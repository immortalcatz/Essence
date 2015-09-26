package net.essence.entity.mob.cloudia.npc;

import net.essence.EssenceItems;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityStarlightBlacksmith extends EntityModVillager {

	public EntityStarlightBlacksmith(World par1World) {
		super(par1World);
		setSize(2.2F, 2.5F);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.STARLIGHT_BLACKSMITH;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.fluffyFeather, 15), new ItemStack(EssenceItems.golemChunk, 5), new ItemStack(EssenceItems.golemSword, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.fluffyFeather, 15), new ItemStack(EssenceItems.golemChunk, 5), new ItemStack(EssenceItems.golemBow, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.luniteChunk, 15), new ItemStack(EssenceItems.golemChunk, 15), new ItemStack(EssenceItems.starlightBlade, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.luniteChunk, 15), new ItemStack(EssenceItems.golemChunk, 15), new ItemStack(EssenceItems.starlightBow, 1)));
		
	}
}