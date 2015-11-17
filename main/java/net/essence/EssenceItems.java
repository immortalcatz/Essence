package net.essence;

import java.util.ArrayList;
import java.util.List;

import net.essence.entity.projectile.*;
import net.essence.enums.EnumKnowledge;
import net.essence.enums.EnumSounds;
import net.essence.items.*;
import net.essence.util.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;
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
	public static ToolMaterial mekyumSwordMat = addToolMaterial(3120, 13F, 25F, true);
	public static ToolMaterial storonSwordMat = addToolMaterial(3120, 13F, 25F, true);
	public static ToolMaterial koriteSwordMat = addToolMaterial(3120, 13F, 25F, true);
	
	public static ToolMaterial hellstone = addToolMaterial(1600, 10F, 5F, true);
	public static ToolMaterial flairium = addToolMaterial(3000, 15F, 5F, true);
	public static ToolMaterial lunium = addToolMaterial(3000, 9F, 5F, true);
	public static ToolMaterial celestium = addToolMaterial(1600, 13F, 5F, true);
	public static ToolMaterial mekyum = addToolMaterial(1600, 13F, 5F, true);
	public static ToolMaterial storon = addToolMaterial(1600, 13F, 5F, true);
	public static ToolMaterial korite = addToolMaterial(1600, 13F, 5F, true);
	public static ToolMaterial shadium = addToolMaterial(1600, 10F, 5F, true);
	public static ToolMaterial sapphiretool = addToolMaterial(1561, 8F, 5F, true);
	public static ToolMaterial orbadite = addToolMaterial(3000, 15F, 5F, true);
	public static ToolMaterial gorbite = addToolMaterial(3000, 15F, 5F, true);
	public static ToolMaterial des = addToolMaterial(3000, 15F, 5F, true);
	
	public static ToolMaterial hellstoneMulti = addToolMaterial(3000, 12F, 5F, false);
	public static ToolMaterial flairiumMulti = addToolMaterial(3000, 15F, 5F, false);
	public static ToolMaterial luniumMulti = addToolMaterial(3000, 9F, 5F, false);
	public static ToolMaterial celestiumMulti = addToolMaterial(3000, 13F, 5F, false);
	public static ToolMaterial mekyumMulti = addToolMaterial(3000, 13F, 5F, false);
	public static ToolMaterial storonMulti = addToolMaterial(3000, 13F, 5F, false);
	public static ToolMaterial koriteMulti = addToolMaterial(3000, 13F, 5F, false);
	public static ToolMaterial shadiumMulti = addToolMaterial(3000, 10F, 5F, false);
	public static ToolMaterial sapphireMulti = addToolMaterial(3000, 8F, 5F, false);
	public static ToolMaterial orbaditeMulti = addToolMaterial(3000, 15F, 5F, false);
	public static ToolMaterial gorbiteMulti = addToolMaterial(3000, 15F, 5F, false);
	public static ToolMaterial desMulti = addToolMaterial(3000, 15F, 5F, false);
	public static ToolMaterial smeltingMulti = addToolMaterial(3000, 15F, 5F, false);

	public static ArrayList<String> itemNames = new ArrayList<String>();

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

	public static final Item hellstoneIngot = new ItemMod("hellstoneIngot", "Hellstone Ingot");
	public static final Item shadiumIngot = new ItemMod("shadiumIngot", "Shadium Ingot");
	public static final Item celestiumIngot = new ItemMod("celestiumIngot", "Celestium Ingot");
	public static final Item mekyumIngot = new ItemMod("mekyumIngot", "Mekyum Ingot");
	public static final Item koriteIngot = new ItemMod("koriteIngot", "Korite Ingot");
	public static final Item storonIngot = new ItemMod("storonIngot", "Storon Ingot");
	public static final Item luniumIngot = new ItemMod("luniumIngot", "Lunium Ingot");
	public static final Item flairiumIngot = new ItemMod("flairiumIngot", "Flairium Ingot");
	public static final Item ash = new ItemMod("ash", "Ash");
	public static final Item sapphire = new ItemMod("sapphire", "Sapphire Gem");
	public static final Item enderilliumShard = new ItemMod("enderilliumShard", "Enderillium Shard");
	public static final Item orbaditeIngot = new ItemMod("orbaditeIngot", "Orbadite Ingot");
	public static final Item gorbiteGem = new ItemMod("gorbiteGem", "Gorbite Gem");
	public static final Item desIngot = new ItemMod("desIngot", "Des Ingot");

	public static final Item boilPowder = new ItemMod("boilPowder", "Boiling Powder");
	public static final Item blazingFireball = new ItemMod("blazingFireball", "Blazing Fireball");
	public static final Item hellTurtleShell = new ItemMod("hellTurtleShell", "Hell Turtle Shell");
	public static final Item sizzlingEye = new ItemMod("sizzlingEye", "Sizzling Eye");
	public static final Item snakeFlesh = new ItemMod("snakeFlesh", "Snake Flesh");
	public static final Item boilingSkull = new ItemMod("boilingSkull", "Boiling Skull");
	public static final Item overgrownNatureBall = new ItemMod("overgrownNatureBall", "Overgrown Natureball");
	public static final Item overseeingTablet = new ItemMod("overseeingTablet", "Overseeing Tablet");
	public static final Item overseeingEye = new ItemMod("overseeingEye", "Overseeing Eye");
	public static final Item darkCrystal = new ItemMod("darkCrystal", "Dark Crystal");
	public static final Item blankKnowledge = new ItemMod("blankKnowledge", "Blank Knowledge");

	public static final Item darkOrb = new ItemMod("darkOrb", "Dark Orb");
	public static final Item depthsFlake = new ItemMod("depthsFlake", "Depths Flake");
	public static final Item beastlyStomach = new ItemMod("beastlyStomach", "Beastly Stomach");
	public static final Item rocFeather = new ItemMod("rocFeather", "Essence Feather");
	public static final Item coldClump = new ItemMod("coldClump", "Cold Clump");
	public static final Item crystalEye = new ItemMod("crystalEye", "Crystal Eye");
	public static final Item crystalFlake = new ItemMod("crystalFlake", "Crystal Flake");
	public static final Item freezingTablet = new ItemMod("freezingTablet", "Freezing Tablet");
	public static final Item frostFlake = new ItemMod("frostFlake", "Frost Flake");
	public static final Item frostGem = new ItemMod("frostGem", "Frost Gem");
	public static final Item frozenIceball = new ItemMod("frozenIceball", "Frozen Iceball");
	public static final Item snowsheet = new ItemMod("snowsheet", "Snowsheet");
	public static final Item gateKeys = new ItemMod("gateKeys", "Gate Keys");
	public static final Item goldClump = new ItemMod("goldClump", "Gold Clump");
	public static final Item silverClump = new ItemMod("silverClump", "Silver Clump");
	public static final Item golderDust = new ItemMod("golderDust", "Golder Dust");
	public static final Item shimmerdust = new ItemMod("shimmerdust", "Shimmer Dust");
	public static final Item royalDisk = new ItemMod("royalDisk", "Royal Disk");
	public static final Item metalDisk = new ItemMod("metalDisk", "Metal Disk");
	public static final Item demonicDust = new ItemMod("demonicDust", "Demonic Dust");
	public static final Item demonicBone = new ItemMod("demonicBone", "Demonic Bone");
	public static final Item withicDust = new ItemMod("withicDust", "Withic Dust");
	public static final Item cloudiaOrb = new ItemMod("cloudiaOrb", "Cloudia Orb");
	public static final Item fluffyFeather = new ItemMod("fluffyFeather", "Fluffy Feather");
	public static final Item golemChunk = new ItemMod("golemChunk", "Golem Chunk");
	public static final Item luniteChunk = new ItemMod("luniteChunk", "Lunite Chunk");
	public static final Item corbaStick = new ItemMod("corbaStick", "Corba Stick");
	public static final Item spyclopseEye = new ItemMod("spyclopseEye", "Spyclopse Eye");
	public static final Item caveCrystal = new ItemMod("caveCrystal", "Cave Crystal");
	public static final Item caveDust = new ItemMod("caveDust", "Cave Dust");
	public static final Item stoneClump = new ItemMod("stoneClump", "Stone Clump");
	public static final Item enchantedLeaf = new ItemMod("enchantedLeaf", "Enchanted Leaf");
	public static final Item baseEssence = new ItemMod("baseEssence", "Base Essence");
	public static final Item cloudPuff = new ItemMod("cloudPuff", "Cloud Puff");
	public static final Item collectorRock = new ItemMod("collectorRock", "Collector Rock");
	public static final Item natureTablet = new ItemMod("natureTablet", "Nature Tablet");
	public static final Item horn = new ItemMod("horn", "Horn");
	public static final Item scale = new ItemMod("scale", "Scale");
	public static final Item crystalBall = new ItemMod("crystalBall", "Crystal Ball");
	public static final Item floroPedal = new ItemMod("floroPedal", "Floro Pedal");
	public static final Item glowshroomPowder = new ItemMod("glowshroomPowder", "Glowshroom Powder");
	public static final Item cloudiaGem = new ItemMod("cloudiaGem", "Cloudia Gem");
	
	public static final Item hellstoneDust = new ItemMod("hellstoneDust", "Hellstone Dust");
	public static final Item shadiumDust = new ItemMod("shadiumDust", "Shadium Dust");
	public static final Item celestiumDust = new ItemMod("celestiumDust", "Celestium Dust");
	public static final Item luniumDust = new ItemMod("luniumDust", "Lunium Dust");
	public static final Item flairiumDust = new ItemMod("flairiumDust", "Flairium Dust");
	public static final Item ashDust = new ItemMod("ashDust", "Ash Dust");
	public static final Item sapphireDust = new ItemMod("sapphireDust", "Sapphire Dust");
	public static final Item enderilliumDust = new ItemMod("enderilliumDust", "Enderillium Dust");
	public static final Item gorbiteDust = new ItemMod("gorbiteDust", "Gorbite Dust");
	public static final Item orbaditeDust = new ItemMod("orbaditeDust", "Orbadite Dust");
	public static final Item diamondDust = new ItemMod("diamondDust", "Diamond Dust");
	public static final Item goldDust = new ItemMod("goldDust", "Gold Dust");
	public static final Item ironDust = new ItemMod("ironDust", "Iron Dust");

	public static final Item hellstoneClump = new ItemMod("hellstoneClump", "Hellstone Clump");
	public static final Item shadiumClump = new ItemMod("shadiumClump", "Shadium Clump");
	public static final Item luniumClump = new ItemMod("luniumClump", "Lunium Clump");
	public static final Item spawnerClump = new ItemMod("spawnerClump", "Spawner Clump");
	public static final Item spawnerBar = new ItemMod("spawnerBar", "Spawner Bar");

	public static final Item flameCoin = new ItemFlameCoin("flameCoin", "Flame Coin");
	//public static final Item essenceDetractor = new ItemAttractor("essenceDetractor", false, true, 100);

	//public static final Item rockChunk = new ItemMod("rockChunk");
	//public static final Item rockShard = new ItemMod("rockShard");
	//public static final Item plasmaBall = new ItemMod("plasmaBall");
	
	/**
	Firebombs are throwing items that explode
	**/
	public static final Item fireBomb = new ItemMod("fireBomb", "Fire Bomb");

	public static final Item hellstoneMultiTool = new ItemMultiTool("hellstoneMultiTool", "Hellstone Multi Tool", EssenceToolMaterial.HELLSTONE_MULTI_TOOL);
	public static final Item shadiumMultiTool = new ItemMultiTool("shadiumMultiTool", "Shadium Multi Tool", EssenceToolMaterial.SHADIUM_MULTI_TOOL);
	public static final Item celestiumMultiTool = new ItemMultiTool("celestiumMultiTool", "Celestium Multi Tool", EssenceToolMaterial.CELESTIUM_MULTI_TOOL);
	public static final Item luniumMultiTool = new ItemMultiTool("luniumMultiTool", "Lunium Multi Tool", EssenceToolMaterial.LUNIUM_MULTI_TOOL);
	public static final Item flairiumMultiTool = new ItemMultiTool("flairiumMultiTool", "Flairium Multi Tool", EssenceToolMaterial.FLAIRIUM_MULTI_TOOL);
	public static final Item sapphireMultiTool = new ItemMultiTool("sapphireMultiTool", "Sapphire Multi Tool", EssenceToolMaterial.SAPPHIRE_MULTI_TOOL);
	public static final Item gorbiteMultiTool = new ItemMultiTool("gorbiteMultiTool", "Gorbite Multi Tool", EssenceToolMaterial.GORBITE_MULTI_TOOL);
	public static final Item orbaditeMultiTool = new ItemMultiTool("orbaditeMultiTool", "Orbadite Multi Tool", EssenceToolMaterial.ORBADITE_MULTI_TOOL);
	public static final Item desMultiTool = new ItemMultiTool("desMultiTool", "Des Multi Tool", EssenceToolMaterial.DES_MULTI_TOOL);
	public static final Item koriteMultiTool = new ItemMultiTool("koriteMultiTool", "Korite Multi Tool", EssenceToolMaterial.KORITE_MULTI_TOOL);
	public static final Item storonMultiTool = new ItemMultiTool("storonMultiTool", "Storon Multi Tool", EssenceToolMaterial.KORITE_MULTI_TOOL);
	public static final Item mekyumMultiTool = new ItemMultiTool("mekyumMultiTool", "Mekyum Multi Tool", EssenceToolMaterial.KORITE_MULTI_TOOL);
	
	public static final Item hellstonePickaxe = new ItemModPickaxe("hellstonePickaxe", "Hellstone Pickaxe", EssenceToolMaterial.HELLSTONE);
	public static final Item shadiumPickaxe = new ItemModPickaxe("shadiumPickaxe", "Shadium Pickaxe", EssenceToolMaterial.SHADIUM);
	public static final Item celestiumPickaxe = new ItemModPickaxe("celestiumPickaxe", "Celestium Pickaxe", EssenceToolMaterial.CELESTIUM);
	public static final Item luniumPickaxe = new ItemModPickaxe("luniumPickaxe", "Lunium Pickaxe", EssenceToolMaterial.LUNIUM);
	public static final Item flairiumPickaxe = new ItemModPickaxe("flairiumPickaxe", "Flairium Pickaxe", EssenceToolMaterial.FLAIRIUM);
	public static final Item sapphirePickaxe = new ItemModPickaxe("sapphirePickaxe", "Sapphire Pickaxe", EssenceToolMaterial.SAPPHIRE);
	public static final Item gorbitePickaxe = new ItemModPickaxe("gorbitePickaxe", "Gorbite Pickaxe", EssenceToolMaterial.GORBITE);
	public static final Item orbaditePickaxe = new ItemModPickaxe("orbaditePickaxe", "Orbadite Pickaxe", EssenceToolMaterial.ORBADITE);
	public static final Item desPickaxe = new ItemModPickaxe("desPickaxe", "Des Pickaxe", EssenceToolMaterial.DES);
	public static final Item koritePickaxe = new ItemModPickaxe("koritePickaxe", "Korite Pickaxe", EssenceToolMaterial.KORITE);
	public static final Item storonPickaxe = new ItemModPickaxe("storonPickaxe", "Storon Pickaxe", EssenceToolMaterial.KORITE);
	public static final Item mekyumPickaxe = new ItemModPickaxe("mekyumPickaxe", "Mekyum Pickaxe", EssenceToolMaterial.KORITE);

	public static final Item hellstoneShovel = new ItemModShovel("hellstoneShovel", "Hellstone Shovel", EssenceToolMaterial.HELLSTONE);
	public static final Item shadiumShovel = new ItemModShovel("shadiumShovel", "Shadium Shovel", EssenceToolMaterial.SHADIUM);
	public static final Item celestiumShovel = new ItemModShovel("celestiumShovel", "Celestium Shovel", EssenceToolMaterial.CELESTIUM);
	public static final Item luniumShovel = new ItemModShovel("luniumShovel", "Lunium Shovel", EssenceToolMaterial.LUNIUM);
	public static final Item flairiumShovel = new ItemModShovel("flairiumShovel", "Flairium Shovel", EssenceToolMaterial.FLAIRIUM);
	public static final Item sapphireShovel = new ItemModShovel("sapphireShovel", "Sapphire Shovel", EssenceToolMaterial.SAPPHIRE);
	public static final Item gorbiteShovel = new ItemModShovel("gorbiteShovel", "Gorbite Shovel", EssenceToolMaterial.GORBITE);
	public static final Item orbaditeShovel = new ItemModShovel("orbaditeShovel", "Orbadite Shovel", EssenceToolMaterial.ORBADITE);
	public static final Item desShovel = new ItemModShovel("desShovel", "Des Shovel", EssenceToolMaterial.DES);
	public static final Item koriteShovel = new ItemModShovel("koriteShovel", "Korite Shovel", EssenceToolMaterial.KORITE);
	public static final Item storonShovel = new ItemModShovel("storonShovel", "Storon Shovel", EssenceToolMaterial.KORITE);
	public static final Item mekyumShovel = new ItemModShovel("mekyumShovel", "Mekyum Shovel", EssenceToolMaterial.KORITE);

	public static final Item hellstoneAxe = new ItemModAxe("hellstoneAxe", "Hellstone Axe", EssenceToolMaterial.HELLSTONE);
	public static final Item shadiumAxe = new ItemModAxe("shadiumAxe", "Shadium Axe", EssenceToolMaterial.SHADIUM);
	public static final Item celestiumAxe = new ItemModAxe("celestiumAxe", "Celestium Axe", EssenceToolMaterial.CELESTIUM);
	public static final Item luniumAxe = new ItemModAxe("luniumAxe", "Lunium Axe", EssenceToolMaterial.LUNIUM);
	public static final Item flairiumAxe = new ItemModAxe("flairiumAxe", "Flairium Axe", EssenceToolMaterial.FLAIRIUM);
	public static final Item sapphireAxe = new ItemModAxe("sapphireAxe", "Sapphire Axe", EssenceToolMaterial.SAPPHIRE);
	public static final Item gorbiteAxe = new ItemModAxe("gorbiteAxe", "Gorbite Axe", EssenceToolMaterial.GORBITE);
	public static final Item orbaditeAxe = new ItemModAxe("orbaditeAxe", "Orbadite Axe", EssenceToolMaterial.ORBADITE);
	public static final Item desAxe = new ItemModAxe("desAxe", "Des Axe", EssenceToolMaterial.DES);
	public static final Item koriteAxe = new ItemModAxe("koriteAxe", "Korite Axe", EssenceToolMaterial.KORITE);
	public static final Item storonAxe = new ItemModAxe("storonAxe", "Storon Axe", EssenceToolMaterial.KORITE);
	public static final Item mekyumAxe = new ItemModAxe("mekyumAxe", "Mekyum Axe", EssenceToolMaterial.KORITE);

	public static final Item hellstoneHoe = new ItemModHoe("hellstoneHoe", "Hellstone Hoe", EssenceToolMaterial.HELLSTONE);
	public static final Item shadiumHoe = new ItemModHoe("shadiumHoe", "Shadium Hoe", EssenceToolMaterial.SHADIUM);
	public static final Item celestiumHoe = new ItemModHoe("celestiumHoe", "Celestium Hoe", EssenceToolMaterial.CELESTIUM);
	public static final Item luniumHoe = new ItemModHoe("luniumHoe", "Lunium Hoe", EssenceToolMaterial.LUNIUM);
	public static final Item flairiumHoe = new ItemModHoe("flairiumHoe", "Flairium Hoe", EssenceToolMaterial.FLAIRIUM);
	public static final Item sapphireHoe = new ItemModHoe("sapphireHoe", "Sapphire Hoe", EssenceToolMaterial.SAPPHIRE);
	public static final Item gorbiteHoe = new ItemModHoe("gorbiteHoe", "Gorbite Hoe", EssenceToolMaterial.GORBITE);
	public static final Item orbaditeHoe = new ItemModHoe("orbaditeHoe", "Orbadite Hoe", EssenceToolMaterial.ORBADITE);
	public static final Item desHoe = new ItemModHoe("desHoe", "Des Hoe", EssenceToolMaterial.DES);
	public static final Item koriteHoe = new ItemModHoe("koriteHoe", "Korite Hoe", EssenceToolMaterial.KORITE);
	public static final Item storonHoe = new ItemModHoe("storonHoe", "Storon Hoe", EssenceToolMaterial.KORITE);
	public static final Item mekyumHoe = new ItemModHoe("mekyumHoe", "Storon Hoe", EssenceToolMaterial.KORITE);
	
	public static final Item multiToolOfEternalSmelting = new ItemMultiTool("multiToolOfEternalSmelting", "Multi Tool of Eternal Smelting", EssenceToolMaterial.SMELTING_TOOL);

	public static final Item hellstoneSword = new ItemFireSword("hellstoneSword", "Hellstone Sword", EssenceToolMaterial.HELLSTONE_SWORD);
	public static final Item shadiumSword = new ItemFreezeSword("shadiumSword", "Shadium Sword", EssenceToolMaterial.SHADIUM_SWORD);
	public static final Item celestiumSword = new ItemModSword("celestiumSword", "Celestium Sword", EssenceToolMaterial.CELESTIUM_SWORD);
	public static final Item luniumSword = new ItemModSword("luniumSword", "Lunium Sword", EssenceToolMaterial.LUNIUM_SWORD);
	public static final Item flairiumSword = new ItemFireSword("flairiumSword", "Flairium Sword", EssenceToolMaterial.FLAIRIUM_SWORD);
	public static final Item desSword = new ItemModSword("desSword", "Des Sword", EssenceToolMaterial.DES_SWORD);
	public static final Item sapphireSword = new ItemModSword("sapphireSword", "Sapphire Sword", EssenceToolMaterial.SAPPHIRE_SWORD);
	public static final Item gorbiteSword = new ItemModSword("gorbiteSword", "Gorbite Sword", EssenceToolMaterial.GORBITE_SWORD);
	public static final Item orbaditeSword = new ItemModSword("orbaditeSword", "Orbadite Sword", EssenceToolMaterial.ORBADITE_SWORD);
	public static final Item poisonSword = new ItemPoisionSword("poisonSword", "Poison Sword", EssenceToolMaterial.POISON_SWORD);
	public static final Item cloudSlicer = new ItemModSword("cloudSlicer", "Cloud Slicer", EssenceToolMaterial.CLOUD_SLICER);
	public static final Item dragonsTooth = new ItemModSword("dragonsTooth", "Dragons Tooth", EssenceToolMaterial.DRAGONS_TOOTH);
	public static final Item netherBeastSword = new ItemModSword("netherBeastSword", "Netherbeast Sword", EssenceToolMaterial.NETHER_BEAST_SWORD);
	public static final Item witheringBeastSword = new ItemWitherSword("witheringBeastSword", "Witheringbeast Sword", EssenceToolMaterial.WITHERING_BEAST_SWORD);
	public static final Item calciaSword = new ItemModSword("calciaSword", "Calcia Sword", EssenceToolMaterial.CALCIA_SWORD);
	public static final Item championsSword = new ItemModSword("championsSword", "Champions Sword", EssenceToolMaterial.CHAMPIONS_SWORD);
	public static final Item theWraith = new ItemModSword("theWraith", "The Wraith", EssenceToolMaterial.THE_WRAITH);
	public static final Item bubbleSword = new ItemModSword("bubbleSword", "Bubble Sword", EssenceToolMaterial.BUBBLE_SWORD);
	public static final Item boilingBlade = new ItemModSword("boilingBlade", "Boiling Blade", EssenceToolMaterial.BOILING_BLADE);
	public static final Item loggersSword = new ItemModSword("loggersSword", "Loggers Sword", EssenceToolMaterial.LOGGERS_SWORD);
	public static final Item naturesBlade = new ItemModSword("naturesBlade", "Natures Blade", EssenceToolMaterial.NATURES_BLADE);
	public static final Item depthsDarksword = new ItemModSword("depthsDarksword", "Depths Darksword", EssenceToolMaterial.DEPTHS_DARKSWORD);
	public static final Item depthsSlayer = new ItemModSword("depthsSlayer", "Depths Slayer", EssenceToolMaterial.DEPTHS_SLAYER);
	public static final Item snowShoveler = new ItemModSword("snowShoveler", "Snow Shoveler", EssenceToolMaterial.SNOW_SHOVELER);
	public static final Item frostySword = new ItemModSword("frostySword", "Frosty Sword", EssenceToolMaterial.FROSTY_SWORD);
	public static final Item frostbittenSword = new ItemModSword("frostbittenSword", "Frostbitten Sword", EssenceToolMaterial.FROSTBITTEN_SWORD);
	public static final Item treeHugger = new ItemModSword("treeHugger", "Tree Hugger", EssenceToolMaterial.TREE_HUGGER);
	public static final Item healersBlade = new ItemModSword("healersBlade", "Healers Blade", EssenceToolMaterial.HEALERS_BLADE);
	public static final Item coreMender = new ItemModSword("coreMender", "Core Mender", EssenceToolMaterial.CORE_MENDER);
	public static final Item royalBlade = new ItemModSword("royalBlade", "Royal Blade", EssenceToolMaterial.ROYAL_BLADE);
	public static final Item royalStabber = new ItemModSword("royalStabber", "Royal Stabber", EssenceToolMaterial.ROYAL_STABBER);
	public static final Item rocSword = new ItemModSword("rocSword", "Roc Sword", EssenceToolMaterial.ROC_SWORD);
	public static final Item swordOfTheThunderbird = new ItemModSword("swordOfTheThunderbird", "Sword of the Thunderbird", EssenceToolMaterial.SWORD_THUNDERBIRD);
	public static final Item bloodwieldSword = new ItemModSword("bloodWieldSword", "Blood Wielder", EssenceToolMaterial.BLOODWIELD_SWORD);
	public static final Item charredBlade = new ItemModSword("charredBlade", "Charred Blade", EssenceToolMaterial.CHARRED_BLADE);
	public static final Item sizzlerSword = new ItemModSword("sizzlerSword", "Sizzler Sword", EssenceToolMaterial.SIZZLER_SWORD);
	public static final Item fluffyBlade = new ItemModSword("fluffyBlade", "Fluffy Blade", EssenceToolMaterial.FLUFFY_BLADE);
	public static final Item golemSword = new ItemModSword("golemSword", "Golem Sword", EssenceToolMaterial.GOLEM_SWORD);
	public static final Item thunderblade = new ItemModSword("thunderblade", "Thunder Blade", EssenceToolMaterial.THUNDERBLADE);
	public static final Item sentrySword = new ItemModSword("sentrySword", "Sentry Sword", EssenceToolMaterial.SENTRY_SWORD);
	public static final Item crystalBlade = new ItemModSword("crystalBlade", "Crystal Blade", EssenceToolMaterial.CRYSTAL_BLADE);
	public static final Item starlightBlade = new ItemModSword("starlightBlade", "Starlight Blade", EssenceToolMaterial.STARLIGHT_BLADE);
	public static final Item koriteSword = new ItemModSword("koriteSword", "Korite Sword", EssenceToolMaterial.KORITE_SWORD);
	public static final Item storonSword = new ItemModSword("storonSword", "Storon Sword", EssenceToolMaterial.KORITE_SWORD);
	public static final Item mekyumSword = new ItemModSword("mekyumSword", "Mekyum Sword", EssenceToolMaterial.KORITE_SWORD);
	public static final Item pedalSword = new ItemModSword("pedalSword", "Pedal Sword", EssenceToolMaterial.PEDAL_SWORD);
	
	public static final Item developerSword = new ItemModSword("developerSword", "Developer Sword", EssenceToolMaterial.DEVELOPER_SWORD);
	
	public static final Item eucaPortalGem = new ItemMod("eucaPortalGem", "Euca Portal Gem");
	public static final Item depthsPortalGem = new ItemMod("depthsPortalGem", "Depths Portal Gem");
	public static final Item corbaPortalGem = new ItemMod("corbaPortalGem", "Corba Portal Gem");
	//public static final Item wastelandPortalGem = new ItemMod("wastelandPortalGem");

	public static final Item calciaOrb = new ItemNetherBossSpawner("calciaOrb", "Calcia Orb");
	public static final Item netherBeastOrb = new ItemNetherBossSpawner("netherBeastOrb", "Nether Beast Orb");
	public static final Item witheringBeastOrb = new ItemNetherBossSpawner("witheringBeastOrb", "Withering Beast Orb");
	public static final Item eudorOrb = new ItemEssenceBossSpawner("eudorOrb", "EudorOrb");
	public static final Item blazierOrb = new ItemSpecificDimensionSpawner(Config.boil, "blazierOrb", "Blazier Orb", "Boiling Point");
	public static final Item rocSpawnEgg = new ItemSpecificDimensionSpawner(0, "rocPetSpawnEgg", "Pet Roc Egg", "Overworld");
	public static final Item soulWatcherOrb = new ItemSpecificDimensionSpawner(Config.boil, "soulWatcherOrb", "Soul Watcher Orb", "Boiling Point");
	public static final Item sentryKingOrb = new ItemSpecificDimensionSpawner(Config.corba, "sentryKingOrb", "Sentry King Orb", "Corba");
	public static final Item thunderbirdOrb = new ItemSpecificDimensionSpawner(Config.depths, "thunderbirdOrb", "Thunderbird Orb", "Depths");
	public static final Item mysteriousDisk = new ItemSpecificDimensionSpawner(Config.cloudia, "mysteriousDisk", "Mysterious Disk", "Cloudia");
	
	//TODO
	public static final Item scaleOrb = new ItemSpecificDimensionSpawner(Config.depths, "scaleOrb", "Scale Orb", "Depths");

	public static final Item weakDarkEnergyPotion = new ItemEssencePotion("weakDarkEnergyPotion", "Weak Dark Energy Potion", false, false);
	public static final Item strongDarkEnergyPotion = new ItemEssencePotion("strongDarkEnergyPotion", "Strong Dark Energy Potion", true, false);
	public static final Item weakEssencePotion = new ItemEssencePotion("weakEssencePotion", "Weak Essence Potion", false, true);
	public static final Item strongEssencePotion = new ItemEssencePotion("strongEssencePotion", "Strong Essence Potion", true, true);

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
	
	public static final Item charskullHelmet = new ItemModArmor(EnumArmor.CHAR_SKULL, HEAD);
	public static final Item charskullChest = new ItemModArmor(EnumArmor.CHAR_SKULL, BODY);
	public static final Item charskullLegs = new ItemModArmor(EnumArmor.CHAR_SKULL, LEGS);
	public static final Item charskullBoots = new ItemModArmor(EnumArmor.CHAR_SKULL, BOOTS);
	
	public static final Item bronzedHelmet = new ItemModArmor(EnumArmor.BRONZED, HEAD);
	public static final Item bronzedChest = new ItemModArmor(EnumArmor.BRONZED, BODY);
	public static final Item bronzedLegs = new ItemModArmor(EnumArmor.BRONZED, LEGS);
	public static final Item bronzedBoots = new ItemModArmor(EnumArmor.BRONZED, BOOTS);
	
	public static final Item golditeHelmet = new ItemModArmor(EnumArmor.GOLDITE, HEAD);
	public static final Item golditeChest = new ItemModArmor(EnumArmor.GOLDITE, BODY);
	public static final Item golditeLegs = new ItemModArmor(EnumArmor.GOLDITE, LEGS);
	public static final Item golditeBoots = new ItemModArmor(EnumArmor.GOLDITE, BOOTS);
	
	public static final Item backBiter = new ItemBattleAxe("backBiter", "Back Biter", EssenceToolMaterial.BACK_BITER);
	public static final Item dawnBreaker = new ItemBattleAxe("dawnBreaker", "Dawn Breaker", EssenceToolMaterial.DAWN_BREAKER);
	public static final Item tempestBattleaxe = new ItemBattleAxe("tempestBattleaxe", "Tempest Battleaxe", EssenceToolMaterial.TEMPEST_BATTLEAXE);
	public static final Item bronzedBattleaxe = new ItemBattleAxe("bronzedBattleaxe", "Bronzed Battleaxe", EssenceToolMaterial.BRONZED_BATTLEAXE);
	public static final Item celestiteBattleaxe = new ItemBattleAxe("celestiteBattleaxe", "Celestite Battleaxe", EssenceToolMaterial.CELESTITE_BATTLEAXE);
	public static final Item storumBattleaxe = new ItemBattleAxe("storumBattleaxe", "Storum Battleaxe", EssenceToolMaterial.STORUM_BATTLEAXE);
	public static final Item celekiumBattleaxe = new ItemBattleAxe("celekiumBattleaxe", "Celekium Battleaxe", EssenceToolMaterial.CELEKIUM_BATTLEAXE);
	public static final Item thunderbirdBattleaxe = new ItemBattleAxe("thunderbirdBattleaxe", "Thunderbird Battleaxe", EssenceToolMaterial.THUNDERBIRD_BATTLEAXE);

	public static final Item staffOfHellstone = new ItemStaff("staffOfHellstone", "Staff of Hellstone", false, 3, 1000, 7, false, EntityBasicProjectile.class);
	public static final Item doomsBringer = new ItemStaff("doomsBringer", "Dooms Bringer", false, 3, 1000, 12, false, EntityDoomsBringer.class);
	public static final Item conjuringStaff = new ItemStaff("conjuringStaff", "Conjuring Staff", false, 3, 1000, 18, false, EntityConjuring.class);
	public static final Item staffOfEnlightenment = new ItemStaff("staffOfEnlightenment", "Staff Of Enlightenment", true, 3, 1000, 14, false, EntityEnlightenment.class);
	public static final Item staffOfGreenpace = new ItemStaff("staffOfGreenpace", "Staff Of Greenpace", true, 3, 1000, 10, false, EntityGreenpace.class);
	public static final Item wizardsStar = new ItemStaff("wizardsStar", "Wizards Star", true, 3, 1000, 5, false, EntityWizardsStar.class);
	public static final Item teleportationStaff = new ItemTeleport("teleportationStaff", "Teleportation Staff");

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
	public static final Item eucaMeat = new ItemModFood("eucaMeat", "Euca Meat", 6, 0.6F, 10, false);
	public static final Item rocMeat = new ItemModFood("rocMeat", "Bird Wing", 6, 0.6F, 10, false);
	public static final Item cookedRocMeat = new ItemModFood("cookedRocMeat", "Cooked Bird Wing", 6, 0.6F, 10, false);
	public static final Item hongoShroom = new ItemModFood("hongoShroom", "Hongoshroom", 6, 0.6F, 10, false);
	public static final Item greenHonglowShroom = new ItemHonglow("greenHonglowShroom", "Green Honglowshroom", 4, 1.2F, false, false).setPotionEffect(Potion.jump.id, 10, 1, 1.0F).setAlwaysEdible();
	public static final Item redHonglowShroom = new ItemHonglow("redHonglowShroom", "Red Honglowshroom", 4, 1.2F, false, false).setPotionEffect(Potion.regeneration.id, 10, 1, 1.0F).setAlwaysEdible();
	public static final Item blueHonglowShroom = new ItemHonglow("blueHonglowShroom", "Blue Honglowshroom", 4, 1.2F, false, false).setPotionEffect(Potion.moveSpeed.id, 10, 1, 1.0F).setAlwaysEdible();
	public static final Item honglowShroom = new ItemHonglow("honglowShroom", "Honglowshroom", 4, 1.2F, false, false).setAlwaysEdible();

	public static final ItemModDoor hotDoorItem = new ItemModDoor(EssenceBlocks.hotDoor, "hotDoor", "Hot Door");

	//public static final Item flameArrow = new ItemMod("flameArrow", EssenceTabs.ranged);
	public static final Item essenceArrow = new ItemMod("essenceArrow", "Essence Arrow", EssenceTabs.ranged);

	public static final Item flameBow = new ItemModBow("flameBow", "Flame Bow", 384, essenceArrow, EntityFlameArrow.class);
	public static final Item poisonBow = new ItemModBow("poisonBow", "Poison Bow", 384, essenceArrow, 18, EntityPoisonArrow.class);
	public static final Item darknessBow = new ItemModBow("darknessBow", "Darkness Bow", 384, essenceArrow, 10, EntityDarknessArrow.class);
	public static final Item frozenBow = new ItemModBow("frozenBow", "Frozen Bow", 384, essenceArrow, 33, EntityFrozenArrow.class);
	public static final Item staringBow = new ItemModBow("staringBow", "Staring Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item deathPiercerBow = new ItemModBow("deathPiercerBow", "Death Piercer Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item fusionBow = new ItemModBow("fusionBow", "Fusion Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item springBow = new ItemModBow("springBow", "Spring Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item starlightBow = new ItemModBow("starlightBow", "Starlight Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item wastefulBow = new ItemModBow("wastefulBow", "Wasteful Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item flamingBow = new ItemModBow("flamingBow", "Flaming Bow", 384, essenceArrow, EntityFlamingArrow.class);
	public static final Item blazingBow = new ItemModBow("blazingBow", "Blazing Bow", 384, essenceArrow, EntityFlamingArrow.class);
	public static final Item darkEnforcer = new ItemModBow("darkEnforcer", "Dark Enforcer", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item depthsBow = new ItemModBow("depthsBow", "Depths Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item frostbittenBow = new ItemModBow("frostbittenBow", "Frostbitten Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item frostyBow = new ItemModBow("frostyBow", "Frosty Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item charredBow = new ItemModBow("charredBow", "Charred Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item fluffyBow = new ItemModBow("fluffyBow", "Fluffy Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item golemBow = new ItemModBow("golemBow", "Golem Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item loggersBow = new ItemModBow("loggersBow", "Loggers Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item overgrownBow = new ItemModBow("overgrownBow", "Overgrown Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item overseerBow = new ItemModBow("overseerBow", "Overseer Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item woodlandBow = new ItemModBow("woodlandBow", "Woodland Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item rocsWing = new ItemModBow("rocsWing", "Rocs Wing", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item scaleBow = new ItemModBow("scaleBow", "Scale Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item mantleBow = new ItemModBow("mantleBow", "Mantle Bow", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item coreExpender = new ItemModBow("coreExpender", "Core Expender", 384, essenceArrow, EntityEssenceArrow.class);
	public static final Item royalBow = new ItemModBow("royalBow", "Royal Bow", 384, essenceArrow, EntityEssenceArrow.class);

	//public static final Item backpack = new ItemBackpack("backpack");

	public static final Item fireWand = new ItemWand("fireWand", "Fire Wand", false, 5, 600, 8, false, EntityFireBall.class);
	public static final Item iceWand = new ItemWand("iceWand", "Ice Wand", true, 5, 600, 8, false, EntityIceBall.class);
	public static final Item lightningWand = new ItemWand("lightningWand", "Lightning Wand", false, 10, 600, 8, false, EntityLightningBall.class);
	
	public static final Item chaosCannon = new ItemChaosCannon("chaosCannon", "Chaos Cannon");
	public static final Item rockLauncher = new ItemChaosCannon("rockLauncher", "Rock Launcher");
	public static final Item netherPlasma = new ItemChaosCannon("netherPlasma", "Nether Plasma");
	public static final Item oceanPlasma = new ItemChaosCannon("oceanPlasma", "Ocean Plasma");
	public static final Item forestPlasma = new ItemChaosCannon("forestPlasma", "Forest Plasma");
	public static final Item eyeBlaster = new ItemChaosCannon("eyeBlaster", "Eye Blaster");
	
	public static final Item greenGem = new ItemMod("greenGem", "Green Gem");
	public static final Item purpleGem = new ItemMod("purpleGem", "Purple Gem");
	public static final Item blueGem = new ItemMod("blueGem", "Blue Gem");
	public static final Item yellowGem = new ItemMod("yellowGem", "Yellow Gem");

	public static final Item eucaTablet = new ItemMod("eucaTablet", "Euca Tablet");

	public static final Item wandBase = new ItemMod("wandBase", "Wand Base");
	public static final Item staffBase = new ItemMod("staffBase", "Staff Base");

	/**
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
	*/

	//TODO
	public static final Item tomato = new ItemModFood("tomato", "Tomato", 3, 0.6F, false);
	public static final Item corveggies = new ItemModFood("corveggies", "Corveggies", 3, 0.6F, false);
	public static final Item crackenCanes = new ItemModFood("crackenCanes", "Kracken Canes", 3, 0.6F, false);
	public static final Item crakeBulb = new ItemModFood("crakeBulb"," Crake Bulb", 3, 0.6F, false);
	public static final Item spineberries = new ItemModFood("spineberries", "Spine Berries", 3, 0.6F, false);
	public static final Item zatPedal = new ItemModFood("zatPedal", "Zat Pedal", 3, 0.6F, false);
	public static final Item glowa = new ItemModFood("glowa", "Glowa", 3, 0.6F, false);
	public static final Item mintCandyCane = new ItemModFood("mintCandyCane", "Mint Candy Cane", 3, 0.6F, false);
	public static final Item fruityCandyCane = new ItemModFood("fruityCandyCane", "Fruity Candy Cane", 3, 0.6F, false);
	public static final Item cherryCandyCane = new ItemModFood("cherryCandyCane", "Cherry Candy Cane", 3, 0.6F, false);
	public static final Item peppermint = new ItemModFood("peppermint", "Peppermint", 3, 0.6F, false);
	public static final Item jellyBeans = new ItemModFood("jellyBeans", "Jelly Beans", 3, 0.6F, false);
	public static final Item chocolate = new ItemModFood("chocolate", "Chocolate Bar", 3, 0.6F, false);
	public static final Item vanillaWafer = new ItemModFood("vanillaWafer", "Vanilla Wafer", 3, 0.6F, false);

	public static final Item tomatoSeeds = new ItemModSeeds("tomatoSeeds", "Tomato Seeds", EssenceBlocks.tomatoCrop);
	public static final Item corveggieSeeds = new ItemModSeeds("corveggieSeeds", "Corveggie", EssenceBlocks.corveggieCrop);
	public static final Item crackenCaneSeeds = new ItemModSeeds("crackenCaneSeeds", "Kracken Cane Seeds", EssenceBlocks.crackenCaneCrop);
	public static final Item crakeBulbSeeds = new ItemModSeeds("crakeBulbSeeds", "Crake Bulb Seeds", EssenceBlocks.crakeBulbCrop);
	public static final Item spineberrySeeds = new ItemModSeeds("spineberrySeeds", "Spine Berry Seeds", EssenceBlocks.spineberryCrop);
	public static final Item glowaSeeds = new ItemModSeeds("glowaSeeds", "Glowa Seeds", EssenceBlocks.glowaCrop);
	public static final Item zatSeeds = new ItemModSeeds("zatSeeds", "Zat Seeds", EssenceBlocks.zatPedalsCrop);

	public static final Item underwaterWorldRecord = new ItemModRecord("underwaterWorld", "Underwater World");
	public static final Item blueWater = new ItemModRecord("blueWater", "Blue Water");
	public static final Item raceStar = new ItemModRecord("raceStar", "Race Star");
	public static final Item compBegins = new ItemModRecord("compBegins", "Compition Begins");
	public static final Item deepBlue = new ItemModRecord("deepBlue", "Deep Blue");
	public static final Item raceShore = new ItemModRecord("raceShore", "Race to Shore");
	
	public static final Item demonicEye = new ItemDemonicEye("demonicEye", "Demonic Eye");

	public static final ItemKnowledge overworldKnowledge = new ItemKnowledge("overworldKnowledge", "Overworld Knowledge", EnumKnowledge.OVERWORLD);
	public static final ItemKnowledge netherKnowledge = new ItemKnowledge("netherKnowledge", "Nether Knowledge", EnumKnowledge.NETHER);
	public static final ItemKnowledge endKnowledge = new ItemKnowledge("endKnowledge", "End knowledge", EnumKnowledge.END);
	public static final ItemKnowledge boilKnowledge = new ItemKnowledge("boilingKnowledge", "Boiling Knowledge", EnumKnowledge.BOIL);
	public static final ItemKnowledge frozenKnowledge = new ItemKnowledge("frozenKnowledge", "Frozen Knowledge", EnumKnowledge.FROZEN);
	public static final ItemKnowledge eucaKnowledge = new ItemKnowledge("eucaKnowledge", "Euca Knowledge", EnumKnowledge.EUCA);
	public static final ItemKnowledge depthsKnowledge = new ItemKnowledge("depthsKnowledge", "Depths Knowledge", EnumKnowledge.DEPTHS);
	public static final ItemKnowledge corbaKnowledge = new ItemKnowledge("corbaKnowledge", "Corba Knowledge", EnumKnowledge.CORBA);
	public static final ItemKnowledge cloudiaKnowledge = new ItemKnowledge("cloudiaKnowledge", "Cloudia Knowledge", EnumKnowledge.CLOUDIA);
	//public static final ItemKnowledge wastelandsKnowledge = new ItemKnowledge("wastelandsKnowledge", EnumKnowledge.WASTELANDS);
	//public static final ItemKnowledge lithiumKnowledge = new ItemKnowledge("lithiumKnowledge", EnumKnowledge.LITHIUM);
	//public static final ItemKnowledge libraryKnowledge = new ItemKnowledge("libraryKnowledge", EnumKnowledge.LIBRARY);
	//public static final ItemKnowledge blazeKnowledge = new ItemKnowledge("blazeKnowledge", EnumKnowledge.BLAZE);
	//public static final ItemKnowledge witherKnowledge = new ItemKnowledge("witherKnowledge", EnumKnowledge.WITHER);

	public static final ItemMod boilingPointEssence = new ItemMod("boilingPointEssence", "Boiling Point Essence");
	public static final ItemMod cloudiaEssence = new ItemMod("cloudiaEssence", "Cloudia Essence");
	public static final ItemMod corbaEssence = new ItemMod("corbaEssence", "Corba Essence");
	public static final ItemMod depthsEssence = new ItemMod("depthsEssence", "Depths Essence");
	public static final ItemMod eucaEssence = new ItemMod("eucaEssence", " Euca Essence");
	public static final ItemMod frozenLandsEssence = new ItemMod("frozenLandsEssence", "Frozen Lands Essence");
	//public static final ItemMod wastelandsEssence = new ItemMod("wastelandsEssence");
	//public static final ItemMod lithiumEssence = new ItemMod("lithiumEssence");
	//public static final ItemMod nethicEssence = new ItemMod("nethicEssence");
	//public static final ItemMod subterrianEssence = new ItemMod("subterrianEssence");
	//public static final ItemMod withicEssence = new ItemMod("withicEssence");
	//public static final ItemMod blazesEssence = new ItemMod("blazesEssence");
	
	//TODO
	public static final Item boilingPiercer = new ItemPiercer("boilingPiercer", "Boiling Piercer", 12F, EntityBoilingPiercer.class);
	//public static final Item nethicPiercer = new ItemPiercer("nethicPiercer", "Nethic Piercer", 11F, EntityNethicPiercer.class);
	public static final Item frozenPiercer = new ItemPiercer("frozenPiercer", "Frozen Piercer", 9F, EntityFrozenPiercer.class);
	public static final Item eucaPiercer = new ItemPiercer("eucaPiercer", "Euca Piercer", 12F, EntityEucaPiercer.class);
	public static final Item depthsPiercer = new ItemPiercer("depthsPiercer", "Depths Piercer", 21F, EntityDepthsPiercer.class);
	public static final Item corbaPiercer = new ItemPiercer("corbaPiercer", "Corba Piercer", 29F, EntityCorbaPiercer.class);
	public static final Item frostbittenPiercer = new ItemPiercer("frostbittenPiercer", "Frostbitten Piercer", 10F, EntityFrostbittenPiercer.class);
	public static final Item frostyPiercer = new ItemPiercer("frostyPiercer", "Frosty Piercer", 9F, EntityFrostyPiercer.class);
	public static final Item sunsetPiercer = new ItemPiercer("sunsetPiercer", "Sunset Piercer", 10F, EntityFrostyPiercer.class);
	public static final Item skyPiercer = new ItemPiercer("skyPiercer", "Sky Piercer", 10F, EntityFrostyPiercer.class);
	public static final Item demonicBomb = new ItemPiercer("demonicBomb", "Demonic Bomb", 8F, EntityDemonicBomb.class);
	
	public static final Item moltenKnife = new ItemPiercer("moltenKnife", "Molten Knife", 10F, EntityFrostyPiercer.class);
	public static final Item royalKnife = new ItemPiercer("royalKnife", "Royal Knife", 14F, EntityFrostyPiercer.class);
	public static final Item aquaticKnife = new ItemPiercer("aquaticKnife", "Aquatic Knife", 6F, EntityFrostyPiercer.class);
	public static final Item bloodKnife = new ItemPiercer("bloodKnife", "Blood Knife", 6F, EntityFrostyPiercer.class);
	public static final Item charredKnife = new ItemPiercer("charredKnife", "Charred Knife", 6F, EntityFrostyPiercer.class);
	public static final Item sizzlingKnife = new ItemPiercer("sizzlingKnife", "Sizzling Knife", 6F, EntityFrostyPiercer.class);
	
	/**
	public static final Item weakPower = new ItemPower("weakPower", 10F);
	*/

	public static ToolMaterial addToolMaterial(int uses, float efficiency, float dam, boolean breakable) {
		return EnumHelper.addToolMaterial("tool", 3, breakable ? uses : -1, efficiency, dam, 30);
	}

}