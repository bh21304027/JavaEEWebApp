package dao.connectionmanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public abstract class ConnectionManager{
	protected Connection cn = null;
	private static ConnectionManager conn = null;

	public static ConnectionManager getInstance(String type){
		if(conn == null){
	        Properties prop = new Properties();
	        try{
	            prop.load(new FileInputStream("C:/pleiades/workspace/Anodidas2/WebContent/properties/connectionmanager.properties"));

	            String name = prop.getProperty(type);

	            Class<?> c = Class.forName(name);
	            conn = (ConnectionManager)c.getDeclaredConstructor().newInstance();
	        }catch(FileNotFoundException e){
	            throw new RuntimeException(e.getMessage(),e);
	        }catch(IOException e){
	            throw new RuntimeException(e.getMessage(),e);
	        }catch(ClassNotFoundException e){
	            throw new RuntimeException(e.getMessage(),e);
	        }catch(InstantiationException e){
	            throw new RuntimeException(e.getMessage(),e);
	        }catch(IllegalAccessException e){
	            throw new RuntimeException(e.getMessage(),e);
	        }catch(Exception e){
	            throw new RuntimeException(e.getMessage(),e);
	        }
		}
		return conn;
    }

	public abstract Connection getConnection();

	public abstract void closeConnection();

	public abstract void beginTransaction();

	public abstract void commit();

	public abstract void rollback();
}