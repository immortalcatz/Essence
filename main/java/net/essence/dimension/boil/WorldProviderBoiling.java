package net.essence.dimension.boil;

import net.essence.dimension.DimensionHelper;
import net.essence.util.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderBoiling extends WorldProvider {

    @Override
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(DimensionHelper.boiling, 0.5F);
        this.dimensionId = Config.boil;
        isHellWorld = false;
    }
    
    @Override
    public String getSaveFolder() {
    	return "Boiling Point";
    }

    @Override
    public float getCloudHeight() {
        return 128.0F;
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderBoiling(this.worldObj, this.worldObj.getSeed());
    }
    
    @Override
    public Vec3 getFogColor(float par1, float par2) {
        float f2 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F - 0.5F;

        if (f2 < 0.0F) {
            f2 = 0.0F;
        }

        if (f2 > 1.0F) {
            f2 = 1.0F;
        }

        float f3 = 0.0F;
        float f4 = 0.05F;
        float f5 = 0.0F;
        f3 *= f2 * 3.0F + 0.01F;
        f4 *= f2 * 4.2F + 0.01F;
        f5 *= f2 * 3.0F + 0.01F;
        return Vec3.createVectorHelper((double)f3, (double)f4, (double)f5);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z) {
        return true;
    }
    
    @Override
    protected void generateLightBrightnessTable() {
        float f = 0.9F;

        for (int i = 0; i <= 15; ++i) {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public float calculateCelestialAngle(long var1, float var3) {
        return 0.18F; 
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public String getDimensionName() {
        return "Boiling Point";
    }
}