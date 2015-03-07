package net.essence.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.block.BlockMod;

public class BlockBrittleIce extends BlockMod {

	public BlockBrittleIce() {
		super(EnumMaterialTypes.ICE, "brittleIce", 0.3F);
		setTranslucent();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean shouldSideBeRendered(IBlockAccess iba, BlockPos pos, EnumFacing side) {
		Block block = iba.getBlockState(pos).getBlock();
        return block == this ? false : super.shouldSideBeRendered(iba, pos, side);
    }

}
