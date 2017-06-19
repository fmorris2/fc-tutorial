package scripts.fc.missions.fctutorial.tasks.prayer_guide;

import org.tribot.api2007.Player;

import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class BrotherBraceDialogue extends AnticipativeTask
{
	private static final long serialVersionUID = 3105566098270435996L;

	@Override
	public boolean execute()
	{ 
		final int PROGRESS = FCTutorial.getProgress();
		if(PROGRESS == 600)
		{
			new NpcDialogue("Talk-to", "Brother Brace", 15, false, 0).execute();
			return true;
		}
		else
			new NpcDialogue("Talk-to", "Brother Brace", 15, 0).execute();
		
		return !shouldExecute();
	}

	@Override
	public boolean shouldExecute()
	{
		final int PROGRESS = FCTutorial.getProgress();
		return (PROGRESS == 550 && Player.getPosition().distanceTo(WalkToBrotherBrace.TARGET_TILE) <= WalkToBrotherBrace.DISTANCE_THRESHOLD) 
					|| PROGRESS == 570 || PROGRESS == 600; 
	}

	@Override
	public String getStatus()
	{
		return "Brother Brace dialogue";
	}

	@Override
	public Task getNext()
	{
		return FCTutorial.getProgress() == 600 ? TutorialTask.BROTHER_BRACE_EXIT.TASK : null;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 5000);
	}

}
