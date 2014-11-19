package net.essence.proxy;

import net.essence.Essence;
import net.essence.client.BarTickHandler;
import net.essence.client.BossTickHandler;
import net.essence.client.EntityRendering;
import net.essence.client.GuiHandler;
import net.essence.client.MusicEvent;
import net.essence.client.MusicHandler;
import net.essence.client.PlayerStats;
import net.essence.event.UpdateCheckerEvent;
import net.essence.util.LangRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerClient() {
		if(SlayerAPI.DEVMODE) LangRegistry.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(Essence.instance, new GuiHandler());
		EntityRendering.init();
		if(!SlayerAPI.DEVMODE) SlayerAPI.addEventBus(new UpdateCheckerEvent());
		//Keybinding.init();
		//SlayerAPI.addForgeEventBus(new KeyInputHandler());
	}
	
	@Override
	public void registerSounds() {
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new MusicHandler());
		FMLCommonHandler.instance().bus().register(new MusicEvent());
	}
	
	@Override
	public void clientInit(FMLInitializationEvent event) {
		SlayerAPI.addForgeEventBus(new BossTickHandler());
		SlayerAPI.addForgeEventBus(new BarTickHandler());
		SlayerAPI.addForgeEventBus(new PlayerStats());
		SlayerAPI.addEventBus(new PlayerStats());
	}
}