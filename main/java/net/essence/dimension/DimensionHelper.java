package net.essence.dimension;

import net.essence.dimension.boil.BiomeGenBoiling;
import net.essence.dimension.boil.WorldProviderBoiling;
import net.essence.dimension.cloudia.BiomeGenCloudia;
import net.essence.dimension.cloudia.WorldProviderCloudia;
import net.essence.dimension.corba.BiomeGenCorba;
import net.essence.dimension.corba.WorldProviderCorba;
import net.essence.dimension.depths.BiomeGenDepths;
import net.essence.dimension.depths.WorldProviderDepths;
import net.essence.dimension.euca.BiomeGenEuca;
import net.essence.dimension.euca.WorldProviderEuca;
import net.essence.dimension.frozen.BiomeGenFrozenLands;
import net.essence.dimension.frozen.WorldProviderFrozenLands;
import net.essence.dimension.wastelands.BiomeGenWastelands;
import net.essence.dimension.wastelands.WorldProviderWastelands;
import net.essence.entity.mob.boiling.EntityAshHoarder;
import net.essence.entity.mob.boiling.EntityBurningLight;
import net.essence.entity.mob.boiling.EntityBurntAsh;
import net.essence.entity.mob.boiling.EntityBurntMiner;
import net.essence.entity.mob.boiling.EntityCrisp;
import net.essence.entity.mob.boiling.EntityExposedFlame;
import net.essence.entity.mob.boiling.EntityMagmaBlaze;
import net.essence.entity.mob.boiling.EntityMagmaGiant;
import net.essence.entity.mob.corba.EntityLeafBlower;
import net.essence.entity.mob.corba.EntitySurfaceSeer;
import net.essence.entity.mob.corba.EntityTreeGolem;
import net.essence.entity.mob.corba.EntityWoodCreature;
import net.essence.entity.mob.depths.EntityDarknessCrawler;
import net.essence.entity.mob.depths.EntityDepthsBeast;
import net.essence.entity.mob.depths.EntityDepthsHunter;
import net.essence.entity.mob.depths.EntityRoc;
import net.essence.entity.mob.depths.EntitySpikedBeast;
import net.essence.entity.mob.euca.EntityDynaster;
import net.essence.entity.mob.euca.EntityEucaCharger;
import net.essence.entity.mob.euca.EntityEucaFighter;
import net.essence.entity.mob.euca.EntityEucaHopper;
import net.essence.entity.mob.euca.EntityGolder;
import net.essence.entity.mob.euca.EntityInsecto;
import net.essence.entity.mob.euca.EntityPsyollom;
import net.essence.entity.mob.frozen.EntityFrozenTroll;
import net.essence.entity.mob.frozen.EntityPermafraust;
import net.essence.entity.mob.frozen.EntityShatterer;
import net.essence.entity.mob.frozen.EntityShiveringBushwalker;
import net.essence.entity.mob.overworld.EntityBigHongo;
import net.essence.entity.mob.overworld.EntityBoom;
import net.essence.entity.mob.overworld.EntityBunny;
import net.essence.entity.mob.overworld.EntityFireMage;
import net.essence.entity.mob.overworld.EntityFish;
import net.essence.entity.mob.overworld.EntityIceMage;
import net.essence.entity.mob.overworld.EntityMediumHongo;
import net.essence.entity.mob.overworld.EntityReaper;
import net.essence.entity.mob.overworld.EntityRobot;
import net.essence.entity.mob.overworld.EntitySandCrawler;
import net.essence.entity.mob.overworld.EntitySmallHongo;
import net.essence.entity.mob.overworld.EntitySpyclops;
import net.essence.entity.mob.overworld.EntityTurtle;
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
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DimensionHelper {

	protected static final BiomeGenBase.Height boilHeight = new BiomeGenBase.Height(0.0F, 0.9F); 

	public static BiomeGenBase euca = new BiomeGenEuca(Config.eucaBiome).setHeight(new BiomeGenBase.Height(0.125F, 0.05F));
	public static BiomeGenBase depths = new BiomeGenDepths(Config.depthsBiome);
	public static BiomeGenBase boiling = new BiomeGenBoiling(Config.boilBiome).setHeight(boilHeight);
	public static BiomeGenBase frozen = new BiomeGenFrozenLands(Config.frozenBiome);
	public static BiomeGenBase corba = new BiomeGenCorba(Config.corbaBiome);
	public static BiomeGenBase wastelands = new BiomeGenWastelands(Config.wastelandsBiome);
	public static BiomeGenBase cloudia = new BiomeGenCloudia(Config.cloudiaBiome);

	public static void init(){
		addDimension(Config.euca, WorldProviderEuca.class, Config.keepLoadingEuca);
		addDimension(Config.depths, WorldProviderDepths.class, Config.keepLoadingDepths);
		addDimension(Config.boil, WorldProviderBoiling.class, Config.keepLoadingBoil);
		addDimension(Config.frozen, WorldProviderFrozenLands.class, Config.keepLoadingFrozen);
		addDimension(Config.corba, WorldProviderCorba.class, Config.keepLoadingCorba);
		addDimension(Config.wastelands, WorldProviderWastelands.class, Config.keepLoadingWastelands);
		addDimension(Config.cloudia, WorldProviderCloudia.class, Config.keepLoadingCloudia);
	}

	private static void addDimension(int id, Class<? extends WorldProvider> w, boolean keeploading) {
		LogHelper.info("Registering dimension ID: " + id);
		DimensionManager.registerProviderType(id, w, keeploading);
		DimensionManager.registerDimension(id, id);
	}

	public static void addSpawns() {
		addEucaSpawns();
		addFrozenSpawns();
		addBoilSpawns();
		addDepthsSpawns();
		addVanillaSpawns();
		addCorbaSpawns();
	}
	
	private static void addCorbaSpawns() {
		int amount = 2;
		EntityRegistry.addSpawn(EntityTreeGolem.class, 1, 1, 1, EnumCreatureType.MONSTER, corba);
		EntityRegistry.addSpawn(EntityLeafBlower.class, amount, 1, 1, EnumCreatureType.MONSTER, corba);
		EntityRegistry.addSpawn(EntitySurfaceSeer.class, amount, 1, 1, EnumCreatureType.MONSTER, corba);
		EntityRegistry.addSpawn(EntityWoodCreature.class, amount, 1, 1, EnumCreatureType.MONSTER, corba);
	}

	private static void addFrozenSpawns() {
		int amount = 2;
		//EntityRegistry.addSpawn(EntitySnowman.class, 2, 1, 6, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityFrozenTroll.class, 2, 1, 6, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityPermafraust.class, 2, 1, 6, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityShatterer.class, 2, 1, 6, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityShiveringBushwalker.class, 2, 1, 6, EnumCreatureType.CREATURE, frozen);
	}

	private static void addEucaSpawns() {
		int amount = 2;
		EntityRegistry.addSpawn(EntityEucaHopper.class, 1, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityEucaFighter.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityInsecto.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityPsyollom.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityEucaCharger.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityDynaster.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityGolder.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
	}

	private static void addBoilSpawns() {
		int amount = 3;
		EntityRegistry.addSpawn(EntityMagmaGiant.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityMagmaCube.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityBlaze.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityMagmaBlaze.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityCrisp.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityBurningLight.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityBurntAsh.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityExposedFlame.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityAshHoarder.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityBurntMiner.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
	}

	private static void addDepthsSpawns() {
		int amount = 2;
		EntityRegistry.addSpawn(EntityDarknessCrawler.class, amount, 1, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntityDepthsBeast.class, amount, 1, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntitySpikedBeast.class, amount, 1, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntityDepthsHunter.class, amount, 1, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntityRoc.class, amount, 1, 1, EnumCreatureType.MONSTER, depths);
	}

	private static void addVanillaSpawns() {
		int amount = 4;
		EntityRegistry.addSpawn(EntityBigHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityBigHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityBigHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityBigHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityBigHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));

		EntityRegistry.addSpawn(EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityMediumHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		
		EntityRegistry.addSpawn(EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntitySmallHongo.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
	
		EntityRegistry.addSpawn(EntityBunny.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityBunny.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityBunny.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityBunny.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityBunny.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		
		EntityRegistry.addSpawn(EntityBoom.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityBoom.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SANDY));
		EntityRegistry.addSpawn(EntityBoom.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityBoom.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SAVANNA));

		EntityRegistry.addSpawn(EntityRobot.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityRobot.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityRobot.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityRobot.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityRobot.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityRobot.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));

		EntityRegistry.addSpawn(EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SANDY));
		EntityRegistry.addSpawn(EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		
		EntityRegistry.addSpawn(EntitySpyclops.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntitySpyclops.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntitySpyclops.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntitySpyclops.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntitySpyclops.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntitySpyclops.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		
		EntityRegistry.addSpawn(EntityReaper.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityReaper.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityReaper.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityReaper.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityReaper.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityReaper.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		
		EntityRegistry.addSpawn(EntityTurtle.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityTurtle.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityTurtle.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityTurtle.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityTurtle.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SWAMP));
		EntityRegistry.addSpawn(EntityTurtle.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityTurtle.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));

		EntityRegistry.addSpawn(EntityFireMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityFireMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityFireMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityFireMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityFireMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DRY));
		EntityRegistry.addSpawn(EntityFireMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntityFireMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MAGICAL));

		EntityRegistry.addSpawn(EntityIceMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityIceMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityIceMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityIceMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityIceMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityIceMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntityIceMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MAGICAL));
		
		EntityRegistry.addSpawn(EntityFish.class, amount, 2, 5, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityFish.class, amount, 2, 5, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityFish.class, amount, 2, 5, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityFish.class, amount, 2, 5, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityFish.class, amount, 2, 5, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomesForType(Type.SWAMP));
		EntityRegistry.addSpawn(EntityFish.class, amount, 2, 5, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityFish.class, amount, 2, 5, EnumCreatureType.WATER_CREATURE, BiomeDictionary.getBiomesForType(Type.WET));
	}
}