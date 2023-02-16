package dao.factory;


import dao.address.AddressDao;
import dao.address.MySQLAddressDao;
import dao.cart.CartDao;
import dao.cart.MySQLCartDao;
import dao.order.MySQLOrderDao;
import dao.order.OrderDao;
import dao.product.MySQLProductInformationDao;
import dao.product.ProductInformationDao;
/*
import dao.cart.CartDao;
import dao.cart.MySQLCartDao;
import dao.cartdetail.CartDetailDao;
import dao.cartdetail.MySQLCartDetailDao;
import dao.category.CategoryDao;
import dao.category.MySQLCategoryDao;
import dao.color.ColorDao;
import dao.color.MySQLColorDao;
import dao.cregit.CregitDao;
import dao.cregit.MySQLCregitDao;
import dao.order.MySQLOrderDao;
import dao.order.OrderDao;
import dao.orderdetail.MySQLOrderDetailDao;
import dao.orderdetail.OrderDetailDao;
import dao.picture.MySQLPictureDao;
import dao.picture.PictureDao;
import dao.product.MySQLProductDao;
import dao.product.MySQLProductInformationDao;
import dao.product.ProductDao;
import dao.product.ProductInformationDao;
import dao.shoes.MySQLShoesDao;
import dao.shoes.ShoesDao;
*/
import dao.user.MySQLUserDao;
import dao.user.UserDao;

/*
import dao.wishlist.MySQLWishListDao;
import dao.wishlist.WishListDao;
*/
public class MySQLDaoFactory extends AbstractDaoFactory {
	/*
	public ProductDao getProductDao(){
		return new MySQLProductDao();
	}
*/
	public ProductInformationDao getProductInformationDao() {
		return new MySQLProductInformationDao();
	}

	public AddressDao getAddressDao(){
		return new MySQLAddressDao();
	}

	public CartDao getCartDao(){
		return new MySQLCartDao();
	}

/*
	public CartDetailDao getCartDetailDao(){
		return new MySQLCartDetailDao();
	}


	public CategoryDao getCategoryDao(){
		return new MySQLCategoryDao();
	}


	public ColorDao getColorDao(){
		return new MySQLColorDao();
	}


	public CregitDao getCregitDao(){
		return new MySQLCregitDao();
	}


	public OrderDetailDao getOrderDetailDao(){
		return new MySQLOrderDetailDao();
	}

*/
	public OrderDao getOrderDao(){
		return new MySQLOrderDao();
	}

/*
	public PictureDao getPictureDao(){
		return new MySQLPictureDao();
	}


	public ShoesDao getShoesDao(){
		return new MySQLShoesDao();
	}
*/

	public UserDao getUserDao(){
		return new MySQLUserDao();
	}

/*
	public WishListDao getWishListDao(){
		return new MySQLWishListDao();
	}
*/
}