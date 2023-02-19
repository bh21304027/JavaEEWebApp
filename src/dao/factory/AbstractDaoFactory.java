package dao.factory;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import dao.address.AddressDao;
import dao.cart.CartDao;
import dao.order.OrderDao;
import dao.product.ProductInformationDao;
//import dao.shoes.ShoesDao;
import dao.user.UserDao;
//import dao.wishlist.WishListDao;

public abstract class AbstractDaoFactory{
    public static AbstractDaoFactory getFactory(String type){
        AbstractDaoFactory factory = null;
        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream("/home/properties/dao.properties"));

            String name = prop.getProperty(type);

            Class<?> c = Class.forName(name);
            factory = (AbstractDaoFactory)c.getDeclaredConstructor().newInstance();
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
        return factory;
    }

	public abstract UserDao getUserDao();

	public abstract AddressDao getAddressDao();
/*
	public abstract CregitDao getCregitDao();

	public abstract CategoryDao getCategoryDao();

	public abstract ShoesDao getShoesDao();

	public abstract ColorDao getColorDao();

	public abstract PictureDao getPictureDao();

	public abstract ProductDao getProductDao();
	*/

	public abstract ProductInformationDao getProductInformationDao();
	/*

	public abstract WishListDao getWishListDao();
*/
	public abstract CartDao getCartDao();

	public abstract OrderDao getOrderDao();
/*
	public abstract CartDetailDao getCartDetailDao();

	public abstract OrderDetailDao getOrderDetailDao();
	*/
}