package scripts.fc.missions.fctutorial.tasks.runescape_guide;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Interfaces;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.framework.task.Task;

public class AccountDesign extends Task
{
	private static final long serialVersionUID = 1841534946959703188L;
	
	private static final int INTERFACE_MASTER = 269;
	private static final int ACCEPT_BUTTON = 100;
	private static final int[] GENDER_BUTTONS = {138, 139};
	private static final int[] DESIGN_BUTTONS = {106, 107, 108, 109, 110, 111, 112, 113, 114,
			115, 116, 117, 118, 119, 121, 122, 123, 124, 125, 127, 129, 130, 131};

	@Override
	public boolean execute()
	{
		designCharacter();
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return Interfaces.get(INTERFACE_MASTER) != null;
	}

	@Override
	public String getStatus()
	{
		return "Account design";
	}
	
	private void designCharacter()
	{
		pickGender();
		
		General.sleep(800, 1600);
		
		pickDesign();
		
		General.sleep(800, 1600);
		
		if(accept())
			Timing.waitCondition(FCConditions.interfaceNotUp(INTERFACE_MASTER), 2000);
	}
	
	private void pickGender()
	{
		Clicking.click(Interfaces.get(INTERFACE_MASTER, GENDER_BUTTONS[General.random(0, GENDER_BUTTONS.length - 1)]));
	}
	
	private void pickDesign()
	{
		int arrowClicks = General.random(0, 16);
		
		for(int i = 0; i < arrowClicks; i++)
		{
			int specificClicks = General.random(0, 5);
			
			for(int clicks = 0; clicks < specificClicks; clicks++)
			{
				Clicking.click(Interfaces.get(INTERFACE_MASTER, DESIGN_BUTTONS[General.random(0, DESIGN_BUTTONS.length - 1)]));
				
				General.sleep(200, 600);
			}
		}
	}
	
	private boolean accept()
	{
		return Clicking.click(Interfaces.get(INTERFACE_MASTER, ACCEPT_BUTTON));
	}

}
