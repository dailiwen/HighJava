package org.ddd.section7.example7_12;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Container {
	
	 Map<String,Object> map = null;
	
	public Container(String filePath)throws Exception{
		 	SAXReader sr=new SAXReader();
		    map = new HashMap<String,Object>();
		    File file = new File(filePath);
		    Document document = sr.read(file);
		    Element root = document.getRootElement();
			List<Element> list = (List<Element>)root.elements("bean");
		    
		    for(int i =0;i<list.size();i++){
		    	String id = list.get(i).attribute("id").getValue();
		    	String path = list.get(i).attribute("class").getValue();
		    	
		    	Class<?> clazz = Class.forName(path);
		    	Object Sobject = clazz.newInstance();
		    	map.put(id, Sobject);
		    	
		    	for(Element element : (List<Element>)list.get(i).elements("property")){
		    		String name  = element.attribute("name").getValue();//gift
		    		String bean = element.attribute("bean").getValue();//g
		    		
		    		Object obj = map.get(bean);//拿到实例化的对象
		    		String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
		    		Method m =  Sobject.getClass().getMethod(methodName, obj.getClass().getInterfaces());
		    		m.invoke(Sobject, obj);
		    	}
		    }
	 }
    public Object getBean(String str){
    	return map.get(str);
    }
} 


