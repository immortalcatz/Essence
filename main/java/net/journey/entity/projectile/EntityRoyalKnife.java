package net.journey.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityRoyalKnife extends EntityThrowable{

	public float damage;

	public EntityRoyalKnife(World var1) {
		super(var1);
	}
	public EntityRoyalKnife(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3);
		damage = dam;
	}
	public float getDamage() {
		return damage;
	}
	
	public void setDamage(float damage) {
		this.damage = damage;
	}
	
	@Override
    protected float getGravityVelocity()
    {
        return 0.04F;
    }

	@Override
    protected float getVelocity()
    {
        return 0.4F;
    }

	@Override
    protected float getInaccuracy()
    {
        return -5.0F;
    }

	@Override
	protected void onImpact(MovingObjectPosition j) {
			float f = (this.rand.nextFloat() - 0.0F) * 0.0F;
       		float f1 = (this.rand.nextFloat() - 0.0F) * 0.0F;
        	float f2 = (this.rand.nextFloat() - 0.0F) * 0.0F;
			if(j.entityHit !=null) j.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this,getThrower()), damage);
            int i = 3 + this.worldObj.rand.nextInt(5) + this.worldObj.rand.nextInt(5);
            this.setDead();
        }   
	}