// package com.example.demo.Dao;

// import java.util.List;

// import org.springframework.data.jdbc.repository.query.Modifying;
// import org.springframework.data.jdbc.repository.query.Query;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.Model.Product;

// @Repository("productRepository")
// public interface ProductRepository extends JpaRepository<Product, String> {

// @Modifying
// @Query(" select "
// + " pid, "
// + " pno, "
// + " pname, "
// + " pprice, "
// + " status, "
// + " statusNC "
// + " From product"
// + " where pno = :pno ")
// List<Product> selectSomeoneProduct(String pno);

// }
