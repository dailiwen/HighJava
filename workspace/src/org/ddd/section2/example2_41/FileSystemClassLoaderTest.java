package org.ddd.section2.example2_41;

import java.lang.reflect.Method;


public class FileSystemClassLoaderTest {
	public static void main(String[] args) {
		new FileSystemClassLoaderTest().testClassIdentity();
	}
	
	public void testClassIdentity() {
		//以下路径根据实际情况修改
		String classDataRootPath = "D:\\StudyLab\\项目\\Java教材\\JavaHighExample\\workspace\\src";
		FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
		FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
		String className = "org.ddd.section2.example2_41.Sample";	
		try {
			Class<?> class1 = fscl1.loadClass(className);
			Object obj1 = class1.newInstance();
			Object obj3 = class1.newInstance();
			
			Class<?> class2 = fscl2.loadClass(className);
			Object obj2 = class2.newInstance();
			Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
			setSampleMethod.invoke(obj1, obj3);
			
			setSampleMethod.invoke(obj1, obj2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
