package org.ddd.section2.example2_40;

import java.util.HashMap;
import java.util.Map;

/**
 * XML注册读取器
 * 该类继承了注册读取器接口,并模拟实现了读取注册对象信息的方法
 */
public class XMLSourceReader implements SourceReader {
	/**
	 * 实现读取注册对象信息方法
	 * 此处只是模拟测试使用,感兴趣的同学可以自己书写通过配置文件读取的实现
	 */
	@Override
	public Map<String, BeanInfo> loadBeans(String filePath) {
		//初始化一个对象信息
		BeanInfo beaninfo = new BeanInfo();
		beaninfo.setId("Person");
		beaninfo.setType("org.ddd.di.bean.Person");
		beaninfo.addProperty("name", "Tim");
		Map<String,BeanInfo> beans = new HashMap<String,BeanInfo>(); //初始化一个对象信息Map
		beans.put("Person", beaninfo);  //将对象信息注册到对象信息MAP中
		return beans; //返回对象信息MAP
	}
}
