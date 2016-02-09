package net.journey.dimension;

import net.journey.dimension.boil.BiomeGenBoiling;
import net.journey.dimension.boil.WorldProviderBoiling;
import net.journey.dimension.cloudia.BiomeGenCloudia;
import net.journey.dimension.cloudia.WorldProviderCloudia;
import net.journey.dimension.corba.BiomeGenCorba;
import net.journey.dimension.corba.WorldProviderCorba;
import net.journey.dimension.depths.BiomeGenDepths;
import net.journey.dimension.depths.WorldProviderDepths;
import net.journey.dimension.euca.BiomeGenEuca;
import net.journey.dimension.euca.WorldProviderEuca;
import net.journey.dimension.frozen.BiomeGenFrozenLands;
import net.journey.dimension.frozen.WorldProviderFrozenLands;
import net.journey.dimension.terrania.BiomeGenTerrania;
import net.journey.entity.mob.boiling.EntityBurningLight;
import net.journey.entity.mob.boiling.EntityFrightener;
import net.journey.entity.mob.boiling.EntityHellwing;
import net.journey.entity.mob.boiling.EntityMagmaBlaze;
import net.journey.entity.mob.boiling.EntityObserver;
import net.journey.entity.mob.cloudia.EntityCloudFlyer;
import net.journey.entity.mob.cloudia.EntityCloudGhost;
import net.journey.entity.mob.cloudia.EntitySkyEel;
import net.journey.entity.mob.cloudia.EntityStarlightGolem;
import net.journey.entity.mob.cloudia.EntityStarlightTransporter;
import net.journey.entity.mob.corba.EntityLeafBlower;
import net.journey.entity.mob.corba.EntitySurfaceSeer;
import net.journey.entity.mob.corba.EntityTreeGolem;
import net.journey.entity.mob.corba.EntityWoodCreature;
import net.journey.entity.mob.depths.EntityDarkener;
import net.journey.entity.mob.depths.EntityDarknessCrawler;
import net.journey.entity.mob.depths.EntityDepthsBeast;
import net.journey.entity.mob.depths.EntityDepthsHunter;
import net.journey.entity.mob.depths.EntityLightener;
import net.journey.entity.mob.depths.EntityRoc;
import net.journey.entity.mob.depths.EntitySpikedBeast;
import net.journey.entity.mob.euca.EntityDynaster;
import net.journey.entity.mob.euca.EntityEucaCharger;
import net.journey.entity.mob.euca.EntityGolder;
import net.journey.entity.mob.euca.EntityGolditeMage;
import net.journey.entity.mob.euca.EntityShimmerer;
import net.journey.entity.mob.frozen.EntityCrystalCluster;
import net.journey.entity.mob.frozen.EntityFrozenTroll;
import net.journey.entity.mob.frozen.EntityPermafraust;
import net.journey.entity.mob.frozen.EntityShatterer;
import net.journey.entity.mob.frozen.EntityShiveringBushwalker;
import net.journey.entity.mob.overworld.EntityBigHongo;
import net.journey.entity.mob.overworld.EntityBoom;
import net.journey.entity.mob.overworld.EntityFireMage;
import net.journey.entity.mob.overworld.EntityFloro;
import net.journey.entity.mob.overworld.EntityIceMage;
import net.journey.entity.mob.overworld.EntityMediumHongo;
import net.journey.entity.mob.overworld.EntityReaper;
import net.journey.entity.mob.overworld.EntityRobot;
import net.journey.entity.mob.overworld.EntitySandCrawler;
import net.journey.entity.mob.overworld.EntitySmallHongo;
import net.journey.entity.mob.overworld.EntitySpyclops;
import net.journey.entity.mob.overworld.underground.EntityBlueHonglow;
import net.journey.entity.mob.overworld.underground.EntityCaveMage;
import net.journey.entity.mob.overworld.underground.EntityCaveling;
import net.journey.entity.mob.overworld.underground.EntityCavurn;
import net.journey.entity.mob.overworld.underground.EntityGreenHonglow;
import net.journey.entity.mob.overworld.underground.EntityHonglow;
import net.journey.entity.mob.overworld.underground.EntityStonewalker;
import net.journey.entity.mob.terrania.mob.EntityTerraScatterer;
import net.journey.entity.mob.terrania.mob.EntityTerralight;
import net.journey.util.Config;
import net.journey.util.LogHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DimensionHelper {

	protected static final BiomeGenBase.Height boilHeight = new BiomeGenBase.Height(0.125F, 0.1F); 
	protected static final BiomeGenBase.Height corbaHeight = new BiomeGenBase.Height(0.2F, 0.2F); 

	public static BiomeGenBase euca = new BiomeGenEuca(Config.eucaBiome).setHeight(new BiomeGenBase.Height(0.125F, 0.05F));
	public static BiomeGenBase depths = new BiomeGenDepths(Config.depthsBiome);
	public static BiomeGenBase boiling = new BiomeGenBoiling(Config.boilBiome).setHeight(boilHeight);
	public static BiomeGenBase frozen = new BiomeGenFrozenLands(Config.frozenBiome);
	public static BiomeGenBase corba = new BiomeGenCorba(Config.corbaBiome).setHeight(corbaHeight);
	//public static BiomeGenBase wastelands = new BiomeGenWastelands(Config.wastelandsBiome);
	public static BiomeGenBase cloudia = new BiomeGenCloudia(Config.cloudiaBiome);
	public static BiomeGenBase terrania = new BiomeGenTerrania(Config.terraniaBiome);

	public static void init(){
		addDimension(Config.euca, WorldProviderEuca.class, Config.keepLoadingEuca);
		addDimension(Config.depths, WorldProviderDepths.class, Config.keepLoadingDepths);
		addDimension(Config.boil, WorldProviderBoiling.class, Config.keepLoadingBoil);
		addDimension(Config.frozen, WorldProviderFrozenLands.class, Config.keepLoadingFrozen);
		addDimension(Config.corba, WorldProviderCorba.class, Config.keepLoadingCorba);
		//addDimension(Config.wastelands, WorldProviderWastelands.class, Config.keepLoadingWastelands);
		addDimension(Config.cloudia, WorldProviderCloudia.class, Config.keepLoadingCloudia);
		addDimension(Config.terrania, WorldProviderCloudia.class, Config.keepLoadingTerrania);
	}

	private static void addDimension(int id, Class<? extends WorldProvider> w, boolean keeploading) {
		LogHelper.info("Registering dimension ID: " + id);
		DimensionManager.registerProviderType(id, w, keeploading);
		DimensionManager.registerDimension(id, id);
	}

	public static void addSpawns() {
		addEucaSpawns();
		addFrostFrozenSpawns();
		addColdFrozenSpawns();
		addBoilSpawns();
		addDepthsSpawns();
		addVanillaSpawns();
		addCaveSpawns();
		addCorbaSpawns();
		addCloudiaSpawns();
		addTerraniaSpawns();
		addRareVanillaSpawns();
	}
	
	private static void addCloudiaSpawns() {
		int amount = 100;
		EntityRegistry.addSpawn(EntityStarlightTransporter.class, 1, 1, 1, EnumCreatureType.MONSTER, cloudia);
		EntityRegistry.addSpawn(EntityStarlightGolem.class, 1, 1, 1, EnumCreatureType.MONSTER, cloudia);
		EntityRegistry.addSpawn(EntityCloudFlyer.class, 1, 1, 1, EnumCreatureType.MONSTER, cloudia);
		EntityRegistry.addSpawn(EntityCloudGhost.class, 1, 1, 1, EnumCreatureType.MONSTER, cloudia);
		EntityRegistry.addSpawn(EntitySkyEel.class, amount, 1, 1, EnumCreatureType.MONSTER, cloudia);
	}

	private static void addCorbaSpawns() {
		int amount = 4;
		EntityRegistry.addSpawn(EntityTreeGolem.class, 1, 1, 1, EnumCreatureType.MONSTER, corba);
		EntityRegistry.addSpawn(EntityLeafBlower.class, amount, 1, 1, EnumCreatureType.MONSTER, corba);
		EntityRegistry.addSpawn(EntitySurfaceSeer.class, amount, 1, 1, EnumCreatureType.MONSTER, corba);
		EntityRegistry.addSpawn(EntityWoodCreature.class, amount, 1, 1, EnumCreatureType.MONSTER, corba);
	}
	private static void addColdFrozenSpawns() {
		int amount = 10;
		//EntityRegistry.addSpawn(EntitySnowman.class, 2, 1, 6, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityFrozenTroll.class, 1, 1, 1, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityPermafraust.class, 1, 1, 1, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityShiveringBushwalker.class, 1, 1, 1, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityIceMage.class, 1, 1, 1, EnumCreatureType.CREATURE, frozen);
		
	}

	private static void addFrostFrozenSpawns() {
		int amount = 10;
		//EntityRegistry.addSpawn(EntitySnowman.class, 2, 1, 6, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityPermafraust.class, 1, 1, 1, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityShatterer.class, 1, 1, 1, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityCrystalCluster.class, 1, 1, 1, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityIceMage.class, 1, 1, 1, EnumCreatureType.CREATURE, frozen);
	}
	
	private static void addTerraniaSpawns() {
		int amount = 10;
		//EntityRegistry.addSpawn(EntitySnowman.class, 2, 1, 6, EnumCreatureType.CREATURE, frozen);
		EntityRegistry.addSpawn(EntityTerraScatterer.class, 1, 1, 1, EnumCreatureType.CREATURE, terrania);
		EntityRegistry.addSpawn(EntityTerralight.class, 1, 1, 1, EnumCreatureType.CREATURE, terrania);
	}

	private static void addEucaSpawns() {
		int amount = 2;
		//EntityRegistry.addSpawn(EntityEucaHopper.class, 1, 1, 1, EnumCreatureType.MONSTER, euca);
		//EntityRegistry.addSpawn(EntityEucaFighter.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		//EntityRegistry.addSpawn(EntityInsecto.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		//EntityRegistry.addSpawn(EntityPsyollom.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityEucaCharger.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityDynaster.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityGolder.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityShimmerer.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
		EntityRegistry.addSpawn(EntityGolditeMage.class, amount, 1, 1, EnumCreatureType.MONSTER, euca);
	}

	private static void addBoilSpawns() {
		int amount = 10;
		//EntityRegistry.addSpawn(EntityMagmaGiant.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		//EntityRegistry.addSpawn(EntityMagmaCube.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		//EntityRegistry.addSpawn(EntityBlaze.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		//EntityRegistry.addSpawn(EntityCrisp.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		//EntityRegistry.addSpawn(EntityBurntAsh.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		//EntityRegistry.addSpawn(EntityExposedFlame.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		//EntityRegistry.addSpawn(EntityAshHoarder.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		//EntityRegistry.addSpawn(EntityBurntMiner.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityFrightener.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityBurningLight.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityMagmaBlaze.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityHellwing.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
		EntityRegistry.addSpawn(EntityObserver.class, amount, 1, 1, EnumCreatureType.MONSTER, boiling);
	}

	private static void addDepthsSpawns() {
		int amount = 2;
		EntityRegistry.addSpawn(EntityDarknessCrawler.class, amount, 10, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntityDepthsBeast.class, amount, 10, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntitySpikedBeast.class, amount, 10, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntityDepthsHunter.class, amount, 10, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntityRoc.class, amount, 10, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntityDarkener.class, amount, 10, 1, EnumCreatureType.MONSTER, depths);
		EntityRegistry.addSpawn(EntityLightener.class, amount, 10, 1, EnumCreatureType.MONSTER, depths);
	}
	
	private static void addCaveSpawns() {
		int amount = 70;
		
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SAVANNA));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MAGICAL));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityCaveMage.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.CONIFEROUS));
		
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SAVANNA));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MAGICAL));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityCaveling.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.CONIFEROUS));
		
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SAVANNA));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MAGICAL));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityCavurn.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.CONIFEROUS));
		
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SAVANNA));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MAGICAL));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityStonewalker.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.CONIFEROUS));
		
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SAVANNA));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MAGICAL));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.CONIFEROUS));
		
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SAVANNA));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MAGICAL));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityBlueHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.CONIFEROUS));
		
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MUSHROOM));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WASTELAND));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SAVANNA));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MOUNTAIN));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SPOOKY));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WATER));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.WET));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.MAGICAL));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.BEACH));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.SNOWY));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityGreenHonglow.class, amount, 2, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.CONIFEROUS));
		
	}

	private static void addRareVanillaSpawns() {
		int amount = 4;
		
	}
	
	private static void addVanillaSpawns() {
		int amount = 4;
		
		EntityRegistry.addSpawn(EntityFloro.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityFloro.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DENSE));
		EntityRegistry.addSpawn(EntityFloro.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityFloro.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		
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
		EntityRegistry.addSpawn(EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.DEAD));
		EntityRegistry.addSpawn(EntitySandCrawler.class, amount, 1, 1, EnumCreatureType.MONSTER, BiomeDictionary.getBiomesForType(Type.HOT));
		
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
	}
}