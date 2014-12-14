package net.essence.blocks;

import java.util.Random;

import net.essence.Essence;
import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityEnrichedTable;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

public class BlockEnrichedEnchantmentTable extends BlockContainer {

	public BlockEnrichedEnchantmentTable(String name) {
		super(Material.rock);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
		setCreativeTab(EssenceTabs.blocks);
		setUnlocalizedName("enrichedEnchantmentTable");
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public boolean isFullCube() {
		return false;
	}
	
	@Override
	public void randomDisplayTick(World par1World, BlockPos pos, IBlockState state, Random par5Random) {
		int par2 = pos.getX(), par3 = pos.getY(), par4 = pos.getX();
		super.randomDisplayTick(par1World, pos, state, par5Random);
		for(int var6 = par2 - 2; var6 <= par2 + 2; ++var6) {
			for(int var7 = par4 - 2; var7 <= par4 + 2; ++var7) {
				if(var6 > par2 - 2 && var6 < par2 + 2 && var7 == par4 - 1)  
					var7 = par4 + 2;

				if(par5Random.nextInt(16) == 0) {
					for (int var8 = par3; var8 <= par3 + 1; ++var8) {
						par1World.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5D);
					}
				}
			}
		}
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityEnrichedTable tileEntity = (TileEntityEnrichedTable)worldIn.getTileEntity(pos);
		if(!worldIn.isRemote) {
			if(tileEntity != null) {
				playerIn.openGui(Essence.instance, GuiIDs.ENRICHMENT_TABLE.ordinal(), worldIn, 0, 0, 0);
			}
			return true;
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityEnrichedTable();
	}
}