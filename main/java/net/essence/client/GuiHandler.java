package net.essence.client;

import net.essence.blocks.tileentity.TileEntityIncubator;
import net.essence.blocks.tileentity.container.ContainerEnrichedTable;
import net.essence.blocks.tileentity.container.ContainerIncubator;
import net.essence.client.render.gui.GuiBackpack;
import net.essence.client.render.gui.GuiEnrichedEnchantmentTable;
import net.essence.client.render.gui.GuiIncubator;
import net.essence.items.tileentity.TileEntityBackpack;
import net.essence.items.tileentity.container.ContainerBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public enum GuiIDs {
		ENRICHMENT_TABLE, INCUBATOR, BACKPACK;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(ID == GuiIDs.ENRICHMENT_TABLE.ordinal()) return new ContainerEnrichedTable(player.inventory, world, x, y, z, player);
		if(ID == GuiIDs.INCUBATOR.ordinal()) return new ContainerIncubator(player.inventory, (TileEntityIncubator)entity);
		if(ID == GuiIDs.BACKPACK.ordinal()) return new ContainerBackpack(player.inventory, (TileEntityBackpack)entity);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(ID == GuiIDs.ENRICHMENT_TABLE.ordinal()) return new GuiEnrichedEnchantmentTable(player.inventory, world, x, y, z, player);
		if(ID == GuiIDs.INCUBATOR.ordinal()) return new GuiIncubator(player.inventory, (TileEntityIncubator)entity);
		if(ID == GuiIDs.BACKPACK.ordinal()) return new GuiBackpack(player.inventory, (TileEntityBackpack)entity);
		return null;
	}
}