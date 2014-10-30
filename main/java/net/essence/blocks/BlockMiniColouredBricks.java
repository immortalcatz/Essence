package net.essence.blocks;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.items.ItemMiniBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockMiniColouredBricks extends Block {

	public static String[] textures = {"black", "blue", "brown", "cyan", "gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"};
	public static String[] names = {"Black", "Blue", "Brown", "Cyan", "Gray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow"};

	private IIcon[] icons = new IIcon[13];

	public static ItemStack[] crafting = new ItemStack[] {
			new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 3),
			new ItemStack(Items.dye, 1, 6), new ItemStack(Items.dye, 1, 8), new ItemStack(Items.dye, 1, 10),
			new ItemStack(Items.dye, 1, 13), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 9), 
			new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 11)};

	public BlockMiniColouredBricks() {
		super(EnumMaterialTypes.STONE.getMaterial());
		setStepSound(EnumMaterialTypes.STONE.getSound());
		setCreativeTab(EssenceTabs.decoraton);
		setHardness(2.0F);
		GameRegistry.registerBlock(this, ItemMiniBlockMetadata.class, "blockMiniColouredBricks");
	}
	
	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase e, ItemStack i) {
		w.setBlock(x, y, z, this, i.getItemDamage(), 2);
	}

	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		for(int i = 0; i < 13; i++)
			l.add(new ItemStack(it, 1, i));
	}

	@Override
	public void registerBlockIcons(IIconRegister r) {
		for(int i = 0; i < textures.length; i++)
			icons[i] = r.registerIcon(SlayerAPI.PREFIX + "bricks/mini/" + textures[i] + "_brick");
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		switch(meta) {
		case 0: return icons[0];
		case 1: return icons[1];
		case 2: return icons[2];
		case 3: return icons[3];
		case 4: return icons[4];
		case 5: return icons[5];
		case 6: return icons[6];
		case 7: return icons[7];
		case 8: return icons[8];
		case 9: return icons[9];
		case 10: return icons[10];
		case 11: return icons[11];
		case 12: return icons[12];
		}
		return icons[0];
	}
	
	@Override
	public int damageDropped(int m) {
		return m;
	}
}