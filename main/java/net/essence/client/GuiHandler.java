package net.essence.client;

import net.essence.blocks.tileentity.TileEntityIncubator;
import net.essence.blocks.tileentity.container.ContainerEnrichedTable;
import net.essence.blocks.tileentity.container.ContainerIncubator;
import net.essence.client.render.gui.GuiEnrichedEnchantmentTable;
import net.essence.client.render.gui.GuiIncubator;
import net.essence.client.render.gui.GuiStats;
import net.essence.util.ContainerEmpty;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	private static int guiID = 0;
	public static int stats = guiID++, enrichmentTable = guiID++, incubator = guiID++;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(ID == stats) return new ContainerEmpty();
		if(ID == enrichmentTable) return new ContainerEnrichedTable(player.inventory, world, x, y, z, player);
		if(ID == incubator) return new ContainerIncubator(player.inventory, (TileEntityIncubator)entity);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(ID == stats) return new GuiStats();
		if(ID == enrichmentTable) return new GuiEnrichedEnchantmentTable(player.inventory, world, x, y, z, player);
		if(ID == incubator) return new GuiIncubator(player.inventory, (TileEntityIncubator)entity);
		return null;
	}
}