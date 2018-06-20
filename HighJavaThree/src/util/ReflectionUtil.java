package util;

import entity.Teacher;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil {

	public static void main(String[] args) throws ClassNotFoundException, Exception, IllegalAccessException {
	
		Class clazz = Class.forName("entity.Teacher");
		
		Object entity = clazz.newInstance();
		
		String sql = generateInsertSQL(entity);
		System.out.println("插入语句:");
		System.out.println(sql);
		
		sql = generateDeleteSQL(entity);
		System.out.println("删除语句:");
		System.out.println(sql);
		
		sql = generateUpdateSQL(entity);
		System.out.println("修改语句:");
		System.out.println(sql);
	}

	public static String generateUpdateSQL(Object entity) throws Exception, Exception {
		Class clazz = entity.getClass();
		String id = null;
		
		Field[] fields = clazz.getDeclaredFields();

		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE ");
		sql.append(clazz.getSimpleName());
		sql.append(" SET ");
		for(Field field: fields) {
			field.setAccessible(true);
			if("id".equals(field.getName())) {
				id = field.get(entity).toString();
				continue;
			}
			sql.append(field.getName()).append(" = ");
			Object value = field.get(entity);
			String valueString = "";
			if(value instanceof String) {
				valueString="'" + value + "'";
			}
			else {
				valueString = value.toString();
			}
			sql.append(valueString).append(",");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" WHERE id = '").append(id).append("'");
		
		return sql.toString();
	}

	public static String generateDeleteSQL(Object entity) throws Exception, Exception {
		Class clazz = entity.getClass();
		
		Method method = clazz.getDeclaredMethod("getId");
		method.setAccessible(true);
		
		StringBuffer sql = new StringBuffer();
		sql.append("Delete from ");
		sql.append(clazz.getSimpleName());
		sql.append(" where id = ");
		sql.append("'"+method.invoke(entity)+"';");
		return sql.toString();
	}

	public static String generateInsertSQL(Object entity) throws Exception, Exception {
		
		Class clazz = entity.getClass();
		
		Field[] fields = clazz.getDeclaredFields(); 
		
		StringBuffer sql = new StringBuffer();
		sql.append("Insert into ");
		sql.append(clazz.getSimpleName());
		sql.append(" (");
		for(Field field: fields) {
			if("ID".equals(field.getName()))
				continue;
			sql.append(field.getName()).append(",");
		}
		sql.deleteCharAt(sql.length()-1);
		
		sql.append(") values (");
		
		for(Field field:fields)
		{
			if("ID".equals(field.getName()))
			{
				continue;
			}			
			field.setAccessible(true);
			Object value = field.get(entity);
			String valueString ="";
			if(value instanceof String)
			{
				valueString="'"+value+"'";
			}
			else
			{
				valueString=value.toString();
			}
			sql.append(valueString).append(",");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(")");
		
		return sql.toString();
	}

}
