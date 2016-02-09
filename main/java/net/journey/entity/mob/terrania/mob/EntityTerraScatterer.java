package net.journey.entity.mob.terrania.mob;

import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.enums.EnumSounds;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.entity.EntityModMob;

public class EntityTerraScatterer extends EntityModMob {

	public EntityTerraScatterer(World w) {
		super(w);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return MobStats.starlightGolemDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.starlightGolemHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.CREEPER;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.CREEPER_DEATH;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.WRAITH_DEATH;
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(30) == 0) dropItem(JourneyItems.cloudiaOrb, 1);
		super.dropFewItems(b, j);
		
	}

	@Override
	public Item getItemDropped() {
		return JourneyItems.cloudiaOrb;
	}

}