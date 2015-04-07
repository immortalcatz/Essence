package net.essence.client;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

public class DarkEnergyBar implements IExtendedEntityProperties {

	private int darkEnergy, regenDelay;

	public static DarkEnergyBar instance = new DarkEnergyBar();

	@Override
	public void saveNBTData(NBTTagCompound n) {
		n.setInteger("darkEnergy", 9);
		n.setInteger("regen", 20);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		this.darkEnergy = n.getInteger("darkEnergy");
		this.regenDelay = n.getInteger("regen");
	}

	public void updateAllBars() {
		darkEnergy += 1;
	}                

	@SideOnly(Side.CLIENT)
	public boolean useBar(int amount, World w) {
		if(darkEnergy < amount) {
			regenDelay = 10;
			return false;
		}
		darkEnergy -= amount;
		regenDelay = 10;
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void regen(int amount) {
		if(regenDelay == 0) darkEnergy += amount;
		else regenDelay -= 1;
	}

	public void mainUpdate() {
		if(darkEnergy >= 10) darkEnergy = 10;
	}

	public float getBarValue() {
		return darkEnergy;
	}

	public void addBarPoints(int i) {
		darkEnergy += i;
	}

	public void removeBarPoints(int i) {
		regenDelay = 10;
		darkEnergy -= i;
	}

	@Override
	public void init(Entity entity, World world) { }
}