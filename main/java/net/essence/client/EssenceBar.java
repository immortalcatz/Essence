package net.essence.client;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EssenceBar implements IExtendedEntityProperties {

	private static int essence, regenDelay;

	@Override
	public void saveNBTData(NBTTagCompound n) {
		n.setInteger("essence", 400);
		n.setInteger("Regen", 20);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		this.essence = n.getInteger("essence");
		this.regenDelay = n.getInteger("Regen");
	}

	public static void updateAllBars() {
		if(essence != 400) regen(1);
		else regen(0);
		if(essence >= 400) essence = 400;
	}                

	public static boolean useBar(int amount) {
		if(essence < amount) {
			regenDelay = 20;
			return false;
		}
		essence -= amount;
		regenDelay = 20;
		return true;
	}

	public static void regen(int amount) {
		if(regenDelay == 0) essence += amount;
		else regenDelay -= 1;
	}

	public static float getBarValue() {
		return essence;
	}

	public static void addBarPoints(int i) {
		essence += i;
	}
	
	public static void removeBarPoints(int i) {
		regenDelay = 20;
		essence -= i;
	}

	@Override
	public void init(Entity entity, World world) { }
}