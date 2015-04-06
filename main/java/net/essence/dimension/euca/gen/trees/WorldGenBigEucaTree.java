package net.essence.dimension.euca.gen.trees;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenBigEucaTree extends WorldGenerator {
	
	public boolean generate(World world, Random rand, BlockPos p) {
		int i = p.getX(), j = p.getY(), k = p.getZ();
		WorldGenAPI.addRectangle(3, 3, 3, world, i, j - 2, k, EssenceBlocks.eucaStone);
		Block leaves = WorldGenAPI.getEucaLeaves();
		Block wood = WorldGenAPI.getEucaLog();
		WorldGenAPI.addSphere(world, 15, i + 1, j + 18, k + 1, leaves);
		WorldGenAPI.addRectangle(3, 3, 44, world, i, j, k, wood);
		return true;
	}
}