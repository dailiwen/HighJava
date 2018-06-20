package org.ddd.section4.example4_11.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.ddd.section4.example4_11.annotation.Entity;

/**
 * 表信息，对应数据库中的一张表
 */
public class TableInfo {
	private String tableName;  //表的名称
	private Class<?> clazz; //该表对应的实体类型信息类
	private boolean needPersist = false; //是否需要持久化存储
	private Map<String,ColumnInfo> columns = new HashMap<String,ColumnInfo>(); //该表中的所有字段信息

	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	/**
	 * 向字段列表中添加字段信息
	 * @param key 字段的标识，一般是字段名
	 * @param column //字段信息，包括名称、类型、限制等
	 */	
	public void addColumn(String key,ColumnInfo column){
		this.columns.put(key, column);
	}
	public boolean isNeedPersist() {
		return needPersist;
	}
	public void setNeedPersist(boolean needPersist) {
		this.needPersist = needPersist;
	}
	
	/**
	 * 将实体对应的类型信息，转换成表信息
	 * 其转换过程出如下：
	 * 1.根据类型信息，获取实体类的简单名称作为表名
	 * 2.获取在该类上使用的注解集合
	 * 3.遍历这些集合：
	 * 		1.如果发现这些集合中含有@Entity注解，则表明该实体需要持久化存储，然后获取@Entity注解的参数value
	 * 			如果参数不为空，则将表明设为此参数值，跳出循环
	 * 		2.如果没有找到该注解，则说明此实体不需要持久化存储，则返回null
	 * 4.如果该实体需要持久化存储，则遍历该实体类型信息的所有属性描述对象列表。并将它们转换成表的字段信息对象，添加到字段信息map中
	 * 5.最后返回解析好的表信息实体
	 * @param clazz 实体对应的类型信息
	 * @return 由类型信息而转化成的表信息对象
	 */
	public static TableInfo parse(Class<?> clazz){
		TableInfo table = new TableInfo();
		table.clazz = clazz;
		table.tableName = table.clazz.getSimpleName();
		Annotation[] annotations = table.clazz.getAnnotations();
		for(Annotation annotation : annotations){
			if(annotation.annotationType().equals(Entity.class)){ //如果包含@Entity注解，则表明此实体需要持久化存储
				table.needPersist = true; //持久化存储标志，设为true
				Entity entity = (Entity)annotation;
				if(!entity.value().equals("")){
					table.tableName = entity.value();
				}
				break;
			}
		}
		if(table.needPersist){  //如果需要持久化存储，遍历生成字段信息
			Field[] fields = table.clazz.getDeclaredFields();
			for(Field field : fields){
				ColumnInfo column = ColumnInfo.parse(field);
				if(column != null){
					table.columns.put(field.getName(), column);
				}
				
			}
			return table;
		}
		else //不需要持久化存储，则返回null
		{
			return null;
		}
	}
	
	/**
	 * 使用表信息对象生成SQL创建语句
	 */
	@Override
	public String toString(){
		StringBuilder sql = new StringBuilder();
		sql.append(Symbol.LINE);
		sql.append("CREATE TABLE ");
		sql.append(this.tableName + Symbol.BLANK);
		sql.append("(");
		for(ColumnInfo column : this.columns.values()){
			sql.append(Symbol.LINE);
			sql.append(Symbol.TAB);
			sql.append(column.toString());
		}
		sql.append(Symbol.LINE);
		sql.append(");");
		return sql.toString();
	}
}
