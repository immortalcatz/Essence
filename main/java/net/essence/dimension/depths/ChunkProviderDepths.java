package net.essence.dimension.depths;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.depths.gen.WorldGenDepthsTree;
import net.essence.dimension.depths.gen.WorldGenSpike;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class ChunkProviderDepths implements IChunkProvider {

	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorPerlin noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	private World worldObj;
	private WorldType field_177475_o;
	private final double[] da;
	private final float[] parabolicField;
	private Block field_177476_s;
	private double[] stoneNoise;
	private BiomeGenBase[] biomesForGeneration;
	double[] gen1;
	double[] gen2;
	double[] gen3;
	double[] gen4;

	public ChunkProviderDepths(World worldIn, long p_i45636_2_) {
		this.field_177476_s = Blocks.water;
		this.stoneNoise = new double[256];
		this.worldObj = worldIn;
		this.field_177475_o = worldIn.getWorldInfo().getTerrainType();
		this.rand = new Random(p_i45636_2_);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.da = new double[825];
		this.parabolicField = new float[25];

		for (int j = -2; j <= 2; ++j) {
			for (int k = -2; k <= 2; ++k) {
				float f = 10.0F / MathHelper.sqrt_float((float)(j * j + k * k) + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}

		NoiseGenerator[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6};
		noiseGens = TerrainGen.getModdedNoiseGenerators(worldIn, this.rand, noiseGens);
		this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
		this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
		this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
		this.noiseGen4 = (NoiseGeneratorPerlin)noiseGens[3];
		this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
		this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
	}

	public void setBlocksInChunk(int p_180518_1_, int p_180518_2_, ChunkPrimer p_180518_3_) {
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, p_180518_1_ * 4 - 2, p_180518_2_ * 4 - 2, 10, 10);
		this.generate(p_180518_1_ * 4, 0, p_180518_2_ * 4);

		for (int k = 0; k < 4; ++k) {
			int l = k * 5;
			int i1 = (k + 1) * 5;

			for (int j1 = 0; j1 < 4; ++j1) {
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;

				for (int k2 = 0; k2 < 32; ++k2) {
					double d0 = 0.125D;
					double d1 = this.da[k1 + k2];
					double d2 = this.da[l1 + k2];
					double d3 = this.da[i2 + k2];
					double d4 = this.da[j2 + k2];
					double d5 = (this.da[k1 + k2 + 1] - d1) * d0;
					double d6 = (this.da[l1 + k2 + 1] - d2) * d0;
					double d7 = (this.da[i2 + k2 + 1] - d3) * d0;
					double d8 = (this.da[j2 + k2 + 1] - d4) * d0;

					for (int l2 = 0; l2 < 8; ++l2) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int i3 = 0; i3 < 4; ++i3) {
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double d15 = d10 - d16;

							for (int j3 = 0; j3 < 4; ++j3) {
								if ((d15 += d16) > 0.0D) {
									p_180518_3_.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + j3, EssenceBlocks.depthsStone.getDefaultState());
								}
							}

							d10 += d12;
							d11 += d13;
						}

						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}

	public void func_180517_a(int p_180517_1_, int p_180517_2_, ChunkPrimer p_180517_3_, BiomeGenBase[] p_180517_4_) {
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_180517_1_, p_180517_2_, p_180517_3_, this.worldObj);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.getResult() == Result.DENY) return;
		double d0 = 0.03125D;
		this.stoneNoise = this.noiseGen4.func_151599_a(this.stoneNoise, (double)(p_180517_1_ * 16), (double)(p_180517_2_ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
		for(int k = 0; k < 16; ++k) {
			for(int l = 0; l < 16; ++l) {
				generateBiomeTerrain(this.rand, p_180517_3_, p_180517_1_ * 16 + k, p_180517_2_ * 16 + l, this.stoneNoise[l + k * 16]);
			}
		}
	}

	public final void generateBiomeTerrain(Random p_180628_2_, ChunkPrimer p_180628_3_, int p_180628_4_, int p_180628_5_, double p_180628_6_) {
		boolean flag = true;
		IBlockState iblockstate = EssenceBlocks.depthsGrass.getDefaultState();
		IBlockState iblockstate1 = EssenceBlocks.depthsGrass.getDefaultState();
		int k = -1;
		int l = (int)(p_180628_6_ / 3.0D + 3.0D + p_180628_2_.nextDouble() * 0.25D);
		int i1 = p_180628_4_ & 15;
		int j1 = p_180628_5_ & 15;

		for(int k1 = 255; k1 >= 0; --k1) {
			if (k1 <= 1) {
				for(int p = 0; p < 4; p++)
				p_180628_3_.setBlockState(j1, k1 + p, i1, EssenceBlocks.depthsDirt.getDefaultState());
				p_180628_3_.setBlockState(j1, k1 + 5, i1, EssenceBlocks.depthsGrass.getDefaultState());
				p_180628_3_.setBlockState(j1, k1, i1, Blocks.bedrock.getDefaultState());
			} else {
				IBlockState iblockstate2 = p_180628_3_.getBlockState(j1, k1, i1);

				if (iblockstate2.getBlock().getMaterial() == Material.air) {
					k = -1;
				}
				else if (iblockstate2.getBlock() == EssenceBlocks.depthsStone) {
					if (k == -1) {
						if (l <= 0) {
							iblockstate = null;
							iblockstate1 = EssenceBlocks.depthsStone.getDefaultState();
						}
						else if (k1 >= 59 && k1 <= 64) {
							iblockstate = EssenceBlocks.depthsGrass.getDefaultState();
							iblockstate1 = EssenceBlocks.depthsStone.getDefaultState();
						}

						if (k1 < 63 && (iblockstate == null || iblockstate.getBlock().getMaterial() == Material.air)) {
							iblockstate = EssenceBlocks.depthsStone.getDefaultState();
						}

						k = l;

						if (k1 >= 62) {
							p_180628_3_.setBlockState(j1, k1, i1, iblockstate);
						}
						else if (k1 < 56 - l) {
							iblockstate = null;
							iblockstate1 = EssenceBlocks.depthsStone.getDefaultState();
						}
						else {
							p_180628_3_.setBlockState(j1, k1, i1, iblockstate1);
						}
					}
					else if (k > 0) {
						--k;
						p_180628_3_.setBlockState(j1, k1, i1, iblockstate1);
					}
				}
			}
		}
	}

	@Override
	public Chunk provideChunk(int x, int z) {
		this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(x, z, chunkprimer);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		this.func_180517_a(x, z, chunkprimer, this.biomesForGeneration);
		Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
		byte[] abyte = chunk.getBiomeArray();
		for(int k = 0; k < abyte.length; ++k) abyte[k] = (byte)this.biomesForGeneration[k].biomeID;
		chunk.generateSkylightMap();
		return chunk;
	}

	private void generate(int x, int y, int z) {
		this.gen4 = this.noiseGen6.generateNoiseOctaves(this.gen4, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
		this.gen1 = this.noiseGen3.generateNoiseOctaves(this.gen1, x, y, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.gen2 = this.noiseGen1.generateNoiseOctaves(this.gen2, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.gen3 = this.noiseGen2.generateNoiseOctaves(this.gen3, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		boolean flag1 = false;
		boolean flag = false;
		int l = 0;
		int i1 = 0;
		double d4 = 8.5D;
		for(int j1 = 0; j1 < 5; ++j1) {
			for(int k1 = 0; k1 < 5; ++k1) {
				float f = 0.0F;
				float f1 = 0.0F;
				float f2 = 0.0F;
				byte b0 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
				for(int l1 = -b0; l1 <= b0; ++l1) {
					for(int i2 = -b0; i2 <= b0; ++i2) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
						float f3 = biomegenbase1.minHeight;
						float f4 = biomegenbase1.maxHeight;
						f3 = 0.0F;
						f4 = -1.0F;
						float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
						if(biomegenbase1.minHeight > biomegenbase.minHeight) f5 /= 2.0F;
						f += f4 * f5;
						f1 += f3 * f5;
						f2 += f5;
					}
				}
				f /= f2;
				f1 /= f2;
				f = f * 0.9F + 0.1F;
				f1 = (f1 * 4.0F - 1.0F) / 8.0F;
				double d12 = this.gen4[i1] / 8000.0D;
				if(d12 < 0.0D) d12 = -d12 * 0.3D;
				d12 = d12 * 3.0D - 2.0D;
				if(d12 < 0.0D) {
					d12 /= 2.0D;
					if(d12 < -1.0D) d12 = -1.0D;
					d12 /= 1.4D;
					d12 /= 2.0D;
				} else {
					if(d12 > 1.0D) d12 = 1.0D;
					d12 /= 8.0D;
				}

				++i1;
				double d13 = (double)f1;
				double d14 = (double)f;
				d13 += d12 * 0.2D;
				d13 = d13 * 8.5D / 8.0D;
				double d5 = 8.5D + d13 * 4.0D;

				for(int j2 = 0; j2 < 33; ++j2) {
					double d6 = ((double)j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
					if(d6 < 0.0D) d6 *= 4.0D;
					double d7 = this.gen2[l] / 512.0D;
					double d8 = this.gen3[l] / 512.0D;
					double d9 = (this.gen1[l] / 10.0D + 1.0D) / 2.0D;
					double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;

					if(j2 > 29) {
						double d11 = (double)((float)(j2 - 29) / 3.0F);
						d10 = d10 * (1.0D - d11) + -10.0D * d11;
					}
					this.da[l] = d10;
					++l;
				}
			}
		}
	}

	@Override
	public boolean chunkExists(int x, int z) {
		return true;
	}

	@Override
	public void populate(IChunkProvider c, int cx, int cz) {
		int x1 = cx * 16;
		int z1 = cz * 16;
		int x, y, z, i;
		x = x1 + this.rand.nextInt(16);
		z = z1 + this.rand.nextInt(16);
		Random r = rand;
		
		for(i = 0; i < 10; i++) {
			y = rand.nextInt(250);
			x = x1 + this.rand.nextInt(16);
			z = z1 + this.rand.nextInt(16);
			if(worldObj.getBlockState(new BlockPos(x, y, z)) == Blocks.air.getDefaultState() && worldObj.getBlockState(new BlockPos(x, y - 1, z)) == EssenceBlocks.depthsGrass.getDefaultState() && worldObj.getBlockState(new BlockPos(x, y + 1, z)) == Blocks.air.getDefaultState()) {
				new WorldGenSpike().generate(worldObj, rand, new BlockPos(x, y, z));
			}
		}
		
		for(i = 0; i < 25; i++) {
			y = r.nextInt(250); x = x1 + this.rand.nextInt(16); z = z1 + this.rand.nextInt(16);
			(new WorldGenMinable(EssenceBlocks.flairiumOre.getDefaultState(), 8, BlockHelper.forBlock(EssenceBlocks.depthsStone))).generate(worldObj, r, new BlockPos(x, y, z));
		}
		
		for(i = 0; i < 10; i++) {
			y = r.nextInt(250); x = x1 + this.rand.nextInt(16); z = z1 + this.rand.nextInt(16);
			(new WorldGenMinable(EssenceBlocks.depthsLights.getDefaultState(), 25, BlockHelper.forBlock(EssenceBlocks.depthsStone))).generate(worldObj, r, new BlockPos(x, y, z));
		}
		
		for(i = 0; i < 100; i++) {
			y = rand.nextInt(250);
			x = x1 + this.rand.nextInt(16);
			z = z1 + this.rand.nextInt(16);
			if(worldObj.getBlockState(new BlockPos(x, y, z)) == Blocks.air.getDefaultState() && worldObj.getBlockState(new BlockPos(x, y - 1, z)) == EssenceBlocks.depthsGrass.getDefaultState() && worldObj.getBlockState(new BlockPos(x, y + 1, z)) == Blocks.air.getDefaultState()) {
				new WorldGenDepthsTree(true).generate(worldObj, rand, new BlockPos(x, y, z));
			}
		}
	}

	@Override
	public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
		return false;
	}

	@Override
	public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
		return true;
	}

	@Override
	public void saveExtraData() {}

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
	public List func_177458_a(EnumCreatureType p_177458_1_, BlockPos p_177458_2_) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(p_177458_2_);
		return biomegenbase.getSpawnableList(p_177458_1_);
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String p_180513_2_, BlockPos p_180513_3_) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_) { }

	@Override
	public Chunk provideChunk(BlockPos blockPosIn) {
		return this.provideChunk(blockPosIn.getX() >> 4, blockPosIn.getZ() >> 4);
	}
}