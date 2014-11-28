package net.essence.blocks;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.items.block.ItemMiniBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;

public class BlockMiniColouredBricks extends Block {

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
		GameRegistry.registerBlock(this, ItemMiniBlockMetadata.class, "blockMiniColouredBricks");
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, getStateFromMeta(stack.getItemDamage()), 2);
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getBlock().getMetaFromState(this.getDefaultState());
	}
	
	@Override
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		for(int i = 0; i < 13; i++)
			l.add(new ItemStack(it, 1, i));
	}
}