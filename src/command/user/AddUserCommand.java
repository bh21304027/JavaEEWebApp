package command.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

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


		if(reqc.getParameter("userid") !=null & reqc.getParameter("username") !=null &
		   reqc.getParameter("userpass") !=null & reqc.getParameter("usergender") !=null &
		   reqc.getParameter("userdob") !=null ) {



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


			HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
			req.setAttribute("message", "登録完了[ログインしてください]");
			resc.setTarget("login");
			return resc;
		}else {
			HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
			req.setAttribute("message", "入力に不足があります。");
			resc.setTarget("signup");
			return resc;
		}
	}

}
