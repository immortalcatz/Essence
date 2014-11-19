package net.essence.client;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;

public class MusicEvent {

	private final Random rand = new Random();
	private final Minecraft mc;
	private ISound curMusic;
	private int tickLength = MathHelper.getRandomIntegerInRange(this.rand, 2000, 24000);

	public MusicEvent() {
		mc = Minecraft.getMinecraft();
	}

	@SubscribeEvent
	public void update(ClientTickEvent event) {
		if (event.phase == Phase.END) {
			MusicTicker.MusicType musictype = this.mc.func_147109_W();

			if (this.curMusic != null) {
				ResourceLocation resource = musictype.getMusicTickerLocation();
				ResourceLocation musicLocation = new ResourceLocation("eotg", resource.getResourcePath());
				if (!musicLocation.equals(this.curMusic.getPositionedSoundLocation())) {
					this.mc.getSoundHandler().stopSound(this.curMusic);
					this.tickLength = MathHelper.getRandomIntegerInRange(this.rand, 0, musictype.func_148634_b() / 2);
				}

				if (!this.mc.getSoundHandler().isSoundPlaying(this.curMusic)) {
					this.curMusic = null;
					this.tickLength = MathHelper.getRandomIntegerInRange(this.rand, 12000, 24000);
				}
			}

			if (this.curMusic == null && this.tickLength-- <= 0) {
				ResourceLocation resource = musictype.getMusicTickerLocation();
				ResourceLocation musicLocation = new ResourceLocation("eotg", resource.getResourcePath());
				this.curMusic = PositionedSoundRecord.func_147673_a(musicLocation);
				this.mc.getSoundHandler().playSound(this.curMusic);
				this.tickLength = Integer.MAX_VALUE;
			}
		}
	}

}

