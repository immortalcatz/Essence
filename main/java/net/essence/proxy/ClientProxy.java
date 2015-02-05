package net.essence.proxy;

import net.essence.*;
import net.essence.client.*;
import net.essence.enums.*;
import net.essence.event.*;
import net.essence.util.Config;
import net.minecraft.block.*;
import net.minecraft.client.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.client.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.*;
import net.minecraftforge.fml.common.registry.*;
import net.slayer.api.*;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerClient() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Essence.instance, new GuiHandler());
		if(!SlayerAPI.DEVMODE) SlayerAPI.addEventBus(new UpdateCheckerEvent());
	}

	@Override
	public void clientPreInit() {
		registerModelBakery(EssenceBlocks.miniColouredBricks, miniBricks);
		registerModelBakery(EssenceBlocks.colouredBricks, brick);
		registerModelBakery(EssenceBlocks.storageBlocks, names);
		registerModelBakery(EssenceBlocks.storageBlocks1, names1);
		registerModelBakery(EssenceBlocks.storageBlocks2, names2);
		registerModelBakery(EssenceBlocks.storageBlocks3, names3);
		registerModelBakery(EssenceItems.flameBow, new String[] {SlayerAPI.PREFIX + "flameBow", SlayerAPI.PREFIX + "flameBow_0", SlayerAPI.PREFIX + "flameBow_1", SlayerAPI.PREFIX + "flameBow_2"});
		addBow(EssenceItems.flameBow, "flameBow");
		addBow(EssenceItems.poisonBow, "poisonBow");
		addBow(EssenceItems.darknessBow, "darknessBow");
		addBow(EssenceItems.frozenBow, "frozenBow");
		addBow(EssenceItems.staringBow, "staringBow");
	}
	
	public void addBow(Item bow, String name) {
		registerModelBakery(bow, new String[] {SlayerAPI.PREFIX + name, SlayerAPI.PREFIX + name + "_0", SlayerAPI.PREFIX + name + "_1", SlayerAPI.PREFIX  + name + "_2"});
	}

	@Override
	public void registerSounds() {
		//((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new MusicHandler()); //Only use if i want to remove every other music from vanilla or mods.
		FMLCommonHandler.instance().bus().register(new MusicEvent());
	}

	@Override
	public void clientInit(FMLInitializationEvent event) {
		EntityRendering.init();
		SlayerAPI.addForgeEventBus(new BossTickHandler());
		SlayerAPI.addForgeEventBus(new BarTickHandler());
		if(Config.reRenderPlayerStats) SlayerAPI.addForgeEventBus(new PlayerStats());
		if(Config.reRenderPlayerStats) SlayerAPI.addEventBus(new PlayerStats());
	}

	public static String[] names = {SlayerAPI.PREFIX + "dirt", SlayerAPI.PREFIX + "birchPlanks", SlayerAPI.PREFIX + "oakPlanks", SlayerAPI.PREFIX + "junglePlanks", SlayerAPI.PREFIX + "sprucePlanks", SlayerAPI.PREFIX + "darkOakPlanks", SlayerAPI.PREFIX + "acaciaPlanks", SlayerAPI.PREFIX + "potatoes", SlayerAPI.PREFIX + "wheat", SlayerAPI.PREFIX + "carrots", SlayerAPI.PREFIX + "obsidian", SlayerAPI.PREFIX + "netherrack", SlayerAPI.PREFIX + "netherBrick", SlayerAPI.PREFIX + "redMushroom", SlayerAPI.PREFIX + "brownMushroom", SlayerAPI.PREFIX + "melon"};
	public static String[] names1 = {SlayerAPI.PREFIX + "pumpkin", SlayerAPI.PREFIX + "birchLog", SlayerAPI.PREFIX + "oakLog", SlayerAPI.PREFIX + "jungleLog", SlayerAPI.PREFIX + "spruceLog", SlayerAPI.PREFIX + "darkOakLog", SlayerAPI.PREFIX + "acaciaLog", SlayerAPI.PREFIX + "lapisOre", SlayerAPI.PREFIX + "diamondOre", SlayerAPI.PREFIX + "goldOre", SlayerAPI.PREFIX + "quartzOre", SlayerAPI.PREFIX + "shadiumOreStorage", SlayerAPI.PREFIX + "luniumOreStorage", SlayerAPI.PREFIX + "sapphireOreStorage", SlayerAPI.PREFIX + "celestiumOreStorage", SlayerAPI.PREFIX + "flairiumOreStorage"};
	public static String[] names2 = {SlayerAPI.PREFIX + "hellstoneOreStorage", SlayerAPI.PREFIX + "ashualOreStorage", SlayerAPI.PREFIX + "ironOre", SlayerAPI.PREFIX + "coalOre", SlayerAPI.PREFIX + "redstoneOre", SlayerAPI.PREFIX + "emeraldOre", SlayerAPI.PREFIX + "hay", SlayerAPI.PREFIX + "gravel", SlayerAPI.PREFIX + "glass", SlayerAPI.PREFIX + "redFlower", SlayerAPI.PREFIX + "yellowFlower", SlayerAPI.PREFIX + "endStone", SlayerAPI.PREFIX + "bush", SlayerAPI.PREFIX + "cobblestone", SlayerAPI.PREFIX + "mossyCobblestone", SlayerAPI.PREFIX + "cake"};
	public static String[] names3 = {SlayerAPI.PREFIX + "cactus", SlayerAPI.PREFIX + "brick", SlayerAPI.PREFIX + "bookshelf", SlayerAPI.PREFIX + "glowstone", SlayerAPI.PREFIX + "redSand", SlayerAPI.PREFIX + "sand", SlayerAPI.PREFIX + "sponge", SlayerAPI.PREFIX + "soulSand", SlayerAPI.PREFIX + "tnt", SlayerAPI.PREFIX + "stone", SlayerAPI.PREFIX + "waterlilly", SlayerAPI.PREFIX + "enderilliumOreStorage"};
	public static String[] brick = {SlayerAPI.PREFIX + "blackColouredBrick", SlayerAPI.PREFIX + "blueColouredBrick", SlayerAPI.PREFIX + "brownColouredBrick", SlayerAPI.PREFIX + "cyanColouredBrick", SlayerAPI.PREFIX + "grayColouredBrick", SlayerAPI.PREFIX + "limeColouredBrick", SlayerAPI.PREFIX + "magentaColouredBrick", SlayerAPI.PREFIX + "orangeColouredBrick", SlayerAPI.PREFIX + "pinkColouredBrick", SlayerAPI.PREFIX + "purpleColouredBrick", SlayerAPI.PREFIX + "redColouredBrick", SlayerAPI.PREFIX + "whiteColouredBrick", SlayerAPI.PREFIX + "yellowColouredBrick"};
	public static String[] miniBricks = {SlayerAPI.PREFIX + "blackMiniColouredBrick", SlayerAPI.PREFIX + "blueMiniColouredBrick", SlayerAPI.PREFIX + "brownMiniColouredBrick", SlayerAPI.PREFIX + "cyanMiniColouredBrick", SlayerAPI.PREFIX + "grayMiniColouredBrick", SlayerAPI.PREFIX + "limeMiniColouredBrick", SlayerAPI.PREFIX + "magentaMiniColouredBrick", SlayerAPI.PREFIX + "orangeMiniColouredBrick", SlayerAPI.PREFIX + "pinkMiniColouredBrick", SlayerAPI.PREFIX + "purpleMiniColouredBrick", SlayerAPI.PREFIX + "redMiniColouredBrick", SlayerAPI.PREFIX + "whiteMiniColouredBrick", SlayerAPI.PREFIX + "yellowMiniColouredBrick"};
	public static String[] brickNames = {"blackColouredBrick", "blueColouredBrick", "brownColouredBrick", "cyanColouredBrick", "grayColouredBrick", "limeColouredBrick", "magentaColouredBrick", "orangeColouredBrick", "pinkColouredBrick", "purpleColouredBrick", "redColouredBrick", "whiteColouredBrick", "yellowColouredBrick"};
	public static String[] miniBricksName = {"blackMiniColouredBrick", "blueMiniColouredBrick", "brownMiniColouredBrick", "cyanMiniColouredBrick", "grayMiniColouredBrick", "limeMiniColouredBrick", "magentaMiniColouredBrick", "orangeMiniColouredBrick", "pinkMiniColouredBrick", "purpleMiniColouredBrick", "redMiniColouredBrick", "whiteMiniColouredBrick", "yellowMiniColouredBrick"};
	public static String[] namesN = {"dirt", "birchPlanks", "oakPlanks", "junglePlanks", "sprucePlanks", "darkOakPlanks", "acaciaPlanks", "potatoes", "wheat", "carrots", "obsidian", "netherrack", "netherBrick", "redMushroom", "brownMushroom", "melon"};
	public static String[] names1N = {"pumpkin", "birchLog", "oakLog", "jungleLog", "spruceLog", "darkOakLog", "acaciaLog", "lapisOre", "diamondOre", "goldOre", "quartzOre", "shadiumOreStorage", "luniumOreStorage", "sapphireOreStorage", "celestiumOreStorage", "flairiumOreStorage"};
	public static String[] names2N = {"hellstoneOreStorage", "ashualOreStorage", "ironOre", "coalOre", "redstoneOre", "emeraldOre", "hay", "gravel", "glass", "redFlower", "yellowFlower", "endStone", "bush", "cobblestone", "mossyCobblestone", "cake"};
	public static String[] names3N = {"cactus", "brick", "bookshelf", "glowstone", "redSand", "sand", "sponge", "soulSand", "tnt", "stone", "waterlilly", "enderilliumOreStorage"};

	@Override
	public void registerModModels() {
		for(String s : EssenceBlocks.blockName) {
			Item i = GameRegistry.findItem(SlayerAPI.MOD_ID, s);
			registerItem(i, s);
		}

		for(String s : EssenceItems.itemNames) {
			Item i = GameRegistry.findItem(SlayerAPI.MOD_ID, s);
			registerItem(i, s);
		}

		addBowRegistry(EssenceItems.flameBow, "flameBow");
		addBowRegistry(EssenceItems.poisonBow, "poisonBow");
		addBowRegistry(EssenceItems.darknessBow, "darknessBow");
		addBowRegistry(EssenceItems.frozenBow, "frozenBow");
		addBowRegistry(EssenceItems.staringBow, "staringBow");

		for(int i = 0; i < brickNames.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockColouredBricks");
			registerItem(it, i, brickNames[i]);
		}

		for(int i = 0; i < miniBricksName.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockMiniColouredBricks");
			registerItem(it, i, miniBricksName[i]);
		}

		for(int i = 0; i < namesN.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockStorageBlocks");
			registerItem(it, i, namesN[i]);
		}

		for(int i = 0; i < names1N.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockStorageBlocks1");
			registerItem(it, i, names1N[i]);
		}

		for(int i = 0; i < names2N.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockStorageBlocks2");
			registerItem(it, i, names2N[i]);
		}
		
		for(int i = 0; i < names3N.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockStorageBlocks3");
			registerItem(it, i, names3N[i]);
		}
	}
	
	public void addBowRegistry(Item bow, String name) {
		registerItem(bow, 0, name);
		registerItem(bow, 1, name + "_0");
		registerItem(bow, 2, name + "_1");
		registerItem(bow, 3, name + "_2");
	}

	public static void registerModelBakery(Item i, String[] names) {
		ModelBakery.addVariantName(i, names);
	}

	public static void registerModelBakery(Block b, String[] names) {
		ModelBakery.addVariantName(SlayerAPI.toItem(b), names);
	}

	public static void registerItem(Item item, int metadata, String itemName) {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		mesher.register(item, metadata, new ModelResourceLocation(SlayerAPI.PREFIX + itemName, "inventory"));
	}

	public static void registerBlock(Block block, int metadata, String blockName) {
		registerItem(Item.getItemFromBlock(block), metadata, blockName);
	}

	public static void registerBlock(Block block, String blockName) {
		registerBlock(block, 0, blockName);
	}

	public static void registerItem(Item item, String itemName) {
		registerItem(item, 0, itemName);
	}

	@Override
	public void spawnParticle(EnumParticlesClasses particle, World worldObj, double posX, double posY, double posZ, boolean b) {
		if(!worldObj.isRemote) {
			try {
				EntityFX fx = null;
				if(b) {
					fx = (EntityFX)particle.getParticle().getConstructor(World.class, double.class, double.class, double.class).newInstance(worldObj, posX, posY, posZ);
				} else {
					fx = (EntityFX)particle.getParticle().getConstructor(World.class, double.class, double.class, double.class, double.class, double.class, double.class).newInstance(worldObj, posX, posY, posZ, 0D, 0D, 0D);
				}
				FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}