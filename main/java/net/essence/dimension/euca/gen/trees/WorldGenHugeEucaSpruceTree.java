package net.essence.dimension.euca.gen.trees;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class WorldGenHugeEucaSpruceTree extends WorldGenEucaHugeTree
{
	private boolean field_150542_e;

	public WorldGenHugeEucaSpruceTree(boolean p_i45457_1_, boolean p_i45457_2_)
	{
		super(p_i45457_1_, 8, 10, 1);
		this.field_150542_e = p_i45457_2_;
	}

	public boolean generate(World p_76484_1_, Random p_76484_2_, BlockPos pos) {

		int p_76484_3_ = pos.getX(), p_76484_4_ = pos.getY(), p_76484_5_ = pos.getZ();

		int l = this.setHeight(p_76484_2_);

		if (!this.gen(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_, l))
		{
			return false;
		}
		else
		{
			this.func_150541_c(p_76484_1_, p_76484_3_, p_76484_5_, p_76484_4_ + l, 0, p_76484_2_);

			for (int i1 = 0; i1 < l; ++i1)
			{
				Block block = p_76484_1_.getBlockState(new BlockPos(p_76484_3_, p_76484_4_ + i1, p_76484_5_)).getBlock();

				if (block.isAir(p_76484_1_, new BlockPos(p_76484_3_, p_76484_4_ + i1, p_76484_5_)) || block.isLeaves(p_76484_1_, new BlockPos(p_76484_3_, p_76484_4_ + i1, p_76484_5_)))
				{
					this.func_175905_a(p_76484_1_, new BlockPos(p_76484_3_, p_76484_4_ + i1, p_76484_5_), EssenceBlocks.eucaLog, this.woodMetadata);
				}

				if (i1 < l - 1)
				{
					block = p_76484_1_.getBlockState(new BlockPos(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_)).getBlock();

					if (block.isAir(p_76484_1_, new BlockPos(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_)) || block.isLeaves(p_76484_1_, new BlockPos(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_)))
					{
						this.func_175905_a(p_76484_1_, new BlockPos(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_), EssenceBlocks.eucaLog, this.woodMetadata);
					}

					block = p_76484_1_.getBlockState(new BlockPos(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ + 1)).getBlock();

					if (block.isAir(p_76484_1_, new BlockPos(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ + 1)) || block.isLeaves(p_76484_1_, new BlockPos(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ + 1)))
					{
						this.func_175905_a(p_76484_1_, new BlockPos(p_76484_3_ + 1, p_76484_4_ + i1, p_76484_5_ + 1), EssenceBlocks.eucaLog, this.woodMetadata);
					}

					block = p_76484_1_.getBlockState(new BlockPos(p_76484_3_, p_76484_4_ + i1, p_76484_5_ + 1)).getBlock();

					if (block.isAir(p_76484_1_, new BlockPos(p_76484_3_, p_76484_4_ + i1, p_76484_5_ + 1)) || block.isLeaves(p_76484_1_, new BlockPos(p_76484_3_, p_76484_4_ + i1, p_76484_5_ + 1)))
					{
						this.func_175905_a(p_76484_1_, new BlockPos(p_76484_3_, p_76484_4_ + i1, p_76484_5_ + 1), EssenceBlocks.eucaLog, this.woodMetadata);
					}
				}
			}

			return true;
		}
	}

	private void func_150541_c(World p_150541_1_, int p_150541_2_, int p_150541_3_, int p_150541_4_, int p_150541_5_, Random p_150541_6_)
	{
		int i1 = p_150541_6_.nextInt(5);

		if (this.field_150542_e)
		{
			i1 += this.baseHeight;
		}
		else
		{
			i1 += 3;
		}

		int j1 = 0;

		for (int k1 = p_150541_4_ - i1; k1 <= p_150541_4_; ++k1)
		{
			int l1 = p_150541_4_ - k1;
			int i2 = p_150541_5_ + MathHelper.floor_float((float)l1 / (float)i1 * 3.5F);
			this.grow3(p_150541_1_, p_150541_2_, k1, p_150541_3_, i2 + (l1 > 0 && i2 == j1 && (k1 & 1) == 0 ? 1 : 0), p_150541_6_);
			j1 = i2;
		}
	}

	public void func_150524_b(World p_150524_1_, Random p_150524_2_, int p_150524_3_, int p_150524_4_, int p_150524_5_) {
		this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ - 1, p_150524_4_, p_150524_5_ - 1);
		this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ + 2, p_150524_4_, p_150524_5_ - 1);
		this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ - 1, p_150524_4_, p_150524_5_ + 2);
		this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ + 2, p_150524_4_, p_150524_5_ + 2);

		for (int l = 0; l < 5; ++l)
		{
			int i1 = p_150524_2_.nextInt(64);
			int j1 = i1 % 8;
			int k1 = i1 / 8;

			if (j1 == 0 || j1 == 7 || k1 == 0 || k1 == 7)
			{
				this.func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ - 3 + j1, p_150524_4_, p_150524_5_ - 3 + k1);
			}
		}
	}

	private void func_150539_c(World p_150539_1_, Random p_150539_2_, int p_150539_3_, int p_150539_4_, int p_150539_5_)
	{
		for (int l = -2; l <= 2; ++l)
		{
			for (int i1 = -2; i1 <= 2; ++i1)
			{
				if (Math.abs(l) != 2 || Math.abs(i1) != 2)
				{
					this.func_150540_a(p_150539_1_, p_150539_3_ + l, p_150539_4_, p_150539_5_ + i1);
				}
			}
		}
	}

	private void func_150540_a(World p_150540_1_, int p_150540_2_, int p_150540_3_, int p_150540_4_)
	{
		for (int l = p_150540_3_ + 2; l >= p_150540_3_ - 3; --l)
		{
			Block block = p_150540_1_.getBlockState(new BlockPos(p_150540_2_, l, p_150540_4_)).getBlock();

			if (block.canSustainPlant(p_150540_1_, new BlockPos(p_150540_2_, l, p_150540_4_), EnumFacing.UP, (BlockSapling)Blocks.sapling))
			{
				this.func_175905_a(p_150540_1_, new BlockPos(p_150540_2_, l, p_150540_4_), EssenceBlocks.eucaDirt, 2);
				break;
			}

			if (block.isAir(p_150540_1_, new BlockPos(p_150540_2_, l, p_150540_4_)) && l < p_150540_3_)
			{
				break;
			}
		}
	}
}