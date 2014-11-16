package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEucaPlant extends WorldGenerator {

	private Block gen;
	
	public WorldGenEucaPlant(Block plant) {
		gen = plant;
	}
	
	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		for(int l = 0; l < 10; ++l) {
			int i1 = x + r.nextInt(8) - r.nextInt(8);
			int j1 = y + r.nextInt(4) - r.nextInt(4);
			int k1 = z + r.nextInt(8) - r.nextInt(8);
			if(w.isAirBlock(i1, j1, k1) && (!w.provider.hasNoSky || j1 < 255) && EssenceBlocks.eucaTallGrass.canBlockStay(w, i1, j1, k1))
				w.setBlock(i1, j1, k1, gen, 0, 2);
		}
		return true;
	}
}