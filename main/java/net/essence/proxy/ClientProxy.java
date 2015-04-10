package net.essence.proxy;

import net.essence.Essence;
import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.BarTickHandler;
import net.essence.client.BossTickHandler;
import net.essence.client.EntityRendering;
import net.essence.client.GuiHandler;
import net.essence.client.MusicEvent;
import net.essence.client.MusicHandler;
import net.essence.client.PlayerStats;
import net.essence.enums.EnumParticlesClasses;
import net.essence.event.ClientTickEvent;
import net.essence.event.UpdateCheckerEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.SlayerAPI;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerClient() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Essence.instance, new GuiHandler());
		if(!SlayerAPI.DEVMODE) SlayerAPI.registerEvent(new UpdateCheckerEvent());
	}

	@Override
	public void clientPreInit() {
		registerModelBakery(EssenceBlocks.miniColouredBricks, miniBricks);
		registerModelBakery(EssenceBlocks.colouredBricks, brick);
		registerModelBakery(EssenceBlocks.brisonBlocks, new String[] {SlayerAPI.PREFIX + "darkBrisonBrick", SlayerAPI.PREFIX + "redBrisonBrick", SlayerAPI.PREFIX + "smallBrisonBrick", SlayerAPI.PREFIX + "brisonStone"});
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
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new MusicHandler()); //Only use if i want to remove every other music from vanilla or mods.
		FMLCommonHandler.instance().bus().register(new MusicEvent());
	}

	@Override
	public void clientInit(FMLInitializationEvent event) {
		EntityRendering.init();
		SlayerAPI.registerEvent(new BossTickHandler());
		SlayerAPI.registerEvent(new BarTickHandler());
		SlayerAPI.registerEvent(new ClientTickEvent());
		SlayerAPI.registerEvent(new PlayerStats());
	}

	public static String[] brick = {SlayerAPI.PREFIX + "blackColouredBrick", SlayerAPI.PREFIX + "blueColouredBrick", SlayerAPI.PREFIX + "brownColouredBrick", SlayerAPI.PREFIX + "cyanColouredBrick", SlayerAPI.PREFIX + "grayColouredBrick", SlayerAPI.PREFIX + "limeColouredBrick", SlayerAPI.PREFIX + "magentaColouredBrick", SlayerAPI.PREFIX + "orangeColouredBrick", SlayerAPI.PREFIX + "pinkColouredBrick", SlayerAPI.PREFIX + "purpleColouredBrick", SlayerAPI.PREFIX + "redColouredBrick", SlayerAPI.PREFIX + "whiteColouredBrick", SlayerAPI.PREFIX + "yellowColouredBrick"};
	public static String[] miniBricks = {SlayerAPI.PREFIX + "blackMiniColouredBrick", SlayerAPI.PREFIX + "blueMiniColouredBrick", SlayerAPI.PREFIX + "brownMiniColouredBrick", SlayerAPI.PREFIX + "cyanMiniColouredBrick", SlayerAPI.PREFIX + "grayMiniColouredBrick", SlayerAPI.PREFIX + "limeMiniColouredBrick", SlayerAPI.PREFIX + "magentaMiniColouredBrick", SlayerAPI.PREFIX + "orangeMiniColouredBrick", SlayerAPI.PREFIX + "pinkMiniColouredBrick", SlayerAPI.PREFIX + "purpleMiniColouredBrick", SlayerAPI.PREFIX + "redMiniColouredBrick", SlayerAPI.PREFIX + "whiteMiniColouredBrick", SlayerAPI.PREFIX + "yellowMiniColouredBrick"};
	public static String[] brickNames = {"blackColouredBrick", "blueColouredBrick", "brownColouredBrick", "cyanColouredBrick", "grayColouredBrick", "limeColouredBrick", "magentaColouredBrick", "orangeColouredBrick", "pinkColouredBrick", "purpleColouredBrick", "redColouredBrick", "whiteColouredBrick", "yellowColouredBrick"};
	public static String[] miniBricksName = {"blackMiniColouredBrick", "blueMiniColouredBrick", "brownMiniColouredBrick", "cyanMiniColouredBrick", "grayMiniColouredBrick", "limeMiniColouredBrick", "magentaMiniColouredBrick", "orangeMiniColouredBrick", "pinkMiniColouredBrick", "purpleMiniColouredBrick", "redMiniColouredBrick", "whiteMiniColouredBrick", "yellowMiniColouredBrick"};
	public static String[] brison = {"dark", "red", "small", "bstone"};

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

		for(int i = 0; i < 4; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "brisonBlocks");
			registerItem(it, i, brison[i]);
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