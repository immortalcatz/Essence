package net.essence.entity.mob.vanilla;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
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
	public String setLivingSound() {
		return EnumSounds.ROBOT.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.ROBOT_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.ROBOT_HURT.getPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}