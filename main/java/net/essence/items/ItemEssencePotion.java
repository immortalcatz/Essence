package net.essence.items;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.client.DarkEnergyBar;
import net.essence.client.EssenceBar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.item.ItemMod;

public class ItemEssencePotion extends ItemMod {

	private boolean isStrong, essence;

	public ItemEssencePotion(String name, boolean strong, boolean essence) {
		super(name, EssenceTabs.misc);
		isStrong = strong;
		this.essence = essence;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 20;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.drink;
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		int amount = isStrong ? 300 : 100;
		if(!world.isRemote){
			if(essence) EssenceBar.addBarPoints(amount);
			else DarkEnergyBar.addBarPoints(amount);
			if(!player.capabilities.isCreativeMode) stack.stackSize--;
		}
		return stack;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return isStrong ? EnumRarity.epic : EnumRarity.rare;
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return isStrong;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list) {
		String type = "";
		if(essence) type = " Essence";
		else type = " Dark Energy";
		int amount = isStrong ? 300 : 100;
		list.add("Replenishes " + amount + type);
	}
}