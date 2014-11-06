package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenWorldSphere {

	protected Block[] GetValidSpawnBlocks() {
		return new Block[] { Blocks.air };
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
		Block block = world.getBlock(i, j, k);

		for(Block x : GetValidSpawnBlocks()) {
			if(block == x)
				return true;
		}
		return false;
	}

	public boolean generate(World w, Random r, int x, int y, int z) {
		int size = 32;

		int XLength = x - size;
		int XHeight = x + size;
		int ZLength = z - size;
		int ZHeight = z + size;
		double realSize = size / 2;
		double sizeOfSphere = realSize * realSize;
		for(int i = XLength; i < XHeight; i++) {
			for(int j = y - size; j < y + size; j++) {
				for(int k = ZLength; k < ZHeight; k++) {
					double dx = i - x;
					double dy = j - y;
					double dz = k - z;
					if(dx * dx * 0.7 + dy * dy * 0.9 + dz * dz * 0.7 < sizeOfSphere) {
						w.setBlock(i, j + 2, k, EssenceBlocks.eucaStone);
						w.setBlock(i, j + 3, k, EssenceBlocks.eucaDirt);
						w.setBlock(i, j + 4, k, EssenceBlocks.eucaGrass);

						if(w.getBlock(i, j, k) == EssenceBlocks.eucaStone) {
							if(r.nextInt(40) == 0) w.setBlock(i, j, k, EssenceBlocks.celestiumOre);
						}
					}
				}
			}
		}
		return true;
	}
}