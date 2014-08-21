package net.essence.entity.mob.boss;

import net.essence.EssenceItems;
import net.essence.Sounds;
import net.essence.entity.MobStats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.slayer.api.entity.EntityEssenceBoss;

public class EntityNetherBeast extends EntityEssenceBoss implements IRangedAttackMob {

	private int waitTick, stage, ability, abilityCoolDown;
	public static final int basic = 0, jump = 1, charge = 2, explosion = 3, arrow = 4;
	private final int melee = 0, ranged = 1;
	private EntityAIBase rangedAI = new EntityAIArrowAttack(this, 0.25F, 5, 64.0F);

	public EntityNetherBeast(World par1World) {
		super(par1World);
		addAttackingAI();
		setSize(3.0F, 3.5F);
		ability = explosion;
		stage = ranged;
	}

	/*@Override
	protected void updateAITasks() {
		super.updateAITasks();
		abilitys();
	}

	private void abilitys(){
		if(getHealth() <= MobStats.netherBeastHealth / 2) stage = ranged;
		else stage = melee;
		EntityPlayer player = (EntityPlayer)this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);
		switch(stage){
		case melee:{
			this.targetTasks.removeTask(rangedAI);
			switch(rand.nextInt(1)){
			case 0:
				ability = jump;
				break;
			case 1:
				ability = charge;
				break;
			}
		}
		case ranged:{
			switch(rand.nextInt(1)){
			case 0:	
				ability = explosion;
				break;
			case 1:
				ability = arrow;
				this.targetTasks.addTask(1, rangedAI);
				break;
			}
		}
		}
		if(stage != ranged) addAttackingAI();
		
		if(ability == explosion){
			int ticks = rand.nextInt(500);
			boolean goneUp = false;
			if(ability == explosion && !goneUp && !worldObj.isRemote){
				this.motionY += 1;
				goneUp = true;
			}
			if(ticks == 0){
				goneUp = false;
				ticks = rand.nextInt(500);
			}
			ticks--;
		}
	}

	@Override
	protected void fall(float par1) {
		super.fall(par1);
		if(this.ability == explosion && !worldObj.isRemote){
			this.fallDistance = 0.0F;
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2.0F, false);
		}
	}*/

	@Override
	public double setAttackDamage(MobStats s) {
		return s.netherBeastDamage;
	}

	@Override
	public double setMaxHealth(MobStats s) {
		return s.netherBeastHealth;
	}

	@Override
	public String setLivingSound(Sounds s) {
		return null;
	}

	@Override
	public String setHurtSound(Sounds s) {
		return null;
	}

	@Override
	public String setDeathSound(Sounds s) {
		return null;
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
		EntityArrow arrow = new EntityArrow(this.worldObj, this, var1, 1.6F, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
		arrow.setDamage(20);
		worldObj.spawnEntityInWorld(arrow);
	}
}