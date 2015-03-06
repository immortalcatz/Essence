package net.essence.dimension.frozen.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenFrozenTree extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, BlockPos p) {
		if(world.getBlockState(p.down()).getBlock() != EssenceBlocks.frozenGrass) return false;
		int height = 11+rand.nextInt(5)*2;
		for(int y = 0; y<height; y++) {
			world.setBlockState(p.up(y), EssenceBlocks.frozenBark.getDefaultState());
		}
		
		for(int y = height/4; y<height; y+=2) {
			world.setBlockState(p.up(y).east(1), EssenceBlocks.frozenLeaves.getDefaultState());
			world.setBlockState(p.up(y).west(1), EssenceBlocks.frozenLeaves.getDefaultState());
			world.setBlockState(p.up(y).north(1), EssenceBlocks.frozenLeaves.getDefaultState());
			world.setBlockState(p.up(y).south(1), EssenceBlocks.frozenLeaves.getDefaultState());
			world.setBlockState(p.up(y).east(1).north(1), EssenceBlocks.frozenLeaves.getDefaultState());
			world.setBlockState(p.up(y).west(1).north(1), EssenceBlocks.frozenLeaves.getDefaultState());
			world.setBlockState(p.up(y).east(1).south(1), EssenceBlocks.frozenLeaves.getDefaultState());
			world.setBlockState(p.up(y).west(1).south(1), EssenceBlocks.frozenLeaves.getDefaultState());
		}
		
		world.setBlockState(p.up(height), EssenceBlocks.frozenLeaves.getDefaultState());
		
		return true;
	}
}