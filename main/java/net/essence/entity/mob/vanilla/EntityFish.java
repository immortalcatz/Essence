package net.essence.entity.mob.vanilla;

import net.essence.entity.MobStats;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModWaterMob;

public class EntityFish extends EntityModWaterMob {

	public static final int ENTITY_TYPE = 27;
	
	public EntityFish(World w) {
		super(w);
		setSize(0.5F, 0.5F);
		dataWatcher.updateObject(ENTITY_TYPE, rand.nextInt(4));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(ENTITY_TYPE, (int)0);
	}
	
	@Override
    public boolean getCanSpawnHere() {
        return this.posY > 45.0D && this.posY < 63.0D && worldObj.getBlockState(this.getPosition()).getBlock().getMaterial() == Material.water;
    }

	@Override
	public double setMaxHealth(MobStats s) {
		return s.fishHealth;
	}

	@Override
	public String setLivingSound() {
		return null;
	}

	@Override
	public String setHurtSound() {
		return null;
	}

	@Override
	public String setDeathSound() {
		return null;
	}

	@Override
	public Item getItemDropped() {
		return Items.fish;
	}
}