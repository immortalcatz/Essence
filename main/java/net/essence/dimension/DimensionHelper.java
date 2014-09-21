package net.essence.dimension;

import net.essence.dimension.boil.BiomeGenBoiling;
import net.essence.dimension.boil.WorldProviderBoiling;
import net.essence.dimension.depths.BiomeGenDepths;
import net.essence.dimension.depths.WorldProviderDepths;
import net.essence.dimension.euca.BiomeGenEuca;
import net.essence.dimension.euca.WorldProviderEuca;
import net.essence.entity.mob.boiling.EntityMagmaGiant;
import net.essence.entity.mob.depths.EntityDarknessCrawler;
import net.essence.entity.mob.depths.EntityDepthsBeast;
import net.essence.entity.mob.depths.EntitySpikedBeast;
import net.essence.entity.mob.euca.EntityEucaHopper;
import net.essence.entity.mob.euca.EntityInsecto;
import net.essence.entity.mob.euca.EntityPsyollom;
import net.essence.entity.mob.vanilla.EntityBigHongo;
import net.essence.entity.mob.vanilla.EntityBoom;
import net.essence.entity.mob.vanilla.EntityRobot;
import net.essence.entity.mob.vanilla.EntitySpyclops;
import net.essence.util.Config;
import net.essence.util.LogHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.registry.EntityRegistry;

public class DimensionHelper {

	protected static final BiomeGenBase.Height boilHeight = new BiomeGenBase.Height(0.0F, 0.9F); 

	public static BiomeGenBase euca = new BiomeGenEuca(Config.eucaBiome);
	public static BiomeGenBase depths = new BiomeGenDepths(Config.depthsBiome);
	public static BiomeGenBase boiling = new BiomeGenBoiling(Config.boilBiome).setHeight(boilHeight);

	public static void init(){
		addDimension(Config.euca, WorldProviderEuca.class, Config.keepLoadingEuca);
		addDimension(Config.depths, WorldProviderDepths.class, Config.keepLoadingDepths);
		addDimension(Config.boil, WorldProviderBoiling.class, Config.keepLoadingBoil);
	}

	private static void addDimension(int id, Class<? extends WorldProvider> w, boolean keeploading) {
		LogHelper.info("Registering dimension ID: " + id);
		DimensionManager.registerProviderType(id, w, keeploading);
		DimensionManager.registerDimension(id, id);
	}

	public static void addSpawns() {
		addEucaSpawns();
		addBoilSpawns();
		addDepthsSpawns();
		addVanillaSpawns();
	}

	private static void addEucaSpawns() {
		EntityRegistry.addSpawn(EntityEucaHopper.class, 1, 1, 1, EnumCreatureType.creature, euca);
		EntityRegistry.addSpawn(EntityInsecto.class, 1, 1, 1, EnumCreatureType.creature, euca);
		EntityRegistry.addSpawn(EntityPsyollom.class, 1, 1, 1, EnumCreatureType.creature, euca);
	}

	private static void addBoilSpawns() {
		EntityRegistry.addSpawn(EntityMagmaGiant.class, 1, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityMagmaCube.class, 1, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityBlaze.class, 1, 1, 1, EnumCreatureType.creature, boiling);
	}

	private static void addDepthsSpawns() {
		EntityRegistry.addSpawn(EntityDarknessCrawler.class, 1, 1, 1, EnumCreatureType.creature, depths);
		EntityRegistry.addSpawn(EntityDepthsBeast.class, 1, 1, 1, EnumCreatureType.creature, depths);
		EntityRegistry.addSpawn(EntitySpikedBeast.class, 1, 1, 1, EnumCreatureType.creature, depths);
	}

	private static void addVanillaSpawns() {
		EntityRegistry.addSpawn(EntityBigHongo.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityBigHongo.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityBigHongo.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityBigHongo.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityBigHongo.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));

		EntityRegistry.addSpawn(EntityBoom.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));

		EntityRegistry.addSpawn(EntityRobot.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityRobot.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityRobot.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityRobot.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityRobot.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityRobot.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SPOOKY));

		EntityRegistry.addSpawn(EntitySpyclops.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntitySpyclops.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntitySpyclops.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntitySpyclops.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntitySpyclops.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntitySpyclops.class, 1, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SPOOKY));
	}
}