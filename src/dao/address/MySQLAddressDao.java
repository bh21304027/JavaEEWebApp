package dao.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AddressBean;
import dao.connectionmanager.ConnectionManager;
import exp.ResourceAccessException;

public class MySQLAddressDao implements AddressDao{

	@Override//未
	public void addAddress(AddressBean ab) {
		PreparedStatement st = null;
		Connection cn = null;
		System.out.print(getAddressidMax()+"kazu");
		System.out.print(ab.getAddressphonenumber());
		System.out.print(ab.getAddressaddress());
		System.out.print(ab.getAddresspostcode());
		System.out.print(ab.getUserid());
		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "INSERT INTO address_table value (?,?,?,?,?)";//insert文
			st = cn.prepareStatement(sql);

			st.setString(1, getAddressidMax());
			st.setString(2, ab.getAddressphonenumber());
			st.setString(3, ab.getAddressaddress());
			st.setString(4, ab.getAddresspostcode());
			st.setString(5, ab.getUserid());

			st.executeUpdate();


			System.out.println("アドレス追加");
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
	public AddressBean getAddress(String userid) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection cn = null;


		AddressBean ab = new AddressBean();

		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "select * from address_table where user_id = ?";
			st = cn.prepareStatement(sql);

			st.setString(1,userid);

			rs = st.executeQuery();

			ab.setState(false);
			while (rs.next()) {

			 ab.setAddressid(rs.getInt(1));
			 ab.setAddressphonenumber(rs.getString(2));
			 ab.setAddressaddress(rs.getString(3));
			 ab.setAddresspostcode(rs.getString(4));
			 ab.setUserid(rs.getString(5));
			 ab.setState(true);

			}


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
		return ab;
	}



	/*
	public AddressBean getAddress(String addressid,String userid) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection cn = null;


		AddressBean ab = new AddressBean();

		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "select * from address_table where addressid = ?";
			st = cn.prepareStatement(sql);

			st.setString(1,addressid);

			rs = st.executeQuery();




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
		return ab;
	}
	*/
	@Override//未
	public void deleteAddress(String addressid,String userid){
		Connection cn = null;
		PreparedStatement st = null;

		try{
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "delete from address_table where user_id = ? and address_id = ?";//delete文
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
	@Override//未
	public void deleteAllAddress(String userid){
		PreparedStatement st = null;

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "delete from address_table where user_id = ?";//delete文
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
	public void updateOrAddAddress(AddressBean a) {
		PreparedStatement st = null;
		Connection cn = null;
		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			if(a.getState()) {

				String sql =  "update address_table set address_phone_number=?,address_address =?,address_post_code=? where Address_id =?";
				st = cn.prepareStatement(sql);

				st.setString(1, a.getAddressphonenumber());
				st.setString(2, a.getAddressaddress());
				st.setString(3, a.getAddresspostcode());
				st.setInt(4, a.getAddressid());

				st.executeUpdate();
				System.out.println("アドレス更新");
			}else {
				addAddress(a);
				return;
			}


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


	//@Override//済み
	public String getAddressidMax() {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String id = null;


		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "SELECT MAX(address_id) FROM address_table";


			st = cn.prepareStatement(sql);

			rs = st.executeQuery();

			rs.next();


			id = String.valueOf(rs.getInt(1)+1);
			System.out.println(id);
			//ConnectionManager.getInstance("mysql").commit();
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
						//ConnectionManager.getInstance("mysql").closeConnection();
						cn=null;
						System.out.println("mysql close");
				}
			}
		}
		return id;
	}
















}
