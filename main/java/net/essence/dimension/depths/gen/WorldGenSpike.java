package net.essence.dimension.depths.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSpike extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos p) {
		int x = p.getX(), y = p.getY(), z = p.getZ();
		int height = 80;
		int width = r.nextInt(4) + 3;
		for(int j = 0; j < height; j++) placeCircle(w, x, j + y, z, Math.abs(((height / 2) - j)) / 5 + width);
		return true;
	}
	
	public void placeCircle(World par1World, int x, int y, int z, int r) {
		if(r >= 7) r = 6;
		for(float i = 0; i < r; i += 0.5) {
			for(float j = 0; j < 2 * Math.PI * i; j += 0.5) {
				par1World.setBlockState(new BlockPos((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i)), EssenceBlocks.depthsStone.getDefaultState());
			}
		}
	}
}