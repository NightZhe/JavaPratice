package com.example.demo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import com.example.demo.Model.PayName;

public class PayNameRowMapper implements RowMapper {

    @Override
    @Nullable
    public PayName mapRow(ResultSet rs, int rowNum) throws SQLException {
        PayName pn = new PayName();
        pn.setId(rs.getInt("id"));
        pn.setPayname(rs.getString("payname"));

        return pn;

    }

}
