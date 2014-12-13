package net.essence.event;

import net.essence.Essence;
import net.essence.util.Config;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.slayer.api.SlayerAPI;

public class PlayerEvent {

	public static final String[] isImmuneToFire = new String[] {"ag", "field_70178_ae", "isImmuneToFire"};

	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent event) {
		EntityPlayer p = event.harvester;
		boolean isWorking = false;
		if(hasItemEnchantment(Essence.hotTouch, p)) isWorking = true;
		if(isWorking){
			if(event.harvester != null && event.harvester instanceof EntityPlayer && event.harvester.getHeldItem() != null) {
				if(!event.isSilkTouching){
					ItemStack stack = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.state.getBlock(), 1, event.world.getBlockState(event.pos).getBlock().getMetaFromState(event.state)));
					if(stack != null && event.state.getBlock() != Blocks.redstone_ore && event.state.getBlock() != Blocks.lapis_ore && event.state.getBlock() != Blocks.lapis_ore) {
						event.drops.clear();
						event.drops.add(stack.copy());
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onDeath(LivingDeathEvent event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			if(!player.worldObj.isRemote && Config.showDeathMessage) SlayerAPI.sendMessageToAll(player.getDisplayName() + " Died at X: " + (int)player.posX + ", Y: " + (int)player.posY + ", Z: " + (int)player.posZ, false);
		}
	}

	@SubscribeEvent
	public void onTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		int i = MathHelper.floor_double(player.posX);
		int j = MathHelper.floor_double(player.posY);
		int k = MathHelper.floor_double(player.posZ);
		Material m = event.player.worldObj.getBlockState(new BlockPos(i, j, k)).getBlock().getMaterial();
		boolean mat = (m == Material.water);
		boolean isWorking = false;
		if(hasArmorEnchantment(Essence.waterWalk, player)) isWorking = true;
		if(isWorking) {
			if(mat && player.motionY < 0.0D) {
				if(player.worldObj.getBlockState(new BlockPos(i, j - 1, k)).getBlock().getMaterial() == Material.water || player.worldObj.getBlockState(new BlockPos(i, j, k)).getBlock().getMaterial() == Material.water) player.motionY = 0.0D;
				if(!Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()) player.motionY = 0.0D; 
				else if(Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()) player.motionY = 0.5D;
			}
		}
	}

	public static int getItemEnchantment(Enchantment en, EntityLivingBase e) {
		if(en != null && e != null) return EnchantmentHelper.getEnchantmentLevel(en.effectId, e.getHeldItem());
		else return 0;
	}

	public static boolean hasItemEnchantment(Enchantment en, EntityLivingBase e) {
		return getItemEnchantment(en, e) > 0;
	}

	public static int getArmorEnchantment(Enchantment en, EntityLivingBase e) {
		if(en != null && e != null) return EnchantmentHelper.getMaxEnchantmentLevel(en.effectId, e.getInventory());
		else return 0;
	}

	public static boolean hasArmorEnchantment(Enchantment en, EntityLivingBase e) {
		return getArmorEnchantment(en, e) > 0;
	}

	/*@SubscribeEvent
	public void transferDims(PlayerChangedDimensionEvent e) {
		String from = e.fromDim == -1 ? " Nether " : e.fromDim == 0 ? " Overworld " : e.fromDim == 1 ? " The End " : e.fromDim == Config.boil ? " Boiling Point " : e.fromDim == Config.depths ? " The Depths " :
			e.fromDim == Config.euca ? " Euca " : e.fromDim == Config.frozen ? " Frozen Lands " : "§rUnknown";
		
		String to = e.toDim == -1 ? " Nether " : e.toDim == 0 ? " Overworld " : e.toDim == 1 ? " The End " : e.toDim == Config.boil ? " Boiling Point " : e.toDim == Config.depths ? " The Depths " :
			e.toDim == Config.euca ? " Euca " : e.toDim == Config.frozen ? " Frozen Lands " : " §rUnknown ";
		
		boolean hasSeen = false;
		if(Config.showDimensionChange) {
			if(!e.player.worldObj.isRemote && !hasSeen) {
				SlayerAPI.sendMessageToAll(e.player.getDisplayName() + " Has travelled from" + from + "to" + to, false);
			}
		}
	}*/
}