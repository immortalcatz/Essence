package net.essence.items;

import net.essence.EssenceTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

public class ItemGoldenFood extends ItemFood {
	
	private boolean op;
	
    public ItemGoldenFood(String name, String tex, String actual, int heal, float sat, boolean wolf, boolean isOP) {
        super(heal, sat, wolf);
        op = isOP;
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        setCreativeTab(EssenceTabs.misc);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack i) {
        return op;
    }

    @Override
    public EnumRarity getRarity(ItemStack i) {
        return !op ? EnumRarity.RARE : EnumRarity.EPIC;
    }

    @Override
    protected void onFoodEaten(ItemStack i, World w, EntityPlayer p) {
        if(!w.isRemote) {
            p.addPotionEffect(new PotionEffect(Potion.absorption.id, 2400, 0));

        if(op) {
                p.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
                p.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
                p.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
            }
        } else {
            super.onFoodEaten(i, w, p);
        }
    }
}