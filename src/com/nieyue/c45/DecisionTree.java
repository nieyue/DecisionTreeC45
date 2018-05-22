package com.nieyue.c45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nieyue.bean.Analyse;
import com.nieyue.service.AnalyseService;
@Component
public class DecisionTree {  
    @Autowired
    AnalyseService analyseService;
    InfoGainRatio infoGainRatio = new InfoGainRatio();  
    /**
     * 建立决策树  
     * @param attribute
     * @param dataset
     * @return
     */
    public TreeNode createDecisionTree(List<String> attribute, List<ArrayList<String>> dataset) {  
    	TreeNode tree = new TreeNode();  
          
        //检查是否单一的
        if(DataSetUtil.isPure(DataSetUtil.getTarget(dataset))) {  
            tree.setLeaf(true);  
            tree.setTargetValue(DataSetUtil.getTarget(dataset).get(0));  
            return tree;  
        }  
        //选择最好的属性
        int bestAttr = getBestAttribute(attribute, dataset);  
        //创建决策树 
        tree.setAttribute(attribute.get(bestAttr));  
        tree.setLeaf(false);  
        List<String> attrValueList = DataSetUtil.getAttributeValueOfUnique(bestAttr, dataset);      
        List<String> subAttribute = new ArrayList<String>();  
        subAttribute.addAll(attribute);  
        subAttribute.remove(bestAttr);  
        for(String attrValue : attrValueList) {  
            //更新数据集dataset  
            List<ArrayList<String>> subDataSet = DataSetUtil.getSubDataSetByAttribute(dataset, bestAttr, attrValue);  
            //递归构建子树  
            TreeNode childTree = createDecisionTree(subAttribute, subDataSet);  
            tree.addAttributeValue(attrValue);  
            tree.addChild(childTree);  
        }  
  
        return tree;  
    }  
    /**
     * 建立决策树  
     * @param attribute
     * @param dataset
     * @return
     */
    public TreeNode createDecisionTree(List<String> attribute, List<ArrayList<String>> dataset,Integer studentAccountId) {  
    	TreeNode tree = new TreeNode();  
    	
    	//检查是否单一的
    	if(DataSetUtil.isPure(DataSetUtil.getTarget(dataset))) {  
    		tree.setLeaf(true);  
    		tree.setTargetValue(DataSetUtil.getTarget(dataset).get(0));  
    		return tree;  
    	}  
    	//选择最好的属性
    	int bestAttr = getBestAttribute(attribute, dataset,studentAccountId);  
    	//创建决策树 
    	tree.setAttribute(attribute.get(bestAttr));  
    	tree.setLeaf(false);  
    	List<String> attrValueList = DataSetUtil.getAttributeValueOfUnique(bestAttr, dataset);      
    	List<String> subAttribute = new ArrayList<String>();  
    	subAttribute.addAll(attribute);  
    	subAttribute.remove(bestAttr);  
    	for(String attrValue : attrValueList) {  
    		//更新数据集dataset  
    		List<ArrayList<String>> subDataSet = DataSetUtil.getSubDataSetByAttribute(dataset, bestAttr, attrValue);  
    		//递归构建子树  
    		TreeNode childTree = createDecisionTree(subAttribute, subDataSet);  
    		tree.addAttributeValue(attrValue);  
    		tree.addChild(childTree);  
    	}  
    	
    	return tree;  
    }  
      
    /** 
     * 选出最优属性 
     * @param attribute 
     * @param dataset 
     * @return 
     */  
    public int getBestAttribute(List<String> attribute, List<ArrayList<String>> dataset) {  
        //计算每个属性的比率，选择最大值
        int bestAttr = 0;  
        double maxGainRatio = 0;  
          
        for(int i = 0; i < attribute.size(); i++) {  
            double thisGainRatio = infoGainRatio.getGainRatio(i, dataset);  
            if(thisGainRatio > maxGainRatio) {  
                maxGainRatio = thisGainRatio;  
                bestAttr = i;  
            }  
        }  
          
        System.out.println("最好的属性是:" + attribute.get(bestAttr));  
        return bestAttr;  
    }  
    /** 
     * 选出最优属性 
     * @param attribute 
     * @param dataset 
     * @return 
     */  
    public int getBestAttribute(List<String> attribute, List<ArrayList<String>> dataset,Integer studentAccountId) {  
    	//计算每个属性的比率，选择最大值
    	int bestAttr = 0;  
    	double maxGainRatio = 0;  
    	
    	for(int i = 0; i < attribute.size(); i++) {  
    		double thisGainRatio = infoGainRatio.getGainRatio(i, dataset);  
    		if(thisGainRatio > maxGainRatio) {  
    			maxGainRatio = thisGainRatio;  
    			bestAttr = i;  
    		}  
    	}  
    	Map<String, Object> eq=new HashMap<>();
    	eq.put("business", studentAccountId);
		analyseService.list(1, Integer.MAX_VALUE, null, null, eq, null, null, null, null, null, null, null);
    	System.out.println("最好的属性是:" + attribute.get(bestAttr));  
    	return bestAttr;  
    }  
  
      
    public static void main(String args[]) {  
        //eg 1  
        String attr = "年龄 收入 学生 信用评级";  
        String[] set = new String[12];  
        set[0] = "青年 高 否 公平的 否";  
        set[1] = "青年 高 否 杰出的 否";  
        set[2] = "中老年人 高 否 公平的 是";  
        set[3] = "级别高的 低的 是 公平的 是";  
        set[4] = "级别高的 低的 是 杰出的 否";  
        set[5] = "中老年人 低的 是 杰出的 是";  
        set[6] = "青年 中等的 否 公平的 否";  
        set[7] = "青年 低的 是 公平的 是";  
        set[8] = "级别高的 中等的 是 公平的 是";  
        set[9] = "青年 中等的 是 杰出的 是";  
        set[10] = "中老年人 高 是 公平的 是";  
        set[11] = "级别高的 中等的 否 杰出的 否";  
/*        String attr = "age income student credit_rating";  
        String[] set = new String[12];  
        set[0] = "青年 高 否 公平的 否";  
        set[1] = "青年 高 否 杰出的 否";  
        set[2] = "中老年人 高 否 公平的 是";  
        set[3] = "级别高的 低的 是 公平的 是";  
        set[4] = "级别高的 低的 是 杰出的 否";  
        set[5] = "中老年人 低的 是 杰出的 是";  
        set[6] = "青年 中等的 否 公平的 否";  
        set[7] = "青年 低的 是 公平的 是";  
        set[8] = "级别高的 中等的 是 公平的 是";  
        set[9] = "青年 中等的 是 杰出的 是";  
        set[10] = "中老年人 高 是 公平的 是";  
        set[11] = "级别高的 中等的 否 杰出的 否";  
*/  
   /*    List<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>();  
        List<String> attribute = Arrays.asList(attr.split(" "));  
        for(int i = 0; i < set.length; i++) {  
            String[] s = set[i].split(" ");  
            ArrayList<String> list = new ArrayList<String>();  
            for(int j = 0; j < s.length; j++) {  
                list.add(s[j]);  
            }  
            dataset.add(list);  
        }  */
    /*    List<String> attribute = new ArrayList<>();
        attribute.add(0, "年龄");
        attribute.add(1, "收入");
        attribute.add(2, "学生");
        attribute.add(3, "信用评级");
        List<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>();
        ArrayList<String> list0=new ArrayList<>();
        list0.add("青年");
        list0.add("高");
        list0.add("否");
        list0.add("公平的 ");
        list0.add("否");
        dataset.add(list0);
        ArrayList<String> list1=new ArrayList<>();
        list1.add("青年");
        list1.add("高");
        list1.add("否");
        list1.add("杰出的");
        list1.add("否");
        dataset.add(list1);*/
        List<String> attribute = new ArrayList<>();
        attribute.add(0, "课后上机学习时间 （小时）");
        attribute.add(1, "课前了解");
        attribute.add(2, "课堂学习");
        attribute.add(3, "平时成绩");
        List<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>();
        ArrayList<String> list0=new ArrayList<>();
        list0.add(">10");
        list0.add("了解一点");
        list0.add("良");
        list0.add("良 ");
        list0.add("优");
        dataset.add(list0);
        ArrayList<String> list1=new ArrayList<>();
        list1.add("5-10");
        list1.add("不了解");
        list1.add("一般");
        list1.add("一般");
        list1.add("一般");
        dataset.add(list1);
        ArrayList<String> list2=new ArrayList<>();
        list2.add("<5");
        list2.add("不了解");
        list2.add("一般");
        list2.add("一般");
        list2.add("一般");
        dataset.add(list2);
        ArrayList<String> list3=new ArrayList<>();
        list3.add("<5");
        list3.add("不了解");
        list3.add("差");
        list3.add("差");
        list3.add("差");
        dataset.add(list3);
        DecisionTree dt = new DecisionTree();  
        TreeNode tree = dt.createDecisionTree(attribute, dataset);  
        tree.print("");  
    }  
  
}