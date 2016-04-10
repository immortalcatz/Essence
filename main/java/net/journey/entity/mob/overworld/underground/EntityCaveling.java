package net.journey.entity.mob.overworld.underground;

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

public class EntityCaveling extends EntityModMob {

	public EntityCaveling(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(1.0F, 2.0F);
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.lowJourneyDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.overworldHealth;
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
		return SlayerAPI.toItem(Blocks.stone);

	}

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 40.0D && super.getCanSpawnHere() && 
				this.worldObj.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == Blocks.stone;
	}

	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(15) == 0) dropItem(JourneyItems.caveCrystal, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(2) == 0) dropItem(JourneyItems.caveDust, 1);
		super.dropFewItems(b, j);
		if(rand.nextInt(4) == 0) dropItem(JourneyItems.caveDust, 3);
		super.dropFewItems(b, j);
		if(rand.nextInt(3) == 0) dropItem(JourneyItems.stoneClump, 2);
		super.dropFewItems(b, j);
		if(rand.nextInt(6) == 0) dropItem(JourneyItems.caveDust, 6);
		super.dropFewItems(b, j);
	}
}