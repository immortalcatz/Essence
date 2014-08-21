package net.essence.items;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.util.EssenceToolMaterial;
import net.essence.util.LangRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemModAxe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBattleAxe extends ItemModAxe {
	
	public ItemBattleAxe(String name, EssenceToolMaterial m) {
		super(name, m);
		setUnlocalizedName(name);
		setTextureName(SlayerAPI.PREFIX + name);
		setCreativeTab(EssenceTabs.weapons);
		LangRegistry.addItem(this);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	list.add(SlayerAPI.Colour.AQUA + "Battle Axe");
        list.add(SlayerAPI.Colour.BLUE + "Efficiency: " + toolMaterial.getEfficiencyOnProperMaterial());
        if (stack.getMaxDamage() != -1) list.add(stack.getMaxDamage() - stack.getItemDamage() + " Uses");
        else list.add(SlayerAPI.Colour.GREEN + "Infinite Uses");
        list.add(SlayerAPI.Colour.DARK_AQUA + SlayerAPI.MOD_NAME);
    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack i) {
    	return EnumAction.block;
    }
    
    @Override
    public int getMaxItemUseDuration(ItemStack i) {
        return 72000;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p) {
        p.setItemInUse(i, this.getMaxItemUseDuration(i));
        return i;
    }
}