package net.journey.dimension;

import java.util.Random;

import net.journey.JourneyBlocks;
import net.journey.dimension.boil.gen.WorldGenBoilingFire;
import net.journey.dimension.boil.gen.WorldGenBoilingLava;
import net.journey.dimension.depths.gen.WorldGenDepthsTree;
import net.journey.dimension.euca.gen.WorldGenSmeltery;
import net.journey.dimension.nether.gen.WorldGenBoilPortal;
import net.journey.dimension.nether.gen.WorldGenHellThorn;
import net.journey.dimension.nether.gen.WorldGenNetherTower;
import net.journey.dimension.overworld.gen.*;
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
			(new WorldGenHellThorn()).generate(w, r, new BlockPos(x, y, z));
			break;
		case 2:
			y = r.nextInt(63); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenSmallGlowshrooms()).generate(w, r, new BlockPos(x, y, z));
			break;
		case 3:
			y = r.nextInt(20); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenVanilla(JourneyBlocks.shadiumOre, 4, w, x, y, z);
			break;
		case 4:
			y = r.nextInt(25); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenVanilla(JourneyBlocks.luniumOre, 5, w, x, y, z);
			break;
		case 5:
			y = r.nextInt(20); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenVanilla(JourneyBlocks.sapphireOre, 5, w, x, y, z);
			break;
		case 6:
			y = r.nextInt(512); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenNether(JourneyBlocks.hellstoneOre, 5, w, x, y, z);
			break;
		case 7:
			y = r.nextInt(512); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenNether(JourneyBlocks.lavaRock, 5, w, x, y, z);
			break;
		case 8:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y > 30 && y < 100) (new WorldGenBoilPortal()).generate(w, r, new BlockPos(x, y, z));
			break;
		case 9:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y > 20 && y < 110) if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.netherrack.getDefaultState()) new WorldGenNetherTower().generate(w, r, new BlockPos(x, y, z));
			break;
		case 10:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.grass.getDefaultState()) new WorldGenTowerDungeon().generate(w, r, new BlockPos(x, y, z));
			break;
		case 11:
			y = r.nextInt(70); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			//if(y < 60) new WorldGenCaveVine().generate(w, r, new BlockPos(x, y, z));
			break;
		//case 11:
			//y = r.nextInt(160); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			//if(y > 100 && y < 160) new WorldGenFloatingIsland().generate(w, r, new BlockPos(x, y, z));
			//break;
		case 12:
			y = r.nextInt(160); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenEnd(JourneyBlocks.enderilliumOre, 5, w, x, y, z);
			break;
		case 13:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.grass.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.grass.getDefaultState() ||
					w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.sand.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.sand.getDefaultState())
				new WorldGenMageHouse().generate(w, r, new BlockPos(x, y, z));
			break;
		case 14:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.grass.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.grass.getDefaultState() ||
					w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.sand.getDefaultState() || w.getBlockState(new BlockPos(x, y, z)) == Blocks.sand.getDefaultState())
				new WorldGenBlacksmithHouse().generate(w, r, new BlockPos(x, y, z));
			break;
		case 15:
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
			(new WorldGenMinable(JourneyBlocks.celestiumOre.getDefaultState(), 10, BlockHelper.forBlock(JourneyBlocks.eucaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 1:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(JourneyBlocks.flairiumOre.getDefaultState(), 8, BlockHelper.forBlock(JourneyBlocks.depthsStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 2:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y, z)) != JourneyBlocks.depthsGrass || w.getBlockState(new BlockPos(x, y - 1, z)) != JourneyBlocks.depthsGrass)
				new WorldGenDepthsTree(true).generate(w, r, new BlockPos(x, y, z));
			break;
		case 3:
			y = r.nextInt(250) + 1; x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(JourneyBlocks.ashualOre.getDefaultState(), 7, BlockHelper.forBlock(JourneyBlocks.ashBlock))).generate(w, r, new BlockPos(x, y, z));
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
			(new WorldGenModFlower(JourneyBlocks.eucaTallGrass)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 7:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenModFlower(JourneyBlocks.eucaTallFlowers)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 8:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenModFlower(JourneyBlocks.eucaBlueFlower)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 9:
			y = r.nextInt(60); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenModFlower(JourneyBlocks.frozenFlower)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 10:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(JourneyBlocks.depthsLights.getDefaultState(), 25, BlockHelper.forBlock(JourneyBlocks.depthsGrass))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 11:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(JourneyBlocks.depthsLights.getDefaultState(), 25, BlockHelper.forBlock(JourneyBlocks.depthsStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 12:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenModFlower(JourneyBlocks.depthsFlower)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 13:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(JourneyBlocks.gorbiteOre.getDefaultState(), 6, BlockHelper.forBlock(JourneyBlocks.corbaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 14:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(JourneyBlocks.orbaditeOre.getDefaultState(), 6, BlockHelper.forBlock(JourneyBlocks.corbaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 15:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(JourneyBlocks.storonOre.getDefaultState(), 10, BlockHelper.forBlock(JourneyBlocks.eucaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 16:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(JourneyBlocks.koriteOre.getDefaultState(), 10, BlockHelper.forBlock(JourneyBlocks.eucaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 17:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(JourneyBlocks.mekyumOre.getDefaultState(), 10, BlockHelper.forBlock(JourneyBlocks.eucaStone))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 18:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == JourneyBlocks.eucaGrass.getDefaultState()) new WorldGenSmeltery().generate(w, r, new BlockPos(x, y, z));
			break;
		case 19:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y < 64 && y > 30)
			(new WorldGenMinable(JourneyBlocks.pinkCloudiaCloud.getDefaultState(), 40, BlockHelper.forBlock(Blocks.air))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 20:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y > 99 && y < 130)
			(new WorldGenMinable(JourneyBlocks.pinkCloudiaCloud.getDefaultState(), 40, BlockHelper.forBlock(Blocks.air))).generate(w, r, new BlockPos(x, y, z));
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