package command.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.CartsBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.cart.CartDao;
import dao.connectionmanager.ConnectionManager;
import dao.factory.AbstractDaoFactory;

public class AddProductCartCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext  reqc = getRequestContext();

		String[] productids = reqc.getParameter("productid");
		String[] kos = reqc.getParameter("kosuu");

		int kosuu = Integer.parseInt(kos[0]);
		int productid = Integer.parseInt(productids[0]);



		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		String userid = (String)session.getAttribute("userid");


		CartsBean cbs = new CartsBean();
		cbs.setUserid(userid);
		cbs.setProductid(productid);
		cbs.setCount(kosuu);

		ConnectionManager.getInstance("mysql").beginTransaction();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		CartDao cd = factory.getCartDao();

		cd.addCart(cbs);


		ConnectionManager.getInstance("mysql").commit();
		ConnectionManager.getInstance("mysql").closeConnection();





		resc.setTargetcommand("showcart");
		return resc;
	}

}