package net.essence.client.render.mob.model;

import java.util.ArrayList;

import net.essence.util.LogHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public abstract class ModelStatue extends ModelBase {

	protected ArrayList<ModelRenderer> parts;

	public ModelStatue() {
		this.parts = new ArrayList<ModelRenderer>();
	}

	public void render(float rotation) {
		if(parts == null || parts.isEmpty()) {
			LogHelper.debug("Nothing to rotate in type: " + getClass().getName());
			return;
		}
		for(ModelRenderer model : parts)
			model.render(rotation);
	}

	public void addPart(ModelRenderer model) {
		parts.add(model);
	}

	protected void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}