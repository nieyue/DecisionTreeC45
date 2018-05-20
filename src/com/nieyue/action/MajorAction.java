package com.nieyue.action;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.nieyue.bean.Major;
import com.nieyue.service.MajorService;


/**
 * 专业
 * @author yy
 *
 */
public class MajorAction extends BaseAction<Major,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private MajorService majorService;
	private Major major=new Major();//专业模型

	@Override
	public Major getModel() {
		return major;
	}
	/**
	 * 增加
	 */
	public String add()  {
		major.setUpdateDate(new Date());
		return super.add(major);
	}
	/**
	* 更新
	*/
	public String update()  {
		major.setUpdateDate(new Date());
		return super.update(major);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(major.getMajorId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(major.getMajorId());
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