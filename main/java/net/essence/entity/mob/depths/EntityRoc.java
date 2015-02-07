package net.essence.entity.mob.depths;

import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityPeacefullUntillAttacked;

public class EntityRoc extends EntityPeacefullUntillAttacked {

	@SuppressWarnings("do this")
	public EntityRoc(World w) {
		super(w);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.rocDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.rocHealth;
	}

	@Override
	public String setLivingSound() {
		return null;
	}

	@Override
	public String setHurtSound() {
		return null;
	}

	@Override
	public String setDeathSound() {
		return null;
	}

	@Override
	public Item getItemDropped() {
		return null;
	}

}