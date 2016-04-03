package net.journey.entity.mob.terrania.npc;

import net.journey.JourneyItems;
import net.journey.client.GuiHandler.GuiIDs;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModVillager;

public class EntityTerranianEnchanter extends EntityModVillager {

	public EntityTerranianEnchanter(World var1) {
		super(var1);
		setSize(2.0F, 4.0F);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		switch(rand.nextInt(3)) {
		case 0:
			SlayerAPI.addFormattedChatMessage(p, "enchanter.enchant");
			break;
		case 1:
			SlayerAPI.addFormattedChatMessage(p, "enchanter.suspicion");
			break;
		case 2:
			SlayerAPI.addFormattedChatMessage(p, "enchanter.magic");
			break;
		}
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.TERRANIAN_ENCHANTER;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(JourneyItems.purpleGem, 10), new ItemStack(JourneyItems.dawnBreaker)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(JourneyItems.purpleGem, 10), new ItemStack(JourneyItems.tempestBattleaxe)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(JourneyItems.greenGem, 10), new ItemStack(JourneyItems.dragonsTooth)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(JourneyItems.greenGem, 10), new ItemStack(JourneyItems.poisonSword)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(JourneyItems.blueGem, 64), new ItemStack(JourneyItems.cloudSlicer)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(JourneyItems.yellowGem, 10), new ItemStack(JourneyItems.backBiter)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.blueGem, 10), new ItemStack(JourneyItems.yellowGem, 10), new ItemStack(JourneyItems.sunsetPiercer, 1)));
		//list.add(new MerchantRecipe(new ItemStack(JourneyItems.blueGem, 10), new ItemStack(JourneyItems.yellowGem, 10), new ItemStack(JourneyItems.aquaticKnife, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.purpleGem, 10), new ItemStack(JourneyItems.greenGem, 10), new ItemStack(JourneyItems.poisonBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.purpleGem, 10), new ItemStack(JourneyItems.yellowGem, 10), new ItemStack(JourneyItems.darknessBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.purpleGem, 10), new ItemStack(JourneyItems.blueGem, 10), new ItemStack(JourneyItems.frozenBow, 1)));
	}
}