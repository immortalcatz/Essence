package net.journey.entity.mob.boss;

import net.journey.JourneyBlocks;
import net.journey.JourneyItems;
import net.journey.entity.MobStats;
import net.journey.entity.projectile.EntityDeathSkull;
import net.journey.enums.EnumSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntityWitheringBeast extends EntityEssenceBoss implements IRangedAttackMob {

	public EntityWitheringBeast(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(2.0F, 3.8F);
		this.tasks.addTask(1, new EntityAIArrowAttack(this, 1.0D, 40, 20.0F));
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.witheringBeastDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.witheringBeastHealth;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource e, float a) {
		if(e.getSourceOfDamage() instanceof EntityPlayer)
			((EntityPlayer)e.getSourceOfDamage()).addPotionEffect(new PotionEffect(Potion.wither.id, 60, 0));
		return super.attackEntityFrom(e, a);
	}

	@Override
	public EnumSounds setLivingSound() {
		return EnumSounds.WITHER;
	}

	@Override
	public EnumSounds setHurtSound() {
		return EnumSounds.WITHER_HURT;
	}

	@Override
	public EnumSounds setDeathSound() {
		return EnumSounds.WITHER_DEATH;
	}

	@Override
	public Item getItemDropped() {
		return JourneyItems.eucaPortalPiece_0;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(JourneyItems.eucaPortalPiece_0, 2);
		this.dropItem(JourneyItems.witheringBeastSword, 1);

		//if(rand.nextInt(1) == 0)
		//	this.dropItem(Item.getItemFromBlock(EssenceBlocks.witheringBeastStatue), 1);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase var1, float var2) {
		this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1014, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
		double vecX = (double)(-MathHelper.sin(var1.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(var1.rotationPitch / 180.0F * (float)Math.PI));
		double vecY = (double)(-MathHelper.sin(var1.rotationPitch / 180.0F * (float)Math.PI));
		double vecZ = (double)( MathHelper.cos(var1.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(var1.rotationPitch / 180.0F * (float)Math.PI));
		double deltaX = (double)(-MathHelper.sin(var1.rotationYaw / 180.0F * (float)Math.PI));
		double deltaZ = (double)( MathHelper.cos(var1.rotationYaw / 180.0F * (float)Math.PI));
		EntityDeathSkull skull = new EntityDeathSkull(worldObj, var1, var1.posX + deltaX, var1.posY + 1, var1.posZ + deltaZ, vecX, vecY, vecZ);
		this.worldObj.spawnEntityInWorld(skull);
	}
}