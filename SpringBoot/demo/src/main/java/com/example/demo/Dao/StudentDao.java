package com.example.demo.Dao;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

import com.example.demo.Model.PayName;
import com.example.demo.Model.Student;

@Repository
public class StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Boolean insertStudent(Student student) {
		System.out.println("enterDAO");
		System.out.println(student.getSname());
		System.out.println(student.getPassword());
		System.out.println(student.getEmail());
		try {
			jdbcTemplate.update("INSERT INTO student(sname,password,email) VALUES (?,?,?)", student.getSname(),
					student.getPassword(), student.getEmail());
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean login(Student student) {

		try {
			String sql = "select count(*) from STUDENT where sname=? and password=?;";
			int count = jdbcTemplate.queryForObject(sql, Integer.class, student.getSname(), student.getPassword());

			System.out.println("Dao Sname value: " + student.getSname());
			System.out.println("Dao Password value: " + student.getPassword());
			System.out.println("抓到幾筆:" + count);
			return count > 0; // count > 0 如果條件符合 回傳true ,否 則回傳false
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public Student forgetPassword(Student student) {
		try {
			System.out.println("DB student sname: " + student.getSname());
			String sql = "select sname,password,email from student where sname=?;";
			// String sql1 = "select * from student where sname=?;";
			RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
			Student sts = jdbcTemplate.queryForObject(sql, rowMapper, student.getSname());
			return sts;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public Boolean resetPassword(Student newst) {
		String sql = "update student set password = ? where sname = ?;";
		int count;
		count = jdbcTemplate.update(sql, newst.getPassword(), newst.getSname());
		System.out.println(count);
		return (count > 0);
	}

	public Integer updateStudent(Student student) {
		System.out.println();
		try {
			String sql = "update student set sno = ?,sname= ?, sage =? where id = ?;";
			jdbcTemplate.update(sql, student.getSno(), student.getSname(), student.getSage(), student.getId());
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public Boolean deleteStudent(Student student) {
		try {
			String sql = "delete from student where sno = ?;";
			jdbcTemplate.update(sql, student.getSno());
		} catch (Exception e) {
			System.out.print(e);
		}
		return null;

	}

	public Boolean checkName(Student student) {
		String sql = "select count(*) from STUDENT where sname=?;";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, student.getSname());
		return count > 0;
	}

	public Boolean createtable() {
		String createTableSql = "CREATE TABLE temp (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY , username VARCHAR(255), email VARCHAR(255))";
		try {
			jdbcTemplate.execute(createTableSql);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;

	}

	public List<Student> list() {
		String sql1 = "select * from STUDENT order by id DESC";
		RowMapper rowMapper = new StudentRowMapper();
		List<Student> allList = jdbcTemplate.query(sql1, rowMapper);

		return allList;

	}

	public List<Student> list(Student student) {
		Vector<Object> params = new Vector<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select id,sno,sname,payid,(");
		sql.append(" select payname from paymethod ");
		sql.append(" where id = student.payid ) as PAYCNAME");
		sql.append(" from student ");
		sql.append(" where 1=1 ");
		if (student.getSname() != "") {
			sql.append(" and sname like ? ");
			params.add(student.getSname() + "%");
		}
		if (student.getSno() != "") {
			sql.append(" and sno = ? ");
			params.add(student.getSno());
		}
		if (student.getPayid() != 0) {
			sql.append(" and payid = ? ");
			params.add(String.valueOf(student.getPayid()));
			;
		}
		if (student.getPageNum() >= 0) {
			sql.append(" limit ?,? ");
			int PageNum = student.getPageNum();
			int PageSize = student.getPageSize();
			params.add(PageNum);
			params.add(PageSize);
		}

		RowMapper<Student> rowMapper = new StudentRowMapper();

		List<Student> allList = jdbcTemplate.query(sql.toString(), rowMapper, params.toArray());
		return allList;

	}

	public List<PayName> payList() {
		RowMapper<PayName> rowMapper = new PayNameRowMapper();
		String sql = "select * from paymethod";

		List<PayName> payList = jdbcTemplate.query(sql, rowMapper);
		return payList;
	}

}