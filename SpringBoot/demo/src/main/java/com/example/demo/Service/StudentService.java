package com.example.demo.Service;

import java.util.List;

import javax.mail.MessagingException;

import org.apache.ibatis.ognl.BooleanExpression;

import com.example.demo.Model.ListDate;
import com.example.demo.Model.PayName;
import com.example.demo.Model.Student;

public interface StudentService {

    public Boolean insertStudent(Student student);

    public List<Student> selectStudent(); // 查詢學生資料

    public Integer updateStudent(Student student); // 修改學生資料

    public Boolean deleteStudent(Student student); // 修改學生資料

    public Boolean checkName(Student student);// 確認是否有帳號

    public Boolean login(Student student);// 登入驗證;

    public boolean forgetPassword(Student student) throws MessagingException; // 更新密碼 & 寄信

    public Boolean createTable(); // 創建資料庫表格

    public List<Student> allList();// 查詢學生全部的list;

    public List<Student> list(Student student); // 有條件查詢

    public List<PayName> payList();// 付款方式List

    public Boolean saveOption(List<ListDate> dateArray);

    public Boolean upadteAccountStatus(int id, String sname, String status); // 修改學生帳號停用啟用

    public List<Student> searchNameProcedure(String sname);

}
