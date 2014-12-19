package net.essence.dimension.vanilla.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.block.BlockModVine;

public class WorldGenCaveVine extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos p) {
		for(int i1 = 0; i1 < 100; i1++) {
			EnumFacing[] aenumfacing = EnumFacing.Plane.HORIZONTAL.facings();
			if(w.isAirBlock(p)) {
				int i = aenumfacing.length;
				for(int j = 0; j < i; ++j) {
					EnumFacing enumfacing = aenumfacing[j];
					if(EssenceBlocks.caveVine.canPlaceBlockOnSide(w, p, enumfacing)) {
						IBlockState iblockstate = EssenceBlocks.caveVine.getDefaultState().withProperty(BlockModVine.NORTH, Boolean.valueOf(enumfacing == EnumFacing.NORTH)).withProperty(BlockModVine.EAST, Boolean.valueOf(enumfacing == EnumFacing.EAST)).withProperty(BlockModVine.SOUTH, Boolean.valueOf(enumfacing == EnumFacing.SOUTH)).withProperty(BlockModVine.WEST, Boolean.valueOf(enumfacing == EnumFacing.WEST));
						w.setBlockState(p, iblockstate, 2);
						break;
					}
				}
			}
		}
		return true;
	}
}