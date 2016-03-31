package net.journey.achievement.event;

import net.journey.JourneyItems;
import net.journey.proxy.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class JourneyPickupItemEvent {
	
	@SubscribeEvent
	public void onSapphireMineEvent(PlayerEvent.ItemPickupEvent e) {
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.sapphire))) {
			e.player.addStat(CommonProxy.achievementore, 1);
		}
	}
	
	@SubscribeEvent
	public void onGemMineEvent(PlayerEvent.ItemPickupEvent e) {
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.greenGem))) {
		}
		e.player.addStat(CommonProxy.achievementGem, 1);
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.blueGem))) {
		}
		e.player.addStat(CommonProxy.achievementGem, 1);
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.yellowGem))) {
		}
		e.player.addStat(CommonProxy.achievementGem, 1);
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.purpleGem))) {
		}
		e.player.addStat(CommonProxy.achievementGem, 1);
	}
}
