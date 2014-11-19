package net.essence.dimension.vanilla.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenChristmasLights extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		for(int i = 0; i < 20; i++) {
			if(w.getBlock(x, y, z) == Blocks.leaves || w.getBlock(x, y, z) == Blocks.leaves2)
				w.setBlock(x, y, z, EssenceBlocks.christmasLights);
		}
		return true;
	}
}