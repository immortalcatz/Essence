package net.essence.blocks;

import java.util.List;
import java.util.Random;

import net.essence.EssenceItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.block.BlockMod;

public class BlockGemBlock extends BlockMod {

	public BlockGemBlock(String name) {
		super(EnumMaterialTypes.GLASS, name, 0.4F);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> drops = super.getDrops(world, pos, state, fortune);
		Item gem = EssenceItems.greenGem;
		switch(rand.nextInt(4)) {
		case 0:
			gem = EssenceItems.greenGem;
			break;
		case 1:
			gem = EssenceItems.purpleGem;
			break;
		case 2:
			gem = EssenceItems.blueGem;
			break;
		case 3:
			gem = EssenceItems.yellowGem;
			break;
		}
		drops.add(new ItemStack(gem, rand.nextInt(4) + 1));
		return drops;
	}
}