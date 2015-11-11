package net.essence.entity.mob.boss;

import java.util.Random;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.entity.mob.cloudia.EntitySkyEel;
import net.essence.entity.mob.euca.EntityShimmerer;
import net.essence.entity.projectile.EntityShimmererProjectile;
import net.essence.enums.EnumSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntitySkyStalker extends EntityEssenceBoss {
	public EntitySkyStalker(World par1World) {
		super(par1World);
		this.moveHelper = new EntitySkyStalker.MoveHelper();
		this.tasks.addTask(5, new EntitySkyStalker.AIRandomFly());
		this.tasks.addTask(7, new EntitySkyStalker.AILookAround());
		this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
		setSize(0.7F, 1.2F);
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.silverbotHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.INSECTO;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.SHIMMERER_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.SHIMMERER_DEATH;
	}

	@Override
	protected float getSoundVolume() {
		return 10.0F;
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.rand.nextInt(15) == 0 && super.getCanSpawnHere()
				&& this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 3;
	}

	@Override
	protected void dropFewItems(boolean b, int j) {
		switch (rand.nextInt(3)) {
		case 0:
			dropItem(EssenceItems.skyPiercer, 128);
			break;
		case 1:
			dropItem(EssenceItems.fluffyBlade, 1);
			break;
		case 2:
			dropItem(EssenceItems.fluffyBow, 1);
			break;
		}
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
	}

	@Override
	public Item getItemDropped() {
		return null;
	}

	public void setFire(boolean b) {
		this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b ? 1 : 0)));
	}

	@Override
	public double setAttackDamage(MobStats s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
	}

	@Override
	protected void func_180433_a(double p_180433_1_, boolean p_180433_3_, Block p_180433_4_, BlockPos p_180433_5_) {
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		if (this.isInWater()) {
			this.moveFlying(p_70612_1_, p_70612_2_, 0.02F);
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.800000011920929D;
			this.motionY *= 0.800000011920929D;
			this.motionZ *= 0.800000011920929D;
		} else if (this.isInLava()) {
			this.moveFlying(p_70612_1_, p_70612_2_, 0.02F);
			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.5D;
			this.motionY *= 0.5D;
			this.motionZ *= 0.5D;
		} else {
			float f2 = 0.91F;

			if (this.onGround) {
				f2 = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX),
						MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1,
						MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91F;
			}

			float f3 = 0.16277136F / (f2 * f2 * f2);
			this.moveFlying(p_70612_1_, p_70612_2_, this.onGround ? 0.1F * f3 : 0.02F);
			f2 = 0.91F;

			if (this.onGround) {
				f2 = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX),
						MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1,
						MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91F;
			}

			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= (double) f2;
			this.motionY *= (double) f2;
			this.motionZ *= (double) f2;
		}

	}

	private class AIRandomFly extends EntityAIBase {
		private EntitySkyStalker e = EntitySkyStalker.this;

		public AIRandomFly() {
			this.setMutexBits(1);
		}

		@Override
		public boolean shouldExecute() {
			EntityMoveHelper entitymovehelper = this.e.getMoveHelper();
			if (!entitymovehelper.isUpdating()) {
				return true;
			} else {
				double d0 = entitymovehelper.func_179917_d() - this.e.posX;
				double d1 = entitymovehelper.func_179919_e() - this.e.posY;
				double d2 = entitymovehelper.func_179918_f() - this.e.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D;
			}
		}

		@Override
		public boolean continueExecuting() {
			return false;
		}

		@Override
		public void startExecuting() {
			Random random = this.e.getRNG();
			double d0 = this.e.posX + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d1 = this.e.posY + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d2 = this.e.posZ + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.e.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
		}
	}

	private class MoveHelper extends EntityMoveHelper {
		private EntitySkyStalker e = EntitySkyStalker.this;
		private int height;

		public MoveHelper() {
			super(EntitySkyStalker.this);
		}

		@Override
		public void onUpdateMoveHelper() {
			if (this.update) {
				double d0 = this.posX - this.e.posX;
				double d1 = this.posY - this.e.posY;
				double d2 = this.posZ - this.e.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				if (this.height-- <= 0) {
					this.height += this.e.getRNG().nextInt(5) + 2;
					d3 = (double) MathHelper.sqrt_double(d3);
					if (this.canMove(this.posX, this.posY, this.posZ, d3)) {
						this.e.motionX += d0 / d3 * 0.1D;
						this.e.motionY += d1 / d3 * 0.1D;
						this.e.motionZ += d2 / d3 * 0.1D;
					} else {
						this.update = false;
					}
				}
			}
		}

		private boolean canMove(double x, double y, double z, double h) {
			double d4 = (x - this.e.posX) / h;
			double d5 = (y - this.e.posY) / h;
			double d6 = (z - this.e.posZ) / h;
			AxisAlignedBB axisalignedbb = this.e.getEntityBoundingBox();
			for (int i = 1; (double) i < h; ++i) {
				axisalignedbb = axisalignedbb.offset(d4, d5, d6);
				if (!this.e.worldObj.getCollidingBoundingBoxes(this.e, axisalignedbb).isEmpty()) {
					return false;
				}
			}
			return true;
		}
	}

	public class AILookAround extends EntityAIBase {
		private EntitySkyStalker e = EntitySkyStalker.this;

		public AILookAround() {
			this.setMutexBits(2);
		}

		@Override
		public boolean shouldExecute() {
			return true;
		}

		@Override
		public void updateTask() {
			if (this.e.getAttackTarget() == null) {
				this.e.renderYawOffset = this.e.rotationYaw = -((float) Math.atan2(this.e.motionX, this.e.motionZ))
						* 180.0F / (float) Math.PI;
			} else {
				EntityLivingBase entitylivingbase = this.e.getAttackTarget();
				double d0 = 64.0D;

				if (entitylivingbase.getDistanceSqToEntity(this.e) < d0 * d0) {
					double d1 = entitylivingbase.posX - this.e.posX;
					double d2 = entitylivingbase.posZ - this.e.posZ;
					this.e.renderYawOffset = this.e.rotationYaw = -((float) Math.atan2(d1, d2)) * 180.0F
							/ (float) Math.PI;
				}
			}
		}
	}
}