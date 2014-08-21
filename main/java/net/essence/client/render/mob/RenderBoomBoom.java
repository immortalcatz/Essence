package net.essence.client.render.mob;

import net.essence.client.render.RenderModMob;
import net.essence.client.render.mob.model.ModelBoomBoom;
import net.essence.entity.mob.vanilla.EntityBoom;
import net.essence.util.Textures;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
        if(f1 < 0.0F) f1 = 0.0F;
        if(f1 > 1.0F) f1 = 1.0F;      
        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0F + f1 * 0.4F) * f2;
        float f4 = (1.0F + f1 * 0.1F) / f2;
        GL11.glScalef(f3, f4, f3);
    }

    protected int getColorMultiplier(EntityBoom par1EntityBoom, float par2, float par3) {
        float f2 = par1EntityBoom.getFlashIntensity(par3);

        if((int)(f2 * 10.0F) % 2 == 0) {
            return 0;
        } else {
            int i = (int)(f2 * 0.2F * 255.0F);
            if(i < 0) i = 0;
            if(i > 255) i = 255;
            short short1 = 255;
            short short2 = 255;
            short short3 = 255;
            return i << 24 | short1 << 16 | short2 << 8 | short3;
        }
    }

    protected int shouldRenderPass(EntityBoom par1EntityBoom, int par2, float par3) {
        if(par1EntityBoom.getPowered()) {
            if (par1EntityBoom.isInvisible()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            if(par2 == 1) {
                float f1 = (float)par1EntityBoom.ticksExisted + par3;
                this.bindTexture(armoredBoomTextures);
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                float f2 = f1 * 0.01F;
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(f2, f3, 0.0F);
                this.setRenderPassModel(this.boomModel);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_BLEND);
                float f4 = 0.5F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
                return 1;
            }

            if(par2 == 2) {
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
            }
        }
        return -1;
    }

    protected int inheritRenderPass(EntityBoom par1EntityBoom, int par2, float par3) {
        return -1;
    }

    protected ResourceLocation getEntityTexture(EntityBoom par1EntityBoom) {
        return boomTextures;
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
    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {
        return this.shouldRenderPass((EntityBoom)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected int inheritRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {
        return this.inheritRenderPass((EntityBoom)par1EntityLivingBase, par2, par3);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.getEntityTexture((EntityBoom)par1Entity);
    }
}