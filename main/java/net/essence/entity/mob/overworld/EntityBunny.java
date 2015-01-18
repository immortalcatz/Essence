package net.essence.entity.mob.overworld;

import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityPeacefullUntillAttacked;

public class EntityBunny extends EntityPeacefullUntillAttacked {

	public EntityBunny(World w) {
		super(w);
		this.setSize(0.5F, 0.5F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 1.0F));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.bunnyDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.bunnyHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.BUNNY.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.BUNNY_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.BUNNY_HURT.getPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}