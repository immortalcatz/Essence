/**
 * An altered version of the Guardian Entity
 * Author ~ Ryan Bakody (Dizzlepop12), and Mojang
 */

package net.journey.entity.mob.boiling;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.journey.JourneyItems;
import net.journey.entity.mob.euca.EntityShimmerer;
import net.journey.entity.projectile.EntityShimmererProjectile;
import net.journey.enums.EnumSounds;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityLavasnake extends EntityMob
{
    private float B;
    private float C;
    private float BK;
    private float BL;
    private float BM;
    private EntityLivingBase BN;
    private int BO;
    private boolean BP;
    //private EntityAIWander wander;
    private static final String __OBFID = "CL_00002213";

    public EntityLavasnake(World worldIn)
    {
        super(worldIn);
        this.experienceValue = 10;
        this.setSize(4.3F, 4.2F);
        this.tasks.addTask(4, new EntityLavasnake.AIGuardianAttack());
        EntityAIMoveTowardsRestriction entityaimovetowardsrestriction;
        this.tasks.addTask(5, entityaimovetowardsrestriction = new EntityAIMoveTowardsRestriction(this, 1.0D));
        //this.tasks.addTask(7, this.wander = new EntityAIWander(this, 1.0D, 80));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityLavasnake.class, 12.0F, 0.01F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        //this.wander.setMutexBits(3);
        entityaimovetowardsrestriction.setMutexBits(3);
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 10, true, false, new EntityLavasnake.GuardianTargetSelector()));
        this.moveHelper = new EntityLavasnake.GuardianMoveHelper();
        this.C = this.B = this.rand.nextFloat();
		//this.moveHelper = new EntityLavasnake.MoveHelper();
		//this.tasks.addTask(5, new EntityLavasnake.AIRandomFly());
		this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
		this.moveHelper = new EntityLavasnake.MoveHelper();
		this.tasks.addTask(5, new EntityLavasnake.AIRandomFly());
		this.tasks.addTask(7, new EntityLavasnake.AIFireballAttack());
        this.tasks.addTask(7, new EntityLavasnake.AILookAround());
		this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
        this.isImmuneToFire = true;
    }

	@Override
	public boolean getCanSpawnHere() {
        return this.rand.nextInt(15) == 0 && super.getCanSpawnHere() && this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
    }
	
	private class AIRandomFly extends EntityAIBase {
		private EntityLavasnake e = EntityLavasnake.this;

		public AIRandomFly() {
			this.setMutexBits(1);
		}

		@Override
		public boolean shouldExecute() {
			EntityMoveHelper entitymovehelper = this.e.getMoveHelper();
			if(!entitymovehelper.isUpdating()) {
				return true;
			} else {
				double d0 = entitymovehelper.func_179917_d() - this.e.posX;
				double d1 = entitymovehelper.func_179919_e() - this.e.posY;
				double d2 = entitymovehelper.func_179918_f() - this.e.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D;
			}
		}

		@Override
		public boolean continueExecuting() {
			return false;
		}

		@Override
		public void startExecuting() {
			Random random = this.e.getRNG();
			double d0 = this.e.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d1 = this.e.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d2 = this.e.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.e.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
		}
	}

	private class MoveHelper extends EntityMoveHelper {
		private EntityLavasnake e = EntityLavasnake.this;
		private int height;

		public MoveHelper() {
			super(EntityLavasnake.this);
		}

		@Override
		public void onUpdateMoveHelper() {
			if(this.update) {
				double d0 = this.posX - this.e.posX;
				double d1 = this.posY - this.e.posY;
				double d2 = this.posZ - this.e.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				if(this.height-- <= 0) {
					this.height += this.e.getRNG().nextInt(5) + 2;
					d3 = (double)MathHelper.sqrt_double(d3);
					if(this.canMove(this.posX, this.posY, this.posZ, d3)) {
						this.e.motionX += d0 / d3 * 0.1D;
						this.e.motionY += d1 / d3 * 0.1D;
						this.e.motionZ += d2 / d3 * 0.1D;
					} else {
						this.update = false;
					}
				}
			}
		}

		private boolean canMove(double x, double y, double z, double h)  {
			double d4 = (x - this.e.posX) / h;
			double d5 = (y - this.e.posY) / h;
			double d6 = (z - this.e.posZ) / h;
			AxisAlignedBB axisalignedbb = this.e.getEntityBoundingBox();
			for(int i = 1; (double)i < h; ++i) {
				axisalignedbb = axisalignedbb.offset(d4, d5, d6);
				if(!this.e.worldObj.getCollidingBoundingBoxes(this.e, axisalignedbb).isEmpty()) {
					return false;
				}
			}
			return true;
		}
	}

	public class AILookAround extends EntityAIBase {
		private EntityLavasnake e = EntityLavasnake.this;

		public AILookAround() {
			this.setMutexBits(2);
		}

		@Override
		public boolean shouldExecute() {
			return true;
		}

		@Override
		public void updateTask() {
			if (this.e.getAttackTarget() == null) {
				this.e.renderYawOffset = this.e.rotationYaw = -((float)Math.atan2(this.e.motionX, this.e.motionZ)) * 180.0F / (float)Math.PI;
			} else {
				EntityLivingBase entitylivingbase = this.e.getAttackTarget();
				double d0 = 64.0D;

				if (entitylivingbase.getDistanceSqToEntity(this.e) < d0 * d0) {
					double d1 = entitylivingbase.posX - this.e.posX;
					double d2 = entitylivingbase.posZ - this.e.posZ;
					this.e.renderYawOffset = this.e.rotationYaw = -((float)Math.atan2(d1, d2)) * 180.0F / (float)Math.PI;
				}
			}
		}
	}

	public class AIFireballAttack extends EntityAIBase {
		private EntityLavasnake entity = EntityLavasnake.this;
		public int counter;

		@Override
		public boolean shouldExecute() {
			return this.entity.getAttackTarget() != null;
		}

		@Override
		public void startExecuting() {
			this.counter = 0;
		}

		@Override
		public void updateTask() {
			EntityLivingBase entitylivingbase = this.entity.getAttackTarget();
			double d0 = 64.0D;

			if(entitylivingbase.getDistanceSqToEntity(this.entity) < d0 * d0 && this.entity.canEntityBeSeen(entitylivingbase)) {
				World world = this.entity.worldObj;
				counter++;

				if(this.counter == 20) {
					double d1 = 4.0D;
					Vec3 vec3 = this.entity.getLook(1.0F);
					double d2 = entitylivingbase.posX - (this.entity.posX + vec3.xCoord * d1);
					double d3 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (0.5D + this.entity.posY + (double)(this.entity.height / 2.0F));
					double d4 = entitylivingbase.posZ - (this.entity.posZ + vec3.zCoord * d1);
					world.playAuxSFXAtEntity((EntityPlayer)null, 1008, new BlockPos(this.entity), 0);
					EntityShimmererProjectile projectile = new EntityShimmererProjectile(world, this.entity, d2, d3, d4);
					projectile.posX = this.entity.posX + vec3.xCoord * d1;
					projectile.posY = this.entity.posY + (double)(this.entity.height / 2.0F) + 0.5D;
					projectile.posZ = this.entity.posZ + vec3.zCoord * d1;
					world.spawnEntityInWorld(projectile);
					this.counter = -40;
				}
			}
			else if(this.counter > 0) counter--;
		}
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
    }

    protected PathNavigate func_175447_b(World worldIn)
    {
        return new PathNavigateSwimmer(this, worldIn);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Integer.valueOf(0));
        this.dataWatcher.addObject(17, Integer.valueOf(0));
    }

    private boolean func_175468_a(int p_175468_1_)
    {
        return (this.dataWatcher.getWatchableObjectInt(16) & p_175468_1_) != 0;
    }

    private void func_175473_a(int p_175473_1_, boolean p_175473_2_)
    {
        int j = this.dataWatcher.getWatchableObjectInt(16);

        if (p_175473_2_)
        {
            this.dataWatcher.updateObject(16, Integer.valueOf(j | p_175473_1_));
        }
        else
        {
            this.dataWatcher.updateObject(16, Integer.valueOf(j & ~p_175473_1_));
        }
    }

    public boolean func_175472_n()
    {
        return this.func_175468_a(2);
    }

    private void func_175476_l(boolean p_175476_1_)
    {
        this.func_175473_a(2, p_175476_1_);
    }

    public int func_175464_ck()
    {
        return this.is () ? 60 : 80;
    }

    public boolean is ()
    {
        return this.func_175468_a(4);
    }

    public void func_175467_a(boolean p_175467_1_)
    {
        this.func_175473_a(4, p_175467_1_);

        if (p_175467_1_)
        {
            this.setSize(1.9975F, 1.9975F);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0D);
            this.enablePersistence();
            //this.wander.func_179479_b(400);
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_175465_cm()
    {
        this.func_175467_a(true);
        this.BM= this.BL = 1.0F;
    }

    private void func_175463_b(int p_175463_1_)
    {
        this.dataWatcher.updateObject(17, Integer.valueOf(p_175463_1_));
    }

    public boolean func_175474_cn()
    {
        return this.dataWatcher.getWatchableObjectInt(17) != 0;
    }

    public EntityLivingBase getTargetedEntity()
    {
        if (!this.func_175474_cn())
        {
            return null;
        }
        else if (this.worldObj.isRemote)
        {
            if (this.BN != null)
            {
                return this.BN;
            }
            else
            {
                Entity entity = this.worldObj.getEntityByID(this.dataWatcher.getWatchableObjectInt(17));

                if (entity instanceof EntityLivingBase)
                {
                    this.BN = (EntityLivingBase)entity;
                    return this.BN;
                }
                else
                {
                    return null;
                }
            }
        }
        else
        {
            return this.getAttackTarget();
        }
    }

    public void func_145781_i(int p_145781_1_)
    {
        super.func_145781_i(p_145781_1_);

        if (p_145781_1_ == 16)
        {
            if (this.is () && this.width < 1.0F)
            {
                this.setSize(1.9975F, 1.9975F);
            }
        }
        else if (p_145781_1_ == 17)
        {
            this.BO = 0;
            this.BN = null;
        }
    }

    public int getTalkInterval()
    {
        return 160;
    }

    protected EnumSounds setLivingSound() {
    {
        return EnumSounds.INSECTO;
    }
    }

    protected EnumSounds setHurtSound() {
    {
        return EnumSounds.INSECTO_HURT;
    }
    }

    protected String getDeathSound()
    {
        return "mob.guardian.land.death";
    }

    protected boolean canTriggerWalking()
    {
        return false;
    }

    public float getEyeHeight()
    {
        return this.height * 0.5F;
    }

    public float func_180484_a(BlockPos p_180484_1_)
    {
        return this.worldObj.getBlockState(p_180484_1_).getBlock().getMaterial() == Material.lava ? 10.0F + this.worldObj.getLightBrightness(p_180484_1_) - 0.5F : super.func_180484_a(p_180484_1_);
    }

    public void onLivingUpdate()
    {
        if (this.worldObj.isRemote)
        {
            this.C = this.B;

            if (!this.isEntityAlive())
            {

            }
            else if (this.func_175472_n())
            {
                if (this.BK < 0.5F)
                {
                    this.BK = 4.0F;
                }
                else
                {
                    this.BK += (0.5F - this.BK) * 0.1F;
                }
            }
            else
            {
                this.BK += (0.125F - this.BK) * 0.2F;
            }

            this.B += this.BK;
            this.BM = this.BL;



            if (!this.isEntityAlive())
            {
                Vec3 vec3 = this.getLook(0.0F);

                for (int i = 0; i < 2; ++i)
                {
                    this.worldObj.spawnParticle(EnumParticleTypes.DRIP_LAVA, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width - vec3.xCoord * 1.5D, this.posY + this.rand.nextDouble() * (double)this.height - vec3.yCoord * 1.5D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width - vec3.zCoord * 1.5D, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (this.func_175474_cn())
            {
                if (this.BO < this.func_175464_ck())
                {
                    ++this.BO;
                }

                EntityLivingBase entitylivingbase = this.getTargetedEntity();

                if (entitylivingbase != null)
                {
                    this.getLookHelper().setLookPositionWithEntity(entitylivingbase, 90.0F, 90.0F);
                    this.getLookHelper().onUpdateLook();
                    double d5 = (double)this.func_175477_p(0.0F);
                    double d0 = entitylivingbase.posX - this.posX;
                    double d1 = entitylivingbase.posY + (double)(entitylivingbase.height * 0.5F) - (this.posY + (double)this.getEyeHeight());
                    double d2 = entitylivingbase.posZ - this.posZ;
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    d0 /= d3;
                    d1 /= d3;
                    d2 /= d3;
                    double d4 = this.rand.nextDouble();

                    while (d4 < d3)
                    {
                        d4 += 1.8D - d5 + this.rand.nextDouble() * (1.7D - d5);
                        this.worldObj.spawnParticle(EnumParticleTypes.DRIP_LAVA, this.posX + d0 * d4, this.posY + d1 * d4 + (double)this.getEyeHeight(), this.posZ + d2 * d4, 0.0D, 0.0D, 0.0D, new int[0]);
                    }
                }
            }
        }

        if (!this.isEntityAlive())
        {
            this.setAir(300);
        }
        else if (this.onGround)
        {
            this.motionY += 0.5D;
            this.motionX += (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.motionZ += (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.rotationYaw = this.rand.nextFloat() * 360.0F;
            this.onGround = false;
            this.isAirBorne = true;
        }

        if (this.func_175474_cn())
        {
            this.rotationYaw = this.rotationYawHead;
        }

        super.onLivingUpdate();
    }

    @SideOnly(Side.CLIENT)
    public float func_175471_a(float p_175471_1_)
    {
        return this.C + (this.B - this.C) * p_175471_1_;
    }

    @SideOnly(Side.CLIENT)
    public float func_175469_o(float p_175469_1_)
    {
        return this.BM + (this.BL - this.BM) * p_175469_1_;
    }

    public float func_175477_p(float p_175477_1_)
    {
        return ((float)this.BO + p_175477_1_) / (float)this.func_175464_ck();
    }

    protected void updateAITasks()
    {
        super.updateAITasks();

        if (this.is ())
        {
            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;

            if ((this.ticksExisted + this.getEntityId()) % 1200 == 0)
            {
                Potion potion = Potion.digSlowdown;
                List list = this.worldObj.getPlayers(EntityPlayerMP.class, new Predicate()
                {
                    private static final String __OBFID = "CL_00002212";
                    public boolean func_179913_a(EntityPlayerMP p_179913_1_)
                    {
                        return EntityLavasnake.this.getDistanceSqToEntity(p_179913_1_) < 2500.0D && p_179913_1_.theItemInWorldManager.func_180239_c();
                    }
                    public boolean apply(Object p_apply_1_)
                    {
                        return this.func_179913_a((EntityPlayerMP)p_apply_1_);
                    }
                });
                Iterator iterator = list.iterator();

                while (iterator.hasNext())
                {
                    EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

                    if (!entityplayermp.isPotionActive(potion) || entityplayermp.getActivePotionEffect(potion).getAmplifier() < 2 || entityplayermp.getActivePotionEffect(potion).getDuration() < 1200)
                    {
                        entityplayermp.playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(10, 0.0F));
                        entityplayermp.addPotionEffect(new PotionEffect(potion.id, 6000, 2));
                    }
                }
            }

            if (!this.hasHome())
            {
                this.func_175449_a(new BlockPos(this), 16);
            }
        }
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (!this.func_175472_n() && !source.isMagicDamage() && source.getSourceOfDamage() instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)source.getSourceOfDamage();

            if (!source.isExplosion())
            {
                entitylivingbase.attackEntityFrom(DamageSource.causeThornsDamage(this), 2.0F);
                entitylivingbase.playSound("damage.thorns", 0.5F, 1.0F);
            }
        }

       // this.wander.func_179480_f();
        return super.attackEntityFrom(source, amount);
    }

    public int getVerticalFaceSpeed()
    {
        return 180;
    }

    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
    {
        if (this.isServerWorld())
        {
        	if (!this.isEntityAlive())
            {
                this.moveFlying(p_70612_1_, p_70612_2_, 0.1F);
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= 0.8999999761581421D;
                this.motionY *= 0.8999999761581421D;
                this.motionZ *= 0.8999999761581421D;

                if (!this.func_175472_n() && this.getAttackTarget() == null)
                {
                    this.motionY -= 0.005D;
                }
            }
            else
            {
                super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
            }
        }
        else
        {
            super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
        }
    }

    class AIGuardianAttack extends EntityAIBase
    {
        private EntityLavasnake field_179456_a = EntityLavasnake.this;
        private int field_179455_b;
        private static final String __OBFID = "CL_00002211";

        public AIGuardianAttack()
        {
            this.setMutexBits(3);
        }

        public boolean shouldExecute()
        {
            EntityLivingBase entitylivingbase = this.field_179456_a.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
        }

        public boolean continueExecuting()
        {
            return super.continueExecuting() && (this.field_179456_a.is () || this.field_179456_a.getDistanceSqToEntity(this.field_179456_a.getAttackTarget()) > 9.0D);
        }

        public void startExecuting()
        {
            this.field_179455_b = -10;
            this.field_179456_a.getNavigator().clearPathEntity();
            this.field_179456_a.getLookHelper().setLookPositionWithEntity(this.field_179456_a.getAttackTarget(), 90.0F, 90.0F);
            this.field_179456_a.isAirBorne = true;
        }

        public void resetTask()
        {
            this.field_179456_a.func_175463_b(0);
            this.field_179456_a.setAttackTarget((EntityLivingBase)null);
            //this.field_179456_a.wander.func_179480_f();
        }

        public void updateTask()
        {
            EntityLivingBase entitylivingbase = this.field_179456_a.getAttackTarget();
            this.field_179456_a.getNavigator().clearPathEntity();
            this.field_179456_a.getLookHelper().setLookPositionWithEntity(entitylivingbase, 90.0F, 90.0F);

            if (!this.field_179456_a.canEntityBeSeen(entitylivingbase))
            {
                this.field_179456_a.setAttackTarget((EntityLivingBase)null);
            }
            else
            {
                ++this.field_179455_b;

                if (this.field_179455_b == 0)
                {
                    this.field_179456_a.func_175463_b(this.field_179456_a.getAttackTarget().getEntityId());
                    this.field_179456_a.worldObj.setEntityState(this.field_179456_a, (byte)21);
                }
                else if (this.field_179455_b >= this.field_179456_a.func_175464_ck())
                {
                    float f = 1.0F;

                    if (this.field_179456_a.worldObj.getDifficulty() == EnumDifficulty.HARD)
                    {
                        f += 2.0F;
                    }

                    if (this.field_179456_a.is ())
                    {
                        f += 2.0F;
                    }

                    entitylivingbase.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this.field_179456_a, this.field_179456_a), f);
                    entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(this.field_179456_a), (float)this.field_179456_a.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
                    this.field_179456_a.setAttackTarget((EntityLivingBase)null);
                }
                else if (this.field_179455_b >= 60 && this.field_179455_b % 20 == 0)
                {
                    ;
                }

                super.updateTask();
            }
        }
    }

    class GuardianMoveHelper extends EntityMoveHelper
    {
        private EntityLavasnake field_179930_g = EntityLavasnake.this;
        private static final String __OBFID = "CL_00002209";

        public GuardianMoveHelper()
        {
            super(EntityLavasnake.this);
        }

        public void onUpdateMoveHelper()
        {
            if (this.update && !this.field_179930_g.getNavigator().noPath())
            {
                double d0 = this.posX - this.field_179930_g.posX;
                double d1 = this.posY - this.field_179930_g.posY;
                double d2 = this.posZ - this.field_179930_g.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                d3 = (double)MathHelper.sqrt_double(d3);
                d1 /= d3;
                float f = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
                this.field_179930_g.rotationYaw = this.limitAngle(this.field_179930_g.rotationYaw, f, 30.0F);
                this.field_179930_g.renderYawOffset = this.field_179930_g.rotationYaw;
                float f1 = (float)(this.speed * this.field_179930_g.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                this.field_179930_g.setAIMoveSpeed(this.field_179930_g.getAIMoveSpeed() + (f1 - this.field_179930_g.getAIMoveSpeed()) * 0.125F);
                double d4 = Math.sin((double)(this.field_179930_g.ticksExisted + this.field_179930_g.getEntityId()) * 0.5D) * 0.05D;
                double d5 = Math.cos((double)(this.field_179930_g.rotationYaw * (float)Math.PI / 180.0F));
                double d6 = Math.sin((double)(this.field_179930_g.rotationYaw * (float)Math.PI / 180.0F));
                this.field_179930_g.motionX += d4 * d5;
                this.field_179930_g.motionZ += d4 * d6;
                d4 = Math.sin((double)(this.field_179930_g.ticksExisted + this.field_179930_g.getEntityId()) * 0.75D) * 0.05D;
                this.field_179930_g.motionY += d4 * (d6 + d5) * 0.25D;
                this.field_179930_g.motionY += (double)this.field_179930_g.getAIMoveSpeed() * d1 * 0.1D;
                EntityLookHelper entitylookhelper = this.field_179930_g.getLookHelper();
                double d7 = this.field_179930_g.posX + d0 / d3 * 2.0D;
                double d8 = (double)this.field_179930_g.getEyeHeight() + this.field_179930_g.posY + d1 / d3 * 1.0D;
                double d9 = this.field_179930_g.posZ + d2 / d3 * 2.0D;
                double d10 = entitylookhelper.func_180423_e();
                double d11 = entitylookhelper.func_180422_f();
                double d12 = entitylookhelper.func_180421_g();

                if (!entitylookhelper.func_180424_b())
                {
                    d10 = d7;
                    d11 = d8;
                    d12 = d9;
                }

                this.field_179930_g.getLookHelper().setLookPosition(d10 + (d7 - d10) * 0.125D, d11 + (d8 - d11) * 0.125D, d12 + (d9 - d12) * 0.125D, 10.0F, 40.0F);
                this.field_179930_g.func_175476_l(true);
            }
            else
            {
                this.field_179930_g.setAIMoveSpeed(0.0F);
                this.field_179930_g.func_175476_l(false);
            }
        }
    }

    class GuardianTargetSelector implements Predicate
    {
        private EntityLavasnake field_179916_a = EntityLavasnake.this;
        private static final String __OBFID = "CL_00002210";

        public boolean func_179915_a(EntityLivingBase p_179915_1_)
        {
            return (p_179915_1_ instanceof EntityPlayer || p_179915_1_ instanceof EntitySquid) && p_179915_1_.getDistanceSqToEntity(this.field_179916_a) > 9.0D;
        }

        public boolean apply(Object p_apply_1_)
        {
            return this.func_179915_a((EntityLivingBase)p_apply_1_);
        }
    }
}