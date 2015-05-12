package net.essence.entity.mob.corba;

import java.util.Random;

import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModFlying;
import net.slayer.api.entity.EntityModMob;

public class EntityOverseer extends EntityModFlying {

	@SuppressWarnings("do this")
	public EntityOverseer(World par1World) {
		super(par1World);
		this.moveHelper = new EntityOverseer.OverseerMoveHelper();
		this.tasks.addTask(5, new EntityOverseer.AIRandomFly());
		setSize(1F, 1F);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if(!this.worldObj.isRemote && this.worldObj.getDifficulty() == EnumDifficulty.EASY) this.setDead();
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.elderOverseerHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.HONGO.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.SAND_CRAWLER.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.SAND_CRAWLER.getPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return null;
	}

	private class AIRandomFly extends EntityAIBase {
		private EntityOverseer e = EntityOverseer.this;

		public AIRandomFly() {
			this.setMutexBits(1);
		}

		@Override
		public boolean shouldExecute() {
			EntityMoveHelper entitymovehelper = this.e.getMoveHelper();
			if(!entitymovehelper.isUpdating()) {
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
			double d0 = this.e.posX + (double)((random.nextFloat() * 1.0F - 1.0F) * 1.0F);
			double d1 = this.e.posY + (double)((random.nextFloat() * 1.0F - 1.0F) * 1.0F);
			double d2 = this.e.posZ + (double)((random.nextFloat() * 1.0F - 1.0F) * 1.0F);
			this.e.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
		}
	}

	private class OverseerMoveHelper extends EntityMoveHelper {
		private EntityOverseer e = EntityOverseer.this;
		private int height;

		public OverseerMoveHelper() {
			super(EntityOverseer.this);
		}

		@Override
		public void onUpdateMoveHelper() {
			if(this.update) {
				double d0 = this.posX - this.e.posX;
				double d1 = this.posY - this.e.posY;
				double d2 = this.posZ - this.e.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				if(this.height-- <= 0) {
					this.height += this.e.getRNG().nextInt(5) + 2;
					d3 = (double)MathHelper.sqrt_double(d3);
					if(this.canMove(this.posX, this.posY, this.posZ, d3)) {
						this.e.motionX += d0 / d3 * 0.1D;
						this.e.motionY += d1 / d3 * 0.1D;
						this.e.motionZ += d2 / d3 * 0.1D;
					} else {
						this.update = false;
					}
				}
			}
		}

		private boolean canMove(double x, double y, double z, double h)  {
			double d4 = (x - this.e.posX) / h;
			double d5 = (y - this.e.posY) / h;
			double d6 = (z - this.e.posZ) / h;
			AxisAlignedBB axisalignedbb = this.e.getEntityBoundingBox();
			for(int i = 1; (double)i < h; ++i) {
				axisalignedbb = axisalignedbb.offset(d4, d5, d6);
				if(!this.e.worldObj.getCollidingBoundingBoxes(this.e, axisalignedbb).isEmpty()) {
					return false;
				}
			}
			return true;
		}
	}
}