package net.essence.dimension.euca;

import net.essence.EssenceBlocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenEuca extends BiomeGenBase {

	public BiomeGenEuca(int par1) {
		super(par1);
		this.setBiomeName("Euca");
		this.topBlock = EssenceBlocks.eucaGrass.getDefaultState();
		this.fillerBlock = EssenceBlocks.eucaDirt.getDefaultState();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
	}
}