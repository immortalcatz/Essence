package net.essence.entity.mob.euca.npc;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModVillager;

public class EntityAlloyMender extends EntityModVillager {

	public EntityAlloyMender(World var1) {
		super(var1);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		switch(rand.nextInt(3)) {
		case 0:
			SlayerAPI.addFormattedChatMessage(p, "mender.welcome");
			break;
		case 1:
			SlayerAPI.addFormattedChatMessage(p, "mender.hello");
			break;
		case 2:
			SlayerAPI.addFormattedChatMessage(p, "mender.good");
			break;
		}
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.ALLOY_MENDER;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.shimmerdust, 64), new ItemStack(EssenceItems.metalDisk, 1), new ItemStack(EssenceItems.royalBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.golderDust, 16), new ItemStack(EssenceItems.goldClump, 16), new ItemStack(EssenceItems.royalBlade, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.golderDust, 10), new ItemStack(EssenceItems.goldClump, 10), new ItemStack(EssenceItems.royalKnife, 16)));
		list.add(new MerchantRecipe(new ItemStack(EssenceBlocks.celestiumBlock, 8), new ItemStack(EssenceBlocks.mekyumBlock, 8), new ItemStack(EssenceItems.celekiumBattleaxe, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceBlocks.celestiumBlock, 7), new ItemStack(EssenceBlocks.koriteBlock, 7), new ItemStack(EssenceItems.celestiteBattleaxe, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceBlocks.storonBlock, 6), new ItemStack(EssenceItems.mekyumIngot, 6), new ItemStack(EssenceItems.storumBattleaxe, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceBlocks.storonBlock, 5), new ItemStack(EssenceItems.koriteIngot, 5), new ItemStack(EssenceItems.bronzedBattleaxe, 1)));
	}
}