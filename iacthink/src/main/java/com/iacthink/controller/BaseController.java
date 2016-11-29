package com.iacthink.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iacthink.dal.dataobject.StudentDO;
import com.iacthink.service.STest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunzihan
 * @version $Id: BaseController.java V 0.1 10/10/16 18:11 sunzihan EXP $
 */

@Controller
public class BaseController {


    @Resource
    private  STest sTest;



    @Resource
    private TransactionTemplate transactionTemplate;



    //@Transactional (propagation = Propagation.REQUIRED,readOnly=false,rollbackFor = {Throwable.class})
    @RequestMapping(value = "/base/test.htm",method = RequestMethod.GET)
    public String test(ModelMap modelMap){


        try {

           final List<StudentDO> studentDOList = new ArrayList<StudentDO>();

            for (int i = 0 ; i < 5 ; i ++){

                StudentDO studentDO = new StudentDO();

                studentDO.setSage(20+i);
                studentDO.setSname("wangwu"+i);
                studentDO.setSno("2016011299"+i);

                studentDOList.add(studentDO);
            }

            transactionTemplate.setReadOnly(false);
            try {
                transactionTemplate.execute(new TransactionCallback<Boolean>() {

                    public Boolean doInTransaction(TransactionStatus status) {
                        for(StudentDO s : studentDOList){
                            sTest.insertStudent(s);
                        }
                        return null;
                    }
                });
            }catch (Exception ex){
                ex.printStackTrace();

            }






            modelMap.put("message", "finish");
        } catch (Exception ex) {
            modelMap.put("message", ex.getCause());
        }

        return "hello";
    }

}

