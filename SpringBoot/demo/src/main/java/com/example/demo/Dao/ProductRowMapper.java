package com.example.demo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Model.Product;

public class ProductRowMapper implements RowMapper {

    @Override

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setPid(rs.getInt("pid"));
        product.setPno(rs.getString("pno"));
        product.setPname(rs.getString("pname"));
        product.setPprice(rs.getInt("pprice"));
        product.setStatus(rs.getInt("status"));
        product.setStatusNC(rs.getString("statusNC"));
        return product;

    }

}
