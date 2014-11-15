package net.essence.items.block;

import java.util.List;

import net.essence.blocks.BlockGlowshroom;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.slayer.api.SlayerAPI.Colour;

public class ItemBlockGlowshroom extends ItemBlock {

	public ItemBlockGlowshroom(Block b) {
		super(b);
		hasSubtypes = true;
	}
	
	@Override
    public String getUnlocalizedName(ItemStack it) {
        int i = MathHelper.clamp_int(it.getItemDamage(), 0, 2);
        return "tile." + BlockGlowshroom.names[i];
    }
	
	@Override
	public void addInformation(ItemStack i, EntityPlayer p, List l, boolean b) {
		l.add(Colour.DARK_AQUA + "Ooooo.. Pretty!");
	}
}