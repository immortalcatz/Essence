package net.essence.util;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static Configuration cfg;
    private static HashMap<String, Integer> configMap = new HashMap<String, Integer>();

    public static void init() {
        cfg = new Configuration(new File("./EssenceOfTheGods/EssenceOfTheGods.cfg"));

        cfg.load();
        dimensionInit();
        miscInit();
        cfg.save();
    }

    public static boolean keepLoadingEuca, keepLoadingDepths, keepLoadingBoil, reRenderPlayerStats;

    public static int euca, depths, boil;
    public static int eucaBiome, depthsBiome, boilBiome;
    
    

    public static void dimensionInit() {
        eucaBiome = cfg.get("Dimension", "Euca biome ID", 60).getInt();
        euca = cfg.get("Dimension", "Euca ID", 20).getInt();
        keepLoadingEuca = cfg.get("Dimension", "Keep loading Euca", true).getBoolean(true);
        depthsBiome = cfg.get("Dimension", "Depths biome ID", 61).getInt();
        depths = cfg.get("Dimension", "Depths ID", 21).getInt();
        keepLoadingDepths = cfg.get("Dimension", "Keep loading Depths", true).getBoolean(true);
        boilBiome = cfg.get("Dimension", "Boiling Point biome ID", 62).getInt();
        boil = cfg.get("Dimension", "Boiling Point ID", 22).getInt();
        keepLoadingBoil = cfg.get("Dimension", "Keep loading Boiling Poing", true).getBoolean(true);
        
        reRenderPlayerStats = cfg.get("Gui", "Re-render the players stats in the top right corner", true).getBoolean(true);

    }

    public static void miscInit() {

    }
}