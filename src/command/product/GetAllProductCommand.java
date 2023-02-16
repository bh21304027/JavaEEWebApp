package command.product;

import java.util.ArrayList;

import bean.ShoesBean;
import command.AbstractCommand;
import context.ResponseContext;
import dao.connectionmanager.ConnectionManager;
import dao.factory.AbstractDaoFactory;
import dao.product.ProductInformationDao;

public class GetAllProductCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		ConnectionManager.getInstance("mysql").beginTransaction();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		ProductInformationDao pid = factory.getProductInformationDao();
		ArrayList<ShoesBean> list = pid.getProductListInformation();

		ConnectionManager.getInstance("mysql").commit();

		ConnectionManager.getInstance("mysql").closeConnection();



		resc.setResult(list);
		resc.setTarget("showlist");
		return resc;
	}

}
