package net.essence.blocks;

import java.util.List;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.items.block.ItemStorageBlockMetadata2;
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

public class BlockStorageBlocks2 extends Block {

	public static final PropertyEnum type = PropertyEnum.create("meta", BlockStorageBlocks2.EnumMetadata.class);
	
	public static String[] names = {"hellstoneOre", "ashualOre", "ironOre", "coalOre", "redstoneOre", "emeraldOre", "hay", "gravel", "glass", "redFlower", "yellowFlower", "endStone", "bush", "cobblestone", "mossyCobblestone", "cake"};

	public static String[] allFinalNames = {"Hellstone Ore", "Ashual Ore", "Iron Ore",
		"Coal Ore", "Redstone Ore", "Emerald Ore", "Hay", "Gravel", "Glass", "Red Flower", "Yellow Flower", "End Stone", "Bush", "Cobblestone", "Mossy Cobblestone", "Cake"};

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
		this.setDefaultState(this.blockState.getBaseState().withProperty(type, BlockStorageBlocks2.EnumMetadata.HELLSTONE_ORE));
		GameRegistry.registerBlock(this, ItemStorageBlockMetadata2.class, "BlockStorageBlocks2");
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
		return this.getDefaultState().withProperty(type, BlockStorageBlocks2.EnumMetadata.getStateFromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockStorageBlocks2.EnumMetadata)state.getValue(type)).getMetaFromState();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {type});
	}
	
    @Override
    public int damageDropped(IBlockState state) {
        return ((BlockStorageBlocks1.EnumMetadata)state.getValue(type)).getMetaFromState();
    }
	
	public enum EnumMetadata implements IStringSerializable {
		HELLSTONE_ORE(0, "hellstoneOre", "hellstoneOre"),
		ASHUAL_ORE(1, "ashualOre", "ashualOre"),
		IRON_ORE(2, "ironOre", "ironOre"),
		COAL_ORE(3, "coalOre", "coalOre"),
		REDSTONE_ORE(4, "redstoneOre", "redstoneOre"),
		EMERALD_ORE(5, "emeraldOre", "emeraldOre"),
		HAY(6, "hay", "hay"),
		GRAVEL(7, "gravel", "gravel"),
		GLASS(8, "grass", "grass"),
		RED_FLOWER(9, "redFlower", "redFlower"),
		YELLOW_FLOWER(10, "yellowFlower", "yellowFlower"),
		END_STONE(11, "endStone", "endStone"),
		BUSH(12, "bush", "bush"),
		COBBLESTONE(13, "cobblestone", "cobblestone"),
		MOSSY_COBBLESTONE(14, "mossyCobblestone", "mossyCobblestone"),
		CAKE(15, "cake", "cake");
		private static final BlockStorageBlocks2.EnumMetadata[] TYPES_ARRAY = new BlockStorageBlocks2.EnumMetadata[values().length];
		private final int meta;
		private final String textureName, type;

		private EnumMetadata(int m, String t, String ty) {
			this.meta = m;
			this.textureName = "storage/" + t;
			this.type = ty;
		}

		public int getMetaFromState() {
			return this.meta;
		}

		@Override
		public String toString() {
			return this.textureName;
		}

		public static BlockStorageBlocks2.EnumMetadata getStateFromMeta(int m) {
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
			BlockStorageBlocks2.EnumMetadata[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				BlockStorageBlocks2.EnumMetadata var3 = var0[var2];
				TYPES_ARRAY[var3.getMetaFromState()] = var3;
			}
		}
	}
}