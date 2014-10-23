package net.essence.entity.mob.boss;

import net.essence.EssenceItems;
import net.essence.entity.MobStats;
import net.essence.entity.projectile.EntityDeathSkull;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
	public String setLivingSound() {
		return "mob.wither.idle";
	}

	@Override
	public String setHurtSound() {
		return "mob.wither.hurt";
	}

	@Override
	public String setDeathSound() {
		return "mob.wither.death";
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.eucaPortalGem;
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		Item item = getItemDropped();
		for(int i = 0; i < rand.nextInt(5) + 4; i++)
			this.dropItem(item, 1);
		
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