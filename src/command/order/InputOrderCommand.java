package command.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.CartsBean;
import bean.ShoesProductBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.cart.CartDao;
import dao.connectionmanager.ConnectionManager;
import dao.factory.AbstractDaoFactory;
import dao.order.OrderDao;
import dao.product.ProductInformationDao;

public class InputOrderCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext  reqc = getRequestContext();




		if(reqc.getParameter("phone")[0].isEmpty() || reqc.getParameter("code")[0].isEmpty() || reqc.getParameter("address")[0].isEmpty() ) {



			HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
			req.setAttribute("message", "入力に不足があります。");
			resc.setTargetcommand("ordercomf");
			return resc;
		}else {
						String message = "";


						HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
						HttpSession session = req.getSession();


						String userid = (String)session.getAttribute("userid");




						ConnectionManager.getInstance("mysql").beginTransaction();

					AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
					OrderDao orderdao = factory.getOrderDao();
					CartDao cartdao = factory.getCartDao();
					ProductInformationDao pinfodao = factory.getProductInformationDao();
					ArrayList<CartsBean> list = cartdao.getCart(userid);



					for(CartsBean cart: list) {


						int id = cart.getProductid();

						int count = cart.getCount();


						ShoesProductBean spb = pinfodao.getProduct(id);

						if(spb.getShoesstock()>= count) {

						//CartBean cbs = cartdao.getCartProduct(id);
						pinfodao.upProductCount(id, spb.getShoesstock()-count);
						orderdao.addOrder(id, count, userid);
						System.out.println(id+count);
						message += spb.getShoesname()+"注文完了<br>";

						}else {
							message += spb.getShoesname()+"在庫不足のため注文できませんでした<br>";



						}
					}
					cartdao.deleteUserCart(userid);



					ConnectionManager.getInstance("mysql").commit();

					ConnectionManager.getInstance("mysql").closeConnection();

						req.setAttribute("message", message);

						resc.setTarget("welcome");
						return resc;




		}
	}
}
