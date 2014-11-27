package net.essence.client.render;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.particle.EntitySnowShovelFX;

public enum EnumParticlesClasses {

	LAVA(EntityLavaFX.class),
	SMOKE(EntitySmokeFX.class),
	FLAME(EntityFlameFX.class),
	SNOWBALL_POOF(EntitySnowShovelFX.class);
	
	private Class particle;
	
	private EnumParticlesClasses(Class name) {
		particle = name;
	}
	
	public Class getParticle() {
		return particle;
	}
}