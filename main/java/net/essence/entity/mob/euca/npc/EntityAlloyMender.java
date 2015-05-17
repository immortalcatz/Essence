package net.essence.entity.mob.euca.npc;

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

	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.golderDust, 15), new ItemStack(EssenceItems.goldClump, 15), new ItemStack(EssenceItems.royalBlade, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.golderDust, 10), new ItemStack(EssenceItems.goldClump, 10), new ItemStack(EssenceItems.royalKnife, 15)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.celestiumIngot, 15), new ItemStack(EssenceItems.mekyumIngot, 10), new ItemStack(EssenceItems.celekiumBattleaxe, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.celestiumIngot, 15), new ItemStack(EssenceItems.koriteIngot, 10), new ItemStack(EssenceItems.celestiteBattleaxe, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.storonIngot, 15), new ItemStack(EssenceItems.mekyumIngot, 10), new ItemStack(EssenceItems.storumBattleaxe, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.storonIngot, 15), new ItemStack(EssenceItems.koriteIngot, 10), new ItemStack(EssenceItems.bronzedBattleaxe, 1)));
	}
}