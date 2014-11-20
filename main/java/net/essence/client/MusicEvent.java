package net.essence.client;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;

public class MusicEvent {

	private final Random rand = new Random();
	private final Minecraft mc;
	private ISound curMusic;
	private int ticks = MathHelper.getRandomIntegerInRange(this.rand, 2000, 10000);

	public MusicEvent() {
		mc = Minecraft.getMinecraft();
	}

	@SubscribeEvent
	public void update(ClientTickEvent event) {
		if(event.phase == Phase.END) {
			MusicTicker.MusicType musictype = this.mc.func_147109_W();
			if(this.curMusic == null && this.ticks-- <= 0) {
				ResourceLocation resource = musictype.getMusicTickerLocation();
				ResourceLocation musicLocation = new ResourceLocation(SlayerAPI.PREFIX + "music.underwaterWorld");
				this.curMusic = PositionedSoundRecord.func_147673_a(musicLocation);
				this.mc.getSoundHandler().playSound(this.curMusic);
				this.ticks = MathHelper.getRandomIntegerInRange(this.rand, 2000, 10000);
			}
		}
	}
}