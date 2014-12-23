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

public class EntityGreenElf extends EntityModVillager {

	public EntityGreenElf(World var1) {
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
	public ItemStack getHeldItem() {
		return new ItemStack(EssenceItems.greenPresent);
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.GREEN_ELF;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.whitePresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.orangePresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.magentaPresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.lightBluePresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.yellowPresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.limePresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.pinkPresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.grayPresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.silverPresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.cyanPresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.purplePresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.bluePresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.brownPresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.greenPresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.redPresent)));
		list.add(new MerchantRecipe(new ItemStack(Items.paper, 32), new ItemStack(Items.leather, 32), new ItemStack(EssenceItems.blackPresent)));
	}
}