package net.slayer.api.item;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.util.LangRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModFood extends ItemFood {

	private int time = 32;
	
    public ItemModFood(String name, int food, float sat, boolean wolfFood) {
        super(food, sat, wolfFood);
        setTextureName(SlayerAPI.PREFIX + name);
        setUnlocalizedName(name);
        setCreativeTab(EssenceTabs.misc);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
    }
    
    public ItemModFood(String name, int food, float sat, int timeToEat, boolean wolfFood) {
       this(name, food, sat, wolfFood);
       time = timeToEat;
    }
    
    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
    	return time;
    }

    public ItemModFood(String name, int food, float sat, boolean wolfFood, int potionID, int potionDuration, int potionAmplifier, float potionEffectProbability) {
        this(name, food, sat, wolfFood);
        setPotionEffect(potionID, potionDuration, potionAmplifier, potionEffectProbability);
    }

    protected int getHealAmount(ItemStack stack) {
        return func_150905_g(stack);
    }

    protected float getSaturation(ItemStack stack) {
        return func_150906_h(stack);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add("Fills " + (double) getHealAmount(stack) / 2 + " Hunger Bars");
        list.add(getSaturation(stack) + " Saturation");
        list.add(!isWolfsFavoriteMeat() ? "Pet Food: false" : "Pet Food: true");
        if(stack.getItem() == EssenceItems.eucaMeat) list.add("Faster eating");
        list.add(SlayerAPI.Colour.DARK_AQUA + SlayerAPI.MOD_NAME);
    }
}