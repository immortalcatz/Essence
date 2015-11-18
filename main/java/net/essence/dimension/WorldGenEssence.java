package net.essence.dimension;

import java.util.Random;

import net.essence.util.Config;
import net.essence.util.LogHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenEssence implements IWorldGenerator {

	private Random rand;

	public WorldGenEssence() {
		rand = new Random();
		LogHelper.info("Loading world generator");
	}

	@Override
	public void generate(Random r, int chunkX, int chunkZ, World w, IChunkProvider c, IChunkProvider c2) {
		int dim = w.provider.getDimensionId();
		switch(dim) {
		case -1: generateNether(w, r, chunkX * 16, chunkZ * 16);
		case 0: generateOverworld(w, r, chunkX * 16, chunkZ * 16);
		case 1: generateEnd(w, r, chunkX * 16, chunkZ * 16);
		}
		if(dim == Config.boil) generateBoilingPoint(w, r, chunkX * 16, chunkZ * 16);
		if(dim == Config.depths) generateDepths(w, r, chunkX * 16, chunkZ * 16);
		if(dim == Config.euca) generateEuca(w, r, chunkX * 16, chunkZ * 16);
		if(dim == Config.frozen) generateFrozen(w, r, chunkX * 16, chunkZ * 16);
		if(dim == Config.corba) generateCorba(w, r, chunkX * 16, chunkZ * 16);
		if(dim == Config.cloudia) generateCloudia(w, r, chunkX * 16, chunkZ * 16);
		int i;
		for(i = 0; i < 3; i++) GenerationHelper.generateVanilla(3, w, chunkX * 16, chunkZ * 16);
		for(i = 0; i < 3; i++) GenerationHelper.generateVanilla(2, w, chunkX * 16, chunkZ * 16);
		for(i = 0; i < 3; i++) GenerationHelper.generateVanilla(4, w, chunkX * 16, chunkZ * 16);
	}
	
	private void generateCorba(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		for(i = 0; i < 10; i++) GenerationHelper.generateEssenceDimensions(13, w, chunkX, chunkZ);
		for(i = 0; i < 10; i++) GenerationHelper.generateEssenceDimensions(14, w, chunkX, chunkZ);
	}

	private void generateFrozen(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		for(i = 0; i < 25; i++) GenerationHelper.generateEssenceDimensions(9, w, chunkX, chunkZ);
	}

	private void generateBoilingPoint(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		//if(rand.nextInt(4) == 0) GenerationHelper.generateEssenceDimensions(4, w, chunkX, chunkZ);
		for(i = 0; i < 50; i++) GenerationHelper.generateEssenceDimensions(5, w, chunkX , chunkZ);
		for(i = 0; i < 40; i++) GenerationHelper.generateEssenceDimensions(3, w, chunkX , chunkZ);
	}

	private void generateDepths(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		//for(i = 0; i < 25; i++) GenerationHelper.generateEssenceDimensions(12, w, chunkX, chunkZ);
		//for(i = 0; i < 25; i++) GenerationHelper.generateEssenceDimensions(2, w, chunkX, chunkZ);
		//for(i = 0; i < 5; i++) GenerationHelper.generateEssenceDimensions(10, w, chunkX, chunkZ);
	}

	private void generateEuca(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		for(i = 0; i < 30; i++) GenerationHelper.generateEssenceDimensions(0, w, chunkX, chunkZ);
		for(i = 0; i < 30; i++) GenerationHelper.generateEssenceDimensions(15, w, chunkX, chunkZ);
		for(i = 0; i < 30; i++) GenerationHelper.generateEssenceDimensions(16, w, chunkX, chunkZ);
		for(i = 0; i < 30; i++) GenerationHelper.generateEssenceDimensions(17, w, chunkX, chunkZ);
		for(i = 0; i < 70; i++) GenerationHelper.generateEssenceDimensions(6, w, chunkX, chunkZ);
		for(i = 0; i < 15; i++) GenerationHelper.generateEssenceDimensions(7, w, chunkX, chunkZ);
		for(i = 0; i < 15; i++) GenerationHelper.generateEssenceDimensions(8, w, chunkX, chunkZ);
	}
	
	private void generateCloudia(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		for(i = 0; i < 15; i++) GenerationHelper.generateEssenceDimensions(19, w, chunkX, chunkZ);
		for(i = 0; i < 3; i++) GenerationHelper.generateEssenceDimensions(20, w, chunkX, chunkZ);
	}

	private void generateNether(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		if(r.nextInt(40) == 0) GenerationHelper.generateVanilla(6, w, chunkX, chunkZ);
		for(i = 0; i < 15; i++) GenerationHelper.generateVanilla(5, w, chunkX, chunkZ);
		if(rand.nextInt(50) == 0) GenerationHelper.generateVanilla(7, w, chunkX, chunkZ);
	}

	private void generateOverworld(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		for(i = 0; i < 100; i++) GenerationHelper.generateVanilla(1, w, chunkX, chunkZ);
		for(i = 0; i < 100; i++) GenerationHelper.generateVanilla(0, w, chunkX, chunkZ);
		if(rand.nextInt(5) == 0) GenerationHelper.generateVanilla(8, w, chunkX, chunkZ);
		//for(i = 0; i < 50; i++) GenerationHelper.generateVanilla(9, w, chunkX, chunkZ);
		//if(rand.nextInt(200) == 0) GenerationHelper.generateVanilla(10, w, chunkX, chunkZ);
		if(rand.nextInt(8) == 0) GenerationHelper.generateVanilla(12, w, chunkX, chunkZ);
		if(rand.nextInt(8) == 0) GenerationHelper.generateVanilla(13, w, chunkX, chunkZ);
		if(rand.nextInt(8) == 0) GenerationHelper.generateVanilla(14, w, chunkX, chunkZ);
	}

	private void generateEnd(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		for(i = 0; i < 15; i++) GenerationHelper.generateVanilla(11, w, chunkX, chunkZ);
	}
}