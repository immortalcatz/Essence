package net.essence.blocks;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.render.BaseBlockRender;
import net.essence.client.render.BlockRenderInfo;
import net.essence.client.render.particles.EntityBoilPotalFX;
import net.essence.client.render.particles.OreParticleFX;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.slayer.api.block.BlockMod;
import cpw.mods.fml.client.FMLClientHandler;
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
		if( renderInfo != null )
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
	public boolean addHitEffects(World w, MovingObjectPosition target, EffectRenderer effectRenderer) {
		int x = target.blockX, y = target.blockY, z = target.blockZ;
		renderParticle(w, x, y, z);
		return super.addHitEffects(w, target, effectRenderer);
	}

	@Override
	public boolean addDestroyEffects(World w, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
		renderParticle(w, x, y, z);
		return super.addDestroyEffects(w, x, y, z, meta, effectRenderer);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World w, int x, int y, int z, Random rand) {
        renderParticle(w, x, y, z);
	}
	
    private void renderParticle(World w, int x, int y, int z) {
    	float r = 0.0F, g = 0.0F, b = 0.0F;
		if(this == EssenceBlocks.celestiumOre || this == EssenceBlocks.celestiumBlock) {
			r = 0.0F;
			g = 1.0F;
			b = 0.0F;
		}
		if(this == EssenceBlocks.shadiumOre || this == EssenceBlocks.shadiumBlock) {
			r = 0.0F;
			g = 0.0F;
			b = 1.0F;
		}
		if(this == EssenceBlocks.luniumOre || this == EssenceBlocks.luniumBlock) {
			r = 1.0F;
			g = 1.0F;
			b = 0.0F;
		}
		if(this == EssenceBlocks.flairiumOre || this == EssenceBlocks.flairiumBlock) {
			r = 1.0F;
			g = 0.5F;
			b = 0.0F;
		}
		if(this == EssenceBlocks.hellstoneBlock || this == EssenceBlocks.hellstoneOre) {
			r = 1.0F;
			g = 0.0F;
			b = 0.0F;
		}
		if(this == EssenceBlocks.sapphireOre || this == EssenceBlocks.sapphireBlock) {
			r = 0.5F;
			g = 0.0F;
			b = 1.0F;
		}
        Random random = w.rand;
        double d0 = 0.0625D;
        for(int l = 0; l < 6; ++l) {
            double d1 = (double)((float)x + random.nextFloat());
            double d2 = (double)((float)y + random.nextFloat());
            double d3 = (double)((float)z + random.nextFloat());
            if(l == 0 && !w.getBlock(x, y + 1, z).isOpaqueCube()) d2 = (double)(y + 1) + d0;
            if(l == 1 && !w.getBlock(x, y - 1, z).isOpaqueCube()) d2 = (double)(y + 0) - d0;
            if(l == 2 && !w.getBlock(x, y, z + 1).isOpaqueCube()) d3 = (double)(z + 1) + d0;    
            if(l == 3 && !w.getBlock(x, y, z - 1).isOpaqueCube()) d3 = (double)(z + 0) - d0;
            if(l == 4 && !w.getBlock(x + 1, y, z).isOpaqueCube()) d1 = (double)(x + 1) + d0;
            if(l == 5 && !w.getBlock(x - 1, y, z).isOpaqueCube()) d1 = (double)(x + 0) - d0;
            if(d1 < (double)x || d1 > (double)(x + 1) || d2 < 0.0D || d2 > (double)(y + 1) || d3 < (double)z || d3 > (double)(z + 1)) {
            	OreParticleFX var20 = new OreParticleFX(w, d1, d2, d3, r, g, b);
                FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
            }
        }
    }


	@Override
	public int getMixedBrightnessForBlock(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		int j1 = 500;
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
		if(this == EssenceBlocks.sapphireOre) return EssenceItems.sapphire;
		return Item.getItemFromBlock(this);
	}

	@Override
	public int getRenderType() {
		return this == EssenceBlocks.celestiumOre || this == EssenceBlocks.shadiumOre || this == EssenceBlocks.luniumOre || this == EssenceBlocks.flairiumOre || 
				this == EssenceBlocks.celestiumBlock || this == EssenceBlocks.shadiumBlock || this == EssenceBlocks.luniumBlock || this == EssenceBlocks.flairiumBlock 
				|| this == EssenceBlocks.hellstoneBlock || this == EssenceBlocks.hellstoneOre || this == EssenceBlocks.sapphireOre ? 50 : 0;
	}
}