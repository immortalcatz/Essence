package net.essence.dimension.frozen.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenCandyCane extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		
		switch(r.nextInt(4)) {
		case 0:
			WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, EssenceBlocks.candyCane);
			WorldGenAPI.addRectangle(2, 1, 1, w, x + 1, y + 6, z, EssenceBlocks.candyCane);
			WorldGenAPI.addRectangle(1, 1, 2, w, x + 3, y + 4, z, EssenceBlocks.candyCane);
			break;
		case 1:
			WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, EssenceBlocks.candyCane);
			WorldGenAPI.addRectangle(1, 2, 1, w, x, y + 6, z + 1, EssenceBlocks.candyCane);
			WorldGenAPI.addRectangle(1, 1, 2, w, x, y + 4, z + 3, EssenceBlocks.candyCane);
			break;
		case 2:
			WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, EssenceBlocks.candyCane);
			WorldGenAPI.addRectangle(2, 1, 1, w, x - 2, y + 6, z, EssenceBlocks.candyCane);
			WorldGenAPI.addRectangle(1, 1, 2, w, x - 3, y + 4, z, EssenceBlocks.candyCane);
			break;
		case 3:
			WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, EssenceBlocks.candyCane);
			WorldGenAPI.addRectangle(1, 2, 1, w, x, y + 6, z - 2, EssenceBlocks.candyCane);
			WorldGenAPI.addRectangle(1, 1, 2, w, x, y + 4, z - 3, EssenceBlocks.candyCane);
			break;
		}
		return true;
	}
}