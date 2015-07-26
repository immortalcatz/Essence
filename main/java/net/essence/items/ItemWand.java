package net.essence.items;

import java.util.List;

import net.essence.EssenceItems;
import net.essence.client.server.DarkEnergyBar;
import net.essence.client.server.EssenceBar;
import net.essence.entity.projectile.EntityBasicProjectile;
import net.essence.entity.projectile.EntityChaosProjectile;
import net.essence.enums.EnumSounds;
import net.essence.util.LangHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;

public class ItemWand extends ItemStaff {

	public ItemWand(String name, String f, boolean essence, int magic, int uses, int dam, boolean unbreakable, Class<? extends EntityBasicProjectile> projectile) {
		super(name, f, essence, magic, uses, dam, unbreakable, projectile);
	}
}