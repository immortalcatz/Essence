package net.essence.dimension.corba;

import net.essence.EssenceBlocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeGenCorba extends BiomeGenBase {

	public BiomeGenCorba(int par1) {
		super(par1);
		this.setBiomeName("Corba");
		this.topBlock = EssenceBlocks.corbaGrass.getDefaultState();
		this.fillerBlock = EssenceBlocks.corbaStone.getDefaultState();
		this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float p_76731_1_) {
        return 0;
    }
}