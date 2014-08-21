package net.essence.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IChatComponent;

public interface IEssenceBoss {
    float getMaxHealth();
    float getHealth();
}