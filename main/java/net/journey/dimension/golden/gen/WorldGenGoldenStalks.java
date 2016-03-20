package net.journey.dimension.golden.gen;

import java.util.Random;

import net.journey.JourneyBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGoldenStalks extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		for(int i = 0; i < 64; i++) {
		Block top = JourneyBlocks.goldenStalksTop, bottom = JourneyBlocks.goldenStalksBottom;
			if(w.getBlockState(pos.down()).getBlock() == JourneyBlocks.goldenGrass && w.getBlockState(pos) == Blocks.air.getDefaultState() && w.getBlockState(pos.up()) == Blocks.air.getDefaultState()) {
				w.setBlockState(pos, bottom.getDefaultState(), 2);
				w.setBlockState(pos.up(), top.getDefaultState(), 2);
			}
		}
		return true;
	}
}
