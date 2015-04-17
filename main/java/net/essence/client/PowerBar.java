package net.essence.client;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

public class PowerBar implements IExtendedEntityProperties {

	private int power, regenDelay;

	public static PowerBar instance = new PowerBar();

	@Override
	public void saveNBTData(NBTTagCompound n) {
		n.setInteger("power", 9);
		n.setInteger("regen", 20);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		this.power = n.getInteger("power");
		this.regenDelay = n.getInteger("regen");
	}

	public void updateAllBars() {
		power += 1;
	}                

	@SideOnly(Side.CLIENT)
	public boolean useBar(int amount, World w) {
		if(power < amount) {
			regenDelay = 10;
			return false;
		}
		power -= amount;
		regenDelay = 10;
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void regen(int amount) {
		if(regenDelay == 0) power += amount;
		else regenDelay -= 1;
	}

	public void mainUpdate() {
		if(power >= 10) power = 10;
	}

	public float getBarValue() {
		return power;
	}

	public void addBarPoints(int i) {
		power += i;
	}

	public void removeBarPoints(int i) {
		regenDelay = 10;
		power -= i;
	}

	@Override
	public void init(Entity entity, World world) { }
}