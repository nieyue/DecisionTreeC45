package com.nieyue.action;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.nieyue.bean.Account;
import com.nieyue.bean.Survey;
import com.nieyue.bean.TeacherCourse;
import com.nieyue.service.AccountService;
import com.nieyue.service.SurveyService;
import com.nieyue.service.TeacherCourseService;
import com.nieyue.util.MyJSON;
import com.nieyue.util.ResultUtil;


/**
 * 学习调查表
 * @author yy
 *
 */
public class SurveyAction extends BaseAction<Survey,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SurveyService surveyService;
	@Autowired
	private TeacherCourseService teacherCourseService;
	@Autowired
	private AccountService accountService;
	private Survey survey=new Survey();//学习调查表模型

	@Override
	public Survey getModel() {
		return survey;
	}
	/**
	 * 增加
	 */
	public String add()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("teacherCourseId", survey.getTeacherCourseId());
		eq.put("studentAccountId", survey.getStudentAccountId());
		List<Survey> cl=surveyService.list(pageNum, pageSize, orderName, orderWay, eq, null, null, null, null, null, null, null);
		if(cl.size()>0){
			Map<String,List<Survey> > map=new HashMap<>();
			result=ResultUtil.getSlefSRList("50000","学习调查表已经存在",
					MyJSON.getJSONObject(map));
			return ERROR;
		}
		survey.setUpdateDate(new Date());
		return super.add(survey);
	}
	/**
	* 更新
	*/
	public String update()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("teacherCourseId", survey.getTeacherCourseId());
		eq.put("studentAccountId", survey.getStudentAccountId());
		List<Survey> cl=surveyService.list(pageNum, pageSize, orderName, orderWay, eq, null, null, null, null, null, null, null);
		if(cl.size()>0){
			Map<String,List<Survey> > map=new HashMap<>();
			result=ResultUtil.getSlefSRList("50000","学习调查表已经存在",
					MyJSON.getJSONObject(map));
			return ERROR;
		}
		survey.setUpdateDate(new Date());
		return super.update(survey);
	}
	/**
	 * 删除
	 */
	public String delete()  {
		return super.delete(survey.getSurveyId());
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(survey.getSurveyId());
	}
	/**
	 * 数量
	 */
	public String countAll()  {
		Map<String, Object> eq=new HashMap<>();
		//eq.put("teacherCourseId", survey.getTeacherCourseId());
		eq.put("studentAccountId", survey.getStudentAccountId());
		return super.countAll(eq, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		Map<String, Object> eq=new HashMap<>();
		//eq.put("teacherCourseId", survey.getTeacherCourseId());
		eq.put("studentAccountId", survey.getStudentAccountId());
		return list(super.pageNum, super.pageSize, super.orderName, super.orderWay, eq, null, null, null, null, null, null, null);
	}
	/**
	 * 重写查询
	 */
	@Override
	public String list(int pageNum, int pageSize, String orderName, String orderWay, Map<String, Object> eq,
			Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt, Map<String, Object> le,
			Map<String, List<Object>> between, Map<String, Object> like, Map<String, List<Object>> in) {
		Map<String,List<Survey> > map=new HashMap<>();
		try {
			List<Survey> rl=baseService.list(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
			for (int i = 0; i < rl.size(); i++) {
				Survey s=rl.get(i);
				TeacherCourse tc=teacherCourseService.load(s.getTeacherCourseId());
				s.setTeacherCourse(tc);
				Account a=accountService.load(s.getStudentAccountId());
				s.setStudentAccount(a);
			}
			map.put("list", rl);
			result=ResultUtil.getSlefSRSuccessList(
					MyJSON.getJSONObject(map));
			return SUCCESS;
		} catch (Exception e) {
			result=ResultUtil.getSlefSRFailList(
					MyJSON.getJSONObject(map));
			return ERROR;
		}
	}
	
}