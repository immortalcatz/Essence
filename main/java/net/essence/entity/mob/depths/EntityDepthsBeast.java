package net.essence.entity.mob.depths;

import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityDepthsBeast extends EntityModMob{

	public EntityDepthsBeast(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.7F, 2.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.depthsBeastDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.depthsBeastHealth;
	}

	@Override
	public String setLivingSound(Sounds s) {
		return s.magmaGiant;
	}

	@Override
	public String setHurtSound(Sounds s) {
		return s.magmaGiantHurt;
	}

	@Override
	public String setDeathSound(Sounds s) {
		return s.magmaGiantHurt;
	}
	
	@Override
	public Item getItemDropped() {
		return null;
	}
}