package net.journey.achievement.event;

import net.journey.JourneyAchievements;
import net.journey.JourneyItems;
import net.journey.proxy.CommonProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class JourneyOnCraftEvent {

	@SubscribeEvent
	public void onCraftSwordEvent(PlayerEvent.ItemCraftedEvent e) {
		if(e.crafting.getItem().equals(JourneyItems.sapphireSword)) {
			e.player.addStat(CommonProxy.achievementSapphireSword, 1);
		}
	}
}
