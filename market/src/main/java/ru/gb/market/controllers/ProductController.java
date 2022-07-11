package ru.gb.market.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.DTO.ProductDto;
import ru.gb.market.exceptions.ResourceNotFoundException;
import ru.gb.market.exceptions.ValidationDataException;
import ru.gb.market.models.Product;
import ru.gb.market.services.ProductService;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping("/products")
    public Page<ProductDto> findAll(@RequestParam(required = false) Integer min, @RequestParam(required = false) Integer max, @RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        System.out.println(pageIndex);
        if (pageIndex < 1) {
            pageIndex = 1;
        }

        return productService.findWithParams(min, max, pageIndex).map(ProductDto::new);
    }

    @GetMapping("/products/{id}")
    public  ProductDto findById(@PathVariable long id){
        return new ProductDto(productService.findById(id)
                   .orElseThrow(()-> new ResourceNotFoundException("Product id = " + id + " not found")));
    }


    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Validated ProductDto productDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new ValidationDataException(
                    bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList())
            );
        }
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        productService.save(product);
    }




    @PutMapping("/products")
    public void update(@RequestBody @Validated ProductDto productDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new ValidationDataException(
                    bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList())
            );
        }
        productService.updateProductFromDto(productDto);
    }


    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


}