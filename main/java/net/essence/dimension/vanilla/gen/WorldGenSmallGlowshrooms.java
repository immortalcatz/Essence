package net.essence.dimension.vanilla.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSmallGlowshrooms extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		for(int i = 0; i < 50; i++) {
			if(w.getBlockState(new BlockPos(x, y, z)) == Blocks.stone && w.getBlockState(new BlockPos(x, y, z)) == Blocks.air && w.getBlockState(new BlockPos(x, y + 1, z)) == Blocks.air && y < 60) {
				w.setBlockState(new BlockPos(x, y + 1, z), EssenceBlocks.glowshroom.getStateFromMeta(1), 2);
			}
		}
		return true;
	}
}