package net.essence.entity.mob.frozen;

import net.essence.EssenceBlocks;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityCrystalCluster extends EntityModMob {

	@SuppressWarnings("do this")
	public EntityCrystalCluster(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(0.5F, 0.7F);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity e) {
		boolean attacked = super.attackEntityAsMob(e);
		if(attacked) {
			if(e instanceof EntityLivingBase) 
				((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2, true, false));
			e.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F)) * 2, 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F)) * 2);
		}
		return attacked;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.crystalClusterDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.crystalClusterHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.SMALL_HONGO;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.SMALL_HONGO_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.SMALL_HONGO_HURT;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.worldObj.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == EssenceBlocks.brittleIce;
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}