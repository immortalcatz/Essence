package net.journey.entity.mob.boiling.npc;

import net.journey.JourneyItems;
import net.journey.client.GuiHandler.GuiIDs;
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
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.ash, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.flamingBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.ash, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.boilingBlade, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.ash, 10), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.moltenKnife, 15)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.boilingSkull, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.charskullHelmet, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.boilingSkull, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.charskullChest, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.boilingSkull, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.charskullLegs, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.boilingSkull, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.charskullBoots, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.snakeFlesh, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.snakeskinHelmet, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.snakeFlesh, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.snakeskinChest, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.snakeFlesh, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.snakeskinLegs, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.snakeFlesh, 15), new ItemStack(JourneyItems.boilPowder, 10), new ItemStack(JourneyItems.snakeskinBoots, 1)));
		
	}
}