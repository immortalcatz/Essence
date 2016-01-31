package net.journey.entity.mob.corba.npc;

import net.journey.JourneyItems;
import net.journey.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityTordo extends EntityModVillager {

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

	@SuppressWarnings("unchecked")
	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 15), new ItemStack(JourneyItems.overseeingEye, 15), new ItemStack(JourneyItems.healersBlade, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 32), new ItemStack(JourneyItems.collectorRock, 32), new ItemStack(JourneyItems.treeHugger, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 32), new ItemStack(JourneyItems.collectorRock, 64), new ItemStack(JourneyItems.multiToolOfEternalSmelting, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.enchantedLeaf, 32), new ItemStack(JourneyItems.corbaStick, 10), new ItemStack(JourneyItems.treehuggersHelmet, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.enchantedLeaf, 32), new ItemStack(JourneyItems.corbaStick, 10), new ItemStack(JourneyItems.treehuggersChest, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.enchantedLeaf, 32), new ItemStack(JourneyItems.corbaStick, 10), new ItemStack(JourneyItems.treehuggersLegs, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.enchantedLeaf, 32), new ItemStack(JourneyItems.corbaStick, 10), new ItemStack(JourneyItems.treehuggersBoots, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 10), new ItemStack(JourneyItems.overseeingEye, 32), new ItemStack(JourneyItems.leapersHelmet, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 10), new ItemStack(JourneyItems.overseeingEye, 32), new ItemStack(JourneyItems.leapersChest, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 10), new ItemStack(JourneyItems.overseeingEye, 32), new ItemStack(JourneyItems.leapersLegs, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.natureTablet, 10), new ItemStack(JourneyItems.overseeingEye, 32), new ItemStack(JourneyItems.leapersBoots, 1)));
		
	}
}