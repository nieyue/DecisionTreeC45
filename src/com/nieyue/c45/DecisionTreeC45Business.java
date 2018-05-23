package com.nieyue.c45;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nieyue.bean.Analyse;
import com.nieyue.bean.Score;
import com.nieyue.bean.Survey;
import com.nieyue.service.AnalyseService;
import com.nieyue.service.ScoreService;
import com.nieyue.service.SurveyService;
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
	@Autowired
	SurveyService surveyService;
	@Autowired
	AnalyseService analyseService;
	//存放决策树属性名称
	List<String> attribute ;
	//存放决策树数据集
	 List<ArrayList<String>> dataset;
	 //总分
	 Double commonTotalScore=0.0;
	 //平均分
 	Double commonAvgScore=0.0;
	 /**
	  * 获取课后上机学习时间 （小时）
	  * @return
	  */
	 public String  getOperateComputerLeaningTimeStr(Integer operateComputerLeaningTime){
		 String operateComputerLeaningTimeStr="<5";
     	if(operateComputerLeaningTime==1){
     		operateComputerLeaningTimeStr="<5";
     	}else if(operateComputerLeaningTime==2){
     		operateComputerLeaningTimeStr="5-10";
     	}else if(operateComputerLeaningTime==3){
     		operateComputerLeaningTimeStr=">10";
     	}
     	return operateComputerLeaningTimeStr;
	 }
	 /**
	  * 获取课前了解
	  * @return
	  */
	 public String  getBeforeClassUnderstandStr(Integer beforeClassUnderstand){
		 String beforeClassUnderstandStr="不了解";
     	if(beforeClassUnderstand==1){
     		beforeClassUnderstandStr="不了解";
     	}else if(beforeClassUnderstand==2){
     		beforeClassUnderstandStr="了解一点";
     	}else if(beforeClassUnderstand==3){
     		beforeClassUnderstandStr="基本了解";
     	}
     	return beforeClassUnderstandStr;
	 }
	 /**
	  * 获取课堂学习
	  * @return
	  */
	 public String  getClassroomLeaningStr(Integer classroomLeaning){
		 String classroomLeaningStr="差";
     	if(classroomLeaning==1){
     		classroomLeaningStr="差";
     	}else if(classroomLeaning==2){
     		classroomLeaningStr="一般";
     	}else if(classroomLeaning==3){
     		classroomLeaningStr="良";
     	}else if(classroomLeaning==4){
     		classroomLeaningStr="优";
     	}
     	return classroomLeaningStr;
	 }
	 /**
	  * 获取平时成绩
	  * @return
	  */
	 public String  getPeacetimeScoreStr(Integer peacetimeScore){
		 String peacetimeScoreStr="差";
     	if( peacetimeScore==1){
     		peacetimeScoreStr="差";
     	}else if( peacetimeScore==2){
     		peacetimeScoreStr="一般";
     	}else if( peacetimeScore==3){
     		peacetimeScoreStr="良";
     	}else if( peacetimeScore==4){
     		peacetimeScoreStr="优";
     	}
		 return peacetimeScoreStr;
	 }
	 /**
	  * 获取考试成绩
	  * @param beforeClassUnderstand
	  * @return
	  */
	 public String  getSubType(Integer subType){
		 String subTypeStr="差";
		 if( subType==1){
			 subTypeStr="差";
		 }else if( subType==2){
			 subTypeStr="一般";
		 }else if( subType==3){
			 subTypeStr="良";
		 }else if( subType==4){
			 subTypeStr="优";
		 }
		 return subTypeStr;
	 }
	 /**
	  * 获取分析建议
	  * @param subType 考试成绩结果
	  * @param selfScore 自身成绩
	  * @param avgScore 该课程的平均成绩
	  * @param bestAttribute 最好的属性
	  * @return
	  */
	 public String  getConclusion(Integer subType,Double selfScore,Double avgScore,String bestAttribute){
		String conclusion="";
		String subTypeStr = getSubType(subType);
		conclusion+="您的教师课程成绩的平均分为："+avgScore+",您的自身成绩为："+selfScore+"。\n";
		if(StringUtils.isEmpty(bestAttribute)){
			conclusion+="本次成绩分析中，由于数据过少，所以没有影响因素！\n";			
		}else{
			conclusion+="本次成绩分析中，影响您成绩的主要因素为："+bestAttribute+"！\n";			
		}
		if(subType==1){
			conclusion+="综合评定，您本次的成绩评定为："+subTypeStr+",不要灰心，请改变学习方法！\n";
		}else if(subType==2){
			conclusion+="综合评定，您本次的成绩评定为："+subTypeStr+",请下次再接再厉，继续保持！\n";
		}else if(subType==3){
			conclusion+="综合评定，您本次的成绩评定为："+subTypeStr+",请下次继续努力，冲进优秀！\n";
		}else if(subType==4){
			conclusion+="综合评定，您本次的成绩评定为："+subTypeStr+",请下次继续加油，保持！\n";
		}
		 return conclusion;
	 }
    /**
     * 初始化数据
     */
	public boolean initData(List<Survey> list){
			//判断是否能决策
		  	boolean canDecision=false;
		  	if(list.size()<=0){
		  		return canDecision;
		  	}
		  	attribute = new ArrayList<>();
		  	dataset = new ArrayList<ArrayList<String>>();
		  	//属性名称
	        attribute.add(0, "课后上机学习时间 （小时）");
	        attribute.add(1, "课前了解");
	        attribute.add(2, "课堂学习");
	        attribute.add(3, "平时成绩");
	        commonTotalScore=0.0;
	        commonAvgScore=0.0;
	        int number=0;
	        //初始化当前老师课程下的当前学生的数据
	        for (int i = 0; i < list.size(); i++) {
	        	ArrayList<String> l=new ArrayList<>();
	        	Survey survey = list.get(i);
	        	l.add(getOperateComputerLeaningTimeStr(survey.getOperateComputerLeaningTime()));
	        	l.add(getBeforeClassUnderstandStr(survey.getBeforeClassUnderstand()));
	        	l.add(getClassroomLeaningStr(survey.getClassroomLeaning()));
	        	l.add(getPeacetimeScoreStr(survey.getPeacetimeScore()));
	        	//初始化当前老师课程下的当前学生的数据的结果
	        	Map<String, Object> eq=new HashMap<>();
	        	eq.put("studentAccountId", survey.getStudentAccountId());
	        	eq.put("teacherCourseId", survey.getTeacherCourseId());
	        	List<Score> scoreList = scoreService.list(1, Integer.MAX_VALUE, null, null, eq, null, null, null, null, null, null, null);
	        	//总分
	       	 	Double totalScore=0.0;
	       	 	//平均分
	        	Double avgScore=0.0;
				if(scoreList.size()>0){
	        		//有一个大于0结果数据，就可以决策，Analyse
	        		canDecision=true;
	        		for (int j = 0; j < scoreList.size(); j++) {
						Score s = scoreList.get(j);
						totalScore+=s.getScore();
						commonTotalScore+=s.getScore();
						number++;
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
	        commonAvgScore=Arith.div(commonTotalScore, number);
	       
	        return canDecision;
	} 
	  /**
     * 学生决策树执行
     * 当前教师课程的成绩维度，学生的决策树
     * @param teacherCourseId 教师课程id
     * @param studentAccountId 学生id
     */
	public boolean studentDecision(Integer teacherCourseId,Integer studentAccountId){
		Map<String, Object> surveyeq=new HashMap<>();
		surveyeq.put("teacherCourseId", teacherCourseId);
		List<Survey> list = surveyService.list(1, Integer.MAX_VALUE, null, null, surveyeq, null, null, null, null, null, null, null);
		 boolean canDecision = initData(list);
	        if(canDecision){
	        	DecisionTree dt = new DecisionTree();  
	        	TreeNode tree = dt.createDecisionTree(attribute, dataset);  
	        	Map<String, Object> selfeq=new HashMap<>();
	        	selfeq.put("studentAccountId", studentAccountId);
	        	selfeq.put("teacherCourseId", list.get(0).getTeacherCourseId());
	        	List<Survey> selfSurveyList = surveyService.list(1, Integer.MAX_VALUE, null, null, selfeq, null, null, null, null, null, null, null);
	        	Map<String,String> map=new HashMap<>();
	        	for (int i = 0; i < selfSurveyList.size(); i++) {
	        		Survey s = selfSurveyList.get(i);
					map.put("课后上机学习时间 （小时）",getOperateComputerLeaningTimeStr(s.getOperateComputerLeaningTime()));
					map.put("课前了解",getBeforeClassUnderstandStr(s.getBeforeClassUnderstand()));
					map.put("课堂学习",getClassroomLeaningStr(s.getClassroomLeaning()));
					map.put("平时成绩",getPeacetimeScoreStr(s.getPeacetimeScore()));
				}
	        	String result="";
	        	result=tree.studentPrint(result, "", map);
	        	if(StringUtils.isEmpty(result)){
	        		return false;
	        	}
	        	List<Score> scoreList = scoreService.list(1, Integer.MAX_VALUE,null, null, selfeq, null, null, null, null, null, null, null);
	        	if(scoreList.size()<=0){
	        		return false;
	        	}
	        	Map<String, Object> analyseeq=new HashMap<>();
	        	analyseeq.put("businessId", scoreList.get(0).getScoreId());
	        	List<Analyse> al = analyseService.list(1, Integer.MAX_VALUE, null, null, analyseeq, null, null, null, null, null, null, null);
	        	if(al.size()>0){
	        		Analyse analyse = al.get(0);
	        		analyse.setType(1);
	        		analyse.setSubType(new Integer(result));
	        		analyse.setScore(commonAvgScore);
	        		analyse.setUpdateDate(new Date());
	        		analyse.setBusinessId(scoreList.get(0).getScoreId());
	        		analyse.setConclusion(getConclusion(new Integer(result), scoreList.get(0).getScore(), commonAvgScore, tree.getAttribute()));
	        		analyseService.update(analyse);
	        	}else{
	        		Analyse analyse=new Analyse();
	        		analyse.setType(1);
	        		analyse.setSubType(new Integer(result));
	        		analyse.setScore(commonAvgScore);
	        		analyse.setUpdateDate(new Date());
	        		analyse.setBusinessId(scoreList.get(0).getScoreId());
	        		analyse.setConclusion(getConclusion(new Integer(result), scoreList.get(0).getScore(), commonAvgScore, tree.getAttribute()));
	        		analyseService.add(analyse);
	        	}
	        }
	        return canDecision;
	}
}
