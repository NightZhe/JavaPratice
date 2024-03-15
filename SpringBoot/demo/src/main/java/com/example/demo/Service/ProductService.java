package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Product;

public interface ProductService {

    public List<Product> allList(); // 查詢全部產品資料

    public Boolean changestatus(Product product); // 改變訂單狀態

    // public List<Product> getStreamList(Product pd);

}
