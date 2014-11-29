package net.essence.blocks;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.items.block.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;

public class BlockColouredBricks extends Block {
	
	public static final PropertyEnum type = PropertyEnum.create("meta", BlockColouredBricks.EnumMetadata.class);

	public static String[] textures = {"black", "blue", "brown", "cyan", "gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"};
	public static String[] names = {"Black", "Blue", "Brown", "Cyan", "Gray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow"};

	public static ItemStack[] crafting = new ItemStack[] {
			new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 3),
			new ItemStack(Items.dye, 1, 6), new ItemStack(Items.dye, 1, 8), new ItemStack(Items.dye, 1, 10),
			new ItemStack(Items.dye, 1, 13), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 9), 
			new ItemStack(Items.dye, 1, 5), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 11)};

	public BlockColouredBricks() {
		super(EnumMaterialTypes.STONE.getMaterial());
		setStepSound(EnumMaterialTypes.STONE.getSound());
		setCreativeTab(EssenceTabs.decoraton);
		setHardness(2.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(type, BlockColouredBricks.EnumMetadata.BLACK));
		GameRegistry.registerBlock(this, ItemBlockMetadata.class, "blockColouredBricks");
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, getStateFromMeta(stack.getItemDamage()), 2);
	}

	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		for(int i = 0; i < 13; i++)
			l.add(new ItemStack(it, 1, i));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(type, BlockColouredBricks.EnumMetadata.getStateFromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockColouredBricks.EnumMetadata)state.getValue(type)).getMetaFromState();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {type});
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return state.getBlock().getMetaFromState(this.getDefaultState());
	}
	
	public enum EnumMetadata implements IStringSerializable {
		BLACK(0, "black", "black"),
		BLUE(1, "blue", "blue"),
		BROWN(2, "brown", "brown"),
		CYAN(3, "cyan", "cyan"),
		GRAY(4, "gray", "gray"),
		LIME(5, "lime", "lime"),
		MAGENTA(6, "magenta", "magenta"),
		ORANGE(7, "orange", "orange"),
		PINK(8, "pink", "pink"),
		PURPLE(9, "purple", "purple"),
		RED(10, "red", "red"),
		WHITE(11, "white", "white"),
		YELLOW(12, "yellow", "yellow");
		private static final BlockColouredBricks.EnumMetadata[] TYPES_ARRAY = new BlockColouredBricks.EnumMetadata[values().length];
		private final int meta;
		private final String textureName, type;

		private EnumMetadata(int m, String t, String ty) {
			this.meta = m;
			this.textureName = "bricks/large/" + t;
			this.type = ty;
		}

		public int getMetaFromState() {
			return this.meta;
		}

		@Override
		public String toString() {
			return this.textureName;
		}

		public static BlockColouredBricks.EnumMetadata getStateFromMeta(int m) {
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
			BlockColouredBricks.EnumMetadata[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				BlockColouredBricks.EnumMetadata var3 = var0[var2];
				TYPES_ARRAY[var3.getMetaFromState()] = var3;
			}
		}
	}
}