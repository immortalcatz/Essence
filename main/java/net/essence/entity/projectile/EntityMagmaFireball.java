package net.essence.entity.projectile;

import cpw.mods.fml.client.FMLClientHandler;
import net.essence.client.render.particles.EntityHellstoneFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMagmaFireball extends EntitySmallFireball {

	public EntityMagmaFireball(World w) {
		super(w);
	}
	
    public EntityMagmaFireball(World w, EntityLivingBase e, double x, double y, double z) {
        super(w, e, x, y, z);
        this.setSize(0.3125F, 0.3125F);
    }
    
    @Override
    public void onUpdate() {
    	super.onUpdate();
		for(int i = 0; i < 6; ++i) {
			EntityFX effect = new EntityHellstoneFX(this.worldObj, this.posX, this.posY - 1.0F, this.posZ, 0.0D, 0.0D, 0.0D);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(effect);
		}
    }

	@Override
	protected void onImpact(MovingObjectPosition m) {
        if(!this.worldObj.isRemote) {
            if(m.entityHit != null) {
                if(!m.entityHit.isImmuneToFire() && m.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 10.0F)) {
                    m.entityHit.setFire(10);
                }
            } else {
                int i = m.blockX;
                int j = m.blockY;
                int k = m.blockZ;
                switch(m.sideHit) {
                    case 0:
                        --j;
                        break;
                    case 1:
                        ++j;
                        break;
                    case 2:
                        --k;
                        break;
                    case 3:
                        ++k;
                        break;
                    case 4:
                        --i;
                        break;
                    case 5:
                        ++i;
                }

                if(this.worldObj.isAirBlock(i, j, k)) {
                    this.worldObj.setBlock(i, j, k, Blocks.fire);
                }
            }
            this.setDead();
        }
    }
	
}
