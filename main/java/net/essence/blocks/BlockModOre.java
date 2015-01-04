package net.essence.blocks;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.render.particles.OreParticleFX;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.block.BlockMod;

public class BlockModOre extends BlockMod {

	public BlockModOre(String name) {
		super(name);
	}

	public int boostBrightnessLow;
	public int boostBrightnessHigh;
	public boolean enhanceBrightness;

	/*@Override
	public boolean addHitEffects(World w, MovingObjectPosition target, EffectRenderer effectRenderer) {
		int x = target.getBlockPos().getX(), y = target.getBlockPos().getY(), z = target.getBlockPos().getZ();
		renderParticle(w, x, y, z);
		Random random = new Random();
		Block particle = Blocks.stone;
		if(this == EssenceBlocks.celestiumOre)
			particle = EssenceBlocks.eucaStone;
		if(this == EssenceBlocks.flairiumOre)
			particle = EssenceBlocks.depthsStone;
		if(this == EssenceBlocks.hellstoneOre)
			particle = Blocks.netherrack;
		double d0 = 0.0625D;
		for(int l = 0; l < 2; ++l) {
			double d1 = (double)((float)x + random.nextFloat());
			double d2 = (double)((float)y + random.nextFloat());
			double d3 = (double)((float)z + random.nextFloat());
			if(l == 0 && !w.getBlockState(new BlockPos(x, y + 1, z)).getBlock().isOpaqueCube()) d2 = (double)(y + 1) + d0;
			if(l == 1 && !w.getBlockState(new BlockPos(x, y - 1, z)).getBlock().isOpaqueCube()) d2 = (double)(y + 0) - d0;
			if(l == 2 && !w.getBlockState(new BlockPos(x, y, z + 1)).getBlock().isOpaqueCube()) d3 = (double)(z + 1) + d0;    
			if(l == 3 && !w.getBlockState(new BlockPos(x, y, z - 1)).getBlock().isOpaqueCube()) d3 = (double)(z + 0) - d0;
			if(l == 4 && !w.getBlockState(new BlockPos(x + 1, y, z)).getBlock().isOpaqueCube()) d1 = (double)(x + 1) + d0;
			if(l == 5 && !w.getBlockState(new BlockPos(x - 1, y, z)).getBlock().isOpaqueCube()) d1 = (double)(x + 0) - d0;
			if(d1 < (double)x || d1 > (double)(x + 1) || d2 < 0.0D || d2 > (double)(y + 1) || d3 < (double)z || d3 > (double)(z + 1)) {
				w.spawnParticle(EnumParticleTypes.BLOCK_DUST, d1, d2, d3, 0, 0, 0, 0);
			}
		}
		return super.addHitEffects(w, target, effectRenderer);
	}

	@Override
	public boolean addDestroyEffects(World w, BlockPos target, EffectRenderer effectRenderer) {
		int x = target.getX(), y = target.getY(), z = target.getZ();
		renderParticle(w, x, y, z);
		Random random = new Random();
		Block particle = Blocks.stone;
		if(this == EssenceBlocks.celestiumOre)
			particle = EssenceBlocks.eucaStone;
		if(this == EssenceBlocks.flairiumOre)
			particle = EssenceBlocks.depthsStone;
		if(this == EssenceBlocks.hellstoneOre)
			particle = Blocks.netherrack;
		double d0 = 0.0625D;
		for(int l = 0; l < 2; ++l) {
			double d1 = (double)((float)x + random.nextFloat());
			double d2 = (double)((float)y + random.nextFloat());
			double d3 = (double)((float)z + random.nextFloat());
			if(l == 0 && !w.getBlockState(new BlockPos(x, y + 1, z)).getBlock().isOpaqueCube()) d2 = (double)(y + 1) + d0;
			if(l == 1 && !w.getBlockState(new BlockPos(x, y - 1, z)).getBlock().isOpaqueCube()) d2 = (double)(y + 0) - d0;
			if(l == 2 && !w.getBlockState(new BlockPos(x, y, z + 1)).getBlock().isOpaqueCube()) d3 = (double)(z + 1) + d0;    
			if(l == 3 && !w.getBlockState(new BlockPos(x, y, z - 1)).getBlock().isOpaqueCube()) d3 = (double)(z + 0) - d0;
			if(l == 4 && !w.getBlockState(new BlockPos(x + 1, y, z)).getBlock().isOpaqueCube()) d1 = (double)(x + 1) + d0;
			if(l == 5 && !w.getBlockState(new BlockPos(x - 1, y, z)).getBlock().isOpaqueCube()) d1 = (double)(x + 0) - d0;
			if(d1 < (double)x || d1 > (double)(x + 1) || d2 < 0.0D || d2 > (double)(y + 1) || d3 < (double)z || d3 > (double)(z + 1)) {
				w.spawnParticle(EnumParticleTypes.BLOCK_DUST, d1, d2, d3, 0, 0, 0, 0);
			}
		}
		return super.addDestroyEffects(w, target, effectRenderer);
	}*/
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random r) {
		renderParticle(worldIn, pos.getX(), pos.getY(), pos.getZ());
	}

	@SideOnly(Side.CLIENT)
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
		if(this == EssenceBlocks.enderilliumOre || this == EssenceBlocks.enderilliumBlock) {
			r = 1.0F;
			g = 0.0F;
			b = 1.0F;
		}
		Random random = w.rand;
		double d0 = 0.0625D;
		for(int l = 0; l < 6; ++l) {
			double d1 = (double)((float)x + random.nextFloat());
			double d2 = (double)((float)y + random.nextFloat());
			double d3 = (double)((float)z + random.nextFloat());
			if(l == 0 && !w.getBlockState(new BlockPos(x, y + 1, z)).getBlock().isOpaqueCube()) d2 = (double)(y + 1) + d0;
			if(l == 1 && !w.getBlockState(new BlockPos(x, y - 1, z)).getBlock().isOpaqueCube()) d2 = (double)(y + 0) - d0;
			if(l == 2 && !w.getBlockState(new BlockPos(x, y, z + 1)).getBlock().isOpaqueCube()) d3 = (double)(z + 1) + d0;    
			if(l == 3 && !w.getBlockState(new BlockPos(x, y, z - 1)).getBlock().isOpaqueCube()) d3 = (double)(z + 0) - d0;
			if(l == 4 && !w.getBlockState(new BlockPos(x + 1, y, z)).getBlock().isOpaqueCube()) d1 = (double)(x + 1) + d0;
			if(l == 5 && !w.getBlockState(new BlockPos(x - 1, y, z)).getBlock().isOpaqueCube()) d1 = (double)(x + 0) - d0;
			if(d1 < (double)x || d1 > (double)(x + 1) || d2 < 0.0D || d2 > (double)(y + 1) || d3 < (double)z || d3 > (double)(z + 1)) {
				OreParticleFX var20 = new OreParticleFX(w, d1, d2, d3, r, g, b);
				FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
			}
		}
	}
	
	@Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if(fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
            int j = random.nextInt(fortune + 2) - 1;
            if(j < 0) j = 0; 
            return this.quantityDropped(random) * (j + 1);
        } else {
            return this.quantityDropped(random);
        }
    }
	
	@Override
	public int getMixedBrightnessForBlock(IBlockAccess worldIn, BlockPos pos) {
		/*if(this == EssenceBlocks.celestiumOre || this == EssenceBlocks.shadiumOre || this == EssenceBlocks.luniumOre || this == EssenceBlocks.flairiumOre || 
				this == EssenceBlocks.celestiumBlock || this == EssenceBlocks.shadiumBlock || this == EssenceBlocks.luniumBlock || this == EssenceBlocks.flairiumBlock 
				|| this == EssenceBlocks.hellstoneBlock || this == EssenceBlocks.hellstoneOre || this == EssenceBlocks.sapphireOre) {
			return 1000;
		}*/
		return super.getMixedBrightnessForBlock(worldIn, pos);
	}

	@Override
	public Item getItemDropped(IBlockState par1, Random par2, int par3) {
		if(this == EssenceBlocks.ashual) return EssenceItems.ash;
		if(this == EssenceBlocks.sapphireOre) return EssenceItems.sapphire;
		if(this == EssenceBlocks.enderilliumOre) return EssenceItems.enderilliumShard;
		return Item.getItemFromBlock(this);
	}

	/*@Override
	public int getRenderType() {
		return this == EssenceBlocks.celestiumOre || this == EssenceBlocks.shadiumOre || this == EssenceBlocks.luniumOre || this == EssenceBlocks.flairiumOre || 
				this == EssenceBlocks.celestiumBlock || this == EssenceBlocks.shadiumBlock || this == EssenceBlocks.luniumBlock || this == EssenceBlocks.flairiumBlock 
				|| this == EssenceBlocks.hellstoneBlock || this == EssenceBlocks.hellstoneOre || this == EssenceBlocks.sapphireOre ? 172 : 0;
	}*/
}