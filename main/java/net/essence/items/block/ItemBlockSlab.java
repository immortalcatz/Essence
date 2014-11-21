package net.essence.items.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.slayer.api.block.BlockModSlab;

public class ItemBlockSlab extends ItemBlock {

	public ItemBlockSlab(Block b) {
		super(b);
		hasSubtypes = true;
	}

	@Override
    public String getUnlocalizedName(ItemStack it)  {
        int i = MathHelper.clamp_int(it.getItemDamage(), 0, 1);
        return "tile." + BlockModSlab.types[i] + "Slab";
    }
}