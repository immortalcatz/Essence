package net.essence.client;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class DarkEnergyBar implements IExtendedEntityProperties {

	private static int darkMagic, regenDelay;

	@Override
	public void saveNBTData(NBTTagCompound n) {
		n.setInteger("darkMagic", 400);
		n.setInteger("Regen", 20);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		this.darkMagic = n.getInteger("darkMagic");
		this.regenDelay = n.getInteger("Regen");
	}

	public static void updateAllBars() {
		if(darkMagic != 400) regen(1);
		else regen(0);
		if(darkMagic >= 400) darkMagic = 400;
	}                

	public static boolean useBar(int amount) {
		if(darkMagic < amount) {
			regenDelay = 20;
			return false;
		}
		darkMagic -= amount;
		regenDelay = 20;
		return true;
	}

	public static void regen(int amount) {
		if(regenDelay == 0) darkMagic += amount;
		else regenDelay -= 1;
	}

	public static float getBarValue() {
		return darkMagic;
	}

	public static void addBarPoints(int i) {
		darkMagic += i;
	}
	
	public static void removeBarPoints(int i) {
		regenDelay = 20;
		darkMagic -= i;
	}

	@Override
	public void init(Entity entity, World world) { }
}