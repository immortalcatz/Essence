package net.slayer.api.block;

import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockModFence extends BlockFence {

	public BlockModFence(Block block, String name, boolean light) {
		super(SlayerAPI.PREFIX + name, block.getMaterial());
		setBlockName(name + "Fence");
		setCreativeTab(EssenceTabs.blocks);
		if(light) setLightLevel(0.5F);
		setHardness(block.getBlockHardness(null, 0, 0, 0));
		GameRegistry.registerBlock(this, name + "Fence");
		LangRegistry.addBlock(this);
	}
	
	public BlockModFence(Block b, String n) {
		this(b, n, false);
	}

	@Override
	public boolean canConnectFenceTo(IBlockAccess blockAccess, int x, int y, int z) {
		Block block = blockAccess.getBlock(x, y, z);
		return !(block instanceof BlockFence) && !(block instanceof BlockFenceGate) ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
	}
}