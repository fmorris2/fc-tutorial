package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class EquipmentTab extends Task
{
	private static final long serialVersionUID = 3099457114228432195L;

	@Override
	public boolean execute()
	{
		GameTab.open(TABS.EQUIPMENT);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 390;
	}

	@Override
	public String getStatus()
	{
		return "Equipment tab";
	}

}
