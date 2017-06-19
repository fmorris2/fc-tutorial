package scripts.fc.missions.fctutorial.tasks.financial_advisor;

import org.tribot.api.Timing;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class FinancialAdvisorExit extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = 2230767898462128069L;

	@Override
	public boolean execute()
	{
		if(getInteractable().execute())
			Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 540), 3500);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 540;
	}

	@Override
	public String getStatus()
	{
		return "Click door";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject("Open", "Door", new RSArea(new RSTile(3129, 3125, 0), new RSTile(3130, 3123, 0)));
	}

}
