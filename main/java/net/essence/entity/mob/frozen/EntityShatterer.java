package net.essence.entity.mob.frozen;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.entity.AI.EntityAIFlying;
import net.essence.enums.EnumSounds;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityShatterer extends EntityModMob {

	public EntityShatterer(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(2F, 2F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.eucaChargerDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.eucaChargerHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.HONGO.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.SAND_CRAWLER.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.SAND_CRAWLER.getPrefixedName();
	}
	
	@Override
	public Item getItemDropped() {
		return null;//TODO: change all this stuff, it ain't my problem
	}
	
	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}
}