package net.journey.entity.mob.overworld;

import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.entity.projectile.EntityGreenpace;
import net.journey.enums.EnumSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityFloro extends EntityModMob implements IRangedAttackMob {

	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), 15, 10);

	public EntityFloro(World par1World) {
		super(par1World);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		if(par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(this.aiArrowAttack); {
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
	public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
        EntityGreenpace b = new EntityGreenpace(this.worldObj, this, 10F);
        b.setThrowableHeading(e.posX-this.posX, e.posY-this.posY, e.posZ-this.posZ, 1.6f, 12);
        EnumSounds.playSound(EnumSounds.SPARKLE, worldObj, this);
        this.worldObj.spawnEntityInWorld(b);
	}
	
	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.floroDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.floroHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.HONGO;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.HONGO_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.HONGO;
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(6) == 0) dropItem(JourneyItems.floroPedal, 4);
		super.dropFewItems(b, j);
		if(rand.nextInt(3) == 0) dropItem(JourneyItems.floroPedal, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(1) == 0) dropItem(JourneyItems.floroPedal, 1);
		super.dropFewItems(b, j);
	
	}

}