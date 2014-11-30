package net.essence.proxy;

import net.essence.Essence;
import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.BarTickHandler;
import net.essence.client.BossTickHandler;
import net.essence.client.EntityRendering;
import net.essence.client.GuiHandler;
import net.essence.client.MusicEvent;
import net.essence.client.PlayerStats;
import net.essence.client.render.EnumParticlesClasses;
import net.essence.event.UpdateCheckerEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.slayer.api.SlayerAPI;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerClient() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Essence.instance, new GuiHandler());
		EntityRendering.init();
		if(!SlayerAPI.DEVMODE) SlayerAPI.addEventBus(new UpdateCheckerEvent());
	}

	@Override
	public void registerSounds() {
		//((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new MusicHandler());
		FMLCommonHandler.instance().bus().register(new MusicEvent());
	}

	@Override
	public void clientInit(FMLInitializationEvent event) {
		SlayerAPI.addForgeEventBus(new BossTickHandler());
		SlayerAPI.addForgeEventBus(new BarTickHandler());
		SlayerAPI.addForgeEventBus(new PlayerStats());
		SlayerAPI.addEventBus(new PlayerStats());
	}

	public static String[] names = {"dirt", "birchPlanks", "oakPlanks", "junglePlanks", "sprucePlanks", "darkOakPlanks", "acaciaPlanks", "potatoes", "wheat", "carrots", "obsidian", "netherrack", "netherBrick", "redMushroom", "brownMushroom", "melon"};
	public static String[] names1 = {"pumpkin", "birchLog", "oakLog", "jungleLog", "spruceLog", "darkOakLog", "acaciaLog", "lapisOre", "diamondOre", "goldOre", "quartzOre", "shadiumOre", "luniumOre", "sapphireOre", "celestiumOre", "flairiumOre"};
	public static String[] names2 = {"hellstoneOre", "ashualOre", "ironOre", "coalOre", "redstoneOre", "emeraldOre", "hay", "gravel", "glass", "redFlower", "yellowFlower", "endStone", "bush", "cobblestone", "mossyCobblestone", "cake"};
	public static String[] names3 = {"cactus", "brick", "bookshelf", "glowstone", "redSand", "sand", "sponge", "soulSand", "tnt", "stone", "waterlilly"};
	public static String[] brickNames = {"black", "blue", "brown", "cyan", "gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"};
	public static String[] finalBrickNames = {"blackColouredBrick", "blueColouredBrick", "brownColouredBrick", "cyanColouredBrick", "grayColouredBrick", "limeColouredBrick", "magentaColouredBrick", "orangeColouredBrick", "pinkColouredBrick", "purpleColouredBrick", "redColouredBrick", "whiteColouredBrick", "yellowColouredBrick"};
	public static String[] finalMiniBrickNames = {"blackMiniColouredBrick", "blueMiniColouredBrick", "brownMiniColouredBrick", "cyanMiniColouredBrick", "grayMiniColouredBrick", "limeMiniColouredBrick", "magentaMiniColouredBrick", "orangeMiniColouredBrick", "pinkMiniColouredBrick", "purpleMiniColouredBrick", "redMiniColouredBrick", "whiteMiniColouredBrick", "yellowMiniColouredBrick"};

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
		
		for(int i = 0; i < brickNames.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockColouredBricks");
			registerItem(it, i, finalBrickNames[i]);
		}
		registerModelBakery(EssenceBlocks.colouredBricks, finalBrickNames);
		
		for(int i = 0; i < finalMiniBrickNames.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockMiniColouredBricks");
			registerItem(it, i, finalMiniBrickNames[i]);
		}
		registerModelBakery(EssenceBlocks.miniColouredBricks, finalMiniBrickNames);
	}
	
	public static void registerModelBakery(Item i, String[] names) {
		ModelBakery.addVariantName(i, "eotg:" + names);
	}
	
	public static void registerModelBakery(Block b, String[] names) {
		ModelBakery.addVariantName(SlayerAPI.toItem(b), "eotg:" + names);
	}

	public static void registerItem(Item item, int metadata, String itemName) {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		mesher.register(item, metadata, new ModelResourceLocation("eotg:" + itemName, "inventory"));
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
				Minecraft.getMinecraft().effectRenderer.addEffect(fx);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}