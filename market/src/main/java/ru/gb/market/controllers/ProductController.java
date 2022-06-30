package ru.gb.market.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.DTO.ProductDto;
import ru.gb.market.models.Product;
import ru.gb.market.services.ProductService;

@RestController
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
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id).get());
    }

    @PostMapping("products")
    public ProductDto save(@RequestBody Product product) {
        return new ProductDto(productService.save(product));
    }

    @GetMapping("products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


}