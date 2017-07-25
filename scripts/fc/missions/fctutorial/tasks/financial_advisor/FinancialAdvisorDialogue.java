package scripts.fc.missions.fctutorial.tasks.financial_advisor;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.AnticipativeTask;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;
import scripts.fc.missions.fctutorial.tasks.TutorialTask;

public class FinancialAdvisorDialogue extends AnticipativeTask implements PredictableInteraction
{
	private static final long serialVersionUID = 6700614689780576513L;

	@Override
	public boolean execute()
	{
		return getInteractable().execute();
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 530;
	}

	@Override
	public String getStatus()
	{
		return "Financial Advisor Dialogue";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		NpcDialogue dialogue = new NpcDialogue("Talk-to", "Financial Advisor", 15, false, 0);
		dialogue.setCheckPath(true);
		return dialogue;
	}

	@Override
	public Task getNext()
	{
		return TutorialTask.FINANCIAL_ADVISOR_EXIT.TASK;
	}

	@Override
	public void waitForTaskComplete()
	{
		FCTiming.waitCondition(() -> !shouldExecute(), 6000);
	}

}
