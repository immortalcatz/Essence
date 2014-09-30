package net.essence.entity.projectile.spawner;

import net.essence.entity.mob.boss.EntityCalcia;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;

public class EntityCalciaSpawner extends EntityThrowable {

	public EntityCalciaSpawner(World w) {
		super(w);
	}

	public EntityCalciaSpawner(World w, double x, double y, double z) {
		super(w, x, y, z);
	}

	public EntityCalciaSpawner(World w, EntityPlayer e) {
		super(w, e);
	}

	@Override
	protected void onImpact(MovingObjectPosition m) {
		if(!this.worldObj.isRemote) {
			if(m.typeOfHit == MovingObjectType.BLOCK) {
				EntityCalcia c = new EntityCalcia(worldObj);
				worldObj.spawnEntityInWorld(c);
				c.setLocationAndAngles(m.blockX, m.blockY + 1, m.blockZ, 0, 0);
				SlayerAPI.sendMessageToAll("Calcia has been summoned", true);
			}
		}
		this.setDead();
	}

	@Override
	protected float getGravityVelocity() {
		return 0.5F;
	}

}