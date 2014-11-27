package net.essence.blocks;

import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.EssenceTabs;
import net.essence.client.render.particles.EntityBoilPotalFX;
import net.essence.dimension.ModTeleporter;
import net.essence.util.Config;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.slayer.api.SlayerAPI;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBoilPortal extends BlockBreakable {

	public static final int[][] sides = new int[][] {new int[0], {3, 1}, {2, 0}};

	public BlockBoilPortal(String name) {
		super(SlayerAPI.PREFIX + "boilPortal", Material.portal, false);
		this.setTickRandomly(true);
		setCreativeTab(EssenceTabs.blocks);
		setBlockName(name);
		setBlockUnbreakable();
		GameRegistry.registerBlock(this, name);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
		return null;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess w, int x, int y, int z) {
		int l = getMeta(w.getBlockMetadata(x, y, z));
		if(l == 0) {
			if(w.getBlock(x - 1, y, z) != this && w.getBlock(x + 1, y, z) != this) {
				l = 2;
			} else {
				l = 1;
			}
			if(w instanceof World && !((World)w).isRemote) {
				((World)w).setBlockMetadataWithNotify(x, y, z, l, 2);
			}
		}
		float f = 0.125F;
		float f1 = 0.125F;
		if(l == 1) f = 0.5F;
		if(l == 2) f1 = 0.5F;

		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean makePortal(World w, int x, int y, int z) {
		BlockBoilPortal.Size size = new BlockBoilPortal.Size(w, x, y, z, 1);
		BlockBoilPortal.Size size1 = new BlockBoilPortal.Size(w, x, y, z, 2);
		if(size.checkSides() && size.value == 0) {
			size.checkDirection();
			return true;
		}
		else if(size1.checkSides() && size1.value == 0) {
			size1.checkDirection();
			return true;
		} else {
			return false;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess w, int x, int y, int z, int i) {
		int i1 = 0;
		if(w.getBlock(x, y, z) == this) {
			i1 = getMeta(w.getBlockMetadata(x, y, z));
			if(i1 == 0) return false;
			if(i1 == 2 && i != 5 && i != 4) return false;
			if(i1 == 1 && i != 3 && i != 2) return false;
		}
		boolean flag = w.getBlock(x - 1, y, z) == this && w.getBlock(x - 2, y, z) != this;
		boolean flag1 = w.getBlock(x + 1, y, z) == this && w.getBlock(x + 2, y, z) != this;
		boolean flag2 = w.getBlock(x, y, z - 1) == this && w.getBlock(x, y, z - 2) != this;
		boolean flag3 = w.getBlock(x, y, z + 1) == this && w.getBlock(x, y, z + 2) != this;
		boolean flag4 = flag || flag1 || i1 == 1;
		boolean flag5 = flag2 || flag3 || i1 == 2;
		return flag4 && i == 4 ? true : (flag4 && i == 5 ? true : (flag5 && i == 2 ? true : flag5 && i == 3));
	}

	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 0;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int xPos, int yPos, int zPos, Entity entity) {
		if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && ((entity instanceof EntityPlayerMP))) {
			EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
			int dimensionID = Config.boil;
			Block blockFrame = EssenceBlocks.boilPortalFrame;
			if(thePlayer.timeUntilPortal > 0) 
				thePlayer.timeUntilPortal = 10;
			else if(thePlayer.dimension != dimensionID) {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, dimensionID, new ModTeleporter(thePlayer.mcServer.worldServerForDimension(dimensionID), dimensionID, this, blockFrame));

			} else {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new ModTeleporter(thePlayer.mcServer.worldServerForDimension(0), 0, this, blockFrame));
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int xPos, int yPos, int zPos, Random rand) {
        for (int l = 0; l < 5; ++l) {
            double d0 = (double) ((float) xPos + rand.nextFloat());
            double d1 = (double) ((float) yPos + rand.nextFloat());
            double d2 = (double) ((float) zPos + rand.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = rand.nextInt(2) * 2 - 1;
            d3 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;

            if (world.getBlock(xPos - 1, yPos, zPos) != this && world.getBlock(xPos + 1, yPos, zPos) != this) {
                d0 = (double) xPos + 0.5D + 0.25D * (double) i1;
                d3 = (double) (rand.nextFloat() * 2.0F * (float) i1);
            } else {
                d2 = (double) zPos + 0.5D + 0.25D * (double) i1;
                d5 = (double) (rand.nextFloat() * 2.0F * (float) i1);
            }
            EntityBoilPotalFX var20 = new EntityBoilPotalFX(world, d0, d1, d2, d3, d4, d5);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
        }
	}

	public static int getMeta(int m) {
		return m & 3;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World w, int x, int y, int z) {
		return Item.getItemFromBlock(this);
	}

	public static class Size {
		private final World w;
		private final int x;
		private final int y;
		private final int z;
		private int value = 0;
		private ChunkCoordinates coords;
		private int direc;
		private int sides;

		public Size(World w, int x, int y, int z, int i) {
			this.w = w;
			this.x = i;
			this.z = BlockBoilPortal.sides[i][0];
			this.y = BlockBoilPortal.sides[i][1];

			for(int i1 = y; y > i1 - 21 && y > 0 && this.getMat(w.getBlock(x, y - 1, z)); --y) {
				;
			}

			int j1 = this.setDirection(x, y, z, this.z) - 1;

			if(j1 >= 0) {
				this.coords = new ChunkCoordinates(x + j1 * Direction.offsetX[this.z], y, z + j1 * Direction.offsetZ[this.z]);
				this.sides = this.setDirection(this.coords.posX, this.coords.posY, this.coords.posZ, this.y);

				if(this.sides < 2 || this.sides > 21) {
					this.coords = null;
					this.sides = 0;
				}
			}

			if(this.coords != null) {
				this.direc = this.idk();
			}
		}

		protected int setDirection(int x, int y, int z, int dir) {
			int j1 = Direction.offsetX[dir];
			int k1 = Direction.offsetZ[dir];
			int i1;
			Block block;

			for(i1 = 0; i1 < 22; ++i1) {
				block = this.w.getBlock(x + j1 * i1, y, z + k1 * i1);

				if(!this.getMat(block)) {
					break;
				}

				Block block1 = this.w.getBlock(x + j1 * i1, y - 1, z + k1 * i1);

				if(block1 != EssenceBlocks.boilPortalFrame) {
					break;
				}
			}

			block = this.w.getBlock(x + j1 * i1, y, z + k1 * i1);
			return block == EssenceBlocks.boilPortalFrame ? i1 : 0;
		}

		protected int idk() {
			int i;
			int j;
			int k;
			int l;
			label56:

				for(this.direc = 0; this.direc < 21; ++this.direc) {
					i = this.coords.posY + this.direc;

					for(j = 0; j < this.sides; ++j) {
						k = this.coords.posX + j * Direction.offsetX[BlockBoilPortal.sides[this.x][1]];
						l = this.coords.posZ + j * Direction.offsetZ[BlockBoilPortal.sides[this.x][1]];
						Block block = this.w.getBlock(k, i, l);

						if(!this.getMat(block)) {
							break label56;
						}

						if(block == EssenceBlocks.boilPortal) {
							++this.value;
						}

						if(j == 0) {
							block = this.w.getBlock(k + Direction.offsetX[BlockBoilPortal.sides[this.x][0]], i, l + Direction.offsetZ[BlockBoilPortal.sides[this.x][0]]);

							if(block != EssenceBlocks.boilPortalFrame) {
								break label56;
							}
						}
						else if(j == this.sides - 1) {
							block = this.w.getBlock(k + Direction.offsetX[BlockBoilPortal.sides[this.x][1]], i, l + Direction.offsetZ[BlockBoilPortal.sides[this.x][1]]);

							if(block != EssenceBlocks.boilPortalFrame) {
								break label56;
							}
						}
					}
				}

			for(i = 0; i < this.sides; ++i) {
				j = this.coords.posX + i * Direction.offsetX[BlockBoilPortal.sides[this.x][1]];
				k = this.coords.posY + this.direc;
				l = this.coords.posZ + i * Direction.offsetZ[BlockBoilPortal.sides[this.x][1]];

				if(this.w.getBlock(j, k, l) != EssenceBlocks.boilPortalFrame) {
					this.direc = 0;
					break;
				}
			}

			if(this.direc <= 21 && this.direc >= 3) {
				return this.direc;
			} else {
				this.coords = null;
				this.sides = 0;
				this.direc = 0;
				return 0;
			}
		}

		protected boolean getMat(Block b){
			return b.getMaterial() == Material.air || b == EssenceBlocks.fire || b == EssenceBlocks.boilPortal;
		}

		public boolean checkSides() {
			return this.coords != null && this.sides >= 2 && this.sides <= 21 && this.direc >= 3 && this.direc <= 21;
		}

		public void checkDirection() {
			for(int i = 0; i < this.sides; ++i) {
				int j = this.coords.posX + Direction.offsetX[this.y] * i;
				int k = this.coords.posZ + Direction.offsetZ[this.y] * i;

				for(int l = 0; l < this.direc; ++l) {
					int i1 = this.coords.posY + l;
					this.w.setBlock(j, i1, k, EssenceBlocks.boilPortal, this.x, 2);
				}
			}
		}
	}
}