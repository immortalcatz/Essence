package net.essence.entity.mob.euca;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityEucaCharger extends EntityModMob {

	public EntityEucaCharger(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.2F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.eucaChargerDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.eucaChargerHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.INSECTO.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.INSECTO_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.INSECTO_HURT.getPrefixedName();
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}