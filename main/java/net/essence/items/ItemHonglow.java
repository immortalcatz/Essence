package net.essence.items;

import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHonglow extends ItemFood {
	
	private boolean op;
	
    public ItemHonglow(String name, String actual, int heal, float f, boolean sat, boolean b) {
        super(heal, sat);
        LangRegistry.addItem(name, actual);
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        EssenceItems.itemNames.add(name);
        setCreativeTab(EssenceTabs.misc);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack i) {
        return op;
    }

    @Override
    protected void onFoodEaten(ItemStack i, World w, EntityPlayer p) {
        if(!w.isRemote) {
            p.addPotionEffect(new PotionEffect(Potion.nightVision.id, 2400, 0));
            }
            super.onFoodEaten(i, w, p);
        }

    }