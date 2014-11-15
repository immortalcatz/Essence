package net.essence.blocks;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.items.block.ItemStorageBlockMetadata;
import net.essence.items.block.ItemStorageBlockMetadata3;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockStorageBlocks3 extends Block {

	public static String[] names = {"cactus", "brick", "bookshelf", "glowstone", "redSand", "sand", "sponge", "soulSand", "tnt", "stone", "waterlilly"};
	public static String[] allFinalNames = {"Cactus", "Brick", "Bookshelf", "Glowstone", "Red Sand", "Sand", "Sponge", "Soul Sand", "TNT", "Stone", "Waterlilly"};
	
	private IIcon[] icons = new IIcon[12];

	public static ItemStack[] crafting = new ItemStack[] {new ItemStack(Blocks.cactus), new ItemStack(Blocks.brick_block), new ItemStack(Blocks.bookshelf), new ItemStack(Blocks.glowstone), new ItemStack(Blocks.sand, 1, 1)
	, new ItemStack(Blocks.sand), new ItemStack(Blocks.sponge), new ItemStack(Blocks.soul_sand), new ItemStack(Blocks.tnt), new ItemStack(Blocks.stone)
	, new ItemStack(Blocks.waterlily)};
	
	public static ItemStack[] getBack = new ItemStack[] {new ItemStack(Blocks.cactus, 9), new ItemStack(Blocks.brick_block, 9), new ItemStack(Blocks.bookshelf, 9), new ItemStack(Blocks.glowstone, 9), new ItemStack(Blocks.sand, 9, 1)
	, new ItemStack(Blocks.sand, 9), new ItemStack(Blocks.sponge, 9), new ItemStack(Blocks.soul_sand, 9), new ItemStack(Blocks.tnt, 9), new ItemStack(Blocks.stone, 9)
	, new ItemStack(Blocks.waterlily, 9)};
	
	public BlockStorageBlocks3() {
		super(EnumMaterialTypes.STONE.getMaterial());
		setStepSound(EnumMaterialTypes.STONE.getSound());
		setCreativeTab(EssenceTabs.decoraton);
		setHardness(1.0F);
		GameRegistry.registerBlock(this, ItemStorageBlockMetadata3.class, "blockStorageBlocks3");
	}
	
	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase e, ItemStack i) {
		w.setBlock(x, y, z, this, i.getItemDamage(), 2);
	}

	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		for(int i = 0; i < 11; i++)
			l.add(new ItemStack(it, 1, i));
	}

	@Override
	public void registerBlockIcons(IIconRegister r) {
		for(int i = 0; i < names.length; i++)
			icons[i] = r.registerIcon(SlayerAPI.PREFIX + "storage/" + names[i]);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return icons[meta];
	}
	
	@Override
	public int damageDropped(int m) {
		return m;
	}
}