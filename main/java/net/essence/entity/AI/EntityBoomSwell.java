package net.essence.entity.AI;

import net.essence.entity.mob.vanilla.EntityBoom;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityBoomSwell extends EntityAIBase {
	
    private EntityBoom swellingBoomBoom;
    private EntityLivingBase BoomBoomAttackTarget;

    public EntityBoomSwell(EntityBoom par1EntityBoomBoom) {
        this.swellingBoomBoom = par1EntityBoomBoom;
        this.setMutexBits(1);
    }
 
    @Override
    public boolean shouldExecute() {
        EntityLivingBase entitylivingbase = this.swellingBoomBoom.getAttackTarget();
        return this.swellingBoomBoom.getBoomBoomState() > 0 || entitylivingbase != null && this.swellingBoomBoom.getDistanceSqToEntity(entitylivingbase) < 9.0D;
    }

    @Override
    public void startExecuting() {
        this.swellingBoomBoom.getNavigator().clearPathEntity();
        this.BoomBoomAttackTarget = this.swellingBoomBoom.getAttackTarget();
    }

    @Override
    public void resetTask() {
        this.BoomBoomAttackTarget = null;
    }

    @Override
    public void updateTask() {
        if(this.BoomBoomAttackTarget == null) {
            this.swellingBoomBoom.setBoomBoomState(-1);
        }
        else if(this.swellingBoomBoom.getDistanceSqToEntity(this.BoomBoomAttackTarget) > 49.0D) {
            this.swellingBoomBoom.setBoomBoomState(-1);
        }
        else if(!this.swellingBoomBoom.getEntitySenses().canSee(this.BoomBoomAttackTarget)) {
            this.swellingBoomBoom.setBoomBoomState(-1);
        } else {
            this.swellingBoomBoom.setBoomBoomState(1);
        }
    }
}