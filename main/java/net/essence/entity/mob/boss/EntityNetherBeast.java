package net.essence.entity.mob.boss;

import net.essence.EssenceBlocks;
import net.essence.EssenceItems;
import net.essence.client.EnumSounds;
import net.essence.entity.MobStats;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntityNetherBeast extends EntityEssenceBoss {

	private int attackTimer;

	public EntityNetherBeast(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(3.0F, 3.5F);
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.attackTimer > 0) --this.attackTimer;
		if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
			int i = MathHelper.floor_double(this.posX);
			int j = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.yOffset);
			int k = MathHelper.floor_double(this.posZ);
			Block block = this.worldObj.getBlock(i, j, k);
			if(block.getMaterial() != Material.air)
				this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.boundingBox.minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity e) {
		this.attackTimer = 5;
		this.worldObj.setEntityState(this, (byte)4);
		boolean flag = e.attackEntityFrom(DamageSource.causeMobDamage(this), (float)getAttackDamage());
		if(flag) { 
			e.motionY += 1.0000000059604645D;
			e.setFire(10 + rand.nextInt(10));
		}
		this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		return flag;
	}

	@Override
	public double setAttackDamage(MobStats s) {
		return s.netherBeastDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.netherBeastHealth;
	}

	@Override
	public String setLivingSound() {
		return EnumSounds.NETHER_BEAST.getPrefixedName();
	}

	@Override
	public String setHurtSound() {
		return EnumSounds.NETHER_BEAST_HURT.getPrefixedName();
	}

	@Override
	public String setDeathSound() {
		return EnumSounds.NETHER_BEAST_HURT.getPrefixedName();
	}

	@Override
	public Item getItemDropped() {
		return EssenceItems.eucaPortalGem;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		switch(rand.nextInt(1)){
		case 0:
			this.dropItem(EssenceItems.eucaPortalGem, 6 + rand.nextInt(4));
			break;
		case 1:
			this.dropItem(EssenceItems.depthsPortalGem, 6 + rand.nextInt(4));
			break;
		}
		this.dropItem(EssenceItems.netherBeastSword, 1);

		if(rand.nextInt(1) == 0)
			this.dropItem(Item.getItemFromBlock(EssenceBlocks.netherBeastStatue), 1);
	}
}