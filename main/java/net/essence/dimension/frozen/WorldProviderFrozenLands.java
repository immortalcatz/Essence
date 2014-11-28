package net.essence.dimension.frozen;

import net.essence.dimension.DimensionHelper;
import net.essence.util.Config;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderFrozenLands extends WorldProvider {

    @Override
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(DimensionHelper.frozen, 0.5F);
        this.dimensionId = Config.frozen;
        isHellWorld = false;
    }
    
    @Override
    public String getSaveFolder() {
    	return "Frozen Lands";
    }

    @Override
    public float getCloudHeight() {
        return 128.0F;
    }

    @Override
    public float calculateCelestialAngle(long var1, float var3) {
        return 0.4F; 
    }
    
    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderFrozenLands(this.worldObj, this.worldObj.getSeed());
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public String getDimensionName() {
        return "Frozen Lands";
    }

	@Override
	public String getInternalNameSuffix() {
		return "Frozen Lands";
	}
}