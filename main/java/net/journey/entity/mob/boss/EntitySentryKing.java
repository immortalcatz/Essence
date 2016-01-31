package net.journey.entity.mob.boss;

import net.journey.JourneyBlocks;
import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.entity.projectile.EntityIceBall;
import net.journey.enums.EnumSounds;
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

public class EntitySentryKing extends EntityEssenceBoss implements IRangedAttackMob {
	
	public EntitySentryKing(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(2.0F, 3.8F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.sentryKingDamage;
	}
	
	@Override
	public double setKnockbackResistance() {
		return 1.0D;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.sentryKingHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.WITHER;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.WITHER_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.WITHER_DEATH;
	}

	@Override
	public Item getItemDropped() {
		return JourneyItems.depthsPortalGem;
	}

	@Override
	protected void dropFewItems(boolean b, int j) {
		switch(rand.nextInt(2)) {
		case 0: dropItem(JourneyItems.overseerBow, 1); break;
		case 1: dropItem(JourneyItems.sentrySword, 1); break;
		}
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
		EntityIceBall b = new EntityIceBall(this.worldObj, this, 10F);
        EnumSounds.playSound(EnumSounds.SPARKLE, worldObj, this);
        this.worldObj.spawnEntityInWorld(b);
	}
}