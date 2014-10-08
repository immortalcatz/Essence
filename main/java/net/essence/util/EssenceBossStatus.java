package net.essence.util;

import net.minecraft.entity.boss.IBossDisplayData;

public final class EssenceBossStatus {

    public static float healthScale;
    public static int statusBarTime, id;
    public static boolean hasColorModifier;

    public static void setStatus(IEssenceBoss boss, int id1) {
        healthScale = boss.getModHealth() / boss.getModMaxHealth();
        statusBarTime = 100;
        id = id1;
    }
}