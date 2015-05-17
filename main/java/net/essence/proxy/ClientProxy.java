package net.essence.proxy;

import net.essence.Essence;
import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.BarTickHandler;
import net.essence.client.BossTickHandler;
import net.essence.client.EntityRendering;
import net.essence.client.GuiHandler;
import net.essence.client.KnowledgeRenderHandler;
import net.essence.client.MusicEvent;
import net.essence.client.MusicHandler;
import net.essence.client.PlayerStats;
import net.essence.client.server.DarkEnergyBar;
import net.essence.client.server.EssenceBar;
import net.essence.client.server.PowerBar;
import net.essence.enums.EnumParticlesClasses;
import net.essence.event.ClientTickEvent;
import net.essence.event.UpdateCheckerEvent;
import net.essence.util.Helper;
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
		SlayerAPI.registerModelBakery(EssenceBlocks.miniColouredBricks, miniBricks);
		SlayerAPI.registerModelBakery(EssenceBlocks.colouredBricks, brick);
		SlayerAPI.registerModelBakery(EssenceBlocks.brisonBlocks, new String[] {SlayerAPI.PREFIX + "darkBrisonBrick", SlayerAPI.PREFIX + "redBrisonBrick", SlayerAPI.PREFIX + "smallBrisonBrick", SlayerAPI.PREFIX + "brisonStone"});
		SlayerAPI.addBow(EssenceItems.flameBow, "flameBow");
		SlayerAPI.addBow(EssenceItems.poisonBow, "poisonBow");
		SlayerAPI.addBow(EssenceItems.darknessBow, "darknessBow");
		SlayerAPI.addBow(EssenceItems.frozenBow, "frozenBow");
		SlayerAPI.addBow(EssenceItems.staringBow, "staringBow");
		SlayerAPI.addBow(EssenceItems.deathPiercerBow, "deathPiercerBow");
		SlayerAPI.addBow(EssenceItems.fusionBow, "fusionBow");
		SlayerAPI.addBow(EssenceItems.springBow, "springBow");
		SlayerAPI.addBow(EssenceItems.starlightBow, "starlightBow");
		SlayerAPI.addBow(EssenceItems.wastefulBow, "wastefulBow");
		SlayerAPI.addBow(EssenceItems.flamingBow, "flamingBow");
		SlayerAPI.addBow(EssenceItems.darkEnforcer, "darkEnforcer");
		SlayerAPI.addBow(EssenceItems.depthsBow, "depthsBow");
		SlayerAPI.addBow(EssenceItems.frostbittenBow, "frostbittenBow");
		SlayerAPI.addBow(EssenceItems.frostyBow, "frostyBow");
	}

	@Override
	public void registerSounds() {
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new MusicHandler());
		FMLCommonHandler.instance().bus().register(new MusicEvent());
	}

	@Override
	public void clientInit(FMLInitializationEvent event) {
		EntityRendering.init();
		SlayerAPI.registerEvent(new BossTickHandler());
		SlayerAPI.registerEvent(new BarTickHandler());
		SlayerAPI.registerEvent(new KnowledgeRenderHandler());
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
			SlayerAPI.registerItemRender(i, s);
		}

		for(String s : EssenceItems.itemNames) {
			Item i = GameRegistry.findItem(SlayerAPI.MOD_ID, s);
			SlayerAPI.registerItemRender(i, s);
		}

		SlayerAPI.addBowRender(EssenceItems.flameBow, "flameBow");
		SlayerAPI.addBowRender(EssenceItems.poisonBow, "poisonBow");
		SlayerAPI.addBowRender(EssenceItems.darknessBow, "darknessBow");
		SlayerAPI.addBowRender(EssenceItems.frozenBow, "frozenBow");
		SlayerAPI.addBowRender(EssenceItems.staringBow, "staringBow");

		for(int i = 0; i < brickNames.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockColouredBricks");
			SlayerAPI.registerItemRender(it, i, brickNames[i]);
		}

		for(int i = 0; i < miniBricksName.length; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "blockMiniColouredBricks");
			SlayerAPI.registerItemRender(it, i, miniBricksName[i]);
		}

		for(int i = 0; i < 4; i++) {
			Item it = GameRegistry.findItem(SlayerAPI.MOD_ID, "brisonBlocks");
			SlayerAPI.registerItemRender(it, i, brison[i]);
		}
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
	
	@Override
	public void updateDarkEnergy(int amount) {
		DarkEnergyBar.getProperties(Minecraft.getMinecraft().thePlayer).setBarValue(amount);
	}
	
	@Override
	public void updateEssence(int amount) {
		EssenceBar.getProperties(Minecraft.getMinecraft().thePlayer).setBarValue(amount);
	}
	
	@Override
	public void updatePower(int amount) {
		PowerBar.getProperties(Minecraft.getMinecraft().thePlayer).setBarValue(amount);
	}
}