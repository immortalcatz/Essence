package net.essence.entity.mob.overworld;

import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityPeacefullUntillAttacked;

public class EntityTurtle extends EntityPeacefullUntillAttacked {

	public EntityTurtle(World par1World) {
		super(par1World);
		this.setSize(0.5F, 0.7F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.turtleDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.turtleHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.TURTLE;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.TURTLE_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.TURTLE_HURT;
	}

	@Override
	public Item getItemDropped() {
		return Items.fish;
	}
}