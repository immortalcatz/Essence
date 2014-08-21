package net.essence.items;

import java.util.List;

import net.essence.util.EssenceToolMaterial;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemModSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFreezeSword extends ItemModSword {

	public ItemFreezeSword(String name, EssenceToolMaterial toolMaterial) {
		super(name, toolMaterial);
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase hit, EntityLivingBase player) {
		hit.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 5));
		for(int i = 0; i < 700; i++)
			Minecraft.getMinecraft().thePlayer.worldObj.spawnParticle("snowballpoof", hit.posX, hit.posY + 0.5F, hit.posZ, 0.0D, 0.0D, 0.0D);
		hit.setFire(0);
		return super.hitEntity(par1ItemStack, hit, player);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
		infoList.add(SlayerAPI.Colour.DARK_AQUA + "On hit: Freezes the target for 6 seconds");
		if(item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
		else infoList.add(SlayerAPI.Colour.GREEN + "Infinite Uses");
		infoList.add(SlayerAPI.Colour.DARK_AQUA + SlayerAPI.MOD_NAME);
	}
}