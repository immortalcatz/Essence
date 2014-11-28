package net.essence.dimension.vanilla.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenChristmasLights extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		for(int i = 0; i < 20; i++) {
			if(w.getBlockState(pos) == Blocks.leaves || w.getBlockState(pos) == Blocks.leaves2)
				w.setBlockState(pos, EssenceBlocks.christmasLights.getDefaultState());
		}
		return true;
	}
}