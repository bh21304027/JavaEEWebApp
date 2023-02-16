package command.product;

import java.util.ArrayList;

import bean.ShoesProductBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.connectionmanager.ConnectionManager;
import dao.factory.AbstractDaoFactory;
import dao.product.ProductInformationDao;

public class ShowProductDetailsCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		//ArrayList list = new ArrayList();

		String[] shoesids = reqc.getParameter("shoesid");
		int shoesid = Integer.parseInt(shoesids[0]);



		ConnectionManager.getInstance("mysql").beginTransaction();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		ProductInformationDao pid = factory.getProductInformationDao();
		ArrayList<ShoesProductBean> list = pid.getProductSizeStock(shoesid);

		ConnectionManager.getInstance("mysql").commit();

		ConnectionManager.getInstance("mysql").closeConnection();

		resc.setResult(list);
		resc.setTarget("showproduct");
		return resc;
	}

}
