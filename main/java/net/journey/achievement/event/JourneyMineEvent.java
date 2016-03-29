package net.journey.achievement.event;

import net.journey.JourneyItems;
import net.journey.proxy.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class JourneyMineEvent {
	
	@SubscribeEvent
	public void onSapphireMineEvent(PlayerEvent.ItemPickupEvent e) {
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.sapphire))) {
			e.player.addStat(CommonProxy.achievementore, 1);
		}
	}
	
	@SubscribeEvent
	public void onGemMineEvent(PlayerEvent.ItemPickupEvent e) {
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.purpleGem)))
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.yellowGem)))
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.blueGem)))
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(JourneyItems.greenGem))) {
		}
		e.player.addStat(CommonProxy.achievementGem, 1);
	}
}
