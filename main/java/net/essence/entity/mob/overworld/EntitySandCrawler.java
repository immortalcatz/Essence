package net.essence.entity.mob.overworld;

import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
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
		return EnumSounds.SAND_CRAWLER.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.MAGMA_GIANT_HURT.getPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		for(int i = 0; i < 32 + rand.nextInt(16); i++)
			this.dropItem(SlayerAPI.toItem(Blocks.sand), 2);
	}
}