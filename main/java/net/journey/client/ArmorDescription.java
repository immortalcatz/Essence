package net.journey.client;

import java.util.List;

import net.journey.JourneyItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArmorDescription {

	public static void add(ItemStack item, EntityPlayer player, List<String> list) {
		Item i = item.getItem();
		if(i == JourneyItems.hellstoneHelmet || i == JourneyItems.hellstoneChest || i == JourneyItems.hellstoneLegs || i == JourneyItems.hellstoneBoots)
			list.add("Full set: Fire Protection");

		if(i == JourneyItems.shadiumHelmet || i == JourneyItems.shadiumChest || i == JourneyItems.shadiumLegs || i == JourneyItems.shadiumBoots)
			list.add("Full set: Water Breathing");

		if(i == JourneyItems.celestiumHelmet || i == JourneyItems.celestiumChest || i == JourneyItems.celestiumLegs || i == JourneyItems.celestiumBoots) {
			list.add("Full set: Jump 3 Blocks High");
			list.add("Full set: Run Faster");
			list.add("Full set: No Fall Damage");
		}
		
		if(i == JourneyItems.luniumHelmet || i == JourneyItems.luniumChest || i == JourneyItems.luniumLegs || i == JourneyItems.luniumBoots)
			list.add("Full set: Adds 4 Melee Damage");
		
		if(i == JourneyItems.flairiumHelmet || i == JourneyItems.flairiumChest || i == JourneyItems.flairiumLegs || i == JourneyItems.flairiumBoots)
			list.add("Full set: Grants fire resistance");
		
		if(i == JourneyItems.sapphireHelmet || i == JourneyItems.sapphireChest || i == JourneyItems.sapphireLegs || i == JourneyItems.sapphireBoots)
			list.add("Full set: Water breathing");
		
		if(i == JourneyItems.flameHelmet || i == JourneyItems.flameChest || i == JourneyItems.flameLegs || i == JourneyItems.flameBoots)
			list.add("Full set: Sets foe on fire when hit");
		
		if(i == JourneyItems.twilightHelmet || i == JourneyItems.twilightChest || i == JourneyItems.twilightLegs || i == JourneyItems.twilightBoots)
			list.add("Full set: Grants the player Night Vision");
		
		if(i == JourneyItems.snakeskinHelmet || i == JourneyItems.snakeskinChest || i == JourneyItems.snakeskinLegs || i == JourneyItems.snakeskinBoots)
			list.add("Full set: Grants speed and fire resistance while in lava");
		
		if(i == JourneyItems.leapersHelmet || i == JourneyItems.leapersChest || i == JourneyItems.leapersLegs || i == JourneyItems.leapersBoots)
			list.add("Full set: Grants increased jump height");
		
		if(i == JourneyItems.treehuggersHelmet || i == JourneyItems.treehuggersChest || i == JourneyItems.treehuggersLegs || i == JourneyItems.treehuggersBoots)
			list.add("Full set: Grants immunity towards poison and wither effects");

		if(i == JourneyItems.charskullHelmet || i == JourneyItems.charskullChest || i == JourneyItems.charskullLegs || i == JourneyItems.charskullBoots)
			list.add("Full set: Grants fire resistance and damage boost");
		
		if(i == JourneyItems.golditeHelmet || i == JourneyItems.golditeChest || i == JourneyItems.golditeLegs || i == JourneyItems.golditeBoots)
			list.add("Full set: No fall damage and speed II");
		
		if(i == JourneyItems.bronzedHelmet || i == JourneyItems.bronzedChest || i == JourneyItems.bronzedLegs || i == JourneyItems.bronzedBoots)
			list.add("Full set: Grants +6 melee damage and slows enemies you hit");
	}
}