package net.essence.dimension.corba.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.dimension.overworld.gen.WorldGenModFlower;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenCorbaSphere extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos p) {
		int size = 16 + r.nextInt(15);
		if(!WorldGenAPI.isAirBlocks(w, size + 5, p.getX(), p.getY(), p.getZ()))
			return false;
		WorldGenAPI.addWorldSphere(w, size, p.getX(), p.getY(), p.getZ(), EssenceBlocks.corbaStone, EssenceBlocks.corbaStone, EssenceBlocks.corbaGrass);
		int y = r.nextInt(250); int x = p.getX() + r.nextInt(16) + 8; int z = p.getZ() + r.nextInt(16) + 8;
		(new WorldGenModFlower(EssenceBlocks.corbaTallGrass)).generate(w, r, new BlockPos(x, y, z));
		y = r.nextInt(250); x = p.getX() + r.nextInt(16) + 8; z = p.getZ() + r.nextInt(16) + 8;
		(new WorldGenModFlower(EssenceBlocks.corbaFlower)).generate(w, r, new BlockPos(x, y, z));
		return true;
	}
}