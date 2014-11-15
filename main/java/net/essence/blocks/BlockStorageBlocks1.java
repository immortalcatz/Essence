package net.essence.blocks;

import java.util.List;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.items.block.ItemStorageBlockMetadata;
import net.essence.items.block.ItemStorageBlockMetadata1;
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

public class BlockStorageBlocks1 extends Block {

	public static String[] names = {"pumpkin", "birchLog", "oakLog", "jungleLog", "spruceLog", "darkOakLog", "acaciaLog", "lapisOre", "diamondOre", "goldOre", "quartzOre", "shadiumOre", "luniumOre", "sapphireOre", "celestiumOre", "flairiumOre"};

	public static String[] allFinalNames = {"Pumpkin", "Birch Log", "Oak Log", "Jungle Log", "SpruceLog", "Dark Oak Log",
		"Acacia Log", "Lapis Ore", "Diamond Ore", "Gold Ore", "Quartz Ore", "Shadium Ore", "Lunium Ore", "Sapphire Ore", "Celestium Ore", "Flairium Ore"};
	
	private IIcon[] icons = new IIcon[16];

	public static ItemStack[] crafting = new ItemStack[] {new ItemStack(Blocks.pumpkin), new ItemStack(Blocks.log, 1, 2), new ItemStack(Blocks.log), new ItemStack(Blocks.log, 1, 3)
	, new ItemStack(Blocks.log, 1, 1), new ItemStack(Blocks.log2), new ItemStack(Blocks.log2, 1, 1), new ItemStack(Blocks.lapis_ore), new ItemStack(Blocks.diamond_ore)
	, new ItemStack(Blocks.gold_ore), new ItemStack(Blocks.quartz_ore), new ItemStack(EssenceBlocks.shadiumOre), new ItemStack(EssenceBlocks.luniumOre), new ItemStack(EssenceBlocks.sapphireOre)
	, new ItemStack(EssenceBlocks.celestiumOre), new ItemStack(EssenceBlocks.flairiumOre)};
	
	public static ItemStack[] getBack = new ItemStack[] {new ItemStack(Blocks.pumpkin, 9), new ItemStack(Blocks.log, 9, 2), new ItemStack(Blocks.log, 9), new ItemStack(Blocks.log, 9, 3)
	, new ItemStack(Blocks.log, 9, 1), new ItemStack(Blocks.log2, 9, 1), new ItemStack(Blocks.log2, 9), new ItemStack(Blocks.lapis_ore, 9), new ItemStack(Blocks.diamond_ore, 9)
	, new ItemStack(Blocks.gold_ore, 9), new ItemStack(Blocks.quartz_ore, 9), new ItemStack(EssenceBlocks.shadiumOre, 9), new ItemStack(EssenceBlocks.luniumOre, 9), new ItemStack(EssenceBlocks.sapphireOre, 9)
	, new ItemStack(EssenceBlocks.celestiumOre, 9), new ItemStack(EssenceBlocks.flairiumOre, 9)};

	public BlockStorageBlocks1() {
		super(EnumMaterialTypes.STONE.getMaterial());
		setStepSound(EnumMaterialTypes.STONE.getSound());
		setCreativeTab(EssenceTabs.decoraton);
		setHardness(1.0F);
		GameRegistry.registerBlock(this, ItemStorageBlockMetadata1.class, "blockStorageBlocks1");
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