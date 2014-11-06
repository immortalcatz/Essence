package net.essence.entity.mob.boiling;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.essence.entity.projectile.EntityMagmaFireball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityMagmaBlaze extends EntityModMob {

	private float heightOffset = 0.5F;
	private int heightOffsetUpdateTime;
	private int attackTimer;

	public EntityMagmaBlaze(World w) {
		super(w);
		this.isImmuneToFire = true;
		this.experienceValue = 10;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float p_70070_1_) {
		return 15728880;
	}

	@Override
	public float getBrightness(float p_70013_1_) {
		return 1.0F;
	}

	@Override
	public void onLivingUpdate() {
		if (!this.worldObj.isRemote) {
			if (this.isWet()) {
				this.attackEntityFrom(DamageSource.drown, 1.0F);
			}

			--this.heightOffsetUpdateTime;

			if (this.heightOffsetUpdateTime <= 0) {
				this.heightOffsetUpdateTime = 100;
				this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
			}

			if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + (double)this.getEntityToAttack().getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset)  {
				this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
			}
		}

		if (this.rand.nextInt(24) == 0) {
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.fire", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
		}

		if (!this.onGround && this.motionY < 0.0D)  {
			this.motionY *= 0.6D;
		}

		for (int i = 0; i < 2; ++i) {
			this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		}

		super.onLivingUpdate();
	}

	@Override
	protected void attackEntity(Entity e, float f) {
		if (this.attackTime <= 0 && f < 2.0F && e.boundingBox.maxY > this.boundingBox.minY && e.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			this.attackEntityAsMob(e);
		}
		else if (f < 30.0F) {
			double d0 = e.posX - this.posX;
			double d1 = e.boundingBox.minY + (double)(e.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
			double d2 = e.posZ - this.posZ;

			if (this.attackTime == 0) {
				++this.attackTimer;

				if (this.attackTimer == 1) {
					this.attackTime = 60;
					this.setFlying(true);
				}
				else if (this.attackTimer <= 4) {
					this.attackTime = 6;
				} else {
					this.attackTime = 100;
					this.attackTimer = 0;
					this.setFlying(false);
				}

				if (this.attackTimer > 1) {
					float f1 = MathHelper.sqrt_float(f) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

					for (int i = 0; i < 1; ++i) {
						EntityMagmaFireball entitysmallfireball = new EntityMagmaFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
						entitysmallfireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
						this.worldObj.spawnEntityInWorld(entitysmallfireball);
					}
				}
			}

			this.rotationYaw = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}

	@Override
	protected void fall(float p_70069_1_) {}

	@Override
	public boolean isBurning() {
		return this.isFlying();
	}

	@Override
	protected void dropFewItems(boolean b, int i) {
		if(b) {
			int j = this.rand.nextInt(2 + i);
			for (int k = 0; k < j; ++k) {
				this.dropItem(Items.blaze_rod, 1);
			}
		}
	}

	public boolean isFlying() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void setFlying(boolean b) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		if(b) b0 = (byte)(b0 | 1);
		else b0 &= -2;
		this.dataWatcher.updateObject(16, Byte.valueOf(b0));
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.magmaBlazeDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.magmaBlazeHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.BLAZE.getNonPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.BLAZE_HURT.getNonPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.BLAZE_DEATH.getNonPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return Items.blaze_rod;
	}
}