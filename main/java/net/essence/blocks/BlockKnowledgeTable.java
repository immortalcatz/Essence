package net.essence.blocks;

import net.essence.Essence;
import net.essence.EssenceTabs;
import net.essence.blocks.tileentity.TileEntityKnowledgeTable;
import net.essence.client.GuiHandler.GuiIDs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.entity.tileentity.container.BlockModContainer;

public class BlockKnowledgeTable extends BlockModContainer {

	public BlockKnowledgeTable(String name) {
		super(EnumMaterialTypes.STONE, name, 2.0F, EssenceTabs.blocks);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityKnowledgeTable tile = (TileEntityKnowledgeTable)worldIn.getTileEntity(pos);
		if(!worldIn.isRemote) {
			if(tile != null) { 
				playerIn.openGui(Essence.instance, GuiIDs.KNOWLEDGE.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			return true;
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityKnowledgeTable();
	}

	@Override
	public int getRenderType() {
		return 3;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}