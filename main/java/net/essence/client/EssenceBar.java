package net.essence.client;

import net.essence.util.Helper;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EssenceBar implements IExtendedEntityProperties {

	private int essence, regenDelay;

	public static EssenceBar instance = new EssenceBar();

	@Override
	public void saveNBTData(NBTTagCompound n) {
		n.setInteger("essence", 9);
		n.setInteger("regen", 20);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		this.essence = n.getInteger("essence");
		this.regenDelay = n.getInteger("regen");
	}

	public void updateAllBars() {
		essence += 1;
	}        

	public void mainUpdate() {
		if(essence >= 10) essence = 10;
	}

	public boolean useBar(int amount, World w) {
		if(!w.isRemote) {
			if(essence < amount) {
				regenDelay = 10;
				return false;
			}
			essence -= amount;
			regenDelay = 10;
			return true;
		}
		return true;
	}

	public void regen(int amount) {
		if(regenDelay == 0) essence += amount;
		else regenDelay -= 1;
	}

	public float getBarValue() {
		return essence;
	}

	public void addBarPoints(int i) {
		essence += i;
	}

	public void removeBarPoints(int i) {
		regenDelay = 10;
		essence -= i;
	}

	@Override
	public void init(Entity entity, World world) { }
}