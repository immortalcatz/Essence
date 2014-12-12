package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenEucaSphere extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos p) {
		int size = 16 + r.nextInt(15);
		if(!WorldGenAPI.isAirBlocks(w, size + 5, p.getX(), p.getY(), p.getZ()))
			return false;
		WorldGenAPI.addOreWorldSphere(w, size, p.getX(), p.getY(), p.getZ(), EssenceBlocks.eucaStone, EssenceBlocks.eucaDirt, EssenceBlocks.eucaGrass, 40, EssenceBlocks.celestiumOre);
		int y = r.nextInt(250); int x = p.getX() + r.nextInt(16) + 8; int z = p.getZ() + r.nextInt(16) + 8;
		(new WorldGenEucaPlant(EssenceBlocks.eucaTallGrass)).generate(w, r, new BlockPos(x, y, z));
		y = r.nextInt(250); x = p.getX() + r.nextInt(16) + 8; z = p.getZ() + r.nextInt(16) + 8;
		(new WorldGenEucaPlant(EssenceBlocks.eucaGreenFlower)).generate(w, r, new BlockPos(x, y, z));
		y = r.nextInt(250); x = p.getX() + r.nextInt(16) + 8; z = p.getZ() + r.nextInt(16) + 8;
		(new WorldGenEucaPlant(EssenceBlocks.eucaBlueFlower)).generate(w, r, new BlockPos(x, y, z));
		return true;
	}
}