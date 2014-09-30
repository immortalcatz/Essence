package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenSmallEucaTree extends WorldGenerator {
	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		int height = r.nextInt(3) + 5;
		Block leaf = null;
		switch(r.nextInt(3)) {
		case 0:
			leaf = EssenceBlocks.greenEucaLeaves;
			break;
		case 1:
			leaf = EssenceBlocks.blueEucaLeaves;
			break;
		case 2:
			leaf = EssenceBlocks.redEucaLeaves;
			break;
		}
		WorldGenAPI.addRectangle(3, 3, 1, w, x - 1, y + height + 1, z - 1, leaf);
		WorldGenAPI.addRectangle(5, 5, 1, w, x - 2, y + height, z - 2, leaf);
		WorldGenAPI.addRectangle(3, 3, 1, w, x - 1, y + height, z - 1, Blocks.air);
		WorldGenAPI.addRectangle(1, 1, height, w, x, y, z, EssenceBlocks.eucaLog);
		WorldGenAPI.addRectangle(1, 1, 1, w, x, y - 1, z, EssenceBlocks.eucaDirt);
		WorldGenAPI.addRectangle(3, 3, 1, w, x - 1, y + height, z - 1, EssenceBlocks.eucaLog);
		return true;
	}
}