package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import org.tribot.api.Clicking;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterface;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.framework.task.PredictableInteraction;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class CombatInstructorDialogue extends Task implements PredictableInteraction
{
	private static final long serialVersionUID = -8348433102917902057L;

	@Override
	public boolean execute()
	{
		RSInterface equipScreen = Interfaces.get(ViewEquipment.EQUIP_SCREEN_MASTER);
		RSInterface closeButton = equipScreen == null ? null : equipScreen.getChild(ViewEquipment.EQUIP_SCREEN_CLOSE_CHILD);
		
		if(closeButton != null)
			Clicking.click(closeButton);
		
		NpcDialogue dialogue = (NpcDialogue)getInteractable();
		dialogue.setCheckPath(true);
		dialogue.execute();
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		final int SETTING = FCTutorial.getProgress();
		return SETTING == 370 || SETTING == 410 || SETTING == 470;
	}

	@Override
	public String getStatus()
	{
		return "Combat Instructor dialogue";
	}

	@Override
	public EntityInteraction getInteractable()
	{
		return new NpcDialogue("Talk-to", "Combat Instructor", 20, 0);
	}
}
