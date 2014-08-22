package net.essence.dimension.depths;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.depths.gen.WorldGenDepthsTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class ChunkProviderDepths implements IChunkProvider{

	private BiomeGenBase[] biomesForGeneration;
	private World worldObj;
	private Random rand;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenCaves();
	double[] noise1, noise2, noise3, noise4, noise5;
	private NoiseGeneratorOctaves noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6;
	private double[] generatedTemperatures;
	private double[] noiseArray;


	public ChunkProviderDepths(World var1, long var2){
		this.worldObj = var1;
		this.rand = new Random(var2 + 4);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
	}

	@Override
	public boolean chunkExists(int i, int j) {
		return true;
	}

	@Override
	public Chunk provideChunk(int i, int j) {
		this.rand.setSeed(i * 341873128712L + j * 132897987541L);
		Block[] var3 = new Block[65536];
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, i * 16, j * 16, 16, 16);
		this.generateTerrain(i, j, var3, this.biomesForGeneration, this.generatedTemperatures);
		this.replaceBlocksForBiome(i, j, var3, this.biomesForGeneration);
		Chunk var4 = new Chunk(this.worldObj, var3, i, j);
		byte[] var5 = var4.getBiomeArray();

		for(int var6 = 0; var6 < var5.length; ++var6) {
			var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
		}

		var4.generateSkylightMap();
		return var4;
	}



	public void replaceBlocksForBiome(int var1, int var2, Block[] var3, BiomeGenBase[] var4) {
		byte var5 = 65;
		double var6 = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, var1 * 16, var2 * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, var1, var2, var3, var4);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.getResult() == Result.DENY) return;

		for(int i1 = 0; i1 < 16; ++i1) {
			for(int var9 = 0; var9 < 16; ++var9) {
				BiomeGenBase j1 = var4[var9 + i1 * 16];
				float var11 = j1.getFloatTemperature(var9, var9, var9);
				int i2 = (int)(this.stoneNoise[i1 + var9 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
				int j2 = -1;
				Block i3 = j1.topBlock;
				Block k1 = EssenceBlocks.depthsGrass;

				for(int k2 = 127; k2 >= 0; --k2) {
					int k3 = (var9 * 16 + i1) * 128 + k2;

					if(k2 <= 0 + this.rand.nextInt(5)) {
						var3[k3] = null;
					} else {
						Block i4 = var3[k3];

						if(i4 == null) {
							j2 = -1;
						}
						else if(i4 == Blocks.stone) {
							if(j2 == -1) {
								if(i2 <= 0) {
									i3 = EssenceBlocks.depthsGrass;
									k1 = EssenceBlocks.depthsGrass;
								}
								else if(k2 >= var5 - 4 && k2 <= var5 + 1) {
									i3 = EssenceBlocks.depthsGrass;
									k1 = EssenceBlocks.depthsStone;
								}

								if(k2 >= var5 - 1) {
									var3[k3] = i3;
								} else {
									var3[k3] = k1;
								}
							}
							else if(j2 > 0) {
								--j2;
								var3[k3] = k1;

								if(j2 == 0 && k1 == EssenceBlocks.depthsGrass) {
									j2 = -1;
									k1 = EssenceBlocks.depthsGrass;
								}
							}
						}

						if(j2 > 0) {
							--j2;
							var3[k3] = k1;

							if(j2 == 0 && k1 == EssenceBlocks.depthsStone) {
								j2 = -1;
								k1 = EssenceBlocks.depthsStone;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public Chunk loadChunk(int i, int j) {
		return this.provideChunk(i, j);
	}

	public void generateTerrain(int var1, int var2, Block[] var3, BiomeGenBase[] var4, double[] var5) {
		byte var6 = 2;
		int var7 = var6 + 1;
		byte i1 = 66;
		int var9 = var6 + 1;
		this.noiseArray = this.initializeNoiseField(this.noiseArray, var1 * var6, 0, var2 * var6, var7, i1, var9);

		for(int j1 = 0; j1 < var6; ++j1) {
			for(int var11 = 0; var11 < var6; ++var11) {
				for(int i2 = 0; i2 < 32; ++i2) {
					double j2 = 0.15D;
					double k1 = this.noiseArray[((j1 + 0) * var9 + var11 + 1) * i1 + i2 + 0];
					double k3 = this.noiseArray[((j1 + 0) * var9 + var11 + 1) * i1 + i2 + 1];
					double j4 = this.noiseArray[((j1 + 1) * var9 + var11 + 1) * i1 + i2 + 0];
					double k5 = this.noiseArray[((j1 + 1) * var9 + var11 + 1) * i1 + i2 + 1];
					double j5 = (this.noiseArray[((j1 + 0) * var9 + var11 + 0) * i1 + i2 + 1] - k1) * j2;
					double i5 = (this.noiseArray[((j1 + 0) * var9 + var11 + 1) * i1 + i2 + 1] - k3) * j2;
					double var27 = (this.noiseArray[((j1 + 1) * var9 + var11 + 0) * i1 + i2 + 1] - j4) * j2;
					double var29 = (this.noiseArray[((j1 + 1) * var9 + var11 + 1) * i1 + i2 + 1] - k5) * j2;

					for(int var31 = 0; var31 < 4; ++var31) {
						double l3 = 0.125D;
						double l4 = k1;
						double l5 = k3;
						double var38 = (j4 - k1) * l3;
						double var40 = (k5 - k3) * l3;

						for(int var42 = 0; var42 < 8; ++var42) {
							int var43 = var42 + j1 * 8 << 11 | 0 + var11 * 8 << 7 | i2 * 4 + var31;
							short var44 = 128;
							double var45 = 0.25D;
							double var47 = l4;
							double var49 = (l5 - l4) * var45;

							for(int var51 = 0; var51 < 8; ++var51) {
								Block var52 = null;

								if(var47 > 0.0D) {
									var52 = Blocks.stone;
								}

								var3[var43] = var52;
								var43 += var44;
								var47 += var49;
							}

							l4 += var38;
							l5 += var40;
						}

						k1 += j5;
						k3 += i5;
						j4 += var27;
						k5 += var29;
					}
				}
			}
		}
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		int x1 = i * 16;
		int z1 = j * 16;
		int x, y, z, times;
		x = x1 + this.rand.nextInt(16);
		z = z1 + this.rand.nextInt(16);

		for(times = 0; times < 40; times++) {
			y = rand.nextInt(256);
			(new WorldGenMinable(EssenceBlocks.flairiumOre, 8, EssenceBlocks.depthsStone)).generate(this.worldObj, this.rand, x, y, z);
		}

		if(rand.nextInt(3) == 0) {
			y = rand.nextInt(256);
			if(worldObj.getBlock(x, y, z) != EssenceBlocks.depthsDirt || worldObj.getBlock(x, y - 1, z) != EssenceBlocks.depthsGrass)
				new WorldGenDepthsTree(true).generate(worldObj, rand, x, y, z);
		}

		BlockSand.fallInstantly = false;
	}

	private double[] initializeNoiseField(double[] d, int x, int y, int z, int i, int j, int k) {
		if(d == null) d = new double[i * j * k];
		double i1 = 684.412D;
		double j1 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, x, z, i, k, 1.121D, 1.121D, 0.5D);
		this.noise4 = this.noiseGen6.generateNoiseOctaves(this.noise4, x, z, i, k, 200.0D, 200.0D, 0.5D);
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
				double k5 = this.noise4[j2] / 8000.0D;

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
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public void recreateStructures(int i, int j) { }

	@Override
	public void saveExtraData() { }
	
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
	public ChunkPosition func_147416_a(World var1, String var2, int var3, int var4, int var5) {
		return null;
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i,int j, int k) {
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(i, k);
		return var5 == null ? null : var5.getSpawnableList(enumcreaturetype);
	}
}