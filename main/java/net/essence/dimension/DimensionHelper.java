package net.essence.dimension;

import net.essence.dimension.boil.BiomeGenBoiling;
import net.essence.dimension.boil.WorldProviderBoiling;
import net.essence.dimension.depths.BiomeGenDepths;
import net.essence.dimension.depths.WorldProviderDepths;
import net.essence.dimension.euca.BiomeGenEuca;
import net.essence.dimension.euca.WorldProviderEuca;
import net.essence.entity.mob.boiling.EntityAshHoarder;
import net.essence.entity.mob.boiling.EntityBurningLight;
import net.essence.entity.mob.boiling.EntityBurntAsh;
import net.essence.entity.mob.boiling.EntityBurntMiner;
import net.essence.entity.mob.boiling.EntityCrisp;
import net.essence.entity.mob.boiling.EntityExposedFlame;
import net.essence.entity.mob.boiling.EntityMagmaBlaze;
import net.essence.entity.mob.boiling.EntityMagmaGiant;
import net.essence.entity.mob.depths.EntityDarknessCrawler;
import net.essence.entity.mob.depths.EntityDepthsBeast;
import net.essence.entity.mob.depths.EntityDepthsHunter;
import net.essence.entity.mob.depths.EntitySpikedBeast;
import net.essence.entity.mob.euca.EntityEucaCharger;
import net.essence.entity.mob.euca.EntityEucaFighter;
import net.essence.entity.mob.euca.EntityEucaHopper;
import net.essence.entity.mob.euca.EntityInsecto;
import net.essence.entity.mob.euca.EntityPsyollom;
import net.essence.entity.mob.vanilla.EntityBigHongo;
import net.essence.entity.mob.vanilla.EntityBoom;
import net.essence.entity.mob.vanilla.EntityBunny;
import net.essence.entity.mob.vanilla.EntityMediumHongo;
import net.essence.entity.mob.vanilla.EntityReaper;
import net.essence.entity.mob.vanilla.EntityRobot;
import net.essence.entity.mob.vanilla.EntitySandCrawler;
import net.essence.entity.mob.vanilla.EntitySmallHongo;
import net.essence.entity.mob.vanilla.EntitySpyclops;
import net.essence.entity.mob.vanilla.EntityTurtle;
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
		EntityRegistry.addSpawn(EntityEucaHopper.class, 4, 1, 1, EnumCreatureType.creature, euca);
		EntityRegistry.addSpawn(EntityEucaFighter.class, 4, 1, 1, EnumCreatureType.creature, euca);
		EntityRegistry.addSpawn(EntityInsecto.class, 4, 1, 1, EnumCreatureType.creature, euca);
		EntityRegistry.addSpawn(EntityPsyollom.class, 4, 1, 1, EnumCreatureType.creature, euca);
		EntityRegistry.addSpawn(EntityEucaCharger.class, 4, 1, 1, EnumCreatureType.creature, euca);
	}

	private static void addBoilSpawns() {
		int amount = 3;
		EntityRegistry.addSpawn(EntityMagmaGiant.class, amount, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityMagmaCube.class, amount, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityBlaze.class, amount, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityMagmaBlaze.class, amount, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityCrisp.class, amount, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityBurningLight.class, amount, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityBurntAsh.class, amount, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityExposedFlame.class, amount, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityAshHoarder.class, amount, 1, 1, EnumCreatureType.creature, boiling);
		EntityRegistry.addSpawn(EntityBurntMiner.class, amount, 1, 1, EnumCreatureType.creature, boiling);
	}

	private static void addDepthsSpawns() {
		EntityRegistry.addSpawn(EntityDarknessCrawler.class, 4, 1, 1, EnumCreatureType.creature, depths);
		EntityRegistry.addSpawn(EntityDepthsBeast.class, 4, 1, 1, EnumCreatureType.creature, depths);
		EntityRegistry.addSpawn(EntitySpikedBeast.class, 4, 1, 1, EnumCreatureType.creature, depths);
		EntityRegistry.addSpawn(EntityDepthsHunter.class, 4, 1, 1, EnumCreatureType.creature, depths);
	}

	private static void addVanillaSpawns() {
		EntityRegistry.addSpawn(EntityBigHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityBigHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityBigHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityBigHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityBigHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));

		EntityRegistry.addSpawn(EntityMediumHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityMediumHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityMediumHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityMediumHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityMediumHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
		
		EntityRegistry.addSpawn(EntitySmallHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntitySmallHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntitySmallHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntitySmallHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntitySmallHongo.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
	
		EntityRegistry.addSpawn(EntityBunny.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityBunny.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityBunny.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityBunny.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityBunny.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
		
		EntityRegistry.addSpawn(EntityBoom.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityBoom.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SANDY));
		EntityRegistry.addSpawn(EntityBoom.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DRY));
		EntityRegistry.addSpawn(EntityBoom.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityBoom.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SAVANNA));

		EntityRegistry.addSpawn(EntityRobot.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityRobot.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityRobot.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityRobot.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityRobot.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityRobot.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SPOOKY));

		EntityRegistry.addSpawn(EntitySandCrawler.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SANDY));
		EntityRegistry.addSpawn(EntitySandCrawler.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntitySandCrawler.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntitySandCrawler.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntitySandCrawler.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntitySandCrawler.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		
		EntityRegistry.addSpawn(EntitySpyclops.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntitySpyclops.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntitySpyclops.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntitySpyclops.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntitySpyclops.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntitySpyclops.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		
		EntityRegistry.addSpawn(EntityReaper.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityReaper.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityReaper.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityReaper.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityReaper.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityReaper.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		
		EntityRegistry.addSpawn(EntityTurtle.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityTurtle.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityTurtle.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.COLD));
		EntityRegistry.addSpawn(EntityTurtle.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityTurtle.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityTurtle.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.SWAMP));
		EntityRegistry.addSpawn(EntityTurtle.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityTurtle.class, 4, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.WET));


	}
}