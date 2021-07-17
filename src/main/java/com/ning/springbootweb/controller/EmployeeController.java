package com.ning.springbootweb.controller;

import com.ning.springbootweb.dao.DeptDao;
import com.ning.springbootweb.dao.EmpDao;
import com.ning.springbootweb.pojo.Dept;
import com.ning.springbootweb.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Resource
    EmpDao dao;
    @Resource
    DeptDao deptDaodao;
    @RequestMapping("/emps")
    public String emplist(Model model){
        Collection<Emp> selectall = dao.selectall();
        model.addAttribute("emp",selectall);
        return "emp/list";
    }

    @GetMapping("/add")
    public String toAddpage(Model model){
        //查出所有部门
        Collection<Dept> departments = deptDaodao.selectAll();
        model.addAttribute("dept",departments);
        return "emp/adduser";
    }
    @PostMapping("/emp")
    public String Add(Emp employee){

        //添加操作
        dao.save(employee);
        return "redirect:/emps";
    }

}
