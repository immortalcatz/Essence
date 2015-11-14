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
	ORBADITE_SWORD(EssenceItems.orbaditeSwordMat, EssenceItems.orbaditeIngot),
	GORBITE_SWORD(EssenceItems.gorbiteSwordMat, EssenceItems.gorbiteGem),
	DES_SWORD(EssenceItems.desSwordMat, EssenceItems.desIngot),
	
	HELLSTONE(EssenceItems.hellstone, EssenceItems.hellstoneIngot, 3),
	FLAIRIUM(EssenceItems.flairium, EssenceItems.flairiumIngot, 3),
	LUNIUM(EssenceItems.lunium, EssenceItems.luniumIngot, 3),
	CELESTIUM(EssenceItems.celestium, EssenceItems.celestiumIngot, 3),
	SHADIUM(EssenceItems.shadium, EssenceItems.shadiumIngot, 3),
	SAPPHIRE(EssenceItems.sapphiretool, EssenceItems.sapphire, 2),
	ORBADITE(EssenceItems.orbadite, EssenceItems.orbaditeIngot, 3),
	GORBITE(EssenceItems.gorbite, EssenceItems.gorbiteGem, 3),
	DES(EssenceItems.des, EssenceItems.desIngot, 3),
	KORITE(EssenceItems.korite, EssenceItems.koriteIngot, 3),
	
	NETHER_BEAST_SWORD(SlayerAPI.addMeleeMaterial(3000, 15, 25)),
	WITHERING_BEAST_SWORD(SlayerAPI.addMeleeMaterial(3000, 15, 25)),
	CALCIA_SWORD(SlayerAPI.addMeleeMaterial(3000, 15, 25)),
	CHAMPIONS_SWORD(SlayerAPI.addMeleeMaterial(3000, 15, 25)),
	THE_WRAITH(SlayerAPI.addMeleeMaterial(3000, 15, 25)),
	BUBBLE_SWORD(SlayerAPI.addMeleeMaterial(3000, 15, 25)),

	POISON_SWORD(SlayerAPI.addMeleeMaterial(1500, 8, 25)),
	CLOUD_SLICER(SlayerAPI.addMeleeMaterial(1500, 8, 25)),
	DRAGONS_TOOTH(SlayerAPI.addMeleeMaterial(1500, 8, 25)),
	BOILING_BLADE(SlayerAPI.addMeleeMaterial(3000, 21, 25)),
	MOLTEN_KNIFE(SlayerAPI.addMeleeMaterial(3000, 10, 25)),
	LOGGERS_SWORD(SlayerAPI.addMeleeMaterial(3000, 30, 25)),
	NATURES_BLADE(SlayerAPI.addMeleeMaterial(3000, 34, 25)),
	DEPTHS_DARKSWORD(SlayerAPI.addMeleeMaterial(3000, 28, 25)),
	DEPTHS_SLAYER(SlayerAPI.addMeleeMaterial(3000, 22, 25)),
	SNOW_SHOVELER(SlayerAPI.addMeleeMaterial(3000, 15, 25)),
	FROSTBITTEN_SWORD(SlayerAPI.addMeleeMaterial(3000, 25, 25)),
	FROSTY_SWORD(SlayerAPI.addMeleeMaterial(3000, 15, 25)),
	TREE_HUGGER(SlayerAPI.addMeleeMaterial(3000, 32, 25)),
	HEALERS_BLADE(SlayerAPI.addMeleeMaterial(3000, 15, 25)),
	CORE_MENDER(SlayerAPI.addMeleeMaterial(3000, 26, 25)),
	ROYAL_BLADE(SlayerAPI.addMeleeMaterial(3000, 18, 25)),
	ROYAL_STABBER(SlayerAPI.addMeleeMaterial(3000, 21, 25)),
	ROC_SWORD(SlayerAPI.addMeleeMaterial(3000, 29, 25)),
	SWORD_THUNDERBIRD(SlayerAPI.addMeleeMaterial(3000, 32, 25)),
	BLOODWIELD_SWORD(SlayerAPI.addMeleeMaterial(3000, 14, 25)),
	CHARRED_BLADE(SlayerAPI.addMeleeMaterial(3000, 18, 25)),
	SIZZLER_SWORD(SlayerAPI.addMeleeMaterial(3000, 22, 25)),
	FLUFFY_BLADE(SlayerAPI.addMeleeMaterial(3000, 38, 25)),
	GOLEM_SWORD(SlayerAPI.addMeleeMaterial(3000, 32, 25)),
	THUNDERBLADE(SlayerAPI.addMeleeMaterial(3000, 35, 25)),
	SENTRY_SWORD(SlayerAPI.addMeleeMaterial(3000, 35, 25)),
	CRYSTAL_BLADE(SlayerAPI.addMeleeMaterial(3000, 9, 25)),
	STARLIGHT_BLADE(SlayerAPI.addMeleeMaterial(3000, 33, 25)),
	KORITE_SWORD(SlayerAPI.addMeleeMaterial(3000, 12, 25)),
	PEDAL_SWORD(SlayerAPI.addMeleeMaterial(50, 8, 25)),
	
	DEVELOPER_SWORD(SlayerAPI.addMeleeMaterial(3000, 9000, 25)),
	
	HELLSTONE_MULTI_TOOL(EssenceItems.hellstoneMulti, EssenceItems.hellstoneIngot, 3),
	FLAIRIUM_MULTI_TOOL(EssenceItems.flairiumMulti, EssenceItems.flairiumIngot, 3),
	LUNIUM_MULTI_TOOL(EssenceItems.luniumMulti, EssenceItems.luniumIngot, 3),
	CELESTIUM_MULTI_TOOL(EssenceItems.celestiumMulti, EssenceItems.celestiumIngot, 3),
	SHADIUM_MULTI_TOOL(EssenceItems.shadiumMulti, EssenceItems.shadiumIngot, 3),
	SAPPHIRE_MULTI_TOOL(EssenceItems.sapphireMulti, EssenceItems.sapphire, 2),
	ORBADITE_MULTI_TOOL(EssenceItems.orbaditeMulti, EssenceItems.orbaditeIngot, 3),
	GORBITE_MULTI_TOOL(EssenceItems.gorbiteMulti, EssenceItems.gorbiteGem, 3),
	DES_MULTI_TOOL(EssenceItems.desMulti, EssenceItems.desIngot, 3),
	KORITE_MULTI_TOOL(EssenceItems.koriteMulti, EssenceItems.koriteIngot, 3),
	SMELTING_TOOL(EssenceItems.smeltingMulti, null, 3),

	BACK_BITER(SlayerAPI.addAxeMaterial(3, 1300, 13, 15, 25)),
	DAWN_BREAKER(SlayerAPI.addAxeMaterial(3, 1300, 13, 10, 25)),
	TEMPEST_BATTLEAXE(SlayerAPI.addAxeMaterial(3, 1300, 13, 13, 25)),
	BRONZED_BATTLEAXE(SlayerAPI.addAxeMaterial(3, 1300, 13, 16, 25)),
	STORUM_BATTLEAXE(SlayerAPI.addAxeMaterial(3, 1300, 13, 17, 25)),
	CELESTITE_BATTLEAXE(SlayerAPI.addAxeMaterial(3, 1300, 13, 18, 25)),
	CELEKIUM_BATTLEAXE(SlayerAPI.addAxeMaterial(3, 1300, 13, 19, 25)),
	THUNDERBIRD_BATTLEAXE(SlayerAPI.addAxeMaterial(3, 1300, 13, 27, 25));

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