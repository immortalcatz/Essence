package net.essence.blocks;

import net.essence.Essence;
import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockTropicalWater extends BlockFluidClassic {

	public BlockTropicalWater(String name) {
		super(Essence.tropicalWater, Material.water);
		Essence.tropicalWater.setBlock(this);
		setCreativeTab(EssenceTabs.tabBlock);
		setUnlocalizedName(name);
		//EssenceBlocks.blockName.add(name);
		GameRegistry.registerBlock(this, name);
	}
}