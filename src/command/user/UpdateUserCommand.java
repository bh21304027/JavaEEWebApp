package command.user;

import javax.servlet.http.HttpServletRequest;

import bean.AddressBean;
import bean.UserBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.address.AddressDao;
import dao.factory.AbstractDaoFactory;
import dao.user.UserDao;

public class UpdateUserCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		UserBean u = new UserBean();

		u.setUserid(reqc.getParameter("userid")[0]);
		u.setUsername(reqc.getParameter("username")[0]);
		u.setUserdob(reqc.getParameter("userdob")[0]);


		AddressBean a = new AddressBean();

		a.setAddressid(Integer.parseInt(reqc.getParameter("addressid")[0]));
		a.setAddressphonenumber(reqc.getParameter("phonenumber")[0]);
		a.setAddressaddress(reqc.getParameter("address")[0]);
		a.setAddresspostcode(reqc.getParameter("postcode")[0]);
		a.setUserid(reqc.getParameter("userid")[0]);
		a.setState(Boolean.valueOf(reqc.getParameter("state")[0]));


		if(reqc.getParameter("phonenumber")[0].isEmpty() ||
			reqc.getParameter("address")[0].isEmpty() || reqc.getParameter("postcode")[0].isEmpty() )
			{


			HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
			req.setAttribute("message", "入力に不足があります。");
			resc.setTargetcommand("inputupdateuser");
			return resc;


			}else {






		//ConnectionManager.getInstance("mysql").beginTransaction();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		UserDao userdao = factory.getUserDao();
		AddressDao addressdao = factory.getAddressDao();
		userdao.updateUser(u);
		addressdao.updateOrAddAddress(a);

		//ConnectionManager.getInstance("mysql").commit();

		//ConnectionManager.getInstance("mysql").closeConnection();
		HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
		req.setAttribute("message", "ユーザー更新完了");
		resc.setTarget("welcome");
		return resc;




	}
	}

}
