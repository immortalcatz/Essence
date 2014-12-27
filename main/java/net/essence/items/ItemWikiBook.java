package net.essence.items;

import net.essence.Essence;
import net.essence.EssenceTabs;
import net.essence.client.GuiHandler.GuiIDs;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.item.ItemMod;

public class ItemWikiBook extends ItemMod {

	private GuiIDs id;
	
	public ItemWikiBook(String name, GuiIDs id) {
		super(name, EssenceTabs.misc);
		setMaxStackSize(1);
		this.id = id;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote) {
			player.openGui(Essence.instance, id.ordinal(), world, 0, 0, 0);
			EnumSounds.playSound(EnumSounds.PAGE_FLIP, world, player);
		}
		return stack;
	}	
}