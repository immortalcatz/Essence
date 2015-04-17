package net.essence.entity.mob.corba.npc;

import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityTordo extends EntityModVillager {

	@SuppressWarnings("do this")
	public EntityTordo(World par1World) {
		super(par1World);
		setSize(0.7F, 1.0F);
	}

	@Override
	public void abstractInteract(EntityPlayer p) {
		
	}

	@Override
	public GuiIDs guiID() {
		return GuiIDs.TORDO;
	}

	@Override
	public void addRecipies(MerchantRecipeList list) {
		
	}
}