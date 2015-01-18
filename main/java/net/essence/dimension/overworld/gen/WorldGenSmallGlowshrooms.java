package net.essence.dimension.overworld.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSmallGlowshrooms extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		for(int i = 0; i < 50; i++) {
			if(w.getBlockState(pos.down()) == Blocks.stone.getDefaultState() && w.getBlockState(pos) == Blocks.air.getDefaultState() && pos.getY() < 60) {
				w.setBlockState(pos, EssenceBlocks.glowshroomTop.getDefaultState(), 2);
			}
		}
		return true;
	}
}