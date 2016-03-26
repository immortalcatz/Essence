package net.journey.client.render.particles;

import net.journey.JITL;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;

public class EntitySummoningFX extends EntityFX{

	public static final ResourceLocation texture = new ResourceLocation(SlayerAPI.MOD_ID, "textures/particle/summoning.png");
	
	public EntitySummoningFX(World w, double x, double y, double z, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(w, x, y, z);
		setMaxAge(20);
		setGravity(-0.01);
        this.motionX = var8;
        this.motionY = var10;
        this.motionZ = var12;
        this.prevPosY = this.posX = var2;
        this.prevPosY = this.posY = var4;
        this.prevPosZ = this.posZ = var6;
        float var14 = this.rand.nextFloat() * 0.6F + 0.4F;
        this.particleMaxAge = (int)(Math.random() * 10.0D) + 40;
        this.noClip = true;
	}
	
	@Override
	public void func_180434_a(WorldRenderer wr, Entity e, float partialTicks, float f3, float f4, float f5, float f6, float f7) {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glDepthMask(false);
		GL11.glEnable(GL_BLEND);		
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glAlphaFunc(GL_GREATER, 0.003921569F);		
		wr.startDrawingQuads();
        wr.setBrightness(getBrightnessForRender(partialTicks));        
        super.func_180434_a(wr, e, partialTicks, f3, f7, f5, f6, f7);
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        float scale = 0.1F*particleScale;
        float x = (float)(prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
        float y = (float)(prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
        float z = (float)(prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
        wr.addVertexWithUV (
        		x - f3 * scale - f6 * scale, 
        		y - f4 * scale - f5 * scale,
        		z - f5 * scale - f7 * scale, 0, 0);
        wr.addVertexWithUV (
        		x - f3 * scale + f6 * scale, 
        		y - f4 * scale - f5 * scale,
        		z - f5 * scale + f7 * scale, 1, 0);
        wr.addVertexWithUV (
        		x + f3 * scale + f6 * scale, 
        		y + f4 * scale - f5 * scale,
        		z + f5 * scale + f7 * scale, 1, 1);
        wr.addVertexWithUV (
        		x + f3 * scale - f6 * scale, 
        		y - f4 * scale - f5 * scale,
        		z + f5 * scale - f7 * scale, 0, 1);
        Tessellator.getInstance().draw();
        glDisable(GL_BLEND);
        glDepthMask(true);
        glAlphaFunc(GL_GREATER, 0.1F);
	}
	
	public int getFXLayer(){
		return 3;
		
	}
	
	public EntitySummoningFX setMaxAge(int maxAge){
		particleMaxAge = maxAge;
		return this;
	}
	
	public EntitySummoningFX setGravity(double d) {
		particleGravity = (float) d;
		return this;
	}
	
	public EntitySummoningFX setScale(float scale) {
		particleScale = scale;
		return this;		
	}
}