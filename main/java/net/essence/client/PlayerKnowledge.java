package net.essence.client;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerKnowledge implements IExtendedEntityProperties {

	public int overworldKnowledge = 0, netherKnowledge = 0, endKnowledge = 0;
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		
	}

	@Override
	public void init(Entity entity, World world) {
		
	}
}