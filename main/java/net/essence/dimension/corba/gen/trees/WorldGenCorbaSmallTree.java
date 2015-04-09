package net.essence.dimension.corba.gen.trees;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenCorbaSmallTree extends WorldGenerator {

	@Override
	public boolean generate(World world, Random r, BlockPos pos) {
		int i = pos.getX() - 2, j = pos.getY(), k = pos.getZ() - 2;
		Block leaves = null, log = null;
		int height = r.nextInt(3);
		switch(r.nextInt(2)) {
		case 0:
			log = EssenceBlocks.brownCorbaLog;
			break;
		case 1:
			log = EssenceBlocks.greenCorbaLog;
			break;
		}
		WorldGenAPI.addRectangle(1, 1, 4 + height, world, i + 2, j + 1, k + 2, log);
		j = j + height;
		switch(r.nextInt(5)) {
		case 0:
			leaves = EssenceBlocks.greenCorbaLeaves;
			break;
		case 1:
			leaves = EssenceBlocks.blueCorbaLeaves;
			break;
		case 2:
			leaves = EssenceBlocks.redCorbaLeaves;
			break;
		case 3:
			leaves = EssenceBlocks.cyanCorbaLeaves;
			break;
		case 4:
			leaves = EssenceBlocks.purpleCorbaLeaves;
			break;
		}
		world.setBlockState(new BlockPos(i, j + 2, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 2, k), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 5, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 2), leaves.getDefaultState());
		return true;
	}
}