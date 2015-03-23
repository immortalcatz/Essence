package net.essence.dimension.euca.gen.trees;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenEucaPyramidTree extends WorldGenerator {
	
	public boolean generate(World world, Random rand, BlockPos p) {
		int i = p.getX(), j = p.getY(), k = p.getZ();
		WorldGenAPI.addRectangle(3, 3, 3, world, i, j - 2, k, EssenceBlocks.eucaStone);
		Block leaves = WorldGenAPI.getEucaLeaves();
		Block wood = EssenceBlocks.eucaLog;
		int height = rand.nextInt(5) + 15;
		WorldGenAPI.addRectangle(3, 3, height, world, i, j, k, wood);
		WorldGenAPI.addRectangle(1, 1, 1, world, i + 1, j + height, k + 1, leaves);
		WorldGenAPI.addRectangle(3, 3, 1, world, i, j + height - 1, k, leaves);
		WorldGenAPI.addRectangle(1, 1, 1, world, i + 1, j + height - 1, k + 1, wood);
		WorldGenAPI.addRectangle(5, 5, 1, world, i - 1, j + height - 2, k - 1, leaves);
		WorldGenAPI.addRectangle(3, 3, 1, world, i, j + height - 2, k, wood);
		WorldGenAPI.addRectangle(7, 7, 1, world, i - 2, j + height - 3, k - 2, leaves);
		WorldGenAPI.addRectangle(5, 5, 1, world, i - 1, j + height - 3, k - 1, Blocks.air);		
		WorldGenAPI.addRectangle(9, 9, 1, world, i - 3, j + height - 4, k - 3, leaves);
		WorldGenAPI.addRectangle(7, 7, 1, world, i - 2, j + height - 4, k - 2, Blocks.air);		
		WorldGenAPI.addRectangle(3, 3, 3, world, i, j + height - 5, k, wood);
		return true;
	}
}