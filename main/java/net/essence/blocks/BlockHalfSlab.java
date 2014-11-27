package net.essence.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import net.essence.EssenceTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;

public class BlockHalfSlab extends BlockSlab {

	private Block full;
	
	public BlockHalfSlab(String name, Block full) {
		super(false, full.getMaterial());
		setCreativeTab(EssenceTabs.blocks);
		setBlockName(name);
		this.full = full;
		setLightOpacity(255);
		setHardness(full.getBlockHardness(null, 0, 0, 0));
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public IIcon getIcon(int s, int m) {
		return full.getBlockTextureFromSide(s);
	}

	@Override
	public String func_150002_b(int i) {
		return null;
	}
	
	@Override
	public Item getItemDropped(int i, Random r, int j) {
		return SlayerAPI.toItem(this);
	}
	
	@Override
	public Item getItem(World w, int x, int y, int z) {
		return SlayerAPI.toItem(this);
	}
}