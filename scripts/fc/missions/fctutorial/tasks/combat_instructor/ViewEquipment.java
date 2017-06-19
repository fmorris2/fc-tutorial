package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import org.tribot.api.Clicking;
import org.tribot.api.Timing;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterface;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class ViewEquipment extends Task
{
	private static final long serialVersionUID = 7438057261786233107L;
	private static final int EQUIP_BUTTON_MASTER = 387;
	private static final int EQUIP_BUTTON_CHILD = 17;
	public static final int EQUIP_SCREEN_MASTER = 84;
	public static final int EQUIP_SCREEN_CLOSE_CHILD = 4;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.EQUIPMENT);
		
		RSInterface equipMaster = Interfaces.get(EQUIP_BUTTON_MASTER);
		RSInterface equipButton = equipMaster == null ? null : equipMaster.getChild(EQUIP_BUTTON_CHILD);
		
		if(equipButton != null && Clicking.click(equipButton))
			Timing.waitCondition(FCConditions.interfaceUp(EQUIP_SCREEN_MASTER), 4500);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		final int SETTING = FCTutorial.getProgress();
		
		return SETTING == 400 || (SETTING == 405 && Interfaces.get(EQUIP_SCREEN_MASTER) == null);
	}

	@Override
	public String getStatus()
	{
		return "View equipment";
	}

}
