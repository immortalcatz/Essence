package net.essence.entity.mob.vanilla;

import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModMob;

public class EntityMediumHongo extends EntityModMob {

	public EntityMediumHongo(World par1World) {
		super(par1World);
		addAttackingAI();
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.bigHongoDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.bigHongoHealth;
	}

	@Override
	public String setLivingSound(Sounds sounds) {
		return sounds.robot;
	}

	@Override
	public String setHurtSound(Sounds sounds) {
		return sounds.robotHurt;
	}

	@Override
	public String setDeathSound(Sounds sounds) {
		return sounds.robotHurt;
	}

	@Override
	public Item getItemDropped() {
		return SlayerAPI.toItem(Blocks.brown_mushroom);
	}
}