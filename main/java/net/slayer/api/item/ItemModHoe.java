package net.slayer.api.item;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.util.EssenceToolMaterial;
import net.essence.util.LangRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModHoe extends ItemHoe {

	protected EssenceToolMaterial mat;
	
    public ItemModHoe(String name, EssenceToolMaterial tool) {
		super(tool.getToolMaterial());
		mat = tool;
		setTextureName(SlayerAPI.PREFIX + "tools/" + name);
        setUnlocalizedName(name);
        setCreativeTab(EssenceTabs.tools);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
    }
    
	@Override
	public boolean getIsRepairable(ItemStack i, ItemStack i1) {
		boolean canRepair = mat.getRepairItem() != null;
		if(canRepair) return mat.getRepairItem() == i1.getItem() ? true : super.getIsRepairable(i, i1);
		return super.getIsRepairable(i, i1);
	}

    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
        if (item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
        else infoList.add(SlayerAPI.Colour.GREEN + "Infinite Uses");
        infoList.add(SlayerAPI.Colour.DARK_AQUA + SlayerAPI.MOD_NAME);
    }
}