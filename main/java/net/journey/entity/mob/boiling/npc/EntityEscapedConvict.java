package net.journey.entity.mob.boiling.npc;

import net.journey.client.GuiHandler.GuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModVillager;

public class EntityEscapedConvict extends EntityModVillager {

	public EntityEscapedConvict(World var1) {
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
}