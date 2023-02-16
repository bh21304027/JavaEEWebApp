package command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.AddressBean;
import bean.UpUserBean;
import bean.UserBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.address.AddressDao;
import dao.factory.AbstractDaoFactory;
import dao.user.UserDao;



public class InputUpdateUserCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		UserDao userdao = factory.getUserDao();
		AddressDao addressdao = factory.getAddressDao();

		HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
		HttpSession session = req.getSession();
		String  userid = (String)session.getAttribute("userid");

		UserBean userinfo = userdao.getUserInfo(userid);
		AddressBean ad = addressdao.getAddress(userid);
		UpUserBean up = new UpUserBean();
		up.setUserid(userid);
		up.setUsername(userinfo.getUsername());
		up.setUserdob(userinfo.getUserdob());
		up.setAddressid(ad.getAddressid());
		up.setAddressphonenumber(ad.getAddressphonenumber());
		up.setAddressaddress(ad.getAddressaddress());
		up.setAddresspostcode(ad.getAddresspostcode());
		up.setState(ad.getState());



		resc.setResult(up);
		resc.setTarget("updateuser");
		return resc;
	}

}
