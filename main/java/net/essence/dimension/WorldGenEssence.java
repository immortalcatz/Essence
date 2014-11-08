package net.essence.dimension;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.vanilla.gen.WorldGenBoilPortal;
import net.essence.util.Config;
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
		int dim = w.provider.dimensionId;
		switch(dim) {
		case -1: generateNether(w, r, chunkX * 16, chunkZ * 16);
		case 0: generateOverworld(w, r, chunkX * 16, chunkZ * 16);
		case 1: generateEnd(w, r, chunkX * 16, chunkZ * 16);
		}
		if(dim == Config.boil) generateBoilingPoint(w, r, chunkX * 16, chunkZ * 16);
		if(dim == Config.depths) generateDepths(w, r, chunkX * 16, chunkZ * 16);
		if(dim == Config.euca) generateEuca(w, r, chunkX * 16, chunkZ * 16);
	}

	private void generateBoilingPoint(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		if(rand.nextInt(4) == 0) GenerationHelper.generateEssenceDimensions("boilLava", w, chunkX, chunkZ);
		for(i = 0; i < 15; i++) GenerationHelper.generateEssenceDimensions("boilFire", w, chunkX , chunkZ);
		for(i = 0; i < 10; i++) GenerationHelper.generateEssenceDimensions("ashualOre", w, chunkX , chunkZ);
	}

	private void generateDepths(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		for(i = 0; i < 15; i++) GenerationHelper.generateEssenceDimensions("flairiumOre", w, chunkX, chunkZ);
	}

	private void generateEuca(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		for(i = 0; i < 25; i++) GenerationHelper.generateEssenceDimensions("celestiumOre", w, chunkX, chunkZ);
	}

	private void generateNether(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		if(r.nextInt(40) == 0) GenerationHelper.generateVanilla("boilPortal", w, chunkX, chunkZ);
		for(i = 0; i < 10; i++) GenerationHelper.generateVanilla("hellstoneOre", w, chunkX, chunkZ);
	}

	private void generateOverworld(World w, Random r, int chunkX, int chunkZ) {
		int i = 0;
		for(i = 0; i < 3; i++) GenerationHelper.generateVanilla("luniumOre", w, chunkX, chunkZ);
		for(i = 0; i < 3; i++) GenerationHelper.generateVanilla("shadiumOre", w, chunkX, chunkZ);
		for(i = 0; i < 3; i++) GenerationHelper.generateVanilla("sapphireOre", w, chunkX, chunkZ);
		for(i = 0; i < 60; i++) GenerationHelper.generateVanilla("smallGlowshroom", w, chunkX, chunkZ);
		for(i = 0; i < 60; i++) GenerationHelper.generateVanilla("tallGlowshroom", w, chunkX, chunkZ);

	}

	private void generateEnd(World w, Random r, int chunkX, int chunkZ) {

	}
}