package net.journey;

import java.util.ArrayList;

import net.journey.blocks.BlockBrison;
import net.journey.blocks.BlockBrittleIce;
import net.journey.blocks.BlockCloud;
import net.journey.blocks.BlockColouredBricks;
import net.journey.blocks.BlockCorbaPortalFrame;
import net.journey.blocks.BlockDungeonBlock;
import net.journey.blocks.BlockEucaPumpkin;
import net.journey.blocks.BlockEucaSapling;
import net.journey.blocks.BlockFrozenPortal;
import net.journey.blocks.BlockGemBlock;
import net.journey.blocks.BlockGlowshroom;
import net.journey.blocks.BlockHalfSlab;
import net.journey.blocks.BlockHotBlock;
import net.journey.blocks.BlockIceLog;
import net.journey.blocks.BlockIcicle;
import net.journey.blocks.BlockJoinedGlass;
import net.journey.blocks.BlockMiniColouredBricks;
import net.journey.blocks.base.BlockModFire;
import net.journey.blocks.base.BlockModOre;
import net.journey.blocks.crop.BlockCorveggieCrop;
import net.journey.blocks.crop.BlockCrackenCaneCrop;
import net.journey.blocks.crop.BlockCrakeBulbCrop;
import net.journey.blocks.crop.BlockGlowaCrop;
import net.journey.blocks.crop.BlockSpineberryCrop;
import net.journey.blocks.crop.BlockTomatoCrop;
import net.journey.blocks.crop.BlockZatPedalsCrop;
import net.journey.blocks.machines.BlockGrindstone;
import net.journey.blocks.machines.BlockKnowledgeTable;
import net.journey.blocks.machines.BlockSummoningTable;
import net.journey.blocks.portal.BlockBoilPortal;
import net.journey.blocks.portal.BlockCloudiaPortal;
import net.journey.blocks.portal.BlockCorbaPortal;
import net.journey.blocks.portal.BlockDepthsPortal;
import net.journey.blocks.portal.BlockEucaPortal;
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
import net.slayer.api.block.BlockModSpawner;
import net.slayer.api.block.BlockModStairs;

public class JourneyBlocks {

	public static ArrayList<String> blockName = new ArrayList<String>();
	
	public static final Block sapphireOre = new BlockModOre("sapphireOre", "Sapphire Ore").setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block shadiumOre = new BlockModOre("shadiumOre", "Shadium Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block luniumOre = new BlockModOre("luniumOre", "Lunium Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block hellstoneOre = new BlockModOre("hellstoneOre", "Hellstone Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block ashualOre = new BlockModOre("ashualOre", "Ashual Ore");
	public static final Block blaziumOre = new BlockModOre("blaziumOre", "Blazium Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block celestiumOre = new BlockModOre("celestiumOre", "Celestium Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block mekyumOre = new BlockModOre("mekyumOre", "Mekyum Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block koriteOre = new BlockModOre("koriteOre", "Korite Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block storonOre = new BlockModOre("storonOre", "Storon Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block flairiumOre = new BlockModOre("flairiumOre", "Flairium Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK).setLightLevel(0.5F);
	public static final Block desOre = new BlockModOre("desOre", "Des Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK).setLightLevel(0.5F);
	public static final Block enderilliumOre = new BlockModOre("enderilliumOre", "Enderillium Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block gorbiteOre = new BlockModOre("gorbiteOre", "Gorbite Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block orbaditeOre = new BlockModOre("orbaditeOre", "Orbadite Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);
	public static final Block luniteOre = new BlockModOre("luniteOre", "Lunite Ore").setHarvestLevel(EnumToolType.DIAMOND_PICK);

	public static final Block sapphireBlock = new BlockModOre("sapphireBlock", "Sapphire Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block shadiumBlock = new BlockModOre("shadiumBlock", "Shadium Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block luniumBlock = new BlockModOre("luniumBlock", "Lunium Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block hellstoneBlock = new BlockModOre("hellstoneBlock", "Hellstone Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block ashualBlock = new BlockModOre("ashualBlock", "Ashual Block");
	public static final Block blaziumBlock = new BlockModOre("blaziumBlock", "Blazium Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block celestiumBlock = new BlockModOre("celestiumBlock", "Celestium Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block mekyumBlock = new BlockModOre("mekyumBlock", "Mekyum Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block koriteBlock = new BlockModOre("koriteBlock", "Korite Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block storonBlock = new BlockModOre("storonBlock", "Storon Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block flairiumBlock = new BlockModOre("flairiumBlock", "Flairium Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block desBlock = new BlockModOre("desBlock", "Des Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block enderilliumBlock = new BlockModOre("enderilliumBlock", "Enderillium Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block gorbiteBlock = new BlockModOre("gorbiteBlock", "Gorbite Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block orbaditeBlock = new BlockModOre("orbaditeBlock", "Orbadite Block").setHarvestLevel(EnumToolType.STONE_PICK);
	public static final Block luniteBlock = new BlockModOre("luniteBlock", "Lunite Block").setHarvestLevel(EnumToolType.STONE_PICK);

	public static final Block greenGemBlock = new BlockMod("greenGemBlock", "Green Gem Block");
	public static final Block purpleGemBlock = new BlockMod("purpleGemBlock", "Purple Gem Block");
	public static final Block blueGemBlock = new BlockMod("blueGemBlock", "Blue Gem Block");
	public static final Block yellowGemBlock = new BlockMod("yellowGemBlock", "Yellow Gem Block");
	
	public static final Block eucaGrass = new BlockModGrass(null, "eucaGrass", "Euca Grass", 2.0F);
	public static final Block eucaStone = new BlockMod("eucaStone", "Euca Stone", 2.0F);
	public static final Block eucaGoldLog = new BlockModLog("eucaGoldLog", "Golden Euca Log");
	public static final Block goldEucaPlank = new BlockMod(EnumMaterialTypes.WOOD, "goldEucaPlank", "Golden Euca Plank", 1.0F);
	public static final Block eucaGoldStairs = new BlockModStairs(eucaGoldLog, "eucaGoldStairs", "Golden Euca Stairs");
	public static final Block eucaGoldLeaves = new BlockModLeaves("eucaGoldLeaves", "Golden Euca Leaves", 1.0F);
	public static final Block eucaSilverLeaves = new BlockModLeaves("eucaSilverLeaves", "Silver Euca Leaves", 1.0F);
	public static final Block eucaSapling = new BlockEucaSapling("eucaSapling", "Euca Sapling");
	public static final Block eucaBricks = new BlockMod("eucaBricks", "Euca Bricks", 2.0F);
	public static final Block eucaTile = new BlockMod("eucaTile", "Euca Tile", 2.0F);
	
	public static final BlockMod depthsDirt = new BlockMod(EnumMaterialTypes.DIRT, "depthsDirt", "Depths Dirt", 2.0F);
	public static final Block depthsGrass = new BlockModGrass(depthsDirt, "depthsGrass", "Depths Grass", 2.0F);
	public static final Block depthsStone = new BlockMod("depthsStone", "Depths Stone", 2.0F);
	public static final Block depthsLog = new BlockModLog("depthsLog", "Depths Log");
	public static final Block depthsPlank = new BlockMod(EnumMaterialTypes.WOOD, "depthsPlank", "Depths Plank", 1.0F);
	public static final Block depthsStairs = new BlockModStairs(depthsPlank, "depthsStairs", "Depths Stairs");
	public static final Block depthsLeaves = new BlockModLeaves("depthsLeaves", "Depths Leaves", 1.0F);
	public static final Block darkBrick = new BlockMod("darkBrick", "Dark Brick", 2.0F);
	public static final Block darkFloor = new BlockModGrass(null, "darkFloor", "Dark Floor", 2.0F);

	//public static final BlockMod godDirt = new BlockMod(EnumMaterialTypes.DIRT, "godDirt", 2.0F);
	//public static final Block godGrass = new BlockModGrass(godDirt, "godGrass", 2.0F);
	//public static final Block godStone = new BlockMod("godStone", 2.0F);
	
	public static final BlockMod frozenDirt = new BlockMod(EnumMaterialTypes.DIRT, "frozenDirt", "Frozen Dirt", 2.0F);
	public static final BlockMod frozenStone = new BlockMod(EnumMaterialTypes.STONE, "frozenStone", "Frozen Stone", 5.0F);
	public static final Block frozenGrass = new BlockModGrass(frozenDirt, "frozenGrass", "Frozen Grass", 2.0F);
	public static final Block frozenLeaves = new BlockModLeaves("frozenLeaves", "Frozen Leaves", 0.5F).setFrozenPlant().setLightLevel(1);
	public static final Block frozenBark = new BlockModLog("frozenBark", "Frozen Bark");
	public static final Block frozenPlanks = new BlockMod(EnumMaterialTypes.WOOD, "frozenPlanks", "Frozen Planks", 0.5F);
	
	public static final BlockMod corbaStone = new BlockMod("corbaStone", "Corba Stone");
	public static final Block corbaGrass = new BlockModGrass((BlockMod)null, "corbaGrass", "Corba Grass", 0.5F);
	public static final Block corbaLog = new BlockModLog("corbaLog", "Corba Log");
	public static final Block corbaLeaves = new BlockModLeaves("corbaLeaves", "Corba Leaves", 0.2F);
	public static final Block corbaPillar = new BlockMod("corbaPillar", "Corba Pillar");
	public static final Block corbaPlank = new BlockMod(EnumMaterialTypes.WOOD, "corbaPlank", "Corba Plank", 0.5F);
	public static final Block blazierBricks = new BlockMod("blazierBricks", "Blazier Bricks"); 
	
	public static final BlockMod cloudiaDirt = new BlockMod(EnumMaterialTypes.DIRT, "cloudiaDirt", "Cloudia Dirt", 2.0F);
	public static final Block cloudiaGrass = new BlockModGrass(cloudiaDirt, "cloudiaGrass", "Cloudia Grass", 2.0F);
	public static final Block cloudiaLog = new BlockModLog("cloudiaLog", "Cloudia Log"); 
	public static final Block cloudiaRock = new BlockMod("cloudiaRock", "Cloudia Rock"); 
	public static final Block cloudiaBrick = new BlockMod("cloudiaBrick", "Cloudia Brick").setLightLevel(0.5F); 
	public static final Block cloudiaWall = new BlockMod("cloudiaWall", "Cloudia Wall").setLightLevel(0.5F);  
	public static final Block cloudiaTile = new BlockMod("cloudiaTile", "Cloudia Tile").setLightLevel(0.5F); 
	public static final Block cloudiaLeaves = new BlockModLeaves("cloudiaLeaves", "Cloudia Leaves", 0.5F).setLightLevel(2);
	public static final Block cloudiaLamp = new BlockMod("cloudiaLamp", "Cloudia Lamp").setLightLevel(1.0F);
	//public static final Block cloudiaPost = new BlockCloudiaPost("cloudiaPost");
	public static final Block pinkCloudiaCloud = new BlockCloud("pinkCloudiaCloud", "Pink Cloudia Cloud");
	public static final Block blueCloudiaCloud = new BlockCloud("blueCloudiaCloud", "Blue Cloudia Cloud");
	public static final Block lightBlueCloudiaCloud = new BlockCloud("lightBlueCloudiaCloud", "Light Blue Cloudia Cloud");
	
	/*public static final BlockMod wastelandsStone = new BlockWastelandsStone("wastelandsStone");
	public static final Block wastelandsGrass = new BlockModGrass((BlockMod)null, "wastelandsGrass", 2.0F);
	public static final Block wastelandsLog = new BlockModLog("wastelandsLog");
	public static final Block wastelandsBranches = new BlockModLeaves("wastelandsBranches", 2.0F).setStepSound(EnumMaterialTypes.WOOD.getSound());*/

	public static final BlockEucaPortal eucaPortal = (BlockEucaPortal)new BlockEucaPortal("eucaPortal");
	public static final Block eucaPortalFrame = new BlockMod("eucaPortalFrame", "Euca Portal Frame", 3.0F);
	public static final BlockDepthsPortal depthsPortal = (BlockDepthsPortal)new BlockDepthsPortal("depthsPortal");
	public static final Block depthsPortalFrame = new BlockMod("depthsPortalFrame", "Depths Portal Frame", 3.0F);
	public static final BlockBoilPortal boilPortal = (BlockBoilPortal)new BlockBoilPortal("boilingPortal");
	public static final Block boilPortalFrame = new BlockMod("boilingPortalFrame", "Boiling Portal Frame", 3.0F);
	public static final BlockFrozenPortal frozenPortal = (BlockFrozenPortal)new BlockFrozenPortal("frozenPortal");
	public static final Block frozenPortalFrame = new BlockMod("frozenPortalFrame", "Frozen Portal Frame", 3.0F);
	public static final BlockCorbaPortal corbaPortal = (BlockCorbaPortal)new BlockCorbaPortal("corbaPortal");
	public static final Block corbaPortalFrame = new BlockCorbaPortalFrame("corbaPortalFrame", "Corba Portal Frame");
	//public static final BlockWastelandsPortal wastelandsPortal = (BlockWastelandsPortal)new BlockWastelandsPortal("wastelandsPortal");
	//public static final Block wastelandsPortalFrame = new BlockMod("wastelandsPortalFrame");
	public static final BlockCloudiaPortal cloudiaPortal = (BlockCloudiaPortal)new BlockCloudiaPortal("cloudiaPortal");
	public static final Block cloudiaPortalFrame = new BlockMod("cloudiaPortalFrame", "Cloudia Portal Frame", 3.0F);
	
	public static final Block depthsLights = new BlockMod("depthsLight", "Depths Light").setLightLevel(1.0F);

	public static final Block hotBlock = new BlockHotBlock("hotGround", "Hot Ground");
	public static final Block ashBlock = new BlockMod("ashBlock", "Ash");
	
	public static final Block fire = new BlockModFire("fire", "Fire");
	
	public static final Block mossyEssenceStone = new BlockMod("mossyEssenceStone", "Mossy Essence Stone", 2.0F);

	public static final Block dungeonBrick = new BlockDungeonBlock("dungeonBrick", "Dungeon Brick");
	public static final Block dungeonCrackedBrick = new BlockDungeonBlock("dungeonCrackedBrick", "Dungeon Cracked Brick");
	public static final Block dungeonChisledBrick = new BlockDungeonBlock("dungeonChiseledBrick", "Dungeon Chiseled Brick");
	public static final Block dungeonBrickCarved = new BlockDungeonBlock("dungeonBrickCarved", "Dungeon Carved Brick");
	public static final Block dungeonLamp = new BlockDungeonBlock("dungeonLamp", "Dungeon Lamp", true);
	
	public static final Block dungeonBrickStairs = new BlockModStairs(dungeonBrick, "dungeonBrickStairs", "Dungeon Brick Stairs");
	public static final Block dungeonCrackedBrickStairs = new BlockModStairs(dungeonCrackedBrick, "dungeonCrackedBrickStairs", "Cracked Dungeon Brick Stairs");
	public static final Block dungeonChisledBrickStairs = new BlockModStairs(dungeonChisledBrick, "dungeonChiseledBrickStairs", "Chiseled Dungeon Brick Stairs");
	public static final Block dungeonBrickCarvedStairs = new BlockModStairs(dungeonBrickCarved, "dungeonBrickCarvedStairs", "Carved Dungeon Brick Stairs");
	public static final Block dungeonLampStairs = new BlockModStairs(dungeonLamp, "dungeonLampStairs", "Dungeon Lamp Stairs", true);

	public static final Block dungeonBrickFence = new BlockModFence(dungeonBrick, "dungeonBrickFence", "Dungeon Brick Fence");
	public static final Block dungeonCrackedBrickFence = new BlockModFence(dungeonCrackedBrick, "dungeonCrackedBrickFence", "Cracked Dungeon Brick Fence");
	public static final Block dungeonChisledBrickFence = new BlockModFence(dungeonChisledBrick, "dungeonChiseledBrickFence", "Chiseled Dungeon Brick Fence");
	public static final Block dungeonBrickCarvedFence = new BlockModFence(dungeonBrickCarved, "dungeonBrickCarvedFence", "Carved Dungeon Brick Fence");
	public static final Block cloudiaPost = new BlockModFence(pinkCloudiaCloud, "cloudiaPost", "Cloudia Post");
	public static final Block dungeonLampFence = new BlockModFence(dungeonLamp, "dungeonLampFence", "Dungeon Lamp Fence", true);
	
	public static final Block hotBrick = new BlockMod("hotBrick", "Hot Brick", 2.0F);
	public static final Block hotBrick_fence = new BlockModFence(hotBrick, "hotBrickFence", "Hot Brick Fence");
	public static final Block hotBrick_stairs = new BlockModStairs(hotBrick, "hotBrickStairs", "Hor Brick Stairs");

	public static final Block hotGlass = new BlockJoinedGlass("hotGlass", "Hot Glass");
	public static final Block smoothGlass = new BlockJoinedGlass("smoothGlass", "Smooth Glass");
	//public static final Block hotGlassPane = new BlockJoinedPane("hotGlass");
	//public static final Block smoothGlassPane = new BlockJoinedPane("smoothGlass");
	
	//public static final Block witheringBeastStatue = new BlockStatue("witheringBeastStatue", new ModelWitheringBeastStatue(), EnumSounds.WITHER);
	//public static final Block netherBeastStatue = new BlockStatue("netherBeastStatue", new ModelNetherBeastStatue(), EnumSounds.NETHER_BEAST);
	//public static final Block calciaStatue = new BlockStatue("calciaStatue", new ModelCalciaStatue(), EnumSounds.CALCIA);
	//public static final Block eudorStatue = new BlockStatue("eudorStatue", new ModelEudorStatue(), EnumSounds.CALCIA);
	//public static final Block enderChampionStatue = new BlockStatue("enderChampionStatue", new ModelEnderChampionStatue());
	//public static final Block wraithStatue = new BlockStatue("wraithStatue", new ModelWraithStatue());
	
	public static final BlockModDoor hotDoor = new BlockModDoor(EnumMaterialTypes.STONE, 5.0F, "hotDoorBlock", "Hot Door");
	
	public static final Block colouredBricks = new BlockColouredBricks();
	public static final Block miniColouredBricks = new BlockMiniColouredBricks();
	public static final Block redGlowshroomTop = new BlockGlowshroom("redGlowshroomTop", "Red Glowshroom", true);
	public static final Block redGlowshroomBottom = new BlockGlowshroom("redGlowshroomBottom", "Red Glowshroom", false);
	public static final Block greenGlowshroomTop = new BlockGlowshroom("greenGlowshroomTop", "Green Glowshroom", true);
	public static final Block greenGlowshroomBottom = new BlockGlowshroom("greenGlowshroomBottom", "Green Glowshroom", false);
	public static final Block blueGlowshroomTop = new BlockGlowshroom("blueGlowshroomTop", "Blue Glowshroom", true);
	public static final Block blueGlowshroomBottom = new BlockGlowshroom("blueGlowshroomBottom", "Blue Glowshroom", false);
		
	public static final Block workshopCarpet = new BlockMod(EnumMaterialTypes.WOOL, "workshopCarpet", "Workshop Carpet", 0.5F);
	public static final Block frozenGlass = new BlockJoinedGlass("frozenGlass", "Frozen Glass");
	//public static final Block frozenPane = new BlockJoinedPane("frozenGlass");
	public static final Block frozenLamp = new BlockMod(EnumMaterialTypes.GLASS, "frozenLamp", "Frozen Lamp", 0.5F).setLightLevel(1.0F);
	public static final Block workshopStone = new BlockMod(EnumMaterialTypes.STONE, "workshopStone", "Workshop Stone", 0.5F);
	public static final Block workshopStoneStair = new BlockModStairs(workshopStone, "workshopStairs", "Workshop Stairs");
	public static final Block workshopStoneFence = new BlockModFence(workshopStone, "workshopStoneFence", "Workshop Fence");
	public static final BlockModDoor frozenDoor = new BlockModDoor(EnumMaterialTypes.STONE, 5.0F, "frozenDoorBlock", "Workshop Fence");
	public static final Block candyCane = new BlockMod(EnumMaterialTypes.WOOD, "candyCane", "Candy Cane", 2.0F);
	public static final Block workshopSlab = new BlockHalfSlab("workshopSlab", "Workshop Slab");
	public static final Block frozenBrick = new BlockMod("frozenBricks", "Frozen Bricks");
	public static final Block icicle = new BlockIcicle("icicle", "Icicle");
	public static final BlockModFlower frostberryThorn = new BlockModFlower("frostberryThorn", "Frostberry Thorn").setContactDamage().setFrozenPlant();
	public static final BlockModFlower iceBud = new BlockModFlower("iceBud", "Ice Bud").setFrozenPlant();
	public static final BlockModFlower frozenBlooms = new BlockModFlower("frozenBlooms", "Frozen Blooms").setFrozenPlant();
	public static final BlockModFlower permaFlower = (BlockModFlower)new BlockModFlower("permaFlower", "Perma Flower").setFrozenPlant();
	public static final BlockModFlower shiverFlower = (BlockModFlower)new BlockModFlower("shiverFlower", "Shiver Flower").setFrozenPlant();
	public static final BlockModFlower iceBush = (BlockModFlower)new BlockModFlower("iceBush", "Ice Bush").setFrozenPlant();
	public static final BlockMod iceLog = new BlockIceLog();
	public static final BlockMod brittleIce = new BlockBrittleIce();
	
	public static final BlockModFlower eucaTallGrass = new BlockModFlower("eucaTallGrass", "Euca Tall Grass");
	public static final BlockModFlower eucaTallFlowers = new BlockModFlower("eucaTallFlowers", "Euca Tall Flowers");
	public static final BlockModFlower eucaBlueFlower = new BlockModFlower("eucaBlueFlower", "Euca Blue Flower");
	public static final BlockModFlower frozenFlower = new BlockModFlower("frozenFlower", "Frozen Flower");
	public static final BlockModFlower depthsFlower = new BlockModFlower("depthsFlower", "Depths Flower");
	public static final BlockModFlower depthsBlueFlower = new BlockModFlower("depthsBlueFlower", "Depths Blue Flower").setLightLevel(0.625F);
	public static final BlockModFlower corbaFlower = new BlockModFlower("corbaFlower", "Corba Flower");
	public static final BlockModFlower corbaTallGrass = new BlockModFlower("corbaTallGrass", "Corba Tall Grass");
	public static final BlockModFlower corbaSpeckledFlower = new BlockModFlower("corbaSpeckledFlower", "Speckled Flower");
	public static final BlockModFlower corbaLightPurpleFlower = new BlockModFlower("corbaLightPurpleFlower", "Light Purple Flower");
	public static final BlockModFlower corbaRedFlower = new BlockModFlower("corbaRedFlower", "Red Flower");
	public static final BlockModFlower corbaBlueFlower = new BlockModFlower("corbaBlueFlower", "Blue Flower");
	public static final BlockModFlower corbaDarkPurpleFlower = new BlockModFlower("corbaDarkPurpleFlower", "Dark Purple Flower");
	public static final BlockModFlower flameFlower = new BlockModFlower("flameFlower", "Flame Flower");
	public static final BlockModFlower infernoPlant = new BlockModFlower("infernoPlant", "Inferno Plant");
	public static final BlockModFlower burntGrass = new BlockModFlower("burntGrass", "Burnt Grass");
	
	public static final Block grindstone = new BlockGrindstone("grindstone");
	public static final Block blueGems = new BlockGemBlock("blueGems", "Red Gems", false);
	public static final Block redGems = new BlockGemBlock("redGems", "Red Gems", true);
	
	public static final Block tomatoCrop = new BlockTomatoCrop("tomatoCrop");
	public static final Block corveggieCrop = new BlockCorveggieCrop("corveggiesCrop");
	public static final Block crackenCaneCrop = new BlockCrackenCaneCrop("crackenCanesCrop");
	public static final Block crakeBulbCrop = new BlockCrakeBulbCrop("crakeBulbCrop");
	public static final Block spineberryCrop = new BlockSpineberryCrop("spineberryCrop");
	public static final Block glowaCrop = new BlockGlowaCrop("glowaCrop");
	public static final Block zatPedalsCrop = new BlockZatPedalsCrop("zatPedalsCrop");

	public static final Block blackBlock = new BlockMod(EnumMaterialTypes.STONE, "blackBlock", "Black Block", 0.5F);
	public static final Block whiteBlock = new BlockMod(EnumMaterialTypes.STONE, "whiteBlock", "White Block", 0.5F);

	public static final Block eucaPumpkin = new BlockEucaPumpkin("eucaPumpkin", "Euca Pumpkin");
	public static final Block cloud = new BlockCloud("cloud", "Cloud");
	
	public static final Block brisonBlocks = new BlockBrison();
	
	public static final Block knowledgeTable = new BlockKnowledgeTable("knowledgeTable", "Knowledge Table");
	public static final Block summoningTable = new BlockSummoningTable("summoningTable", "Summoning Table");
	public static final Block bossAltar = new BlockMod("bossAltar", "Boss Altar");
	
	public static final Block goldbotSpawner = new BlockModSpawner("goldbotSpawner", "Goldbot Spawner", "goldbot");
	public static final Block silverbotSpawner = new BlockModSpawner("silverbotSpawner", "Silverbot Spawner", "silverbot");

	//public static final Block tropicalWater = new BlockTropicalWater("tropicalWater");
	
	//public static final Block bowCraftingTable = new BlockBowCrafter("bowCraftingTable");
}