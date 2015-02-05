package net.essence.util;

import net.essence.EssenceItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.slayer.api.SlayerAPI;

public enum EnumArmor {

	HELLSTONE(SlayerAPI.addArmorMaterial("hellstone", 3000, new int[] {3, 4, 3, 2}, 10), "hellstone", false, 50, EssenceItems.hellstoneIngot),
	FLAIRIUM(SlayerAPI.addArmorMaterial("flairium", 3000, new int[] {3, 4, 3, 2}, 10), "flairium", false, 70, EssenceItems.flairiumIngot),
	CELESTIUM(SlayerAPI.addArmorMaterial("celestium", 3000, new int[] {3, 4, 3, 2}, 10), "celestium", false, 65, EssenceItems.celestiumIngot),
	LUNIUM(SlayerAPI.addArmorMaterial("lunium", 3000, new int[] {3, 4, 3, 2}, 10), "lunium", false, 40, EssenceItems.luniumIngot),
	SHADIUM(SlayerAPI.addArmorMaterial("shadium", 3000, new int[] {3, 4, 3, 2}, 10), "shadium", false, 40, EssenceItems.shadiumIngot),
	CONDENSED_DIAMOND(SlayerAPI.addArmorMaterial("condensedDiamond", 3000, new int[] {3, 4, 3, 2}, 10), "condensedDiamond", false, 60, Blocks.diamond_block),
	SAPPHIRE(SlayerAPI.addArmorMaterial("sapphire", 3000, new int[] {3, 4, 3, 2}, 10), "sapphire", false, 40, EssenceItems.sapphire),
	ORBADITE(SlayerAPI.addArmorMaterial("orbadite", 3000, new int[] {3, 4, 3, 2}, 10), "orbadite", false, 76, EssenceItems.orbaditeIngot),
	FLAME(SlayerAPI.addArmorMaterial("flame", 3000, new int[] {3, 4, 3, 2}, 10), "flame", false, 76, (Item)null),
	GORBITE(SlayerAPI.addArmorMaterial("gorbite", 3000, new int[] {3, 4, 3, 2}, 10), "gorbite", false, 76, EssenceItems.gorbiteGem);
	
	private ArmorMaterial armorMaterial;
	private String type;
	private boolean undamageable;
	private int damageReduction;
	private Item repairItem;

	private EnumArmor(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction, Item repair) {
		this.armorMaterial = armorMaterial;
		this.type = type;
		this.undamageable = undamageable;
		this.damageReduction = damageReduction;
		this.repairItem = repair;
	}

	private EnumArmor(ArmorMaterial armorMaterial, String type, boolean undamageable, int damageReduction, Block repair) {
		this.armorMaterial = armorMaterial;
		this.type = type;
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

	public boolean isUndamageable() {
		return undamageable;
	}

	public int getDamageReduction() {
		return damageReduction;
	}
}