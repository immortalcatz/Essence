package net.essence.entity.mob.corba.npc;

import net.essence.EssenceItems;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityRedTordo extends EntityModVillager {

	public EntityRedTordo(World par1World) {
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
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.collectorRock, 15), new ItemStack(EssenceItems.tomatoSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.collectorRock, 15), new ItemStack(EssenceItems.corveggieSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.collectorRock, 15), new ItemStack(EssenceItems.crackenCaneSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.collectorRock, 15), new ItemStack(EssenceItems.crakeBulbSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.collectorRock, 15), new ItemStack(EssenceItems.spineberrySeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.collectorRock, 15), new ItemStack(EssenceItems.glowaSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.collectorRock, 15), new ItemStack(EssenceItems.zatSeeds, 15)));
		
	}
}