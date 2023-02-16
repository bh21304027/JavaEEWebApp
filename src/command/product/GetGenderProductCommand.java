package command.product;

import java.util.ArrayList;

import bean.ShoesBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.connectionmanager.ConnectionManager;
import dao.factory.AbstractDaoFactory;
import dao.product.ProductInformationDao;

public class GetGenderProductCommand extends AbstractCommand {
	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		String[] genders = reqc.getParameter("gender");
		int gender = Integer.parseInt(genders[0]);





		System.out.println(gender);

		ConnectionManager.getInstance("mysql").beginTransaction();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		ProductInformationDao pid = factory.getProductInformationDao();
		ArrayList<ShoesBean> list = pid.getProductListInformation(gender);

		ConnectionManager.getInstance("mysql").commit();

		ConnectionManager.getInstance("mysql").closeConnection();




		resc.setResult(list);
		resc.setTarget("showlist");
		return resc;
	}

}
