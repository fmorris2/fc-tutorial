package scripts.fc.missions.fctutorial.tasks.quest_guide;

import org.tribot.api.Timing;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class QuestGuideLadder extends Task
{
	private static final long serialVersionUID = -1878757915046483345L;

	private ABC2Reaction reaction = new ABC2Reaction(true, 2400);
	
	@Override
	public boolean execute()
	{
		if(new ClickObject("Climb-down", "Ladder", 15).execute())
		{
			reaction.start();
			if(Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 250), 5000))
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
		return FCTutorial.getProgress() == 250;
	}

	@Override
	public String getStatus()
	{
		return "Go down ladder";
	}

}
