package net.slayer.api.block;

import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.items.block.ItemBlockSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModSlab extends BlockSlab {

	public static final String[] types = new String[] {"euca", "depths"};
	public static IIcon[] icons = new IIcon[2];
	private boolean full;

	public BlockModSlab(boolean full) {
		super(full, Material.wood);
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

	@Override
	public void registerBlockIcons(IIconRegister r) {
		for(int i = 0; i < types.length; i++) {
			icons[i] = r.registerIcon(SlayerAPI.PREFIX + types[i] + "Plank");
		}
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase e, ItemStack i) {
		w.setBlock(x, y, z, this, i.getItemDamage(), 2);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int s, int m) {
		return m == 0 ? icons[0] : icons[1];
	}

	public boolean isSlab(Block b) {
		return b == EssenceBlocks.halfSlab;
	}

	@Override
	public void onBlockAdded(World w, int x, int y, int z) {
		if(w.getBlockMetadata(x, y - 1, z) == 1) {
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
		}
	}

	@Override
	public Item getItemDropped(int m, Random r, int j) {
		return new ItemStack(EssenceBlocks.halfSlab, full ? 2 : 1, m).getItem();
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
	}
}