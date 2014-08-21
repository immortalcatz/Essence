package net.slayer.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public abstract interface ITickHandler {
	
	public abstract void renderTick(TickEvent.RenderTickEvent event);
	
	public abstract void playerTick(TickEvent.PlayerTickEvent event);
	
	public abstract void serverTick(TickEvent.ServerTickEvent event);
	
	public abstract void worldTick(TickEvent.WorldTickEvent event);
}