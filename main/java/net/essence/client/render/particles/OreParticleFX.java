package net.essence.client.render.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class OreParticleFX extends EntityFX {
    private float reddustParticleScale;

    public OreParticleFX(World w, double x, double y, double z, float r, float g, float b) {
        this(w, x, y, z, 1.0F, r, g, b);
    }

    public OreParticleFX(World w, double x, double y, double z, float scale, float r, float g, float b) {
        super(w, x, y, z, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;
        float f4 = (float)Math.random() * 0.4F + 0.6F;
        setRBGColorF(r, g, b);
        this.particleScale *= 0.75F;
        this.particleScale *= scale;
        this.reddustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
        this.noClip = false;
    }

    @Override
    public void renderParticle(Tessellator t, float x, float y, float z, float f, float f1, float f2) {
        float f6 = ((float)this.particleAge + x) / (float)this.particleMaxAge * 32.0F;
        if(f6 < 0.0F) f6 = 0.0F;
        if(f6 > 1.0F) f6 = 1.0F;
        this.particleScale = this.reddustParticleScale * f6;
        super.renderParticle(t, x, y, z, f, f1, f2);
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if(this.particleAge++ >= this.particleMaxAge)
            this.setDead();
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if(this.posY == this.prevPosY) {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }
        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;
        if(this.onGround) {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}