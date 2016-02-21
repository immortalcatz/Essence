package net.journey.entity.mob.corba.npc;

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

public class EntityOvergrownMerchant extends EntityModVillager {

	public EntityOvergrownMerchant(World var1) {
		super(var1);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		switch(rand.nextInt(3)) {
		case 0:
			SlayerAPI.addFormattedChatMessage(p, "Herro");
			break;
		case 1:
			SlayerAPI.addFormattedChatMessage(p, "Ayyy lmao");
			break;
		case 2:
			SlayerAPI.addFormattedChatMessage(p, "lol wut");
			break;
		}
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.OVERGROWN_MERCHANT;
	}
	
	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.crystalFlake, 15), new ItemStack(JourneyItems.frostGem, 15), new ItemStack(JourneyItems.frostySword, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.crystalFlake, 15), new ItemStack(JourneyItems.frostGem, 15), new ItemStack(JourneyItems.frostyBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.crystalFlake, 10), new ItemStack(JourneyItems.frostGem, 10), new ItemStack(JourneyItems.frostyPiercer, 15)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.frostFlake, 15), new ItemStack(JourneyItems.frostySword, 1), new ItemStack(JourneyItems.frostbittenSword, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.frostFlake, 15), new ItemStack(JourneyItems.frostyBow, 1), new ItemStack(JourneyItems.frostbittenBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(JourneyItems.frostFlake, 10), new ItemStack(JourneyItems.frostyPiercer, 10), new ItemStack(JourneyItems.frostbittenPiercer, 15)));
		
	}
}