package net.essence.entity.mob.boiling;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityAshHoarder extends EntityModMob{

	public EntityAshHoarder(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.3F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.ashHoarderDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.ashHoarderHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.MAGMA_GIANT;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.MAGMA_GIANT_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.MAGMA_GIANT_HURT;
	}

	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).setFire(5 + rand.nextInt(7));
		return super.attackEntityFrom(e, a);
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.ash;
	}
}