package net.essence.dimension.vanilla.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.util.Helper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenTowerDungeon extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		Helper.printCoords(x, y, z);
		int levels = 4;
		int height = levels * 4;
		ItemStack[] items = {new ItemStack(Items.apple), new ItemStack(Items.arrow), new ItemStack(Blocks.acacia_stairs)};

		/*WorldGenAPI.placeChestWithContents(w, x + 13, y + 14, z + 1, 1, false, items);
		WorldGenAPI.placeChestWithContents(w, x + 1, y + 14, z + 8, 2, false, items);
		WorldGenAPI.placeChestWithContents(w, x + 13, y + 14, z + 8, 2, false, items);*/
		
		WorldGenAPI.addRectangle(17, 12, 1, w, x - 1, y, z - 1, Blocks.grass);
		WorldGenAPI.addRectangle(17, 12, 10, w, x - 1, y - 10, z - 1, Blocks.dirt);

		WorldGenAPI.addCornerlessRectangle(15, 10, height + 10, w, x, y + 1, z, EssenceBlocks.dungeonBrick);
		WorldGenAPI.addRectangle(13, 8, height + 10, w, x + 1, y + 1, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y, z + 1, EssenceBlocks.dungeonBrick);
		WorldGenAPI.addRectangle(2, 1, 3, w, x + 6, y + 1, z, Blocks.air);
		WorldGenAPI.addRectangle(2, 1, 3, w, x + 6, y + 1, z + 9, Blocks.air);
		WorldGenAPI.addRectangle(1, 2, 3, w, x, y + 1, z + 4, Blocks.air);
		WorldGenAPI.addRectangle(1, 2, 3, w, x + 14, y + 1, z + 4, Blocks.air);

		addLevel(w, x, y, z, 4, 1);
		addLevel(w, x, y, z, 4, 0);
		addLevel(w, x, y, z, 12, 1);
		addLevel(w, x, y, z, 12, 0);
		addLevel(w, x, y, z, 20, 1);
		
		WorldGenAPI.addRectangleWithMetadata(15, 1, 1, w, x, y + height * 2 - 6, z - 1, EssenceBlocks.dungeonBrickStairs, 6);
		WorldGenAPI.addRectangleWithMetadata(15, 1, 1, w, x, y + height * 2 - 6, z + 10, EssenceBlocks.dungeonBrickStairs, 7);
		WorldGenAPI.addRectangleWithMetadata(1, 10, 1, w, x + 15, y + height * 2 - 6, z, EssenceBlocks.dungeonBrickStairs, 5);
		WorldGenAPI.addRectangleWithMetadata(1, 10, 1, w, x - 1, y + height * 2 - 6, z, EssenceBlocks.dungeonBrickStairs, 12);
		
		WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y + height + 8, z + 1, EssenceBlocks.mossyEssenceStone);
		WorldGenAPI.addRectangle(15, 10, 1, w, x, y + height + 10, z, EssenceBlocks.dungeonBrick);
		WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y + height + 10, z + 1, Blocks.air);

		WorldGenAPI.addHollowRectangle(15, 10, 1, w, x, y + height + 11, z, EssenceBlocks.dungeonLampFence);
		WorldGenAPI.addHollowRectangle(13, 8, 1, w, x + 1, y + height + 11, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(4, 2, 1, w, x + 2, y + height + 8, z + 1, Blocks.air);

		for(int i = 0; i < 4; i++) {
			w.setBlockState(new BlockPos(x + 5 - i, y + i + height + 5, z + 1), EssenceBlocks.dungeonBrickStairs.getStateFromMeta(1), 2);
			w.setBlockState(new BlockPos(x + 5 - i, y + i + height + 5, z + 2), EssenceBlocks.dungeonBrickStairs.getStateFromMeta(1), 2);
		}
		
		w.setBlockState(new BlockPos(x + 13, y + height + 9, z + 1), EssenceBlocks.dungeonLamp.getDefaultState());
		w.setBlockState(new BlockPos(x + 1, y + height + 9, z + 8), EssenceBlocks.dungeonLamp.getDefaultState());
		w.setBlockState(new BlockPos(x + 13, y + height + 9, z + 8), EssenceBlocks.dungeonLamp.getDefaultState());

		w.setBlockState(new BlockPos(x + 12, y + height + 9, z + 8), EssenceBlocks.dungeonLampStairs.getStateFromMeta(0), 2);
		w.setBlockState(new BlockPos(x + 12, y + height + 9, z + 7), EssenceBlocks.dungeonLampStairs.getStateFromMeta(0), 2);
		w.setBlockState(new BlockPos(x + 13, y + height + 9, z + 7), EssenceBlocks.dungeonLampStairs.getStateFromMeta(2), 2);
		w.setBlockState(new BlockPos(x + 12, y + height + 9, z + 2), EssenceBlocks.dungeonLampStairs.getStateFromMeta(0), 2);
		w.setBlockState(new BlockPos(x + 12, y + height + 9, z + 1), EssenceBlocks.dungeonLampStairs.getStateFromMeta(0), 2);
		w.setBlockState(new BlockPos(x + 13, y + height + 9, z + 2), EssenceBlocks.dungeonLampStairs.getStateFromMeta(3), 2);
		w.setBlockState(new BlockPos(x + 2, y + height + 9, z + 7), EssenceBlocks.dungeonLampStairs.getStateFromMeta(2), 2);
		w.setBlockState(new BlockPos(x + 1, y + height + 9, z + 7), EssenceBlocks.dungeonLampStairs.getStateFromMeta(2), 2);
		w.setBlockState(new BlockPos(x + 2, y + height + 9, z + 8), EssenceBlocks.dungeonLampStairs.getStateFromMeta(1), 2);
		
		addDifferentBlocks(w, x, y, z);
		return true;
	}

	public void addDifferentBlocks(World w, int x, int y, int z) {
		Random r = new Random();
		for(int x1 = 0; x1 < 15; x1++) {
			for(int y1 = 0; y1 < 200; y1++) {
				for(int z1 = 0; z1 < 15; z1++) {
					if(w.getBlockState(new BlockPos(x + x1, y + y1, z + z1)) == EssenceBlocks.dungeonBrick && r.nextInt(15) == 0) {
						w.setBlockState(new BlockPos(x + x1, y + y1, z + z1), EssenceBlocks.dungeonChisledBrick.getDefaultState());
						break;
					}
				}
			}
		}

		for(int x1 = 0; x1 < 15; x1++) {
			for(int y1 = 0; y1 < 200; y1++) {
				for(int z1 = 0; z1 < 15; z1++) {
					if(w.getBlockState(new BlockPos(x + x1, y + y1, z + z1)) == EssenceBlocks.dungeonBrick && r.nextInt(10) == 0) {
						w.setBlockState(new BlockPos(x + x1, y + y1, z + z1), EssenceBlocks.dungeonBrickCarved.getDefaultState());
						break;
					}
				}
			}
		}

		for(int x1 = 0; x1 < 15; x1++) {
			for(int y1 = 0; y1 < 200; y1++) {
				for(int z1 = 0; z1 < 15; z1++) {
					if(w.getBlockState(new BlockPos(x + x1, y + y1, z + z1)) == EssenceBlocks.dungeonBrick && r.nextInt(10) == 0) {
						w.setBlockState(new BlockPos(x + x1, y + y1, z + z1), EssenceBlocks.dungeonCrackedBrick.getDefaultState());
						break;
					}
				}
			}
		}
		
		for(int i = 0; i < 50; i++) {
			for(int j = 0; j < 200; j++) {
				for(int k = 0; k < 50; k++) {
					if(w.getBlockState(new BlockPos(i, j, k)) == EssenceBlocks.dungeonBrick) {
						if(r.nextInt(10) == 0) w.setBlockState(new BlockPos(i, j, k), EssenceBlocks.dungeonCrackedBrick.getDefaultState());
					}
				}
			}
		}
	}

	public void addLevel(World w, int x, int y, int z, int height, int lor) {
		Random r = new Random();
		WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y + height, z + 1, EssenceBlocks.dungeonBrick);
		WorldGenAPI.addRectangle(13, 8, 1, w, x + 1, y + height + 4, z + 1, EssenceBlocks.dungeonBrick);
		WorldGenAPI.addRectangle(4, 2, 1, w, x + 2, y + height + 4, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(4, 2, 1, w, x + 2, y + height, z + 7, Blocks.air);
		WorldGenAPI.addBlock(w, x + 13, y + height - 1, z + 1, EssenceBlocks.dungeonLamp);
		WorldGenAPI.addBlock(w, x + 1, y + height - 1, z + 1, EssenceBlocks.dungeonLamp);
		WorldGenAPI.addBlock(w, x + 1, y + height - 1, z + 8, EssenceBlocks.dungeonLamp);
		WorldGenAPI.addBlock(w, x + 13, y + height - 1, z + 8, EssenceBlocks.dungeonLamp);
		WorldGenAPI.addBlock(w, x + 13, y + height - 5, z + 1, EssenceBlocks.dungeonLamp);
		WorldGenAPI.addBlock(w, x + 1, y + height - 5, z + 1, EssenceBlocks.dungeonLamp);
		WorldGenAPI.addBlock(w, x + 1, y + height - 5, z + 8, EssenceBlocks.dungeonLamp);
		WorldGenAPI.addBlock(w, x + 13, y + height - 5, z + 8, EssenceBlocks.dungeonLamp);

		for(int i = 0; i < 4; i++) {
			if(lor == 0) {
				w.setBlockState(new BlockPos(x + 5 - i, y + i + 1 + height, z + 1), EssenceBlocks.dungeonBrickStairs.getStateFromMeta(1), 2);
				w.setBlockState(new BlockPos(x + 5 - i, y + i + 1 + height, z + 2), EssenceBlocks.dungeonBrickStairs.getStateFromMeta(1), 2);
			} else {
				w.setBlockState(new BlockPos(x + 5 - i, y + i + 1 + height - 4, z + 7), EssenceBlocks.dungeonBrickStairs.getStateFromMeta(1), 2);
				w.setBlockState(new BlockPos(x + 5 - i, y + i + 1 + height - 4, z + 8), EssenceBlocks.dungeonBrickStairs.getStateFromMeta(1), 2);
			}
		}
		w.setBlockState(new BlockPos(x + 2, y + 1 + height - 1, z + 7), EssenceBlocks.dungeonBrickStairs.getStateFromMeta(1), 2);
		w.setBlockState(new BlockPos(x + 2, y + 1 + height - 1, z + 8), EssenceBlocks.dungeonBrickStairs.getStateFromMeta(1), 2);
		
		for(int x1 = 0; x1 < 15; x1++) {
			for(int y1 = 0; y1 < 200; y1++) {
				for(int z1 = 0; z1 < 15; z1++) {
					if(w.getBlockState(new BlockPos(x + x1, y + y1, z + z1)) == EssenceBlocks.dungeonBrickStairs && r.nextInt(15) == 0) {
						w.setBlockState(new BlockPos(x + x1, y + y1, z + z1), EssenceBlocks.dungeonChisledBrickStairs.getStateFromMeta(1), 2);
						break;
					}
				}
			}
		}

		for(int x1 = 0; x1 < 15; x1++) {
			for(int y1 = 0; y1 < 200; y1++) {
				for(int z1 = 0; z1 < 15; z1++) {
					if(w.getBlockState(new BlockPos(x + x1, y + y1, z + z1)) == EssenceBlocks.dungeonBrickStairs && r.nextInt(10) == 0) {
						w.setBlockState(new BlockPos(x + x1, y + y1, z + z1), EssenceBlocks.dungeonBrickCarvedStairs.getStateFromMeta(1), 2);
						break;
					}
				}
			}
		}

		for(int x1 = 0; x1 < 15; x1++) {
			for(int y1 = 0; y1 < 200; y1++) {
				for(int z1 = 0; z1 < 15; z1++) {
					if(w.getBlockState(new BlockPos(x + x1, y + y1, z + z1)) == EssenceBlocks.dungeonBrickStairs && r.nextInt(10) == 0) {
						w.setBlockState(new BlockPos(x + x1, y + y1, z + z1), EssenceBlocks.dungeonCrackedBrickStairs.getStateFromMeta(1), 2);
						break;
					}
				}
			}
		}
		
		for(int i = 0; i < 50; i++) {
			for(int j = 0; j < 200; j++) {
				for(int k = 0; k < 50; k++) {
					if(w.getBlockState(new BlockPos(i, j, k)) == EssenceBlocks.dungeonBrickStairs) {
						if(r.nextInt(10) == 0) w.setBlockState(new BlockPos(i, j, k), EssenceBlocks.dungeonCrackedBrickStairs.getStateFromMeta(1), 2);
					}
				}
			}
		}
	}
}