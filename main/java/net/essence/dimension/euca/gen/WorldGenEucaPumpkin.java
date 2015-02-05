package net.essence.dimension.euca.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.blocks.BlockEucaPumpkin;
import net.essence.util.Helper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEucaPumpkin extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random r, BlockPos b) {
		for(int i = 0; i < 30; ++i) {
			BlockPos blockpos1 = b.add(r.nextInt(8) - r.nextInt(8), r.nextInt(4) - r.nextInt(4), r.nextInt(8) - r.nextInt(8));
			if(worldIn.isAirBlock(blockpos1) && worldIn.getBlockState(blockpos1.down()).getBlock() == EssenceBlocks.eucaGrass)
				worldIn.setBlockState(blockpos1, EssenceBlocks.eucaPumpkin.getDefaultState().withProperty(BlockEucaPumpkin.FACING, EnumFacing.Plane.HORIZONTAL.random(r)), 2);
		}
		return true;
	}
}