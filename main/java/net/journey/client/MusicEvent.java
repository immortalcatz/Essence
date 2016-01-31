package net.journey.client;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.slayer.api.SlayerAPI;

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
			MusicTicker.MusicType musictype = this.mc.getAmbientMusicType();
			if(this.curMusic == null && this.ticks-- <= 0) {
				ResourceLocation resource = musictype.getMusicLocation();
				String name = "";
				switch(rand.nextInt(6)) {
				case 0:
					name = "underwaterWorld";
					break;
				case 1:
					name = "blueWater";
					break;
				case 2:
					name = "compBegins";
					break;
				case 3:
					name = "deepBlue";
					break;
				case 4:
					name = "raceShore";
					break;
				case 5:
					name = "raceStar";
					break;
				}
				ResourceLocation musicLocation = new ResourceLocation(SlayerAPI.PREFIX + "music.records." + name);
				this.curMusic = PositionedSoundRecord.create(musicLocation);
				this.mc.getSoundHandler().playSound(this.curMusic);
				this.ticks = MathHelper.getRandomIntegerInRange(this.rand, 2000, 10000);
			}
		}
	}
}