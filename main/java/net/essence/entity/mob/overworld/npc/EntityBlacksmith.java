package net.essence.entity.mob.overworld.npc;

import net.essence.EssenceItems;
import net.essence.client.GuiHandler.GuiIDs;
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

public class EntityBlacksmith extends EntityModVillager {

	public EntityBlacksmith(World var1) {
		super(var1);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		switch(rand.nextInt(3)) {
		case 0:
			SlayerAPI.addFormattedChatMessage(p, "smith.valuables");
			break;
		case 1:
			SlayerAPI.addFormattedChatMessage(p, "smith.greetings");
			break;
		case 2:
			SlayerAPI.addFormattedChatMessage(p, "smith.deals");
			break;
		}
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(EssenceItems.dragonsTooth);
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.BLACKSMITH;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(EssenceItems.yellowGem, 10), new ItemStack(EssenceItems.backBiter)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(EssenceItems.purpleGem, 10), new ItemStack(EssenceItems.dawnBreaker)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(EssenceItems.purpleGem, 10), new ItemStack(EssenceItems.tempestBattleaxe)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(EssenceItems.greenGem, 10), new ItemStack(EssenceItems.dragonsTooth)));
		list.add(new MerchantRecipe(new ItemStack(Items.potionitem, 1, 8228), new ItemStack(Items.potionitem, 1, 8228), new ItemStack(EssenceItems.poisonSword)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 10), new ItemStack(Blocks.wool, 64), new ItemStack(EssenceItems.cloudSlicer)));
	}
}