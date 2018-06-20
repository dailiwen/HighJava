package org.ddd.section7.example7_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JasonTest {
	public static void main(String[] args) {
		 List<Student> studentList = new ArrayList<Student>();
		 
		 Student stu1  = new Student(1,"张三");
		 Student stu2  = new Student(2,"李四");
		 Student stu3  = new Student(3,"王五");
		 
		 studentList.add(stu1); 
		 studentList.add(stu2); 
		 studentList.add(stu3); 
		 
		 JSONArray jso = JSONArray.fromObject(studentList);
		 System.out.println("jason:\t"+jso);
		 
		 JSONArray ja = JSONArray.fromObject("[{\"id\":1,\"name\":\"张三\"},{\"id\":2,\"name\":\"李四\"},{\"id\":3,\"name\":\"王五\"}]");
		 Map<String, Class<Student>>
		 classMap = new HashMap<String, Class<Student>>(); 
		 classMap.put("list", Student.class); 
		 List<Student>list = JSONArray.toList(ja, Student.class,classMap);
		 
		 for(Student student:list){
			 System.out.println(student.getName());
			 System.out.println(student.getId());
		 }
		 
		 
/*		 
		 //map转为json
		 Map map = new LinkedHashMap();
		 
		 map.put("int", new Integer(1));
		 map.put("arr", new String[]{"12","22"});
		 map.put("fun", "function app{return true}");
		 
		 JSONObject json = JSONObject.fromObject(map);
		 System.out.println(json);
		 */
		 
		 
		 
	}
}
