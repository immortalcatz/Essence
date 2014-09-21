package net.essence.items;

import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGoldenFood extends ItemFood {
	
	private boolean op;
	
    public ItemGoldenFood(String name, String tex, String actual, int heal, float sat, boolean wolf, boolean isOP) {
        super(heal, sat, wolf);
        op = isOP;
        setUnlocalizedName(name);
        setTextureName(SlayerAPI.PREFIX + tex);
        LangRegistry.addOPFood(name, actual);
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
        return !op ? EnumRarity.rare : EnumRarity.epic;
    }

    @Override
    protected void onFoodEaten(ItemStack i, World w, EntityPlayer p) {
        if(!w.isRemote) {
            p.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2400, 0));

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