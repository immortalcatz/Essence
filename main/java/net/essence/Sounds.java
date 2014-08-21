package net.essence;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class Sounds {

	public static final String robot = "eotg:robot";
	public static final String robotHurt = "eotg:robotHurt";
	public static final String psyollom = "eotg:psyollom";
	public static final String psyollomHurt = "eotg:psyollomHurt";
	public static final String insecto = "eotg:insecto";
	public static final String insectoHurt = "eotg:insectoHurt";
	public static final String spikedBeast = "eotg:spikedBeast";
	public static final String spikedBeastHurt = "eotg:spikedBeastHurt";
	public static final String magmaGiant = "eotg:magmaGiant";
	public static final String magmaGiantHurt = "eotg:magmaGiantHurt";
	public static final String spyclops = "eotg:spyclops";
	public static final String spyclopsHurt = "eotg:spyclopsHurt";
	public static final String staff = "eotg:staff";
	
	public static void playSound(String sound, World w, EntityLivingBase e){
		w.playSoundAtEntity(e, sound, 1.0F, 1.0F);
	}
	
	public static void playSound(String sound, World w, EntityLivingBase e, float volume, float pitch){
		w.playSoundAtEntity(e, sound, volume, pitch);
	}
}