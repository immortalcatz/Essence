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
import net.minecraft.util.EnumWorldBlockLayer;
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
	
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        return super.canPlaceBlockAt(worldIn, pos) && worldIn.getBlockState(pos.down()).getBlock().canSustainPlant(worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
	
	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
		this.checkAndDropBlock(worldIn, pos, state);
	}

	@Override
	public void updateTick(World w, BlockPos pos, IBlockState s, Random r) {
		this.checkAndDropBlock(w, pos, s);
	}

	protected void checkAndDropBlock(World w, BlockPos pos, IBlockState s) {
		if(!this.canBlockStay(w, pos, s))  {
            this.dropBlockAsItem(w, pos, s, 0);
            w.setBlockState(pos, Blocks.air.getDefaultState(), 3);
        }
	}

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        return !(worldIn.getBlockState(pos.down()).getBlock() == Blocks.air);
    }

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World w, BlockPos pos, IBlockState s) {
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
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return getDefaultState();
	}
}