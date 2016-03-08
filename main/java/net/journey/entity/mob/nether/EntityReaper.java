package net.journey.entity.mob.nether;

import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.enums.EnumSounds;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityReaper extends EntityModMob {

	protected int animID = 1;
	protected int animTick = 1;
	
	public EntityReaper(World par1World) {
		super(par1World);
		addAttackingAI();
		this.isImmuneToFire = true;
		setSize(0.7F, 2.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.reaperDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.reaperHealth;
	}

    protected String getLivingSound()
    {
        return "mob.wither.idle";
    }
    
    protected String getHurtSound()
    {
        return "mob.skeleton.hurt";
    }
    
    protected String getDeathSound()
    {
        return "mob.skeleton.death";
    }
	
	@Override
	public Item getItemDropped() {
		return JourneyItems.withicDust;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.EMPTY;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.EMPTY;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.EMPTY;
	}
}