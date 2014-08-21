package net.essence.event;

import java.util.Random;

import net.essence.Essence;
import net.essence.client.ModPlayerHealth;
import net.essence.client.PlayerLevels;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerEvent {

	@SubscribeEvent
	public void entityConstructing(EntityConstructing event) {
		if(event.entity instanceof EntityPlayer && ModPlayerHealth.getInstance().getPlayer((EntityPlayer)event.entity) == null){
			ModPlayerHealth.getInstance().register((EntityPlayer)event.entity);
			//PlayerLevels.register((EntityPlayer)event.entity);
		}
	}
	
	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent event){
		EntityPlayer p = event.harvester;
		Random r = new Random();
		boolean isWorking = false;
		int amount = getEnch(Essence.hotTouch, p);
		if(amount > 0) isWorking = true;
		if(event.harvester != null && event.harvester instanceof EntityPlayer) {
			if(isWorking){
				if(!event.isSilkTouching){
					ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(event.block, 1, event.blockMetadata));
					if(stack != null && event.block != Blocks.redstone_ore && event.block != Blocks.lapis_ore) {
						event.drops.clear();
						event.drops.add(stack.copy());
					}
				}
			}
		}
	}
	
	public static int getEnch(Enchantment en, EntityLivingBase e) {
		if(en != null && e != null) return EnchantmentHelper.getEnchantmentLevel(en.effectId, e.getHeldItem());
		else return 0;
	}
}