package net.essence.blocks;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.render.BaseBlockRender;
import net.essence.client.render.BlockRenderInfo;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.slayer.api.block.BlockMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModOre extends BlockMod {

	public BlockModOre(String name, float hardness) {
		super(name, hardness);
	}
	
	@SideOnly(Side.CLIENT)
	BlockRenderInfo renderInfo;
	public int boostBrightnessLow;
	public int boostBrightnessHigh;
	public boolean enhanceBrightness;
	
	@SideOnly(Side.CLIENT)
	public BlockRenderInfo getRendererInstance() {
		if ( renderInfo != null )
			return renderInfo;

		try {
			return renderInfo = new BlockRenderInfo(getRenderer().newInstance());
		}
		catch (Throwable t) {
			throw new RuntimeException( t );
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Class<? extends BaseBlockRender> getRenderer() {
		return BaseBlockRender.class;
	}
	
	@Override
	public int getMixedBrightnessForBlock(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		int j1 = 500;//super.getMixedBrightnessForBlock(par1iBlockAccess, par2, par3, par4);
		if(enhanceBrightness) {
			j1 = Math.max( j1 >> 20, j1 >> 4);
			if(j1 > 4) j1 += boostBrightnessHigh;
			else j1 += boostBrightnessLow;
			if(j1 > 15) j1 = 15;
			return j1 << 20 | j1 << 4;
		}
		return j1;
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2, int par3) {
		if(this == EssenceBlocks.ashual) return EssenceItems.ash;
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int getRenderType() {
		return this == EssenceBlocks.celestiumOre || this == EssenceBlocks.shadiumOre || this == EssenceBlocks.luniumOre || this == EssenceBlocks.flairiumOre || 
				this == EssenceBlocks.celestiumBlock || this == EssenceBlocks.shadiumBlock || this == EssenceBlocks.luniumBlock || this == EssenceBlocks.flairiumBlock 
						 || this == EssenceBlocks.hellstoneBlock || this == EssenceBlocks.hellstoneOre ? 50 : 0;
	}
}