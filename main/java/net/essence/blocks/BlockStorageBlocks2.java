package net.essence.blocks;

import java.util.List;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.items.block.ItemStorageBlockMetadata2;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockStorageBlocks2 extends Block {

	public static String[] names = {"hellstoneOre", "ashualOre", "ironOre", "coalOre", "redstoneOre", "emeraldOre", "hay", "gravel", "glass", "redFlower", "yellowFlower", "endStone", "bush", "cobblestone", "mossyCobblestone", "cake"};

	public static String[] allFinalNames = {"Hellstone Ore", "Ashual Ore", "Iron Ore",
		"Coal Ore", "Redstone Ore", "Emerald Ore", "Hay", "Gravel", "Glass", "Red Flower", "Yellow Flower", "End Stone", "Bush", "Cobblestone", "Mossy Cobblestone", "Cake"};
	private IIcon[] icons = new IIcon[16];

	public static ItemStack[] crafting = new ItemStack[] {new ItemStack(EssenceBlocks.hellstoneOre), new ItemStack(EssenceBlocks.ashual), new ItemStack(Blocks.iron_ore), new ItemStack(Blocks.coal_ore)
	, new ItemStack(Blocks.redstone_ore), new ItemStack(Blocks.emerald_ore), new ItemStack(Blocks.hay_block), new ItemStack(Blocks.gravel), new ItemStack(Blocks.glass)
	, new ItemStack(Blocks.red_flower), new ItemStack(Blocks.yellow_flower), new ItemStack(Blocks.end_stone), new ItemStack(Blocks.deadbush), new ItemStack(Blocks.cobblestone)
	, new ItemStack(Blocks.mossy_cobblestone), new ItemStack(Items.cake)};

	public static ItemStack[] getBack = new ItemStack[] {new ItemStack(EssenceBlocks.hellstoneOre, 9), new ItemStack(EssenceBlocks.ashual, 9), new ItemStack(Blocks.iron_ore, 9), new ItemStack(Blocks.coal_ore, 9)
	, new ItemStack(Blocks.redstone_ore, 9), new ItemStack(Blocks.emerald_ore, 9), new ItemStack(Blocks.hay_block, 9), new ItemStack(Blocks.gravel, 9), new ItemStack(Blocks.glass, 9)
	, new ItemStack(Blocks.red_flower, 9), new ItemStack(Blocks.yellow_flower, 9), new ItemStack(Blocks.end_stone, 9), new ItemStack(Blocks.deadbush, 9), new ItemStack(Blocks.cobblestone, 9)
	, new ItemStack(Blocks.mossy_cobblestone, 9), new ItemStack(Items.cake, 9)};

	public BlockStorageBlocks2() {
		super(EnumMaterialTypes.STONE.getMaterial());
		setStepSound(EnumMaterialTypes.STONE.getSound());
		setCreativeTab(EssenceTabs.decoraton);
		setHardness(1.0F);
		GameRegistry.registerBlock(this, ItemStorageBlockMetadata2.class, "blockStorageBlocks2");
	}
	
	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase e, ItemStack i) {
		w.setBlock(x, y, z, this, i.getItemDamage(), 2);
	}

	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		for(int i = 0; i < 16; i++)
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