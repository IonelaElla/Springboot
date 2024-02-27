package net.javaguides.springboot.service;

import net.javaguides.springboot.exception.ResourcesNotFoundException;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ProductServicesImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
    return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productDb = this.productRepository.findById(product.getId());

        if(productDb.isPresent())
        {
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productRepository.save(productUpdate);
            return  productUpdate;
        }else {
            throw new ResourcesNotFoundException("Record not found whith id:"+ product.getId());
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        Optional<Product> productDb = this.productRepository.findById(productId);

        if(productDb.isPresent()){
return productDb.get();
        }else{    throw new ResourcesNotFoundException("Record not found whith id:"+ productId);


        }
    }

    @Override
    public void deleteProduct(long productId){
    Optional<Product> productDb = this.productRepository.findById(productId);

        if(productDb.isPresent()){
        this.productRepository.delete(productDb.get());
    }else{    throw new ResourcesNotFoundException("Record not found whith id:"+ productId);


    }
}

}