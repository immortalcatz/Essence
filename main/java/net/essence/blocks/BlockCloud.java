package net.essence.blocks;

import net.minecraft.block.BlockCactus;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.block.BlockMod;

public class BlockCloud extends BlockMod {

	public BlockCloud(String name) {
		super(EnumMaterialTypes.WOOL, name, 0.2F);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.setInWeb();
	}
	
	@Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
	
	@Override
	public boolean isNormalCube() {
		return true;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}