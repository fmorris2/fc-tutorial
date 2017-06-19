package scripts.fc.missions.fctutorial.tasks;

import java.util.ArrayList;
import java.util.List;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fctutorial.tasks.bank_stage.BankerDialogue;
import scripts.fc.missions.fctutorial.tasks.bank_stage.BankingExit;
import scripts.fc.missions.fctutorial.tasks.bank_stage.PollBooth;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.CombatInstructorDialogue;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.CombatInstructorExit;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.CombatTab;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.EnterRatCage;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.EquipBowAndArrow;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.EquipSwordAndShield;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.EquipmentTab;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.MeleeRat;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.RangeRat;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.ViewEquipment;
import scripts.fc.missions.fctutorial.tasks.combat_instructor.WieldDagger;
import scripts.fc.missions.fctutorial.tasks.financial_advisor.FinancialAdvisorDialogue;
import scripts.fc.missions.fctutorial.tasks.financial_advisor.FinancialAdvisorExit;
import scripts.fc.missions.fctutorial.tasks.magic_instructor.CastWindStrike;
import scripts.fc.missions.fctutorial.tasks.magic_instructor.MagicInstructorDialogue;
import scripts.fc.missions.fctutorial.tasks.magic_instructor.MagicTab;
import scripts.fc.missions.fctutorial.tasks.magic_instructor.WalkToMagicInstructor;
import scripts.fc.missions.fctutorial.tasks.master_chef.CookDough;
import scripts.fc.missions.fctutorial.tasks.master_chef.MakeDough;
import scripts.fc.missions.fctutorial.tasks.master_chef.MasterChefDialogue;
import scripts.fc.missions.fctutorial.tasks.master_chef.MasterChefDoor;
import scripts.fc.missions.fctutorial.tasks.master_chef.MasterChefExit;
import scripts.fc.missions.fctutorial.tasks.master_chef.MusicTab;
import scripts.fc.missions.fctutorial.tasks.mining_instructor.ClickAnvil;
import scripts.fc.missions.fctutorial.tasks.mining_instructor.HandleCopper;
import scripts.fc.missions.fctutorial.tasks.mining_instructor.HandleTin;
import scripts.fc.missions.fctutorial.tasks.mining_instructor.MakeDagger;
import scripts.fc.missions.fctutorial.tasks.mining_instructor.MiningInstructorDialogue;
import scripts.fc.missions.fctutorial.tasks.mining_instructor.MiningInstructorExit;
import scripts.fc.missions.fctutorial.tasks.mining_instructor.SmeltOre;
import scripts.fc.missions.fctutorial.tasks.prayer_guide.BrotherBraceDialogue;
import scripts.fc.missions.fctutorial.tasks.prayer_guide.BrotherBraceExit;
import scripts.fc.missions.fctutorial.tasks.prayer_guide.FriendsTab;
import scripts.fc.missions.fctutorial.tasks.prayer_guide.IgnoreTab;
import scripts.fc.missions.fctutorial.tasks.prayer_guide.PrayerTab;
import scripts.fc.missions.fctutorial.tasks.prayer_guide.WalkToBrotherBrace;
import scripts.fc.missions.fctutorial.tasks.quest_guide.ClickEmote;
import scripts.fc.missions.fctutorial.tasks.quest_guide.ClickOptions;
import scripts.fc.missions.fctutorial.tasks.quest_guide.EmotesTab;
import scripts.fc.missions.fctutorial.tasks.quest_guide.OpenQuestGuideDoor;
import scripts.fc.missions.fctutorial.tasks.quest_guide.QuestGuideDialogue;
import scripts.fc.missions.fctutorial.tasks.quest_guide.QuestGuideLadder;
import scripts.fc.missions.fctutorial.tasks.quest_guide.QuestTab;
import scripts.fc.missions.fctutorial.tasks.quest_guide.TurnRunOn;
import scripts.fc.missions.fctutorial.tasks.runescape_guide.AccountDesign;
import scripts.fc.missions.fctutorial.tasks.runescape_guide.OptionsTab;
import scripts.fc.missions.fctutorial.tasks.runescape_guide.RunescapeGuideDialogue;
import scripts.fc.missions.fctutorial.tasks.runescape_guide.RunescapeGuideDoor;
import scripts.fc.missions.fctutorial.tasks.survival_expert.ChopTree;
import scripts.fc.missions.fctutorial.tasks.survival_expert.CookShrimps;
import scripts.fc.missions.fctutorial.tasks.survival_expert.FishShrimps;
import scripts.fc.missions.fctutorial.tasks.survival_expert.InventoryTab;
import scripts.fc.missions.fctutorial.tasks.survival_expert.LightFire;
import scripts.fc.missions.fctutorial.tasks.survival_expert.StatsTab;
import scripts.fc.missions.fctutorial.tasks.survival_expert.SurvivalExpertDialogue;
import scripts.fc.missions.fctutorial.tasks.survival_expert.SurvivalExpertGate;

public enum TutorialTask
{
	ACCOUNT_DESIGN(new AccountDesign()),
	RS_GUIDE_DIALOGUE(new RunescapeGuideDialogue()),
	OPTIONS_TAB(new OptionsTab()),
	RS_GUIDE_DOOR(new RunescapeGuideDoor()),
	SURVIVAL_EXPERT_DIALOGUE(new SurvivalExpertDialogue()),
	INVENTORY_TAB(new InventoryTab()),
	CHOP_TREE(new ChopTree()),
	LIGHT_FIRE(new LightFire()),
	STATS_TAB(new StatsTab()),
	FISH_SHRIMPS(new FishShrimps()),
	COOK_SHRIMPS(new CookShrimps()),
	SURVIVAL_EXPERT_GATE(new SurvivalExpertGate()),
	MASTER_CHEF_DOOR(new MasterChefDoor()),
	MASTER_CHEF_DIALOGUE(new MasterChefDialogue()),
	MAKE_DOUGH(new MakeDough()),
	COOK_DOUGH(new CookDough()),
	MUSIC_TAB(new MusicTab()),
	MASTER_CHEF_EXIT(new MasterChefExit()),
	EMOTES_TAB(new EmotesTab()),
	CLICK_EMOTE(new ClickEmote()),
	CLICK_OPTIONS(new ClickOptions()),
	TURN_RUN_ON(new TurnRunOn()),
	OPEN_QUEST_GUIDE_DOOR(new OpenQuestGuideDoor()),
	QUEST_GUIDE_DIALOGUE(new QuestGuideDialogue()),
	QUEST_TAB(new QuestTab()),
	QUEST_GUIDE_LADDER(new QuestGuideLadder()),
	MINING_INSTRUCTOR_DIALOGUE(new MiningInstructorDialogue()),
	HANDLE_TIN(new HandleTin()),
	HANDLE_COPPER(new HandleCopper()),
	SMELT_ORE(new SmeltOre()),
	CLICK_ANVIL(new ClickAnvil()),
	MAKE_DAGGER(new MakeDagger()),
	MINING_INSTRUCTOR_EXIT(new MiningInstructorExit()),
	COMBAT_INSTRUCTOR_DIALOGUE(new CombatInstructorDialogue()),
	EQUIPMENT_TAB(new EquipmentTab()),
	VIEW_EQUIPMENT(new ViewEquipment()),
	WIELD_DAGGER(new WieldDagger()),
	EQUIP_SWORD_AND_SHIELD(new EquipSwordAndShield()),
	COMBAT_TAB(new CombatTab()),
	ENTER_RAT_CAGE(new EnterRatCage()),
	MELEE_RAT(new MeleeRat()),
	EQUIP_BOW_AND_ARROW(new EquipBowAndArrow()),
	RANGE_RAT(new RangeRat()),
	COMBAT_INSTRUCTOR_EXIT(new CombatInstructorExit()),
	BANKER_DIALOGUE(new BankerDialogue()),
	POLL_BOOTH(new PollBooth()),
	BANKING_EXIT(new BankingExit()),
	FINANCIAL_ADVISOR_DIALOGUE(new FinancialAdvisorDialogue()),
	FINANCIAL_ADVISOR_EXIT(new FinancialAdvisorExit()),
	WALK_TO_BROTHER_BRACE(new WalkToBrotherBrace()),
	BROTHER_BRACE_DIALOGUE(new BrotherBraceDialogue()),
	PRAYER_TAB(new PrayerTab()),
	FRIENDS_TAB(new FriendsTab()),
	IGNORE_TAB(new IgnoreTab()),
	BROTHER_BRACE_EXIT(new BrotherBraceExit()),
	MAGIC_INSTRUCTOR_DIALOGUE(new MagicInstructorDialogue()),
	WALK_TO_MAGIC_INSTRUCTOR(new WalkToMagicInstructor()),
	MAGIC_TAB(new MagicTab()),
	CAST_WIND_STRIKE(new CastWindStrike()),
	STUCK_CHECKS(new StuckChecks()),
	GENERAL_CHECKS(new GeneralChecks());
	
	public final static List<Task> ALL_TASKS = getTasks();
	
	public final Task TASK;
	TutorialTask(Task t)
	{
		TASK = t;
	}
	
	private static List<Task> getTasks()
	{
		List<Task> tasks = new ArrayList<>();
		for(TutorialTask t : values())
			tasks.add(t.TASK);
			
		return tasks;
	}
}
