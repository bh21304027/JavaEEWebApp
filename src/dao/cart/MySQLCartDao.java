package dao.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CartBean;
import bean.CartsBean;
import dao.connectionmanager.ConnectionManager;
import exp.ResourceAccessException;

public class MySQLCartDao implements CartDao{

	//済み
	@Override
	public void addCart(CartsBean cbs) {
		Connection cn = null;
		PreparedStatement st = null;

		try{
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql1 = "insert into cart_table(cart_id, user_id, product_id, cartdetail_purchase_quantity) values(?,?,?,?)";
			st = cn.prepareStatement(sql1);

			st.setInt(1, getCartidMax());
			st.setString(2, cbs.getUserid());
			st.setInt(3, cbs.getProductid());
			st.setInt(4, cbs.getCount());

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

/*
	@Override
	public void updateCart(CartBean c) {
		PreparedStatement st = null;

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "update cart_table set cart_total = ? where user_id = ?";
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

*/


	//済み
	@Override
	public CartBean deleteCart(int cartid) {
		Connection cn = null;
		PreparedStatement st = null;
		CartBean cb = new CartBean();

		try {

			cn = ConnectionManager.getInstance("mysql").getConnection();

			String sql1 = "delete from cart_table where cart_id = ?";
			st = cn.prepareStatement(sql1);
			st.setInt(1, cartid);

			st.executeUpdate();


		} catch (SQLException e) {
			ConnectionManager.getInstance("mysql").rollback();
			throw new ResourceAccessException(e.getMessage(), e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				throw new ResourceAccessException(e.getMessage(), e);
			}
		}
		return cb;
	}

	@Override
	public void deleteUserCart(String userid) {
		PreparedStatement st = null;

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "delete from cart_table where user_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1,userid);
			st.executeUpdate();

			ConnectionManager.getInstance("mysql").commit();
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



	//済み
	@Override
	public ArrayList<CartsBean> getCart(String userid) {
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<CartsBean> list = new ArrayList<CartsBean>();

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "select * from cart_table where user_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, userid);
			rs = st.executeQuery();

			while(rs.next()){
				CartsBean cb = new CartsBean();
				cb.setCartid(rs.getInt(1));
				cb.setUserid(rs.getString(2));
				cb.setProductid(rs.getInt(3));
				cb.setCount(rs.getInt(4));
				list.add(cb);

			}



		}catch(SQLException e){
			ConnectionManager.getInstance("mysql").rollback();
			throw new ResourceAccessException(e.getMessage(),e);
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st != null){
    				st.close();
    			}
			}catch(SQLException e){
				throw new ResourceAccessException(e.getMessage(),e);
			}
		}
		return list;
	}





	@Override
	public CartBean getCartProduct(int productid) {
		PreparedStatement st = null;
		ResultSet rs = null;

		CartBean cb = new CartBean();
		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();

			String sql = "select p.product_id,shoes_size,shoes_name,shoes_price,shoes_picturepath,s.shoes_id from product_table p left join shoes_table s on p.shoes_id = s.shoes_id where p.product_id = ?;";
			st = cn.prepareStatement(sql);
			st.setInt(1, productid);
			rs = st.executeQuery();

			rs.next();

				cb.setProductid(rs.getInt(1));
				cb.setShoessize(rs.getFloat(2));
				cb.setShoesname(rs.getString(3));
				cb.setShoesprice(rs.getInt(4));
				cb.setShoespicturepath(rs.getString(5));
				cb.setShoesid(rs.getInt(6));






		}catch(SQLException e){
			//ConnectionManager.getInstance("mysql").rollback();
			throw new ResourceAccessException(e.getMessage(),e);
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st != null){
    				st.close();
    			}
			}catch(SQLException e){
				throw new ResourceAccessException(e.getMessage(),e);
			}
		}
		return cb;
	}


	/*
	@Override
	public ArrayList getAllCarts() {
		PreparedStatement st = null;
		ResultSet rs = null;

		ArrayList addresses = new ArrayList();

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "select * from cart_table";
			st = cn.prepareStatement(sql);

			rs = st.executeQuery();

			while(rs.next()){
				AddressBean ab = new AddressBean();


				addresses.add(ab);
			}


		}catch(SQLException e){
			ConnectionManager.getInstance("mysql").rollback();
			throw new ResourceAccessException(e.getMessage(),e);
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st != null){
    				st.close();
    			}
			}catch(SQLException e){
				throw new ResourceAccessException(e.getMessage(),e);
			}
		}
		return addresses;
	}
	*/

	public int getCartidMax() {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;


		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "SELECT MAX(cart_id) FROM cart_table";


			st = cn.prepareStatement(sql);

			rs = st.executeQuery();

			rs.next();


			id = (rs.getInt(1)+1);
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
