package net.slayer.api.entity;

import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

public abstract class EntityModMob extends EntityMob {

	public EntityModMob(World par1World) {
		super(par1World);
		addBasicAI();
	}

	public double getHP(){return getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();}
	public double getMoveSpeed(){return getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();}
	public double getAttackDamage(){return getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();}
	public double getFollowRange(){return getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();}
	public double getKnockbackResistance(){return getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue();}

	protected void addAttackingAI() {
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0F, false));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	protected void addBasicAI(){
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 1.0F));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(setFollowRange());
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(setMovementSpeed());
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(setMaxHealth(new MobStats()));
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(setAttackDamage(new MobStats()));
	}

	public double setFollowRange(){return MobStats.follow;}
	public double setMovementSpeed(){return MobStats.normalSpeed;}

	public abstract double setAttackDamage(MobStats s);
	public abstract double setMaxHealth(MobStats s);
	public abstract String setLivingSound(Sounds s);
	public abstract String setHurtSound(Sounds s);
	public abstract String setDeathSound(Sounds s);
	public abstract Item getItemDropped();

	@Override
	protected Item getDropItem() {
		return getItemDropped();
	}

	@Override
	protected String getLivingSound() {
		super.getLivingSound();
		return setLivingSound(new Sounds());
	}

	@Override
	protected String getHurtSound() {
		super.getHurtSound();
		return setHurtSound(new Sounds());
	}

	@Override
	protected String getDeathSound() {
		super.getDeathSound();
		return setDeathSound(new Sounds());
	}

	@Override
	protected boolean isAIEnabled() {
		return false;
	}
}