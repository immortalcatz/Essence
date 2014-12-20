package net.essence.entity.mob.boss;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.entity.projectile.EntityIceBall;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntityEudor extends EntityEssenceBoss implements IRangedAttackMob {

	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), 15, 60);
	
	private int firetick;
	private int firemax = 400, firemax2 = 300;
	private boolean isInvi;
	
	public EntityEudor(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(2.0F, 3.8F);
		if(par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItem();
		if(itemstack != null && itemstack.getItem() == EssenceItems.iceWand) {
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
		return new ItemStack(EssenceItems.iceWand);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.eudorDamage;
	}
	
	@Override
	public double setKnockbackResistance() {
		return 1.0D;
	}
	
	public boolean isInv() {
		return isInvi;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if(isInv()) {
			for(int i = 0; i < 5; i++) this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, posX + 0.5F + rand.nextFloat(), posY + 1.0D + rand.nextFloat(), posZ + 0.5F + rand.nextFloat(), 0, 0, 0);
			Entity entity = attackingPlayer;
			if(entity != null)
				((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 25, 2));
		}
	}

	@Override
	public void onLivingUpdate() {
		if(firemax == firetick && firetick != 0) {
			this.isInvi = true;
			this.firetick = 0;
		} else {
			firetick++;
		} 

		if(firemax2 == firetick && firetick != 0) {
			this.isInvi = false;
			this.firetick = 0;
		} else {
			firetick++;
		}
		super.onLivingUpdate();
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.eudorHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.WITHER.getNonPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.WITHER_HURT.getNonPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.WITHER_DEATH.getNonPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.depthsPortalGem;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(getItemDropped(), 6 + rand.nextInt(4));
		if(rand.nextInt(1) == 0) this.dropItem(Item.getItemFromBlock(EssenceBlocks.eudorStatue), 1);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
		EntityIceBall b = new EntityIceBall(this.worldObj, this, 10F);
        EnumSounds.playSound(EnumSounds.SPARKLE, worldObj, this);
        this.worldObj.spawnEntityInWorld(b);
	}
}