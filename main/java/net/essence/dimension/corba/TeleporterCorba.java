package net.essence.dimension.corba;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.essence.EssenceBlocks;
import net.essence.util.Config;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.slayer.api.worldgen.WorldGenAPI;

public class TeleporterCorba extends Teleporter {

	protected final WorldServer worldServerInstance;
	protected final Random random;
	protected final LongHashMap destinationCoordinateCache = new LongHashMap();
	protected final List destinationCoordinateKeys = new ArrayList();
	protected int dimensionID;
	protected Block portal, frameBlock;

	public TeleporterCorba(WorldServer worldServer, int dimensionID, Block portal, Block frameBlock) {
		super(worldServer);
		this.worldServerInstance = worldServer;
		this.dimensionID = dimensionID;
		this.portal = portal;
		this.frameBlock = frameBlock;
		this.random = new Random(worldServer.getSeed());
	}

	@Override
	public void placeInPortal(Entity entity, float par8) {
		int x = MathHelper.floor_double(entity.posX);
		int y = MathHelper.floor_double(entity.posY) - 1;
		int z = MathHelper.floor_double(entity.posZ);
		WorldGenAPI.addRectangle(6, 6, 6, worldServerInstance, x, y + 1, z, Blocks.air);
		WorldGenAPI.addCornerlessRectangle(5, 5, 1, worldServerInstance, x + 1, y + 1, z + 1, EssenceBlocks.corbaPortalFrame);
		WorldGenAPI.addRectangle(3, 3, 1, worldServerInstance, x + 2, y + 1, z + 2, EssenceBlocks.corbaPortal);
		entity.setLocationAndAngles((double)x, (double)y + 5, (double)z, entity.rotationYaw, 0.0F);
		entity.motionX = entity.motionY = entity.motionZ = 0.0D;
	}

	@Override
	public boolean placeInExistingPortal(Entity player, float rot) {
		return true;
	}

	@Override
	public boolean makePortal(Entity entity) {
		return true;
	}
}