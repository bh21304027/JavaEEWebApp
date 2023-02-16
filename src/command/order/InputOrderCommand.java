package command.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.CartsBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.cart.CartDao;
import dao.factory.AbstractDaoFactory;
import dao.order.OrderDao;

public class InputOrderCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
		HttpSession session = req.getSession();


		String userid = (String)session.getAttribute("userid");

	AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
	OrderDao orderdao = factory.getOrderDao();
	CartDao cartdao = factory.getCartDao();
	ArrayList<CartsBean> list = cartdao.getCart(userid);



	for(CartsBean cart: list) {


		int id = cart.getProductid();

		int count = cart.getCount();
		//CartBean cbs = cartdao.getCartProduct(id);
		orderdao.addOrder(id, count, userid);
		System.out.println(id+count);




	}
	cartdao.deleteUserCart(userid);



		resc.setTarget("top");
		return resc;
	}

}
