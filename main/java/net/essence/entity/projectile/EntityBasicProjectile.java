package net.essence.entity.projectile;

import java.util.Random;

import net.essence.client.particles.EntityHellstoneFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

public class EntityBasicProjectile extends EntityThrowable {

	private int ticks, damage;

	public EntityBasicProjectile(World var1) {
		super(var1);
	}

	public EntityBasicProjectile(World var1, EntityLivingBase var3, int dam) {
		super(var1, var3);
		ticks = 500;
		damage = dam;
	}

	public EntityBasicProjectile(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public void onUpdate() {
		Random rand = new Random();
		super.onUpdate();
		for(int i = 0; i < 6; ++i) {
			EntityHellstoneFX hellstone = new EntityHellstoneFX(this.worldObj, this.posX, this.posY - 1.0F, this.posZ, 0.0D, 0.0D, 0.0D);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(hellstone);
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(var1.entityHit != null) {
			var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), damage);
		}
		if(!this.worldObj.isRemote) this.setDead();
	}

	@Override
	protected float getGravityVelocity() {
		return 0.001F;
	}
}