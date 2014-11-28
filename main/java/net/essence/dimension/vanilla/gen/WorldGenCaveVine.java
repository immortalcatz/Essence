package net.essence.dimension.vanilla.gen;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.block.BlockVine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCaveVine extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, BlockPos pos) {
		int x = pos.getZ(), y = pos.getY(), z = pos.getZ();
		int l = x;
		for(int i1 = z; y < 40; ++y) {
			if(w.isAirBlock(pos)) {
				for(int j1 = 2; j1 <= 5; ++j1) {
					EnumFacing[] aenumfacing = EnumFacing.Plane.HORIZONTAL.facings();
					int i = aenumfacing.length;
					for (int j = 0; j < i; ++j) {
						EnumFacing enumfacing = aenumfacing[j];
						if(EssenceBlocks.caveVine.canPlaceBlockOnSide(w, pos, enumfacing)) {
							IBlockState iblockstate = EssenceBlocks.caveVine.getDefaultState().withProperty(BlockVine.field_176273_b, Boolean.valueOf(enumfacing == EnumFacing.NORTH)).withProperty(BlockVine.field_176278_M, Boolean.valueOf(enumfacing == EnumFacing.EAST)).withProperty(BlockVine.field_176279_N, Boolean.valueOf(enumfacing == EnumFacing.SOUTH)).withProperty(BlockVine.field_176280_O, Boolean.valueOf(enumfacing == EnumFacing.WEST));
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