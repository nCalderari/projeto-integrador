package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDto;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import com.desafiofinal.praticafinal.repository.ProductRepo;
import com.desafiofinal.praticafinal.model.BatchStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafiofinal.praticafinal.requestResponseDto.ProductResponseDto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ProductsImpService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private InBoundOrderRepo inBoundOrderRepo;

    public List<ProductDto> listAllProducts (){

        List<ProductDto> productList= new ArrayList<>();

        List<Product> foundListProduct = productRepo.findAll();

        for(Product product:foundListProduct){

            ProductDto productDto = new ProductDto(product);

            productList.add(productDto);
        }

        return productList;

    }


    public List<ProductResponseDto> listProductsByCategory (String category) throws Exception{

        List<InBoundOrder> listInBoundOrder = inBoundOrderRepo.findAll(); //TODO no final refatorar esse método

        List<ProductResponseDto> productListByCategory= new ArrayList<>();

        for (InBoundOrder inBoundOrder: listInBoundOrder){
            String foundCategory = inBoundOrder.getSector().getCategory();

            if(foundCategory.equals(category)){
                for (BatchStock batchStock: inBoundOrder.getBatchStockList()){
                    Product foundProduct =  batchStock.getProduct();

                    ProductResponseDto productResponseDto = new ProductResponseDto(foundProduct);

                   // LocalDate convertToLocalDate = convertToLocalDateViaInstant(productResponseDto.getValidateDate());

                    LocalDate minusDays = productResponseDto.getValidateDate().minusDays(21);

                    if (!productListByCategory.contains(productResponseDto)){
                        if(LocalDate.now().isBefore(minusDays)){
                            productListByCategory.add(productResponseDto); //TODO alterar os atributos de LocalDate para Date
                        }
                    }
                }
            }
        }

        if(productListByCategory.isEmpty()){
            throw new Exception("Nenhum produto foi encontrado para essa categoria");
        }else {
            return productListByCategory;
        }

    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
