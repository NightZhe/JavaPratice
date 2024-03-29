package com.example.demo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.example.demo.Model.Student;

public class ConcatRowMapper implements RowMapper {

    @Override
    @Nullable
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student st = new Student();
        st.setId(rs.getInt("id"));
        st.setSno(rs.getString("sno"));
        st.setSname(rs.getString("sname"));
        st.setSage(rs.getInt("sage"));
        st.setPayid(rs.getInt("payid"));
        return st;

    }
}
