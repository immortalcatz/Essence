package net.journey.entity.mob.depths.npc;

import net.journey.JourneyItems;
import net.journey.client.GuiHandler.GuiIDs;
import net.journey.items.ItemPresent;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModVillager;

public class EntityStaringGuardian extends EntityModVillager {

	@SuppressWarnings("do this")
	public EntityStaringGuardian(World var1) {
		super(var1);
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.STARING_GUARDIAN;
	}
	
	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.depthsFlake, 15), new ItemStack(JourneyItems.darkCrystal, 15), new ItemStack(JourneyItems.depthsSlayer, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.depthsFlake, 15), new ItemStack(JourneyItems.beastlyStomach, 15), new ItemStack(JourneyItems.depthsBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.depthsFlake, 15), new ItemStack(JourneyItems.depthsSlayer, 1), new ItemStack(JourneyItems.depthsDarksword, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.depthsFlake, 15), new ItemStack(JourneyItems.depthsBow, 1), new ItemStack(JourneyItems.darkEnforcer, 1)));
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		
	}
}