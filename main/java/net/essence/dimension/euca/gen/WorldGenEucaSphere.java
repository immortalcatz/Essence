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
		if(!WorldGenAPI.isAirBlocks(w, 18, p.getX(), p.getY(), p.getZ()))
			return false;
		WorldGenAPI.addOreWorldSphere(w, 16, p.getX(), p.getY(), p.getZ(), EssenceBlocks.eucaStone, EssenceBlocks.eucaDirt, EssenceBlocks.eucaGrass, 30, EssenceBlocks.celestiumOre);
		return true;
	}
}