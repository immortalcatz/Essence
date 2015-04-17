package net.essence.items;

import net.essence.Essence;
import net.essence.EssenceTabs;
import net.essence.client.GuiHandler.GuiIDs;
import net.essence.items.tileentity.TileEntityBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.item.ItemMod;

public class ItemBackpack extends ItemMod {

	public ItemBackpack(String name) {
		super(name);
		setCreativeTab(EssenceTabs.misc);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		TileEntityBackpack te = (TileEntityBackpack)world.getTileEntity(player.playerLocation);
		if(te != null) {
			if(!world.isRemote) player.openGui(Essence.instance, GuiIDs.BACKPACK.ordinal(), world, player.playerLocation.getX(), player.playerLocation.getY(), player.playerLocation.getZ());
		}
		return stack;
	}
}