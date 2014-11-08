package net.essence.util;

import net.essence.EssenceItems;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.slayer.api.SlayerAPI;

public enum EssenceToolMaterial {

	HELLSTONE_SWORD(EssenceItems.hellstoneSwordMat, EssenceItems.hellstoneIngot),
	FLAIRIUM_SWORD(EssenceItems.flairiumSwordMat, EssenceItems.flairiumIngot),
	LUNIUM_SWORD(EssenceItems.luniumSwordMat, EssenceItems.luniumIngot),
	CELESTIUM_SWORD(EssenceItems.celestiumSwordMat, EssenceItems.celestiumIngot),
	SHADIUM_SWORD(EssenceItems.shadiumSwordMat, EssenceItems.shadiumIngot),
	SAPPHIRE_SWORD(EssenceItems.sapphiretoolSwordMat, EssenceItems.sapphire),

	NETHER_BEAST_SWORD(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	WITHERING_BEAST_SWORD(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	CALCIA_SWORD(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	CHAMPIONS_SWORD(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	THE_WRAITH(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	
	POISON_SWORD(SlayerAPI.addMeleeMaterial(1500, 8, 25)),
	CLOUD_SLICER(SlayerAPI.addMeleeMaterial(1500, 8, 25)),
	DRAGONS_TOOTH(SlayerAPI.addMeleeMaterial(1500, 8, 25)),

	HELLSTONE_PICKAXE(EssenceItems.hellstone, EssenceItems.hellstoneIngot, 3),
	FLAIRIUM_PICKAXE(EssenceItems.flairium, EssenceItems.flairiumIngot, 3),
	LUNIUM_PICKAXE(EssenceItems.lunium, EssenceItems.luniumIngot, 3),
	CELESTIUM_PICKAXE(EssenceItems.celestium, EssenceItems.celestiumIngot, 3),
	SHADIUM_PICKAXE(EssenceItems.shadium, EssenceItems.shadiumIngot, 3),
	SAPPHIRE_PICKAXE(EssenceItems.sapphiretool, EssenceItems.sapphire, 2),

	HELLSTONE_AXE(EssenceItems.hellstone, EssenceItems.hellstoneIngot),
	FLAIRIUM_AXE(EssenceItems.flairium, EssenceItems.flairiumIngot),
	LUNIUM_AXE(EssenceItems.lunium, EssenceItems.luniumIngot),
	CELESTIUM_AXE(EssenceItems.celestium, EssenceItems.celestiumIngot),
	SHADIUM_AXE(EssenceItems.shadium, EssenceItems.shadiumIngot),
	SAPPHIRE_AXE(EssenceItems.sapphiretool, EssenceItems.sapphire),

	HELLSTONE_SHOVEL(EssenceItems.hellstone, EssenceItems.hellstoneIngot),
	FLAIRIUM_SHOVEL(EssenceItems.flairium, EssenceItems.flairiumIngot),
	LUNIUM_SHOVEL(EssenceItems.lunium, EssenceItems.luniumIngot),
	CELESTIUM_SHOVEL(EssenceItems.celestium, EssenceItems.celestiumIngot),
	SHADIUM_SHOVEL(EssenceItems.shadium, EssenceItems.shadiumIngot),
	SAPPHIRE_SHOVEL(EssenceItems.sapphiretool, EssenceItems.sapphire),

	HELLSTONE_HOE(EssenceItems.hellstone, EssenceItems.hellstoneIngot),
	FLAIRIUM_HOE(EssenceItems.flairium, EssenceItems.flairiumIngot),
	LUNIUM_HOE(EssenceItems.lunium, EssenceItems.luniumIngot),
	CELESTIUM_HOE(EssenceItems.celestium, EssenceItems.celestiumIngot),
	SHADIUM_HOE(EssenceItems.shadium, EssenceItems.shadiumIngot),
	SAPPHIRE_HOE(EssenceItems.sapphiretool, EssenceItems.sapphire),

	HELLSTONE_MULTI_TOOL(EssenceItems.hellstoneMulti, EssenceItems.hellstoneIngot, 3),
	FLAIRIUM_MULTI_TOOL(EssenceItems.flairiumMulti, EssenceItems.flairiumIngot, 3),
	LUNIUM_MULTI_TOOL(EssenceItems.luniumMulti, EssenceItems.luniumIngot, 3),
	CELESTIUM_MULTI_TOOL(EssenceItems.celestiumMulti, EssenceItems.celestiumIngot, 3),
	SHADIUM_MULTI_TOOL(EssenceItems.shadiumMulti, EssenceItems.shadiumIngot, 3),
	SAPPHIRE_MULTI_TOOL(EssenceItems.sapphireMulti, EssenceItems.sapphire, 2),

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