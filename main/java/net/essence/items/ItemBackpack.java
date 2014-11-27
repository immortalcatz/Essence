package net.essence.items;

import java.util.List;

import net.essence.Essence;
import net.essence.EssenceTabs;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemBackpack extends ItemMod {

	public static String[] textures = {"black", "blue", "brown", "cyan", "gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"};
	public static String[] names = {"Black", "Blue", "Brown", "Cyan", "Gray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow"};
		
	public static ItemStack[] crafting = new ItemStack[] {
		new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 3),
		new ItemStack(Items.dye, 1, 6), new ItemStack(Items.dye, 1, 8), new ItemStack(Items.dye, 1, 10),
		new ItemStack(Items.dye, 1, 13), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 9), 
		new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 11)};
	
	public ItemBackpack(String name) {
		super(name);
		hasSubtypes = true;
		setCreativeTab(EssenceTabs.misc);
	}

	@Override
	public void getSubItems(Item i, CreativeTabs t, List l) {
		for(int j = 0; j < 13; j++)
			l.add(new ItemStack(i, 1, j));
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote) {
			player.openGui(Essence.instance, GuiIDs.BACKPACK.ordinal(), world, 0, 0, 0);
		}
		return stack;
	}
}