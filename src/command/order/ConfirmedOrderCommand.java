package command.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.AddressBean;
import bean.CartBean;
import bean.CartsBean;
import bean.UserBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.address.AddressDao;
import dao.cart.CartDao;
import dao.connectionmanager.ConnectionManager;
import dao.factory.AbstractDaoFactory;
import dao.user.UserDao;

public class ConfirmedOrderCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();
		HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
		HttpSession session = req.getSession();


	String	userid = (String)session.getAttribute("userid");

	ConnectionManager.getInstance("mysql").beginTransaction();

	AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
	AddressDao addressdao = factory.getAddressDao();
	CartDao cd = factory.getCartDao();
	UserDao ud = factory.getUserDao();


	Map<Object,Object> resultMap = new HashMap<Object,Object>();

	AddressBean ab = addressdao.getAddress(userid);
	ArrayList<CartsBean> list = cd.getCart(userid);
	UserBean ub = ud.getUserInfo(userid);

	ArrayList<Object> list2 = new ArrayList<Object>();
	int total = 0;
	int count = 0;
	for(CartsBean cart: list) {
		Map<Object,Object> cartMap = new HashMap<Object,Object>();

		int id = cart.getProductid();
		cartMap.put("cartBean", cart);

		CartBean cbs = cd.getCartProduct(id);
		total +=cbs.getShoesprice()*cart.getCount();
		count +=cart.getCount();
		cartMap.put("cartsBean", cbs);

		list2.add(cartMap);

	}

	resultMap.put("total", total);
	resultMap.put("count", count);
	resultMap.put("list2", list2);
	resultMap.put("AddressBean", ab);
	resultMap.put("UserBean", ub);


	//ConnectionManager.getInstance("mysql").commit();

	ConnectionManager.getInstance("mysql").closeConnection();


	resc.setResult(resultMap);

	resc.setTarget("order");

		return resc;
	}

}
