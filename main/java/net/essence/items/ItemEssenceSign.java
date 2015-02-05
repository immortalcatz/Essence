package net.essence.items;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.blocks.BlockEssenceStandingSign;
import net.essence.blocks.BlockEssenceWallSign;
import net.essence.blocks.tileentity.TileEntityEssenceSign;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.item.ItemMod;

public class ItemEssenceSign extends ItemMod {

    public ItemEssenceSign(String name) {
    	super(name);
        this.maxStackSize = 16;
        this.setCreativeTab(EssenceTabs.misc);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (side == EnumFacing.DOWN) {
            return false;
        }
        else if (!worldIn.getBlockState(pos).getBlock().getMaterial().isSolid()) {
            return false;
        } else {
            pos = pos.offset(side);

            if (!playerIn.canPlayerEdit(pos, side, stack)) {
                return false;
            }
            else if (!EssenceBlocks.essenceStandingSign.canPlaceBlockAt(worldIn, pos)) {
                return false;
            }
            else if (worldIn.isRemote) {
                return true;
            } else {
                if (side == EnumFacing.UP) {
                    int i = MathHelper.floor_double((double)((playerIn.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
                    worldIn.setBlockState(pos, EssenceBlocks.essenceStandingSign.getDefaultState().withProperty(BlockEssenceStandingSign.ROTATION, Integer.valueOf(i)), 3);
                } else {
                    worldIn.setBlockState(pos, EssenceBlocks.essenceWallSign.getDefaultState().withProperty(BlockEssenceWallSign.FACING, side), 3);
                }

                --stack.stackSize;
                TileEntity tileentity = worldIn.getTileEntity(pos);

                if (tileentity instanceof TileEntityEssenceSign && !ItemBlock.setTileEntityNBT(worldIn, pos, stack)) {
                    playerIn.openEditSign((TileEntitySign)tileentity);
                }
                return true;
            }
        }
    }
}