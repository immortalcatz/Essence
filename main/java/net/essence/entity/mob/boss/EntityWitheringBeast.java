package net.essence.entity.mob.boss;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.essence.entity.projectile.EntityDeathSkull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
	protected void attackEntity(Entity e, float a) {
		super.attackEntity(e, a);
		((EntityPlayer)e).addPotionEffect(new PotionEffect(Potion.wither.id, 60, 0));
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.WITHER.getNonPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.WITHER_HURT.getNonPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.WITHER_DEATH.getNonPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.eucaPortalGem;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		switch(rand.nextInt(1)){
		case 0:
			this.dropItem(EssenceItems.depthsPortalGem, 6 + rand.nextInt(4));
			break;
		case 1:
			this.dropItem(EssenceItems.eucaPortalGem, 6 + rand.nextInt(4));
			break;
		}
		this.dropItem(EssenceItems.witheringBeastSword, 1);

		if(rand.nextInt(1) == 0)
			this.dropItem(Item.getItemFromBlock(EssenceBlocks.witheringBeastStatue), 1);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase var1, float var2) {
		this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1014, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
		double vecX = (double)(-MathHelper.sin(var1.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(var1.rotationPitch / 180.0F * (float)Math.PI));
		double vecY = (double)(-MathHelper.sin(var1.rotationPitch / 180.0F * (float)Math.PI));
		double vecZ = (double)( MathHelper.cos(var1.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(var1.rotationPitch / 180.0F * (float)Math.PI));
		double deltaX = (double)(-MathHelper.sin(var1.rotationYaw / 180.0F * (float)Math.PI));
		double deltaZ = (double)( MathHelper.cos(var1.rotationYaw / 180.0F * (float)Math.PI));
		EntityDeathSkull skull = new EntityDeathSkull(worldObj, var1, var1.posX + deltaX, var1.posY + 1, var1.posZ + deltaZ, vecX, vecY, vecZ);
		this.worldObj.spawnEntityInWorld(skull);
	}
}