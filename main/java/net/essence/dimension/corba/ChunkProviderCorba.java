package net.essence.dimension.corba;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class ChunkProviderCorba implements IChunkProvider {

	private Random corbaRNG;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	public NoiseGeneratorOctaves noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	private World corbaWorld;
	private double[] densities;
	private BiomeGenBase[] biomesForGeneration;
	double[] noiseData1;
	double[] noiseData2;
	double[] noiseData3;
	double[] noiseData4;
	double[] noiseData5;

	public ChunkProviderCorba(World worldIn, long p_i2007_2_) {
		this.corbaWorld = worldIn;
		this.corbaRNG = new Random(p_i2007_2_);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.corbaRNG, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.corbaRNG, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.corbaRNG, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.corbaRNG, 10);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.corbaRNG, 16);
		NoiseGenerator[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5};
		noiseGens = TerrainGen.getModdedNoiseGenerators(worldIn, this.corbaRNG, noiseGens);
		this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
		this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
		this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
		this.noiseGen4 = (NoiseGeneratorOctaves)noiseGens[3];
		this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
	}

	public void func_180520_a(int p_180520_1_, int p_180520_2_, ChunkPrimer p_180520_3_) {
		byte b0 = 2;
		int k = b0 + 1;
		byte b1 = 33;
		int l = b0 + 1;
		this.densities = this.initializeNoiseField(this.densities, p_180520_1_ * b0, 0, p_180520_2_ * b0, k, b1, l);

		for (int i1 = 0; i1 < b0; ++i1) {
			for (int j1 = 0; j1 < b0; ++j1) {
				for (int k1 = 0; k1 < 32; ++k1) {
					double d0 = 0.25D;
					double d1 = this.densities[((i1 + 0) * l + j1 + 0) * b1 + k1 + 0];
					double d2 = this.densities[((i1 + 0) * l + j1 + 1) * b1 + k1 + 0];
					double d3 = this.densities[((i1 + 1) * l + j1 + 0) * b1 + k1 + 0];
					double d4 = this.densities[((i1 + 1) * l + j1 + 1) * b1 + k1 + 0];
					double d5 = (this.densities[((i1 + 0) * l + j1 + 0) * b1 + k1 + 1] - d1) * d0;
					double d6 = (this.densities[((i1 + 0) * l + j1 + 1) * b1 + k1 + 1] - d2) * d0;
					double d7 = (this.densities[((i1 + 1) * l + j1 + 0) * b1 + k1 + 1] - d3) * d0;
					double d8 = (this.densities[((i1 + 1) * l + j1 + 1) * b1 + k1 + 1] - d4) * d0;

					for (int l1 = 0; l1 < 4; ++l1) {
						double d9 = 0.125D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						for(int i2 = 0; i2 < 8; ++i2) {
							double d14 = 0.125D;
							double d15 = d10;
							double d16 = (d11 - d10) * d14;
							for (int j2 = 0; j2 < 8; ++j2) {
								IBlockState iblockstate = null;
								if(d15 > 0.0D) iblockstate = EssenceBlocks.corbaStone.getDefaultState();
								int k2 = i2 + i1 * 8;
								int l2 = l1 + k1 * 4;
								int i3 = j2 + j1 * 8;
								p_180520_3_.setBlockState(k2, l2, i3, iblockstate);
								d15 += d16;
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

	public void func_180519_a(ChunkPrimer p_180519_1_) {
		for (int i = 0; i < 16; ++i) {
			for (int j = 0; j < 16; ++j) {
				byte b0 = 1;
				int k = -1;
				IBlockState iblockstate = EssenceBlocks.corbaStone.getDefaultState();
				IBlockState iblockstate1 = EssenceBlocks.corbaStone.getDefaultState();

				for (int l = 300; l >= 0; --l) {
					IBlockState iblockstate2 = p_180519_1_.getBlockState(i, l, j);

					if (iblockstate2.getBlock().getMaterial() == Material.air) {
						k = -1;
					}
					else if (iblockstate2.getBlock() == EssenceBlocks.corbaStone) {
						if (k == -1) {
							if (b0 <= 0) {
								iblockstate = Blocks.air.getDefaultState();
								iblockstate1 = EssenceBlocks.corbaStone.getDefaultState();
							}
							k = b0;
							if (l >= 0) {
								p_180519_1_.setBlockState(i, l, j, iblockstate);
							} else {
								p_180519_1_.setBlockState(i, l + 1, j, EssenceBlocks.corbaGrass.getDefaultState());
								p_180519_1_.setBlockState(i, l, j, iblockstate1);
							}
						}
						else if (k > 0) {
							--k;
							p_180519_1_.setBlockState(i, l + 1, j, EssenceBlocks.corbaGrass.getDefaultState());
							p_180519_1_.setBlockState(i, l, j, iblockstate1);
						}
					}
				}
			}
		}
	}

	private int chunkX = 0, chunkZ = 0;

	public Chunk provideChunk(int x, int z) {
		this.corbaRNG.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.biomesForGeneration = this.corbaWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		this.func_180520_a(x, z, chunkprimer);
		this.func_180519_a(chunkprimer);
		Chunk chunk = new Chunk(this.corbaWorld, chunkprimer, x, z);
		byte[] abyte = chunk.getBiomeArray();
		for(int k = 0; k < abyte.length; ++k) abyte[k] = (byte)this.biomesForGeneration[k].biomeID;
		chunk.generateSkylightMap();
		return chunk;
	}

	private double[] initializeNoiseField(double[] p_73187_1_, int p_73187_2_, int p_73187_3_, int p_73187_4_, int p_73187_5_, int p_73187_6_, int p_73187_7_) {
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, p_73187_1_, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return event.noisefield;

		if (p_73187_1_ == null) {
			p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];
		}

		double d0 = 684.412D;
		double d1 = 684.412D;
		this.noiseData4 = this.noiseGen4.generateNoiseOctaves(this.noiseData4, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 1.121D, 1.121D, 0.5D);
		this.noiseData5 = this.noiseGen5.generateNoiseOctaves(this.noiseData5, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 200.0D, 200.0D, 0.5D);
		d0 *= 2.0D;
		this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
		this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
		this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
		int k1 = 0;

		for (int l1 = 0; l1 < p_73187_5_; ++l1) {
			for (int i2 = 0; i2 < p_73187_7_; ++i2) {
				float f = (float)(l1 + p_73187_2_) / 1.0F;
				float f1 = (float)(i2 + p_73187_4_) / 1.0F;
				float f2 = 100.0F - MathHelper.sqrt_float(f * f + f1 * f1) * 8.0F;

				if (f2 > 80.0F) {
					f2 = 80.0F;
				}

				if (f2 < -100.0F) {
					f2 = -100.0F;
				}

				for (int j2 = 0; j2 < p_73187_6_; ++j2) {
					double d2 = 0.0D;
					double d3 = this.noiseData2[k1] / 512.0D;
					double d4 = this.noiseData3[k1] / 512.0D;
					double d5 = (this.noiseData1[k1] / 10.0D + 1.0D) / 2.0D;

					if (d5 < 0.0D) {
						d2 = d3;
					}
					else if (d5 > 1.0D) {
						d2 = d4;
					} else {
						d2 = d3 + (d4 - d3) * d5;
					}

					d2 -= 8.0D;
					d2 += (double)f2;
					byte b0 = 2;
					double d6;

					if (j2 > p_73187_6_ / 2 - b0) {
						d6 = (double)((float)(j2 - (p_73187_6_ / 2 - b0)) / 64.0F);
						d6 = MathHelper.clamp_double(d6, 0.0D, 1.0D);
						d2 = d2 * (1.0D - d6) + -3000.0D * d6;
					}

					b0 = 8;

					if (j2 < b0) {
						d6 = (double)((float)(b0 - j2) / ((float)b0 - 1.0F));
						d2 = d2 * (1.0D - d6) + -30.0D * d6;
					}

					p_73187_1_[k1] = d2;
					++k1;
				}
			}
		}

		return p_73187_1_;
	}

	@Override
	public boolean chunkExists(int x, int z) {
		return true;
	}

	@Override
	public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
		//this.corbaWorld.getBiomeGenForCoords(blockpos.add(16, 0, 16)).decorate(this.corbaWorld, this.corbaWorld.rand, blockpos);
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
		return this.corbaWorld.getBiomeGenForCoords(p_177458_2_).getSpawnableList(p_177458_1_);
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
	public void recreateStructures(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_) {}

	@Override
	public Chunk provideChunk(BlockPos blockPosIn) {
		return this.provideChunk(blockPosIn.getX() >> 4, blockPosIn.getZ() >> 4);
	}
}