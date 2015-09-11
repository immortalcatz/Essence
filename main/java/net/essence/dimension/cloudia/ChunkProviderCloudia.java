package net.essence.dimension.cloudia;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.cloudia.gen.WorldGenHut;
import net.essence.dimension.cloudia.gen.WorldGenStarlightCastle;
import net.essence.dimension.cloudia.gen.WorldGenTower;
import net.essence.dimension.euca.gen.trees.WorldGenBotSpawner;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderCloudia implements IChunkProvider {

	private Random rand;
	private World worldObj;

	public ChunkProviderCloudia(World worldIn, long seed) {
		this.worldObj = worldIn;
		this.rand = new Random(seed);
	}

	@Override
	public Chunk provideChunk(int x, int z) {
		this.rand.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public void populate(IChunkProvider c, int cx, int cz) {
		this.rand.setSeed(this.worldObj.getSeed() * (cx + cz) * this.rand.nextInt());
		int x1 = cx * 16;
		int z1 = cz * 16;
		int x, z, times;
		for(times = 0; times < 5; times++) {
		x = x1 + this.rand.nextInt(16);
		z = z1 + this.rand.nextInt(16);
		if (this.rand.nextInt(20) == 0) {
			int yCoord = rand.nextInt(128) + 1;
			new WorldGenStarlightCastle().generate(worldObj, rand, new BlockPos(x, yCoord, z));
		}
	for(times = 0; times < 1; times++) {
		x = x1 + this.rand.nextInt(16) + 8;
		z = z1 + this.rand.nextInt(16) + 8;
		int yCoord = rand.nextInt(128) + 1;
		new WorldGenTower().generate(worldObj, rand, new BlockPos(x, yCoord, z));
	}

	for(times = 0; times < 10; times++) {
		x = x1 + this.rand.nextInt(16) + 8;
		z = z1 + this.rand.nextInt(16) + 8;
		int yCoord = rand.nextInt(128) + 1;
		new WorldGenHut().generate(worldObj, rand, new BlockPos(x, yCoord, z));
			}
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