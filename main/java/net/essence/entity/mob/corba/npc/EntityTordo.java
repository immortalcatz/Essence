package net.essence.entity.mob.corba.npc;

import net.essence.EssenceItems;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityTordo extends EntityModVillager {

	@SuppressWarnings("do this")
	public EntityTordo(World par1World) {
		super(par1World);
		setSize(0.7F, 2.5F);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.TORDO;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.cloudPuff, 15), new ItemStack(EssenceItems.healersBlade, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.collectorRock, 15), new ItemStack(EssenceItems.treeHugger, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.collectorRock, 15), new ItemStack(EssenceItems.multiToolOfEternalSmelting, 1)));
		
	}
}