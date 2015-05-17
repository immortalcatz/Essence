package net.essence.items;

import java.util.List;

import net.essence.EssenceTabs;
import net.essence.client.server.EssenceBar;
import net.essence.entity.projectile.EntityChaosProjectile;
import net.essence.enums.EnumSounds;
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
	
	public ItemGun(String name, Item ammo, float damage, int uses, EnumSounds sound, Class<? extends Entity> projectile) {
		super(name, EssenceTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(uses);
		setFull3D();
		this.ammo = ammo;
		this.damage = damage;
		this.sound = sound;
		this.projectileClass = projectile;
	}
	
	public ItemGun(String name, Item ammo, float damage, Class<? extends Entity> projectile) {
		super(name, EssenceTabs.ranged);
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
			EnumSounds.playSound(sound, worldIn, playerIn);
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
}