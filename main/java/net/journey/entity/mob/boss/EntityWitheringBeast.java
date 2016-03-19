package net.journey.entity.mob.boss;

import com.google.common.collect.Lists;

import net.journey.JourneyBlocks;
import net.journey.JourneyItems;
import net.journey.blocks.tileentity.TileEntityJourneyChest;
import net.journey.entity.MobStats;
import net.journey.entity.projectile.EntityDeathSkull;
import net.journey.enums.EnumSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
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
	public void onDeath(DamageSource damage){
		this.worldObj.setBlockState(new BlockPos((int)Math.floor(this.posX + 0), ((int)Math.floor(this.posY + 0)), ((int)Math.floor(this.posZ + 0))), JourneyBlocks.netherChest.getStateFromMeta(5));
		TileEntityJourneyChest te = (TileEntityJourneyChest)worldObj.getTileEntity(new BlockPos((int)Math.floor(this.posX + 0), ((int)Math.floor(this.posY + 0)), ((int)Math.floor(this.posZ + 0))));
		switch(rand.nextInt(2)) {
		case 0:
			te.setInventorySlotContents(2, new ItemStack(JourneyItems.witheringBeastSword, 1));
			te.setInventorySlotContents(11, new ItemStack(JourneyItems.eucaPortalPiece_0, 1));
			break;
		case 1:
			te.setInventorySlotContents(5, new ItemStack(JourneyItems.witheringBeastSword, 1));
			te.setInventorySlotContents(15, new ItemStack(JourneyItems.eucaPortalPiece_0, 2));
			break;
		}
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
		return null;
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