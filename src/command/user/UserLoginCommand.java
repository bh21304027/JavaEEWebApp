package command.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;
import dao.factory.AbstractDaoFactory;
import dao.user.UserDao;

public class UserLoginCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();
		String[] userids = reqc.getParameter("userid");
		String[] userpasses = reqc.getParameter("userpass");


		String userid = userids[0];
		String userpass = userpasses[0];
		String hashuserpass = null;

		System.out.println(userid);
		System.out.println(userpass);

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

			byte[] b = userpass.getBytes();
			byte[] h = messageDigest.digest(b);
			hashuserpass = new String(h);
		} catch (NoSuchAlgorithmException e) {

		}

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory("mysql");
		UserDao userdao = factory.getUserDao();

		String[] userida = userdao.getUser(userid,hashuserpass);
		String user = userida[0];
		String username = userida[1];
		System.out.println(userida);
		//ConnectionManager.getInstance("mysql").commit();

		//ConnectionManager.getInstance("mysql").closeConnection();

		HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
		HttpSession session = req.getSession();
		session.setAttribute("userid", user);
		session.setAttribute("username", username);
		if(user !=null) {
			req.setAttribute("message", "ようこそAnodidas。");
		//session.setAttribute("productattribute", new HashMap<Object, Object>());
		resc.setTarget("welcome");
		}else {
			req.setAttribute("message", "パスワードもしくはメールアドレスが間違っています。");
			resc.setTarget("login");
		}


		return resc;
	}

}
