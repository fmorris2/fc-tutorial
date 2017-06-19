package scripts.fc.missions.fctutorial.tasks.survival_expert;

import org.tribot.api.Clicking;
import org.tribot.api.input.Mouse;
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
		
		
		Mouse.clickBox(632, 170, 651, 192, 1);
		
		return false;
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
