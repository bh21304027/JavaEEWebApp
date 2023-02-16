package command.user;

import command.AbstractCommand;
import context.ResponseContext;

public class InputTopCommand extends AbstractCommand{

	@Override
	public ResponseContext execute(ResponseContext resc) {
		//RequestContext reqc = getRequestContext();

		//HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		//HttpSession session = req.getSession();

		//session.invalidate();
		resc.setTarget("top");
		return resc;
	}

}
