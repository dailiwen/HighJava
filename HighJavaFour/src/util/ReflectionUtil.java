package util;

import annotation.Column;

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
		String idName = null;
		String id = null;
		
		Field[] fields = clazz.getDeclaredFields();


		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE ");
		sql.append(clazz.getSimpleName());
		sql.append(" SET ");
		for(Field field: fields) {
			field.setAccessible(true);
			Column column = field.getAnnotation(Column.class);
			if(column == null) {
				continue;
			}
			if(column.isId() == true) {
				idName = field.getName();
				id = field.get(entity).toString();
				continue;
			}
			sql.append(column.name()).append(" = ");
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
		sql.append(" WHERE " + idName + " = '").append(id).append("'");
		
		return sql.toString();
	}

	public static String generateDeleteSQL(Object entity) throws Exception, Exception {
		Class clazz = entity.getClass();
		String idName = null;
		String id = null;

		Field[] fields = clazz.getDeclaredFields();

		for(Field field: fields) {
			field.setAccessible(true);
			Column column = field.getAnnotation(Column.class);
			if(column == null) {
				continue;
			}
			if(column.isId() == true) {
				idName = field.getName();
				id = field.get(entity).toString();
			}
		}

		Method method = clazz.getDeclaredMethod("getId");
		method.setAccessible(true);
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM ");
		sql.append(clazz.getSimpleName().toLowerCase());
		sql.append(" WHERE " + idName + " = ");
		sql.append("'" + id + "'");
		return sql.toString();
	}

	public static String generateInsertSQL(Object entity) throws Exception, Exception {
		
		Class clazz = entity.getClass();
		
		Field[] fields = clazz.getDeclaredFields(); 
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append(clazz.getSimpleName().toLowerCase());
		sql.append(" (");
		for(Field field: fields) {
			Column column = field.getAnnotation(Column.class);
			if(column == null) {
				continue;
			}
			String columnName = column.name();
			sql.append(columnName).append(",");
		}
		sql.deleteCharAt(sql.length()-1);
		
		sql.append(") VALUES (");
		
		for(Field field:fields) {
			field.setAccessible(true);
			Object value = field.get(entity);
			String valueString ="";
			if(value instanceof String) {
				valueString = "'"+value+"'";
			}
			else {
				valueString = value.toString();
			}
			sql.append(valueString).append(",");
		}

		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		
		return sql.toString();
	}

}
