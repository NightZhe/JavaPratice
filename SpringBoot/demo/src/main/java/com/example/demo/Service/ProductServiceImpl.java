package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.ProductDao;

import com.example.demo.Model.Product;

import jakarta.transaction.Transactional;

@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    // @Autowired
    // private ProductRepository productRepository;

    @Autowired
    Product product;

    @Override
    public List<Product> allList() {
        List productlist = productDao.allList();
        for (int i = 0; i < productlist.size(); i++) {
            Object elemets = productlist.get(i);
            Product pd = (Product) elemets;
            if (pd.getStatus() == 0) {
                pd.setStatusNC("建制中改");
            }
        }

        return productlist;
    }

    @Override
    public Boolean changestatus(Product product) {
        if (productDao.changeStatus(product)) {
            return true;
        }
        return false;
    }

    // @Override
    // @Transactional
    // public List<Product> getStreamList(Product pd) {
    // List productList = productRepository.selectSomeoneProduct(pd.getPno());

    // return productList;

    // }
}
