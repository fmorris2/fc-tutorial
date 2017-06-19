package scripts.fc.missions.fctutorial.tasks;

import org.tribot.api.Timing;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.framework.task.Task;

public class StuckChecks extends Task
{
	private static final long serialVersionUID = -4289020477017317557L;
	
	private static final RSArea ABOVE_QUEST_GUIDE = new RSArea(new RSTile(3084, 3121, 1), 10);

	@Override
	public boolean execute()
	{
		if(new ClickObject("Climb-down", "Staircase", 10).execute())
			Timing.waitCondition(FCConditions.planeChanged(Player.getPosition().getPlane()), 3500);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return ABOVE_QUEST_GUIDE.contains(Player.getPosition());
	}

	@Override
	public String getStatus()
	{
		return "Stuck checks";
	}

}
