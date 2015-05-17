package net.essence;

import java.util.ArrayList;

import net.essence.blocks.BlockBoilingFire;
import net.essence.blocks.BlockBrison;
import net.essence.blocks.BlockBrittleIce;
import net.essence.blocks.BlockCaveVine;
import net.essence.blocks.BlockCloud;
import net.essence.blocks.BlockColouredBricks;
import net.essence.blocks.BlockCorbaPortalFrame;
import net.essence.blocks.BlockDungeonBlock;
import net.essence.blocks.BlockEssenceStandingSign;
import net.essence.blocks.BlockEssenceWallSign;
import net.essence.blocks.BlockEucaPumpkin;
import net.essence.blocks.BlockEucaSapling;
import net.essence.blocks.BlockFrozenPortal;
import net.essence.blocks.BlockGemBlock;
import net.essence.blocks.BlockGlowshroom;
import net.essence.blocks.BlockHalfSlab;
import net.essence.blocks.BlockIceLog;
import net.essence.blocks.BlockIcicle;
import net.essence.blocks.BlockJoinedGlass;
import net.essence.blocks.BlockMiniColouredBricks;
import net.essence.blocks.BlockStatue;
import net.essence.blocks.BlockTropicalWater;
import net.essence.blocks.BlockWastelandsStone;
import net.essence.blocks.base.BlockModFire;
import net.essence.blocks.base.BlockModOre;
import net.essence.blocks.crop.BlockCorveggieCrop;
import net.essence.blocks.crop.BlockCrackenCaneCrop;
import net.essence.blocks.crop.BlockCrakeBulbCrop;
import net.essence.blocks.crop.BlockGlowaCrop;
import net.essence.blocks.crop.BlockSpineberryCrop;
import net.essence.blocks.crop.BlockTomatoCrop;
import net.essence.blocks.crop.BlockZatPedalsCrop;
import net.essence.blocks.machines.BlockGrindstone;
import net.essence.blocks.machines.BlockKnowledgeTable;
import net.essence.blocks.machines.BlockSummoningTable;
import net.essence.blocks.portal.BlockBoilPortal;
import net.essence.blocks.portal.BlockCloudiaPortal;
import net.essence.blocks.portal.BlockCorbaPortal;
import net.essence.blocks.portal.BlockDepthsPortal;
import net.essence.blocks.portal.BlockEucaPortal;
import net.essence.blocks.portal.BlockWastelandsPortal;
import net.essence.client.render.model.statue.ModelCalciaStatue;
import net.essence.client.render.model.statue.ModelEudorStatue;
import net.essence.client.render.model.statue.ModelNetherBeastStatue;
import net.essence.client.render.model.statue.ModelWitheringBeastStatue;
import net.essence.enums.EnumSounds;
import net.minecraft.block.Block;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.EnumToolType;
import net.slayer.api.block.BlockMod;
import net.slayer.api.block.BlockModDoor;
import net.slayer.api.block.BlockModFence;
import net.slayer.api.block.BlockModFlower;
import net.slayer.api.block.BlockModGrass;
import net.slayer.api.block.BlockModLeaves;
import net.slayer.api.block.BlockModLog;
import net.slayer.api.block.BlockModSlab;
import net.slayer.api.block.BlockModStairs;

public class EssenceBlocks {

	public static ArrayList<String> blockName = new ArrayList<String>();
	
	public static final Block hellstoneOre = new BlockModOre("hellstoneOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block celestiumOre = new BlockModOre("celestiumOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block mekyumOre = new BlockModOre("mekyumOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block koriteOre = new BlockModOre("koriteOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block storonOre = new BlockModOre("storonOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	
	public static final Block luniumOre = new BlockModOre("luniumOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block shadiumOre = new BlockModOre("shadiumOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block flairiumOre = new BlockModOre("flairiumOre").setHarvestLevel(EnumToolType.DIAMOND_PICK).setLightLevel(0.5F);
	public static final Block desOre = new BlockModOre("desOre").setHarvestLevel(EnumToolType.DIAMOND_PICK).setLightLevel(0.5F);
	public static final Block ashual = new BlockModOre("ashual");
	public static final Block sapphireOre = new BlockModOre("sapphireOre").setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block enderilliumOre = new BlockModOre("enderilliumOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block gorbiteOre = new BlockModOre("gorbiteOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block orbaditeOre = new BlockModOre("orbaditeOre").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	
	public static final Block hellstoneBlock = new BlockModOre("hellstoneBlock").setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block celestiumBlock = new BlockModOre("celestiumBlock").setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block luniumBlock = new BlockModOre("luniumBlock").setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block shadiumBlock = new BlockModOre("shadiumBlock").setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block flairiumBlock = new BlockModOre("flairiumBlock").setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block sapphireBlock = new BlockModOre("sapphireBlock").setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block enderilliumBlock = new BlockModOre("enderilliumBlock").setHarvestLevel(EnumToolType.IRON_PICK);

	public static final Block greenGemBlock = new BlockMod("greenGemBlock");
	public static final Block purpleGemBlock = new BlockMod("purpleGemBlock");
	public static final Block blueGemBlock = new BlockMod("blueGemBlock");
	public static final Block yellowGemBlock = new BlockMod("yellowGemBlock");

	/*public static final Block hellstoneBlockOverlay = new BlockModOre("hellstoneBlock_overlay", -1).setCreativeTab(null);
	public static final Block celestiumBlockOverlay = new BlockModOre("celestiumBlock_overlay", -1).setCreativeTab(null);
	public static final Block luniumBlockOverlay = new BlockModOre("luniumBlock_overlay", -1).setCreativeTab(null);
	public static final Block shadiumBlockOverlay = new BlockModOre("shadiumBlock_overlay", -1).setCreativeTab(null);
	public static final Block flairiumBlockOverlay = new BlockModOre("flairiumBlock_overlay", -1).setCreativeTab(null);*/

	public static final BlockModSlab eucaSlab = new BlockModSlab(false, "eucaSlab");
	//public static final BlockModDoubleSlab eucaFullSlab = new BlockModDoubleSlab(true, "eucaDoubleSlab");
	
	public static final BlockModSlab depthsSlab = new BlockModSlab(false, "depthsSlab");
	//public static final BlockModDoubleSlab depthsFullSlab = new BlockModDoubleSlab(true, "depthsDoubleSlab");
	
	public static final Block eucaGrass = new BlockModGrass(null, "eucaGrass", 2.0F);
	public static final Block eucaStone = new BlockMod("eucaStone", 2.0F);
	public static final Block eucaGoldLog = new BlockModLog("eucaGoldLog");
	public static final Block goldEucaPlank = new BlockMod(EnumMaterialTypes.WOOD, "goldEucaPlank", 1.0F);
	public static final Block eucaGoldStairs = new BlockModStairs(eucaGoldLog, "eucaGoldStairs");
	public static final Block eucaGoldLeaves = new BlockModLeaves("eucaGoldLeaves", 1.0F);
	public static final Block eucaSilverLeaves = new BlockModLeaves("eucaSilverLeaves", 1.0F);
	public static final Block eucaSapling = new BlockEucaSapling("eucaSapling");
	
	public static final BlockMod depthsDirt = new BlockMod(EnumMaterialTypes.DIRT, "depthsDirt", 2.0F);
	public static final Block depthsGrass = new BlockModGrass(depthsDirt, "depthsGrass", 2.0F);
	public static final Block depthsStone = new BlockMod("depthsStone", 2.0F);
	public static final Block depthsLog = new BlockModLog("depthsLog");
	public static final Block depthsPlank = new BlockMod(EnumMaterialTypes.WOOD, "depthsPlank", 1.0F);
	public static final Block depthsStairs = new BlockModStairs(depthsPlank, "depthsStairs");
	public static final Block depthsLeaves = new BlockModLeaves("depthsLeaves", 1.0F);

	//public static final BlockMod godDirt = new BlockMod(EnumMaterialTypes.DIRT, "godDirt", 2.0F);
	//public static final Block godGrass = new BlockModGrass(godDirt, "godGrass", 2.0F);
	//public static final Block godStone = new BlockMod("godStone", 2.0F);
	
	public static final BlockMod frozenDirt = new BlockMod(EnumMaterialTypes.DIRT, "frozenDirt", 2.0F);
	public static final BlockMod frozenStone = new BlockMod(EnumMaterialTypes.STONE, "frozenStone", 5.0F);
	public static final Block frozenGrass = new BlockModGrass(frozenDirt, "frozenGrass", 2.0F);
	public static final Block frozenLeaves = new BlockModLeaves("frozenLeaves", 0.5F).setFrozenPlant().setLightLevel(1);
	public static final Block frozenBark = new BlockModLog("frozenBark");
	public static final Block frozenPlanks = new BlockMod(EnumMaterialTypes.WOOD, "frozenPlanks", 0.5F);
	
	public static final BlockMod corbaStone = new BlockMod("corbaStone");
	public static final Block corbaGrass = new BlockModGrass((BlockMod)null, "corbaGrass", 0.5F);
	public static final Block corbaLog = new BlockModLog("corbaLog");
	public static final Block corbaLeaves = new BlockModLeaves("corbaLeaves", 0.2F);
	public static final Block corbaPillar = new BlockMod("corbaPillar");
	public static final Block corbaPlank = new BlockMod(EnumMaterialTypes.WOOD, "corbaPlank", 0.5F);
	
	public static final Block blazierBricks = new BlockMod("blazierBricks"); 
	
	public static final BlockMod cloudiaDirt = new BlockMod(EnumMaterialTypes.DIRT, "cloudiaDirt", 2.0F);
	public static final Block cloudiaGrass = new BlockModGrass(cloudiaDirt, "cloudiaGrass", 2.0F);
	public static final Block cloudiaLog = new BlockModLog("cloudiaLog"); 
	public static final Block cloudiaRock = new BlockMod("cloudiaRock"); 
	public static final Block cloudiaBrick = new BlockMod("cloudiaBrick");
	public static final Block cloudiaWall = new BlockMod("cloudiaWall"); 
	public static final Block cloudiaTile = new BlockMod("cloudiaTile"); 
	public static final Block cloudiaLamp = new BlockMod("cloudiaLamp").setLightLevel(1.0F);
	//public static final Block cloudiaPost = new BlockCloudiaPost("cloudiaPost");
	public static final Block pinkCloudiaCloud = new BlockCloud("pinkCloudiaCloud");
	public static final Block blueCloudiaCloud = new BlockCloud("blueCloudiaCloud");
	public static final Block lightBlueCloudiaCloud = new BlockCloud("lightBlueCloudiaCloud");
	
	public static final BlockMod wastelandsStone = new BlockWastelandsStone("wastelandsStone");
	public static final Block wastelandsGrass = new BlockModGrass((BlockMod)null, "wastelandsGrass", 2.0F);
	public static final Block wastelandsLog = new BlockModLog("wastelandsLog");
	public static final Block wastelandsBranches = new BlockModLog("wastelandsBranches");

	public static final BlockEucaPortal eucaPortal = (BlockEucaPortal)new BlockEucaPortal("eucaPortal");
	public static final Block eucaPortalFrame = new BlockMod("eucaPortalFrame", 3.0F);
	public static final BlockDepthsPortal depthsPortal = (BlockDepthsPortal)new BlockDepthsPortal("depthsPortal");
	public static final Block depthsPortalFrame = new BlockMod("depthsPortalFrame", 3.0F);
	public static final BlockBoilPortal boilPortal = (BlockBoilPortal)new BlockBoilPortal("boilingPortal");
	public static final Block boilPortalFrame = new BlockMod("boilingPortalFrame", 3.0F);
	public static final BlockFrozenPortal frozenPortal = (BlockFrozenPortal)new BlockFrozenPortal("frozenPortal");
	public static final Block frozenPortalFrame = new BlockMod("frozenPortalFrame", 3.0F);
	public static final BlockCorbaPortal corbaPortal = (BlockCorbaPortal)new BlockCorbaPortal("corbaPortal");
	public static final Block corbaPortalFrame = new BlockCorbaPortalFrame("corbaPortalFrame");
	public static final BlockWastelandsPortal wastelandsPortal = (BlockWastelandsPortal)new BlockWastelandsPortal("wastelandsPortal");
	public static final Block wastelandsPortalFrame = new BlockMod("wastelandsPortalFrame");
	public static final BlockCloudiaPortal cloudiaPortal = (BlockCloudiaPortal)new BlockCloudiaPortal("cloudiaPortal");
	public static final Block cloudiaPortalFrame = new BlockMod("cloudiaPortalFrame", 3.0F);
	
	public static final Block depthsLights = new BlockMod("depthsLight").setLightLevel(1.0F);

	public static final Block hotBlock = new BlockMod(EnumMaterialTypes.GRASS, "hotGround", 2.0F);
	public static final Block ashBlock = new BlockMod("ashBlock");
	
	public static final Block fire = new BlockModFire("fire");
	public static final BlockBoilingFire boilingFire = new BlockBoilingFire("boilingFire");
	
	public static final Block mossyEssenceStone = new BlockMod("mossyEssenceStone", 2.0F);

	public static final Block dungeonBrick = new BlockDungeonBlock("dungeonBrick");
	public static final Block dungeonCrackedBrick = new BlockDungeonBlock("dungeonCrackedBrick");
	public static final Block dungeonChisledBrick = new BlockDungeonBlock("dungeonChiseledBrick");
	public static final Block dungeonBrickCarved = new BlockDungeonBlock("dungeonBrickCarved");
	public static final Block dungeonLamp = new BlockDungeonBlock("dungeonLamp", true);
	
	public static final Block dungeonBrickStairs = new BlockModStairs(dungeonBrick, "dungeonBrickStairs");
	public static final Block dungeonCrackedBrickStairs = new BlockModStairs(dungeonCrackedBrick, "dungeonCrackedBrickStairs");
	public static final Block dungeonChisledBrickStairs = new BlockModStairs(dungeonChisledBrick, "dungeonChiseledBrickStairs");
	public static final Block dungeonBrickCarvedStairs = new BlockModStairs(dungeonBrickCarved, "dungeonBrickCarvedStairs");
	public static final Block dungeonLampStairs = new BlockModStairs(dungeonLamp, "dungeonLampStairs", true);

	public static final Block dungeonBrickFence = new BlockModFence(dungeonBrick, "dungeonBrickFence");
	public static final Block dungeonCrackedBrickFence = new BlockModFence(dungeonCrackedBrick, "dungeonCrackedBrickFence");
	public static final Block dungeonChisledBrickFence = new BlockModFence(dungeonChisledBrick, "dungeonChiseledBrickFence");
	public static final Block dungeonBrickCarvedFence = new BlockModFence(dungeonBrickCarved, "dungeonBrickCarvedFence");
	public static final Block dungeonLampFence = new BlockModFence(dungeonLamp, "dungeonLampFence", true);
	
	public static final Block hotBrick = new BlockMod("hotBrick", 2.0F);
	public static final Block hotBrick_fence = new BlockModFence(hotBrick, "hotBrickFence");
	public static final Block hotBrick_stairs = new BlockModStairs(hotBrick, "hotBrickStairs");

	public static final Block hotGlass = new BlockJoinedGlass("hotGlass");
	public static final Block smoothGlass = new BlockJoinedGlass("smoothGlass");
	//public static final Block hotGlassPane = new BlockJoinedPane("hotGlass");
	//public static final Block smoothGlassPane = new BlockJoinedPane("smoothGlass");
	
	public static final Block witheringBeastStatue = new BlockStatue("witheringBeastStatue", new ModelWitheringBeastStatue(), EnumSounds.WITHER);
	public static final Block netherBeastStatue = new BlockStatue("netherBeastStatue", new ModelNetherBeastStatue(), EnumSounds.NETHER_BEAST);
	public static final Block calciaStatue = new BlockStatue("calciaStatue", new ModelCalciaStatue(), EnumSounds.CALCIA);
	public static final Block eudorStatue = new BlockStatue("eudorStatue", new ModelEudorStatue(), EnumSounds.CALCIA);
	//public static final Block enderChampionStatue = new BlockStatue("enderChampionStatue", new ModelEnderChampionStatue());
	//public static final Block wraithStatue = new BlockStatue("wraithStatue", new ModelWraithStatue());

	//public static final Block enrichedEnchantmentTable = new BlockEnrichedEnchantmentTable("enrichedEnchantmentTable");
	
	//public static final Block incubatorIdle = new BlockIncubator("incubator", false);
	//public static final Block incubatorActive = new BlockIncubator("incubatorActive", true);
	
	public static final BlockModDoor hotDoor = new BlockModDoor(EnumMaterialTypes.STONE, 5.0F, "hotDoorBlock");
	
	public static final Block essenceWallSign = new BlockEssenceWallSign("essenceSign");
	public static final Block essenceStandingSign = new BlockEssenceStandingSign("essenceStandingSign");
	
	public static final Block colouredBricks = new BlockColouredBricks();
	public static final Block miniColouredBricks = new BlockMiniColouredBricks();
	public static final Block glowshroomTop = new BlockGlowshroom("glowshroomTop", true);
	public static final Block glowshroomBottom = new BlockGlowshroom("glowshroomBottom", false);

	public static final Block caveVine = new BlockCaveVine("caveVine");

	//public static final Block christmasLights = new BlockChristmasLights("christmasLights");
	
	public static final Block workshopCarpet = new BlockMod(EnumMaterialTypes.WOOL, "workshopCarpet", 0.5F);
	public static final Block frozenGlass = new BlockJoinedGlass("frozenGlass");
	//public static final Block frozenPane = new BlockJoinedPane("frozenGlass");
	public static final Block frozenLamp = new BlockMod(EnumMaterialTypes.GLASS, "frozenLamp", 0.5F).setLightLevel(1.0F);
	public static final Block workshopStone = new BlockMod(EnumMaterialTypes.STONE, "workshopStone", 0.5F);
	public static final Block workshopStoneStair = new BlockModStairs(workshopStone, "workshopStairs");
	public static final Block workshopStoneFence = new BlockModFence(workshopStone, "workshopStoneFence");
	public static final BlockModDoor frozenDoor = new BlockModDoor(EnumMaterialTypes.STONE, 5.0F, "frozenDoorBlock");
	public static final Block candyCane = new BlockMod(EnumMaterialTypes.WOOD, "candyCane", 2.0F);
	public static final Block workshopSlab = new BlockHalfSlab("workshopSlab");
	public static final Block frozenBrick = new BlockMod("frozenBricks");
	public static final Block icicle = new BlockIcicle("icicle");
	public static final BlockModFlower frostberryThorn = new BlockModFlower("frostberryThorn").setContactDamage().setFrozenPlant();
	public static final BlockModFlower iceBud = new BlockModFlower("iceBud").setFrozenPlant();
	public static final BlockModFlower frozenBlooms = new BlockModFlower("frozenBlooms").setFrozenPlant();
	public static final BlockModFlower permaFlower = (BlockModFlower)new BlockModFlower("permaFlower").setFrozenPlant();
	public static final BlockModFlower shiverFlower = (BlockModFlower)new BlockModFlower("shiverFlower").setFrozenPlant();
	public static final BlockModFlower iceBush = (BlockModFlower)new BlockModFlower("iceBush").setFrozenPlant();
	public static final BlockMod iceLog = new BlockIceLog();
	public static final BlockMod brittleIce = new BlockBrittleIce();
	
	public static final BlockModFlower eucaTallGrass = new BlockModFlower("eucaTallGrass");
	public static final BlockModFlower eucaTallFlowers = new BlockModFlower("eucaTallFlowers");
	public static final BlockModFlower eucaBlueFlower = new BlockModFlower("eucaBlueFlower");
	public static final BlockModFlower frozenFlower = new BlockModFlower("frozenFlower");
	public static final BlockModFlower depthsFlower = new BlockModFlower("depthsFlower");
	public static final BlockModFlower depthsBlueFlower = new BlockModFlower("depthsBlueFlower").setLightLevel(0.625F);
	public static final BlockModFlower corbaFlower = new BlockModFlower("corbaFlower");
	public static final BlockModFlower corbaTallGrass = new BlockModFlower("corbaTallGrass");
	public static final BlockModFlower corbaSpeckledFlower = new BlockModFlower("corbaSpeckledFlower");
	public static final BlockModFlower corbaLightPurpleFlower = new BlockModFlower("corbaLightPurpleFlower");
	public static final BlockModFlower corbaRedFlower = new BlockModFlower("corbaRedFlower");
	public static final BlockModFlower corbaBlueFlower = new BlockModFlower("corbaBlueFlower");
	public static final BlockModFlower corbaDarkPurpleFlower = new BlockModFlower("corbaDarkPurpleFlower");
	public static final BlockModFlower flameFlower = new BlockModFlower("flameFlower");
	public static final BlockModFlower infernoPlant = new BlockModFlower("infernoPlant");
	public static final BlockModFlower burntGrass = new BlockModFlower("burntGrass");
	
	public static final Block grindstone = new BlockGrindstone("grindstone");
	public static final Block blueGems = new BlockGemBlock("blueGems", false);
	public static final Block redGems = new BlockGemBlock("redGems", true);
	
	public static final Block tomatoCrop = new BlockTomatoCrop("tomatoCrop");
	public static final Block corveggieCrop = new BlockCorveggieCrop("corveggiesCrop");
	public static final Block crackenCaneCrop = new BlockCrackenCaneCrop("crackenCanesCrop");
	public static final Block crakeBulbCrop = new BlockCrakeBulbCrop("crakeBulbCrop");
	public static final Block spineberryCrop = new BlockSpineberryCrop("spineberryCrop");
	public static final Block glowaCrop = new BlockGlowaCrop("glowaCrop");
	public static final Block zatPedalsCrop = new BlockZatPedalsCrop("zatPedalsCrop");

	public static final Block blackBlock = new BlockMod(EnumMaterialTypes.STONE, "blackBlock", 0.5F);
	public static final Block whiteBlock = new BlockMod(EnumMaterialTypes.STONE, "whiteBlock", 0.5F);

	public static final Block eucaPumpkin = new BlockEucaPumpkin("eucaPumpkin");
	public static final Block gemBlock = new BlockMod("gemBlock", 1F);
	public static final Block cloud = new BlockCloud("cloud");
	
	public static final Block brisonBlocks = new BlockBrison();
	
	public static final Block knowledgeTable = new BlockKnowledgeTable("knowledgeTable");
	public static final Block summoningTable = new BlockSummoningTable("summoningTable");

	//public static final Block tropicalWater = new BlockTropicalWater("tropicalWater");
	
	//public static final Block bowCraftingTable = new BlockBowCrafter("bowCraftingTable");
}