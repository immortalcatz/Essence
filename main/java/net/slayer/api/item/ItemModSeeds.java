package net.slayer.api.item;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.SlayerAPI;

public class ItemModSeeds extends ItemSeeds {
	
	public ItemModSeeds(String name, String f, Block block) {
		super(block, Blocks.farmland);
		LangRegistry.addItem(name, f);
		setUnlocalizedName(name);
		setCreativeTab(EssenceTabs.util);
		EssenceItems.itemNames.add(name);
		GameRegistry.registerItem(this, name);
	}
}