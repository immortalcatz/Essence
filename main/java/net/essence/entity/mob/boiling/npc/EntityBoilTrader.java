package net.essence.entity.mob.boiling.npc;

import net.essence.EssenceItems;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityBoilTrader extends EntityModVillager {

	public EntityBoilTrader(World var1) {
		super(var1);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.BOIL_TRADER;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.ash, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.flamingBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.ash, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.boilingBlade, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.ash, 10), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.moltenKnife, 15)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.boilingSkull, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.charskullHelmet, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.boilingSkull, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.charskullChest, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.boilingSkull, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.charskullLegs, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.boilingSkull, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.charskullBoots, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.snakeFlesh, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.snakeskinHelmet, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.snakeFlesh, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.snakeskinChest, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.snakeFlesh, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.snakeskinLegs, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.snakeFlesh, 15), new ItemStack(EssenceItems.boilPowder, 10), new ItemStack(EssenceItems.snakeskinBoots, 1)));
		
	}
}