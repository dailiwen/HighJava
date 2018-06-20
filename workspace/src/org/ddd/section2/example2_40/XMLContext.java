package org.ddd.section2.example2_40;

public class XMLContext extends AbstractBeanFactory{
	/**
	 * 上下文的构造方法
	 * 该方法中指明注册读取器
	 * 并在构造该方法时一次性的加载注册的对象
	 * @param filePath
	 */
	public XMLContext(String filePath) {
		super(filePath);
		this.setSourceReader(new XMLSourceReader()); //添加注册读取器，此处的注册读取器为XMLSourceReader
 		this.registerBeans(); //加载注册的对象信息
	}	
	//  设置注册读取器
	@Override
	protected void setSourceReader(SourceReader reader) {
		this.reader = reader;
	}
}

