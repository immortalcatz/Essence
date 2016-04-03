/**package net.journey.items;

import java.util.List;

import net.journey.JourneyTabs;
import net.journey.client.server.EssenceBar;
import net.journey.entity.projectile.EntityChaosProjectile;
import net.journey.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemGun extends ItemMod {

	private Item ammo;
	private Class<? extends Entity> projectileClass;
	private float damage;
	private EnumSounds sound;
	
	public ItemGun(String name, String f, Item ammo, float damage, int uses, Class<? extends Entity> projectile) {
		super(name, f, JourneyTabs.staves);
		setMaxStackSize(1);
		setMaxDamage(uses);
		setFull3D();
		this.ammo = ammo;
		this.damage = damage;
		this.projectileClass = projectile;
	}
	
	public ItemGun(String name, String f, Item ammo, float damage, Class<? extends Entity> projectile) {
		super(name, f, JourneyTabs.staves);
		setMaxStackSize(1);
		setMaxDamage(500);
		setFull3D();
		this.ammo = ammo;
		this.damage = damage;
		this.projectileClass = projectile;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(ammo)) {
			Entity projectile = null;
			try {
				projectile = projectileClass.getConstructor(World.class, EntityLivingBase.class).newInstance(worldIn, playerIn);
			} catch(Exception e) {
				e.printStackTrace();
			}
			EnumSounds.playSound(EnumSounds.PLASMA, worldIn, playerIn);
			itemStackIn.damageItem(1, playerIn);
			playerIn.inventory.consumeInventoryItem(ammo);
			if(!worldIn.isRemote) worldIn.spawnEntityInWorld(projectile);
		}
		return itemStackIn;
	}
	
	@Override
	public void addInformation(ItemStack i, EntityPlayer p, List l) {
		l.add("Ammo: " + StatCollector.translateToLocal(ammo.getUnlocalizedName() + ".name"));
		l.add("Damage: " + (int)damage);
		l.add(i.getMaxDamage() - i.getItemDamage() + SlayerAPI.Colour.DARK_GREEN + " Uses remaining");
	}
}*/

package net.journey.items;

import java.util.List;

import net.journey.JourneyTabs;
import net.journey.client.server.DarkEnergyBar;
import net.journey.entity.projectile.EntityChaosProjectile;
import net.journey.entity.projectile.EntityOceanPlasma;
import net.journey.enums.EnumSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemGun extends ItemMod {
    private Item ammo;
    private Class<? extends Entity> projectileClass;
    private float damage;
    private EnumSounds sound;

    public ItemGun(String name, String f, Item ammo, float damage, int uses, EnumSounds sound) {
        super(name, f, JourneyTabs.staves);
		setMaxStackSize(1);
		setMaxDamage(uses);
		setFull3D();
        this.ammo = ammo;
        this.damage = damage;
        this.sound = sound;
    }

    public ItemGun(String name, String f, Item ammo, float damage) {
        super(name, f, JourneyTabs.staves);
		setMaxStackSize(1);
		setMaxDamage(500);
		setFull3D();
        this.ammo = ammo;
        this.damage = damage;
    }

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote) {
			if(DarkEnergyBar.getProperties(player).useBar(1)) {
				world.spawnEntityInWorld(new EntityOceanPlasma(world, player));
				EnumSounds.playSound(EnumSounds.CANNON, world, player);
				stack.damageItem(1, player);
			}
		}
		return stack;
	}
		/*if(playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(ammo)) {
            Entity projectile = null;

            try {
                projectile = (Entity)this.projectileClass.getConstructor(new Class[]{World.class, EntityLivingBase.class}).newInstance(new Object[]{worldIn, playerIn});
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            EnumSounds.playSound(this.sound, worldIn, playerIn);
			itemStackIn.damageItem(1, playerIn);
			playerIn.inventory.consumeInventoryItem(ammo);
			if(!worldIn.isRemote) worldIn.spawnEntityInWorld(projectile);
		}
		return itemStackIn;
	}
	*/

    public void addInformation(ItemStack i, EntityPlayer p, List l) {
		l.add("Ammo: " + StatCollector.translateToLocal(ammo.getUnlocalizedName() + ".name"));
        l.add("Damage: " + (int)this.damage);
		l.add(i.getMaxDamage() - i.getItemDamage() + SlayerAPI.Colour.DARK_GREEN + " Uses remaining");
    }
}