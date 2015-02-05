package net.essence.items;

import java.util.List;
import java.util.Random;

import net.essence.EssenceTabs;
import net.essence.client.DarkEnergyBar;
import net.essence.client.EssenceBar;
import net.minecraft.client.particle.EntityCritFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.slayer.api.SlayerAPI;
import net.slayer.api.item.ItemMod;

public class ItemAttractor extends ItemMod {

	private boolean attracts, essence;
	private int magic;

	public ItemAttractor(String name, boolean attracts, boolean essence, int magic) {
		super(name, EssenceTabs.weapons);
		setMaxStackSize(1);
		this.attracts = attracts;
		this.magic = magic;
		this.essence = essence;
	}

	@Override 
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase hit) {
		Random r = new Random();
		if(essence ? EssenceBar.instance.useBar(magic, player.worldObj) : DarkEnergyBar.instance.useBar(magic, player.worldObj)){
			if(!attracts){
				hit.motionY = 1.0F;
				hit.motionX = (hit.posX - player.posX) * 1.0F;
				hit.motionZ = (hit.posZ - player.posZ) * 1.0F;
				//for(int i = 0; i < 50; i++)
				//	FMLClientHandler.instance().getClient().effectRenderer.addEffect(new EntityCritFX(player.worldObj, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, 0.0D, 0.0D, 0.0D));
			} else {
				hit.motionY = 1.0F;
				hit.motionX = (hit.posX + player.posX) * 1.0F;
				hit.motionZ = (hit.posZ + player.posZ) * 1.0F;
				//for(int i = 0; i < 50; i++)
				//	FMLClientHandler.instance().getClient().effectRenderer.addEffect(new EntityCritFX(player.worldObj, hit.posX + r.nextFloat() - 0.5F, hit.posY + 0.5D + r.nextFloat(), hit.posZ + r.nextFloat() - 0.5F, 0.0D, 0.0D, 0.0D));
			}
		}
		return false;
	}

	@Override
	public void addInformation(ItemStack i, EntityPlayer p, List l) {
		String essence = "";
		if(this.essence) essence = " Essence ";
		else essence = " Dark Energy ";
		l.add(SlayerAPI.Colour.AQUA + "Uses " + magic + essence);
		l.add(this.attracts ? SlayerAPI.Colour.AQUA + "Attracts a mob towards you" : SlayerAPI.Colour.AQUA + "Fires a mob away from you");
	}
}