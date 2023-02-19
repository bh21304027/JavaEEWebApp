package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;
import dao.connectionmanager.ConnectionManager;
import exp.ResourceAccessException;

public class MySQLUserDao implements UserDao{

	@Override//済み
	public void addUser(UserBean u) {
		PreparedStatement st = null;
		Connection cn = null;
		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "insert into user_table values(?,?,?,?,?)";


			st = cn.prepareStatement(sql);

			st.setString(1,u.getUserid());
			st.setString(2,u.getUsername());
			st.setString(3,u.getUserpass());
			st.setInt(4,u.getUsergender());
			st.setString(5,u.getUserdob());

			System.out.println(u.getUserid());
			System.out.println(u.getUsername());
			System.out.println(u.getUserpass());
			System.out.println(u.getUsergender());
			System.out.println(u.getUserdob());

			st.executeUpdate();
			System.out.println("ユーザ追加");
			ConnectionManager.getInstance("mysql").commit();
		}catch(SQLException e){
			e.printStackTrace();
			ConnectionManager.getInstance("mysql").rollback();
		}finally{
			try{
				if(st !=null){
					st.close();
				}
			}catch(SQLException e2){
				System.out.print("MySQLUserDao addUserでエラー");
				e2.printStackTrace();
				throw new ResourceAccessException(e2.getMessage(),e2);
			}finally{
				if(cn !=null){
						ConnectionManager.getInstance("mysql").closeConnection();
						cn=null;
						System.out.println("mysql close");
				}
			}
		}
	}
	@Override//済み
	public void updateUser(UserBean u){
		PreparedStatement st = null;
		Connection cn = null;
		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);

			String sql = "update user_table set  user_name = ?,user_dob = ? where user_id = ?";
			st = cn.prepareStatement(sql);

			st.setString(1,u.getUsername());
			st.setString(2,u.getUserdob());
			st.setString(3,u.getUserid());

			st.executeUpdate();

			System.out.println("ユーザ情報変更");
			ConnectionManager.getInstance("mysql").commit();
		}catch(SQLException e){
			e.printStackTrace();
			ConnectionManager.getInstance("mysql").rollback();
		}finally{
			try{
				if(st !=null){
					st.close();
				}
			}catch(SQLException e2){
				System.out.print("MySQLUserDao addUserでエラー");
				e2.printStackTrace();
				throw new ResourceAccessException(e2.getMessage(),e2);
			}finally{
				if(cn !=null){
						ConnectionManager.getInstance("mysql").closeConnection();
						cn=null;
						System.out.println("mysql close");
				}
			}
		}
	}
	@Override//未
	public void updateUserpass(UserBean u){
		PreparedStatement st = null;

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);

			String sql = "update user_table set user_pass = ? where user_id = ?";
			st = cn.prepareStatement(sql);

			st.setString(1,u.getUserpass());
			st.setString(2,u.getUserid());

			st.executeUpdate();
		}catch(SQLException e){
			ConnectionManager.getInstance("mysql").rollback();
			throw new ResourceAccessException(e.getMessage(),e);
		}finally{
			try{
				if(st != null){
    				st.close();
    			}
			}catch(SQLException e){
				throw new ResourceAccessException(e.getMessage(),e);
			}
		}
	}


	@Override//未
	public void deleteUser(String userid){
		PreparedStatement st = null;

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "delete from user_table where user_id = '"+userid+"'";
			st = cn.prepareStatement(sql);

			st.executeUpdate();


		}catch(SQLException e){
			ConnectionManager.getInstance("mysql").rollback();
			throw new ResourceAccessException(e.getMessage(),e);
		}finally{
			try{
				if(st != null){
    				st.close();
    			}
			}catch(SQLException e){
				throw new ResourceAccessException(e.getMessage(),e);
			}
		}
	}

	@Override//済み
	public String[] getUser(String uid, String upass) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;



		String userid[] =new String[2];

		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "select user_id,user_name from user_table where User_id = ? and User_pass = ?";


			st = cn.prepareStatement(sql);
			st.setString(1,uid);
			st.setString(2,upass);

			rs = st.executeQuery();


			while (rs.next()) {

				userid[0] = rs.getString(1);
				userid[1] = rs.getString(2);
				System.out.println(userid);
				}

		}catch(SQLException e){
			e.printStackTrace();
			ConnectionManager.getInstance("mysql").rollback();

		}finally{
			try{
				if(st !=null){
					st.close();
				}
			}catch(SQLException e2){
				e2.printStackTrace();
				//throw new ResourceAccessException(e.getMessage(),e2);
			}finally{
				if(cn !=null){
						ConnectionManager.getInstance("mysql").closeConnection();
						cn=null;
						System.out.println("mysql close");
				}
			}
		}
		return userid;
	}

	@Override//済み
	public UserBean getUserInfo(String uid) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		UserBean u = new UserBean();


		String username = null;
		String userbod =null;

		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "select user_name ,user_dob from user_table where User_id = ?";


			st = cn.prepareStatement(sql);
			st.setString(1,uid);

			rs = st.executeQuery();

			while (rs!=null&rs.next()) {


			username = rs.getString("user_name");
			userbod = rs.getString("user_dob");
			System.out.println(username);
			System.out.println(userbod);





			u.setUsername(username);
			u.setUserdob(userbod);
			}

		}catch(SQLException e){
			e.printStackTrace();
			ConnectionManager.getInstance("mysql").rollback();

		}finally{
			try{
				if(st !=null){
					st.close();
				}
			}catch(SQLException e2){
				e2.printStackTrace();
				throw new ResourceAccessException(e2.getMessage(),e2);
			}finally{
				if(cn !=null){
						ConnectionManager.getInstance("mysql").closeConnection();
						cn=null;
						System.out.println("mysql close1");
				}
			}
		}
		return u;
	}


}