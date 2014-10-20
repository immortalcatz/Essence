package net.essence.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.slayer.api.SlayerAPI;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {

    private static BufferedWriter writer;
    
    static {
        File dir = new File("./EssenceOfTheGods");
        dir.mkdir();
        dir = new File("./EssenceOfTheGods/debug.log");
        try {
            writer = new BufferedWriter(new FileWriter(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void log(Level level, Object msg) {
        FMLLog.log(SlayerAPI.MOD_NAME, level, "[Essence of the gods] " + msg.toString());
        System.err.println(msg);
        writeFile(msg);
    }

    public static void debug(Object msg) {
        if(SlayerAPI.DEVMODE) log(Level.DEBUG, "[Essence of the gods] " + "[DEBUG] " + msg);
    }

    public static void error(Object msg) {
        log(Level.ERROR, "[Essence of the gods] " + msg);
    }

    public static void info(Object msg) {
        log(Level.INFO, "[Essence of the gods] " + msg);
    }

    public static void warn(Object msg) {
        log(Level.WARN, "[Essence of the gods] " + msg);
    }

    public static void dev(Object msg) {
        log(Level.INFO, "[Essence of the gods] " + "[DEVELOPMENT] " + msg);
    }
    
    public static void writeFile(Object msg){
        try {
            writer.write(msg + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeFile() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}