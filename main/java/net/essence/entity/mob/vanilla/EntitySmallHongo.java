package net.essence.entity.mob.vanilla;

import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModMob;

public class EntitySmallHongo extends EntityModMob {

	public EntitySmallHongo(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(0.5F, 0.7F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.smallHongoDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.smallHongoHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.HONGO.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.SMALL_HONGO_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.SMALL_HONGO_HURT.getPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return SlayerAPI.toItem(Blocks.brown_mushroom);
	}
}