package net.essence.entity.mob.vanilla;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModMob;

public class EntitySandCrawler extends EntityModMob {

	public EntitySandCrawler(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(1.8F, 1.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.sandCrawlerDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.sandCrawlerHealth;
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