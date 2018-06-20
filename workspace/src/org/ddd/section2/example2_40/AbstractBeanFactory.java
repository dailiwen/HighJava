package org.ddd.section2.example2_40;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 最顶层的IOC实现
 * 该类负责从注册器中取出注册对象
 * 实现从对象描述信息转换为对象实例的过程、
 * 实现根据名称获取对象的方法
 */
public abstract class AbstractBeanFactory implements BeanFactory {
	private String filePath;	//注册文件路径
	private Map<String,BeanInfo> container; //注册对象信息Map
	protected SourceReader reader; //对象注册读取器
	public AbstractBeanFactory(String filePath){
		this.filePath = filePath;
	}
	/**
	 * 该方法为抽象方法,需有子类类实现,用于指定使用什么样的注册读取器
	 * @param reader 指定的注册读取器
	 */
	protected abstract void setSourceReader(SourceReader reader);
	// 从注册读取器中读取,注册对象的信息MAP
	public void registerBeans(){
		this.container = this.reader.loadBeans(filePath);
	}
	//  实现BeanFactory定义的根据名称获取指定对象的方法
	@Override
	public Object getBean(String name) {
		BeanInfo beaninfo = this.container.get(name); //根据对象名获取该对象的描述信息
		if(beaninfo == null){ //如果容器中不存在该对象的描述信息,则返回null,此处可以抛开一个异常
			return null;
		}else{ //根据对象信息,解析并生成指定对象实例,返回给用户
			return this.parseBean(beaninfo);
		}
	}	
	/**
	 * 解析并生成对象实例
	 * 该方法主要通过反射完成，步骤如下：
	 * 1.根据类名，加载指定类，并获取该类的貌似Class对象clazz
	 * 2.使用Class对象clazz实例化该类，获取一个对象，注意，这儿实例化对象时，采用的无参构造方法，因此要求注册的对象必须含有无参构造方法
	 * 3.逐个设置对象字段的值，这儿采用setter Method方式，而不是直接使用Field对象的原因是，用户有可能在setter对象中，对注入的值进行额外处理，如格式化等
	 * 4.返回对象实例
	 * @param beaninfo 指定对象的描述信息
	 * @return
	 */
	protected Object parseBean(BeanInfo beaninfo){
		Class clazz; 
		try {
			clazz = Class.forName(beaninfo.getType()); //根据对象的全类名，指定类
			Object bean = clazz.newInstance(); //使用注册对象的无参构造函数，实例化对象实例
			Method[] methods = clazz.getMethods(); //获取该类声明的所有公共方法，其实Spring获取的是所有方法，包括非公有的
			for(String property : beaninfo.getProperties().keySet()){ //遍历对象的所有属性，进行赋值
				String setter = "set" + StringUtil.firstCharToUp(property); //获取属性的setter方法名称
				for(Method method : methods){ //遍历该类的所有公有方法
					String methodName = method.getName(); //获取方法名称
					if(methodName.equals(setter)){ //比较方法名与属性的setter方法名是否相同，如果相同则进行赋值
						Object value = beaninfo.getProperties().get(property); //从对象描述信息中获取该属性的值
						method.invoke(bean,value); //通过反射对属性进行赋值
						continue; //对下一属性赋值
					}
				}
			}
			return bean; //返回指定的对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
}
