package com.ning.springbootweb.dao;

import com.ning.springbootweb.pojo.Dept;
import com.ning.springbootweb.pojo.Emp;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmpDao {

    //模拟数据库中的数据
    private static Map<Integer, Emp> employees = null;
    @Resource
    DeptDao deptdao;


    static {
        employees = new HashMap<Integer, Emp>();
        employees.put(1001,new Emp(1001,"name1","name1123@qq.com",0,new Dept(101,"第一部")));
        employees.put(1002,new Emp(1002,"name2","name1223@qq.com",1,new Dept(102,"第二部")));
        employees.put(1003,new Emp(1003,"name3","name1323@qq.com",0,new Dept(103,"第三部")));
        employees.put(1004,new Emp(1004,"name4","name1423@qq.com",1,new Dept(104,"第四部")));
        employees.put(1005,new Emp(1005,"name5","name1523@qq.com",0,new Dept(105,"第五部")));
    }

    private static Integer initId=1006;

    public void save (Emp emp){
        if (emp.getId()==null){
            emp.setId(initId++);
        }

        Dept dept = deptdao.selectID(emp.getDept().getId());
        emp.setDept(dept);
        employees.put(emp.getId(),emp);
    }

    public Collection<Emp> selectall(){
        return employees.values();
    }

    public Emp selectByID(Integer id){
        return employees.get(id);
    }

    public Emp delete(Integer id){
        return employees.remove(id);
    }

}
