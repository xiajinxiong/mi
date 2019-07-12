package com.sure.mi.mapper;

import com.sure.mi.model.Product;

import java.util.List;

public interface ProductMapper {

    Product selectProductByName(String name);
    void insertProduct(Product product);
    void deleteProduct(Product product);
    Long selectIdByName(String name);
}
