package command.user;

import command.AbstractCommand;
import context.ResponseContext;

public class InputUserSignUpCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {

		resc.setTarget("signup");
		return resc;
	}

}
