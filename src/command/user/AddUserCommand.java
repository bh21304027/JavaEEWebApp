package command.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import bean.UserBean;
import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.factory.AbstractDaoFactory;
import dao.user.UserDao;

public class AddUserCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		String[] useridｓ = reqc.getParameter("userid");
		String[] usernames = reqc.getParameter("username");
		String[] userpasses = reqc.getParameter("userpass");
		String[] usergenders = reqc.getParameter("usergender");
		String[] userdobs = reqc.getParameter("userdob");



		UserBean u = new UserBean();
		String userpass = userpasses[0];
		String hashuserpass = null;

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

			byte[] b = userpass.getBytes();
			byte[] h = messageDigest.digest(b);
			hashuserpass = new String(h);
		} catch (NoSuchAlgorithmException e) {

		}
		u.setUserid(useridｓ[0]);
		u.setUsername(usernames[0]);
		u.setUserpass(hashuserpass);
		u.setUsergender(Integer.parseInt(usergenders[0]));
		u.setUserdob(userdobs[0]);



			AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
			UserDao userdao = factory.getUserDao();


			userdao.addUser(u);



			//string userid = userdao.getUser(useridｓ [0],hashuserpass);


			//HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
			//HttpSession session = req.getSession();
			//session.setAttribute("userid", userid);



		resc.setTarget("top");
		return resc;
	}

}
