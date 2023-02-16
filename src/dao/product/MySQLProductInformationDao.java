package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ShoesBean;
import bean.ShoesProductBean;
import dao.connectionmanager.ConnectionManager;
import exp.ResourceAccessException;

public class MySQLProductInformationDao implements ProductInformationDao {

	//済み
	@Override
	public ArrayList<ShoesBean> getProductListInformation() {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<ShoesBean> ShoesList = new ArrayList<ShoesBean>();

		try{
			cn = ConnectionManager.getInstance("mysql").getConnection();

			String sql = "select * from shoes_table";
			st = cn.prepareStatement(sql);

			rs = st.executeQuery();

			while(rs.next()){
				ShoesBean sb = new ShoesBean();

				sb.setShoesid(rs.getInt(1));
				sb.setShoesname(rs.getString(2));
				sb.setShoesprice(rs.getInt(3));
				sb.setCategoryid(rs.getInt(4));
				sb.setShoespicture(rs.getString(6));


				ShoesList.add(sb);
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
		return ShoesList;
	}



	//済み
	@Override
	public ArrayList<ShoesProductBean> getProductSizeStock(int shoesid) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		ArrayList<ShoesProductBean> list = new ArrayList<ShoesProductBean>();



		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "select shoes.shoes_id,shoes.shoes_name,shoes.shoes_price,shoes.category_id,shoes.shoes_gender,shoes.shoes_picturepath, product.Product_stock,product.shoes_size,product_id from shoes_table shoes \r\n"
					+ "inner join product_table product on shoes.shoes_id = product.shoes_id where product.shoes_id = ?";
			st = cn.prepareStatement(sql);
			st.setInt(1, shoesid);

			rs = st.executeQuery();
			while(rs.next()) {
				ShoesProductBean sp = new ShoesProductBean();
					System.out.println(rs.getFloat(8));
				sp.setShoesid(rs.getInt(1));
				sp.setShoesname(rs.getString(2));
				sp.setShoesprice(rs.getInt(3));
				sp.setCategoryid(rs.getInt(4));
				sp.setShoesgender(rs.getInt(5));
				sp.setShoespicture(rs.getString(6));
				sp.setShoesstock(rs.getInt(7));
				sp.setShoessize(rs.getFloat(8));
				sp.setProductid(rs.getInt(9));
			list.add(sp);
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


	//済
	@Override
	public ArrayList<ShoesBean> getProductListInformation(int gender) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		ArrayList<ShoesBean> ShoesList = new ArrayList<ShoesBean>();




		try{
			cn = ConnectionManager.getInstance("mysql").getConnection();


				String sql = "select * from shoes_table where shoes_gender = ?";

				st = cn.prepareStatement(sql);

			st.setInt(1,gender);

			rs = st.executeQuery();

			while(rs.next()){
				ShoesBean sb = new ShoesBean();

				sb.setShoesid(rs.getInt(1));
				sb.setShoesname(rs.getString(2));
				sb.setShoesprice(rs.getInt(3));
				sb.setCategoryid(rs.getInt(4));
				sb.setShoespicture(rs.getString(6));


				ShoesList.add(sb);
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
		return ShoesList;
	}





	//済
	@Override
	public ArrayList<ShoesBean> getProductListInformation(int gender,int category) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		ArrayList<ShoesBean> ShoesList = new ArrayList<ShoesBean>();




		try{
			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "select * from shoes_table where shoes_gender = ? AND Category_id = ?";

			st = cn.prepareStatement(sql);

			st.setInt(1,gender);
			st.setInt(2,category);

			rs = st.executeQuery();

			while(rs.next()){
				ShoesBean sb = new ShoesBean();

				sb.setShoesid(rs.getInt(1));
				sb.setShoesname(rs.getString(2));
				sb.setShoesprice(rs.getInt(3));
				sb.setCategoryid(rs.getInt(4));
				sb.setShoespicture(rs.getString(6));


				ShoesList.add(sb);
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
		return ShoesList;
	}



	//未
	@Override
	public ShoesProductBean getProduct(int productid) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ShoesProductBean sp = new ShoesProductBean();

		//ArrayList<ShoesProductBean> list = new ArrayList<ShoesProductBean>();



		try{

			cn = ConnectionManager.getInstance("mysql").getConnection();


			String sql = "select s.shoes_id,s.shoes_name,s.shoes_price,s.category_id,s.shoes_gender,s.shoes_picturepath, p.Product_stock,p.shoes_size,p.product_id from shoes_table s join product_table p on s.shoes_id = p.shoes_id where p.product_id = ?";
			st = cn.prepareStatement(sql);
			st.setInt(1, productid);

			rs = st.executeQuery();
			while(rs.next()) {

					System.out.println(rs.getFloat(8));
				sp.setShoesid(rs.getInt(1));
				sp.setShoesname(rs.getString(2));
				sp.setShoesprice(rs.getInt(3));
				sp.setCategoryid(rs.getInt(4));
				sp.setShoesgender(rs.getInt(5));
				sp.setShoespicture(rs.getString(6));
				sp.setShoesstock(rs.getInt(7));
				sp.setShoessize(rs.getFloat(8));
				sp.setProductid(rs.getInt(9));
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
		return sp;
	}

}