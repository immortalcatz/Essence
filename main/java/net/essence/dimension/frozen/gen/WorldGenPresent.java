package net.essence.dimension.frozen.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenPresent extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getX(), y = pos.getY(), z = pos.getZ();
		y = y + 1;
		int glass1 = r.nextInt(13), glass2 = r.nextInt(13);
		if(glass2 == glass1) glass2 = r.nextInt(13);
		WorldGenAPI.addRectangleWithMetadata(16, 16, 9, w, x, y, z, Blocks.stained_glass, glass2);
		WorldGenAPI.addRectangleWithMetadata(16, 3, 9, w, x, y, z + 6, Blocks.stained_glass, glass1);
		WorldGenAPI.addRectangleWithMetadata(3, 16, 9, w, x + 6, y, z, Blocks.stained_glass, glass1);
		WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 7, y + 9, z + 8, Blocks.stained_glass, glass1);
		WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 7, y + 9, z + 5, Blocks.stained_glass, glass1);
		WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 7, y + 11, z + 8, Blocks.stained_glass, glass1);
		WorldGenAPI.addRectangleWithMetadata(1, 2, 1, w, x + 7, y + 11, z + 5, Blocks.stained_glass, glass1);
		
		WorldGenAPI.addRectangleWithMetadata(1, 1, 1, w, x + 7, y + 10, z + 4, Blocks.stained_glass, glass1);
		WorldGenAPI.addRectangleWithMetadata(1, 1, 1, w, x + 7, y + 10, z + 7, Blocks.stained_glass, glass1);
		WorldGenAPI.addRectangleWithMetadata(1, 1, 1, w, x + 7, y + 10, z + 10, Blocks.stained_glass, glass1);
		WorldGenAPI.placeChestWithContents(w, x + 7, y, z + 7, 1, false, (ItemStack[])null);
		return true;
	}
}