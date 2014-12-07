package net.essence.blocks;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.items.block.ItemMiniBlockMetadata;
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
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;

public class BlockMiniColouredBricks extends Block {
	
	public static final PropertyEnum type = PropertyEnum.create("meta", BlockMiniColouredBricks.EnumMetadata.class);

	public static String[] textures = {"black", "blue", "brown", "cyan", "gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"};
	public static String[] names = {"Black", "Blue", "Brown", "Cyan", "Gray", "Lime", "Magenta", "Orange", "Pink", "Purple", "Red", "White", "Yellow"};

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
		this.setDefaultState(this.blockState.getBaseState().withProperty(type, BlockMiniColouredBricks.EnumMetadata.BLACK));
		GameRegistry.registerBlock(this, ItemMiniBlockMetadata.class, "blockMiniColouredBricks");
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
		return this.getDefaultState().withProperty(type, BlockMiniColouredBricks.EnumMetadata.getStateFromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockMiniColouredBricks.EnumMetadata)state.getValue(type)).getMetaFromState();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {type});
	}
	
    @Override
    public int damageDropped(IBlockState state) {
        return ((BlockMiniColouredBricks.EnumMetadata)state.getValue(type)).getMetaFromState();
    }

	public enum EnumMetadata implements IStringSerializable {
		BLACK(0, "blackMiniColouredBrick"),
		BLUE(1, "blueMiniColouredBrick"),
		BROWN(2, "brownMiniColouredBrick"),
		CYAN(3, "cyanMiniColouredBrick"),
		GRAY(4, "grayMiniColouredBrick"),
		LIME(5, "limeMiniColouredBrick"),
		MAGENTA(6, "magentaMiniColouredBrick"),
		ORANGE(7, "orangeMiniColouredBrick"),
		PINK(8, "pinkMiniColouredBrick"),
		PURPLE(9, "purpleMiniColouredBrick"),
		RED(10, "redMiniColouredBrick"),
		WHITE(11, "whiteMiniColouredBrick"),
		YELLOW(12, "yellowMiniColouredBrick");
		private static final EnumMetadata[] TYPES_ARRAY = new BlockMiniColouredBricks.EnumMetadata[values().length];
		private final int meta;
		private final String type;

		private EnumMetadata(int m, String ty) {
			this.meta = m;
			this.type = ty;
		}

		public int getMetaFromState() {
			return this.meta;
		}

		@Override
		public String toString() {
			return type;
		}

		public static BlockMiniColouredBricks.EnumMetadata getStateFromMeta(int m) {
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
			BlockMiniColouredBricks.EnumMetadata[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				BlockMiniColouredBricks.EnumMetadata var3 = var0[var2];
				TYPES_ARRAY[var3.getMetaFromState()] = var3;
			}
		}
	}
}