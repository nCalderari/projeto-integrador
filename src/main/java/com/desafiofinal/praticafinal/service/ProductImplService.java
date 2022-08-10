package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.ProductDTO;
import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.model.Product;
import com.desafiofinal.praticafinal.model.Seller;
import com.desafiofinal.praticafinal.repository.IProductRepo;
import com.desafiofinal.praticafinal.repository.ISellerRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductImplService implements IProductService{

    private final IProductRepo repo;
    private final ISellerRepo sellerRepo;

    public ProductImplService(IProductRepo repo, ISellerRepo sellerRepo) {
        this.repo = repo;
        this.sellerRepo = sellerRepo;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO product) {

        var seller = sellerRepo
                .findById(product.getIdSeller())
                .orElseThrow(() -> new ElementNotFoundException("Seller does not exist"));

        Product productSaved = repo.save(buildProduct(product, seller));
        return new ProductDTO(productSaved, seller);
    }

    private Product buildProduct(ProductDTO productDTO, Seller seller){
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
