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
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 15), new ItemStack(EssenceItems.overseeingEye, 15), new ItemStack(EssenceItems.healersBlade, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 32), new ItemStack(EssenceItems.collectorRock, 32), new ItemStack(EssenceItems.treeHugger, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 32), new ItemStack(EssenceItems.collectorRock, 64), new ItemStack(EssenceItems.multiToolOfEternalSmelting, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.enchantedLeaf, 32), new ItemStack(EssenceItems.corbaStick, 10), new ItemStack(EssenceItems.treehuggersHelmet, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.enchantedLeaf, 32), new ItemStack(EssenceItems.corbaStick, 10), new ItemStack(EssenceItems.treehuggersChest, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.enchantedLeaf, 32), new ItemStack(EssenceItems.corbaStick, 10), new ItemStack(EssenceItems.treehuggersLegs, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.enchantedLeaf, 32), new ItemStack(EssenceItems.corbaStick, 10), new ItemStack(EssenceItems.treehuggersBoots, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 10), new ItemStack(EssenceItems.overseeingEye, 32), new ItemStack(EssenceItems.leapersHelmet, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 10), new ItemStack(EssenceItems.overseeingEye, 32), new ItemStack(EssenceItems.leapersChest, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 10), new ItemStack(EssenceItems.overseeingEye, 32), new ItemStack(EssenceItems.leapersLegs, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.natureTablet, 10), new ItemStack(EssenceItems.overseeingEye, 32), new ItemStack(EssenceItems.leapersBoots, 1)));
		
	}
}