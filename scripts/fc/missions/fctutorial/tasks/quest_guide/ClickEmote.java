package scripts.fc.missions.fctutorial.tasks.quest_guide;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterface;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class ClickEmote extends Task
{
	private static final long serialVersionUID = -892318255408849103L;
	
	private static final int INTERFACE_MASTER = 320;
	private static final int INTERFACE_CHILD = General.random(1, 24);

	@Override
	public boolean execute()
	{
		doEmote();
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 187;
	}

	@Override
	public String getStatus()
	{
		return "Click emote";
	}
	
	private void doEmote()
	{
		RSInterface inter = Interfaces.get(INTERFACE_MASTER, INTERFACE_CHILD);
		
		if(Clicking.click(inter))
			Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 187), 3000);
	}

}
