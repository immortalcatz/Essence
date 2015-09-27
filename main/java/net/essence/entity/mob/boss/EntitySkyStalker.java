package net.essence.entity.mob.boss;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntitySkyStalker extends EntityEssenceBoss {

	public EntitySkyStalker(World par1World) {
		super(par1World);
		this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
		setSize(0.7F, 1.2F);
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return MobStats.silverbotHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.INSECTO;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.SHIMMERER_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.SHIMMERER_DEATH;
	}
	
	@Override
	protected float getSoundVolume() {
        return 10.0F;
    }
	
	@Override
	public boolean getCanSpawnHere() {
        return this.rand.nextInt(15) == 0 && super.getCanSpawnHere() && this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(1) == 0) dropItem(EssenceItems.fluffyFeather, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(1) == 0) dropItem(EssenceItems.fluffyFeather, 4);
		super.dropFewItems(b, j);
		if(rand.nextInt(30) == 0) dropItem(EssenceItems.cloudiaOrb, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(60) == 0) dropItem(EssenceItems.cloudiaOrb, 4);
		super.dropFewItems(b, j);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}

	@Override
	public Item getItemDropped() {
		return null;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		// TODO Auto-generated method stub
		return 0;
	}
}