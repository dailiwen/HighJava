package org.ddd.section8.example8_8;

import java.sql.Connection;
/**
 * 含有状态的数据库连接
 */
public class MyCon {	
	public static final int FREE = 100; //当前连接空闲
	public static final int BUZY = 101; //当前连接繁忙
	public static final int CLOSED = 102; //当前连接关闭	
	private Connection con; //持有的数据库连接
	private int state = FREE; //数据库连接当前状态，初始时为空闲状态	
	
	public MyCon(Connection con){
		this.con = con;
	}
	
	public Connection getCon() {
		return con;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
