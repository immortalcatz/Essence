package net.essence.blocks.base;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.render.particles.OreParticleFX;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.block.BlockMod;

public class BlockModOre extends BlockMod {

	public BlockModOre(String name, String finalName) {
		super(name, finalName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random r) {
		renderParticle(worldIn, pos.getX(), pos.getY(), pos.getZ());
	}

	@SideOnly(Side.CLIENT)
	private void renderParticle(World w, int x, int y, int z) {
		float r = 0.0F, g = 0.0F, b = 0.0F;
		if(this == EssenceBlocks.celestiumOre || this == EssenceBlocks.celestiumBlock || this == EssenceBlocks.orbaditeOre) {
			r = 0.0F;
			g = 1.0F;
			b = 0.0F;
		}
		if(this == EssenceBlocks.shadiumOre || this == EssenceBlocks.shadiumBlock || this == EssenceBlocks.gorbiteOre || this == EssenceBlocks.desOre || this == EssenceBlocks.koriteOre) {
			r = 0.0F;
			g = 0.0F;
			b = 1.0F;
		}
		if(this == EssenceBlocks.luniumOre || this == EssenceBlocks.luniumBlock) {
			r = 1.0F;
			g = 1.0F;
			b = 0.0F;
		}
		if(this == EssenceBlocks.flairiumOre || this == EssenceBlocks.flairiumBlock || this == EssenceBlocks.storonOre) {
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
		if(this == EssenceBlocks.enderilliumOre || this == EssenceBlocks.enderilliumBlock || this == EssenceBlocks.mekyumOre) {
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
            return 1;
        }
    }

	@Override
	public Item getItemDropped(IBlockState par1, Random par2, int par3) {
		if(this == EssenceBlocks.ashualOre) return EssenceItems.ash;
		if(this == EssenceBlocks.sapphireOre) return EssenceItems.sapphire;
		if(this == EssenceBlocks.enderilliumOre) return EssenceItems.enderilliumShard;
		if(this == EssenceBlocks.gorbiteOre) return EssenceItems.gorbiteGem;
		return Item.getItemFromBlock(this);
	}
}