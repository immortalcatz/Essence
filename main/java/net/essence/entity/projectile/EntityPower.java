package net.essence.entity.projectile;

import java.util.List;
import java.util.Random;

import net.essence.client.render.particles.EntityHellstoneFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityPower extends EntityThrowable {

	public float damage;
	public float lifeTicks;

	public EntityPower(World var1) {
		super(var1);
		lifeTicks = 20;
	}

	public EntityPower(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3);
		damage = dam;
		lifeTicks = 20;
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate() {
		Random rand = new Random();
		super.onUpdate();
		lifeTicks--;
		if(lifeTicks >= 0) this.setDead();
		List<EntityLivingBase> list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.getBoundingBox().expand(10.0D, 10.0D, 10.0D));
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				Entity entity1 = (Entity)list.get(i);
				if(entity1 instanceof EntityLivingBase && entity1 != getThrower()) {
					EntityLivingBase hit = (EntityLivingBase)entity1;
					for(int i1 = 0; i1 < 6; i1++) {
						EntityFX effect = new EntityHellstoneFX(this.worldObj, hit.posX + rand.nextFloat(), hit.posY + 1D + rand.nextFloat(), hit.posZ + rand.nextFloat(), 0.0D, 0.0D, 0.0D);
						FMLClientHandler.instance().getClient().effectRenderer.addEffect(effect);
					}
					hit.attackEntityFrom(new DamageSource("power"), 10F);
				}
			}
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(!worldObj.isRemote) this.setDead();
	}

	@Override
	protected float getGravityVelocity() {
		return 0.001F;
	}
}