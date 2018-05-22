package com.nieyue.c45;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nieyue.bean.Analyse;
import com.nieyue.bean.Score;
import com.nieyue.bean.Survey;
import com.nieyue.service.AnalyseService;
import com.nieyue.service.CourseService;
import com.nieyue.service.ScoreService;
import com.nieyue.service.TeacherCourseService;
import com.nieyue.util.Arith;

/**
 * 决策树业务
 * @author 聂跃
 * @date 2018年4月28日
 */
@Component
public class DecisionTreeC45Business  {
	@Autowired
	TeacherCourseService teacherCourseService;
	@Autowired
	ScoreService scoreService;
    /**
     * 学生决策树执行
     * 所有课程，当前人所有成绩
     * @param studentAccountId
     */
	public boolean student(List<Survey> list,Integer studentAccountId){
			boolean canDecision=false;
		  List<String> attribute = new ArrayList<>();
	        attribute.add(0, "课后上机学习时间 （小时）");
	        attribute.add(1, "课前了解");
	        attribute.add(2, "课堂学习");
	        attribute.add(3, "平时成绩");
	        List<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>();
	        for (int i = 0; i < list.size(); i++) {
	        	ArrayList<String> l=new ArrayList<>();
	        	Survey survey = list.get(i);
	        	l.add(survey.getOperateComputerLeaningTime().toString());
	        	l.add(survey.getBeforeClassUnderstand().toString());
	        	l.add(survey.getClassroomLeaning().toString());
	        	l.add(survey.getPeacetimeScore().toString());
	        	Map<String, Object> eq=new HashMap<>();
	        	eq.put("studentAccountId", survey.getStudentAccountId());
	        	//eq.put("teacherCourseId", survey.getTeacherCourseId());
				List<Score> scoreList = scoreService.list(1, Integer.MAX_VALUE, null, null, eq, null, null, null, null, null, null, null);
				Double totalScore=0.0;
	        	Double avgScore=0.0;
				if(scoreList.size()>0){
	        		//有一个大于0结果数据，就可以决策，Analyse
	        		canDecision=true;
	        		for (int j = 0; j < scoreList.size(); j++) {
						Score s = scoreList.get(j);
						totalScore+=s.getScore();
					}
	        		avgScore=Arith.div(totalScore, scoreList.size());
	        		if(avgScore<60.0){
	        			l.add("1");//差
	        		}else if(avgScore>=60.0&&avgScore<80.0){
	        			l.add("2");//一般
	        		}else if(avgScore>=80.0&&avgScore<90.0){
	        			l.add("3");//良
	        		}else if(avgScore>=90.0){
	        			l.add("4");//优秀
	        		}
	        	}
	        	dataset.add(l);
			}
	        Analyse analyse=new Analyse();
	        if(canDecision){
	        	DecisionTree dt = new DecisionTree();  
	        	TreeNode tree = dt.createDecisionTree(attribute, dataset,studentAccountId);  
	        	tree.print("");  
	        }
	        return canDecision;
	} 
}
