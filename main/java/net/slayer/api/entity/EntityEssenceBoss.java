package net.slayer.api.entity;

import net.essence.util.IEssenceBoss;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityEssenceBoss extends EntityModMob implements IEssenceBoss {

	private int deathTicks;

	public EntityEssenceBoss(World par1World) {
		super(par1World);
	}

	@Override
	protected void onDeathUpdate() {
		++this.deathTicks;

		if(this.deathTicks >= 180 && this.deathTicks <= 200) {
			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D);
		}
		int i;
		int j;

		if(!this.worldObj.isRemote) {
			if(this.deathTicks > 150 && this.deathTicks % 5 == 0) {
				i = 1000;

				while(i > 0) {
					j = EntityXPOrb.getXPSplit(i);
					i -= j;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
				}
			}

			if(this.deathTicks == 1) this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
		}
		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;
		if(this.deathTicks == 200 && !this.worldObj.isRemote) {
			i = 2000;

			while (i > 0) {
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
			}
			this.setDead();
		}
	}
}