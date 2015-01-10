package net.essence.blocks;

import net.essence.EssenceBlocks;
import net.essence.blocks.tileentity.container.ContainerBowCrafter;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.slayer.api.EnumMaterialTypes;
import net.slayer.api.SlayerAPI;
import net.slayer.api.block.BlockMod;

public class BlockBowCrafter extends BlockMod {

	private static final String __OBFID = "CL_00000221";

	public BlockBowCrafter(String name) {
		super(EnumMaterialTypes.WOOD, name, 0.5F);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			playerIn.displayGui(new BlockBowCrafter.InterfaceCraftingTable(worldIn, pos));
			return true;
		}
		return false;
	}

	public static class InterfaceCraftingTable implements IInteractionObject {
		private final World world;
		private final BlockPos position;

		public InterfaceCraftingTable(World worldIn, BlockPos pos) {
			this.world = worldIn;
			this.position = pos;
		}

		@Override
		public String getName() {
			return "bowCrafter";
		}

		@Override
		public boolean hasCustomName() {
			return true;
		}

		/*@Override
		public IChatComponent getDisplayName() {
			return new ChatComponentTranslation(EssenceBlocks.bowCraftingTable.getUnlocalizedName() + ".name", new Object[0]);
		}*/

		@Override
		public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
			return new ContainerBowCrafter(playerInventory, this.world, this.position);
		}

		@Override
		public String getGuiID() {
			return SlayerAPI.PREFIX + "bowCrafter";
		}

		@Override
		public IChatComponent getDisplayName() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}