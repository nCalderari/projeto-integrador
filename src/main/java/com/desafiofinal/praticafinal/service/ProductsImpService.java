package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.modelDto.ProductDto;
import com.desafiofinal.praticafinal.modelEntity.InBoundOrder;

import com.desafiofinal.praticafinal.modelEntity.Sector;
import com.desafiofinal.praticafinal.modelRequestResponseDto.InBoundOrderRequestDto;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import com.desafiofinal.praticafinal.repository.ProductRepo;
import com.desafiofinal.praticafinal.modelEntity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafiofinal.praticafinal.modelRequestResponseDto.ProductResponseDto;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;

import java.util.ArrayList;
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

                    LocalDate convertToLocalDate = convertToLocalDateViaInstant(productResponseDto.getValidateDate());

                    LocalDate minusDays = convertToLocalDate.minusDays(21);

                    if (!productListByCategory.contains(productResponseDto)){
                        if(minusDays.isBefore(LocalDate.now())){
                            productListByCategory.add(productResponseDto);
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
