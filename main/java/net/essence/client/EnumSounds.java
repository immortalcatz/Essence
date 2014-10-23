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
	STAFF("staff");
	
	private String sound;
	
	private EnumSounds(String sound) {
		this.sound = sound;
	}
	
	public String getPrefixedName() {
		return SlayerAPI.MOD_ID + sound;
	}
	
	public static void playSound(String sound, World w, EntityLivingBase e){
		w.playSoundAtEntity(e, SlayerAPI.MOD_ID + sound, 1.0F, 1.0F);
	}
	
	public static void playSound(String sound, World w, EntityLivingBase e, float volume, float pitch){
		w.playSoundAtEntity(e, SlayerAPI.MOD_ID + sound, volume, pitch);
	}
}