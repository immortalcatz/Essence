package net.essence.dimension.cloudia;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.cloudia.gen.WorldGenCloudiaLamp;
import net.essence.dimension.cloudia.gen.WorldGenHut;
import net.essence.dimension.cloudia.gen.WorldGenIsland;
import net.essence.dimension.cloudia.gen.WorldGenStarlightCastle;
import net.essence.dimension.cloudia.gen.WorldGenStarlightTree;
import net.essence.dimension.cloudia.gen.WorldGenTower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ChunkProviderCloudia implements IChunkProvider {

	private Random rand;
	private World worldObj;
	private BiomeGenBase[] biomesForGeneration;
	public ChunkProviderCloudia(World worldIn, long seed) {
		this.worldObj = worldIn;
		this.rand = new Random(seed);
		new NoiseGeneratorOctaves(this.rand, 4);
		new NoiseGeneratorOctaves(this.rand, 4);
	}

	@Override
	public Chunk provideChunk(int cx, int cz) {
		this.rand.setSeed((long)cx * 391279512714L + (long)cz * 132894987741L);
		ChunkPrimer primer = new ChunkPrimer();
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, cx* 16, cz* 16, 16, 16);
		Chunk chunk = new Chunk(this.worldObj, primer, cx, cz);
		byte[] abyte = chunk.getBiomeArray();
		for(int k = 0; k < abyte.length; ++k) abyte[k] = (byte)this.biomesForGeneration[k].biomeID;
		chunk.generateSkylightMap();
		return chunk;
	}

	private static WorldGenerator castle = new WorldGenStarlightCastle();
	private static WorldGenerator tower = new WorldGenTower();
	private static WorldGenerator hut = new WorldGenHut();
	private static WorldGenerator lamp = new WorldGenCloudiaLamp();
	private static WorldGenerator tree = new WorldGenStarlightTree();
	private static WorldGenerator island = new WorldGenIsland();
	
	@Override
	public void populate(IChunkProvider c, int cx, int cz) {
		this.rand.setSeed(this.worldObj.getSeed() * (cx + cz) * this.rand.nextInt());
		int x1 = cx * 16;
		int z1 = cz * 16;
		int x, z;
		x = x1 + this.rand.nextInt(16);
		z = z1 + this.rand.nextInt(16);
		
		if (this.rand.nextInt(15) == 0) {
			int yCoord = rand.nextInt(20) + 64;
			if(worldObj.isAirBlock(new BlockPos(x, yCoord, z)))castle.generate(worldObj, rand, new BlockPos(x, yCoord, z));
		}
		if (this.rand.nextInt(15) == 0) {
			x = x1 + this.rand.nextInt(16) + 8;
			z = z1 + this.rand.nextInt(16) + 8;
			int yCoord = rand.nextInt(20) + 64;
			if(worldObj.isAirBlock(new BlockPos(x, yCoord, z)))tower.generate(worldObj, rand, new BlockPos(x, yCoord, z));
		}

		if (this.rand.nextInt(15) == 0) {
			x = x1 + this.rand.nextInt(16) + 8;
			z = z1 + this.rand.nextInt(16) + 8;
			int yCoord = rand.nextInt(20) + 64;
			if(worldObj.isAirBlock(new BlockPos(x, yCoord, z)))hut.generate(worldObj, rand, new BlockPos(x, yCoord, z));
		}

		if (this.rand.nextInt(15) == 0) {
			x = x1 + this.rand.nextInt(16) + 8;
			z = z1 + this.rand.nextInt(16) + 8;
			int yCoord = rand.nextInt(20) + 64;
			if(worldObj.isAirBlock(new BlockPos(x, yCoord, z)))lamp.generate(worldObj, rand, new BlockPos(x, yCoord, z));
		}
		
		if (this.rand.nextInt(15) == 0) {
			x = x1 + this.rand.nextInt(16) + 8;
			z = z1 + this.rand.nextInt(16) + 8;
			int yCoord = rand.nextInt(20) + 64;
			if(worldObj.isAirBlock(new BlockPos(x, yCoord, z)))tree.generate(worldObj, rand, new BlockPos(x, yCoord, z));
		}
		
		if (this.rand.nextInt(15) == 0) {
			x = x1 + this.rand.nextInt(16) + 8;
			z = z1 + this.rand.nextInt(16) + 8;
			int yCoord = rand.nextInt(20) + 64;
			if(worldObj.isAirBlock(new BlockPos(x, yCoord, z)))island.generate(worldObj, rand, new BlockPos(x, yCoord, z));
		}
	}

	@Override
	public boolean chunkExists(int x, int z) {
		return true;
	}

	@Override
	public boolean func_177460_a(IChunkProvider ic, Chunk c, int x, int z) {
		return false;
	}

	@Override
	public boolean saveChunks(boolean b, IProgressUpdate i) {
		return true;
	}

	@Override
	public void saveExtraData() {
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "RandomLevelSource";
	}

	@Override
	public List<?> func_177458_a(EnumCreatureType t, BlockPos p) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(p);
		return biomegenbase.getSpawnableList(t);
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String s, BlockPos p) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(Chunk c, int x, int z) {
	}

	@Override
	public Chunk provideChunk(BlockPos blockPosIn) {
		return this.provideChunk(blockPosIn.getX() >> 4, blockPosIn.getZ() >> 4);
	}
}