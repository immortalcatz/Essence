package net.essence.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBoilingPiercer extends EntityThrowable {

	public float damage;
	public float impacts, maxImpact;

	public EntityBoilingPiercer(World var1) {
		super(var1);
	}

	public EntityBoilingPiercer(World var1, EntityLivingBase var3, float dam, float mi, float i) {
		super(var1, var3);
		damage = dam;
		maxImpact = mi;
		impacts = i;
	}
	
	public float getDamage() {
		return damage;
	}
	
	public void setDamage(float damage) {
		this.damage = damage;
		
	}
	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(var1.entityHit != null) var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), damage);
		if(var1.sideHit == EnumFacing.UP||var1.sideHit == EnumFacing.DOWN) {
			this.motionY *= -1.0D;
		} else if(var1.sideHit == EnumFacing.SOUTH||var1.sideHit == EnumFacing.NORTH) {
			this.motionZ *= -1.0D;
		} else if(var1.sideHit == EnumFacing.EAST||var1.sideHit == EnumFacing.WEST) {
			this.motionX *= -1.0D;
		}
		this.maxImpact++;
		if(this.impacts == maxImpact) this.setDead();
	}
}