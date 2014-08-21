package net.essence.dimension.boil;

import net.essence.EssenceBlocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBoiling extends BiomeGenBase {

	public BiomeGenBoiling(int par1) {
		super(par1);
		this.setBiomeName("Boiling Point");
		this.topBlock = EssenceBlocks.hotBlock;
		this.fillerBlock = EssenceBlocks.hotBlock;
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        setColor(0xC40600);
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0xC40600;
	}
}