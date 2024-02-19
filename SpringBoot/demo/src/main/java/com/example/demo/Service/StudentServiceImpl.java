package com.example.demo.Service;

import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import com.example.demo.Dao.StudentDao;
import com.example.demo.Model.JavaMail;
import com.example.demo.Model.ListDate;
import com.example.demo.Model.PayName;
import com.example.demo.Model.Student;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Boolean insertStudent(Student student) {
        if (studentDao.checkName(student)) {
            return false;
        }
        String md5Psd = DigestUtils.md5DigestAsHex(student.getPassword().getBytes());
        Student newStudent = new Student(student.getSname(), md5Psd, student.getEmail());
        return studentDao.insertStudent(newStudent);
    }

    @Override
    public List<Student> selectStudent() {
        return null;
    }

    @Override
    public Integer updateStudent(Student student) {
        studentDao.updateStudent(student);
        return 1;
    }

    @Override
    public Boolean deleteStudent(Student studen) {
        studentDao.deleteStudent(studen);
        return true;
    }

    @Override
    public Boolean checkName(Student student) {

        return studentDao.checkName(student);
    }

    @Override
    public Boolean login(Student student) {
        String md5Psd = DigestUtils.md5DigestAsHex(student.getPassword().getBytes());
        Student newStudent = new Student(student.getSname(), md5Psd);
        System.out.println(newStudent.getSname());
        return studentDao.login(newStudent);
    }

    @Override
    public boolean forgetPassword(Student student) throws MessagingException {
        System.out.println(student.getSname());
        Student stuts = new Student();
        stuts = studentDao.forgetPassword(student);
        if (stuts == null) {
            return false;
        }
        System.out.println(stuts.getSname());
        System.out.println(stuts.getPassword());
        System.out.println(stuts.getEmail());

        int i = 0;
        i = (int) (Math.random() * 100000) + 1000;
        String numberString = Integer.toString(i);
        System.out.println(numberString);
        String newMd5Pwd = DigestUtils.md5DigestAsHex(numberString.getBytes());
        System.out.println(newMd5Pwd);

        Student newst = new Student(stuts.getSname(), newMd5Pwd, student.getEmail());

        if (studentDao.resetPassword(newst)) {
            JavaMail javaMail = new JavaMail();
            String txt = "給您的密碼:" + numberString;
            javaMail.SendMail(stuts.getEmail(), txt);
            return true;
        }
        return false;
    }

    @Override
    public Boolean createTable() {
        return studentDao.createtable();
    }

    @Override
    public List<Student> allList() {
        List concatList = studentDao.allList();
        for (int i = 0; i < concatList.size(); i++) {
            Object elemnets = concatList.get(i);
            Student st = (Student) elemnets;
            if (st.getSage() != 0) {
                st.setSname(st.getSname().concat(";").concat(Integer.toString(st.getSage())));

            }
            System.out.println(concatList.get(i));
        }

        return concatList;
    }

    @Override
    public List<Student> list(Student student) {
        return studentDao.list(student);
    }

    @Override
    public List<PayName> payList() {
        return studentDao.payList();
    }

    @Override
    public Boolean saveOption(List<ListDate> dateArray) {
        // for (ListDate list : dateArray) {
        // System.out.println("ID:" + list.getId() + "," + "selecOption:" +
        // list.getSelectOption());
        // }
        return studentDao.batchUpdate(dateArray);

    }

    @Override
    public Boolean upadteAccountStatus(int id, String sname, String status) {
        if (status.equals("停用")) {
            status = "啟用";
            Boolean resutl = studentDao.upadteAccountStatus(id, status);
            return resutl;
        } else if (status.equals("啟用")) {
            status = "停用";
            Boolean result = studentDao.upadteAccountStatus(id, status);
            return result;
        }
        return null;

    }

    public List<Student> searchNameProcedure(String Sname) {
        return (studentDao.searchNameProcedure(Sname));
    }
}
