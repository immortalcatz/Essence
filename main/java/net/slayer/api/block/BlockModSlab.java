package net.slayer.api.block;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.items.block.ItemBlockSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockModSlab extends BlockSlab {

	public static final String[] types = new String[] {"euca", "depths"};
	private boolean full;

	public BlockModSlab(boolean full) {
		super(Material.wood);
		if(!full) this.setCreativeTab(EssenceTabs.decoraton);
		setHardness(2.0F);
		setStepSound(soundTypeWood);
		setLightOpacity(255);
		this.full = full;
		String s = "";
		if(full) s = "double";
		else s = "half";
		GameRegistry.registerBlock(this, ItemBlockSlab.class, s + "EssenceSlab");
	}

	@Override
	public void onBlockAdded(World w, BlockPos pos, IBlockState s) {

	}

	@Override
	public boolean isDouble() {
		return false;
	}

	@Override
	public String getUnlocalizedName(int meta) {
		return null;
	}

	@Override
	public IProperty getVariantProperty() {
		return null;
	}

	@Override
	public Object getVariant(ItemStack stack) {
		return null;
	}
}