package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.entity.mob.euca.npc.EntityAlloyMender;
import net.essence.entity.mob.overworld.npc.EntityBlacksmith;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenSmeltery extends WorldGenerator {

	public boolean locationIsValidSpawn(World w, int x, int y, int z) {
		for(int i = 0; i < 11; i++) {
			for(int l = 0; l < 11; l++) {
				if(w.getBlockState(new BlockPos(x + i, y, z + l)) != EssenceBlocks.eucaGrass) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getX(), y = pos.getY() - 1, z = pos.getZ();
		if(locationIsValidSpawn(w, x, y, z)) return false;
		
		WorldGenAPI.addRectangle(11, 11, 1, w, x - 1, y + 1, z - 1, EssenceBlocks.eucaGrass);
		WorldGenAPI.addRectangle(11, 11, 4, w, x - 1, y - 3, z - 1, EssenceBlocks.eucaStone);
		WorldGenAPI.addHollowCube(9, w, x, y, z, EssenceBlocks.eucaStone);
		WorldGenAPI.addRectangle(9, 9, 4, w, x, y + 6, z, Blocks.air);
		WorldGenAPI.addRectangle(9, 9, 1, w, x, y + 5, z, EssenceBlocks.eucaStone);
		WorldGenAPI.addRectangleWithMetadata(1, 7, 1, w, x, y + 3, z + 1, Blocks.glass, 2);
		WorldGenAPI.addRectangleWithMetadata(1, 3, 2, w, x, y + 3, z + 3, Blocks.glass, 2);
		WorldGenAPI.addRectangleWithMetadata(1, 7, 1, w, x + 8, y + 3, z + 1, Blocks.glass, 2);
		WorldGenAPI.addRectangleWithMetadata(1, 3, 2, w, x + 8, y + 3, z + 3, Blocks.glass, 2);
		WorldGenAPI.addRectangleWithMetadata(7, 1, 1, w, x + 1, y + 3, z, Blocks.glass, 2);
		WorldGenAPI.addRectangleWithMetadata(3, 1, 2, w, x + 3, y + 3, z, Blocks.glass, 2);
		WorldGenAPI.addRectangleWithMetadata(7, 1, 1, w, x + 1, y + 3, z + 8, Blocks.glass, 2);
		WorldGenAPI.addRectangleWithMetadata(3, 1, 2, w, x + 3, y + 3, z + 8, Blocks.glass, 2);
		ItemDoor.placeDoor(w, new BlockPos(x, y + 2, z + 4), EnumFacing.EAST, Blocks.oak_door);
		ItemDoor.placeDoor(w, new BlockPos(x + 8, y + 2, z + 4), EnumFacing.WEST, Blocks.oak_door);
		ItemDoor.placeDoor(w, new BlockPos(x + 4, y + 2, z), EnumFacing.SOUTH, Blocks.oak_door);
		ItemDoor.placeDoor(w, new BlockPos(x + 4, y + 2, z + 8), EnumFacing.NORTH, Blocks.oak_door);
		w.setBlockState(new BlockPos(x + 1, y + 4, z + 2), Blocks.torch.getStateFromMeta(1), 2);
		w.setBlockState(new BlockPos(x + 1, y + 4, z + 6), Blocks.torch.getStateFromMeta(1), 2);
		w.setBlockState(new BlockPos(x + 7, y + 4, z + 2), Blocks.torch.getStateFromMeta(2), 2);
		w.setBlockState(new BlockPos(x + 7, y + 4, z + 6), Blocks.torch.getStateFromMeta(2), 2);
		WorldGenAPI.addBlock(w, x, y + 5, z, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 2, y + 5, z, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 4, y + 5, z, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 6, y + 5, z, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 8, y + 5, z, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x, y + 5, z + 2, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x, y + 5, z + 4, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x, y + 5, z + 6, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x, y + 5, z + 8, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 2, y + 5, z + 8, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 4, y + 5, z + 8, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 6, y + 5, z + 8, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 8, y + 5, z + 8, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 8, y + 5, z + 2, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 8, y + 5, z + 4, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 8, y + 5, z + 6, EssenceBlocks.eucaStone);
		WorldGenAPI.addBlock(w, x + 8, y + 5, z + 8, EssenceBlocks.eucaStone);
		
		if(!w.isRemote) {
			EntityAlloyMender smith = new EntityAlloyMender(w);
			smith.setLocationAndAngles(x + 4, y + 2, z + 4, 0.0F, 0.0F);
			w.spawnEntityInWorld(smith);
		}
		return true;
	}
}