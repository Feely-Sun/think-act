package com.iacthink.service;

import com.iacthink.dal.daointerface.StudentDAO;
import com.iacthink.dal.dataobject.StudentDO;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author sunzihan
 * @version $Id: S.java V 0.1 10/10/16 20:34 sunzihan EXP $
 */
public class STest {



    private StudentDAO studentDAO;

    private int count = 1;


    private TransactionTemplate transactionTemplate;

   // @Transactional(propagation = Propagation.NESTED,readOnly=false)
    public void insertStudent(final StudentDO studentDO){

            transactionTemplate.execute(new TransactionCallback<Boolean>() {

                public Boolean doInTransaction(TransactionStatus transactionStatus) {
                    studentDAO.insert(studentDO);
                    return null;
                }
            });

//            if (count == 4){
//                System.out.println("异常回滚");
//                throw new RuntimeException("ROLLBACK");
//            }

        count ++ ;

    }


    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
}

