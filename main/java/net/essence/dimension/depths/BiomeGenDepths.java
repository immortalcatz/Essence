package net.essence.dimension.depths;

import net.essence.EssenceBlocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDepths extends BiomeGenBase {

	public BiomeGenDepths(int par1) {
		super(par1);
		this.setBiomeName("The Depths");
		this.topBlock = EssenceBlocks.depthsGrass.getDefaultState();
		this.fillerBlock = EssenceBlocks.depthsDirt.getDefaultState();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
	}
}