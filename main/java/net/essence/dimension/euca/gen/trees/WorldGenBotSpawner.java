package net.essence.dimension.euca.gen.trees;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenBotSpawner extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getX() - 3, y = pos.getY() -1, z = pos.getZ() - 1;
		int height = r.nextInt(10) + 10;
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 3, y + height + 2, z + 1, EssenceBlocks.tinbotSpawner);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 3, y + height + 3, z + 1, EssenceBlocks.silverbotSpawner);
		WorldGenAPI.addRectangle(1, 1, height + 1, w, x + 3, y + 1, z + 1, EssenceBlocks.eucaBricks);
		WorldGenAPI.addRectangle(3, 1, height, w, x + 2, y + 1, z + 1, EssenceBlocks.eucaBricks);
		WorldGenAPI.addRectangle(1, 3, height, w, x + 3, y + 1, z, EssenceBlocks.eucaBricks);
		WorldGenAPI.addRectangle(7, 3, 1, w, x, y + height, z, EssenceBlocks.eucaTile);	
		WorldGenAPI.addRectangle(3, 7, 1, w, x + 2, y + height, z - 2, EssenceBlocks.eucaTile);		
		WorldGenAPI.addRectangle(5, 5, 1, w, x + 1, y + height, z - 1, EssenceBlocks.eucaTile);
		return false;
	}
}