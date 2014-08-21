package net.essence.entity.mob.vanilla;

import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntitySpyclops extends EntityModMob {

	public EntitySpyclops(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(1.5F, 2.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.spyclopsDamage;
	}
	
	@Override
	public double setMaxHealth(MobStats s) {
		return s.spyclopsHealth;
	}

	@Override
	public String setLivingSound(Sounds s) {
		return s.spyclops;
	}

	@Override
	public String setHurtSound(Sounds s) {
		return s.spyclopsHurt;
	}

	@Override
	public String setDeathSound(Sounds s) {
		return s.spyclopsHurt;
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}