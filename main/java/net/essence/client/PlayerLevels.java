package net.essence.client;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerLevels implements IExtendedEntityProperties {

	private int experienceLevel, experienceTotal, coins;
	public float levelXP;
	public int maxStatLevel = 10, bowTotal, bowExperience, witherTotal, witherExperience, hoeTotal, hoeExperience, pickTotal, pickExperience;
	public float bowXP, witherXP, pickXP, hoeXP;
	public String NBT_NAME = "PlayerLevels";
	private final EntityPlayer player;
	private Random rand = new Random();

	public PlayerLevels(EntityPlayer p) {
		player = p;
	}

	@Override
	public void saveNBTData(NBTTagCompound n) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("bowTotal", bowTotal);
		nbt.setInteger("playerLevel", experienceTotal);
		nbt.setInteger("playerExperience", experienceLevel);
		nbt.setInteger("bowExperience", bowExperience);
		nbt.setInteger("witherTotal", witherTotal);
		nbt.setInteger("witherExperience", witherExperience);
		nbt.setInteger("hoeTotal", hoeTotal);
		nbt.setInteger("hoeExperience", hoeExperience);
		nbt.setInteger("pickTotal", pickTotal);
		nbt.setInteger("pickExperience", pickExperience);
		nbt.setFloat("bowXP", bowXP);
		nbt.setFloat("playerXP", levelXP);
		nbt.setFloat("witherXP", witherXP);
		nbt.setFloat("hoeXP", hoeXP);
		nbt.setFloat("pickXP", pickXP);
		nbt.setTag(NBT_NAME, nbt);
	}

	@Override
	public void loadNBTData(NBTTagCompound n) {
		NBTTagCompound nbt = (NBTTagCompound)n.getCompoundTag(NBT_NAME);
		bowTotal = nbt.getInteger("bowTotal");
		bowExperience = nbt.getInteger("bowExperience");
		experienceLevel = nbt.getInteger("playerExperience");
		experienceTotal = nbt.getInteger("playerLevel");
		witherTotal = nbt.getInteger("witherTotal");
		witherExperience = nbt.getInteger("witherExperience");
		hoeTotal = nbt.getInteger("hoeTotal");
		hoeExperience = nbt.getInteger("hoeExperience");
		pickTotal = nbt.getInteger("pickTotal");
		pickExperience = nbt.getInteger("pickExperience");
		bowXP = nbt.getFloat("bowXP");
		levelXP = nbt.getFloat("playerXP");
		witherXP = nbt.getFloat("witherXP");
		hoeXP = nbt.getFloat("hoeXP");
		pickXP = nbt.getFloat("pickXP");
	}

	private void addWitherLevel(int par1, EntityPlayer p) {
		int field_82249_h;
		field_82249_h = p.ticksExisted;

		witherExperience += par1;

		if (witherExperience < 0) {
			witherExperience = 0;
			witherXP = 0.0F;
			witherTotal = 0;
		}

		if (par1 > 0 && witherExperience % 5 == 0 && (float)field_82249_h < (float)p.ticksExisted - 100.0F) {
			float f = witherExperience > 30 ? 1.0F : (float)witherExperience / 30.0F;
		}
	}

	private void addBowLevel(int par1, EntityPlayer p) {
		int field_82249_h;
		field_82249_h = p.ticksExisted;

		bowExperience += par1;

		if (bowExperience < 0) {
			bowExperience = 0;
			bowXP = 0.0F;
			bowTotal = 0;
		}

		if (par1 > 0 && bowExperience % 5 == 0 && (float)field_82249_h < (float)p.ticksExisted - 100.0F) {
			float f = bowExperience > 30 ? 1.0F : (float)bowExperience / 30.0F;
		}
	}

	private void addHoeLevel(int par1, EntityPlayer p) {
		int field_82249_h;
		field_82249_h = p.ticksExisted;

		hoeExperience += par1;

		if (hoeExperience < 0) {
			hoeExperience = 0;
			hoeXP = 0.0F;
			hoeTotal = 0;
		}

		if (par1 > 0 && hoeExperience % 5 == 0 && (float)field_82249_h < (float)p.ticksExisted - 100.0F) {
			float f = hoeExperience > 30 ? 1.0F : (float)hoeExperience / 30.0F;
		}
	}

	private void addPickaxeLevel(int par1, EntityPlayer p) {
		int field_82249_h;
		field_82249_h = p.ticksExisted;

		pickExperience += par1;

		if (pickExperience < 0) {
			pickExperience = 0;
			pickXP = 0.0F;
			pickTotal = 0;
		}

		if (par1 > 0 && pickExperience % 5 == 0 && (float)field_82249_h < (float)p.ticksExisted - 100.0F) {
			float f = pickExperience > 30 ? 1.0F : (float)pickExperience / 30.0F;
		}
	}

	public void addHoeExperience(int par1, EntityPlayer player) {
		int j = Integer.MAX_VALUE - hoeTotal;

		if (par1 > j) {
			par1 = j;
		}

		hoeXP += (float)par1 / (float)normalCap();

		for (hoeTotal += par1; hoeXP >= 1.0F; hoeXP /= (float)normalCap()) {
			hoeXP = (hoeXP - 1.0F) * (float)18;
			addHoeLevel(1, player);
			addExperience((int)((float)rand.nextInt(15) / 2), player);
		}
	}

	public void addPickaxeExperience(int par1, EntityPlayer player) {
		int j = Integer.MAX_VALUE - pickTotal;

		if (par1 > j) {
			par1 = j;
		}

		pickXP += (float)par1 / (float)normalCap();

		for (pickTotal += par1; pickXP >= 1.0F; pickXP /= (float)normalCap()) {
			pickXP = (pickXP - 1.0F) * (float)18;
			addPickaxeLevel(1, player);
			addExperience((int)((float)rand.nextInt(15) / 2), player);
		}
	}

	public void addWitherExperience(int par1, EntityPlayer player) {
		int j = Integer.MAX_VALUE - witherTotal;

		if (par1 > j) {
			par1 = j;
		}

		witherXP += (float)par1 / (float)normalCap();

		for (witherTotal += par1; witherXP >= 1.0F; witherXP /= (float)normalCap()) {
			witherXP = (witherXP - 1.0F) * (float)18;
			addWitherLevel(1, player);
			addExperience((int)((float)rand.nextInt(15) / 2), player);
		}
	}

	public void addBowExperience(int par1, EntityPlayer player) {
		int j = Integer.MAX_VALUE - bowTotal;

		if (par1 > j) {
			par1 = j;
		}

		bowXP += (float)par1 / (float)normalCap();

		for(bowTotal += par1; bowXP >= 1.0F; bowXP /= (float)normalCap()) {
			bowXP = (bowXP - 1.0F) * (float)18;
			addBowLevel(1, player);
			addExperience((int)((float)rand.nextInt(15) / 2), player);
		}
	}

	public void addExperience(int par1, EntityPlayer player) {
		int j = Integer.MAX_VALUE - experienceTotal;

		if(par1 > j) 
			par1 = j;

		levelXP += (float)par1 / (float)xpBarCap();

		for(experienceTotal += par1; levelXP >= 1.0F; levelXP /= (float)xpBarCap()) {
			levelXP = (levelXP - 1.0F) * (float)xpBarCap();
			addLevel(1);
		}
	}

	public void addLevel(int par1) {
		experienceLevel += par1;
		levelXP = 0.0F;
		experienceTotal = 0;
	}

	public int xpBarCap() {
		return experienceLevel >= 10 ? 2 : experienceLevel >= 40 ? 5 : experienceLevel >= 90 ? 8 : experienceLevel >= 150 ? 10 : experienceLevel >= 200 ? 15 : 17;
	}

	public int normalCap(){
		return 23;
	}

	public int getPlayerLevel() {
		return experienceLevel;
	}

	public int getBowExperience(){
		return bowExperience;
	}

	public int getWitherExperience(){
		return witherExperience;
	}

	public int getPickaxeExperience(){
		return pickExperience;
	}

	public int getHoeExperience(){
		return hoeExperience;
	}

	@Override
	public void init(Entity entity, World world) { }
}