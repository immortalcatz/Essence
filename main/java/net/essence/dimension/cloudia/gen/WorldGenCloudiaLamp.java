package net.essence.dimension.cloudia.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCloudiaLamp extends WorldGenerator {
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int i = pos.getX(), j = pos.getY(), k = pos.getZ();
		
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 1), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 1), EssenceBlocks.cloudiaDirt.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 2), EssenceBlocks.cloudiaRock.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 3), EssenceBlocks.cloudiaRock.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 0), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 1), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 2), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 3), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 2), EssenceBlocks.cloudiaPost.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 2), EssenceBlocks.cloudiaRock.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 1), EssenceBlocks.cloudiaDirt.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 2), EssenceBlocks.cloudiaRock.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 1), EssenceBlocks.cloudiaRock.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 2), EssenceBlocks.cloudiaDirt.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 3), EssenceBlocks.cloudiaDirt.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 0), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 1), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 2), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 3), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 4), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 1), EssenceBlocks.cloudiaPost.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 2), EssenceBlocks.cloudiaLog.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 3), EssenceBlocks.cloudiaPost.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 5, k + 2), EssenceBlocks.cloudiaPost.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 6, k + 2), EssenceBlocks.cloudiaPost.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 7, k + 2), EssenceBlocks.cloudiaLamp.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 2), EssenceBlocks.cloudiaRock.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 1), EssenceBlocks.cloudiaDirt.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 2), EssenceBlocks.cloudiaRock.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 3), EssenceBlocks.cloudiaRock.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 0), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 1), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 2), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 3), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 4), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 2), EssenceBlocks.cloudiaPost.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 1), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 2), EssenceBlocks.cloudiaGrass.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 3), EssenceBlocks.cloudiaGrass.getDefaultState());


		return true;
	}
}
