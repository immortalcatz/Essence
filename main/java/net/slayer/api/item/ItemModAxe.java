package net.slayer.api.item;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.util.EssenceToolMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.SlayerAPI;

public class ItemModAxe extends ItemAxe {

	protected EssenceToolMaterial mat;

	public ItemModAxe(String name, EssenceToolMaterial tool) {
		super(tool.getToolMaterial());
		mat = tool;
		setUnlocalizedName(name);
		setCreativeTab(EssenceTabs.tools);
		GameRegistry.registerItem(this, name);
	}

	@Override
	public boolean isItemTool(ItemStack i) {
		return true;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack i, ItemStack i1) {
		boolean canRepair = mat.getRepairItem() != null;
		if(canRepair) return mat.getRepairItem() == i1.getItem() ? true : super.getIsRepairable(i, i1);
		return super.getIsRepairable(i, i1);
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block) {
		return block.getMaterial() != Material.wood && block.getMaterial() != Material.web && block.getMaterial() != Material.plants && block.getMaterial() != Material.vine ? super.getStrVsBlock(stack, block) : this.efficiencyOnProperMaterial;
	}

	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
		infoList.add(SlayerAPI.Colour.BLUE + "Efficiency: " + toolMaterial.getEfficiencyOnProperMaterial());
		if(item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
		else infoList.add(SlayerAPI.Colour.GREEN + "Infinite Uses");
		infoList.add(SlayerAPI.Colour.DARK_AQUA + SlayerAPI.MOD_NAME);
	}
}