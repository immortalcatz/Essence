package net.journey.util;

import net.journey.JourneyItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.slayer.api.SlayerAPI;

public enum EssenceToolMaterial {

	HELLSTONE_SWORD(JourneyItems.hellstoneSwordMat, JourneyItems.hellstoneIngot),
	FLAIRIUM_SWORD(JourneyItems.flairiumSwordMat, JourneyItems.flairiumIngot),
	LUNIUM_SWORD(JourneyItems.luniumSwordMat, JourneyItems.luniumIngot),
	CELESTIUM_SWORD(JourneyItems.celestiumSwordMat, JourneyItems.celestiumIngot),
	SHADIUM_SWORD(JourneyItems.shadiumSwordMat, JourneyItems.shadiumIngot),
	SAPPHIRE_SWORD(JourneyItems.sapphiretoolSwordMat, JourneyItems.sapphire),
	ORBADITE_SWORD(JourneyItems.orbaditeSwordMat, JourneyItems.orbaditeIngot),
	GORBITE_SWORD(JourneyItems.gorbiteSwordMat, JourneyItems.gorbiteGem),
	DES_SWORD(JourneyItems.desSwordMat, JourneyItems.desIngot),
	
	HELLSTONE(JourneyItems.hellstone, JourneyItems.hellstoneIngot, 3),
	FLAIRIUM(JourneyItems.flairium, JourneyItems.flairiumIngot, 3),
	LUNIUM(JourneyItems.lunium, JourneyItems.luniumIngot, 3),
	CELESTIUM(JourneyItems.celestium, JourneyItems.celestiumIngot, 3),
	SHADIUM(JourneyItems.shadium, JourneyItems.shadiumIngot, 3),
	SAPPHIRE(JourneyItems.sapphiretool, JourneyItems.sapphire, 2),
	ORBADITE(JourneyItems.orbadite, JourneyItems.orbaditeIngot, 3),
	GORBITE(JourneyItems.gorbite, JourneyItems.gorbiteGem, 3),
	DES(JourneyItems.des, JourneyItems.desIngot, 3),
	KORITE(JourneyItems.korite, JourneyItems.koriteIngot, 3),
	
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
	
	HELLSTONE_MULTI_TOOL(JourneyItems.hellstoneMulti, JourneyItems.hellstoneIngot, 3),
	FLAIRIUM_MULTI_TOOL(JourneyItems.flairiumMulti, JourneyItems.flairiumIngot, 3),
	LUNIUM_MULTI_TOOL(JourneyItems.luniumMulti, JourneyItems.luniumIngot, 3),
	CELESTIUM_MULTI_TOOL(JourneyItems.celestiumMulti, JourneyItems.celestiumIngot, 3),
	SHADIUM_MULTI_TOOL(JourneyItems.shadiumMulti, JourneyItems.shadiumIngot, 3),
	SAPPHIRE_MULTI_TOOL(JourneyItems.sapphireMulti, JourneyItems.sapphire, 2),
	ORBADITE_MULTI_TOOL(JourneyItems.orbaditeMulti, JourneyItems.orbaditeIngot, 3),
	GORBITE_MULTI_TOOL(JourneyItems.gorbiteMulti, JourneyItems.gorbiteGem, 3),
	DES_MULTI_TOOL(JourneyItems.desMulti, JourneyItems.desIngot, 3),
	KORITE_MULTI_TOOL(JourneyItems.koriteMulti, JourneyItems.koriteIngot, 3),
	SMELTING_TOOL(JourneyItems.smeltingMulti, null, 3),
	WOOD_MULTI_TOOL(JourneyItems.woodMulti, SlayerAPI.toItem(Blocks.planks), 1),
	STONE_MULTI_TOOL(JourneyItems.stoneMulti, SlayerAPI.toItem(Blocks.cobblestone), 2),
	IRON_MULTI_TOOL(JourneyItems.ironMulti, Items.iron_ingot, 3),
	GOLD_MULTI_TOOL(JourneyItems.goldMulti, Items.gold_ingot, 3),
	DIAMOND_MULTI_TOOL(JourneyItems.diamondMulti, Items.diamond, 3),

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