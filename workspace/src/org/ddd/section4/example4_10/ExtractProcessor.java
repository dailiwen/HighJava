package org.ddd.section4.example4_10;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 抽象接口注解处理器 该处理器负责抽象指定类的公共方法，然后生成指定的接口
 */
public class ExtractProcessor implements AnnotationProcessor {

	/**
	 * 暴露的外部接口方法，使用该方法需要传入指定类的Class对象 处理的流程如下： 1.获取@ExtractInterface注解
	 * 2.如果注解该类拥有指定注解，则创建一个StringBuilder用于临时存放生成代码 3.在StringBuilder中添加包信息
	 * 4.在StringBuilder中添加接口信息 5.遍历指定类声明的方法集合，并在StringBuilder加入公共方法信息 6.生成接口文件
	 */
	public boolean process(Class<?> clazz) throws Exception {
		ExtractInterface extractInterface = this.getExcactInterface(clazz);
		if (extractInterface != null) {
			StringBuilder sb = new StringBuilder();
			this.addPackage(sb, clazz);
			this.addInterface(sb, extractInterface);
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) { // 遍历指定类声明的方法
				 
				if (method.getModifiers() == Modifier.PUBLIC) { // 如果获取的方法为公共方法
					sb = this.addMethod(sb, method); // 添加方法信息
				}
			}
			sb.append("}");
			this.createFile(sb, clazz, extractInterface); // 创建接口文件
			return true;
		}
		return false;
	}

	/**
	 * 获取@ExtractInterface注解,使用该方法需要传入指定类的Class对象 处理流程如下： 1.遍历该类上的所有注解
	 * 2.如果注解的类型为@ExtractInterface，则返回该注解，负责返回null
	 * 
	 * @param clazz
	 *            指定类的Class对象
	 * @return 类上声明的@ExtractInterface注解
	 */
	private ExtractInterface getExcactInterface(Class<?> clazz) {
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation.annotationType() == ExtractInterface.class) {
				return (ExtractInterface) annotation;
			}
		}
		return null;
	}

	/**
	 * 向StringBuilder中添加包信息，使用该类需要传入StringBuilder和指定类的Class对象
	 */
	private StringBuilder addPackage(StringBuilder sb, Class<?> clazz) {
		sb.append("package ");
		sb.append(clazz.getPackage().getName());
		sb.append(";");
		sb.append("\n");
		return sb;
	}

	/**
	 * 向StringBuilder中添加接口信息，使用该类需要传入StringBuilder和@ExtractInterface注解对象
	 */
	private StringBuilder addInterface(StringBuilder sb, ExtractInterface anno) {
		if(anno.isPublicModifier() == true)
		{
			sb.append("public");
		}
		else
		{
			sb.append("private");
		}
		sb.append(" interface ");
		sb.append(anno.value()); // 根据@ExtractInterface的value参数来确定接口名称
		sb.append("{");
		sb.append("\n");
		return sb;
	}

	/**
	 * 向StringBuilder中添加方法信息，使用该方法传入StringBuilder和指定的方法 处理流程如下： 1.添加修饰符
	 * 2.添加返回值类型 3.添加方法名称 4.遍历参数类型，并向StringBuilder中添加参数
	 */
	private StringBuilder addMethod(StringBuilder sb, Method method) {
		sb.append(TAB + "public ");
		sb.append(method.getReturnType().getCanonicalName() + BLANK); // 添加返回值类型
		sb.append(method.getName() + BLANK); // 添加方法名
		sb.append("(");
		Class[] paras = method.getParameterTypes(); // 获取参数类型集合
		String arg = "arg"; // 参数名得前半部分
		Integer argIndex = 0; // 参数索引
		for (Class<?> para : paras) { // 遍历方法的参数类型
			sb.append(para.getCanonicalName() + BLANK); // 添加参数类型
			sb.append(arg + argIndex); // 添加参数名称，参数名称由arg+索引组成
			sb.append("," + BLANK);
			argIndex++;
		}
		if (argIndex > 0) { // 去除多余的逗号和空格
			sb = new StringBuilder(sb.substring(0, sb.length() - 2));
		}
		sb.append(")");
		sb.append(";");
		sb.append("\n");
		return sb;
	}

	/**
	 * 创建接口文件
	 */
	private void createFile(StringBuilder sb, Class<?> clazz,
			ExtractInterface ext) throws Exception {
		String path = clazz.getPackage().getName();
		path = path.replace(".", "\\");
		String url = System.getProperty("user.dir") + "\\src\\" + path + "\\"
				+ ext.value() + ".java";
		FileOutputStream fileWriter;
		fileWriter = new FileOutputStream(url);
		fileWriter.write(sb.toString().getBytes("UTF-8"));

		fileWriter.flush();
		fileWriter.close();
		System.out.println(url);
	}

	public static final String BLANK = " ";
	public static final String TAB = "\t";
}
