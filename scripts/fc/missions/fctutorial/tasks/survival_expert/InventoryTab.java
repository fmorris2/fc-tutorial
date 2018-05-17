package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api.Clicking;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.types.RSInterface;

import scripts.fc.api.utils.InterfaceUtils;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class InventoryTab extends Task
{
	private static final long serialVersionUID = -4786621914246842238L;

	@Override
	public boolean execute()
	{
		RSInterface clickToCont = InterfaceUtils.findContainingText("Click here to continue");
		if(clickToCont != null)
			Clicking.click(clickToCont);
		
		
		return GameTab.open(TABS.INVENTORY);
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 30;
	}

	@Override
	public String getStatus()
	{
		return "Inventory tab";
	}

}
