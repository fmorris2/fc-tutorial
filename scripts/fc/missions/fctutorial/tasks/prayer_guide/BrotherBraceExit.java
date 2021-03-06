package scripts.fc.missions.fctutorial.tasks.prayer_guide;

import org.tribot.api.Timing;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class BrotherBraceExit extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = 5202217227264072445L;

	private ABC2Reaction reaction = new ABC2Reaction(false, 2400);
	
	@Override
	public boolean execute()
	{
		if(getInteractable().execute())
		{
			reaction.start();
			if(Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 610), 3500))
				reaction.react();
		}
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 610;
	}

	@Override
	public String getStatus()
	{
		return "Click door";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject("Open", "Door", 15);
	}

}
