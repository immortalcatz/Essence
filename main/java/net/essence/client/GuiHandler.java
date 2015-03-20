package net.essence.client;

import net.essence.blocks.tileentity.*;
import net.essence.blocks.tileentity.container.*;
import net.essence.client.render.gui.*;
import net.essence.items.tileentity.*;
import net.essence.items.tileentity.container.*;
import net.essence.util.ContainerEmpty;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.common.network.*;
import net.slayer.api.entity.tileentity.container.*;

public class GuiHandler implements IGuiHandler {

	public enum GuiIDs {
		ENRICHMENT_TABLE, INCUBATOR, BACKPACK, MAGE, BLACKSMITH, GREEN_ELF, RED_ELF, KNOWLEDGE;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		if(ID == GuiIDs.ENRICHMENT_TABLE.ordinal()) return new ContainerEnrichedTable(player.inventory, world, new BlockPos(x, y, z), player);
		if(ID == GuiIDs.INCUBATOR.ordinal()) return new ContainerIncubator(player.inventory, (TileEntityIncubator)entity);
		if(ID == GuiIDs.BACKPACK.ordinal()) return new ContainerBackpack(player.inventory, (TileEntityBackpack)entity);
		if(ID == GuiIDs.MAGE.ordinal()) return new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world);
		if(ID == GuiIDs.BLACKSMITH.ordinal()) return new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world);
		if(ID == GuiIDs.GREEN_ELF.ordinal()) return new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world);
		if(ID == GuiIDs.RED_ELF.ordinal()) return new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world);
		if(ID == GuiIDs.KNOWLEDGE.ordinal()) return new ContainerKnowledgeTable(player.inventory, (TileEntityKnowledgeTable)entity, world);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		if(ID == GuiIDs.ENRICHMENT_TABLE.ordinal()) return new GuiEnrichedEnchantmentTable(player.inventory, world, x, y, z, player);
		if(ID == GuiIDs.INCUBATOR.ordinal()) return new GuiIncubator(player.inventory, (TileEntityIncubator)entity);
		if(ID == GuiIDs.BACKPACK.ordinal()) return new GuiBackpack(player.inventory, (TileEntityBackpack)entity);
		if(ID == GuiIDs.MAGE.ordinal()) return new GuiMage(new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == GuiIDs.BLACKSMITH.ordinal()) return new GuiBlacksmith(new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == GuiIDs.GREEN_ELF.ordinal()) return new GuiGreenElf(new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == GuiIDs.RED_ELF.ordinal()) return new GuiRedElf(new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == GuiIDs.KNOWLEDGE.ordinal()) return new GuiKnowledgeTable(player.inventory, (TileEntityKnowledgeTable)entity, world);
		return null;
	}

	private Entity getEntityByID(int entityID, World world) {
		for(int i = 0; i < world.getLoadedEntityList().size(); i++) {
			if(((Entity)world.getLoadedEntityList().get(i)).getEntityId() == entityID) {
				return ((Entity)world.getLoadedEntityList().get(i));
			}
		}
		return null;
	}
}