package net.journey.items;

import java.util.List;

import net.journey.JourneyItems;
import net.journey.JourneyTabs;
import net.journey.client.server.DarkEnergyBar;
import net.journey.client.server.EssenceBar;
import net.journey.entity.projectile.EntityBasicProjectile;
import net.journey.entity.projectile.EntityChaosProjectile;
import net.journey.entity.projectile.EntityIceBall;
import net.journey.entity.projectile.EntityLightningBall;
import net.journey.enums.EnumSounds;
import net.journey.util.EssenceToolMaterial;
import net.journey.util.LangHelper;
import net.journey.util.LangRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.slayer.api.SlayerAPI;

public class ItemHammer extends ItemSword{
	
	protected int usage;
	protected int damage;
	protected boolean essence, unbreakable;
	protected Class<? extends EntityBasicProjectile> projectile;
	protected EssenceToolMaterial mat;
		
	    public ItemHammer(String name, String f, EssenceToolMaterial toolMaterial, boolean durability, Class<? extends EntityBasicProjectile> projectile, boolean essence, int dam, int magic, int uses) {
	        super(toolMaterial.getToolMaterial());
	    	this.projectile=projectile;
	    	damage = dam;
	    	usage = magic;
	    	this.essence = essence;
	    	setMaxDamage(uses);
	    	setMaxStackSize(1);
	        LangRegistry.addItem(name, f);
	        setUnlocalizedName(name);
	        mat = toolMaterial;
	        setCreativeTab(JourneyTabs.swords);
	        JourneyItems.itemNames.add(name);
	        GameRegistry.registerItem(this, name);

		}

		@Override
		public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
			if(essence) {
				if(!world.isRemote && EssenceBar.getProperties(player).useBar(usage)) {
					EnumSounds.playSound(EnumSounds.HAMMER, world, player);
					if(!unbreakable) stack.damageItem(1, player);
					try {
						world.spawnEntityInWorld(projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				if(!world.isRemote && DarkEnergyBar.getProperties(player).useBar(usage)) {
					EnumSounds.playSound(EnumSounds.HAMMER, world, player);
					if(!unbreakable) stack.damageItem(1, player);
					try {
						world.spawnEntityInWorld(projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return stack;
		}
	    
		@Override
		public boolean isItemTool(ItemStack i) {
			return true;
		}
	    
		@Override
		public boolean getIsRepairable(ItemStack i, ItemStack i1) {
			boolean canRepair = mat.getRepairItem() != null;
			if(canRepair) return mat.getRepairItem() == i1.getItem() ? true : super.getIsRepairable(i, i1);
			return super.getIsRepairable(i, i1);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
			if(item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " " + LangHelper.getUsesRemaining());
			else infoList.add(SlayerAPI.Colour.GREEN + LangHelper.getInfiniteUses());
		}
	}