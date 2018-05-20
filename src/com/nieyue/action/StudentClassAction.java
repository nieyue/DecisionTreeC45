package com.nieyue.action;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.nieyue.bean.StudentClass;
import com.nieyue.service.StudentClassService;


/**
 * 班级
 * @author yy
 *
 */
public class StudentClassAction extends BaseAction<StudentClass,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentClassService studentClassService;
	private StudentClass studentClass=new StudentClass();//班级模型

	@Override
	public StudentClass getModel() {
		return studentClass;
	}
	/**
	 * 增加
	 */
	public String add()  {
		studentClass.setUpdateDate(new Date());
		return super.add(studentClass);
	}
	/**
	* 更新
	*/
	public String update()  {
		studentClass.setUpdateDate(new Date());
		return super.update(studentClass);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(studentClass.getStudentClassId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(studentClass.getStudentClassId());
	}
	/**
	 * 数量
	 */
	public String countAll()  {
		return super.countAll(null, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		return super.list(super.pageNum, super.pageSize, super.orderName, super.orderWay, null, null, null, null, null, null, null, null);
	}

	
}