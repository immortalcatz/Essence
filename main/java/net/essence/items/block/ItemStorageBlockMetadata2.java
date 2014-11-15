package net.essence.items.block;

import java.util.List;

import net.essence.blocks.BlockStorageBlocks2;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.slayer.api.SlayerAPI.Colour;

public class ItemStorageBlockMetadata2 extends ItemBlock {

	public ItemStorageBlockMetadata2(Block b) {
		super(b);
		hasSubtypes = true;
	}
	
	@Override
    public String getUnlocalizedName(ItemStack it)  {
        int i = MathHelper.clamp_int(it.getItemDamage(), 0, 16);
        return "tile." + BlockStorageBlocks2.names[i] + "Storage";
    }
	
	@Override
	public void addInformation(ItemStack i, EntityPlayer p, List l, boolean b) {
		l.add(Colour.DARK_AQUA + "Extra storage!");
	}
}