package net.essence.entity.mob.corba;

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

public class EntityTreeGolem extends EntityModMob{

	public EntityTreeGolem(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.2F, 2.5F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.treeGolemDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.treeGolemHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.BLAZE.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.WITHER.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.WITHER.getPrefixedName();
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).addPotionEffect(new PotionEffect(Potion.poison.id, 60, 1));
		return super.attackEntityFrom(e, a);
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}