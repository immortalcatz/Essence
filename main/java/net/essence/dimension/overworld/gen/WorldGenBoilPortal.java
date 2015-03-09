package net.essence.dimension.overworld.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.SlayerAPI;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenBoilPortal extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		/*int i;
		boolean foundGround = false;
		for(i = 0; i < 100; i++) {
			for(int x1 = 0; x1 < x - 6; x1++) {
				for(int z1 = 0; z1 < z + 26; z1++) {
					if(w.getBlock(x + x1, i, z + z1) == Blocks.netherrack) {
						foundGround = true;
						break;
					}
				}
			}
		}
		if(!foundGround) return false;
		WorldGenAPI.addRectangle(4, 8, 11, w, x, y - 5, z - 2, Blocks.nether_brick);
		WorldGenAPI.addRectangle(2, 6, 3, w, x + 1, y + 2, z - 2, Blocks.air);
		WorldGenAPI.addRectangle(2, 4, 3, w, x + 1, y, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(4, 1, 1, w, x, y + 2, z - 2, Blocks.nether_brick);
		WorldGenAPI.addRectangle(2, 3, 3, w, x + 1, y - 1, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(2, 2, 3, w, x + 1, y - 2, z + 3, Blocks.air);
		WorldGenAPI.addRectangle(2, 1, 3, w, x + 1, y - 3, z + 4, Blocks.air);
		WorldGenAPI.addRectangle(4, 6, 5, w, x, y - 5, z + 5, Blocks.nether_brick);
		WorldGenAPI.addBlock(w, x, y - 4, z + 7, Blocks.glowstone);
		WorldGenAPI.addBlock(w, x + 3, y - 4, z + 7, Blocks.glowstone);
		WorldGenAPI.addRectangle(2, 1, 1, w, x + 1, y, z + 6, Blocks.nether_brick);
		WorldGenAPI.addRectangle(2, 1, 1, w, x + 1, y, z + 5, Blocks.air);
		WorldGenAPI.addRectangle(2, 2, 1, w, x + 1, y - 1, z + 5, Blocks.air);
		WorldGenAPI.addRectangle(16, 17, 5, w, x - 6, y - 5, z + 10, Blocks.nether_brick);
		WorldGenAPI.addRectangle(14, 14, 3, w, x - 5, y - 4, z + 11, Blocks.air);
		WorldGenAPI.addRectangle(2, 6, 3, w, x + 1, y - 4, z + 5, Blocks.air);
		WorldGenAPI.addRectangle(4, 4, 1, w, x, y - 4, z + 16, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangle(2, 2, 1, w, x + 1, y - 4, z + 17, Blocks.air);
		WorldGenAPI.addRectangle(2, 2, 1, w, x + 1, y - 5, z + 17, Blocks.lava);
		WorldGenAPI.addRectangle(1, 2, 1, w, x + 9, y - 3, z + 17, Blocks.glowstone);
		WorldGenAPI.addRectangle(1, 2, 1, w, x - 6, y - 3, z + 17, Blocks.glowstone);
		WorldGenAPI.addRectangle(10, 1, 5, w, x - 3, y - 5, z + 25, EssenceBlocks.boilPortalFrame);
		WorldGenAPI.addRectangle(8, 1, 3, w, x - 2, y - 4, z + 25, EssenceBlocks.boilPortal);
		WorldGenAPI.addRectangle(2, 14, 1, w, x - 5, y - 5, z + 11, Blocks.soul_sand);
		WorldGenAPI.addRectangle(2, 14, 1, w, x + 7, y - 5, z + 11, Blocks.soul_sand);
		WorldGenAPI.addRectangle(1, 14, 3, w, x + 6, y - 4, z + 11, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangle(1, 14, 3, w, x - 3, y - 4, z + 11, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangleWithMetadata(2, 14, 1, w, x - 5, y - 4, z + 11, Blocks.nether_wart, 3);
		WorldGenAPI.addRectangleWithMetadata(2, 14, 1, w, x + 7, y - 4, z + 11, Blocks.nether_wart, 3);
		for(i = 0; i < 7; i++){
			w.setBlock(x + 1, y - 4 + i, z + 5 - i, Blocks.nether_brick_stairs, 3, 2);
			w.setBlock(x + 2, y - 4 + i, z + 5 - i, Blocks.nether_brick_stairs, 3, 2);
		}*/

		boolean canSpawn = false;
		for(int x1 = 0; x1 < 5; x1++) {
			for(int z1 = 0; z1 < 6; z1++) {
				for(int y1 = 0; y1 < 6; y1++) {
					if(w.getBlockState(new BlockPos(x + x1, y, z + z1)) == Blocks.netherrack.getDefaultState() && w.getBlockState(new BlockPos(x + x1, y + y1, z + z1)) == Blocks.air.getDefaultState()) {
						canSpawn = true;
						break;
					}
				}
			}
		}
		WorldGenAPI.addRectangle(5, 6, 5, w, x, y + 1, z, Blocks.air);
		WorldGenAPI.addRectangle(5, 6, 1, w, x, y, z, Blocks.nether_brick);
		WorldGenAPI.addRectangle(5, 6, 1, w, x, y + 6, z, Blocks.nether_brick);
		WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangle(1, 1, 5, w, x + 4, y + 1, z, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangle(1, 1, 5, w, x + 4, y + 1, z + 5, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangle(1, 1, 5, w, x, y + 1, z + 5, Blocks.nether_brick_fence);
		WorldGenAPI.addRectangle(1, 4, 5, w, x + 2, y + 1, z + 1, EssenceBlocks.boilPortalFrame);
		WorldGenAPI.addRectangle(1, 2, 3, w, x + 2, y + 2, z + 2, Blocks.air);
		WorldGenAPI.addBlock(w, x + 2, y + 3, z + 2, EssenceBlocks.fire);
		return canSpawn;
	}
}