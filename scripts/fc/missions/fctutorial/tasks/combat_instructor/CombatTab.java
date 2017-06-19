package scripts.fc.missions.fctutorial.tasks.combat_instructor;

import org.tribot.api.General;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class CombatTab extends Task
{
	private static final long serialVersionUID = 5360167541732055017L;

	@Override
	public boolean execute()
	{
		if(GameTab.open(TABS.COMBAT))
			General.sleep(1000, 3000);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 430;
	}

	@Override
	public String getStatus()
	{
		return "Click combat tab";
	}

}
