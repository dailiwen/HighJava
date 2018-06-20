package org.ddd.section2.example2_40;

import java.util.HashMap;
import java.util.Map;

//该类用于描述注册在容器中的对象
public class BeanInfo {
	private String id; //对象的标识
	private String type; //对象的类型,即全类名
	private Map<String,Object> properties = new HashMap<String,Object>(); //对象的属性及值得集合	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<String,Object> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	public void addProperty(String name, Object value){
		this.properties.put(name, value);
	}
}