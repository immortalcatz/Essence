package net.essence.items;

import java.util.Iterator;
import java.util.List;

import net.essence.EssenceTabs;
import net.essence.entity.EssenceEntityList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawnEggs extends Item {
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    public ItemSpawnEggs() {
        this.setHasSubtypes(true);
        GameRegistry.registerItem(this, "essenceSpawners");
        setUnlocalizedName("essenceSpawner");
        this.setCreativeTab(EssenceTabs.spawners);
    }

    @Override
    public String getItemStackDisplayName(ItemStack i) {
        String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
        String s1 = EssenceEntityList.getStringFromID(i.getItemDamage());
        if(s1 != null) s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
        return s;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack i, int j) {
        EssenceEntityList.EntityEggInfo entityegginfo = (EssenceEntityList.EntityEggInfo)EssenceEntityList.entityEggs.get(Integer.valueOf(i.getItemDamage()));
        return entityegginfo != null ? (j == 0 ? entityegginfo.primaryColor : entityegginfo.secondaryColor) : 16777215;
    }
 
    @Override
    public boolean onItemUse(ItemStack i, EntityPlayer p, World w, int x, int y, int z, int s, float f, float f1, float f2) {
        if (w.isRemote) {
            return true;
        } else {
            Block block = w.getBlock(x, y, z);
            x += Facing.offsetsXForSide[s];
            y += Facing.offsetsYForSide[s];
            z += Facing.offsetsZForSide[s];
            double d0 = 0.0D;

            if (s == 1 && block.getRenderType() == 11) {
                d0 = 0.5D;
            }

            Entity entity = spawnCreature(w, i.getItemDamage(), (double)x + 0.5D, (double)y + d0, (double)z + 0.5D);

            if (entity != null) {
                if (entity instanceof EntityLivingBase && i.hasDisplayName()) {
                    ((EntityLiving)entity).setCustomNameTag(i.getDisplayName());
                }

                if (!p.capabilities.isCreativeMode) {
                    --i.stackSize;
                }
            }
            return true;
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer p) {
        if (w.isRemote) {
            return stack;
        } else {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(w, p, true);

            if (movingobjectposition == null) {
                return stack;
            } else {
                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if (!w.canMineBlock(p, i, j, k)) {
                        return stack;
                    }

                    if (!p.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack)) {
                        return stack;
                    }

                    if (w.getBlock(i, j, k) instanceof BlockLiquid) {
                        Entity entity = spawnCreature(w, stack.getItemDamage(), (double)i, (double)j, (double)k);

                        if (entity != null) {
                            if (entity instanceof EntityLivingBase && stack.hasDisplayName()) {
                                ((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
                            }

                            if (!p.capabilities.isCreativeMode) {
                                --stack.stackSize;
                            }
                        }
                    }
                }
                return stack;
            }
        }
    }

    public static Entity spawnCreature(World w, int id, double x, double y, double z) {
        if (!EssenceEntityList.entityEggs.containsKey(Integer.valueOf(id))) {
            return null;
        } else {
            Entity entity = null;

            for (int j = 0; j < 1; ++j) {
                entity = EssenceEntityList.createEntityByID(id, w);

                if (entity != null && entity instanceof EntityLivingBase) {
                    EntityLiving entityliving = (EntityLiving)entity;
                    entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(w.rand.nextFloat() * 360.0F), 0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.onSpawnWithEgg((IEntityLivingData)null);
                    w.spawnEntityInWorld(entity);
                    entityliving.playLivingSound();
                }
            }
            return entity;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int i, int j) {
        return j > 0 ? this.theIcon : super.getIconFromDamageForRenderPass(i, j);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item i, CreativeTabs c, List l) {
        Iterator iterator = EssenceEntityList.entityEggs.values().iterator();
        while (iterator.hasNext()) {
            EssenceEntityList.EntityEggInfo entityegginfo = (EssenceEntityList.EntityEggInfo)iterator.next();
            l.add(new ItemStack(i, 1, entityegginfo.entityID));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister i) {
    	this.itemIcon = i.registerIcon("spawn_egg");
        this.theIcon = i.registerIcon("spawn_egg_overlay");
    }
}