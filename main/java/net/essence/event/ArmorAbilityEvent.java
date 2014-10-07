package net.essence.event;

import net.essence.Essence;
import net.essence.EssenceItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.*;

public class ArmorAbilityEvent{

	private Item boots = null, body = null, legs = null, helmet = null;
	private EssenceItems item = new EssenceItems();
	public static final String[] isImmuneToFire = new String[] { "ag", "field_70178_ae", "isImmuneToFire" };
	public static final String[] isJumping = new String[] { "bd", "field_70703_bu", "isJumping" };

	@SubscribeEvent
	public void playerTick(PlayerTickEvent event) {
		ItemStack stackBoots = event.player.inventory.armorItemInSlot(0);
		ItemStack stackLegs = event.player.inventory.armorItemInSlot(1);
		ItemStack stackBody = event.player.inventory.armorItemInSlot(2);
		ItemStack stackHelmet = event.player.inventory.armorItemInSlot(3);
		if(stackBoots != null) boots = stackBoots.getItem();
		else boots = null;
		if(stackBody != null) body = stackBody.getItem();
		else body = null;
		if(stackLegs != null) legs = stackLegs.getItem();
		else legs = null;
		if(stackHelmet != null) helmet = stackHelmet.getItem();
		else helmet = null;

		if(helmet == item.hellstoneHelmet && body == item.hellstoneChest && legs == item.hellstoneLegs && boots == item.hellstoneBoots) {
			ObfuscationReflectionHelper.setPrivateValue(Entity.class, event.player, true, isImmuneToFire);
		}

		if(helmet == item.shadiumHelmet && body == item.shadiumChest && legs == item.shadiumLegs && boots == item.shadiumBoots){
			if(event.player.isInWater()) event.player.setAir(300);
		}
		
		if(helmet == item.sapphireHelmet && body == item.sapphireChest && legs == item.sapphireLegs && boots == item.sapphireBoots){
			if(event.player.isInWater()) event.player.setAir(300);
		}

		if(helmet == item.flairiumHelmet && body == item.flairiumChest && legs == item.flairiumLegs && boots == item.flairiumBoots ||
				helmet == item.condencedDiamondHelmet && body == item.condencedDiamondChest && legs == item.condencedDiamondLegs && boots == item.condencedDiamondBoots){
			event.player.capabilities.allowFlying = true;
			event.player.capabilities.setFlySpeed(0.11F);
		}

		if(helmet == item.celestiumHelmet && body == item.celestiumChest && legs == item.celestiumLegs && boots == item.celestiumBoots){
			event.player.capabilities.setPlayerWalkSpeed(0.2F);
			event.player.fallDistance = 0.0F;
		}

		if(!event.player.capabilities.isCreativeMode) {
			if(!(helmet == item.celestiumHelmet && body == item.celestiumChest && legs == item.celestiumLegs && boots == item.celestiumBoots)) {
				event.player.capabilities.setPlayerWalkSpeed(0.1F);
			}
			if(!(helmet == item.flairiumHelmet && body == item.flairiumChest && legs == item.flairiumLegs && boots == item.flairiumBoots ||
					helmet == item.condencedDiamondHelmet && body == item.condencedDiamondChest && legs == item.condencedDiamondLegs && boots == item.condencedDiamondBoots)){
				event.player.capabilities.isFlying = false;
				event.player.capabilities.allowFlying = false;
				event.player.capabilities.setFlySpeed(0.1F);
			}
			if(!(helmet == item.hellstoneHelmet && body == item.hellstoneChest && legs == item.hellstoneLegs && boots == item.hellstoneBoots)){
				ObfuscationReflectionHelper.setPrivateValue(Entity.class, event.player, false, isImmuneToFire);
			}
		}
	}
	
	public static int getArmorEnchantment(Enchantment en, EntityLivingBase e) {
		if(en != null && e != null) return EnchantmentHelper.getMaxEnchantmentLevel(en.effectId, e.getLastActiveItems());
		else return 0;
	}

	public static boolean hasArmorEnchantment(Enchantment en, EntityLivingBase e) {
		return getArmorEnchantment(en, e) > 0;
	}

	@SubscribeEvent
	public void onJump(LivingJumpEvent event) {
		if(event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack stackBoots = player.inventory.armorItemInSlot(0);
			ItemStack stackLegs = player.inventory.armorItemInSlot(1);
			ItemStack stackBody = player.inventory.armorItemInSlot(2);
			ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
			if(stackBoots != null) boots = stackBoots.getItem();
			else boots = null;
			if(stackBody != null) body = stackBody.getItem();
			else body = null;
			if(stackLegs != null) legs = stackLegs.getItem();
			else legs = null;
			if(stackHelmet != null) helmet = stackHelmet.getItem();
			else helmet = null;

			if(helmet == item.celestiumHelmet && body == item.celestiumChest && legs == item.celestiumLegs && boots == item.celestiumBoots){
				player.addVelocity(0, 0.3, 0);
			} 
		}
	}

	@SubscribeEvent
	public void onPlayerHurtEvent(LivingHurtEvent e) { //Used when the player is hurt by something (for armor that doesn't take damage from certain things like arrows)
		if(e.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) e.entity;
			ItemStack stackBoots = player.inventory.armorItemInSlot(0);
			ItemStack stackLegs = player.inventory.armorItemInSlot(1);
			ItemStack stackBody = player.inventory.armorItemInSlot(2);
			ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
			if(stackBoots != null) boots = stackBoots.getItem();
			else boots = null;
			if(stackBody != null) body = stackBody.getItem();
			else body = null;
			if(stackLegs != null) legs = stackLegs.getItem();
			else legs = null;
			if(stackHelmet != null) helmet = stackHelmet.getItem();
			else helmet = null;
			DamageSource s = e.source;

		}
	}

	@SubscribeEvent
	public void onPlayerAttackEvent(LivingAttackEvent e) { //Used when the player is hurt by something (for armor that doesn't take damage from certain things like drowning)
		if(e.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) e.entity;
			ItemStack stackBoots = player.inventory.armorItemInSlot(0);
			ItemStack stackLegs = player.inventory.armorItemInSlot(1);
			ItemStack stackBody = player.inventory.armorItemInSlot(2);
			ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
			if(stackBoots != null) boots = stackBoots.getItem();
			else boots = null;
			if(stackBody != null) body = stackBody.getItem();
			else body = null;
			if(stackLegs != null) legs = stackLegs.getItem();
			else legs = null;
			if(stackHelmet != null) helmet = stackHelmet.getItem();
			else helmet = null;
			DamageSource s = e.source;
		}
	}

	@SubscribeEvent
	public void onLivingHurtEvent(LivingHurtEvent e) {
		DamageSource s = e.source;
		if(e.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)e.entity;
			ItemStack stackBoots = player.inventory.armorItemInSlot(0);
			ItemStack stackLegs = player.inventory.armorItemInSlot(1);
			ItemStack stackBody = player.inventory.armorItemInSlot(2);
			ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
			if(stackBoots != null) boots = stackBoots.getItem();
			else boots = null;
			if(stackBody != null) body = stackBody.getItem();
			else body = null;
			if(stackLegs != null) legs = stackLegs.getItem();
			else legs = null;
			if(stackHelmet != null) helmet = stackHelmet.getItem();
			else helmet = null;
		}

		if(!(e.entity instanceof EntityPlayer)) {
			if(helmet == item.luniumHelmet && body == item.luniumChest && legs == item.luniumLegs && boots == item.luniumBoots)
				e.ammount += 4;
		}
	}
}