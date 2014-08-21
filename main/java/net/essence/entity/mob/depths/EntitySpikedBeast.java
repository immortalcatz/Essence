package net.essence.entity.mob.depths;

import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntitySpikedBeast extends EntityModMob{

	public EntitySpikedBeast(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 1.7F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.spikedBeastDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.spikedBeastHealth;
	}

	@Override
	public String setLivingSound(Sounds s) {
		return s.spikedBeast;
	}

	@Override
	public String setHurtSound(Sounds s) {
		return s.spikedBeastHurt;
	}

	@Override
	public String setDeathSound(Sounds s) {
		return s.spikedBeastHurt;
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}