package net.journey.dimension.corba;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderCorba extends BiomeGenBase implements IChunkProvider
{
    protected boolean field_150628_aC;
    private static final String __OBFID = "CL_00000180";

    public ChunkProviderCorba(int p_i1986_1_)
    {
        super(p_i1986_1_);
        this.setTemperatureRainfall(0.8F, 0.4F);
        this.setHeight(height_LowPlains);
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityHorse.class, 5, 2, 6));
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 10;
    }

    public BlockFlower.EnumFlowerType pickRandomFlower(Random p_180623_1_, BlockPos p_180623_2_)
    {
        double d0 = field_180281_af.func_151601_a((double)p_180623_2_.getX() / 200.0D, (double)p_180623_2_.getZ() / 200.0D);
        int i;

        if (d0 < -0.8D)
        {
            i = p_180623_1_.nextInt(4);

            switch (i)
            {
                case 0:
                    return BlockFlower.EnumFlowerType.ORANGE_TULIP;
                case 1:
                    return BlockFlower.EnumFlowerType.RED_TULIP;
                case 2:
                    return BlockFlower.EnumFlowerType.PINK_TULIP;
                case 3:
                default:
                    return BlockFlower.EnumFlowerType.WHITE_TULIP;
            }
        }
        else if (p_180623_1_.nextInt(3) > 0)
        {
            i = p_180623_1_.nextInt(3);
            return i == 0 ? BlockFlower.EnumFlowerType.POPPY : (i == 1 ? BlockFlower.EnumFlowerType.HOUSTONIA : BlockFlower.EnumFlowerType.OXEYE_DAISY);
        }
        else
        {
            return BlockFlower.EnumFlowerType.DANDELION;
        }
    }

    public void decorate(World worldIn, Random p_180624_2_, BlockPos p_180624_3_)
    {
        double d0 = field_180281_af.func_151601_a((double)(p_180624_3_.getX() + 8) / 200.0D, (double)(p_180624_3_.getZ() + 8) / 200.0D);
        int i;
        int j;
        int k;
        int l;

        if (d0 < -0.8D)
        {
            this.theBiomeDecorator.flowersPerChunk = 15;
            this.theBiomeDecorator.grassPerChunk = 5;
        }
        else
        {
            this.theBiomeDecorator.flowersPerChunk = 4;
            this.theBiomeDecorator.grassPerChunk = 10;
            DOUBLE_PLANT_GENERATOR.func_180710_a(BlockDoublePlant.EnumPlantType.GRASS);

            for (i = 0; i < 7; ++i)
            {
                j = p_180624_2_.nextInt(16) + 8;
                k = p_180624_2_.nextInt(16) + 8;
                l = p_180624_2_.nextInt(worldIn.getHorizon(p_180624_3_.add(j, 0, k)).getY() + 32);
                DOUBLE_PLANT_GENERATOR.generate(worldIn, p_180624_2_, p_180624_3_.add(j, l, k));
            }
        }

        if (this.field_150628_aC)
        {
            DOUBLE_PLANT_GENERATOR.func_180710_a(BlockDoublePlant.EnumPlantType.SUNFLOWER);

            for (i = 0; i < 10; ++i)
            {
                j = p_180624_2_.nextInt(16) + 8;
                k = p_180624_2_.nextInt(16) + 8;
                l = p_180624_2_.nextInt(worldIn.getHorizon(p_180624_3_.add(j, 0, k)).getY() + 32);
                DOUBLE_PLANT_GENERATOR.generate(worldIn, p_180624_2_, p_180624_3_.add(j, l, k));
            }
        }

        super.decorate(worldIn, p_180624_2_, p_180624_3_);
    }

    public BiomeGenBase createMutatedBiome(int p_180277_1_)
    {
        ChunkProviderCorba biomegenplains = new ChunkProviderCorba(p_180277_1_);
        biomegenplains.setBiomeName("Sunflower Plains");
        biomegenplains.field_150628_aC = true;
        biomegenplains.setColor(9286496);
        biomegenplains.field_150609_ah = 14273354;
        return biomegenplains;
    }

    @Override
    public void addDefaultFlowers()
    {
        BlockFlower red = net.minecraft.init.Blocks.red_flower;
        BlockFlower yel = net.minecraft.init.Blocks.yellow_flower;
        addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.ORANGE_TULIP), 3);
        addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.RED_TULIP), 3);
        addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.PINK_TULIP), 3);
        addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.WHITE_TULIP), 3);
        addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.POPPY), 20);
        addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.HOUSTONIA), 20);
        addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.OXEYE_DAISY), 20);
        addFlower(yel.getDefaultState().withProperty(yel.getTypeProperty(), BlockFlower.EnumFlowerType.DANDELION), 30);
    }

	@Override
	public boolean chunkExists(int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Chunk provideChunk(int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chunk provideChunk(BlockPos blockPosIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void populate(IChunkProvider p_73153_1_, int p_73153_2_,
			int p_73153_3_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_,
			int p_177460_3_, int p_177460_4_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadQueuedChunks() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String makeString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List func_177458_a(EnumCreatureType p_177458_1_, BlockPos p_177458_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String p_180513_2_,
			BlockPos p_180513_3_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recreateStructures(Chunk p_180514_1_, int p_180514_2_,
			int p_180514_3_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveExtraData() {
		// TODO Auto-generated method stub
		
	}
}