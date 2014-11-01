package net.essence.dimension.boil.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBoilingFire extends WorldGenerator{

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		for(int i = 0; i < 20; i++){
			if(w.getBlock(x, y - 1, z) == EssenceBlocks.hotBlock){
				w.setBlock(x, y, z, EssenceBlocks.boilingFire, 0, 2);
				return true;
			}
		}
		return false;
	}
}