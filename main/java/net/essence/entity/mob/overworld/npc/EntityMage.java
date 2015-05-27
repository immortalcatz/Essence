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

public class EntityMage extends EntityModVillager {

	public EntityMage(World var1) {
		super(var1);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		switch(rand.nextInt(3)) {
		case 0:
			SlayerAPI.addFormattedChatMessage(p, "mage.valuables");
			break;
		case 1:
			SlayerAPI.addFormattedChatMessage(p, "mage.greetings");
			break;
		case 2:
			SlayerAPI.addFormattedChatMessage(p, "mage.deals");
			break;
		}
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(EssenceItems.conjuringStaff);
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.MAGE;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 1), new ItemStack(Items.gold_ingot, 5), new ItemStack(EssenceItems.wandBase)));
		list.add(new MerchantRecipe(new ItemStack(Items.stick, 1), new ItemStack(Items.diamond, 2), new ItemStack(EssenceItems.staffBase)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.staffBase, 1), new ItemStack(EssenceItems.greenGem, 15), new ItemStack(EssenceItems.staffOfGreenpace)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.staffBase, 1), new ItemStack(EssenceItems.hellstoneIngot, 15), new ItemStack(EssenceItems.staffOfHellstone)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.staffBase, 1), new ItemStack(EssenceItems.purpleGem, 15), new ItemStack(EssenceItems.doomsBringer)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.staffBase, 1), new ItemStack(EssenceItems.yellowGem, 5), new ItemStack(EssenceItems.wizardsStar)));
		//list.add(new MerchantRecipe(new ItemStack(EssenceItems.staffBase, 1), new ItemStack(EssenceItems.hellstoneIngot, 5), new ItemStack(EssenceItems.chaosCannon)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.staffBase, 1), new ItemStack(EssenceItems.blueGem, 15), new ItemStack(EssenceItems.staffOfEnlightenment)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.greenGem, 10), new ItemStack(EssenceItems.staffOfGreenpace, 1), new ItemStack(EssenceItems.conjuringStaff)));		
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.wandBase, 1), new ItemStack(Blocks.ice, 32), new ItemStack(EssenceItems.iceWand)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.wandBase, 1), new ItemStack(Items.fire_charge, 32), new ItemStack(EssenceItems.fireWand)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.wandBase, 1), new ItemStack(Items.diamond, 32), new ItemStack(EssenceItems.lightningWand)));
	}
}