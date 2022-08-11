package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTOWithSeller;
import com.desafiofinal.praticafinal.dto.requestResponseDto.BatchStockResponseDto;
import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.model.BatchStock;
import com.desafiofinal.praticafinal.model.InBoundOrder;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.ISellerRepo;
import com.desafiofinal.praticafinal.repository.InBoundOrderRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImplService implements IProductService{

    private final IProductRepo repo;
    private final ISellerRepo sellerRepo;
    private InBoundOrderRepo inBoundOrderRepo;


    public ProductImplService(IProductRepo repo, ISellerRepo sellerRepo, InBoundOrderRepo inBoundOrderRepo) {
        this.repo = repo;
        this.sellerRepo = sellerRepo;
        this.inBoundOrderRepo = inBoundOrderRepo;
    }

    @Override
    public ProductDTOWithSeller saveProduct(ProductDTOWithSeller product) {

        var seller = sellerRepo
                .findById(product.getIdSeller())
                .orElseThrow(() -> new ElementNotFoundException("Seller does not exist"));

        Product productSaved = repo.save(buildProduct(product, seller));
        return new ProductDTOWithSeller(productSaved, seller);
    }

    public List<ProductDTO> listAllProducts (){

        List<ProductDTO> productList= new ArrayList<>();

        List<Product> foundListProduct = repo.findAll();

        for(Product product:foundListProduct){

            ProductDTO productDto = new ProductDTO(product);

            productList.add(productDto);
        }

        return productList;

    }


    public List<BatchStockResponseDto> listBatchStockByCategory (String category) throws Exception{

        List<InBoundOrder> listInBoundOrder = inBoundOrderRepo.findAll(); //TODO no final refatorar esse método

        List<BatchStockResponseDto> batchListByCategory = new ArrayList<>();

        for (InBoundOrder inBoundOrder: listInBoundOrder){
            String foundCategory = inBoundOrder.getSector().getCategory();

            if(foundCategory.equalsIgnoreCase(category)){
                for (BatchStock batchStock: inBoundOrder.getBatchStockList()){

                    BatchStockResponseDto batchResponseDto = new BatchStockResponseDto(batchStock);

                    LocalDate minusDays2 = batchStock.getDueDate().minusDays(21);

                    if(LocalDate.now().isBefore(minusDays2)){

                        batchListByCategory.add(batchResponseDto);
                        // }
                    }
                }
            }
        }

        if(batchListByCategory.isEmpty()){
            throw new Exception("Nenhum produto foi encontrado para essa categoria");
        }else {
            return batchListByCategory;
        }

    }

    private Product buildProduct(ProductDTOWithSeller productDTO, Seller seller){
        return Product.builder()
                .productType(productDTO.getProductType())
                .productName(productDTO.getProductName())
                .validateDate(productDTO.getValidateDate())
                .price(productDTO.getPrice())
                .bulk(productDTO.getBulk())
                .seller(seller)
                .build();
    }
}
