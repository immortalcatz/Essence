package net.slayer.api.item;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModSeeds extends ItemSeeds {
	
	public ItemModSeeds(String name, Block block) {
		super(block, Blocks.farmland);
		setUnlocalizedName(name);
		setTextureName(SlayerAPI.PREFIX + name);
		setCreativeTab(EssenceTabs.util);
		GameRegistry.registerItem(this, name);
		LangRegistry.addItem(this);
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(SlayerAPI.Colour.DARK_AQUA + SlayerAPI.MOD_NAME);
	}
}