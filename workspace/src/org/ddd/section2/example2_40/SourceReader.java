package org.ddd.section2.example2_40;

import java.util.Map;

/**
 * 注册读取器接口
 * 负责从读取用户注册的对象
 * 继承该接口的类可以实现多种读取方式，如从配置文件中读取，根据标注读取，从网络中读取等
 */
public interface SourceReader {
	/**
	 * 读取用户注册的对象信息
	 * @param filePath 读取录取
	 * @return 注册对象信息Map
	 */
	Map<String,BeanInfo> loadBeans(String filePath);
}
