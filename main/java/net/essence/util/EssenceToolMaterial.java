package net.essence.util;

import net.essence.EssenceItems;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.slayer.api.SlayerAPI;

public enum EssenceToolMaterial {

	HELLSTONE_SWORD(SlayerAPI.addMeleeMaterial(1300, 9, 25), EssenceItems.hellstoneIngot),
	FLAIRIUM_SWORD(SlayerAPI.addMeleeMaterial(3000, 30, 25), EssenceItems.flairiumIngot),
	LUNIUM_SWORD(SlayerAPI.addMeleeMaterial(1000, 8, 25), EssenceItems.luniumIngot),
	CELESTIUM_SWORD(SlayerAPI.addMeleeMaterial(3000, 14, 25), EssenceItems.celestiumIngot),
	SHADIUM_SWORD(SlayerAPI.addMeleeMaterial(1000, 8, 25), EssenceItems.shadiumIngot),
	SAPPHIRE_SWORD(SlayerAPI.addMeleeMaterial(1000, 8, 25), EssenceItems.sapphire),

	NETHER_BEAST_SWORD(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	WITHERING_BEAST_SWORD(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	CALCIA_SWORD(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	CHAMPIONS_SWORD(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	THE_WRAITH(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	
	POISON_SWORD(SlayerAPI.addMeleeMaterial(1500, 8, 25)),
	CLOUD_SLICER(SlayerAPI.addMeleeMaterial(1500, 8, 25)),
	DRAGONS_TOOTH(SlayerAPI.addMeleeMaterial(1500, 8, 25)),

	HELLSTONE_PICKAXE(SlayerAPI.addPickMaterial(3, 1300, 13, 4, 25), EssenceItems.hellstoneIngot, 3),
	FLAIRIUM_PICKAXE(SlayerAPI.addPickMaterial(3, 3000, 13, 4, 25), EssenceItems.flairiumIngot, 3),
	LUNIUM_PICKAXE(SlayerAPI.addPickMaterial(3, 1000, 13, 4, 25), EssenceItems.luniumIngot, 2),
	CELESTIUM_PICKAXE(SlayerAPI.addPickMaterial(3, 3000, 13, 4, 25), EssenceItems.celestiumIngot, 3),
	SHADIUM_PICKAXE(SlayerAPI.addPickMaterial(3, 1000, 13, 4, 25), EssenceItems.shadiumIngot, 2),
	SAPPHIRE_PICKAXE(SlayerAPI.addPickMaterial(3, 1000, 13, 4, 25), EssenceItems.sapphire, 2),

	HELLSTONE_AXE(SlayerAPI.addAxeMaterial(3, 1300, 13, 4, 25), EssenceItems.hellstoneIngot),
	FLAIRIUM_AXE(SlayerAPI.addAxeMaterial(3, 3000, 13, 4, 25), EssenceItems.flairiumIngot),
	LUNIUM_AXE(SlayerAPI.addAxeMaterial(3, 1000, 13, 4, 25), EssenceItems.luniumIngot),
	CELESTIUM_AXE(SlayerAPI.addAxeMaterial(3, 3000, 13, 4, 25), EssenceItems.celestiumIngot),
	SHADIUM_AXE(SlayerAPI.addAxeMaterial(3, 1000, 13, 4, 25), EssenceItems.shadiumIngot),
	SAPPHIRE_AXE(SlayerAPI.addAxeMaterial(3, 1000, 13, 4, 25), EssenceItems.sapphire),

	HELLSTONE_SHOVEL(SlayerAPI.addSpadeMaterial(3, 1300, 13, 4, 25), EssenceItems.hellstoneIngot),
	FLAIRIUM_SHOVEL(SlayerAPI.addSpadeMaterial(3, 3000, 13, 4, 25), EssenceItems.flairiumIngot),
	LUNIUM_SHOVEL(SlayerAPI.addSpadeMaterial(3, 1000, 13, 4, 25), EssenceItems.luniumIngot),
	CELESTIUM_SHOVEL(SlayerAPI.addSpadeMaterial(3, 3000, 13, 4, 25), EssenceItems.celestiumIngot),
	SHADIUM_SHOVEL(SlayerAPI.addSpadeMaterial(3, 1000, 13, 4, 25), EssenceItems.shadiumIngot),
	SAPPHIRE_SHOVEL(SlayerAPI.addSpadeMaterial(3, 1000, 13, 4, 25), EssenceItems.sapphire),

	HELLSTONE_HOE(SlayerAPI.addHoeMaterial(3, 1300, 13, 4, 25), EssenceItems.hellstoneIngot),
	FLAIRIUM_HOE(SlayerAPI.addHoeMaterial(3, 3000, 13, 4, 25), EssenceItems.flairiumIngot),
	LUNIUM_HOE(SlayerAPI.addHoeMaterial(3, 1000, 13, 4, 25), EssenceItems.luniumIngot),
	CELESTIUM_HOE(SlayerAPI.addHoeMaterial(3, 3000, 13, 4, 25), EssenceItems.celestiumIngot),
	SHADIUM_HOE(SlayerAPI.addHoeMaterial(3, 1000, 13, 4, 25), EssenceItems.shadiumIngot),
	SAPPHIRE_HOE(SlayerAPI.addHoeMaterial(3, 1000, 13, 4, 25), EssenceItems.sapphire),

	HELLSTONE_MULTI_TOOL(SlayerAPI.addShickMaterial(3, 13, 4, 25), EssenceItems.hellstoneIngot, 3),
	FLAIRIUM_MULTI_TOOL(SlayerAPI.addShickMaterial(3, 13, 4, 25), EssenceItems.flairiumIngot, 3),
	LUNIUM_MULTI_TOOL(SlayerAPI.addShickMaterial(3, 13, 4, 25), EssenceItems.luniumIngot, 2),
	CELESTIUM_MULTI_TOOL(SlayerAPI.addShickMaterial(3, 13, 4, 25), EssenceItems.celestiumIngot, 3),
	SHADIUM_MULTI_TOOL(SlayerAPI.addShickMaterial(3, 13, 4, 25), EssenceItems.shadiumIngot, 2),
	SAPPHIRE_MULTI_TOOL(SlayerAPI.addShickMaterial(3, 13, 4, 25), EssenceItems.sapphire, 2),

	BACK_BITER(SlayerAPI.addAxeMaterial(3, 1300, 13, 4, 25)),
	DAWN_BREAKER(SlayerAPI.addAxeMaterial(3, 1300, 13, 4, 25)),
	TEMPEST_BATTLEAXE(SlayerAPI.addAxeMaterial(3, 1300, 13, 4, 25));

	private ToolMaterial toolMaterial;
	private Item repairItem;
	private int harvestLevel = 0;

	private EssenceToolMaterial(ToolMaterial toolMaterial, Item repair) {
		this.toolMaterial = toolMaterial;
		this.repairItem = repair;
		harvestLevel = 0;
	}
	
	private EssenceToolMaterial(ToolMaterial toolMaterial, Item repair, int level) {
		this.toolMaterial = toolMaterial;
		this.repairItem = repair;
		this.harvestLevel = level;
	}

	private EssenceToolMaterial(ToolMaterial toolMaterial) {
		this(toolMaterial, null);
	}

	public int getHarvestLevel(){
		return harvestLevel;
	}
	
	public Item getRepairItem(){
		return repairItem;
	}

	public ToolMaterial getToolMaterial() {
		return toolMaterial;
	}
}