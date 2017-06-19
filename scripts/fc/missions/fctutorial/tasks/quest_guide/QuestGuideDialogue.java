package scripts.fc.missions.fctutorial.tasks.quest_guide;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class QuestGuideDialogue extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = 8079259777220217093L;

	@Override
	public boolean execute()
	{
		getInteractable().execute();
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 220 || FCTutorial.getProgress() == 240;
	}

	@Override
	public String getStatus()
	{
		return "Quest Guide dialogue";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new NpcDialogue("Talk-to", "Quest Guide", 15, false, 0);
	}

}
