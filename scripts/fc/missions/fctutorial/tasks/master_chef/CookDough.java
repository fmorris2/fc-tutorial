package scripts.fc.missions.fctutorial.tasks.master_chef;

import org.tribot.api.Timing;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ItemOnObject;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class CookDough extends Task
{
	private static final long serialVersionUID = -1265625303285280482L;

	@Override
	public boolean execute()
	{
		if(new ItemOnObject("Use", "Range", "Bread dough", 10).execute() && Timing.waitCondition(FCConditions.animationChanged(-1), 6000))
				Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 160), 5000);
		
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 160;
	}

	@Override
	public String getStatus()
	{
		return "Cook dough";
	}

}
