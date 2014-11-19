package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class WorldGenEucaHugeTree extends WorldGenAbstractTree {

	protected final int baseHeight;
	protected final int woodMetadata;
	protected Block leaves = null;
	protected int maxHeight;

	public WorldGenEucaHugeTree(boolean b, int h, int mh, int w) {
		super(b);
		Random r = new Random();
		this.baseHeight = h;
		this.maxHeight = mh;
		this.woodMetadata = w;
		switch(r.nextInt(3)) {
		case 0:
			leaves = EssenceBlocks.greenEucaLeaves;
			break;
		case 1:
			leaves = EssenceBlocks.blueEucaLeaves;
			break;
		case 2:
			leaves = EssenceBlocks.redEucaLeaves;
			break;
		}
	}

	protected int setHeight(Random r) {
		int i = r.nextInt(3) + this.baseHeight;
		if(this.maxHeight > 1) {
			i += r.nextInt(this.maxHeight);
		}
		return i;
	}

	private boolean idk(World w, Random r, int x, int y, int z, int m) {
		boolean flag = true;

		if (y >= 1 && y + m + 1 <= 256) {
			for (int i1 = y; i1 <= y + 1 + m; ++i1) {
				byte b0 = 2;

				if (i1 == y) {
					b0 = 1;
				}

				if (i1 >= y + 1 + m - 2) {
					b0 = 2;
				}

				for (int j1 = x - b0; j1 <= x + b0 && flag; ++j1) {
					for (int k1 = z - b0; k1 <= z + b0 && flag; ++k1) {
						if (i1 >= 0 && i1 < 256) {
							Block block = w.getBlock(j1, i1, k1);

							if (!this.isReplaceable(w, j1, i1, k1)) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}
			return flag;
		} else {
			return false;
		}
	}

	private boolean grow(World w, Random r, int x, int y, int z) {
		Block block = w.getBlock(x, y - 1, z);

		boolean isSoil = block.canSustainPlant(w, x, y - 1, z, ForgeDirection.UP, (BlockSapling)Blocks.sapling);
		if (isSoil && y >= 2) {
			onPlantGrow(w, x, y - 1, z, x, y, z);
			onPlantGrow(w, x + 1, y - 1, z, x, y, z);
			onPlantGrow(w, x, y - 1, z + 1, x, y, z);
			onPlantGrow(w, x + 1, y - 1, z + 1, x, y, z);
			return true;
		} else {
			return false;
		}
	}

	protected boolean gen(World w, Random r, int x, int y, int z, int m) {
		return this.idk(w, r, x, y, z, m) && this.grow(w, r, x, y, z);
	}

	protected void grow3(World w, int x, int y, int z, int m, Random r) {
		int i1 = m * m;

		for (int j1 = x - m; j1 <= x + m + 1; ++j1) {
			int k1 = j1 - x;

			for (int l1 = z - m; l1 <= z + m + 1; ++l1) {
				int i2 = l1 - z;
				int j2 = k1 - 1;
				int k2 = i2 - 1;

				if (k1 * k1 + i2 * i2 <= i1 || j2 * j2 + k2 * k2 <= i1 || k1 * k1 + k2 * k2 <= i1 || j2 * j2 + i2 * i2 <= i1) {
					Block block = w.getBlock(j1, y, l1);

					if (block.isAir(w, j1, y, l1) || block.isLeaves(w, j1, y, l1)) {
						this.setBlockAndNotifyAdequately(w, j1, y, l1, leaves, 0);
					}
				}
			}
		}
	}

	protected void grow2(World w, int x, int y, int z, int m, Random r) {
		int i1 = m * m;

		for (int j1 = x - m; j1 <= x + m; ++j1) {
			int k1 = j1 - x;

			for (int l1 = z - m; l1 <= z + m; ++l1) {
				int i2 = l1 - z;

				if (k1 * k1 + i2 * i2 <= i1) {
					Block block = w.getBlock(j1, y, l1);

					if (block.isAir(w, j1, y, l1) || block.isLeaves(w, j1, y, l1)) {
						this.setBlockAndNotifyAdequately(w, j1, y, l1, leaves, 0);
					}
				}
			}
		}
	}

	private void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
		world.getBlock(x, y, z).onPlantGrow(world, x, y, z, sourceX, sourceY, sourceZ);
	}
}