package net.essence.dimension.depths.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenDepthsTree extends WorldGenAbstractTree {

	private final int minTreeHeight;
	private final int metaWood;
	private final int metaLeaves;
	private static final Random rand = new Random();

	public WorldGenDepthsTree(boolean var1) {
		this(var1, rand.nextInt(10) + 10, 0, 0);
	}

	public WorldGenDepthsTree(boolean var1, int var2, int var3, int var4) {
		super(var1);
		this.minTreeHeight = var2;
		this.metaWood = var3;
		this.metaLeaves = var4;
	}

	public boolean generate(World par1World, Random par2Random, BlockPos pos) {
		int par3 = pos.getX(), par4 = pos.getY(), par5 = pos.getZ();
		int l = par2Random.nextInt(3) + this.minTreeHeight;
		boolean flag = true;

		if(par4 >= 1 && par4 + l + 1 <= 256) {
			byte b0;
			int k1;
			Block block;
			for(int i1 = par4; i1 <= par4 + 1 + l; ++i1) {
				b0 = 1;

				if(i1 == par4) {
					b0 = 0;
				}
				if(i1 >= par4 + 1 + l - 2) {
					b0 = 2;
				}
				for (int j1 = par3 - b0; j1 <= par3 + b0 && flag; ++j1) {
					for (k1 = par5 - b0; k1 <= par5 + b0 && flag; ++k1) {
						if (i1 >= 0 && i1 < 256) {
							block = par1World.getBlockState(new BlockPos(j1, i1, k1)).getBlock();
							if (!this.isReplaceable(par1World, new BlockPos(j1, i1, k1)))
								flag = false;
						} else {
							flag = false;
						}
					}
				}
			}

			if (!flag) {
				return false;
			} else {
				Block block2 = par1World.getBlockState(new BlockPos(par3, par4 - 1, par5)).getBlock();
				boolean isSoil = block2.canSustainPlant(par1World, new BlockPos(par3, par4 - 1, par5), EnumFacing.UP, (BlockSapling)Blocks.sapling);
				if (isSoil && par4 < 256 - l - 1) {
					block2.onPlantGrow(par1World, new BlockPos(par3, par4 - 1, par5), new BlockPos(par3, par4, par5));
					b0 = 3;
					byte b1 = 0;
					int l1;
					int i2;
					int j2;
					int i3;
					for(k1 = par4 - b0 + l; k1 <= par4 + l; ++k1) {
						i3 = k1 - (par4 + l);
						l1 = b1 + 1 - i3 / 2;

						for(i2 = par3 - l1; i2 <= par3 + l1; ++i2) {
							j2 = i2 - par3;

							for(int k2 = par5 - l1; k2 <= par5 + l1; ++k2) {
								int l2 = k2 - par5;

								if(Math.abs(j2) != l1 || Math.abs(l2) != l1 || par2Random.nextInt(2) != 0 && i3 != 0) {
									Block block1 = par1World.getBlockState(new BlockPos(i2, k1, k2)).getBlock();

									if(block1.isAir(par1World, new BlockPos(i2, k1, k2)) || block1.isLeaves(par1World, new BlockPos(i2, k1, k2))) {
										this.func_175905_a(par1World, new BlockPos(i2, k1, k2), EssenceBlocks.depthsLeaves, this.metaLeaves);
									}
								}
							}
						}
					}
					for(k1 = 0; k1 < l; ++k1) {
						block = par1World.getBlockState(new BlockPos(par3, par4 + k1, par5)).getBlock();
						if(block.isAir(par1World, new BlockPos(par3, par4 + k1, par5)) || block.isLeaves(par1World, new BlockPos(par3, par4 + k1, par5))) 
							this.func_175905_a(par1World, new BlockPos(par3, par4 + k1, par5), EssenceBlocks.depthsLog, this.metaWood);
					}
					par1World.setBlockState(new BlockPos(par3, par4 + l, par5), EssenceBlocks.depthsLights.getDefaultState());
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
}