package net.essence.items.block;

import net.essence.blocks.BlockBrison;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class ItemBrisonBlockMetadata extends ItemBlock {

	public ItemBrisonBlockMetadata(Block b) {
		super(b);
		hasSubtypes = true;
	}
	
	@Override
    public String getUnlocalizedName(ItemStack it)  {
        int i = MathHelper.clamp_int(it.getItemDamage(), 0, 16);
        return "tile." + BlockBrison.allNames[i];
    }
}