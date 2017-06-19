package scripts.fc.missions.fctutorial.tasks.runescape_guide;

import org.tribot.api.General;
import org.tribot.api2007.Game;

import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class RunescapeGuideDialogue extends AnticipativeTask
{
	private static final long serialVersionUID = -7875730470627555141L;

	@Override
	public boolean execute()
	{
		return new NpcDialogue("Talk-to", "Runescape Guide", 15, General.random(0, 2)).execute();
	}

	@Override
	public boolean shouldExecute()
	{
		return (FCTutorial.getProgress() == 0 && Game.getSetting(22) > 0)
				|| FCTutorial.getProgress() == 7;
	}

	@Override
	public String getStatus()
	{
		return "Runescape Guide Dialogue";
	}

	@Override
	public Task getNext()
	{
		return FCTutorial.getProgress() == 7 ? TutorialTask.RS_GUIDE_DOOR.TASK : null;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 6000);
	}

}
