package scripts.fc.missions.fctutorial.tasks.mining_instructor;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class HandleCopper extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = 297434712529988827L;
	private static final int ESTIMATED_WAIT = 3000;
	
	private int setting;
	private ABC2Reaction reaction = new ABC2Reaction(true, ESTIMATED_WAIT);

	@Override
	public boolean execute()
	{
		boolean success = getInteractable().execute();
		if(success)
			reaction.start();
		
		return success;
	}

	@Override
	public boolean shouldExecute()
	{
		setting = FCTutorial.getProgress();
		return setting == 280 || setting == 310;
	}

	@Override
	public String getStatus()
	{
		return setting == 280 ? "Prospect copper" : "Mine copper";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject((setting <= 280 ? "Prospect" : "Mine"), "Rocks", new RSArea(new RSTile(3081, 9505, 0), new RSTile(3087, 9495, 0)));
	}

	@Override
	public Task getNext()
	{
		setting = FCTutorial.getProgress();
		return setting <= 280 ? TutorialTask.MINING_INSTRUCTOR_DIALOGUE.TASK : TutorialTask.SMELT_ORE.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{	
		if(FCTiming.waitCondition(() -> !shouldExecute(), 6000))
			reaction.react();
	}

}
