package net.essence.blocks;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;

public class BlockGlowshroom extends Block {

	public BlockGlowshroom(String name, boolean top) {
		super(EnumMaterialTypes.PLANT.getMaterial());
		setStepSound(EnumMaterialTypes.PLANT.getSound());
		setCreativeTab(EssenceTabs.decoraton);
		setHardness(0.0F);
		setLightLevel(0.6F);
		setTickRandomly(true);
		setUnlocalizedName(name);
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		return null;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.TRANSLUCENT;
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
	public int getMixedBrightnessForBlock(IBlockAccess worldIn, BlockPos pos) {
		return 900;
	}

	@Override
	public void onBlockDestroyedByPlayer(World w, BlockPos pos, IBlockState state) {
		if(w.getBlockState(pos.up()) == EssenceBlocks.glowshroomBottom.getDefaultState() || w.getBlockState(pos.up()) == EssenceBlocks.glowshroomTop.getDefaultState()) 
			w.setBlockState(pos.up(), Blocks.air.getDefaultState());
		if(w.getBlockState(pos.down()) == EssenceBlocks.glowshroomBottom.getDefaultState() || w.getBlockState(pos.down()) == EssenceBlocks.glowshroomTop.getDefaultState()) 
			w.setBlockState(pos.down(), Blocks.air.getDefaultState());
	}

	@Override
	public boolean canPlaceBlockAt(World w, BlockPos pos) {
		return w.getBlockState(pos.down()) == Blocks.stone.getDefaultState() || w.getBlockState(pos.down()) == EssenceBlocks.glowshroomBottom.getDefaultState() || w.getBlockState(pos.down()) == EssenceBlocks.glowshroomTop.getDefaultState();
	}

	@Override
	public void updateTick(World w, BlockPos pos, IBlockState s, Random r) {
		this.checkAndDropBlock(w, pos, s);
	}

	public void checkAndDropBlock(World w, BlockPos pos, IBlockState s) {
		if(!this.canBlockStay(w, pos)) {
			this.dropBlockAsItem(w, pos, s, 0);
			w.setBlockState(pos, Blocks.air.getDefaultState(), 3);
		}
	}

	public boolean canBlockStay(World w, BlockPos pos) {
		return canPlaceBlockAt(w, pos);
	}
}