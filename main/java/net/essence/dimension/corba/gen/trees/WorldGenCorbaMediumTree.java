package net.essence.dimension.corba.gen.trees;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenCorbaMediumTree extends WorldGenerator {

	@Override
	public boolean generate(World world, Random r, BlockPos pos) {
		int i = pos.getX() - 3, j = pos.getY(), k = pos.getZ() - 3;
		int height = r.nextInt(4);
		Block leaves = null, log = null;
		switch(r.nextInt(2)) {
		case 0:
			log = EssenceBlocks.brownCorbaLog;
			break;
		case 1:
			log = EssenceBlocks.greenCorbaLog;
			break;
		}
		WorldGenAPI.addRectangle(1, 1, 9 + height, world, i + 3, j + 1, k + 3, log);
		j = j + height + 2;
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
		world.setBlockState(new BlockPos(i, j + 1, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i, j + 1, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i, j + 1, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 5), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 1, k), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 5), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 6), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 5), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 5, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 5, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 5, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 2, j + 7, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 1, k), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 5), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 6), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 5), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 5, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 5, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 7, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 7, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 3, j + 8, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 1, k), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 5), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 6), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 5), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 4, j + 7, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 1), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 5), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 4), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 2), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 3), leaves.getDefaultState());
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 4), leaves.getDefaultState());
		return true;
	}
}