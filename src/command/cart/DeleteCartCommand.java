package command.cart;


import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.cart.CartDao;
import dao.connectionmanager.ConnectionManager;
import dao.factory.AbstractDaoFactory;

public class DeleteCartCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext  reqc = getRequestContext();

		String cartidss[] = reqc.getParameter("cartid");
		String cartids = cartidss[0];





		int cartid = Integer.parseInt(cartids);

		ConnectionManager.getInstance("mysql").beginTransaction();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		CartDao cd = factory.getCartDao();


		cd.deleteCart(cartid);



		ConnectionManager.getInstance("mysql").commit();
		ConnectionManager.getInstance("mysql").closeConnection();



		resc.setTargetcommand("showcart");
		return resc;
	}
}