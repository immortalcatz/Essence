package net.essence.proxy;

import net.essence.Essence;
import net.essence.client.*;
import net.essence.event.*;
import net.essence.util.*;
import net.slayer.api.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerClient() {
		if(SlayerAPI.DEVMODE) LangRegistry.registerNames();
		NetworkRegistry.INSTANCE.registerGuiHandler(Essence.instance, new GuiHandler());
		EntityRendering.init();
		Keybinding.init();
		SlayerAPI.addForgeEventBus(new KeyInputHandler());
	}
	
	@Override
	public void clientInit(FMLInitializationEvent event) {
		SlayerAPI.addForgeEventBus(new BossTickHandler());
		SlayerAPI.addForgeEventBus(new LevelBarTickHandler());
		SlayerAPI.addForgeEventBus(new BarTickHandler());
		SlayerAPI.addForgeEventBus(new PlayerStats());
		SlayerAPI.addEventBus(new PlayerStats());
	}
}