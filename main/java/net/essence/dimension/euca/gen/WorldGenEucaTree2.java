package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenEucaTree2 extends WorldGenerator {

	@Override
	public boolean generate(World w, Random rand, int x, int y, int z) {
		
		int height = rand.nextInt(40) + 10;
		int logHeight = height;
		Block leaves = EssenceBlocks.redEucaLeaves;
		Block log = EssenceBlocks.eucaLog;
		Block dirt = EssenceBlocks.eucaDirt;

		/*WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x - 1, y + 1, z, log, 4);
		WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 2, y + 1, z, log, 4);
		WorldGenAPI.addRectangleWithMetadata(2, 1, 1, w, x, y + 1, z - 1, log, 8);
		WorldGenAPI.addRectangleWithMetadata(2, 1, 1, w, x, y + 1, z + 2, log, 8);
		WorldGenAPI.addRectangleWithMetadata(2, 1, 1, w, x, y, z - 2, log, 1);
		WorldGenAPI.addRectangleWithMetadata(2, 1, 1, w, x, y, z + 3, log, 1);
		WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x - 2, y, z, log, 1);
		WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 3, y, z, log, 1);
		WorldGenAPI.addBlock(w, x + 4, y - 1, z, log);
		WorldGenAPI.addBlock(w, x - 3, y - 1, z + 1, log);
		WorldGenAPI.addBlock(w, x, y - 1, z + 4, log);
		WorldGenAPI.addBlock(w, x + 1, y - 1, z - 3, log);*/
		WorldGenAPI.addCornerlessRectangle(4, 4, height - 7, w, x - 1, y + 7, z - 1, leaves);
		WorldGenAPI.addRectangle(2, 2, 2, w, x, y + height, z, leaves);
		
		if(height > 10){
			height -= 6;
			addRow(w, x, y, z, height, log, leaves);
		}

		if(height > 18){
			height -= 6;
			addRow(w, x, y, z, height, log, leaves);
		}

		if(height > 27){
			height -= 6;
			addRow(w, x, y, z, height, log, leaves);
			height -= 6;
			addRow(w, x, y, z, height, log, leaves);
			height -= 6;
			addRow(w, x, y, z, height, log, leaves);
		}
		
		if(height > 40){
			height -= 6;
			addRow(w, x, y, z, height, log, leaves);
		}
		
		WorldGenAPI.addRectangle(2, 2, logHeight, w, x, y, z, log);
		WorldGenAPI.addRectangle(2, 2, 1, w, x, y - 1, z, dirt);

		return true;
	}
	
	private void addRow(World w, int x, int y, int z, int height, Block log, Block leaves){
		WorldGenAPI.addCornerlessRectangle(4, 4, 1, w, x - 6, y + height - 5, z - 1, leaves);
		WorldGenAPI.addCornerlessRectangle(4, 4, 1, w, x + 4, y + height - 5, z - 1, leaves);
		WorldGenAPI.addCornerlessRectangle(4, 4, 1, w, x - 1, y + height - 5, z - 6, leaves);
		WorldGenAPI.addCornerlessRectangle(4, 4, 1, w, x - 1, y + height - 5, z + 4, leaves);
		WorldGenAPI.addRectangle(2, 2, 3, w, x - 5, y + height - 6, z, leaves);
		WorldGenAPI.addRectangle(2, 2, 3, w, x + 5, y + height - 6, z, leaves);
		WorldGenAPI.addRectangle(2, 2, 3, w, x, y + height - 6, z - 5, leaves);
		WorldGenAPI.addRectangle(2, 2, 3, w, x, y + height - 6, z + 5, leaves);
		WorldGenAPI.addCornerlessRectangle(5, 4, 1, w, x - 4, y + height - 4, z - 1, leaves);
		WorldGenAPI.addCornerlessRectangle(5, 4, 1, w, x + 1, y + height - 4, z - 1, leaves);
		WorldGenAPI.addCornerlessRectangle(4, 5, 1, w, x - 1, y + height - 4, z + 1, leaves);
		WorldGenAPI.addCornerlessRectangle(4, 5, 1, w, x - 1, y + height - 4, z - 4, leaves);
		WorldGenAPI.addRectangle(3, 2, 3, w, x - 3, y + height - 5, z, leaves);
		WorldGenAPI.addRectangle(3, 2, 3, w, x + 2, y + height - 5, z, leaves);
		WorldGenAPI.addRectangle(2, 3, 3, w, x, y + height - 5, z - 3, leaves);
		WorldGenAPI.addRectangle(2, 3, 3, w, x, y + height - 5, z + 2, leaves);
		WorldGenAPI.addRectangleWithMetadata(3, 2, 1, w, x - 3, y + height - 4, z, log, 4);
		WorldGenAPI.addRectangleWithMetadata(3, 2, 1, w, x + 2, y + height - 4, z, log, 4);
		WorldGenAPI.addRectangleWithMetadata(2, 3, 1, w, x, y + height - 4, z - 3, log, 8);
		WorldGenAPI.addRectangleWithMetadata(2, 3, 1, w, x, y + height - 4, z + 2, log, 8);
		WorldGenAPI.addRectangleWithMetadata(2, 2, 1, w, x - 5, y + height - 5, z, log, 4);
		WorldGenAPI.addRectangleWithMetadata(2, 2, 1, w, x + 5, y + height - 5, z, log, 4);
		WorldGenAPI.addRectangleWithMetadata(2, 2, 1, w, x, y + height - 5, z - 5, log, 8);
		WorldGenAPI.addRectangleWithMetadata(2, 2, 1, w, x, y + height - 5, z + 5, log, 8);
	}
}