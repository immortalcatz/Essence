package net.essence.dimension.boil;

import net.essence.dimension.DimensionHelper;
import net.essence.util.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
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
	public boolean canBlockFreeze(int x, int y, int z, boolean byWater) {
		return false;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override
	public boolean canSnowAt(int x, int y, int z, boolean checkLight) {
		return false;
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
	protected void generateLightBrightnessTable() {
		float f = 1.2F;

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