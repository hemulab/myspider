package com.ksyche.tools.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Query {
	
	private List<Object> values = new ArrayList<Object>();
	private StringBuilder sql = new StringBuilder();

	public Query column(String column) {
		sql.append(' ');
		sql.append(column);
		sql.append(' ');
		return this;
	}
	
	public Query equal(Object value) {
		sql.append("=?");
		values.add(value);
		return this;
	}
	
	public Query notEqual(Object value) {
		sql.append("!=?");
		values.add(value);
		return this;
	}
	
	public Query greater(Object value) {
		sql.append(">?");
		values.add(value);
		return this;
	}
	
	public Query greaterOrEqual(Object value) {
		sql.append(">=?");
		values.add(value);
		return this;
	}
	
	public Query less(Object value) {
		sql.append("<?");
		values.add(value);
		return this;
	}
	
	public Query lessOrEqual(Object value) {
		sql.append("<=?");
		values.add(value);
		return this;
	}
	
	public Query in(Object ... value) {
		if(value==null || value.length==0) {
			return this;
		}
		if(value.length==1){
			 sql.append(" = ?");
			 values.add(value[0]);
			 return this;
		}
		
		sql.append(" IN (");
		for(int i=0; i<value.length; i++) {
			if(i != 0) {
				sql.append(',');
			}
			sql.append('?');
			values.add(value[i]);
		}
		sql.append(')');
		return this;
	}
	
	public Query notIn(Object ... value) {
		if(value==null || value.length==0) {
			return this;
		}
		if(value.length==1){
			 sql.append(" = ?");
			 values.add(value[0]);
			 return this;
		}
		
		sql.append(" NOT IN (");
		for(int i=0; i<value.length; i++) {
			if(i != 0) {
				sql.append(',');
			}
			sql.append('?');
			values.add(value[i]);
		}
		sql.append(')');
		return this;
	}
	
	
	public <T> Query inCollection(Collection<T> value) {
		if(value==null || value.size()==0) {
			return this;
		}
		Iterator<T> iterator = value.iterator();
		if(value.size()==1){
			sql.append(" = ?");
			values.add(iterator.next());
			return this;
		}
		sql.append(" IN (");
		for(int i=0; i<value.size(); i++) {
			if(i != 0) {
				sql.append(',');
			}
			sql.append('?');
			values.add(iterator.next());
		}
		sql.append(')');
		return this;
	}
	
	public <T> Query inList(List<T> value) {
		if(value==null || value.size()==0) {
			return this;
		}
		if(value.size()==1){
			sql.append(" = ?");
			values.add(value.get(0));
			return this;
		}
		sql.append(" IN (");
		for(int i=0; i<value.size(); i++) {
			if(i != 0) {
				sql.append(',');
			}
			sql.append('?');
			values.add(value.get(i));
		}
		sql.append(')');
		return this;
	}
	
	public Query like(Object value) {
		sql.append(" LIKE ? ");
		values.add(value);
		return this;
	}
	
	public Query and() {
		if(sql.length() > 0) {
			sql.append(" AND ");
		}
		return this;
	}
	
	public Query or() {
		if(sql.length() > 0) {
			sql.append(" OR ");
		}
		return this;
	}
	
	public Query leftBracket() {
		sql.append(" ( ");
		return this;
	}
	
	public Query rightBracket() {
		sql.append(" ) ");
		return this;
	}
	
	public List<Object> values() {
		return this.values;
	}
	
	public String toSql() {
		return sql.toString();
	}
	
	public boolean isEmpty() {
		return sql.length()==0 ? true : false;
	}
	
	//------------20140506 xuqiang---------------------//
	public Query append(String sql){
		this.sql.append(sql);
		return this;
	}
}
