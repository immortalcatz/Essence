package net.slayer.api.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityPeacefullUntillAttacked extends EntityModMob {

	public EntityPeacefullUntillAttacked(World w) {
		super(w);
		this.targetTasks.addTask(1, new EntityPeacefullUntillAttacked.AIHurtByAggressor());
		this.targetTasks.addTask(2, new EntityPeacefullUntillAttacked.AITargetAggressor());
	}

	private int angerLevel = 0;

	public void writeEntityToNBT(NBTTagCompound var1) {
		super.writeEntityToNBT(var1);
		var1.setShort("Anger", (short)this.angerLevel);
	}

	public void readEntityFromNBT(NBTTagCompound var1) {
		super.readEntityFromNBT(var1);
		this.angerLevel = var1.getShort("Anger");
	}
	
    public boolean func_175457_ck() {
        return this.angerLevel > 0;
    }

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if(par1DamageSource.getEntity() instanceof EntityPlayer){
			angerLevel = 400;
			addAttackingAI();
		}
		return super.attackEntityFrom(par1DamageSource, par2);
	}

	private void becomeAngryAt(Entity p_70835_1_){
		this.angerLevel = 400 + this.rand.nextInt(400);

		if (p_70835_1_ instanceof EntityLivingBase)
		{
			this.setRevengeTarget((EntityLivingBase)p_70835_1_);
		}
	}

	class AIHurtByAggressor extends EntityAIHurtByTarget
	{
		private static final String __OBFID = "CL_00002206";

		public AIHurtByAggressor()
		{
			super(EntityPeacefullUntillAttacked.this, true, new Class[0]);
		}

		protected void func_179446_a(EntityCreature p_179446_1_, EntityLivingBase p_179446_2_)
		{
			super.func_179446_a(p_179446_1_, p_179446_2_);

			if (p_179446_1_ instanceof EntityPeacefullUntillAttacked)
			{
				((EntityPeacefullUntillAttacked)p_179446_1_).becomeAngryAt(p_179446_2_);
			}
		}
	}

	class AITargetAggressor extends EntityAINearestAttackableTarget
	{
		private static final String __OBFID = "CL_00002207";

		public AITargetAggressor()
		{
			super(EntityPeacefullUntillAttacked.this, EntityPlayer.class, true);
		}

		public boolean shouldExecute()
		{
			return ((EntityPeacefullUntillAttacked)this.taskOwner).func_175457_ck() && super.shouldExecute();
		}
	}
}