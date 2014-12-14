package net.slayer.api.block;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModLog extends BlockRotatedPillar {
	protected String name;

	public BlockModLog(String name) {
		super(Material.wood);
		this.name = name;
		setUnlocalizedName(name);
		setHardness(3.0F);
		setCreativeTab(EssenceTabs.blocks);
		setStepSound(soundTypeWood);
		EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public boolean isWood(IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		/*int var10 = meta & 3;
		byte var11 = 0;
		switch (side) {
		case 1:
			var11 = 0;
			break;
		case 2:
			var11 = 1;
		case 3:
			var11 = 8;
			break;
		case 4: 
			var11 = 4;
			break;
		case 5:
			var11 = 4;
			break;
		}*/
		return worldIn.getBlockState(pos).getBlock().getStateFromMeta(meta);
	}
}