package scripts.fc.missions.fctutorial.tasks.master_chef;

import org.tribot.api.Timing;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ItemOnObject;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class CookDough extends Task
{
	private static final long serialVersionUID = -1265625303285280482L;
	
	private ABC2Reaction reaction = new ABC2Reaction(true, 3500);
	
	@Override
	public boolean execute()
	{
		if(new ItemOnObject("Use", "Range", "Bread dough", 10).execute())
		{
			reaction.start();
			if(Timing.waitCondition(FCConditions.animationChanged(-1), 6000) 
					&& Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 160), 5000))
			{
				reaction.react();
				return true;
			}
		}
		
		
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
