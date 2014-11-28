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
		GameRegistry.registerBlock(this, ItemBlockSlab.class, s + "EssenceSlabs");
	}

	/*@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase e, ItemStack i) {
		w.setBlock(x, y, z, this, i.getItemDamage(), 2);
	}*/

	public boolean isSlab(Block b) {
		return b == EssenceBlocks.halfSlab;
	}

	@Override
	public void onBlockAdded(World w, BlockPos pos, IBlockState s) {
		/*if(w.getBlockMetadata(x, y - 1, z) == 1) {
			if(w.getBlock(x, y - 1, z) == EssenceBlocks.halfSlab) {
				w.setBlock(x, y, z, Blocks.air);
				w.setBlock(x, y - 1, z, EssenceBlocks.fullSlab, 1, 2);
			}
			if(w.getBlock(x, y + 1, z) == EssenceBlocks.halfSlab) {
				w.setBlock(x, y, z, Blocks.air);
				w.setBlock(x, y + 1, z, EssenceBlocks.fullSlab, 1, 2);
			}
		}
		if(w.getBlock(x, y - 1, z) == EssenceBlocks.halfSlab) {
			w.setBlock(x, y, z, Blocks.air);
			w.setBlock(x, y - 1, z, EssenceBlocks.fullSlab);
		}
		if(w.getBlock(x, y + 1, z) == EssenceBlocks.halfSlab) {
			w.setBlock(x, y, z, Blocks.air);
			w.setBlock(x, y + 1, z, EssenceBlocks.fullSlab);
		}*/
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

	/*@Override
	public Item getItemDropped(IBlockState m, Random r, int j) {
		return new ItemStack(EssenceBlocks.halfSlab, full ? 2 : 1, m.).getItem();
	}

	@Override
	public Item getItem(World w, int x, int y, int z) {
		return isSlab(this) ? SlayerAPI.toItem(this) : SlayerAPI.toItem(EssenceBlocks.fullSlab);
	}

	@Override
	protected ItemStack createStackedBlock(int m) {
		return new ItemStack(Item.getItemFromBlock(EssenceBlocks.halfSlab), 2, m & 1);
	}

	@Override //Slab Names
	public String func_150002_b(int m) {
		return super.getUnlocalizedName() + "." + types[m];
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs c, List l) {
		for(int j = 0; j < types.length; j++)
			l.add(new ItemStack(i, 0, j));
	}*/
}