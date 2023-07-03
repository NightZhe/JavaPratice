package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dao.StudentDao;
import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    Student Student;

    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentService studentService;

    // 跳轉註冊
    @RequestMapping("/register")
    public String register(Model model) {
        return "register";
    }

    // 跳轉忘記密碼頁面
    @RequestMapping("/forget")
    public String forget(Model model) {
        return "fpd";
    }

    // Ajax帳號驗證
    @RequestMapping("/comfirm")
    @ResponseBody
    public Map<String, Object> checkName(Student student) {
        System.out.println("帳號:" + student.getSname());
        System.out.println("密碼:" + student.getPassword());
        Map<String, Object> map = new HashMap<>();
        if (studentService.checkName(student)) {
            map.put("message", "repeat");
            return map;
        }
        map.put("message", "norepeat");
        return map;
    }

    @RequestMapping("/insert")
    public String insert(Model model, String sname, String password, String email) throws Exception {
        System.out.println(sname);
        System.out.println(password);
        System.out.println(email);
        System.out.println("sfsadsfs");

        Student student = new Student(sname, password, email);

        if (studentService.insertStudent(student)) {
            model.addAttribute("sname", student.getSname());
            model.addAttribute("password", student.getPassword());
            return "information";
        }
        model.addAttribute("message", "註冊失敗，帳號重複，請重新輸入帳號");
        return "register";

    }

    @RequestMapping("/login")
    public String login(Model model, String sname, String password, HttpSession session) {
        session.setAttribute(sname, "valid");
        Object sessionvalue = session.getAttribute(sname);
        System.out.println(sessionvalue);
        System.out.println("---------------");

        System.out.println(sname);
        System.out.println(password);
        Student student = new Student(sname, password);
        if (studentService.login(student)) {
            model.addAttribute("sname", student.getSname());
            model.addAttribute("password", student.getPassword());
            return "information";
        }
        model.addAttribute("message", "帳號密碼錯誤，請重新錯誤");
        return "index";

    }

    @RequestMapping("/forgetPassword")
    public String forgetpassword(Model model, String sname) throws MessagingException {
        System.out.println(sname);
        Student student = new Student(sname);
        System.out.println("student.sname: " + student.getSname());

        if (studentService.forgetPassword(student)) {
            return "show";
        }
        model.addAttribute("message", "帳號不存在");
        return "fpd";
    }

    @RequestMapping("/update")
    public String update() throws Exception {
        Student student = new Student();
        student.setId(1);
        student.setSno("56789");
        student.setSname("小王");
        student.setSage(30);
        studentService.updateStudent(student);
        return "this is update";
    }

    @RequestMapping("/sellect")
    public String selectall(Model model) {
        List<Student> st = new ArrayList<>();
        st = studentService.selectStudent();
        model.addAttribute("StudentList", st);

        return "sellect";
    }

    @RequestMapping("/delete")
    public String delete() throws Exception {
        Student student = new Student();
        student.setSno("444");
        studentService.deleteStudent(student);
        return "this is delete";
    }

    @RequestMapping("/creatTable")
    @ResponseBody
    public String creatTable(Model model, Object data) {

        if (studentService.createTable()) {
            model.addAttribute("message1", "成功創建");

        }
        model.addAttribute("message1", "創建失敗");

        return "index";

    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> getlist(Student student) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Student> list = studentService.list();
        if (list != null) {
            map.put("staus", "200");
            map.put("data", list);
            map.put("message", "success");
            return map;
        } else {
            map.put("staus", "400");
            map.put("mseeage", "error");
        }

        return map;
    }

}
