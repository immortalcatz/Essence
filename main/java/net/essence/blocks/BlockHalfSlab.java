package net.essence.blocks;

import java.util.Random;

import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.SlayerAPI;

public class BlockHalfSlab extends BlockSlab {

	private Block full;

	public BlockHalfSlab(String name, Block full) {
		super(full.getMaterial());
		setCreativeTab(EssenceTabs.blocks);
		setUnlocalizedName(name);
		this.full = full;
		setLightOpacity(255);
		setHardness(full.getBlockHardness(null, null));
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	/*@Override
	public IIcon getIcon(int s, int m) {
		return full.getBlockTextureFromSide(s);
	}*/

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return SlayerAPI.toItem(this);
	}

	@Override
	public Item getItem(World worldIn, BlockPos pos) {
		return SlayerAPI.toItem(this);
	}

	@Override
	public String getFullSlabName(int p_150002_1_) {
		return null;
	}

	@Override
	public boolean isDouble() {
		return false;
	}

	@Override
	public IProperty func_176551_l() {
		return null;
	}

	@Override
	public Object func_176553_a(ItemStack p_176553_1_) {
		return null;
	}
}