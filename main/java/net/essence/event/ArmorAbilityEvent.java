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

		if(helmet == item.hellstoneHelmet && body == item.hellstoneChest && legs == item.hellstoneLegs && boots == item.hellstoneBoots) {
			event.player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 10, 1));
		}

		else if(helmet == item.shadiumHelmet && body == item.shadiumChest && legs == item.shadiumLegs && boots == item.shadiumBoots){
			if(event.player.isInWater()) event.player.setAir(300);
		}

		else if(helmet == item.sapphireHelmet && body == item.sapphireChest && legs == item.sapphireLegs && boots == item.sapphireBoots){
			if(event.player.isInWater()) event.player.setAir(300);
		}
		
		else if(helmet == item.twilightHelmet && body == item.twilightChest && legs == item.twilightLegs && boots == item.twilightBoots){
			event.player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 10, 1));
		}

		else if(event.player instanceof EntityPlayerMP) { 
			EntityPlayer player = (EntityPlayerMP)event.player;
			if(!player.capabilities.isCreativeMode && !player.isSpectator()) {
				if(helmet == item.flairiumHelmet && body == item.flairiumChest && legs == item.flairiumLegs && boots == item.flairiumBoots) {
					player.capabilities.allowFlying = true;
				} else {
					player.capabilities.allowFlying = false;
					player.capabilities.isFlying = false;
				}
			}
		}
		
		else if(helmet == item.celestiumHelmet && body == item.celestiumChest && legs == item.celestiumLegs && boots == item.celestiumBoots) {
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

			if(helmet == item.celestiumHelmet && body == item.celestiumChest && legs == item.celestiumLegs && boots == item.celestiumBoots){
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
			if(helmet == item.luniumHelmet && body == item.luniumChest && legs == item.luniumLegs && boots == item.luniumBoots)
				e.ammount += 4;
			else if(helmet == item.flameHelmet && body == item.flameChest && legs == item.flameLegs && boots == item.flameBoots)
				e.entityLiving.setFire(5);
		}
	}
}