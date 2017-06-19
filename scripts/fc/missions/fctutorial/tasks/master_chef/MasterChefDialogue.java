package scripts.fc.missions.fctutorial.tasks.master_chef;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class MasterChefDialogue extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = 1067735338811725099L;

	@Override
	public boolean execute()
	{
		getInteractable().execute();
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 140;
	}

	@Override
	public String getStatus()
	{
		return "Master Chef dialogue";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new NpcDialogue("Talk-to", "Master Chef", 10, false, 0);
	}

}
