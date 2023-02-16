package command.user;

import command.AbstractCommand;
import context.ResponseContext;

public class InputUserLoginCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("login");
		return resc;
	}

}
