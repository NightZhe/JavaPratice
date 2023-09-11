package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Product;

@Repository
public class ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> allList() {
        RowMapper<Product> productListRowMapper = new ProductRowMapper();
        StringBuffer sql = new StringBuffer();
        sql.append(" select pid,pno,pname,pprice,status,(");
        sql.append(" select statusNA from product_Status");
        sql.append(" where status = product.status) as statusNC");
        sql.append(" from product");
        List<Product> productList = jdbcTemplate.query(sql.toString(), productListRowMapper);
        return productList;

    }

    public Boolean changeStatus(Product product) {
        try {
            String sql = "update product set status = ? where pid =?;";
            jdbcTemplate.update(sql, product.getStatus(), product.getPid());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("sql語法錯誤，可能沒找到id  or status");
            return false;
        }

    }
}
