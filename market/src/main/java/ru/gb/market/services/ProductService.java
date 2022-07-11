package ru.gb.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.gb.market.DTO.ProductDto;
import ru.gb.market.exceptions.ResourceNotFoundException;
import ru.gb.market.models.Product;
import ru.gb.market.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> findAll(int id) {
        return productRepository.findAll(PageRequest.of(id, 10));}

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);

    }
    public void save (Product product){
         productRepository.save(product);
    }


    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> findWithParams(Integer min,Integer max,int pageCount){
        Pageable page = PageRequest.of(pageCount - 1, 10);
        if (min == null && max ==null){
            return productRepository.findAll(page);}
        else if (min == null){
            return productRepository.findByPriceBefore(max, page);}
        else if (max == null){
            return productRepository.findByPriceAfter(min,page);}
        else {
            return productRepository.findByPriceBetween(min, max, page);
            }
        }

    @Transactional
    public void updateProductFromDto(ProductDto productDto) {
        Product product = findById(productDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product id = " + productDto.getId() + " not found"));
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
    }




}


