package com.nieyue.action;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.nieyue.bean.Account;
import com.nieyue.bean.Course;
import com.nieyue.bean.Score;
import com.nieyue.bean.TeacherCourse;
import com.nieyue.c45.DecisionTreeC45Business;
import com.nieyue.service.AccountService;
import com.nieyue.service.AnalyseService;
import com.nieyue.service.CourseService;
import com.nieyue.service.ScoreService;
import com.nieyue.service.TeacherCourseService;
import com.nieyue.util.MyJSON;
import com.nieyue.util.ResultUtil;


/**
 * 成绩
 * @author yy
 *
 */
public class ScoreAction extends BaseAction<Score,Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TeacherCourseService teacherCourseService;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private AnalyseService analyseService;
	@Autowired
	private DecisionTreeC45Business decisionTreeC45Business;
/*	@Autowired
	private DecisionTreeBusiness decisionTreeBusiness;
*/	private Score score=new Score();//成绩模型
	private String identifier;
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	@Override
	public Score getModel() {
		return score;
	}
	/**
	 * 增加
	 */
	public String add()  {
		if(StringUtils.isNotEmpty(identifier)){
			Map<String, Object> eqaccount=new HashMap<>();
			eqaccount.put("identifier", identifier);
			List<Account> al = accountService.list(1, 1, null, null, eqaccount, null, null, null, null, null, null, null);
			Map<String,List<TeacherCourse> > map=new HashMap<>();
			if(al.size()<=0){
				result=ResultUtil.getSlefSRList("50001","没有此学生编号",
						MyJSON.getJSONObject(map));
				return ERROR;
			}else if(al.get(0).getMajorId()==null||al.get(0).getMajorId()==0){
				result=ResultUtil.getSlefSRList("50002","非学生编号错误",
						MyJSON.getJSONObject(map));
				return ERROR;
			}
			score.setStudentAccountId(al.get(0).getAccountId());
		}
		Map<String, Object> eq=new HashMap<>();
		eq.put("studentAccountId", score.getStudentAccountId());
		eq.put("teacherCourseId", score.getTeacherCourseId());
		List<Score> cl=scoreService.list(pageNum, pageSize, orderName, orderWay, eq, null, null, null, null, null, null, null);
		if(cl.size()>0){
			Map<String,List<TeacherCourse> > map=new HashMap<>();
			result=ResultUtil.getSlefSRList("50000","成绩已经存在",
					MyJSON.getJSONObject(map));
			return ERROR;
		}
		score.setUpdateDate(new Date());
		String r=super.add(score);
		//决策树切入点
		if(r.equals(SUCCESS)){
			if(score.getStudentAccountId()!=null
					&&!score.getStudentAccountId().equals(0)
					&&score.getTeacherCourseId()!=null
					&&!score.getTeacherCourseId().equals(0)
					){
				decisionTreeC45Business.studentDecision(score.getTeacherCourseId(), score.getStudentAccountId());
			}
		}
		return r;
	}
	/**
	* 更新
	*/
	public String update()  {
		Score oldScore=scoreService.load(score.getScoreId());
		Map<String, Object> eq=new HashMap<>();
		//如果还是原来的学生和教师课程
		if(oldScore.getStudentAccountId().equals(score.getStudentAccountId())
				&&oldScore.getTeacherCourseId().equals(score.getTeacherCourseId())){
			score.setUpdateDate(new Date());
			String rr=super.update(score);
			//决策树切入点
			if(rr.equals(SUCCESS)){
				if(score.getStudentAccountId()!=null
						&&!score.getStudentAccountId().equals(0)
						&&score.getTeacherCourseId()!=null
						&&!score.getTeacherCourseId().equals(0)
						){
					decisionTreeC45Business.studentDecision(score.getTeacherCourseId(), score.getStudentAccountId());
				}
			}
			return rr;
		}
		if(StringUtils.isNotEmpty(identifier)){
			Map<String, Object> eqaccount=new HashMap<>();
			eqaccount.put("identifier", identifier);
			List<Account> al = accountService.list(1, 1, null, null, eqaccount, null, null, null, null, null, null, null);
			Map<String,List<TeacherCourse> > map=new HashMap<>();
			if(al.size()<=0){
				result=ResultUtil.getSlefSRList("50001","没有此学生编号",
						MyJSON.getJSONObject(map));
				return ERROR;
			}else if(al.get(0).getMajorId()==null||al.get(0).getMajorId()==0){
				result=ResultUtil.getSlefSRList("50002","非学生编号错误",
						MyJSON.getJSONObject(map));
				return ERROR;
			}
			score.setStudentAccountId(al.get(0).getAccountId());
		}
		eq.put("studentAccountId", score.getStudentAccountId());
		eq.put("teacherCourseId", score.getTeacherCourseId());
		List<Score> cl=scoreService.list(pageNum, pageSize, orderName, orderWay, eq, null, null, null, null, null, null, null);
		if(cl.size()>0){
			Map<String,List<TeacherCourse> > map=new HashMap<>();
			result=ResultUtil.getSlefSRList("50000","成绩已经存在",
					MyJSON.getJSONObject(map));
			return ERROR;
		}
		score.setUpdateDate(new Date());
		String r=super.update(score);
		//决策树切入点
		if(r.equals(SUCCESS)){
			if(score.getStudentAccountId()!=null
					&&!score.getStudentAccountId().equals(0)
					&&score.getTeacherCourseId()!=null
					&&!score.getTeacherCourseId().equals(0)
					){
				decisionTreeC45Business.studentDecision(score.getTeacherCourseId(), score.getStudentAccountId());
			}
		}
		return r;
	}
	/**
	 * 删除
	 */
	public String delete()  {
		Score s=scoreService.load(score.getScoreId());
		String r=super.delete(score.getScoreId());
		//决策树切入点
		if(r.equals(SUCCESS)){
			if(score.getStudentAccountId()!=null
					&&!score.getStudentAccountId().equals(0)
					&&score.getTeacherCourseId()!=null
					&&!score.getTeacherCourseId().equals(0)
					){
				decisionTreeC45Business.studentDecision(score.getTeacherCourseId(), score.getStudentAccountId());
			}
		}
		return r;
	}
	/**
	*加载
	*/
	public String load()  {
		return super.load(score.getScoreId());
	}
	/**
	 * 数量
	 */
	public String countAll()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("studentAccountId", score.getStudentAccountId());
		eq.put("teacherCourseId", score.getTeacherCourseId());
		return super.countAll(eq, null, null, null, null, null, null, null);
	}
	/**
	 * 查询
	 */
	public String list()  {
		Map<String, Object> eq=new HashMap<>();
		eq.put("studentAccountId", score.getStudentAccountId());
		eq.put("teacherCourseId", score.getTeacherCourseId());
		return list(super.pageNum, super.pageSize, super.orderName, super.orderWay, eq, null, null, null, null, null, null, null);
	}

	/**
	 * 重写查询
	 */
	@Override
	public String list(int pageNum, int pageSize, String orderName, String orderWay, Map<String, Object> eq,
			Map<String, Object> gt, Map<String, Object> ge, Map<String, Object> lt, Map<String, Object> le,
			Map<String, List<Object>> between, Map<String, Object> like, Map<String, List<Object>> in) {
		Map<String,List<Score> > map=new HashMap<>();
		try {
			List<Score> sl=baseService.list(pageNum, pageSize, orderName, orderWay, eq, gt, ge, lt, le, between, like, in);
			for (int i = 0; i < sl.size(); i++) {
				
				Score s=sl.get(i);
				Map<String, Object> eq1=new HashMap<>();
				eq1.put("teacherCourseId", s.getTeacherCourseId());
				List<TeacherCourse> tcl=teacherCourseService.list(1, 10, null, null, eq1, null, null, null, null, null, null, null);
				for (int j = 0; j < tcl.size(); j++) {
					TeacherCourse tc=tcl.get(j);
					Course c=courseService.load(tc.getCourseId());
					tc.setCourse(c);
					Account a=accountService.load(tc.getTeacherAccountId());
					tc.setTeacherAccount(a);
					s.setTeacherCourse(tc);
				}
				//TeacherCourse ntc=tcl.get(0);
				//s.setTeacherCourse(ntc);
				
				Map<String, Object> eq2=new HashMap<>();
				eq2.put("accountId", s.getStudentAccountId());
				List<Account> al2=accountService.list(1, 10, null, null, eq2, null, null, null, null, null, null, null);
				for (int z = 0; z < al2.size(); z++) {
					Account a=al2.get(z);
					s.setStudentAccount(a);
				}
			}
			map.put("list", sl);
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