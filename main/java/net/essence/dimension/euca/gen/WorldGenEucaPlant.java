package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEucaPlant extends WorldGenerator {

	private Block gen;
	
	public WorldGenEucaPlant(Block plant) {
		gen = plant;
	}
	
	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		for(int l = 0; l < 10; ++l) {
			int i1 = pos.getX() + r.nextInt(8) - r.nextInt(8);
			int j1 = pos.getY() + r.nextInt(4) - r.nextInt(4);
			int k1 = pos.getZ() + r.nextInt(8) - r.nextInt(8);
			if(w.isAirBlock(new BlockPos(i1, j1, k1)) && (!w.provider.getHasNoSky() || j1 < 255) && w.getBlockState(pos.offsetDown()) == EssenceBlocks.eucaGrass)
				w.setBlockState(new BlockPos(i1, j1, k1), EssenceBlocks.eucaTallGrass.getDefaultState(), 2);
		}
		return true;
	}
}