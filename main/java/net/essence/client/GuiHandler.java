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
		ENRICHMENT_TABLE, INCUBATOR, BACKPACK, MAGE, BLACKSMITH, FROZEN_MERCHANT, KNOWLEDGE, SUMMONING, STARING_GUARDIAN, TORDO;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		if(ID == GuiIDs.ENRICHMENT_TABLE.ordinal()) return new ContainerEnrichedTable(player.inventory, world, new BlockPos(x, y, z), player);
		if(ID == GuiIDs.INCUBATOR.ordinal()) return new ContainerIncubator(player.inventory, (TileEntityIncubator)entity);
		if(ID == GuiIDs.BACKPACK.ordinal()) return new ContainerBackpack(player.inventory, (TileEntityBackpack)entity);
		if(ID == GuiIDs.MAGE.ordinal()) return new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world);
		if(ID == GuiIDs.BLACKSMITH.ordinal()) return new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world);
		if(ID == GuiIDs.FROZEN_MERCHANT.ordinal()) return new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world);
		if(ID == GuiIDs.KNOWLEDGE.ordinal()) return new ContainerKnowledgeTable(player.inventory, (TileEntityKnowledgeTable)entity, world);
		if(ID == GuiIDs.SUMMONING.ordinal()) return new ContainerSummoningTable(player.inventory, (TileEntitySummoningTable)entity, world);
		if(ID == GuiIDs.STARING_GUARDIAN.ordinal()) return new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world);
		if(ID == GuiIDs.TORDO.ordinal()) return new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world);
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
		if(ID == GuiIDs.FROZEN_MERCHANT.ordinal()) return new GuiFrozenMerchant(new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == GuiIDs.KNOWLEDGE.ordinal()) return new GuiKnowledgeTable(player.inventory, (TileEntityKnowledgeTable)entity, world);
		if(ID == GuiIDs.SUMMONING.ordinal()) return new GuiSummoningTable(player.inventory, (TileEntitySummoningTable)entity, world);
		if(ID == GuiIDs.STARING_GUARDIAN.ordinal()) return new GuiStaringGuardian(new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == GuiIDs.TORDO.ordinal()) return new GuiTordo(new ContainerModVillager(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		return null;
	}

	private Entity getEntityByID(int entityID, World world) {
		for(int i = 0; i < world.loadedEntityList.size(); i++) {
			if(((Entity)world.loadedEntityList.get(i)).getEntityId() == entityID) {
				return ((Entity)world.loadedEntityList.get(i));
			}
		}
		return null;
	}
}