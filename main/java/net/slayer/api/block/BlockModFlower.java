package net.slayer.api.block;

import static net.minecraftforge.common.EnumPlantType.Plains;

import java.util.Random;

import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.slayer.api.EnumMaterialTypes;

public class BlockModFlower extends BlockMod implements IPlantable {

	public BlockModFlower(String name) {
		super(EnumMaterialTypes.PLANT, name, 0.0F);
		this.setTickRandomly(true);
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
		this.setCreativeTab(EssenceTabs.decoraton);
	}
	
    public boolean canBlockStay(World w, BlockPos p, IBlockState s) {
        return w.getBlockState(p.down()).getBlock().canSustainPlant(w, p, EnumFacing.UP, this);
    }
	
	@Override
	public boolean canPlaceBlockAt(World w, BlockPos p) {
		return super.canPlaceBlockAt(w, p) && this.canBlockStay(w, p, getDefaultState());
	}
	
	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
		this.checkAndDropBlock(worldIn, pos, state);
	}

	@Override
	public void updateTick(World w, BlockPos pos, IBlockState s, Random p_149674_5_) {
		this.checkAndDropBlock(w, pos, s);
	}

	protected void checkAndDropBlock(World w, BlockPos pos, IBlockState s) {
		if (!this.canBlockStay(w, pos, s))  {
            this.dropBlockAsItem(w, pos, s, 0);
            w.setBlockState(pos, Blocks.air.getDefaultState(), 3);
        }
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World p_149668_1_, BlockPos pos, IBlockState s) {
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
}