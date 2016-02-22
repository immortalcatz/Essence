package net.journey.entity.mob.terrania.mob;

import net.journey.JourneyItems;
import net.journey.JITL;
import net.journey.entity.MobStats;
import net.journey.enums.EnumSounds;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModMob;

public class EntityTerraslug extends EntityModMob {

	public EntityTerraslug(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.1F, 0.1F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.mediumHongoDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.mediumHongoHealth;
	}
	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.HONGO;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.HONGO_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.HONGO_HURT;
	}

	@Override
	public Item getItemDropped() {
		return JourneyItems.hongoShroom;
	}
}