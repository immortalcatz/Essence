package net.essence.items;

import java.util.List;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.essence.util.EssenceToolMaterial;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemModSword;

public class ItemFireSword extends ItemModSword {

	public ItemFireSword(String name, EssenceToolMaterial toolMaterial) {
		super(name, toolMaterial);
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase hit, EntityLivingBase player) {
		hit.setFire(10);
		for(int i = 0; i < 40; i++){
			Minecraft.getMinecraft().thePlayer.worldObj.spawnParticle("lava", hit.posX, hit.posY + 0.5F, hit.posZ, 0.0D, 0.0D, 0.0D);
			Minecraft.getMinecraft().thePlayer.worldObj.spawnParticle("flame", hit.posX, hit.posY + 0.5F, hit.posZ, 0.0D, 0.0D, 0.0D);
		}
		
		/*
		 Random random = new Random();
		World w = player.worldObj;
		double x = hit.posX, y = hit.posY, z = hit.posZ;
		double d1 = (double)((float)x + random.nextFloat());
		double d2 = (double)((float)y + random.nextFloat());
		double d3 = (double)((float)z + random.nextFloat());
		hit.setFire(10);
		for(int i = 0; i < 40; i++){
			EntityLavaFX fx = new EntityLavaFX(w, d1, d2, d3);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
			EntityFlameFX fx1 = new EntityFlameFX(w, d1, d2, d3, random.nextFloat() - 0.5F, random.nextFloat() - 0.5F, random.nextFloat() - 0.5F);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx1);
		}
		 */
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