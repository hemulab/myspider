package com.ksyche.tools.dao.connpool;

import java.sql.Connection;
import java.util.Date;

class MyConnection {

	private Connection conn;
	private int state;
	private Date lastTime;
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Connection getConn() {
		return conn;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getState() {
		return state;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public Date getLastTime() {
		return lastTime;
	}
}
