package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.worldgen.WorldGenAPI;

public class WorldGenEucaSphere extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		if(!WorldGenAPI.isAirBlocks(w, 18, x, y, z))
			return false;
		WorldGenAPI.addOreWorldSphere(w, 16, x, y, z, EssenceBlocks.eucaStone, EssenceBlocks.eucaDirt, EssenceBlocks.eucaGrass, 30, EssenceBlocks.celestiumOre);
		return true;
	}
}