package net.essence.entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import net.essence.util.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 * 
 * <b>A modified version of vanilla EntityList</b>
 * @author TheSlayerMC, Mojang
 */
public class EssenceEntityList {

    public static Map stringToClassMapping = new HashMap();
    public static Map classToStringMapping = new HashMap();
    public static Map IDtoClassMapping = new HashMap();
    private static Map classToIDMapping = new HashMap();
    private static Map stringToIDMapping = new HashMap();
    public static HashMap entityEggs = new LinkedHashMap();

    public static void addMapping(Class clazz, String name, int id) {

        if(stringToClassMapping.containsKey(name))
            throw new IllegalArgumentException("ID is already registered: " + name);
        
        else if(IDtoClassMapping.containsKey(Integer.valueOf(id))) 
            throw new IllegalArgumentException("ID is already registered: " + id);
        
        else {
            stringToClassMapping.put(name, clazz);
            classToStringMapping.put(clazz, name);
            IDtoClassMapping.put(Integer.valueOf(id), clazz);
            classToIDMapping.put(clazz, Integer.valueOf(id));
            stringToIDMapping.put(name, Integer.valueOf(id));
        }
    }

    public static void addMapping(Class clazz, String name, int id, int primary, int secondary) {
        addMapping(clazz, name, id);
        entityEggs.put(Integer.valueOf(id), new EssenceEntityList.EntityEggInfo(id, primary, secondary));
    }

    public static String getStringFromID(int id) {
        Class oclass = getClassFromID(id);
        return oclass != null ? (String) classToStringMapping.get(oclass) : null;
    }

    public static Class getClassFromID(int id) {
        return (Class) IDtoClassMapping.get(Integer.valueOf(id));
    }

    public static int getIDFromClass(Class clazz) {
        return (Integer) classToIDMapping.get(clazz);
    }

    public static Entity createEntityByID(int id, World world) {

        Entity entity = null;

        try {
            Class oclass = getClassFromID(id);
            if(oclass != null) {
                entity = (Entity) oclass.getConstructor(new Class[] { World.class }).newInstance(new Object[] { world });
            }
        }

        catch(Exception exception) {
            exception.printStackTrace();
        }
        if(entity == null) {
            LogHelper.warn("Entity with ID " + id + " is null, it will be skipped.");
        }

        return entity;
    }

    public static class EntityEggInfo {

        public final int entityID;
        public final int primaryColor;
        public final int secondaryColor;

        public EntityEggInfo(int id, int primary, int secondary) {
            this.entityID = id;
            this.primaryColor = primary;
            this.secondaryColor = secondary;
        }
    }
}