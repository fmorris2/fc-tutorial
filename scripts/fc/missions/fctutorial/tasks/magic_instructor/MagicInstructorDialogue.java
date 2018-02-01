package scripts.fc.missions.fctutorial.tasks.magic_instructor;

import org.tribot.api2007.Player;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class MagicInstructorDialogue extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = -2871454659516233306L;

	@Override
	public boolean execute()
	{
		getInteractable().execute();
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		final int SETTING = FCTutorial.getProgress();
		return (SETTING == 620 && Player.getPosition().distanceTo(WalkToMagicInstructor.TARGET) <= WalkToMagicInstructor.THRESHOLD) 
					|| SETTING == 640 || SETTING == 670;
	}

	@Override
	public String getStatus()
	{
		return "Magic Instructor dialogue";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		NpcDialogue n = new NpcDialogue("Talk-to", "Magic Instructor", 30, 0,1);
		n.setWalkToPos(false);
		n.setCheckPath(false);
		
		return n;
	}

}
