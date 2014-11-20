package net.essence.client.render.mob;

import net.essence.client.render.RenderModMob;
import net.essence.entity.mob.vanilla.EntityFish;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.slayer.api.SlayerAPI;

public class RenderFish extends RenderModMob {

	public RenderFish(ModelBase model) {
		super(model, 0.2F, null);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		String[] tex = {"fish_0", "fish_1", "fish_2", "fish_3"};
		String name = "";
		switch(var1.getDataWatcher().getWatchableObjectInt(EntityFish.ENTITY_TYPE)) {
		case 0:
			name = tex[0];
			break;
		case 1:
			name = tex[1];
			break;
		case 2:
			name = tex[2];
			break;
		case 3:
			name = tex[3];
			break;
		}
		return new ResourceLocation(SlayerAPI.PREFIX + "textures/models/mobs/" + name + ".png");
	}
}