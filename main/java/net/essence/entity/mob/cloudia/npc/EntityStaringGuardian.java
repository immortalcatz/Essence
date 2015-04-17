package net.essence.entity.mob.cloudia.npc;

import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityStaringGuardian extends EntityModVillager {

	@SuppressWarnings("do this")
	public EntityStaringGuardian(World par1World) {
		super(par1World);
		setSize(0.7F, 1.0F);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.STARING_GUARDIAN;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		
	}
}