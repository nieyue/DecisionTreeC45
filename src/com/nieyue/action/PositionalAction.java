package com.nieyue.action;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.nieyue.bean.Positional;
import com.nieyue.service.PositionalService;


/**
 * 职称
 * @author yy
 *
 */
public class PositionalAction extends BaseAction<Positional,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private PositionalService positionalService;
	private Positional positional=new Positional();//专业模型

	@Override
	public Positional getModel() {
		return positional;
	}
	/**
	 * 增加
	 */
	public String add()  {
		positional.setUpdateDate(new Date());
		return super.add(positional);
	}
	/**
	* 更新
	*/
	public String update()  {
		positional.setUpdateDate(new Date());
		return super.update(positional);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(positional.getPositionalId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(positional.getPositionalId());
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