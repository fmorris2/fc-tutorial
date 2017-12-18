package scripts.fc.missions.fctutorial.tasks.quest_guide;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterface;

import scripts.fc.api.abc.ABC2Reaction;
import scripts.fc.api.generic.FCConditions;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.FCTutorial;

public class ClickEmote extends Task
{
	private static final long serialVersionUID = -892318255408849103L;
	
	private static final int INTERFACE_MASTER = 216;
	private static final int SCROLLBAR_CHILD = 2;
	private static final int SCROLLBAR_COMP = 1;
	
	private static final int SCROLLBAR_MAX_Y = 20;
	
	private ABC2Reaction reaction = new ABC2Reaction(true, 1800);

	@Override
	public boolean execute()
	{
		doEmote();
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return FCTutorial.getProgress() == 187;
	}

	@Override
	public String getStatus()
	{
		return "Click emote";
	}
	
	private void doEmote()
	{
		RSInterface parent = Interfaces.get(INTERFACE_MASTER);
		if(parent == null)
			return;
		
		if(GameTab.open(TABS.EMOTES)) {
			
			checkScrollBar(parent);
			
			RSInterface emote = parent.getChild(General.random(1, 19));
			
			if(Clicking.click(emote))
			{
				reaction.start();
				if(Timing.waitCondition(FCConditions.settingNotEqualsCondition(FCTutorial.PROGRESS_SETTING, 187), 3000))
					reaction.react();
			}
		}
	}
	
	private void checkScrollBar(RSInterface parent) {
		RSInterface scrollBar = parent.getChild(SCROLLBAR_CHILD);
		if(scrollBar != null) {
			RSInterface component = scrollBar.getChild(SCROLLBAR_COMP);
			while(component != null && component.getY() > SCROLLBAR_MAX_Y) {
				if(!parent.getAbsoluteBounds().contains(Mouse.getPos())) {
					Mouse.moveBox(parent.getAbsoluteBounds());
				}
				Mouse.scroll(true);
				General.sleep(5, 15);
			}
		}
	}

}
