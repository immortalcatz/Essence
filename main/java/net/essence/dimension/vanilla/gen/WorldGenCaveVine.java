package net.essence.dimension.vanilla.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.slayer.api.block.BlockModVine;

public class WorldGenCaveVine extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getZ(), y = pos.getY(), z = pos.getZ();
		int l = x;
		for(int i1 = z; y < 70; ++y) {
			if(w.isAirBlock(pos)) {
				for(int j1 = 2; j1 <= 5; ++j1) {
					EnumFacing[] aenumfacing = EnumFacing.Plane.HORIZONTAL.facings();
					int i = aenumfacing.length;
					for (int j = 0; j < i; ++j) {
						EnumFacing enumfacing = aenumfacing[j];
						if(EssenceBlocks.caveVine.canPlaceBlockOnSide(w, pos, enumfacing)) {
	                        IBlockState iblockstate = EssenceBlocks.caveVine.getDefaultState().withProperty(BlockModVine.NORTH, Boolean.valueOf(enumfacing == EnumFacing.NORTH)).withProperty(BlockModVine.EAST, Boolean.valueOf(enumfacing == EnumFacing.EAST)).withProperty(BlockModVine.SOUTH, Boolean.valueOf(enumfacing == EnumFacing.SOUTH)).withProperty(BlockModVine.WEST, Boolean.valueOf(enumfacing == EnumFacing.WEST));
							w.setBlockState(pos, iblockstate, 2);
							break;
						}
					}
				}
			} else {
				x = l + r.nextInt(4) - r.nextInt(4);
				z = i1 + r.nextInt(4) - r.nextInt(4);
			}
		}
		return true;
	}
}