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

public class HandleTin extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = -4014208023321206656L;
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
		return setting == 270 || setting == 300;
	}

	@Override
	public String getStatus()
	{
		return setting == 270 ? "Prospect tin" : "Mine tin";
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.HANDLE_COPPER.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		if(FCTiming.waitCondition(() -> !shouldExecute(), 6000))
			reaction.react();
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new ClickObject((setting <= 270 ? "Prospect" : "Mine"), "Rocks", new RSArea(new RSTile(3072, 9512, 0), new RSTile(3078, 9500, 0)));
	}

}
