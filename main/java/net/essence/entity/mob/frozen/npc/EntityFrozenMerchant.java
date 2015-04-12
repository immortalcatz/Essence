package net.essence.entity.mob.frozen.npc;

import net.essence.EssenceItems;
import net.essence.client.GuiHandler.GuiIDs;
import net.essence.items.ItemPresent;
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

public class EntityFrozenMerchant extends EntityModVillager {

	public EntityFrozenMerchant(World var1) {
		super(var1);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		switch(rand.nextInt(3)) {
		case 0:
			SlayerAPI.addFormattedChatMessage(p, "elf.welcome");
			break;
		case 1:
			SlayerAPI.addFormattedChatMessage(p, "elf.hello");
			break;
		case 2:
			SlayerAPI.addFormattedChatMessage(p, "elf.good");
			break;
		}
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.FROZEN_MERCHANT;
	}
	
	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.crystalFlake, 15), new ItemStack(EssenceItems.frostGem, 15), new ItemStack(EssenceItems.frostySword, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.crystalFlake, 15), new ItemStack(EssenceItems.frostGem, 15), new ItemStack(EssenceItems.frostyBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.crystalFlake, 15), new ItemStack(EssenceItems.frostGem, 15), new ItemStack(EssenceItems.frostyPiercer, 32)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.frostFlake, 15), new ItemStack(EssenceItems.frostySword, 1), new ItemStack(EssenceItems.frostbittenSword, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.frostFlake, 15), new ItemStack(EssenceItems.frostyBow, 1), new ItemStack(EssenceItems.frostbittenBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.frostFlake, 15), new ItemStack(EssenceItems.frostyPiercer, 1), new ItemStack(EssenceItems.frostbittenPiercer, 32)));
		
	}
}