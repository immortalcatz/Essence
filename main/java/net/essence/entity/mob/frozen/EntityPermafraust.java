package net.essence.entity.mob.frozen;

import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityPermafraust extends EntityModMob {

	@SuppressWarnings("do this")
	public EntityPermafraust(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(0.5F, 2F);
	}
	
	@Override
	public double setAttackDamage(MobStats s) {
		return s.smallHongoDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.smallHongoHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.SMALL_HONGO.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.SMALL_HONGO_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.SMALL_HONGO_HURT.getPrefixedName();
	}
	
	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}

	@Override
	public Item getItemDropped() {
		return null;
	}

}