package net.essence.entity.mob.cloudia.npc;

import net.essence.EssenceItems;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityStarlightVillager extends EntityModVillager {

	public EntityStarlightVillager(World par1World) {
		super(par1World);
		setSize(2.2F, 2.5F);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.STARLIGHT_VILLAGER;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addRecipies(MerchantRecipeList list) {
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.fluffyFeather, 32), new ItemStack(EssenceItems.golemChunk, 16), new ItemStack(EssenceItems.cloudiaOrb, 1)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.fluffyFeather, 64), new ItemStack(EssenceItems.golemChunk, 32), new ItemStack(EssenceItems.luniteChunk, 8)));
		list.add(new MerchantRecipe(new ItemStack(EssenceItems.cloudiaOrb, 15), new ItemStack(EssenceItems.luniteChunk, 16), new ItemStack(EssenceItems.mysteriousDisk, 1)));
		
	}
}