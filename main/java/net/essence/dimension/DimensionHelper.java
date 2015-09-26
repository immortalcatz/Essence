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
import net.essence.entity.mob.boiling.EntityBurningLight;
import net.essence.entity.mob.boiling.EntityFrightener;
import net.essence.entity.mob.boiling.EntityHellwing;
import net.essence.entity.mob.boiling.EntityMagmaBlaze;
import net.essence.entity.mob.boiling.EntityObserver;
import net.essence.entity.mob.cloudia.EntityCloudFlyer;
import net.essence.entity.mob.cloudia.EntityCloudGhost;
import net.essence.entity.mob.cloudia.EntitySkyEel;
import net.essence.entity.mob.cloudia.EntityStarlightGolem;
import net.essence.entity.mob.cloudia.EntityStarlightTransporter;
import net.essence.entity.mob.corba.EntityLeafBlower;
import net.essence.entity.mob.corba.EntitySurfaceSeer;
import net.essence.entity.mob.corba.EntityTreeGolem;
import net.essence.entity.mob.corba.EntityWoodCreature;
import net.essence.entity.mob.depths.EntityDarkener;
import net.essence.entity.mob.depths.EntityDarknessCrawler;
import net.essence.entity.mob.depths.EntityDepthsBeast;
import net.essence.entity.mob.depths.EntityDepthsHunter;
import net.essence.entity.mob.depths.EntityLightener;
import net.essence.entity.mob.depths.EntityRoc;
import net.essence.entity.mob.depths.EntitySpikedBeast;
import net.essence.entity.mob.euca.EntityDynaster;
import net.essence.entity.mob.euca.EntityEucaCharger;
import net.essence.entity.mob.euca.EntityGolder;
import net.essence.entity.mob.euca.EntityGolditeMage;
import net.essence.entity.mob.euca.EntityShimmerer;
import net.essence.entity.mob.frozen.EntityCrystalCluster;
import net.essence.entity.mob.frozen.EntityFrozenTroll;
import net.essence.entity.mob.frozen.EntityPermafraust;
import net.essence.entity.mob.frozen.EntityShatterer;
import net.essence.entity.mob.frozen.EntityShiveringBushwalker;
import net.essence.entity.mob.overworld.EntityBigHongo;
import net.essence.entity.mob.overworld.EntityBoom;
import net.essence.entity.mob.overworld.EntityFireMage;
import net.essence.entity.mob.overworld.EntityFloro;
import net.essence.entity.mob.overworld.EntityIceMage;
import net.essence.entity.mob.overworld.EntityMediumHongo;
import net.essence.entity.mob.overworld.EntityReaper;
import net.essence.entity.mob.overworld.EntityRobot;
import net.essence.entity.mob.overworld.EntitySandCrawler;
import net.essence.entity.mob.overworld.EntitySmallHongo;
import net.essence.entity.mob.overworld.EntitySpyclops;
import net.essence.entity.mob.overworld.underground.EntityBlueHonglow;
import net.essence.entity.mob.overworld.underground.EntityCaveMage;
import net.essence.entity.mob.overworld.underground.EntityCaveling;
import net.essence.entity.mob.overworld.underground.EntityCavurn;
import net.essence.entity.mob.overworld.underground.EntityGreenHonglow;
import net.essence.entity.mob.overworld.underground.EntityHonglow;
import net.essence.entity.mob.overworld.underground.EntityStonewalker;
import net.essence.util.Config;
import net.essence.util.LogHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DimensionHelper {

	protected static final BiomeGenBase.Height boilHeight = new BiomeGenBase.Height(0.0F, 0.9F); 
	protected static final BiomeGenBase.Height corbaHeight = new BiomeGenBase.Height(0.2F, 0.2F); 

	public static BiomeGenBase euca = new BiomeGenEuca(Config.eucaBiome).setHeight(new BiomeGenBase.Height(0.125F, 0.05F));
	public static BiomeGenBase depths = new BiomeGenDepths(Config.depthsBiome);
	public static BiomeGenBase boiling = new BiomeGenBoiling(Config.boilBiome).setHeight(boilHeight);
	public static BiomeGenBase frozen = new BiomeGenFrozenLands(Config.frozenBiome);
	public static BiomeGenBase corba = new BiomeGenCorba(Config.corbaBiome).setHeight(corbaHeight);
	//public static BiomeGenBase wastelands = new BiomeGenWastelands(Config.wastelandsBiome);
	public static BiomeGenBase cloudia = new BiomeGenCloudia(Config.cloudiaBiome);

	public static void init(){
		addDimension(Config.euca, WorldProviderEuca.class, Config.keepLoadingEuca);
		addDimension(Config.depths, WorldProviderDepths.class, Config.keepLoadingDepths);
		addDimension(Config.boil, WorldProviderBoiling.class, Config.keepLoadingBoil);
		addDimension(Config.frozen, WorldProviderFrozenLands.class, Config.keepLoadingFrozen);
		addDimension(Config.corba, WorldProviderCorba.class, Config.keepLoadingCorba);
		//addDimension(Config.wastelands, WorldProviderWastelands.class, Config.keepLoadingWastelands);
		addDimension(Config.cloudia, WorldProviderCloudia.class, Config.keepLoadingCloudia);
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
		addRareVanillaSpawns();
	}
	
	private static void addCloudiaSpawns() {
		int amount = 90;
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
		int amount = 5;
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
		int amount = 70;
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