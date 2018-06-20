package org.ddd.section2.example2_40;

/**
 * IOC容器的顶层接口
 */
public interface BeanFactory {
	/**
	 * 根据对象的名称标识来获取对象实例
	 * @param name 对象名称，即对象描述信息中的对象标识
	 * @return 指定名称的对象实例
	 */
	Object getBean(String name);
}
