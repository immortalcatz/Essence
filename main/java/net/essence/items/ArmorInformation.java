package net.essence.items;

import java.util.List;

import net.essence.EssenceItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ArmorInformation {

	public static void addInfo(ItemStack i, List l){
		Item part = i.getItem();
		EssenceItems item = new EssenceItems();
		if(part == item.hellstoneHelmet || part == item.hellstoneChest || part == item.hellstoneLegs || part == item.hellstoneBoots)
			l.add("Full set: Fire protection");
	}
}