package net.essence.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityOceanPlasma extends EntityThrowable {

	public EntityOceanPlasma(World var1) {
		super(var1);
	}
	
	public EntityOceanPlasma(World var1, EntityLivingBase base) {
		super(var1, base);
	}
	
	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(var1.entityHit != null && var1.entityHit instanceof EntityLivingBase) {
			var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 10);
			((EntityLivingBase)var1.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2));
		}
		if(!worldObj.isRemote) this.setDead();
	}

	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}
}