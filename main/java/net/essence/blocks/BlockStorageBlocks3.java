package net.essence.blocks;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.items.block.ItemStorageBlockMetadata3;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;

public class BlockStorageBlocks3 extends Block {
	
	public static final PropertyEnum type = PropertyEnum.create("meta", BlockStorageBlocks3.EnumMetadata.class);

	public static String[] names = {"cactus", "brick", "bookshelf", "glowstone", "redSand", "sand", "sponge", "soulSand", "tnt", "stone", "waterlilly"};
	public static String[] allFinalNames = {"Cactus", "Brick", "Bookshelf", "Glowstone", "Red Sand", "Sand", "Sponge", "Soul Sand", "TNT", "Stone", "Waterlilly"};
	
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
		this.setDefaultState(this.blockState.getBaseState().withProperty(type, BlockStorageBlocks3.EnumMetadata.CACTUS));
		GameRegistry.registerBlock(this, ItemStorageBlockMetadata3.class, "BlockStorageBlocks3");
	}

	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		for(int i = 0; i < 11; i++)
			l.add(new ItemStack(it, 1, i));
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, getStateFromMeta(stack.getItemDamage()), 2);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(type, BlockStorageBlocks3.EnumMetadata.getStateFromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((BlockStorageBlocks3.EnumMetadata)state.getValue(type)).getMetaFromState();
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
		CACTUS(0, "cactus", "cactus"),
		BRICK(1, "brick", "brick"),
		BOOKSHELF(2, "bookshelf", "bookshelf"),
		GLOWSTONE(3, "glowstone", "glowstone"),
		RED_SAND(4, "redSand", "redSand"),
		SAND(5, "sand", "sand"),
		SPONGE(6, "sponge", "sponge"),
		SOUL_SAND(7, "soulSand", "soulSand"),
		TNT(8, "tnt", "tnt"),
		STONE(9, "stone", "stone"),
		WATERLILLY(10, "waterlilly", "waterlilly");
		private static final BlockStorageBlocks3.EnumMetadata[] TYPES_ARRAY = new BlockStorageBlocks3.EnumMetadata[values().length];
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

		public static BlockStorageBlocks3.EnumMetadata getStateFromMeta(int m) {
			if(m < 0 || m >= TYPES_ARRAY.length) m = 0;
			return TYPES_ARRAY[m];
		}

		@Override
		public String getName() {
			return this.textureName;
		}

		public String getTypeName() {
			return this.type;
		}

		static {
			BlockStorageBlocks3.EnumMetadata[] var0 = values();
			int var1 = var0.length;

			for(int var2 = 0; var2 < var1; ++var2) {
				BlockStorageBlocks3.EnumMetadata var3 = var0[var2];
				TYPES_ARRAY[var3.getMetaFromState()] = var3;
			}
		}
	}
}