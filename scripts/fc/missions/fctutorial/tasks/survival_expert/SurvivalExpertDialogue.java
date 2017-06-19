package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api2007.Game;
import org.tribot.api2007.Options;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class SurvivalExpertDialogue extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = 7533640471665342842L;

	@Override
	public boolean execute()
	{
		if(!Game.isRunOn())
			Options.setRunOn(true);
		
		return getInteractable().execute();
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 20 || FCTutorial.getProgress() == 70;
	}

	@Override
	public String getStatus()
	{
		return "Survival Expert dialogue";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new NpcDialogue("Talk-to", "Survival Expert", 30, (FCTutorial.getProgress() == 70 ? false : true), 0);
	}

	@Override
	public Task getNext()
	{
		return FCTutorial.getProgress() == 70 ? TutorialTask.FISH_SHRIMPS.TASK : null;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 6000);
	}

}
