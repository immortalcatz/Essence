package net.essence.entity.mob.euca;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.entity.projectile.EntityFireBall;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityGolditeMage extends EntityModMob implements IRangedAttackMob {

	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), 15, 60);

	public EntityGolditeMage(World par1World) {
		super(par1World);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		if(par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItem();
		if(itemstack != null && itemstack.getItem() == EssenceItems.fireWand) {
			this.tasks.addTask(4, this.aiArrowAttack);
		}
	}
	
	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack) {
		super.setCurrentItemOrArmor(par1, par2ItemStack);
		if(!this.worldObj.isRemote && par1 == 0) {
			this.setCombatTask();
		}
	}

	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(EssenceItems.fireWand);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
        EntityFireBall b = new EntityFireBall(this.worldObj, this, 10F);
        EnumSounds.playSound(EnumSounds.SPARKLE, worldObj, this);
        this.worldObj.spawnEntityInWorld(b);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return 0;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.mageHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.INSECTO;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.INSECTO_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.INSECTO_HURT;
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(32) == 0) dropItem(EssenceItems.goldClump, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(37) == 0) dropItem(EssenceItems.goldClump, 4);
		super.dropFewItems(b, j);
		if(rand.nextInt(60) == 0) dropItem(EssenceItems.silverClump, 1);
		super.dropFewItems(b, j);
	}
}