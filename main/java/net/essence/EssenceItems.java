package net.essence;

import java.util.ArrayList;

import net.essence.*;
import net.essence.client.GuiHandler.GuiIDs;
import net.essence.client.server.DarkEnergyBar;
import net.essence.client.server.EssenceBar;
import net.essence.entity.projectile.*;
import net.essence.enums.EnumKnowledge;
import net.essence.enums.EnumSounds;
import net.essence.items.*;
import net.essence.items.ItemEgg;
import net.essence.util.*;
import net.minecraft.block.Block;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraftforge.common.util.EnumHelper;
import net.slayer.api.*;
import net.slayer.api.item.*;

public class EssenceItems {

	public static ToolMaterial hellstoneSwordMat = addToolMaterial(2356, 13F, 10F, true);
	public static ToolMaterial flairiumSwordMat = addToolMaterial(3120, 13F, 25F, true);
	public static ToolMaterial celestiumSwordMat = addToolMaterial(3120, 13F, 20F, true);
	public static ToolMaterial shadiumSwordMat = addToolMaterial(2210, 13F, 8F, true);
	public static ToolMaterial luniumSwordMat = addToolMaterial(2210, 13F, 8F, true);
	public static ToolMaterial sapphiretoolSwordMat = addToolMaterial(1561, 13F, 7F, true);
	public static ToolMaterial gorbiteSwordMat = addToolMaterial(3120, 13F, 25F, true);
	public static ToolMaterial orbaditeSwordMat = addToolMaterial(3120, 13F, 25F, true);
	public static ToolMaterial desSwordMat = addToolMaterial(3120, 13F, 25F, true);

	public static ToolMaterial hellstone = addToolMaterial(1600, 10F, 5F, true);
	public static ToolMaterial flairium = addToolMaterial(3000, 15F, 5F, true);
	public static ToolMaterial lunium = addToolMaterial(3000, 9F, 5F, true);
	public static ToolMaterial celestium = addToolMaterial(1600, 13F, 5F, true);
	public static ToolMaterial shadium = addToolMaterial(1600, 10F, 5F, true);
	public static ToolMaterial sapphiretool = addToolMaterial(1561, 8F, 5F, true);
	public static ToolMaterial orbadite = addToolMaterial(3000, 15F, 5F, true);
	public static ToolMaterial gorbite = addToolMaterial(3000, 15F, 5F, true);
	public static ToolMaterial des = addToolMaterial(3000, 15F, 5F, true);

	public static ToolMaterial hellstoneMulti = addToolMaterial(3000, 12F, 5F, false);
	public static ToolMaterial flairiumMulti = addToolMaterial(3000, 15F, 5F, false);
	public static ToolMaterial luniumMulti = addToolMaterial(3000, 9F, 5F, false);
	public static ToolMaterial celestiumMulti = addToolMaterial(3000, 13F, 5F, false);
	public static ToolMaterial shadiumMulti = addToolMaterial(3000, 10F, 5F, false);
	public static ToolMaterial sapphireMulti = addToolMaterial(3000, 8F, 5F, false);
	public static ToolMaterial orbaditeMulti = addToolMaterial(3000, 15F, 5F, false);
	public static ToolMaterial gorbiteMulti = addToolMaterial(3000, 15F, 5F, false);
	public static ToolMaterial desMulti = addToolMaterial(3000, 15F, 5F, false);
	public static ToolMaterial smeltingMulti = addToolMaterial(3000, 15F, 5F, false);

	public static ArrayList<String> itemNames = new ArrayList<String>();

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

	public static final Item hellstoneIngot = new ItemMod("hellstoneIngot");
	public static final Item shadiumIngot = new ItemMod("shadiumIngot");
	public static final Item celestiumIngot = new ItemMod("celestiumIngot");
	public static final Item mekyumIngot = new ItemMod("mekyumIngot");
	public static final Item koriteIngot = new ItemMod("koriteIngot");
	public static final Item storonIngot = new ItemMod("storonIngot");
	public static final Item luniumIngot = new ItemMod("luniumIngot");
	public static final Item flairiumIngot = new ItemMod("flairiumIngot");
	public static final Item ash = new ItemMod("ash");
	public static final Item sapphire = new ItemMod("sapphire");
	public static final Item enderilliumShard = new ItemMod("enderilliumShard");
	public static final Item orbaditeIngot = new ItemMod("orbaditeIngot");
	public static final Item gorbiteGem = new ItemMod("gorbiteGem");
	public static final Item desIngot = new ItemMod("desIngot");

	public static final Item boilPowder = new ItemMod("boilPowder");
	public static final Item blazingFireball = new ItemMod("blazingFireball");
	public static final Item hellTurtleShell = new ItemMod("hellTurtleShell");
	public static final Item sizzlingEye = new ItemMod("sizzlingEye");
	public static final Item snakeFlesh = new ItemMod("snakeFlesh");
	public static final Item boilingSkull = new ItemMod("boilingSkull");
	public static final Item blankKnowledge = new ItemMod("blankKnowledge");
	public static final Item overgrownNatureBall = new ItemMod("overgrownNatureBall");
	public static final Item overseeingTablet = new ItemMod("overseeingTablet");
	public static final Item overseeingEye = new ItemMod("overseeingEye");
	public static final Item darkCrystal = new ItemMod("darkCrystal");

	public static final Item darkOrb = new ItemMod("darkOrb");
	public static final Item depthsFlake = new ItemMod("depthsFlake");
	public static final Item beastlyStomach = new ItemMod("beastlyStomach");
	public static final Item rocFeather = new ItemMod("rocFeather");
	public static final Item coldClump = new ItemMod("coldClump");
	public static final Item crystalEye = new ItemMod("crystalEye");
	public static final Item crystalFlake = new ItemMod("crystalFlake");
	public static final Item freezingTablet = new ItemMod("freezingTablet");
	public static final Item frostFlake = new ItemMod("frostFlake");
	public static final Item frostGem = new ItemMod("frostGem");
	public static final Item frozenIceball = new ItemMod("frozenIceball");
	public static final Item snowsheet = new ItemMod("snowsheet");
	public static final Item gateKeys = new ItemMod("gateKeys");
	public static final Item goldClump = new ItemMod("goldClump");
	public static final Item silverClump = new ItemMod("silverClump");
	public static final Item golderDust = new ItemMod("golderDust");
	public static final Item shimmerdust = new ItemMod("shimmerdust");
	public static final Item royalDisk = new ItemMod("royalDisk");
	public static final Item metalDisk = new ItemMod("metalDisk");
	
	public static final Item hellstoneDust = new ItemMod("hellstoneDust");
	public static final Item shadiumDust = new ItemMod("shadiumDust");
	public static final Item celestiumDust = new ItemMod("celestiumDust");
	public static final Item luniumDust = new ItemMod("luniumDust");
	public static final Item flairiumDust = new ItemMod("flairiumDust");
	public static final Item ashDust = new ItemMod("ashDust");
	public static final Item sapphireDust = new ItemMod("sapphireDust");
	public static final Item enderilliumDust = new ItemMod("enderilliumDust");
	public static final Item gorbiteDust = new ItemMod("gorbiteDust");
	public static final Item orbaditeDust = new ItemMod("orbaditeDust");
	public static final Item diamondDust = new ItemMod("diamondDust");
	public static final Item goldDust = new ItemMod("goldDust");
	public static final Item ironDust = new ItemMod("ironDust");

	public static final Item hellstoneClump = new ItemMod("hellstoneClump");
	public static final Item shadiumClump = new ItemMod("shadiumClump");
	public static final Item luniumClump = new ItemMod("luniumClump");
	public static final Item spawnerClump = new ItemMod("spawnerClump");
	public static final Item spawnerBar = new ItemMod("spawnerBar");

	public static final Item flameCoin = new ItemFlameCoin("flameCoin");
	//public static final Item essenceDetractor = new ItemAttractor("essenceDetractor", false, true, 100);

	//public static final Item rockChunk = new ItemMod("rockChunk");
	//public static final Item rockShard = new ItemMod("rockShard");
	//public static final Item plasmaBall = new ItemMod("plasmaBall");
	
	/**
	Firebombs are throwing items that explode
	**/
	public static final Item fireBomb = new ItemMod("fireBomb");
	
	//public static final Item chaosCannon = new ItemChaosCannon("chaosCannon");
	//public static final Item rockLauncher = new ItemGun("rockLauncher", rockChunk, 9, 650, EnumSounds.CANNON, EntityRockProjectile.class);
	//public static final Item netherPlasma = new ItemGun("netherPlasma", plasmaBall, 9, 650, EnumSounds.PLASMA, EntityNetherPlasma.class);
	//public static final Item oceanPlasma = new ItemGun("oceanPlasma", plasmaBall, 9, 650, EnumSounds.PLASMA, EntityOceanPlasma.class);
	//public static final Item forestPlasma = new ItemGun("forestPlasma", plasmaBall, 9, 650, EnumSounds.PLASMA, EntityForestPlasma.class);
	//TODO
	//public static final Item fireGun = new ItemGun("fireGun", fireBomb, 10, 650, EnumSounds.CANNON, EntityForestPlasma.class);
	//public static final Item flameThrower = new ItemGun("flameThrower", fireBomb, 10, 650, EnumSounds.CANNON, EntityForestPlasma.class);
	//public static final Item natureDuster = new ItemGun("natureDuster", fireBomb, 10, 650, EnumSounds.CANNON, EntityForestPlasma.class);
	//public static final Item eyeBlaster = new ItemGun("eyeBlaster", fireBomb, 10, 650, EnumSounds.CANNON, EntityForestPlasma.class);
	//public static final Item candyBlaster = new ItemGun("candyBlaster", fireBomb, 10, 650, EnumSounds.CANNON, EntityForestPlasma.class);

	public static final Item hellstoneMultiTool = new ItemMultiTool("hellstoneMultiTool", EssenceToolMaterial.HELLSTONE_MULTI_TOOL);
	public static final Item shadiumMultiTool = new ItemMultiTool("shadiumMultiTool", EssenceToolMaterial.SHADIUM_MULTI_TOOL);
	public static final Item celestiumMultiTool = new ItemMultiTool("celestiumMultiTool", EssenceToolMaterial.CELESTIUM_MULTI_TOOL);
	public static final Item luniumMultiTool = new ItemMultiTool("luniumMultiTool", EssenceToolMaterial.LUNIUM_MULTI_TOOL);
	public static final Item flairiumMultiTool = new ItemMultiTool("flairiumMultiTool", EssenceToolMaterial.FLAIRIUM_MULTI_TOOL);
	public static final Item sapphireMultiTool = new ItemMultiTool("sapphireMultiTool", EssenceToolMaterial.SAPPHIRE_MULTI_TOOL);
	public static final Item gorbiteMultiTool = new ItemMultiTool("gorbiteMultiTool", EssenceToolMaterial.GORBITE_MULTI_TOOL);
	public static final Item orbaditeMultiTool = new ItemMultiTool("orbaditeMultiTool", EssenceToolMaterial.ORBADITE_MULTI_TOOL);
	public static final Item desMultiTool = new ItemMultiTool("desMultiTool", EssenceToolMaterial.DES_MULTI_TOOL);

	public static final Item hellstonePickaxe = new ItemModPickaxe("hellstonePickaxe", EssenceToolMaterial.HELLSTONE);
	public static final Item shadiumPickaxe = new ItemModPickaxe("shadiumPickaxe", EssenceToolMaterial.SHADIUM);
	public static final Item celestiumPickaxe = new ItemModPickaxe("celestiumPickaxe", EssenceToolMaterial.CELESTIUM);
	public static final Item luniumPickaxe = new ItemModPickaxe("luniumPickaxe", EssenceToolMaterial.LUNIUM);
	public static final Item flairiumPickaxe = new ItemModPickaxe("flairiumPickaxe", EssenceToolMaterial.FLAIRIUM);
	public static final Item sapphirePickaxe = new ItemModPickaxe("sapphirePickaxe", EssenceToolMaterial.SAPPHIRE);
	public static final Item gorbitePickaxe = new ItemModPickaxe("gorbitePickaxe", EssenceToolMaterial.GORBITE);
	public static final Item orbaditePickaxe = new ItemModPickaxe("orbaditePickaxe", EssenceToolMaterial.ORBADITE);
	public static final Item desPickaxe = new ItemModPickaxe("desPickaxe", EssenceToolMaterial.DES);

	public static final Item hellstoneShovel = new ItemModShovel("hellstoneShovel", EssenceToolMaterial.HELLSTONE);
	public static final Item shadiumShovel = new ItemModShovel("shadiumShovel", EssenceToolMaterial.SHADIUM);
	public static final Item celestiumShovel = new ItemModShovel("celestiumShovel", EssenceToolMaterial.CELESTIUM);
	public static final Item luniumShovel = new ItemModShovel("luniumShovel", EssenceToolMaterial.LUNIUM);
	public static final Item flairiumShovel = new ItemModShovel("flairiumShovel", EssenceToolMaterial.FLAIRIUM);
	public static final Item sapphireShovel = new ItemModShovel("sapphireShovel", EssenceToolMaterial.SAPPHIRE);
	public static final Item gorbiteShovel = new ItemModShovel("gorbiteShovel", EssenceToolMaterial.GORBITE);
	public static final Item orbaditeShovel = new ItemModShovel("orbaditeShovel", EssenceToolMaterial.ORBADITE);
	public static final Item desShovel = new ItemModShovel("desShovel", EssenceToolMaterial.DES);

	public static final Item hellstoneAxe = new ItemModAxe("hellstoneAxe", EssenceToolMaterial.HELLSTONE);
	public static final Item shadiumAxe = new ItemModAxe("shadiumAxe", EssenceToolMaterial.SHADIUM);
	public static final Item celestiumAxe = new ItemModAxe("celestiumAxe", EssenceToolMaterial.CELESTIUM);
	public static final Item luniumAxe = new ItemModAxe("luniumAxe", EssenceToolMaterial.LUNIUM);
	public static final Item flairiumAxe = new ItemModAxe("flairiumAxe", EssenceToolMaterial.FLAIRIUM);
	public static final Item sapphireAxe = new ItemModAxe("sapphireAxe", EssenceToolMaterial.SAPPHIRE);
	public static final Item gorbiteAxe = new ItemModAxe("gorbiteAxe", EssenceToolMaterial.GORBITE);
	public static final Item orbaditeAxe = new ItemModAxe("orbaditeAxe", EssenceToolMaterial.ORBADITE);
	public static final Item desAxe = new ItemModAxe("desAxe", EssenceToolMaterial.DES);

	public static final Item hellstoneHoe = new ItemModHoe("hellstoneHoe", EssenceToolMaterial.HELLSTONE);
	public static final Item shadiumHoe = new ItemModHoe("shadiumHoe", EssenceToolMaterial.SHADIUM);
	public static final Item celestiumHoe = new ItemModHoe("celestiumHoe", EssenceToolMaterial.CELESTIUM);
	public static final Item luniumHoe = new ItemModHoe("luniumHoe", EssenceToolMaterial.LUNIUM);
	public static final Item flairiumHoe = new ItemModHoe("flairiumHoe", EssenceToolMaterial.FLAIRIUM);
	public static final Item sapphireHoe = new ItemModHoe("sapphireHoe", EssenceToolMaterial.SAPPHIRE);
	public static final Item gorbiteHoe = new ItemModHoe("gorbiteHoe", EssenceToolMaterial.GORBITE);
	public static final Item orbaditeHoe = new ItemModHoe("orbaditeHoe", EssenceToolMaterial.ORBADITE);
	public static final Item desHoe = new ItemModHoe("desHoe", EssenceToolMaterial.DES);
	
	public static final Item multiToolOfEternalSmelting = new ItemMultiTool("multiToolOfEternalSmelting", EssenceToolMaterial.SMELTING_TOOL);

	public static final Item hellstoneSword = new ItemFireSword("hellstoneSword", EssenceToolMaterial.HELLSTONE_SWORD);
	public static final Item shadiumSword = new ItemFreezeSword("shadiumSword", EssenceToolMaterial.SHADIUM_SWORD);
	public static final Item celestiumSword = new ItemModSword("celestiumSword", EssenceToolMaterial.CELESTIUM_SWORD);
	public static final Item luniumSword = new ItemModSword("luniumSword", EssenceToolMaterial.LUNIUM_SWORD);
	public static final Item flairiumSword = new ItemFireSword("flairiumSword", EssenceToolMaterial.FLAIRIUM_SWORD);
	public static final Item desSword = new ItemModSword("desSword", EssenceToolMaterial.DES_SWORD);
	public static final Item sapphireSword = new ItemModSword("sapphireSword", EssenceToolMaterial.SAPPHIRE_SWORD);
	public static final Item gorbiteSword = new ItemModSword("gorbiteSword", EssenceToolMaterial.GORBITE_SWORD);
	public static final Item orbaditeSword = new ItemModSword("orbaditeSword", EssenceToolMaterial.ORBADITE_SWORD);
	public static final Item poisonSword = new ItemPoisionSword("poisonSword", EssenceToolMaterial.POISON_SWORD);
	public static final Item cloudSlicer = new ItemModSword("cloudSlicer", EssenceToolMaterial.CLOUD_SLICER);
	public static final Item dragonsTooth = new ItemModSword("dragonsTooth", EssenceToolMaterial.DRAGONS_TOOTH);
	public static final Item netherBeastSword = new ItemModSword("netherBeastSword", EssenceToolMaterial.NETHER_BEAST_SWORD);
	public static final Item witheringBeastSword = new ItemWitherSword("witheringBeastSword", EssenceToolMaterial.WITHERING_BEAST_SWORD);

	public static final Item calciaSword = new ItemModSword("calciaSword", EssenceToolMaterial.CALCIA_SWORD);
	public static final Item championsSword = new ItemModSword("championsSword", EssenceToolMaterial.CHAMPIONS_SWORD);
	public static final Item theWraith = new ItemModSword("theWraith", EssenceToolMaterial.THE_WRAITH);
	public static final Item bubbleSword = new ItemModSword("bubbleSword", EssenceToolMaterial.BUBBLE_SWORD);
	public static final Item boilingBlade = new ItemModSword("boilingBlade", EssenceToolMaterial.BOILING_BLADE);
	public static final Item loggersSword = new ItemModSword("loggersSword", EssenceToolMaterial.LOGGERS_SWORD);
	public static final Item naturesBlade = new ItemModSword("naturesBlade", EssenceToolMaterial.NATURES_BLADE);
	public static final Item depthsDarksword = new ItemModSword("depthsDarksword", EssenceToolMaterial.DEPTHS_DARKSWORD);
	public static final Item depthsSlayer = new ItemModSword("depthsSlayer", EssenceToolMaterial.DEPTHS_SLAYER);
	public static final Item snowShoveler = new ItemModSword("snowShoveler", EssenceToolMaterial.SNOW_SHOVELER);
	public static final Item frostySword = new ItemModSword("frostySword", EssenceToolMaterial.FROSTY_SWORD);
	public static final Item frostbittenSword = new ItemModSword("frostbittenSword", EssenceToolMaterial.FROSTBITTEN_SWORD);
	public static final Item treeHugger = new ItemModSword("treeHugger", EssenceToolMaterial.TREE_HUGGER);
	public static final Item healersBlade = new ItemModSword("healersBlade", EssenceToolMaterial.HEALERS_BLADE);
	public static final Item coreMender = new ItemModSword("coreMender", EssenceToolMaterial.CORE_MENDER);
	public static final Item royalBlade = new ItemModSword("royalBlade", EssenceToolMaterial.ROYAL_BLADE);
	public static final Item royalStabber = new ItemModSword("royalStabber", EssenceToolMaterial.ROYAL_STABBER);
	public static final Item rocSword = new ItemModSword("rocSword", EssenceToolMaterial.ROC_SWORD);
	public static final Item swordOfTheThunderbird = new ItemModSword("swordOfTheThunderbird", EssenceToolMaterial.SWORD_THUNDERBIRD);
	public static final Item bloodwieldSword = new ItemModSword("bloodWieldSword", EssenceToolMaterial.BLOODWIELD_SWORD);
	public static final Item charredBlade = new ItemModSword("charredBlade", EssenceToolMaterial.CHARRED_BLADE);
	public static final Item sizzlerSword = new ItemModSword("sizzlerSword", EssenceToolMaterial.SIZZLER_SWORD);

	public static final Item eucaPortalGem = new ItemMod("eucaPortalGem");
	public static final Item depthsPortalGem = new ItemMod("depthsPortalGem");
	public static final Item corbaPortalGem = new ItemMod("corbaPortalGem");
	public static final Item wastelandPortalGem = new ItemMod("wastelandPortalGem");

	public static final Item calciaOrb = new ItemNetherBossSpawner("calciaOrb");
	public static final Item netherBeastOrb = new ItemNetherBossSpawner("netherBeastOrb");
	public static final Item witheringBeastOrb = new ItemNetherBossSpawner("witheringBeastOrb");
	public static final Item eudorOrb = new ItemEssenceBossSpawner("eudorOrb");
	public static final Item blazierOrb = new ItemSpecificDimensionSpawner(Config.boil, "blazierOrb", "Boiling Point");
	public static final Item rocSpawnEgg = new ItemSpecificDimensionSpawner(0, "rocPetSpawnEgg", "Overworld");
	public static final Item soulWatcherOrb = new ItemSpecificDimensionSpawner(Config.boil, "soulWatcherOrb", "Boiling Point");
	public static final Item sentryKingOrb = new ItemSpecificDimensionSpawner(Config.corba, "sentryKingOrb", "Corba");
	public static final Item thunderbirdOrb = new ItemSpecificDimensionSpawner(Config.depths, "thunderbirdOrb", "Depths");
	
	//TODO
	public static final Item scaleOrb = new ItemSpecificDimensionSpawner(Config.depths, "scaleOrb", "Depths");

	public static final Item weakDarkEnergyPotion = new ItemEssencePotion("weakDarkEnergyPotion", false, false);
	public static final Item strongDarkEnergyPotion = new ItemEssencePotion("strongDarkEnergyPotion", true, false);
	public static final Item weakEssencePotion = new ItemEssencePotion("weakEssencePotion", false, true);
	public static final Item strongEssencePotion = new ItemEssencePotion("strongEssencePotion", true, true);

	public static final Item hellstoneHelmet = new ItemModArmor(EnumArmor.HELLSTONE, HEAD);
	public static final Item hellstoneChest = new ItemModArmor(EnumArmor.HELLSTONE, BODY);
	public static final Item hellstoneLegs = new ItemModArmor(EnumArmor.HELLSTONE, LEGS);
	public static final Item hellstoneBoots = new ItemModArmor(EnumArmor.HELLSTONE, BOOTS);

	public static final Item flairiumHelmet = new ItemModArmor(EnumArmor.FLAIRIUM, HEAD);
	public static final Item flairiumChest = new ItemModArmor(EnumArmor.FLAIRIUM, BODY);
	public static final Item flairiumLegs = new ItemModArmor(EnumArmor.FLAIRIUM, LEGS);
	public static final Item flairiumBoots = new ItemModArmor(EnumArmor.FLAIRIUM, BOOTS);

	public static final Item celestiumHelmet = new ItemModArmor(EnumArmor.CELESTIUM, HEAD);
	public static final Item celestiumChest = new ItemModArmor(EnumArmor.CELESTIUM, BODY);
	public static final Item celestiumLegs = new ItemModArmor(EnumArmor.CELESTIUM, LEGS);
	public static final Item celestiumBoots = new ItemModArmor(EnumArmor.CELESTIUM, BOOTS);

	public static final Item luniumHelmet = new ItemModArmor(EnumArmor.LUNIUM, HEAD);
	public static final Item luniumChest = new ItemModArmor(EnumArmor.LUNIUM, BODY);
	public static final Item luniumLegs = new ItemModArmor(EnumArmor.LUNIUM, LEGS);
	public static final Item luniumBoots = new ItemModArmor(EnumArmor.LUNIUM, BOOTS);

	public static final Item shadiumHelmet = new ItemModArmor(EnumArmor.SHADIUM, HEAD);
	public static final Item shadiumChest = new ItemModArmor(EnumArmor.SHADIUM, BODY);
	public static final Item shadiumLegs = new ItemModArmor(EnumArmor.SHADIUM, LEGS);
	public static final Item shadiumBoots = new ItemModArmor(EnumArmor.SHADIUM, BOOTS);

	public static final Item condensedDiamondHelmet = new ItemModArmor(EnumArmor.CONDENSED_DIAMOND, HEAD);
	public static final Item condensedDiamondChest = new ItemModArmor(EnumArmor.CONDENSED_DIAMOND, BODY);
	public static final Item condensedDiamondLegs = new ItemModArmor(EnumArmor.CONDENSED_DIAMOND, LEGS);
	public static final Item condensedDiamondBoots = new ItemModArmor(EnumArmor.CONDENSED_DIAMOND, BOOTS);

	public static final Item sapphireHelmet = new ItemModArmor(EnumArmor.SAPPHIRE, HEAD);
	public static final Item sapphireChest = new ItemModArmor(EnumArmor.SAPPHIRE, BODY);
	public static final Item sapphireLegs = new ItemModArmor(EnumArmor.SAPPHIRE, LEGS);
	public static final Item sapphireBoots = new ItemModArmor(EnumArmor.SAPPHIRE, BOOTS);

	public static final Item gorbiteHelmet = new ItemModArmor(EnumArmor.GORBITE, HEAD);
	public static final Item gorbiteChest = new ItemModArmor(EnumArmor.GORBITE, BODY);
	public static final Item gorbiteLegs = new ItemModArmor(EnumArmor.GORBITE, LEGS);
	public static final Item gorbiteBoots = new ItemModArmor(EnumArmor.GORBITE, BOOTS);

	public static final Item orbaditeHelmet = new ItemModArmor(EnumArmor.ORBADITE, HEAD);
	public static final Item orbaditeChest = new ItemModArmor(EnumArmor.ORBADITE, BODY);
	public static final Item orbaditeLegs = new ItemModArmor(EnumArmor.ORBADITE, LEGS);
	public static final Item orbaditeBoots = new ItemModArmor(EnumArmor.ORBADITE, BOOTS);

	public static final Item flameHelmet = new ItemModArmor(EnumArmor.FLAME, HEAD);
	public static final Item flameChest = new ItemModArmor(EnumArmor.FLAME, BODY);
	public static final Item flameLegs = new ItemModArmor(EnumArmor.FLAME, LEGS);
	public static final Item flameBoots = new ItemModArmor(EnumArmor.FLAME, BOOTS);

	public static final Item twilightHelmet = new ItemModArmor(EnumArmor.TWILIGHT, HEAD);
	public static final Item twilightChest = new ItemModArmor(EnumArmor.TWILIGHT, BODY);
	public static final Item twilightLegs = new ItemModArmor(EnumArmor.TWILIGHT, LEGS);
	public static final Item twilightBoots = new ItemModArmor(EnumArmor.TWILIGHT, BOOTS);
	
	public static final Item snakeskinHelmet = new ItemModArmor(EnumArmor.SNAKESKIN, HEAD);
	public static final Item snakeskinChest = new ItemModArmor(EnumArmor.SNAKESKIN, BODY);
	public static final Item snakeskinLegs = new ItemModArmor(EnumArmor.SNAKESKIN, LEGS);
	public static final Item snakeskinBoots = new ItemModArmor(EnumArmor.SNAKESKIN, BOOTS);
	
	public static final Item leapersHelmet = new ItemModArmor(EnumArmor.LEAPERS, HEAD);
	public static final Item leapersChest = new ItemModArmor(EnumArmor.LEAPERS, BODY);
	public static final Item leapersLegs = new ItemModArmor(EnumArmor.LEAPERS, LEGS);
	public static final Item leapersBoots = new ItemModArmor(EnumArmor.LEAPERS, BOOTS);
	
	public static final Item treehuggersHelmet = new ItemModArmor(EnumArmor.TREEHUGGERS, HEAD);
	public static final Item treehuggersChest = new ItemModArmor(EnumArmor.TREEHUGGERS, BODY);
	public static final Item treehuggersLegs = new ItemModArmor(EnumArmor.TREEHUGGERS, LEGS);
	public static final Item treehuggersBoots = new ItemModArmor(EnumArmor.TREEHUGGERS, BOOTS);
	
	public static final Item charSkullHelmet = new ItemModArmor(EnumArmor.CHAR_SKULL, HEAD);
	public static final Item charSkullChest = new ItemModArmor(EnumArmor.CHAR_SKULL, BODY);
	public static final Item charSkullLegs = new ItemModArmor(EnumArmor.CHAR_SKULL, LEGS);
	public static final Item charSkullBoots = new ItemModArmor(EnumArmor.CHAR_SKULL, BOOTS);
	
	public static final Item backBiter = new ItemBattleAxe("backBiter", EssenceToolMaterial.BACK_BITER);
	public static final Item dawnBreaker = new ItemBattleAxe("dawnBreaker", EssenceToolMaterial.DAWN_BREAKER);
	public static final Item tempestBattleaxe = new ItemBattleAxe("tempestBattleaxe", EssenceToolMaterial.TEMPEST_BATTLEAXE);
	public static final Item bronzedBattleaxe = new ItemBattleAxe("bronzedBattleaxe", EssenceToolMaterial.BRONZED_BATTLEAXE);
	public static final Item celestiteBattleaxe = new ItemBattleAxe("celestiteBattleaxe", EssenceToolMaterial.CELESTITE_BATTLEAXE);
	public static final Item storumBattleaxe = new ItemBattleAxe("storumBattleaxe", EssenceToolMaterial.STORUM_BATTLEAXE);
	public static final Item celekiumBattleaxe = new ItemBattleAxe("celekiumBattleaxe", EssenceToolMaterial.CELEKIUM_BATTLEAXE);
	public static final Item thunderbirdBattleaxe = new ItemBattleAxe("thunderbirdBattleaxe", EssenceToolMaterial.THUNDERBIRD_BATTLEAXE);

	public static final Item staffOfHellstone = new ItemStaff("staffOfHellstone", false, 3, 1000, 7, false, EntityBasicProjectile.class);
	public static final Item doomsBringer = new ItemStaff("doomsBringer", false, 3, 1000, 12, false, EntityDoomsBringer.class);
	public static final Item conjuringStaff = new ItemStaff("conjuringStaff", false, 3, 1000, 18, false, EntityConjuring.class);
	public static final Item staffOfEnlightenment = new ItemStaff("staffOfEnlightenment", true, 3, 1000, 14, false, EntityEnlightenment.class);
	public static final Item staffOfGreenpace = new ItemStaff("staffOfGreenpace", true, 3, 1000, 10, false, EntityGreenpace.class);
	public static final Item wizardsStar = new ItemStaff("wizardsStar", true, 3, 1000, 5, false, EntityWizardsStar.class);
	public static final Item teleportationStaff = new ItemTeleport("teleportationStaff");

	/*public static final Item blueEgg = new ItemMod("blueEgg", EssenceTabs.misc);
	public static final Item redEgg = new ItemMod("redEgg", EssenceTabs.misc);
	public static final Item greenEgg = new ItemMod("greenEgg", EssenceTabs.misc);
	public static final Item orangeEgg = new ItemMod("orangeEgg", EssenceTabs.misc);
	public static final Item purpleEgg = new ItemMod("purpleEgg", EssenceTabs.misc);
	public static final Item yellowEgg = new ItemMod("yellowEgg", EssenceTabs.misc);
	public static final Item pinkEgg = new ItemMod("pinkEgg", EssenceTabs.misc);
	public static final Item cyanEgg = new ItemMod("cyanEgg", EssenceTabs.misc);

	public static final Item incubatedBlueEgg = new ItemEgg("incubatedBlueEgg");
	public static final Item incubatedRedEgg = new ItemEgg("incubatedRedEgg");
	public static final Item incubatedGreenEgg = new ItemEgg("incubatedGreenEgg");
	public static final Item incubatedOrangeEgg = new ItemEgg("incubatedOrangeEgg");
	public static final Item incubatedPurpleEgg = new ItemEgg("incubatedPurpleEgg");
	public static final Item incubatedYellowEgg = new ItemEgg("incubatedYellowEgg");
	public static final Item incubatedPinkEgg = new ItemEgg("incubatedPinkEgg");
	public static final Item incubatedCyanEgg = new ItemEgg("incubatedCyanEgg");*/

	public static final Item goldenSteak = new ItemGoldenFood("normalGoldenSteak", "Golden Steak", 4, 1.2F, false, false).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	public static final Item goldenSteakOP = new ItemGoldenFood("OPGoldenSteak", "Golden Steak", 4, 1.2F, false, true).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	public static final Item goldenPotato = new ItemGoldenFood("normalGoldenPotato", "Golden Potato", 4, 1.2F, false, false).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	public static final Item goldenPotatoOP = new ItemGoldenFood("OPGoldenPotato", "Golden Potato", 4, 1.2F, false, true).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	public static final Item goldenPork = new ItemGoldenFood("normalGoldenPork", "Golden Porkchop", 4, 1.2F, false, false).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();
	public static final Item goldenPorkOP = new ItemGoldenFood("OPGoldenPork", "Golden Porkchop", 4, 1.2F, false, true).setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F).setAlwaysEdible();	
	public static final Item eucaMeat = new ItemModFood("eucaMeat", 6, 0.6F, 10, false);
	public static final Item rocMeat = new ItemModFood("rocMeat", 6, 0.6F, 10, false);
	public static final Item cookedRocMeat = new ItemModFood("cookedRocMeat", 6, 0.6F, 10, false);

	public static final ItemModDoor hotDoorItem = new ItemModDoor(EssenceBlocks.hotDoor, "hotDoor");

	//public static final Item flameArrow = new ItemMod("flameArrow", EssenceTabs.ranged);
	public static final Item essenceArrow = new ItemMod("essenceArrow", EssenceTabs.ranged);

	public static final Item flameBow = new ItemModBow("flameBow", 384, essenceArrow, EntityFlameArrow.class);
	public static final Item poisonBow = new ItemModBow("poisonBow", 384, essenceArrow, 18, EntityPoisonArrow.class);
	public static final Item darknessBow = new ItemModBow("darknessBow", 384, essenceArrow, 10, EntityDarknessArrow.class);
	public static final Item frozenBow = new ItemModBow("frozenBow", 384, essenceArrow, 33, EntityFrozenArrow.class);
	public static final Item staringBow = new ItemModBow("staringBow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item deathPiercerBow = new ItemModBow("deathPiercerBow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item fusionBow = new ItemModBow("fusionBow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item springBow = new ItemModBow("springBow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item starlightBow = new ItemModBow("starlightBow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item wastefulBow = new ItemModBow("wastefulBow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item flamingBow = new ItemModBow("flamingBow", 384, essenceArrow, EntityFlamingArrow.class);
	public static final Item darkEnforcer = new ItemModBow("darkEnforcer", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item depthsBow = new ItemModBow("depthsBow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item frostbittenBow = new ItemModBow("frostbittenBow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item frostyBow = new ItemModBow("frostyBow", 384, essenceArrow, EntityEssenceArrow.class);

	//public static final Item backpack = new ItemBackpack("backpack");

	public static final Item fireWand = new ItemWand("fireWand", false, 5, 600, 8, false, EntityFireBall.class);
	public static final Item iceWand = new ItemWand("iceWand", true, 5, 600, 8, false, EntityIceBall.class);
	public static final Item lightningWand = new ItemWand("lightningWand", false, 10, 600, 8, false, EntityLightningBall.class);

	public static final Item greenGem = new ItemMod("greenGem");
	public static final Item purpleGem = new ItemMod("purpleGem");
	public static final Item blueGem = new ItemMod("blueGem");
	public static final Item yellowGem = new ItemMod("yellowGem");

	public static final Item eucaTablet = new ItemMod("eucaTablet");

	public static final Item wandBase = new ItemMod("wandBase");
	public static final Item staffBase = new ItemMod("staffBase");

	public static final Item whitePresent = new ItemPresent("whitePresent");
	public static final Item orangePresent = new ItemPresent("orangePresent");
	public static final Item magentaPresent = new ItemPresent("magentaPresent");
	public static final Item lightBluePresent = new ItemPresent("lightBluePresent");
	public static final Item yellowPresent = new ItemPresent("yellowPresent");
	public static final Item limePresent = new ItemPresent("limePresent");
	public static final Item pinkPresent = new ItemPresent("pinkPresent");
	public static final Item grayPresent = new ItemPresent("grayPresent");
	public static final Item silverPresent = new ItemPresent("silverPresent");
	public static final Item cyanPresent = new ItemPresent("cyanPresent");
	public static final Item purplePresent = new ItemPresent("purplePresent");
	public static final Item bluePresent = new ItemPresent("bluePresent");
	public static final Item brownPresent = new ItemPresent("brownPresent");
	public static final Item greenPresent = new ItemPresent("greenPresent");
	public static final Item redPresent = new ItemPresent("redPresent");
	public static final Item blackPresent = new ItemPresent("blackPresent");

	//TODO
	public static final Item tomato = new ItemModFood("tomato", 3, 0.6F, false);
	public static final Item corveggies = new ItemModFood("corveggies", 3, 0.6F, false);
	public static final Item crackenCanes = new ItemModFood("crackenCanes", 3, 0.6F, false);
	public static final Item crakeBulb = new ItemModFood("crakeBulb", 3, 0.6F, false);
	public static final Item spineberries = new ItemModFood("spineberries", 3, 0.6F, false);
	public static final Item zatPedal = new ItemModFood("zatPedal", 3, 0.6F, false);
	public static final Item glowa = new ItemModFood("glowa", 3, 0.6F, false);
	public static final Item mintCandyCane = new ItemModFood("mintCandyCane", 3, 0.6F, false);
	public static final Item fruityCandyCane = new ItemModFood("fruityCandyCane", 3, 0.6F, false);
	public static final Item cherryCandyCane = new ItemModFood("cherryCandyCane", 3, 0.6F, false);
	public static final Item peppermint = new ItemModFood("peppermint", 3, 0.6F, false);
	public static final Item jellyBeans = new ItemModFood("jellyBeans", 3, 0.6F, false);
	public static final Item chocolate = new ItemModFood("chocolate", 3, 0.6F, false);
	public static final Item vanillaWafer = new ItemModFood("vanillaWafer", 3, 0.6F, false);

	public static final Item tomatoSeeds = new ItemModSeeds("tomatoSeeds", EssenceBlocks.tomatoCrop);
	public static final Item corveggieSeeds = new ItemModSeeds("corveggieSeeds", EssenceBlocks.corveggieCrop);
	public static final Item crackenCaneSeeds = new ItemModSeeds("crackenCaneSeeds", EssenceBlocks.crackenCaneCrop);
	public static final Item crakeBulbSeeds = new ItemModSeeds("crakeBulbSeeds", EssenceBlocks.crakeBulbCrop);
	public static final Item spineberrySeeds = new ItemModSeeds("spineberrySeeds", EssenceBlocks.spineberryCrop);
	public static final Item glowaSeeds = new ItemModSeeds("glowaSeeds", EssenceBlocks.glowaCrop);
	public static final Item zatSeeds = new ItemModSeeds("zatSeeds", EssenceBlocks.zatPedalsCrop);


	public static final Item underwaterWorldRecord = new ItemModRecord("underwaterWorld");
	public static final Item blueWater = new ItemModRecord("blueWater");
	public static final Item raceStar = new ItemModRecord("raceStar");
	public static final Item compBegins = new ItemModRecord("compBegins");
	public static final Item deepBlue = new ItemModRecord("deepBlue");
	public static final Item raceShore = new ItemModRecord("raceShore");

	public static final Item essenceSign = new ItemEssenceSign("essenceSignItem");

	public static final Item demonicEye = new ItemDemonicEye("demonicEye");

	public static final Item baseEssence = new ItemMod("baseEssence");
	public static final Item cloudPuff = new ItemMod("cloudPuff");
	public static final Item collectorRock = new ItemMod("collectorRock");
	public static final Item natureTablet = new ItemMod("natureTablet");
	public static final Item horn = new ItemMod("horn");
	public static final Item scale = new ItemMod("scale");

	public static final ItemKnowledge overworldKnowledge = new ItemKnowledge("overworldKnowledge", EnumKnowledge.OVERWORLD);
	public static final ItemKnowledge netherKnowledge = new ItemKnowledge("netherKnowledge", EnumKnowledge.NETHER);
	public static final ItemKnowledge endKnowledge = new ItemKnowledge("endKnowledge", EnumKnowledge.END);
	public static final ItemKnowledge boilKnowledge = new ItemKnowledge("boilingKnowledge", EnumKnowledge.BOIL);
	public static final ItemKnowledge frozenKnowledge = new ItemKnowledge("frozenKnowledge", EnumKnowledge.FROZEN);
	public static final ItemKnowledge eucaKnowledge = new ItemKnowledge("eucaKnowledge", EnumKnowledge.EUCA);
	public static final ItemKnowledge depthsKnowledge = new ItemKnowledge("depthsKnowledge", EnumKnowledge.DEPTHS);
	public static final ItemKnowledge corbaKnowledge = new ItemKnowledge("corbaKnowledge", EnumKnowledge.CORBA);
	public static final ItemKnowledge cloudiaKnowledge = new ItemKnowledge("cloudiaKnowledge", EnumKnowledge.CLOUDIA);
	public static final ItemKnowledge wastelandsKnowledge = new ItemKnowledge("wastelandsKnowledge", EnumKnowledge.WASTELANDS);
	//public static final ItemKnowledge lithiumKnowledge = new ItemKnowledge("lithiumKnowledge", EnumKnowledge.LITHIUM);
	//public static final ItemKnowledge libraryKnowledge = new ItemKnowledge("libraryKnowledge", EnumKnowledge.LIBRARY);
	//public static final ItemKnowledge blazeKnowledge = new ItemKnowledge("blazeKnowledge", EnumKnowledge.BLAZE);
	//public static final ItemKnowledge witherKnowledge = new ItemKnowledge("witherKnowledge", EnumKnowledge.WITHER);

	public static final ItemMod blazesEssence = new ItemMod("blazesEssence");
	public static final ItemMod boilingPointEssence = new ItemMod("boilingPointEssence");
	public static final ItemMod cloudiaEssence = new ItemMod("cloudiaEssence");
	public static final ItemMod corbaEssence = new ItemMod("corbaEssence");
	public static final ItemMod depthsEssence = new ItemMod("depthsEssence");
	public static final ItemMod eucaEssence = new ItemMod("eucaEssence");
	public static final ItemMod frozenLandsEssence = new ItemMod("frozenLandsEssence");
	public static final ItemMod wastelandsEssence = new ItemMod("wastelandsEssence");
	//public static final ItemMod lithiumEssence = new ItemMod("lithiumEssence");
	//public static final ItemMod nethicEssence = new ItemMod("nethicEssence");
	//public static final ItemMod subterrianEssence = new ItemMod("subterrianEssence");
	//public static final ItemMod withicEssence = new ItemMod("withicEssence");
	
	//TODO
	public static final Item boilingPiercer = new ItemPiercer("boilingPiercer", 12F, EntityBoilingPiercer.class);
	public static final Item nethicPiercer = new ItemPiercer("nethicPiercer", 11F, EntityNethicPiercer.class);
	public static final Item frozenPiercer = new ItemPiercer("frozenPiercer", 9F, EntityFrozenPiercer.class);
	public static final Item eucaPiercer = new ItemPiercer("eucaPiercer", 12F, EntityEucaPiercer.class);
	public static final Item depthsPiercer = new ItemPiercer("depthsPiercer", 21F, EntityDepthsPiercer.class);
	public static final Item corbaPiercer = new ItemPiercer("corbaPiercer", 29F, EntityCorbaPiercer.class);
	public static final Item frostbittenPiercer = new ItemPiercer("frostbittenPiercer", 10F, EntityFrostbittenPiercer.class);
	public static final Item frostyPiercer = new ItemPiercer("frostyPiercer", 9F, EntityFrostyPiercer.class);
	public static final Item sunsetPiercer = new ItemPiercer("sunsetPiercer", 10F, EntityFrostyPiercer.class);
	public static final Item moltenKnife = new ItemPiercer("moltenKnife", 10F, EntityMoltenKnife.class);
	public static final Item royalKnife = new ItemPiercer("royalKnife", 14F, EntityRoyalKnife.class);
	public static final Item aquaticKnife = new ItemPiercer("aquaticKnife", 6F, EntityRoyalKnife.class);
	
	public static final Item weakPower = new ItemPower("weakPower", 10F);

	public static ToolMaterial addToolMaterial(int uses, float efficiency, float dam, boolean breakable) {
		return EnumHelper.addToolMaterial("tool", 3, breakable ? uses : -1, efficiency, dam, 30);
	}
}