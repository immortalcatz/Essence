package net.essence.util;

import net.essence.EssenceItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.slayer.api.SlayerAPI;

public enum EnumArmor {

	HELLSTONE(SlayerAPI.addArmorMaterial("hellstone", 3000, new int[] {3, 4, 3, 2}, 10), "hellstone", false, 50, EssenceItems.hellstoneIngot, "Hellstone"),
	FLAIRIUM(SlayerAPI.addArmorMaterial("flairium", 3000, new int[] {3, 4, 3, 2}, 10), "flairium", false, 70, EssenceItems.flairiumIngot, "Flairium"),
	CELESTIUM(SlayerAPI.addArmorMaterial("celestium", 3000, new int[] {3, 4, 3, 2}, 10), "celestium", false, 65, EssenceItems.celestiumIngot, "Celestium"),
	LUNIUM(SlayerAPI.addArmorMaterial("lunium", 3000, new int[] {3, 4, 3, 2}, 10), "lunium", false, 40, EssenceItems.luniumIngot, "Lunium"),
	SHADIUM(SlayerAPI.addArmorMaterial("shadium", 3000, new int[] {3, 4, 3, 2}, 10), "shadium", false, 40, EssenceItems.shadiumIngot, "Shadium"),
	SAPPHIRE(SlayerAPI.addArmorMaterial("sapphire", 3000, new int[] {3, 4, 3, 2}, 10), "sapphire", false, 40, EssenceItems.sapphire, "Sapphire"),
	ORBADITE(SlayerAPI.addArmorMaterial("orbadite", 3000, new int[] {3, 4, 3, 2}, 10), "orbadite", false, 76, EssenceItems.orbaditeIngot, "Orbadite"),
	GORBITE(SlayerAPI.addArmorMaterial("gorbite", 3000, new int[] {3, 4, 3, 2,}, 10), "gorbite", false, 76, EssenceItems.gorbiteGem, "Gorbite"),
	FLAME(SlayerAPI.addArmorMaterial("flame", 3000, new int[] {3, 4, 3, 2}, 10), "flame", false, 76, (Item)null, "Flame"),
	TWILIGHT(SlayerAPI.addArmorMaterial("twilight", 3000, new int[] {3, 4, 3, 2}, 10), "twilight", false, 76, (Item)null, "Twilight"),
	SNAKESKIN(SlayerAPI.addArmorMaterial("snakeskin", 3000, new int[] {3, 4, 3, 2,}, 10), "snakeskin", false, 76, (Item)null, "Snakeskin"),
	CHAR_SKULL(SlayerAPI.addArmorMaterial("charSkull", 3000, new int[] {3, 4, 3, 2}, 10), "charSkull", false, 76, (Item)null, "Char Skull"),
	LEAPERS(SlayerAPI.addArmorMaterial("leapers", 3000, new int[] {3, 4, 3, 2}, 10), "leapers", false, 76, (Item)null, "Leapers"),
	TREEHUGGERS(SlayerAPI.addArmorMaterial("treehuggers", 3000, new int[] {3, 4, 3, 2}, 10), "treehuggers", false, 76, (Item)null, "Tree Huggers");
	
	private ArmorMaterial armorMaterial;
	private String type, finalName;
	private boolean undamageable;
	private int damageReduction;
	private Item repairItem;

	private EnumArmor(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction, Item repair, String finalName) {
		this.armorMaterial = armorMaterial;
		this.type = type;
		this.finalName = finalName;
		this.undamageable = undamageable;
		this.damageReduction = damageReduction;
		this.repairItem = repair;
	}

	private EnumArmor(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction, Block repair, String finalName) {
		this.armorMaterial = armorMaterial;
		this.type = type;
		this.finalName = finalName;
		this.undamageable = undamageable;
		this.damageReduction = damageReduction;
		this.repairItem = SlayerAPI.toItem(repair);
	}

	public Item getRepairItem(){
		return repairItem;
	}

	public ArmorMaterial getArmorMaterial() {
		return armorMaterial;
	}

	public String getType() {
		return type;
	}
	
	public String getFinalName() {
		return finalName;
	}

	public boolean isUndamageable() {
		return undamageable;
	}

	public int getDamageReduction() {
		return damageReduction;
	}
}