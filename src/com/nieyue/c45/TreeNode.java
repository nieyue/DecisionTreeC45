package com.nieyue.c45;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TreeNode {  
    public String attribute;  
    public List<String> attributeValue;  
    public List<TreeNode> child;  
    //for leaf node  
    public boolean isLeaf;  
    public String targetValue;  
    
      
    TreeNode() {  
        attributeValue = new ArrayList<String>();  
        child = new ArrayList<TreeNode>();  
    }  

	public String getAttribute() {  
        return attribute;  
    }  
      
    public void setAttribute(String attribute) {  
        this.attribute = attribute;  
    }  
      
    public List<String> getAttributeValue() {  
        return attributeValue;  
    }  
      
    public void setAttributeValue(List<String> attributeValue) {  
        this.attributeValue = attributeValue;  
    }  
      
    public void addAttributeValue(String attributeValue) {  
        this.attributeValue.add(attributeValue);  
    }  
      
    public List<TreeNode> getChild() {  
        return child;  
    }  
      
    public void setChild(List<TreeNode> child) {  
        this.child = child;  
    }  
      
    public void addChild(TreeNode child) {  
        this.child.add(child);  
    }  
      
    public boolean isLeaf() {  
        return isLeaf;  
    }  
      
    public void setLeaf(boolean isLeaf) {  
        this.isLeaf = isLeaf;  
    }  
      
    public String getTargetValue() {  
        return targetValue;  
    }  
      
    public void setTargetValue(String targetValue) {  
        this.targetValue = targetValue;  
    }  
      
    public void print(String depth) {  
        if(!this.isLeaf){  
            System.out.println(depth + this.attribute+"!!!!");  
            depth += "\t";  
            for(int i = 0; i < this.attributeValue.size(); i++) {  
                System.out.println(depth + "---(" + this.attributeValue.get(i) + ")---" );  
                this.child.get(i).print(depth + "\t");  
            }  
        } else {  
            System.out.println(depth + "[" + this.targetValue + "]");  
        }  
          
          
    }  
    public String studentPrint(String result,String depth,Map<String,String> map) {
    	if(!this.isLeaf){  
    		System.out.println(depth + this.attribute+"!!!!"); 
    		depth += "\t";  
    		for(int i = 0; i < this.attributeValue.size(); i++) {  
    			Iterator<Entry<String, String>> mapIt = map.entrySet().iterator();
    			while(mapIt.hasNext()){
    				Entry<String, String> entry = mapIt.next();
    				if(
    					entry.getKey().equals(this.attribute)
    						&&
    						entry.getValue().equals(this.attributeValue.get(i))){
    					//System.err.print(entry );
    					//System.err.println(this.getAttributeValue().get(i));
    					System.out.println(depth + "---(" + this.attributeValue.get(i) + ")---" );  
    					result=this.child.get(i).studentPrint(result,depth + "\t",map);  
    				}
    			}
    		}  
    	} else {  
    		
    		result=this.targetValue;
    		System.out.println(depth + "[" + this.targetValue + "]");  
    	}  
    	return result;
    	
    }  
    public List<String> getAttributeList(List<String> list,Map<String,String> map) {
    	if(!this.isLeaf){  
    		if(list.size()<=0||!list.contains(this.attribute)){    			
    			list.add(this.attribute);
    		}
    		for(int i = 0; i < this.attributeValue.size(); i++) {  
    			Iterator<Entry<String, String>> mapIt = map.entrySet().iterator();
    			while(mapIt.hasNext()){
    				Entry<String, String> entry = mapIt.next();
    				if(
    						entry.getKey().equals(this.attribute)
    						&&
    						entry.getValue().equals(this.attributeValue.get(i))){
    					list=this.child.get(i).getAttributeList(list,map);  
    				}
    			}
    		}  
    	} else {  
    	}  
    	return list;
    	
    }  
      
}