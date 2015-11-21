package net.essence.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDemonicBomb extends EntityThrowable{

	public float damage;

	public EntityDemonicBomb(World var1) {
		super(var1);
	}
	public EntityDemonicBomb(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3);
		damage = dam;
	}
	public float getDamage() {
		return damage;
	}
	
	public void setDamage(float damage) {
		this.damage = damage;
	}
	
    protected float getGravityVelocity()
    {
        return 0.1F;
    }

    protected float getVelocity()
    {
        return 2.0F;
    }

	@Override
	protected void onImpact(MovingObjectPosition j) {
			if(j.entityHit !=null) j.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this,getThrower()), damage);
            this.worldObj.playAuxSFX(2002, new BlockPos(this), 5);
            int i = 3 + this.worldObj.rand.nextInt(5) + this.worldObj.rand.nextInt(5);
            this.setDead();
        }   
	}