package net.essence.client.render;

import net.essence.util.EssenceBossStatus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.entity.EntityEssenceBoss;

public class RenderBoss extends RenderSizeable {

	private int bossID;
	
	public RenderBoss(ModelBase model, float shadow, float size, ResourceLocation tex, final int bossID) {
		super(model, shadow, size, tex);
		this.bossID = bossID;
	}

	@Override
	public void doRender(EntityLiving par1Entity, double par2, double par4, double par6, float par8, float par9) {
		EssenceBossStatus.setStatus((EntityEssenceBoss)par1Entity, bossID);
        super.doRender((EntityEssenceBoss)par1Entity, par2, par4, par6, par8, par9);
	}
}