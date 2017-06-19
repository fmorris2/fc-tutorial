package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import org.tribot.api.Timing;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class CombatInstructorExit extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = -3730419609801977185L;

	@Override
	public boolean execute()
	{
		if(getInteractable().execute())
			return Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 500), 7500);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 500;
	}

	@Override
	public String getStatus()
	{
		return "Click ladder";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject("Climb-up", "Ladder", 20);
	}

}
