package net.essence.client;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;

public enum EnumSounds {

	ROBOT("robot"),
	ROBOT_HURT("robotHurt"),
	PSYOLLOM("psyollom"),
	PSYOLLOM_HURT("psyollomHurt"),
	INSECTO("insecto"),
	INSECTO_HURT("insectoHurt"),
	SPIKED_BEAST("spikedBeast"),
	SPIKED_BEAST_HURT("spikedBeastHurt"),
	MAGMA_GIANT("magmaGiant"),
	MAGMA_GIANT_HURT("magmaGiantHurt"),
	SPYCLOPS("spyclops"),
	SPYCLOPS_HURT("spyclopsHurt"),
	BLAZE("mob.blaze.breathe"),
	BLAZE_HURT("mob.blaze.hit"),
	BLAZE_DEATH("mob.blaze.death"),
	STAFF("staff");
	
	private String sound;
	
	private EnumSounds(String sound) {
		this.sound = sound;
	}
	
	public String getPrefixedName() {
		return "eotg:" + sound;
	}
	
	public String getNonPrefixedName() {
		return sound;
	}
	
	public static void playSound(String sound, World w, EntityLivingBase e){
		w.playSoundAtEntity(e, sound, 1.0F, 1.0F);
	}
	
	public static void playSound(String sound, World w, EntityLivingBase e, float volume, float pitch){
		w.playSoundAtEntity(e, sound, volume, pitch);
	}
}