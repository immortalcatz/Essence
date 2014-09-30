package net.essence.dimension.boil.gen.village;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenVillageHouse1 extends WorldGenerator {

	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 7; i++) {
			for(int l = 0; l < 7; l++) {
				if(w.getBlock(x + i, y, z + l) == EssenceBlocks.hotBlock && w.getBlock(x + i, y + 1, z + l) == Blocks.air) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		if(locationIsValidSpawn(w, x, y, z)) {
			WorldGenAPI.addCube(7, w, x, y - 1, z, EssenceBlocks.hotBrick);
			WorldGenAPI.addHollowCube(5, w, x + 1, y - 2, z + 1, EssenceBlocks.hotBrick);
			WorldGenAPI.addRectangle(7, 5, 1, w, x, y + 2, z + 1, EssenceBlocks.hotGlass);
			WorldGenAPI.addRectangle(5, 7, 1, w, x + 1, y + 2, z, EssenceBlocks.hotGlass);
			WorldGenAPI.addCube(5, w, x + 1, y, z + 1, Blocks.air);
			WorldGenAPI.addRectangle(7, 7, 5, w, x, y + 4, z, Blocks.air);
			WorldGenAPI.addRectangle(5, 5, 1, w, x + 1, y + 4, z + 1, EssenceBlocks.hotBrick);
			WorldGenAPI.addRectangle(3, 3, 1, w, x + 2, y + 4, z + 2, Blocks.air);
			WorldGenAPI.addRectangle(3, 3, 1, w, x + 2, y + 5, z + 2, EssenceBlocks.hotGlass);
			WorldGenAPI.addRectangle(3, 3, 1, w, x + 2, y - 1, z + 2, Blocks.flowing_lava);
			WorldGenAPI.addRectangle(3, 3, 1, w, x + 2, y, z + 2, EssenceBlocks.hotGlass);

			switch(r.nextInt(4)) {
			case 0:
				WorldGenAPI.addRectangle(1, 1, 2, w, x + 3, y + 1, z, Blocks.air);
				ItemDoor.placeDoorBlock(w, x + 3, y + 1, z, 1, EssenceBlocks.hotDoor);
				break;
			case 1:
				WorldGenAPI.addRectangle(1, 1, 2, w, x, y + 1, z + 3, Blocks.air);
				ItemDoor.placeDoorBlock(w, x, y + 1, z + 3, 0, EssenceBlocks.hotDoor);
				break;
			case 2:
				WorldGenAPI.addRectangle(1, 1, 2, w, x + 6, y + 1, z + 3, Blocks.air);
				ItemDoor.placeDoorBlock(w, x + 6, y + 1, z + 3, 2, EssenceBlocks.hotDoor);
				break;
			case 3:
				WorldGenAPI.addRectangle(1, 1, 2, w, x + 3, y + 1, z + 6, Blocks.air);
				ItemDoor.placeDoorBlock(w, x + 3, y + 1, z + 6, 3, EssenceBlocks.hotDoor);
				break;
			}
			return true;
		}
		return false;
	}
}