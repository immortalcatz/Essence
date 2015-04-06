package net.essence.dimension.euca.gen.trees;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenSmallEucaTree extends WorldGenerator {
	
	@Override
	public boolean generate(World w, Random r, BlockPos p) {
		int x = p.getX(), y = p.getY(), z = p.getZ();
		int height = r.nextInt(3) + 5;
		Block leaf = null;
		switch(r.nextInt(2)) {
		case 0:
			leaf = EssenceBlocks.eucaSilverLeaves;
			break;
		case 1:
			leaf = EssenceBlocks.eucaGoldLeaves;
			break;
		}
		Block log = null;
		switch(r.nextInt(2)) {
		case 0:
			log = EssenceBlocks.eucaSilverLog;
			break;
		case 1:
			log = EssenceBlocks.eucaGoldLog;
			break;
		}
		WorldGenAPI.addRectangle(3, 3, 1, w, x - 1, y + height + 1, z - 1, leaf);
		WorldGenAPI.addRectangle(5, 5, 1, w, x - 2, y + height, z - 2, leaf);
		WorldGenAPI.addRectangle(3, 3, 1, w, x - 1, y + height, z - 1, Blocks.air);
		WorldGenAPI.addRectangle(1, 1, height, w, x, y, z, log);
		WorldGenAPI.addRectangle(1, 1, 1, w, x, y - 1, z, EssenceBlocks.eucaStone);
		WorldGenAPI.addRectangle(3, 3, 1, w, x - 1, y + height, z - 1, log);
		return true;
	}
}