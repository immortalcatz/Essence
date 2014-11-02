package net.slayer.api.block;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.slayer.api.EnumMaterialTypes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModGlass extends BlockMod {
		
	public BlockModGlass(String name, float hardness) {
		super(EnumMaterialTypes.GLASS, name, hardness);
	}
	
	@Override
    public int getRenderBlockPass() {
        return 1;
    }
    
	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube() {
    	return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side){
        Block i1 = blockAccess.getBlock(x, y, z);
        return i1 == this ? false : super.shouldSideBeRendered(blockAccess, x, y, z, side);
    }
}