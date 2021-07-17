package com.ning.springbootweb.dao;

import com.ning.springbootweb.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeptDao {

    private static Map<Integer, Dept> deptmapmsg=null;

    static {
        deptmapmsg=  new HashMap<Integer,Dept>();
        deptmapmsg.put(101,new Dept(101,"第一部"));
        deptmapmsg.put(102,new Dept(102,"第二部"));
        deptmapmsg.put(103,new Dept(103,"第三部"));
        deptmapmsg.put(104,new Dept(104,"第四部"));
        deptmapmsg.put(105,new Dept(105,"第五部"));
    }


    public Collection<Dept> selectAll() {
        return deptmapmsg.values();
    }

    public Dept selectID(Integer id){
        return deptmapmsg.get(id);
    }


}
