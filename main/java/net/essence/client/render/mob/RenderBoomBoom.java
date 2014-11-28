package net.essence.client.render.mob;

import net.essence.client.render.RenderModMob;
import net.essence.client.render.mob.model.vanilla.ModelBoomBoom;
import net.essence.entity.mob.vanilla.EntityBoom;
import net.essence.util.Textures;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBoomBoom extends RenderModMob {
	
    public RenderBoomBoom(ModelBase model, ResourceLocation tex) {
		super(model, tex);
	}

	private final ResourceLocation armoredBoomTextures = Textures.boomArmor;
    private final ResourceLocation boomTextures = Textures.boom;
    private final ModelBoomBoom boomModel = new ModelBoomBoom();
    
    protected void preRenderCallback(EntityBoom par1EntityBoom, float par2) {
    	float f1 = par1EntityBoom.getFlashIntensity(par2);
        float f2 = 1.0F + MathHelper.sin(f1 * 100.0F) * f1 * 0.01F;
        f1 = MathHelper.clamp_float(f1, 0.0F, 1.0F);
        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0F + f1 * 0.4F) * f2;
        float f4 = (1.0F + f1 * 0.1F) / f2;
        GlStateManager.scale(f3, f4, f3);
    }

    protected int getColorMultiplier(EntityBoom par1EntityBoom, float par2, float par3) {
        float f2 = par1EntityBoom.getFlashIntensity(par3);

        if ((int)(f2 * 10.0F) % 2 == 0) {
            return 0;
        } else {
            int i = (int)(f2 * 0.2F * 255.0F);
            i = MathHelper.clamp_int(i, 0, 255);
            return i << 24 | 16777215;
        }
    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        this.preRenderCallback((EntityBoom)par1EntityLivingBase, par2);
    }

    @Override
    protected int getColorMultiplier(EntityLivingBase par1EntityLivingBase, float par2, float par3) {
        return this.getColorMultiplier((EntityBoom)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.getEntityTexture((EntityBoom)par1Entity);
    }
}