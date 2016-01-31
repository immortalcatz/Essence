package net.journey.blocks;

import java.util.List;

import net.journey.JourneyTabs;
import net.journey.items.block.ItemBrisonBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;

public class BlockBrison extends Block {

	public static final PropertyEnum type = PropertyEnum.create("variant", BlockBrison.EnumMetadata.class);

	public static String[] allNames = {"darkBrisonBrick", "redBrisonBrick", "smallBrisonBrick", "brisonStone"};
	
	public BlockBrison() {
		super(EnumMaterialTypes.STONE.getMaterial());
		setStepSound(EnumMaterialTypes.STONE.getSound());
		setCreativeTab(JourneyTabs.decoraton);
		setHardness(1.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(type, BlockBrison.EnumMetadata.DARK));
		GameRegistry.registerBlock(this, ItemBrisonBlockMetadata.class, "brisonBlocks");
	}
	
	@Override
	public Block setStepSound(SoundType sound) {
		this.stepSound = sound;
		return this;
	}

	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		for(int i = 0; i < 4; i++)
			l.add(new ItemStack(it, 1, i));
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, getStateFromMeta(stack.getItemDamage()), 2);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(type, BlockBrison.EnumMetadata.getStateFromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockBrison.EnumMetadata)state.getValue(type)).getMetaFromState();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {type});
	}
	
    @Override
    public int damageDropped(IBlockState state) {
        return ((BlockBrison.EnumMetadata)state.getValue(type)).getMetaFromState();
    }

	public enum EnumMetadata implements IStringSerializable {
		DARK(0, "dark"),
		RED(1, "red"),
		SMALL(2, "small"),
		STONE(3, "bstone");
		private static final BlockBrison.EnumMetadata[] TYPES_ARRAY = new BlockBrison.EnumMetadata[values().length];
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

		public static BlockBrison.EnumMetadata getStateFromMeta(int m) {
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
			BlockBrison.EnumMetadata[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				BlockBrison.EnumMetadata var3 = var0[var2];
				TYPES_ARRAY[var3.getMetaFromState()] = var3;
			}
		}
	}
}