package net.essence.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ModPlayerHealth implements IExtendedEntityProperties {

	private int health;
	private float regen;
	public String NBT_NAME = "CustomPlayerHealth";
	private static ModPlayerHealth INSTANCE = new ModPlayerHealth();
	
	public ModPlayerHealth getPlayer(EntityPlayer player) {
		return (ModPlayerHealth)player.getExtendedProperties(NBT_NAME);
	}
	
	public void register(EntityPlayer player) {
		player.registerExtendedProperties(NBT_NAME, new ModPlayerHealth());
	}
	
	@Override
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("Health", 50);
		nbt.setFloat("Regen", 20F);
		nbt.setTag(NBT_NAME, nbt);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound nbt = (NBTTagCompound)n.getCompoundTag(NBT_NAME);
		health = nbt.getInteger("Health");
		regen = nbt.getFloat("Regen");
	}
	
	public static ModPlayerHealth getInstance(){
		return INSTANCE;
	}

	public void updateHealth() {
		if(health != 50) regen(1);
		else regen(0);
		if(health >= 50) health = 50;
	}
	
	public void regen(int amount) {
		if(regen == 0) health += amount;
		else regen -= 1;
	}
	
	public void removeHealth(int remove) {
		health -= remove;
	}
	
	public int getHealth() {
		return health;
	}
	
	public float getRegenTimer() {
		return regen;
	}
	
	@Override
	public void init(Entity entity, World world) {
		EntityPlayer player = (EntityPlayer)entity;
	}
}