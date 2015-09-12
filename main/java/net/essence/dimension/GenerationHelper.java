package net.essence.dimension;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.boil.gen.WorldGenBoilingFire;
import net.essence.dimension.boil.gen.WorldGenBoilingLava;
import net.essence.dimension.depths.gen.WorldGenDepthsTree;
import net.essence.dimension.euca.gen.WorldGenSmeltery;
import net.essence.dimension.overworld.gen.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GenerationHelper {

	private static Random r = new Random();

	public static void generateVanilla(int gen, World w, int chunkX, int chunkZ) {
		int x, y, z;
		switch(gen) {
		case 0:
			y = r.nextInt(63); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenTallGlowshrooms()).generate(w, r, new BlockPos(x, y, z));
			break;
		case 1:
			y = r.nextInt(63); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenSmallGlowshrooms()).generate(w, r, new BlockPos(x, y, z));
			break;
		case 2:
			y = r.nextInt(20); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenVanilla(EssenceBlocks.shadiumOre, 4, w, x, y, z);
			break;
		case 3:
			y = r.nextInt(25); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenVanilla(EssenceBlocks.luniumOre, 5, w, x, y, z);
			break;
		case 4:
			y = r.nextInt(20); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenVanilla(EssenceBlocks.sapphireOre, 5, w, x, y, z);
			break;
		case 5:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenNether(EssenceBlocks.hellstoneOre, 5, w, x, y, z);
			break;
		case 6:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y > 30 && y < 100) (new WorldGenBoilPortal()).generate(w, r, new BlockPos(x, y, z));
			break;
		case 7:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y > 20 && y < 110) if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.netherrack.getDefaultState()) new WorldGenNetherTower().generate(w, r, new BlockPos(x, y, z));
			break;
		case 8:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.grass.getDefaultState()) new WorldGenTowerDungeon().generate(w, r, new BlockPos(x, y, z));
			break;
		case 9:
			y = r.nextInt(70); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			//if(y < 60) new WorldGenCaveVine().generate(w, r, new BlockPos(x, y, z));
			break;
		case 10:
			y = r.nextInt(160); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y > 100 && y < 160) new WorldGenFloatingIsland().generate(w, r, new BlockPos(x, y, z));
			break;
		case 11:
			y = r.nextInt(160); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenEnd(EssenceBlocks.enderilliumOre, 5, w, x, y, z);
			break;
		case 12:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.grass.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.grass.getDefaultState() ||
					w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.sand.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.sand.getDefaultState())
				new WorldGenMageHouse().generate(w, r, new BlockPos(x, y, z));
			break;
		case 13:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.grass.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.grass.getDefaultState() ||
					w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.sand.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.sand.getDefaultState())
				new WorldGenBlacksmithHouse().generate(w, r, new BlockPos(x, y, z));
			break;
		case 14:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.grass.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.grass.getDefaultState() ||
					w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.sand.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.sand.getDefaultState())
				new WorldGenMerchant().generate(w, r, new BlockPos(x, y, z));
			break;
		}
	}

	public static void generateEssenceDimensions(int gen, World w, int chunkX, int chunkZ) {
		int x, y, z;
		switch(gen) {
		case 0:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.celestiumOre.getDefaultState(), 10, BlockHelper.forBlock(EssenceBlocks.eucaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 1:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.flairiumOre.getDefaultState(), 8, BlockHelper.forBlock(EssenceBlocks.depthsStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 2:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y, z)) != EssenceBlocks.depthsGrass || w.getBlockState(new BlockPos(x, y - 1, z)) != EssenceBlocks.depthsGrass)
				new WorldGenDepthsTree(true).generate(w, r, new BlockPos(x, y, z));
			break;
		case 3:
			y = r.nextInt(250) + 1; x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.ashualOre.getDefaultState(), 7, BlockHelper.forBlock(EssenceBlocks.ashBlock))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 4:
			y = r.nextInt(200) + 1; x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenBoilingLava(Blocks.lava)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 5:
			y = r.nextInt(200) + 1; x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenBoilingFire()).generate(w, r, new BlockPos(x, y, z));
			break;
		case 6:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenModFlower(EssenceBlocks.eucaTallGrass)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 7:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenModFlower(EssenceBlocks.eucaTallFlowers)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 8:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenModFlower(EssenceBlocks.eucaBlueFlower)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 9:
			y = r.nextInt(60); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenModFlower(EssenceBlocks.frozenFlower)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 10:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.depthsLights.getDefaultState(), 25, BlockHelper.forBlock(EssenceBlocks.depthsGrass))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 11:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.depthsLights.getDefaultState(), 25, BlockHelper.forBlock(EssenceBlocks.depthsStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 12:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenModFlower(EssenceBlocks.depthsFlower)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 13:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.gorbiteOre.getDefaultState(), 6, BlockHelper.forBlock(EssenceBlocks.corbaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 14:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.orbaditeOre.getDefaultState(), 6, BlockHelper.forBlock(EssenceBlocks.corbaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 15:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.storonOre.getDefaultState(), 10, BlockHelper.forBlock(EssenceBlocks.eucaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 16:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.koriteOre.getDefaultState(), 10, BlockHelper.forBlock(EssenceBlocks.eucaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 17:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.mekyumOre.getDefaultState(), 10, BlockHelper.forBlock(EssenceBlocks.eucaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 18:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == EssenceBlocks.eucaGrass.getDefaultState()) new WorldGenSmeltery().generate(w, r, new BlockPos(x, y, z));
			break;
		case 19:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y<64);
			(new WorldGenMinable(EssenceBlocks.pinkCloudiaCloud.getDefaultState(), 20, BlockHelper.forBlock(Blocks.air))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 20:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y<64);
			(new WorldGenMinable(EssenceBlocks.lightBlueCloudiaCloud.getDefaultState(), 20, BlockHelper.forBlock(Blocks.air))).generate(w, r, new BlockPos(x, y, z));
			break;
		}
	}

	private static void worldMinableGenVanilla(Block spawn, int vein, World w, int x, int y, int z){
		(new WorldGenMinable(spawn.getDefaultState(), vein)).generate(w, r, new BlockPos(x, y, z));
	}

	private static void worldMinableGenNether(Block spawn, int vein, World w, int x, int y, int z){
		(new WorldGenMinable(spawn.getDefaultState(), vein, BlockHelper.forBlock(Blocks.netherrack))).generate(w, r, new BlockPos(x, y, z));
	}

	private static void worldMinableGenEnd(Block spawn, int vein, World w, int x, int y, int z){
		(new WorldGenMinable(spawn.getDefaultState(), vein, BlockHelper.forBlock(Blocks.end_stone))).generate(w, r, new BlockPos(x, y, z));
	}
}