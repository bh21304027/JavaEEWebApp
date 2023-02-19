package command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import command.AbstractCommand;
import context.RequestContext;
import context.ResponseContext;

public class UserLogoutCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
		HttpSession session = req.getSession();

		session.invalidate();
		req.setAttribute("message", "ログアウトしました。ゲストになります。");
		resc.setTarget("welcome");
		return resc;
	}

}
