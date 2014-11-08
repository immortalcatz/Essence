package net.essence.dimension;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.boil.gen.WorldGenBoilingFire;
import net.essence.dimension.boil.gen.WorldGenBoilingLava;
import net.essence.dimension.depths.gen.WorldGenDepthsTree;
import net.essence.dimension.vanilla.gen.WorldGenBoilPortal;
import net.essence.dimension.vanilla.gen.WorldGenSmallGlowshrooms;
import net.essence.dimension.vanilla.gen.WorldGenTallGlowshrooms;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GenerationHelper {

	private static Random r = new Random();
	
	public static void generateVanilla(int gen, World w, int chunkX, int chunkZ) {
		int x, y, z;
		switch(gen) {
		case 0:
			y = r.nextInt(63); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenTallGlowshrooms()).generate(w, r, x, y, z);
			break;
		case 1:
			y = r.nextInt(63); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenSmallGlowshrooms()).generate(w, r, x, y, z);
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
			if(y > 30 && y < 100) (new WorldGenBoilPortal()).generate(w, r, x, y, z);
			break;
		}
	}
	
	public static void generateEssenceDimensions(int gen, World w, int chunkX, int chunkZ) {
		int x, y, z;
		switch(gen) {
		case 0:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.celestiumOre, 10, EssenceBlocks.eucaStone)).generate(w, r, x, y, z);
			break;
		case 1:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.flairiumOre, 8, EssenceBlocks.depthsStone)).generate(w, r, x, y, z);
			break;
		case 2:
			y = r.nextInt(250); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			if(w.getBlock(x, y, z) != EssenceBlocks.depthsGrass || w.getBlock(x, y - 1, z) != EssenceBlocks.depthsGrass)
				new WorldGenDepthsTree(true).generate(w, r, x, y, z);
			break;
		case 3:
			y = r.nextInt(250) + 1; x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.ashual, 7, EssenceBlocks.ashBlock)).generate(w, r, x, y, z);
			break;
		case 4:
			y = r.nextInt(128) + 1; x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenBoilingLava(Blocks.lava)).generate(w, r, x, y, z);
			break;
		case 5:
			y = w.getHeightValue(chunkX + r.nextInt(16) + 8, chunkZ + r.nextInt(16) + 8); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenBoilingFire()).generate(w, r, x, y, z);
			break;
		}
	}
	
	private static void worldMinableGenVanilla(Block spawn, int vein, World w, int x, int y, int z){
		(new WorldGenMinable(spawn, vein)).generate(w, r, x, y, z);
	}

	private static void worldMinableGenNether(Block spawn, int vein, World w, int x, int y, int z){
		(new WorldGenMinable(spawn, vein, Blocks.netherrack)).generate(w, r, x, y, z);
	}

	private static void worldMinableGenEnd(Block spawn, int vein, World w, int x, int y, int z){
		(new WorldGenMinable(spawn, vein, Blocks.end_stone)).generate(w, r, x, y, z);
	}
}