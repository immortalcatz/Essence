package net.essence.blocks;

import java.util.Random;

import net.essence.dimension.euca.gen.trees.WorldGenBigEucaTree;
import net.essence.dimension.euca.gen.trees.WorldGenSmallEucaTree;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
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
	public void updateTick(World w, int x, int y, int z, Random r)  {
		if(!w.isRemote) {
			super.updateTick(w, x, y, z, r);

			if(w.getBlockLightValue(x, y + 1, z) >= 9 && r.nextInt(12) == 0)
				this.generate(w, x, y, z, r);
		}
	}
	
	@Override
	public void updateTick(World w, BlockPos pos, IBlockState state, Random r) {
		if(!w.isRemote) {
			super.updateTick(w, pos, state, r);
			if(w.getLightFromNeighbors(pos.offsetUp()) >= 9 && rand.nextInt(9) == 0) 
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
	public boolean canPlaceBlockAt(World w, BlockPos pos) {
		return super.canPlaceBlockAt(w, pos) && this.canBlockStay(w, pos);
	}

	@Override
	public boolean canBlockStay(World w, BlockPos pos) {
		return w.getBlock(x, y - 1, z).canSustainPlant(w, x, y - 1, z, ForgeDirection.UP, this);
	}

	
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
		return null;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 1;
	}

	@Override
	public boolean func_149851_a(World w, int x, int y, int z, boolean b) {
		return true;
	}

	@Override
	public boolean func_149852_a(World w, Random r, int x, int y, int z) {
		return (double)r.nextFloat() < 0.45D;
	}

	@Override
	public void func_149853_b(World w, Random r, int x, int y, int z) {
		generate(w, x, y, z, r);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Plains;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return this;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.getDefaultState();
	}

	@Override
	public boolean isStillGrowing(World worldIn, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_) {
		return false;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_) {
		return false;
	}

	@Override
	public void grow(World worldIn, Random p_176474_2_, BlockPos p_176474_3_, IBlockState p_176474_4_) {
		
	}
}