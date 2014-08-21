package net.essence.entity.mob.boss;

import net.essence.EssenceItems;
import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntityWraith extends EntityEssenceBoss {

	public EntityWraith(World par1World) {
		super(par1World);
		addAttackingAI();
	}
	
	@Override
	public double setAttackDamage(MobStats s) {
		return s.wraithDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.wraithHealth;
	}

	@Override
	public String setLivingSound(Sounds s) {
		return null;
	}

	@Override
	public String setHurtSound(Sounds s) {
		return null;
	}

	@Override
	public String setDeathSound(Sounds s) {
		return null;
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}