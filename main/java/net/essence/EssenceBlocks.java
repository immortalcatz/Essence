package net.essence;

import net.essence.blocks.*;
import net.essence.client.render.mob.model.statue.*;
import net.essence.util.Textures;
import net.minecraft.block.*;
import net.slayer.api.*;
import net.slayer.api.block.*;

public class EssenceBlocks {

	public static final Block hellstoneOre = new BlockModOre("hellstoneOre", 3.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block celestiumOre = new BlockModOre("celestiumOre", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block luniumOre = new BlockModOre("luniumOre", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block shadiumOre = new BlockModOre("shadiumOre", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block flairiumOre = new BlockModOre("flariumOre", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block ashual = new BlockModOre("ashual", 2.0F);
	public static final Block magneticOre = new BlockModOre("magneticOre", 2.0F).setHarvestLevel(EnumToolType.DIAMOND_PICK);
	
	public static final Block hellstoneBlock = new BlockMod("hellstoneBlock", 3.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block celestiumBlock = new BlockMod("celestiumBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block luniumBlock = new BlockMod("luniumBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block shadiumBlock = new BlockMod("shadiumBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);
	public static final Block flairiumBlock = new BlockMod("flariumBlock", 2.0F).setHarvestLevel(EnumToolType.IRON_PICK);

	public static final BlockMod eucaDirt = new BlockMod(EnumMaterialTypes.DIRT, "eucaDirt", true);
	public static final Block eucaGrass = new BlockModGrass(eucaDirt, "eucaGrass", 2.0F, "eucaDirt");
	public static final Block eucaStone = new BlockMod("eucaStone", 2.0F);
	public static final Block eucaLog = new BlockModLog("eucaLog");
	public static final Block eucaPlank = new BlockMod(EnumMaterialTypes.WOOD, "eucaPlank", true);
	public static final Block eucaStairs = new BlockModStairs(eucaPlank, "eucaStairs");
	public static final Block redEucaLeaves = new BlockModLeaves("redEucaLeaves", 1.0F);
	public static final Block greenEucaLeaves = new BlockModLeaves("greenEucaLeaves", 1.0F);
	public static final Block blueEucaLeaves = new BlockModLeaves("blueEucaLeaves", 1.0F);
	public static final Block eucaSapling = new BlockEucaSapling("eucaSapling");
	
	public static final BlockMod depthsDirt = new BlockMod(EnumMaterialTypes.DIRT, "depthsDirt", true);
	public static final Block depthsGrass = new BlockModGrass(depthsDirt, "depthsGrass", 2.0F, "depthsDirt");
	public static final Block depthsStone = new BlockMod("depthsStone", 2.0F);
	public static final Block depthsLog = new BlockModLog("depthsLog");
	public static final Block depthsPlank = new BlockMod(EnumMaterialTypes.WOOD, "depthsPlank", true);
	public static final Block depthsStairs = new BlockModStairs(depthsPlank, "depthsStairs");
	public static final Block depthsLeaves = new BlockModLeaves("depthsLeaves", 1.0F);
	
	public static final BlockEucaPortal eucaPortal = (BlockEucaPortal)new BlockEucaPortal("eucaPortal");
	public static final Block eucaPortalFrame = new BlockMod("eucaPortalFrame", 3.0F);
	public static final BlockDepthsPortal depthsPortal = (BlockDepthsPortal)new BlockDepthsPortal("depthsPortal");
	public static final Block depthsPortalFrame = new BlockMod("depthsPortalFrame", 3.0F);
	public static final BlockBoilPortal boilPortal = (BlockBoilPortal)new BlockBoilPortal("boilingPortal");
	public static final Block boilPortalFrame = new BlockMod("boilingPortalFrame", 3.0F);
	
	public static final Block hotBlock = new BlockMod("hotGround", 2.0F);
	public static final Block ashBlock = new BlockMod(EnumMaterialTypes.STONE, "ash", "ashBlock");

	public static final Block fire = new BlockModFire("fire");
	public static final Block boilingFire = new BlockBoilingFire("boilingFire");

	public static final Block ultimateRail = new BlockModRail("ultimateRail", true, 6.0F);
	
	public static final Block mossyEssenceStone = new BlockMod("mossyEssenceStone", false);
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

	public static final Block dungeonBrickFence = new BlockModFence(dungeonBrick, "dungeonBrick");
	public static final Block dungeonCrackedBrickFence = new BlockModFence(dungeonCrackedBrick, "dungeonCrackedBrick");
	public static final Block dungeonChisledBrickFence = new BlockModFence(dungeonChisledBrick, "dungeonChiseledBrick");
	public static final Block dungeonBrickCarvedFence = new BlockModFence(dungeonBrickCarved, "dungeonBrickCarved");
	public static final Block dungeonLampFence = new BlockModFence(dungeonLamp, "dungeonLamp", true);
	
	public static final Block witheringBeastStatue = new BlockStatue("witheringBeastStatue", new ModelWitheringBeastStatue());
	public static final Block netherBeastStatue = new BlockStatue("netherBeastStatue", new ModelNetherBeastStatue());
	public static final Block enderChampionStatue = new BlockStatue("enderChampionStatue", new ModelEnderChampionStatue());
	public static final Block wraithStatue = new BlockStatue("wraithStatue", new ModelWraithStatue());

	public static final Block enrichedEnchantmentTable = new BlockEnrichedEnchantmentTable("enrichedEnchantmentTable");
	
	public static final Block incubatorIdle = new BlockIncubator("incubator", false);
	public static final Block incubatorActive = new BlockIncubator("incubatorActive", true);
	
	//public static final Block blockBreaker = new BlockBreaker("blockBreaker");
}