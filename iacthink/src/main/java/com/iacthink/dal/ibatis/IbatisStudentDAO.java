/*
 * Alipay.com Inc.
 * Copyright (c) 2004 - 2010 All Rights Reserved.
 * Powered By [rapid-generator]
 */
 
package com.iacthink.dal.ibatis;


import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.iacthink.dal.daointerface.StudentDAO;
import com.iacthink.dal.dataobject.StudentDO;

/**
 * StudentDAO
 * database table: student
 * database table comments: Student
 * This file is generated by <tt>dalgen</tt>, a DAL (Data Access Layer)
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/dalgen</tt>
 * @author badqiu(zhongxuan)
 *
 
 */
public class IbatisStudentDAO extends SqlMapClientDaoSupport implements StudentDAO {


	/**
	 * 
	 * sql: 
	 * <pre>SELECT         id, s_no, s_name,s_age           FROM         student</pre>
	 */
	public List<StudentDO> queryAll() throws DataAccessException {
		return (List<StudentDO>)getSqlMapClientTemplate().queryForList("iacthink.Student.queryAll",null);
	}

	/**
	 * 
	 * sql: 
	 * <pre>insert      into         student         (id,s_no,s_name,s_age)     values         (?,?,?,?)</pre>
	 */
	public int insert(StudentDO student) throws DataAccessException {
		if(student == null) {
			throw new IllegalArgumentException("Can't insert a null data object into db.");
		}
		getSqlMapClientTemplate().insert("iacthink.Student.insert", student);
		return student.getId();
	}

}

