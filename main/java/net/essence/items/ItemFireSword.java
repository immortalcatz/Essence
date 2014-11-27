package net.essence.items;

import java.util.List;
import java.util.Random;

import net.essence.Essence;
import net.essence.client.render.EnumParticlesClasses;
import net.essence.proxy.ClientProxy;
import net.essence.util.Config;
import net.essence.util.EssenceToolMaterial;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemModSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFireSword extends ItemModSword {

	public ItemFireSword(String name, EssenceToolMaterial toolMaterial) {
		super(name, toolMaterial);
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase hit, EntityLivingBase player) {
		hit.setFire(10);
		return super.hitEntity(par1ItemStack, hit, player);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
		infoList.add(SlayerAPI.Colour.DARK_RED + "On hit: Burns for 10 seconds");
		if(item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
		else infoList.add(SlayerAPI.Colour.GREEN + "Infinite Uses");
		infoList.add(SlayerAPI.Colour.DARK_AQUA + SlayerAPI.MOD_NAME);
	}
}