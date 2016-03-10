package net.slayer.api.entity;

import net.journey.client.render.particles.EntityModFireFX;
import net.journey.client.render.particles.EntityModLavaFX;
import net.journey.enums.EnumSounds;
import net.journey.util.IEssenceBoss;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public abstract class EntityEssenceBoss extends EntityModMob implements IEssenceBoss {

	private int deathTicks;
	public EntityEssenceBoss(World par1World) {
		super(par1World);
		isImmuneToFire = true;
	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	@Override
	public final float getModHealth() {
		return super.getHealth();
	}
	
    protected String getDeathSound()
    {
        return "mob.wither.death";
    }
    
    @Override
    public float getSoundVolume() {
    	return 10.0F;
    }
	
	@Override
	public float getModMaxHealth() {
		return getMaxHealth();
	}

	protected void onDeathUpdate(World world, EntityPlayer player)
    {
       // ++this.deathTicks;

       // if (this.deathTicks >= 180 && this.deathTicks <= 200)
        {
        	EnumSounds.playSound(EnumSounds.WRAITH_DEATH, world, player);
            float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + (double)f, this.posY + 2.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + (double)f, this.posY + 1.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + (double)f, this.posY + 3.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + (double)f, this.posY + 2.5D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + (double)f, this.posY + 1.5D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, this.posX + (double)f, this.posY + 3.5D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D, new int[0]);
         
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + (double)f, this.posY + 1.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + (double)f, this.posY + 3.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + (double)f, this.posY + 1.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + (double)f, this.posY + 1.0D + (double)f1, this.posZ + (double)f2, 1.0D, 0.0D, 1.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + (double)f, this.posY + 3.0D + (double)f1, this.posZ + (double)f2, -1.0D, 0.0D, -1.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + (double)f, this.posY + 1.0D + (double)f1, this.posZ + (double)f2, 1.0D, 0.0D, -1.0D, new int[0]);
        }

        int i;
        int j;

        if (!this.worldObj.isRemote)
        {
            //if (this.deathTicks > 150 && this.deathTicks % 5 == 0 && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot"))
            {
                i = 1000;

                while (i > 0)
                {
                    j = EntityXPOrb.getXPSplit(i);
                    i -= j;
                    this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                }
            }

            //if (this.deathTicks == 1)
            {
                //this.worldObj.playBroadcastSound(1018, new BlockPos(this), 0);
            }
        }

        //this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
        this.renderYawOffset = this.rotationYaw += 20.0F;

        //if (this.deathTicks == 200 && !this.worldObj.isRemote)
        {
            i = 2000;

            while (i > 0)
            {
                j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
            }
            this.setDead();
        }
    }
}