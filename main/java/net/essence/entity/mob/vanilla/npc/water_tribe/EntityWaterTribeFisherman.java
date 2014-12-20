package net.essence.entity.mob.vanilla.npc.water_tribe;

import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityWaterTribeFisherman extends EntityModVillager {

	public EntityWaterTribeFisherman(World var1) {
		super(var1);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		
	}

	@Override
	public GuiIDs guiID() {
		return null;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.fishing_rod);
	}
}