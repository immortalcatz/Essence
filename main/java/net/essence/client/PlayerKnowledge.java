package net.essence.client;

import net.essence.enums.EnumKnowledge;
import net.essence.util.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerKnowledge implements IExtendedEntityProperties {

	public int[] knowledge = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public int[] xpTotal = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public float[] xp = new float[] {0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F};
	public String[] knowledgeNames = {"overworld", "nether", "end", "boil", "frozen", "euca", "depths", "corba", "cloudia", "wasteland", "lithium", "library", "blaze", "wither"};

	public static PlayerKnowledge instance = new PlayerKnowledge();
	
	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		for(int i = 0; i < knowledgeNames.length; i++) {
			nbt.setInteger(knowledgeNames[i] + "Knowledge", knowledge[i]);
			nbt.setInteger(knowledgeNames[i] + "XPTotal", xpTotal[i]);
			nbt.setFloat(knowledgeNames[i] + "XP", xp[i]);
		}
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		for(int i = 0; i < knowledgeNames.length; i++) {
			knowledge[i] = nbt.getInteger(knowledgeNames[i] + "Knowledge");
			xpTotal[i] = nbt.getInteger(knowledgeNames[i] + "XPTotal");
			xp[i] = nbt.getFloat(knowledgeNames[i] + "XP");
		}
	}

	public EnumKnowledge getKnowledgeFromDimension(int dim) {
		switch(dim) {
		case -1: return EnumKnowledge.NETHER;
		case 0: return EnumKnowledge.OVERWORLD;
		case 1: return EnumKnowledge.END;
		}
		if(dim == Config.frozen) return EnumKnowledge.FROZEN;
		else if(dim == Config.boil) return EnumKnowledge.BOIL;
		else if(dim == Config.euca) return EnumKnowledge.EUCA;
		else if(dim == Config.depths) return EnumKnowledge.DEPTHS;
		else if(dim == Config.corba) return EnumKnowledge.CORBA;
		else if(dim == Config.wastelands) return EnumKnowledge.WASTELANDS;
		else return EnumKnowledge.OVERWORLD;
	}
	
	public int getKnowledge(EnumKnowledge knowledge) {
		switch(knowledge) {
		case OVERWORLD: return 0;
		case NETHER: return 1;
		case END: return 2;
		case BOIL: return 3;
		case FROZEN: return 4;
		case EUCA: return 5;
		case DEPTHS: return 6;
		case CORBA: return 7;
		case CLOUDIA: return 8;
		case WASTELANDS: return 9;
		case LITHIUM: return 10;
		case LIBRARY: return 11;
		case BLAZE:	return 12;
		case WITHER: return 13;
		default: return 0;
		}
	}

	public void addExperience(int amount, EnumKnowledge type, EntityPlayer player) {
		int kind = getKnowledge(type);
		int j = Integer.MAX_VALUE - xpTotal[kind];
		if(amount > j) amount = j;
		xp[kind] += (float)amount / (float)xpBarCap(type);
		for(xpTotal[kind] += amount; xp[kind] >= 1.0F; xp[kind] /= (float)xpBarCap(type)) {
			xp[kind] = (xp[kind] - 1.0F) * (float)xpBarCap(type);
			addLevel(1, type);
		}
	}

	public void addLevel(int amount, EnumKnowledge type) {
		int kind = getKnowledge(type);
		if(knowledge[kind] < 0) {
			knowledge[kind] = 0;
			xp[kind] = 0.0F;
			xpTotal[kind] = 0;
		}
	}

	public int xpBarCap(EnumKnowledge type) {
		int kind = getKnowledge(type);
		return knowledge[kind] >= 10 ? 2 : knowledge[kind] >= 40 ? 5 : knowledge[kind] >= 90 ? 8 : knowledge[kind] >= 150 ? 10 : knowledge[kind] >= 200 ? 15 : 17;
	}
	
	public boolean hasEnoughKnowledge(int amount, EnumKnowledge type) {
		int kind = getKnowledge(type);
		return knowledge[kind] >= amount;
	}

	@Override
	public void init(Entity entity, World world) { }
}