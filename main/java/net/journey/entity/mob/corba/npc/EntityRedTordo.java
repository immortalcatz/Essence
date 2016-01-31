package net.journey.entity.mob.corba.npc;

import net.journey.JourneyItems;
import net.journey.client.GuiHandler.GuiIDs;
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
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 15), new ItemStack(JourneyItems.collectorRock, 15), new ItemStack(JourneyItems.tomatoSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 15), new ItemStack(JourneyItems.collectorRock, 15), new ItemStack(JourneyItems.corveggieSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 15), new ItemStack(JourneyItems.collectorRock, 15), new ItemStack(JourneyItems.crackenCaneSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 15), new ItemStack(JourneyItems.collectorRock, 15), new ItemStack(JourneyItems.crakeBulbSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 15), new ItemStack(JourneyItems.collectorRock, 15), new ItemStack(JourneyItems.spineberrySeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 15), new ItemStack(JourneyItems.collectorRock, 15), new ItemStack(JourneyItems.glowaSeeds, 15)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 15), new ItemStack(JourneyItems.collectorRock, 15), new ItemStack(JourneyItems.zatSeeds, 15)));
		
	}
}