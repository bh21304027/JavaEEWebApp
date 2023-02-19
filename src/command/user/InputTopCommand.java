package command.user;

import java.util.ArrayList;
import java.util.Random;

import bean.ShoesBean;
import command.AbstractCommand;
//import context.RequestContext;
import context.ResponseContext;
import dao.connectionmanager.ConnectionManager;
import dao.factory.AbstractDaoFactory;
import dao.product.ProductInformationDao;

public class InputTopCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		//RequestContext reqc = getRequestContext();
		ArrayList<ShoesBean> list= new ArrayList<>();

		ConnectionManager.getInstance("mysql").beginTransaction();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		ProductInformationDao pid = factory.getProductInformationDao();


		Random r = new Random();
		for(int i = 0;i < 4; i++) {

			int randomvalue=r.nextInt(24)+1;



			ShoesBean sb = pid.getProductListInformationRandom(randomvalue);


		list.add(sb);
		}
		ConnectionManager.getInstance("mysql").commit();

		ConnectionManager.getInstance("mysql").closeConnection();

		resc.setResult(list);


		resc.setTarget("top");
		return resc;
	}

}