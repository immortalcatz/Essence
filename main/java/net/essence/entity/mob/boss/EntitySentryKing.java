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

public class EntitySentryKing extends EntityEssenceBoss implements IRangedAttackMob {
	
	@SuppressWarnings("this")
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