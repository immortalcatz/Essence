package net.essence.entity.projectile;

import java.util.Random;

import net.essence.client.render.particles.EntityConjuringFX;
import net.essence.client.render.particles.EntityDoomFX;
import net.essence.client.render.particles.EntityWizardsFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

public class EntityWizardsStar extends EntityBasicProjectile {

	public EntityWizardsStar(World var1) {
		super(var1);
	}
	
	public EntityWizardsStar(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3, dam);
	}
	
	@Override
	public void onUpdate() {
		Random rand = new Random();
		super.onUpdate();
		for(int i = 0; i < 6; ++i) {
			EntityFX effect = new EntityWizardsFX(this.worldObj, this.posX, this.posY - 1.0F, this.posZ, 0.0D, 0.0D, 0.0D);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(effect);
		}
	}
}