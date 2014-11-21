package net.essence.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import net.slayer.api.block.BlockMod;

public class BlockChristmasLights extends BlockMod implements IShearable {

	public BlockChristmasLights(String name) {
		super(EnumMaterialTypes.LEAVES, name, 0.2F);
		setLightLevel(0.35F);
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2, int par3) {
		return SlayerAPI.toItem(this);
	}
	
	@Override
	public int getRenderBlockPass() {
		return 1;
	}
	
	@Override
	public int getRenderType() {
		return EssenceBlocks.mossyEssenceStone.getRenderType();
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(this));
		return stack;
	}
}