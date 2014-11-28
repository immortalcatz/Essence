package net.essence.blocks;

import java.util.List;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.items.block.ItemStorageBlockMetadata1;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.EnumMaterialTypes;

public class BlockStorageBlocks1 extends Block {

	public static String[] names = {"pumpkin", "birchLog", "oakLog", "jungleLog", "spruceLog", "darkOakLog", "acaciaLog", "lapisOre", "diamondOre", "goldOre", "quartzOre", "shadiumOre", "luniumOre", "sapphireOre", "celestiumOre", "flairiumOre"};

	public static String[] allFinalNames = {"Pumpkin", "Birch Log", "Oak Log", "Jungle Log", "SpruceLog", "Dark Oak Log",
		"Acacia Log", "Lapis Ore", "Diamond Ore", "Gold Ore", "Quartz Ore", "Shadium Ore", "Lunium Ore", "Sapphire Ore", "Celestium Ore", "Flairium Ore"};
	
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
	public void getSubBlocks(Item it, CreativeTabs c, List l) {
		for(int i = 0; i < 16; i++)
			l.add(new ItemStack(it, 1, i));
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, getStateFromMeta(stack.getItemDamage()), 2);
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getBlock().getMetaFromState(this.getDefaultState());
	}
}