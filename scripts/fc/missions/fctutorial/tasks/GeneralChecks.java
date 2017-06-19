package scripts.fc.missions.fctutorial.tasks;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterface;

import scripts.fc.framework.task.Task;

public class GeneralChecks extends Task
{
	private static final long serialVersionUID = -8065901942838995357L;
	private final int CLICK_CONTINUE_MASTER = 162;
	private final int CLICK_CONTINUE_CHILD = 33;
	private final int LOGS_MESSAGE = 193;
	private final int LOGS_CHILD = 2;
	
	private RSInterface inter;
	

	@Override
	public boolean execute()
	{
		General.sleep(600, 1500);
		Clicking.click(inter);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		inter = Interfaces.get(CLICK_CONTINUE_MASTER, CLICK_CONTINUE_CHILD);
		
		if(inter == null || inter.isHidden())
			inter = Interfaces.get(LOGS_MESSAGE, LOGS_CHILD);
		
		return inter != null && !inter.isHidden();
	}

	@Override
	public String getStatus()
	{
		return "General checks";
	}

}
