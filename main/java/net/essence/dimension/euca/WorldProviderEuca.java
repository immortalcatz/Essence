package net.essence.dimension.euca;

import net.essence.dimension.DimensionHelper;
import net.essence.util.Config;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderEuca extends WorldProvider {

    @Override
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(DimensionHelper.euca, 0.5F);
        this.dimensionId = Config.euca;
        isHellWorld = false;
    }
    
    @Override
    public String getSaveFolder() {
    	return "Euca";
    }

    @Override
    public float getCloudHeight() {
        return 128.0F;
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderEuca(worldObj, worldObj.getSeed(), worldObj.getWorldInfo().getGeneratorOptions());
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public float calculateCelestialAngle(long var1, float var3) {
        return 0.1F;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public String getDimensionName() {
        return "Euca";
    }

	@Override
	public String getInternalNameSuffix() {
		return "Euca";
	}
}