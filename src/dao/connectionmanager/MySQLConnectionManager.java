package dao.connectionmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exp.ResourceAccessException;

public class MySQLConnectionManager extends ConnectionManager{

	public Connection getConnection(){
		if(cn == null){
			try{
	            Class.forName("com.mysql.jdbc.Driver");

	            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orcl?characterEncoding=UTF-8&serverTimezone=JST","info","pro");
	            System.out.println("接続完了");
        	}catch(ClassNotFoundException e){
            	e.printStackTrace();
        	}catch(SQLException e){
            	e.printStackTrace();
            	throw new ResourceAccessException(e.getMessage(),e);
        	}catch(Exception e){
            	e.printStackTrace();
        	}
    	}
		return cn;
	}

    public void closeConnection(){
    	try{
    		if(cn != null){
    			cn.close();
    			cn = null;
    			System.out.println("切断完了");
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    		throw new ResourceAccessException(e.getMessage(),e);
    	}
    }

	public void beginTransaction(){
    	if(cn == null){
    		getConnection();
    	}
		try{
			cn.setAutoCommit(false);
		}catch(SQLException e){
    		e.printStackTrace();
    		throw new ResourceAccessException(e.getMessage(),e);
    	}
    }

	public void commit(){
		try{
			cn.commit();
    	}catch(SQLException e){
    		e.printStackTrace();
    		throw new ResourceAccessException(e.getMessage(),e);
    	}
    }

	public void rollback(){
		try{
			cn.rollback();
    	}catch(SQLException e){
    		e.printStackTrace();
    		throw new ResourceAccessException(e.getMessage(),e);
    	}
    }
}
