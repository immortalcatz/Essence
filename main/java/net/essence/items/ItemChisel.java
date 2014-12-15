package net.essence.items;

import java.util.Set;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityGrindstone;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.google.common.collect.Sets;

public class ItemChisel extends ItemTool {

	private static final Set effectiveBlocks = Sets.newHashSet(EssenceBlocks.grindstone);
	String iconString;

	public ItemChisel(ToolMaterial material, String name) {
		super(2, material, effectiveBlocks);
		setCreativeTab(EssenceTabs.misc);
		setUnlocalizedName(name);
		EssenceItems.itemNames.add(name);
		GameRegistry.registerItem(this, name);
	}

	@Override
	public boolean canHarvestBlock(Block par1Block) {
		return false;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block block, BlockPos pos, EntityLivingBase par7EntityLiving) {
		if((double) block.getBlockHardness(par2World, pos) != 0.0D)
			par1ItemStack.damageItem(1, par7EntityLiving);
		return true;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
		if(player.worldObj.isRemote) return false;
		if (player.worldObj.getBlockState(pos).getBlock() == EssenceBlocks.grindstone) {
			if(((TileEntityGrindstone)player.worldObj.getTileEntity(pos)).work((int)getStrVsBlock(new ItemStack(this), EssenceBlocks.grindstone))) {
				if (itemstack.getItemDamage() >= itemstack.getMaxDamage()) {
					player.destroyCurrentEquippedItem();
				} else {
					itemstack.attemptDamageItem(3, itemRand);
				}
			}
			return true;
		}
		return super.onBlockStartBreak(itemstack, pos, player);
	}

	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		if (par2Block == EssenceBlocks.grindstone) {
			if(toolMaterial == ToolMaterial.WOOD)
				return 1;
			else if(toolMaterial == ToolMaterial.STONE)
				return 2;
			else if(toolMaterial == ToolMaterial.IRON)
				return 3;
			else if(toolMaterial == ToolMaterial.GOLD)
				return 4;
			else if(toolMaterial == ToolMaterial.EMERALD)
				return 5;
		}
		return 1;
	}
}