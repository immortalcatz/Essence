package net.essence.dimension;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.vanilla.gen.WorldGenBoilPortal;
import net.essence.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenEssence implements IWorldGenerator {

	private Random rand;

	public WorldGenEssence() {
		rand = new Random();
		LogHelper.info("Loading world generator");
	}

	@Override
	public void generate(Random r, int chunkX, int chunkZ, World w, IChunkProvider c, IChunkProvider c2) {
		switch(w.provider.dimensionId){
		case -1: generateNether(w, r, chunkX * 16, chunkZ * 16);
		case 0: generateOverworld(w, r, chunkX * 16, chunkZ * 16);
		case 1: generateEnd(w, r, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateNether(World w, Random r, int chunkX, int chunkZ) { 
		int x, z, y, i;
		if(r.nextInt(30) == 0){
			y = rand.nextInt(100); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			//if(y > 27) (new WorldGenBoilPortal()).generate(w, r, x, y, z);
		}
		
		for(i = 0; i < 13; i++){ 
			y = rand.nextInt(200); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.hellstoneOre, 5, Blocks.netherrack)).generate(w, rand, x, y, z);
		}
	}

	private void generateOverworld(World w, Random r, int chunkX, int chunkZ) {
		int x = chunkX + r.nextInt(16) + 8, z = chunkZ + r.nextInt(16) + 8, y, i;
		for(i = 0; i < 6; i++){
			y = rand.nextInt(25); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			(new WorldGenMinable(EssenceBlocks.luniumOre, 3)).generate(w, rand, x, y, z);
		}
		
		for(i = 0; i < 5; i++){
			y = rand.nextInt(20); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenVanilla(EssenceBlocks.shadiumOre, 3, w, x, y, z);
		}
		
		for(i = 0; i < 5; i++){
			y = rand.nextInt(20); x = chunkX + r.nextInt(16) + 8; z = chunkZ + r.nextInt(16) + 8;
			worldMinableGenVanilla(EssenceBlocks.sapphireOre, 3, w, x, y, z);
		}
	}

	private void generateEnd(World w, Random r, int chunkX, int chunkZ) {
		int x = chunkX + r.nextInt(16) + 8, z = chunkZ + r.nextInt(16) + 8, y, i;

	}

	private void worldMinableGenVanilla(Block spawn, int vein, World w, int x, int y, int z){
		(new WorldGenMinable(spawn, vein)).generate(w, rand, x, y, z);
	}

	private void worldMinableGenNether(Block spawn, int vein, World w, int x, int y, int z){
		(new WorldGenMinable(spawn, vein, Blocks.netherrack)).generate(w, rand, x, y, z);
	}

	private void worldMinableGenEnd(Block spawn, int vein, World w, int x, int y, int z){
		(new WorldGenMinable(spawn, vein, Blocks.end_stone)).generate(w, rand, x, y, z);
	}
}