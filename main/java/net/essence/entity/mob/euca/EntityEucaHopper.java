package net.essence.entity.mob.euca;

import net.essence.entity.MobStats;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModTameable;

public class EntityEucaHopper extends EntityModTameable {

	public EntityEucaHopper(World var1) {
		super(var1);
		this.setSize(0.5F, 0.5F);
		this.experienceValue = 40;
	}

	public EntityEucaHopper(World w, boolean tamed, String owner) {
		this(w);
		this.setTamed(tamed);
		this.func_152115_b(owner);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(MobStats.eucaHopperHealth);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(MobStats.eucaHopperSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(MobStats.eucaHopperFollowRange);
	}

	@Override
	protected boolean canDespawn() {
		return !this.isTamed();
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		double i = MobStats.eucaHopperDamage;
		if(this.isTamed()) {
			return false;
		}
		return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
	}
	
    protected void updateAITick() {
        this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, new Float(this.getHealth()));
        this.dataWatcher.addObject(19, new Byte((byte)0));
    }

	@Override
	public boolean interact(EntityPlayer var1) {
		ItemStack var2 = var1.inventory.getCurrentItem();

		if(this.isTamed()) {
			if(var2 != null && var2.getItem() instanceof ItemFood) {
				ItemFood var3 = (ItemFood)var2.getItem();

				if(var3.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectInt(18) < 20) {
					if(!var1.capabilities.isCreativeMode) {
						--var2.stackSize;
					}
					this.heal((float)var3.func_150905_g(var2));
					if(var2.stackSize <= 0) {
						var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
					}
					return true;
				}
			}
			if(var1.getDisplayName().equalsIgnoreCase(this.func_152113_b()) && !this.worldObj.isRemote) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity)null);
			}
		}
		else if(var2 != null && var2.getItem() == Items.apple) {
			if(!var1.capabilities.isCreativeMode) {
				--var2.stackSize;
			}

			if(var2.stackSize <= 0) {
				var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
			}

			if(!this.worldObj.isRemote) {
				if(this.rand.nextInt(3) == 0) {
					this.setTamed(true);
					this.setPathToEntity((PathEntity)null);
					this.setAttackTarget((EntityLiving)null);
					this.aiSit.setSitting(true);
					this.setHealth((int)MobStats.eucaHopperHealth);
					this.func_152115_b(var1.getDisplayName());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte)7);
				} else {
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte)6);
				}
			}
			return true;
		}
		return super.interact(var1);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
}