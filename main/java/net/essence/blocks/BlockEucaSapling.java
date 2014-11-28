package net.essence.blocks;

import java.util.Random;

import net.essence.dimension.euca.gen.trees.WorldGenBigEucaTree;
import net.essence.dimension.euca.gen.trees.WorldGenSmallEucaTree;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.block.BlockMod;

public class BlockEucaSapling extends BlockMod implements IGrowable, IPlantable {

	public BlockEucaSapling(String name) {
		super(EnumMaterialTypes.PLANT, name, 0.0F);
		this.setTickRandomly(true);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}

	@Override
	public void updateTick(World w, BlockPos pos, IBlockState s, Random r)  {
		if(!w.isRemote) {
			super.updateTick(w, pos, s, r);
			if(w.getLightFromNeighbors(pos.offsetUp()) >= 9 && r.nextInt(9) == 0)
				this.generate(w, pos, r);
		}
	}

	private void generate(World w, BlockPos pos, Random r) {
		Object tree = new WorldGenBigEucaTree();
		switch(r.nextInt(2)) {
		case 0:
			tree = new WorldGenBigEucaTree();
			break;
		case 1:
			tree = new WorldGenSmallEucaTree();
			break;
		}
		((WorldGenerator)tree).generate(w, r, pos);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return super.canPlaceBlockAt(worldIn, pos) && this.canBlockStay(worldIn, pos);
	}

	public boolean canBlockStay(World w, BlockPos pos) {
		return w.getBlockState(pos.offsetDown()).getBlock().canSustainPlant(w, new BlockPos(pos.offsetDown()), EnumFacing.UP, this);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		return null;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return world.getBlockState(pos);
	}

	@Override
	public boolean isStillGrowing(World worldIn, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_) {
		return true;
	}

	@Override
	public void grow(World w, Random r, BlockPos p, IBlockState p_176474_4_) {
		generate(w, p, r);
	}
}