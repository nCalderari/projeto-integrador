package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.requestResponseDto.ProductDTO;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import com.desafiofinal.praticafinal.model.BatchStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafiofinal.praticafinal.dto.requestResponseDto.ProductResponseDTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ProductsImpService {

    @Autowired
    private IProductRepo productRepo;

    @Autowired
    private InBoundOrderRepo inBoundOrderRepo;

    public List<ProductDTO> listAllProducts (){

        List<ProductDTO> productList= new ArrayList<>();

        List<Product> foundListProduct = productRepo.findAll();

        for(Product product:foundListProduct){

            ProductDTO productDto = new ProductDTO(product);

            productList.add(productDto);
        }

        return productList;

    }


    public List<ProductResponseDTO> listProductsByCategory (String category) throws Exception{

        List<InBoundOrder> listInBoundOrder = inBoundOrderRepo.findAll(); //TODO no final refatorar esse método

        List<ProductResponseDTO> productListByCategory= new ArrayList<>();

        for (InBoundOrder inBoundOrder: listInBoundOrder){
            String foundCategory = inBoundOrder.getSector().getCategory();

            if(foundCategory.equals(category)){
                for (BatchStock batchStock: inBoundOrder.getBatchStockList()){
                    Product foundProduct =  batchStock.getProduct();

                    ProductResponseDTO productResponseDto = new ProductResponseDTO(foundProduct);

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
