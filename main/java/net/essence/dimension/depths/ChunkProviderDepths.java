package net.essence.dimension.depths;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
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
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ChunkProviderDepths implements IChunkProvider {

	private Random rand;
	private NoiseGeneratorOctaves noiseGen1, noiseGen2, noiseGen3, field_909_n, noiseGen4, noiseGen5, noiseGen6;
	private World worldObj;
	private double[] noiseArray, stoneNoise = new double[256];
	private BiomeGenBase[] biomesForGeneration;
	private double[] noise3, noise1, noise2, noise5, noise6;
	private NoiseGeneratorPerlin field_147430_m;
	private int[][] field_914_i = new int[32][32];
	private double[] generatedTemperatures;

	public ChunkProviderDepths(World var1, long var2){
		this.worldObj = var1;
		this.rand = new Random(var2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_909_n = new NoiseGeneratorOctaves(this.rand, 4);
		this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
	}

	@Override
	public boolean chunkExists(int i, int j) {
		return true;
	}

	@Override
	public Chunk provideChunk(int par1, int par2) {
		this.rand.setSeed((long)par1 * 391279128714L + (long)par2 * 132894987741L);
		ChunkPrimer primer = new ChunkPrimer();
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		this.generateTerrain(par1, par2, primer);
		this.replaceBlocksForBiome(primer);
		Chunk chunk = new Chunk(this.worldObj, primer, par1, par2);
		byte[] abyte = chunk.getBiomeArray();
		for(int k = 0; k < abyte.length; ++k)
			abyte[k] = (byte)this.biomesForGeneration[k].biomeID;
		chunk.generateSkylightMap();
		return chunk;
	}

	public void generateTerrain(int var1, int var2, ChunkPrimer primer) {
		byte b0 = 2;
		int k = b0 + 1;
		byte b1 = 33;
		int l = b0 + 1;
		this.noiseArray = this.initializeNoiseField(this.noiseArray, var1 * b0, 0, var2 * b0, k, b1, l);

		for (int i1 = 0; i1 < b0; ++i1) {
			for (int j1 = 0; j1 < b0; ++j1) {
				for (int k1 = 0; k1 < 32; ++k1) {
					double d0 = 0.25D;
					double d1 = this.noiseArray[((i1 + 0) * l + j1 + 0) * b1 + k1 + 0];
					double d2 = this.noiseArray[((i1 + 0) * l + j1 + 1) * b1 + k1 + 0];
					double d3 = this.noiseArray[((i1 + 1) * l + j1 + 0) * b1 + k1 + 0];
					double d4 = this.noiseArray[((i1 + 1) * l + j1 + 1) * b1 + k1 + 0];
					double d5 = (this.noiseArray[((i1 + 0) * l + j1 + 0) * b1 + k1 + 1] - d1) * d0;
					double d6 = (this.noiseArray[((i1 + 0) * l + j1 + 1) * b1 + k1 + 1] - d2) * d0;
					double d7 = (this.noiseArray[((i1 + 1) * l + j1 + 0) * b1 + k1 + 1] - d3) * d0;
					double d8 = (this.noiseArray[((i1 + 1) * l + j1 + 1) * b1 + k1 + 1] - d4) * d0;

					for (int l1 = 0; l1 < 4; ++l1) {
						double d9 = 0.125D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int i2 = 0; i2 < 8; ++i2) {
							double d14 = 0.125D;
							double d15 = d10;
							double d16 = (d11 - d10) * d14;

							for (int j2 = 0; j2 < 8; ++j2) {
								IBlockState iblockstate = null;

								if (d15 > 0.0D) {
									iblockstate = EssenceBlocks.depthsStone.getDefaultState();
								}

								int k2 = i2 + i1 * 8;
								int l2 = l1 + k1 * 4;
								int i3 = j2 + j1 * 8;
								primer.setBlockState(k2, l2, i3, iblockstate);
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

	public final void replaceBlocksForBiome(ChunkPrimer c) {
		for (int i = 0; i < 16; ++i) {
			for (int j = 0; j < 16; ++j) {
				byte b0 = 1;
				int k = -1;
				IBlockState iblockstate = EssenceBlocks.depthsGrass.getDefaultState();
				IBlockState iblockstate1 = EssenceBlocks.depthsDirt.getDefaultState();

				for (int l = 127; l >= 0; --l) {
					IBlockState iblockstate2 = c.getBlockState(i, l, j);

					if (iblockstate2.getBlock().getMaterial() == Material.air) {
						k = -1;
					}
					else if (iblockstate2.getBlock() == EssenceBlocks.depthsStone) {
						if (k == -1) {
							if (b0 <= 0) {
								iblockstate = Blocks.air.getDefaultState();
								iblockstate1 = EssenceBlocks.depthsGrass.getDefaultState();
							}

							k = b0;

							if (l >= 0) {
								c.setBlockState(i, l, j, iblockstate);
							} else {
								c.setBlockState(i, l, j, iblockstate1);
								c.setBlockState(i, l - 1, j, iblockstate1);
								c.setBlockState(i, l - 2, j, iblockstate1);
							}
						}
						else if (k > 0) {
							--k;
							c.setBlockState(i, l, j, iblockstate1);
							c.setBlockState(i, l - 1, j, iblockstate1);
							c.setBlockState(i, l - 2, j, iblockstate1);
						}
					}
				}
			}
		}
	}
	
	private double[] initializeNoiseField(double[] d, int x, int y, int z, int i, int j, int k) {
		if(d == null) d = new double[i * j * k];
		double i1 = 684.412D;
		double j1 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, x, z, i, k, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, x, z, i, k, 200.0D, 200.0D, 0.5D);
		i1 *= 2.0D;
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, x, y, z, i, j, k, i1 / 80.0D, i1 / 160.0D, i1 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, x, y, z, i, j, k, i1, j1, i1);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, x, y, z, i, j, k, i1, j1, i1);
		int i2 = 0;
		int j2 = 0;
		int i3 = 16 / i;

		for(int k1 = 0; k1 < i; ++k1) {
			int k2 = k1 * i3 + i3 / 2;

			for(int k3 = 0; k3 < k; ++k3) {
				int i4 = k3 * i3 + i3 / 2;
				double j4 = (this.noise5[j2] + 256.0D) / 512.0D;
				double k5 = this.noise6[j2] / 8000.0D;

				if(k5 < 0.0D) {
					k5 = -k5 * 0.3D;
				}

				k5 = k5 * 3.0D - 2.0D;

				if(k5 > 1.0D) {
					k5 = 1.0D;
				}

				k5 /= 8.0D;
				k5 = 0.0D;

				if(j4 < 0.0D) {
					j4 = 0.0D;
				}

				j4 += 0.5D;
				k5 = k5 * j / 16.0D;
				++j2;
				double j5 = j / 2.0D;

				for(int i5 = 0; i5 < j; ++i5) {
					double l = 0.0D;
					double l1 = (i5 - j5) * 8.0D / j4;

					if(l1 < 0.0D) {
						l1 *= -1.0D;
					}

					double l2 = this.noise1[i2] / 512.0D;
					double l3 = this.noise2[i2] / 512.0D;
					double l4 = (this.noise3[i2] / 10.0D + 1.0D) / 2.0D;

					if(l4 < 0.0D) {
						l = l2;
					}
					else if(l4 > 1.0D) {
						l = l3;
					} else {
						l = l2 + (l3 - l2) * l4;
					}

					l -= 8.0D;
					byte l5 = 32;
					double l6;

					if(i5 > j - l5) {
						l6 = (i5 - (j - l5)) / (l5 - 1.0F);
						l = l * (1.0D - l6) + -30.0D * l6;
					}

					l5 = 8;

					if(i5 < l5) {
						l6 = (l5 - i5) / (l5 - 1.0F);
						l = l * (1.0D - l6) + -30.0D * l6;
					}

					d[i2] = l;
					++i2;
				}
			}
		}
		return d;
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		int x1 = i * 16;
		int z1 = j * 16;
		int x, y, z, times;
	}

	@Override
	public boolean saveChunks(boolean par1, IProgressUpdate par2) {
		return true;
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
		return "Depths";
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void saveExtraData() { }

	@Override
	public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
		return false;
	}

	@Override
	public List func_177458_a(EnumCreatureType p_177458_1_, BlockPos p_177458_2_) {
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(p_177458_2_);
		return var5 == null ? null : var5.getSpawnableList(p_177458_1_);
	}

	@Override
	public Chunk provideChunk(BlockPos pos) {
		return this.provideChunk(pos.getX() >> 4, pos.getZ() >> 4);
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String p_180513_2_, BlockPos p_180513_3_) {
		return null;
	}

	@Override
	public void recreateStructures(Chunk p_180514_1_, int par1, int par2) { }
}