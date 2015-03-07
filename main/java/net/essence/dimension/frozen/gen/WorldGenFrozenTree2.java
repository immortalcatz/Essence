package net.essence.dimension.frozen.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenFrozenTree2 extends WorldGenerator {

	@Override
	public boolean generate(World world, Random rand, BlockPos p) {
		if(world.getBlockState(p.down()).getBlock() != EssenceBlocks.frozenGrass) return false;
		int height = 11+rand.nextInt(5)*2;
		
		for(int y = height / 4; y < height; y+=2) {
			for(int x = -3; x <= 3; x++) {
				for(int z = -3; z <= 3; z++) {
					world.setBlockState(p.east(x).north(z).up(y), EssenceBlocks.frozenLeaves.getDefaultState());
				}
			}
			for(int x = -1; x <= 1; x++) {
				for(int z = -1; z <= 1; z++) {
					world.setBlockState(p.east(x).north(z).up(y+1), EssenceBlocks.frozenLeaves.getDefaultState());
				}
			}
		}
		
		for(int y = 0; y < height; y++) {
			world.setBlockState(p.up(y), EssenceBlocks.frozenBark.getDefaultState());
		}
		
		world.setBlockState(p.up(height), EssenceBlocks.frozenLeaves.getDefaultState());
		
		return true;
	}
}