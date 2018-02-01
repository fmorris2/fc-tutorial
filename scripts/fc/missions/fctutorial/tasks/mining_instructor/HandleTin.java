package scripts.fc.missions.fctutorial.tasks.mining_instructor;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.utils.InterfaceUtils;
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
	private static final String CHATBOX_INTER_MSG = "So now you know there's copper in the brown rocks,";
	
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
		return shouldProspect() || setting == 300;
	}
	
	private boolean shouldProspect() {
		return setting == 270 || InterfaceUtils.findContainingText(CHATBOX_INTER_MSG) != null;
	}

	@Override
	public String getStatus()
	{
		return shouldProspect() ? "Prospect tin" : "Mine tin";
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
		return new ClickObject((shouldProspect() ? "Prospect" : "Mine"), "Rocks", new RSArea(new RSTile(3072, 9512, 0), new RSTile(3078, 9500, 0)));
	}

}
