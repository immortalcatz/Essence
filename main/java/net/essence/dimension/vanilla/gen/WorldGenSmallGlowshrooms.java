package net.essence.dimension.vanilla.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSmallGlowshrooms extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		for(int i = 0; i < 50; i++) {
			if(w.getBlock(x, y, z) == Blocks.stone && w.getBlock(x, y, z) == Blocks.air && w.getBlock(x, y + 1, z) == Blocks.air && y < 60) {
				w.setBlock(x, y + 1, z, EssenceBlocks.glowshroom, 1, 2);
				w.setBlockMetadataWithNotify(z,  y, z, 1, 2);
			}
		}
		return true;
	}
}