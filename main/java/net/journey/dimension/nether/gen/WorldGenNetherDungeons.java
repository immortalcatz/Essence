package net.journey.dimension.nether.gen;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.journey.JourneyBlocks;
import net.journey.JourneyItems;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;

public class WorldGenNetherDungeons extends WorldGenerator
{
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String[] SPAWNERTYPES = new String[] {"hellBot"};
    private static final String __OBFID = "CL_00000425";
    private static final List CHESTCONTENT = Lists.newArrayList(new WeightedRandomChestContent[] {new WeightedRandomChestContent
    		(JourneyItems.flamingHide, 0, 1, 1, 10), new WeightedRandomChestContent
    		(JourneyItems.hellstoneIngot, 0, 1, 4, 10), new WeightedRandomChestContent
    		(JourneyItems.blood, 0, 1, 1, 10), new WeightedRandomChestContent
    		(JourneyItems.snakeFlesh, 0, 1, 4, 10), new WeightedRandomChestContent
    		(JourneyItems.hellcrustIngot, 0, 1, 4, 10), new WeightedRandomChestContent
    		(JourneyItems.boilKey, 0, 1, 1, 1)});

    public boolean generate(World worldIn, Random p_180709_2_, BlockPos p_180709_3_)
    {
        boolean flag = true;
        int i = p_180709_2_.nextInt(2) + 2;
        int j = -i - 1;
        int k = i + 1;
        boolean flag1 = true;
        boolean flag2 = true;
        int l = p_180709_2_.nextInt(2) + 2;
        int i1 = -l - 1;
        int j1 = l + 1;
        int k1 = 0;
        int l1;
        int i2;
        int j2;
        BlockPos blockpos1;

        for (l1 = j; l1 <= k; ++l1)
        {
            for (i2 = -1; i2 <= 4; ++i2)
            {
                for (j2 = i1; j2 <= j1; ++j2)
                {
                    blockpos1 = p_180709_3_.add(l1, i2, j2);
                    Material material = worldIn.getBlockState(blockpos1).getBlock().getMaterial();
                    boolean flag3 = material.isSolid();

                    if (i2 == -1 && !flag3)
                    {
                        return false;
                    }

                    if (i2 == 4 && !flag3)
                    {
                        return false;
                    }

                    if ((l1 == j || l1 == k || j2 == i1 || j2 == j1) && i2 == 0 && worldIn.isAirBlock(blockpos1) && worldIn.isAirBlock(blockpos1.up()))
                    {
                        ++k1;
                    }
                }
            }
        }

        if (k1 >= 1 && k1 <= 5)
        {
            for (l1 = j; l1 <= k; ++l1)
            {
                for (i2 = 3; i2 >= -1; --i2)
                {
                    for (j2 = i1; j2 <= j1; ++j2)
                    {
                        blockpos1 = p_180709_3_.add(l1, i2, j2);

                        if (l1 != j && i2 != -1 && j2 != i1 && l1 != k && i2 != 4 && j2 != j1)
                        {
                            if (worldIn.getBlockState(blockpos1).getBlock() != JourneyBlocks.netherChest)
                            {
                                worldIn.setBlockToAir(blockpos1);
                            }
                        }
                        else if (blockpos1.getY() >= 0 && !worldIn.getBlockState(blockpos1.down()).getBlock().getMaterial().isSolid())
                        {
                            worldIn.setBlockToAir(blockpos1);
                        }
                        else if (worldIn.getBlockState(blockpos1).getBlock().getMaterial().isSolid() && worldIn.getBlockState(blockpos1).getBlock() != JourneyBlocks.netherChest)
                        {
                            if (i2 == -1 && p_180709_2_.nextInt(4) != 0)
                            {
                                worldIn.setBlockState(blockpos1, Blocks.nether_brick.getDefaultState(), 2);
                            }
                            else
                            {
                                worldIn.setBlockState(blockpos1, JourneyBlocks.largeNetherBrick.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }

            l1 = 0;

            while (l1 < 2)
            {
                i2 = 0;

                while (true)
                {
                    if (i2 < 3)
                    {
                        label197:
                        {
                            j2 = p_180709_3_.getX() + p_180709_2_.nextInt(i * 2 + 1) - i;
                            int l2 = p_180709_3_.getY();
                            int i3 = p_180709_3_.getZ() + p_180709_2_.nextInt(l * 2 + 1) - l;
                            BlockPos blockpos2 = new BlockPos(j2, l2, i3);

                            if (worldIn.isAirBlock(blockpos2))
                            {
                                int k2 = 0;
                                Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator();

                                while (iterator.hasNext())
                                {
                                    EnumFacing enumfacing = (EnumFacing)iterator.next();

                                    if (worldIn.getBlockState(blockpos2.offset(enumfacing)).getBlock().getMaterial().isSolid())
                                    {
                                        ++k2;
                                    }
                                }

                                if (k2 == 1)
                                {
                                    worldIn.setBlockState(blockpos2, JourneyBlocks.netherChest.getDefaultState(), 2);
                                    TileEntity tileentity1 = worldIn.getTileEntity(blockpos2);

                                    if (tileentity1 instanceof TileEntityChest)
                                    {
                                        WeightedRandomChestContent.generateChestContents(p_180709_2_, ChestGenHooks.getItems(DUNGEON_CHEST, p_180709_2_), (TileEntityChest)tileentity1, ChestGenHooks.getCount(DUNGEON_CHEST, p_180709_2_));
                                    }

                                    break label197;
                                }
                            }

                            ++i2;
                            continue;
                        }
                    }

                    ++l1;
                    break;
                }
            }

            worldIn.setBlockState(p_180709_3_, Blocks.mob_spawner.getDefaultState(), 2);
            TileEntity tileentity = worldIn.getTileEntity(p_180709_3_);

            if (tileentity instanceof TileEntityMobSpawner)
            {
                ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic().setEntityName(this.pickMobSpawner(p_180709_2_));
            }
            else
            {
                LOGGER.error("Failed to fetch mob spawner entity at (" + p_180709_3_.getX() + ", " + p_180709_3_.getY() + ", " + p_180709_3_.getZ() + ")");
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Randomly decides which spawner to use in a dungeon
     */
    private String pickMobSpawner(Random p_76543_1_)
    {
        return DungeonHooks.getRandomDungeonMob(p_76543_1_);
    }

    static
    {
        ChestGenHooks.init(DUNGEON_CHEST, CHESTCONTENT, 8, 8);
        ChestGenHooks.addItem(DUNGEON_CHEST, new WeightedRandomChestContent(new net.minecraft.item.ItemStack(Items.enchanted_book, 1, 0), 1, 1, 1));
    }
}