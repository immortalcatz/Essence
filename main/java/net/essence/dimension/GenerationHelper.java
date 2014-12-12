package net.essence.dimension;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.boil.gen.WorldGenBoilingFire;
import net.essence.dimension.boil.gen.WorldGenBoilingLava;
import net.essence.dimension.depths.gen.WorldGenDepthsTree;
import net.essence.dimension.euca.gen.WorldGenEucaPlant;
import net.essence.dimension.vanilla.gen.WorldGenBoilPortal;
import net.essence.dimension.vanilla.gen.WorldGenCaveVine;
import net.essence.dimension.vanilla.gen.WorldGenChristmasLights;
import net.essence.dimension.vanilla.gen.WorldGenFloatingIsland;
import net.essence.dimension.vanilla.gen.WorldGenSmallGlowshrooms;
import net.essence.dimension.vanilla.gen.WorldGenTallGlowshrooms;
import net.essence.dimension.vanilla.gen.WorldGenTowerDungeon;
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
			new WorldGenChristmasLights().generate(w, r, new BlockPos(x, y, z));
			break;
		case 8:
			y = r.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.grass.getDefaultState()) new WorldGenTowerDungeon().generate(w, r, new BlockPos(x, y, z));
			break;
		case 9:
			y = r.nextInt(70); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			new WorldGenCaveVine().generate(w, r, new BlockPos(x, y, z));
			break;

		case 10:
			y = r.nextInt(160); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(y > 100 && y < 160) new WorldGenFloatingIsland().generate(w, r, new BlockPos(x, y, z));
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
			(new WorldGenMinable(EssenceBlocks.ashual.getDefaultState(), 7, BlockHelper.forBlock(EssenceBlocks.ashBlock))).generate(w, r, new BlockPos(x, y, z));
			break;
		case 4:
			y = r.nextInt(128) + 1; x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenBoilingLava(Blocks.lava)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 5:
			y = (int)w.getHorizon(); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenBoilingFire()).generate(w, r, new BlockPos(x, y, z));
			break;
		case 6:
			y = (int)w.getHorizon(); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenEucaPlant(EssenceBlocks.eucaTallGrass)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 7:
			y = (int)w.getHorizon(); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenEucaPlant(EssenceBlocks.eucaGreenFlower)).generate(w, r, new BlockPos(x, y, z));
			break;
		case 8:
			y = (int)w.getHorizon(); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenEucaPlant(EssenceBlocks.eucaBlueFlower)).generate(w, r, new BlockPos(x, y, z));
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