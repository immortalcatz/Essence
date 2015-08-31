package net.essence.event;

import net.essence.EssenceItems;
import net.essence.util.Helper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorAbilityEvent{


	private EssenceItems item = new EssenceItems();
	private Item boots = null, body = null, legs = null, helmet = null;

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

		if(helmet == EssenceItems.hellstoneHelmet && body == EssenceItems.hellstoneChest && legs == EssenceItems.hellstoneLegs && boots == EssenceItems.hellstoneBoots) {
			event.player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 10, 1));
		}

		else if(helmet == EssenceItems.shadiumHelmet && body == EssenceItems.shadiumChest && legs == EssenceItems.shadiumLegs && boots == EssenceItems.shadiumBoots){
			if(event.player.isInWater()) event.player.setAir(300);
		}

		else if(helmet == EssenceItems.sapphireHelmet && body == EssenceItems.sapphireChest && legs == EssenceItems.sapphireLegs && boots == EssenceItems.sapphireBoots){
			if(event.player.isInWater()) event.player.setAir(300);
		}
		
		else if(helmet == EssenceItems.twilightHelmet && body == EssenceItems.twilightChest && legs == EssenceItems.twilightLegs && boots == EssenceItems.twilightBoots){
			event.player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 10, 1));
		}
		
		else if(helmet == EssenceItems.leapersHelmet && body == EssenceItems.leapersChest && legs == EssenceItems.leapersLegs && boots == EssenceItems.leapersBoots){
			event.player.addPotionEffect(new PotionEffect(Potion.jump.id, 10, 1));
		}
		
		else if(helmet == EssenceItems.snakeskinHelmet && body == EssenceItems.snakeskinChest && legs == EssenceItems.snakeskinLegs && boots == EssenceItems.snakeskinBoots){
			event.player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10, 1));
			event.player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 10, 1));
			if(event.player.isInLava()) event.player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10, 3));
		}
		
		else if(helmet == EssenceItems.charskullHelmet && body == EssenceItems.charskullChest && legs == EssenceItems.charskullLegs && boots == EssenceItems.charskullBoots){
			event.player.removePotionEffect(19);
			event.player.removePotionEffect(20);
		}
		
		else if(helmet == EssenceItems.charskullHelmet && body == EssenceItems.charskullChest && legs == EssenceItems.charskullLegs && boots == EssenceItems.charskullBoots){
			player.fallDamage=0;
			event.player.removePotionEffect(20);

		}

		else if(event.player instanceof EntityPlayerMP) { 
			EntityPlayer player = (EntityPlayerMP)event.player;
			if(!player.capabilities.isCreativeMode && !player.isSpectator()) {
				if(helmet == EssenceItems.flairiumHelmet && body == EssenceItems.flairiumChest && legs == EssenceItems.flairiumLegs && boots == EssenceItems.flairiumBoots) {
					player.capabilities.allowFlying = true;
				} else {
					player.capabilities.allowFlying = false;
					player.capabilities.isFlying = false;
				}
			}
		}
		
		else if(helmet == EssenceItems.celestiumHelmet && body == EssenceItems.celestiumChest && legs == EssenceItems.celestiumLegs && boots == EssenceItems.celestiumBoots) {
			event.player.capabilities.setPlayerWalkSpeed(0.3F);
			event.player.fallDistance = 0.0F;
		} else {
			event.player.capabilities.setPlayerWalkSpeed(0.1F);
		}
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

			if(helmet == EssenceItems.celestiumHelmet && body == EssenceItems.celestiumChest && legs == EssenceItems.celestiumLegs && boots == EssenceItems.celestiumBoots){
				player.addVelocity(0, 0.3, 0);
			} 
		}
	}

	/*@SubscribeEvent
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
	}*/

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
			if(helmet == EssenceItems.luniumHelmet && body == EssenceItems.luniumChest && legs == EssenceItems.luniumLegs && boots == EssenceItems.luniumBoots)
				e.ammount += 4;
			
			else if(helmet == EssenceItems.flameHelmet && body == EssenceItems.flameChest && legs == EssenceItems.flameLegs && boots == EssenceItems.flameBoots)
				e.entityLiving.setFire(5);
			
			if(!(e.entity instanceof EntityPlayer)) {
				if(helmet == EssenceItems.bronzedHelmet && body == EssenceItems.bronzedChest && legs == EssenceItems.bronzedLegs && boots == EssenceItems.bronzedBoots)
					e.ammount += 6;
		}
	}
}}