package net.journey.entity.mob.frozen;

import net.journey.JourneyBlocks;
import net.journey.entity.MobStats;
import net.journey.enums.EnumSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityPermafraust extends EntityModMob {

	@SuppressWarnings("do this")
	public EntityPermafraust(World par1World) {
		super(par1World);
		addAttackingAI();
		this.setSize(0.5F, 2F);
	}
	
	@Override
	public double setAttackDamage(MobStats s) {
		return s.permafraustDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.permafraustHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.SMALL_HONGO;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.SMALL_HONGO_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.SMALL_HONGO_HURT;
	}
	
	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 45.0D && super.getCanSpawnHere() &&
				(this.worldObj.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == JourneyBlocks.frozenGrass);
	}

	@Override
	public Item getItemDropped() {
		return null;
	}
}