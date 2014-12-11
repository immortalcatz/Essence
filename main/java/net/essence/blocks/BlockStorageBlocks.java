package net.essence.blocks;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.items.block.ItemStorageBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;

public class BlockStorageBlocks extends Block {

	public static final PropertyEnum type = PropertyEnum.create("variant", BlockStorageBlocks.EnumMetadata.class);

	public static String[] allNames = {"dirt", "birchPlanks", "oakPlanks", "junglePlanks", "sprucePlanks", "darkOakPlanks", "acaciaPlanks", "potatoes", "wheat", "carrots",
		"obsidian", "netherrack", "netherBrick", "redMushroom", "brownMushroom", "melon"};

	public static String[] allFinalNames = {"Dirt", "Birch Planks", "Oak Planks", "Jungle Planks", "Spruce Planks", "Dark Oak Planks", "Acacia Planks", "Potatoes", "Wheat", "Carrots",
		"Obsidian", "Netherrack", "Nether Brick", "Red Mushroom", "Brown Mushroom", "melon", "Pumpkin", "Birch Log", "Oak Log", "Jungle Log", "SpruceLog", "Dark Oak Log",
		"Acacia Log", "Lapis Ore", "Diamond Ore", "Gold Ore", "Quartz Ore", "Shadium Ore", "Lunium Ore", "Sapphire Ore", "Celestium Ore", "Flairium Ore", "Hellstone Ore", "Ashual Ore", "Iron Ore",
		"Coal Ore", "Redstone Ore", "Emerald Ore", "Hay", "Gravel", "Glass", "Red Flower", "Yellow Flower", "End Stone", "Bush", "Cobblestone", "Mossy Cobblestone", "Cake", "Cactus",
		"Brick", "Bookshelf", "Glowstone", "Red Sand", "Sand", "Sponge", "Soul Sand", "TNT", "Stone", "Waterlilly"};

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
		this.setDefaultState(this.blockState.getBaseState().withProperty(type, BlockStorageBlocks.EnumMetadata.DIRT));
		GameRegistry.registerBlock(this, ItemStorageBlockMetadata.class, "blockStorageBlocks");
	}

	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		for(int i = 0; i < 16; i++)
			l.add(new ItemStack(it, 1, i));
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, getStateFromMeta(stack.getItemDamage()), 2);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(type, BlockStorageBlocks.EnumMetadata.getStateFromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockStorageBlocks.EnumMetadata)state.getValue(type)).getMetaFromState();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {type});
	}
	
    @Override
    public int damageDropped(IBlockState state) {
        return ((BlockStorageBlocks.EnumMetadata)state.getValue(type)).getMetaFromState();
    }

	public enum EnumMetadata implements IStringSerializable {
		DIRT(0, "dirt"),
		BIRCH_PLANKS(1, "birch"),
		OAK_PLANKS(2, "oak"),
		JUNGLE_PLANKS(3, "jungle"),
		SPRUCE_PLANKS(4, "spruce"),
		DARK_OAK_PLANKS(5, "dark"),
		ACACIA_PLANKS(6, "acacia"),
		POTATOES(7, "potatoes"),
		WHEAT(8, "wheat"),
		CARROTS(9, "carrots"),
		OBSIDIAN(10, "obsidian"),
		NETHERRACK(11, "netherrack"),
		NETHER_BRICK(12, "netherbrick"),
		RED_MUSHROOM(13, "redmushroom"),
		BROWN_MUSHROOM(14, "brownmushroom"),
		MELON(15, "melon");
		private static final BlockStorageBlocks.EnumMetadata[] TYPES_ARRAY = new BlockStorageBlocks.EnumMetadata[values().length];
		private final int meta;
		private final String type;

		private EnumMetadata(int m, String t) {
			this.meta = m;
			this.type = t;
		}

		public int getMetaFromState() {
			return this.meta;
		}

		@Override
		public String toString() {
			return this.type;
		}

		public static BlockStorageBlocks.EnumMetadata getStateFromMeta(int m) {
			if(m < 0 || m >= TYPES_ARRAY.length) m = 0;
			return TYPES_ARRAY[m];
		}

		@Override
		public String getName() {
			return this.type;
		}

		public String getTypeName() {
			return this.type;
		}

		static {
			BlockStorageBlocks.EnumMetadata[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				BlockStorageBlocks.EnumMetadata var3 = var0[var2];
				TYPES_ARRAY[var3.getMetaFromState()] = var3;
			}
		}
	}
}