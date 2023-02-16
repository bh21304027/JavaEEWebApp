package command.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.OrderBean;
import bean.ShoesProductBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.connectionmanager.ConnectionManager;
import dao.factory.AbstractDaoFactory;
import dao.order.OrderDao;
import dao.product.ProductInformationDao;

public class ShowOrderCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpSession session = req.getSession();
		String userid = (String)session.getAttribute("userid");

		ConnectionManager.getInstance("mysql").beginTransaction();
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		OrderDao od = factory.getOrderDao();
		ProductInformationDao pid = factory.getProductInformationDao();






		Map<Object,Object> resultMap = new HashMap<Object,Object>();

		ArrayList<OrderBean> list = od.getOrder(userid);

		ArrayList<Object> list2 = new ArrayList<Object>();

		for(OrderBean ob: list) {
			Map<Object,Object> orderMap = new HashMap<Object,Object>();

			int id = ob.getProductid();
			orderMap.put("orderBean", ob);

			ShoesProductBean spb = pid.getProduct(id);
			int price = ob.getCount() * spb.getShoesprice();
			System.out.print(price);
			orderMap.put("price", price);
			orderMap.put("shoesProductBean", spb);
			list2.add(orderMap);

		}

		//resultMap.put("total", total);
		//resultMap.put("count", count);
		resultMap.put("list2", list2);

		ConnectionManager.getInstance("mysql").commit();

		ConnectionManager.getInstance("mysql").closeConnection();


		resc.setResult(resultMap);
		resc.setTarget("orderlist");
		return resc;
	}

}



