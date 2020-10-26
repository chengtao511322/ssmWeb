package com.ct.service;

import com.ct.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品的业务层接口
 */
@Service
public interface ProductService {

    /**
     * 查询所有产品信息
     * @return
     */
    List<Product> findAllProduct();

    /**
     * 添加产品信息
     * @param product
     */
    void save(Product product);
}
