package net.essence.client.render.mob;

import net.essence.entity.EntityDragonEgg;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

import org.lwjgl.opengl.GL11;

public class RenderDragonEgg extends RenderLiving {

	private ResourceLocation loc;

	public RenderDragonEgg(ModelBase model) {
		super(model, 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		EntityDragonEgg egg = (EntityDragonEgg)e;		
		return new ResourceLocation(SlayerAPI.PREFIX + "models/entity/dragonEgg_" + egg.getColour() + ".png");
	}
}