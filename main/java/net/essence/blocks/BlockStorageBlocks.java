package net.essence.blocks;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.items.block.ItemStorageBlockMetadata;
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

public class BlockStorageBlocks extends Block {

	public static String[] allNames = {"dirt", "birchPlanks", "oakPlanks", "junglePlanks", "sprucePlanks", "darkOakPlanks", "acaciaPlanks", "potatoes", "wheat", "carrots",
		"obsidian", "netherrack", "netherBrick", "redMushroom", "brownMushroom", "melon"};
	
	public static String[] allFinalNames = {"Dirt", "Birch Planks", "Oak Planks", "Jungle Planks", "Spruce Planks", "Dark Oak Planks", "Acacia Planks", "Potatoes", "Wheat", "Carrots",
		"Obsidian", "Netherrack", "Nether Brick", "Red Mushroom", "Brown Mushroom", "melon", "Pumpkin", "Birch Log", "Oak Log", "Jungle Log", "SpruceLog", "Dark Oak Log",
		"Acacia Log", "Lapis Ore", "Diamond Ore", "Gold Ore", "Quartz Ore", "Shadium Ore", "Lunium Ore", "Sapphire Ore", "Celestium Ore", "Flairium Ore", "Hellstone Ore", "Ashual Ore", "Iron Ore",
		"Coal Ore", "Redstone Ore", "Emerald Ore", "Hay", "Gravel", "Glass", "Red Flower", "Yellow Flower", "End Stone", "Bush", "Cobblestone", "Mossy Cobblestone", "Cake", "Cactus",
		"Brick", "Bookshelf", "Glowstone", "Red Sand", "Sand", "Sponge", "Soul Sand", "TNT", "Stone", "Waterlilly"};
	
	private IIcon[] icons = new IIcon[16];
	
	public static ItemStack[] crafting = new ItemStack[] {new ItemStack(Blocks.dirt), new ItemStack(Blocks.planks, 1, 2), new ItemStack(Blocks.planks, 1), new ItemStack(Blocks.planks, 1, 3)
	, new ItemStack(Blocks.planks, 1, 1), new ItemStack(Blocks.planks, 1, 5), new ItemStack(Blocks.planks, 1, 4), new ItemStack(Items.potato), new ItemStack(Items.wheat)
	, new ItemStack(Items.carrot), new ItemStack(Blocks.obsidian), new ItemStack(Blocks.netherrack), new ItemStack(Blocks.nether_brick), new ItemStack(Blocks.red_mushroom)
	, new ItemStack(Blocks.brown_mushroom), new ItemStack(Blocks.melon_block)};
	
	public static ItemStack[] getBack = new ItemStack[] {new ItemStack(Blocks.dirt, 9), new ItemStack(Blocks.planks, 9, 2), new ItemStack(Blocks.planks, 9), new ItemStack(Blocks.planks, 9, 3)
	, new ItemStack(Blocks.planks, 9, 1), new ItemStack(Blocks.planks, 9, 5), new ItemStack(Blocks.planks, 9, 4), new ItemStack(Items.potato, 9), new ItemStack(Items.wheat, 9)
	, new ItemStack(Items.carrot, 9), new ItemStack(Blocks.obsidian, 9), new ItemStack(Blocks.netherrack, 9), new ItemStack(Blocks.nether_brick, 9), new ItemStack(Blocks.red_mushroom, 9)
	, new ItemStack(Blocks.brown_mushroom, 9), new ItemStack(Blocks.melon_block, 9)};

	public BlockStorageBlocks() {
		super(EnumMaterialTypes.STONE.getMaterial());
		setStepSound(EnumMaterialTypes.STONE.getSound());
		setCreativeTab(EssenceTabs.decoraton);
		setHardness(1.0F);
		GameRegistry.registerBlock(this, ItemStorageBlockMetadata.class, "blockStorageBlocks");
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
		for(int i = 0; i < 16; i++)
			icons[i] = r.registerIcon(SlayerAPI.PREFIX + "storage/" + allNames[i]);
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