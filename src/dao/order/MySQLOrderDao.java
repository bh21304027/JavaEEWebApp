package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.OrderBean;
import dao.connectionmanager.ConnectionManager;
import exp.ResourceAccessException;

public class MySQLOrderDao implements OrderDao {

	@Override
	public void addOrder(int productid,int count,String userid) {
		PreparedStatement st = null;

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "insert into order_table(Order_id,Order_date,User_id,Product_id,Cartdetail_purchase_quantity) values(?,cast(now() as date),?,?,?)";
			st = cn.prepareStatement(sql);

				st.setInt(1, getOrderidMax());

				st.setString(2, userid);
				st.setInt(3, productid);
				st.setInt(4, count);


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

	@Override
	public void updateOrder(OrderBean o){
		PreparedStatement st = null;

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "update order_table set order_total = ?,order_delivery_date = ? where user_id = ?";
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

	@Override
	public void deleteOrder(String userid,String orderid){
		PreparedStatement st = null;

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "delete from order_table where order_id = ? and user_id = ?";
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

	@Override
	public void deleteUserOrder(String userid){
		PreparedStatement st = null;

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "delete from order_table where user_id = ?";//delete文
			st = cn.prepareStatement(sql);

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
	public ArrayList<OrderBean> getOrder(String userid) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<OrderBean> OrderList = new ArrayList<OrderBean>();

		try{
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "select * from order_table where user_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, userid);
			rs = st.executeQuery();

			while(rs.next()) {
				OrderBean ob = new OrderBean();
				ob.setOrderid(rs.getInt(1));
				ob.setOrderdate(rs.getString(2));
				ob.setUserid(rs.getString(3));
				ob.setProductid(rs.getInt(4));
				ob.setCount(rs.getInt(5));

				OrderList.add(ob);
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
		return OrderList;
	}



	/*
	@Override
	public ArrayList getAllOrders() {
		PreparedStatement st = null;
		ResultSet rs = null;

		ArrayList orders = new ArrayList();

		try{
			Connection cn = null;
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "select * from order_table";
			st = cn.prepareStatement(sql);

			rs = st.executeQuery();

			while(rs.next()){
				OrderBean ob = new OrderBean();


				orders.add(ob);
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
		return orders;
	}
*/

	public int getOrderidMax() {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;


		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();
			cn.setAutoCommit(false);


			String sql = "SELECT MAX(Order_id) FROM order_table";


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


