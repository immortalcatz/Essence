package net.essence.entity.mob.boiling;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityModMob;

public class EntityHellwing extends EntityModMob{

	public EntityHellwing(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(0.2F, 2.0F);
		isImmuneToFire = true;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.hellwingDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.hellwingHealth;
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.SPIKED_BEAST;
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
	public boolean getCanSpawnHere() {
		return this.worldObj.getBlockState(new BlockPos(this.posX, this.posY-1, this.posZ)).getBlock() == EssenceBlocks.hotBlock;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).setFire(5 + rand.nextInt(7));
		return super.attackEntityFrom(e, a);
	}
	
	@Override
	public Item getItemDropped() {
		return EssenceItems.ash;
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(Items.diamond_axe);
	}
	
	@Override
	protected void dropFewItems(boolean b, int j) {
		if(rand.nextInt(10) == 0) dropItem(EssenceItems.boilingSkull, 1);
		super.dropFewItems(b, j);
	    if(rand.nextInt(30) == 0) dropItem(EssenceItems.blazingFireball, 1);
		super.dropFewItems(b, j); 
		
		{
		}
	}
}