package net.essence.entity.mob.euca;

import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityInsecto extends EntityModMob{

	public EntityInsecto(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.7F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.insectoDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.insectoHealth;
	}

	@Override
	public String setLivingSound(Sounds s) {
		return s.insecto;
	}

	@Override
	public String setHurtSound(Sounds s) {
		return s.insectoHurt;
	}

	@Override
	public String setDeathSound(Sounds s) {
		return s.insectoHurt;
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}