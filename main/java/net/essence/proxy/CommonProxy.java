package net.essence.proxy;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityCorbaPortal;
import net.essence.blocks.tileentity.TileEntityEnrichedTable;
import net.essence.blocks.tileentity.TileEntityEssenceSign;
import net.essence.blocks.tileentity.TileEntityGrindstone;
import net.essence.blocks.tileentity.TileEntityIncubator;
import net.essence.blocks.tileentity.TileEntityKnowledgeTable;
import net.essence.blocks.tileentity.TileEntityStatue;
import net.essence.blocks.tileentity.TileEntitySummoningTable;
import net.essence.dimension.DimensionHelper;
import net.essence.dimension.WorldGenEssence;
import net.essence.enums.EnumParticlesClasses;
import net.essence.event.ArmorAbilityEvent;
import net.essence.event.KnowledgeEvent;
import net.essence.event.PlayerEvent;
import net.essence.items.tileentity.TileEntityBackpack;
import net.essence.misc.DimensionCommand;
import net.essence.misc.EssenceCommands;
import net.essence.util.Config;
import net.essence.util.EntityRegistry;
import net.essence.util.recipes.RecipeHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.slayer.api.SlayerAPI;

public class CommonProxy {

	public void updateDarkEnergy(int amount) { }
	public void updateEssence(int amount) { }
	public void updatePower(int amount) { }
	public void registerClient() { }
	public void clientInit(FMLInitializationEvent event) { }
	public void clientPreInit() { }
	public void registerSounds() { }
	public void spawnParticle(EnumParticlesClasses particle, World worldObj, double x, double y, double z, boolean b) { }
	public void registerModModels() { }
	
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event);
		//Essence.tropicalWater.setBlock(EssenceBlocks.tropicalWater);
		EntityRegistry.init();
		RecipeHelper.init();
		DimensionHelper.init();
		DimensionHelper.addSpawns();
		EssenceTabs.init();
		addOreDictionary();
		SlayerAPI.registerEvent(new ArmorAbilityEvent());
		SlayerAPI.registerEvent(new PlayerEvent());
		SlayerAPI.registerEvent(new KnowledgeEvent());
		GameRegistry.registerTileEntity(TileEntityStatue.class, "EssenceStatue");
		GameRegistry.registerTileEntity(TileEntityEnrichedTable.class, "Enriched table");
		GameRegistry.registerTileEntity(TileEntityIncubator.class, "incubator");
		GameRegistry.registerTileEntity(TileEntityBackpack.class, "backpack");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, "grindstone");
		GameRegistry.registerTileEntity(TileEntityCorbaPortal.class, "Corba Portal");
		GameRegistry.registerTileEntity(TileEntityEssenceSign.class, "Essence Sign");
		GameRegistry.registerTileEntity(TileEntityKnowledgeTable.class, "Knowledge Table");
		GameRegistry.registerTileEntity(TileEntitySummoningTable.class, "Summon Table");
		//SlayerAPI.addMapGen(MapGenBoilVillage.Start.class, "Boil Village");
		//SlayerAPI.addMapGen(MapGenBoilBridge.Start.class, "Boil Bridge");
		//StructureBoilBridgePieces.registerBoilFortressPieces();
		//StructureBoilVillagePieces.registerVillagePieces();
		MinecraftForge.addGrassSeed(new ItemStack(EssenceItems.tomatoSeeds), 5);
	}
	
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGenEssence(), 2);
		SlayerAPI.registerEvent(new PlayerEvent());
		SlayerAPI.registerEvent(new KnowledgeEvent());
		//EssenceAchievements.init();
	}
	
	public void postInit(FMLPostInitializationEvent event) { }
	
	public void serverStarting(FMLServerStartingEvent event) {
		SlayerAPI.registerCommand(new EssenceCommands());
		SlayerAPI.registerCommand(new DimensionCommand());
	}
	
	private void addOreDictionary() {
		OreDictionary.registerOre("oreAshual", EssenceBlocks.ashual);
		OreDictionary.registerOre("oreCelestium", EssenceBlocks.celestiumOre);
		OreDictionary.registerOre("oreLunium", EssenceBlocks.luniumOre);
		OreDictionary.registerOre("oreShadium", EssenceBlocks.shadiumOre);
		OreDictionary.registerOre("oreFlairium", EssenceBlocks.flairiumOre);
		OreDictionary.registerOre("oreSapphire", EssenceBlocks.sapphireOre);
		OreDictionary.registerOre("ash", EssenceItems.ash);
		OreDictionary.registerOre("ingotCelestium", EssenceItems.celestiumIngot);
		OreDictionary.registerOre("ingotLunium", EssenceItems.luniumIngot);
		OreDictionary.registerOre("ingotShadium", EssenceItems.shadiumIngot);
		OreDictionary.registerOre("ingotFlairium", EssenceItems.flairiumIngot);
		OreDictionary.registerOre("gemSapphire", EssenceItems.sapphire);
	}
}