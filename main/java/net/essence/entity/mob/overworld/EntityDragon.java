package net.essence.entity.mob.overworld;

import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityDragon extends EntityModMob {

	public EntityDragon(World par1World) {
		super(par1World);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return 0;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return 5;
	}

	@Override
	public EnumSounds setLivingSound() {
		return null;
	}

	@Override
	public EnumSounds setHurtSound() {
		return null;
	}

	@Override
	public EnumSounds setDeathSound() {
		return null;
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}