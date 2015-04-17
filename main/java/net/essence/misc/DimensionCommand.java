package net.essence.misc;

import java.util.List;

import net.essence.EssenceBlocks;
import net.essence.client.DarkEnergyBar;
import net.essence.client.EssenceBar;
import net.essence.dimension.ModTeleporter;
import net.essence.dimension.corba.TeleporterCorba;
import net.essence.util.Config;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Teleporter;

public class DimensionCommand extends CommandBase {

	@Override
	public String getName() {
		return "dimension";
	}
	
	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/dimension";
	}

	@Override
	public void execute(ICommandSender var1, String[] var2) throws CommandException {
		EntityPlayerMP playerMP = getCommandSenderAsPlayer(var1);
		if(!playerMP.worldObj.isRemote) {
			if(var2[0].equalsIgnoreCase("Overworld")) {
				if(playerMP.dimension != 0) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, new Teleporter(playerMP.mcServer.worldServerForDimension(0)));
				}
			}

			if(var2[0].equalsIgnoreCase("Nether")) {
				if(playerMP.dimension != -1) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, -1, new Teleporter(playerMP.mcServer.worldServerForDimension(-1)));
				}
			}

			if(var2[0].equalsIgnoreCase("End")) {
				if(playerMP.dimension != 1) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 1, new Teleporter(playerMP.mcServer.worldServerForDimension(1)));
				}
			}

			if(var2[0].equalsIgnoreCase("Euca")) {
				if(playerMP.dimension != Config.euca) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.euca, new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.euca), Config.euca, EssenceBlocks.eucaPortal, EssenceBlocks.eucaPortalFrame));
				}
			}

			if(var2[0].equalsIgnoreCase("BoilingPoint")) {
				if(playerMP.dimension != Config.boil) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.boil, new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.boil), Config.boil, EssenceBlocks.boilPortal, EssenceBlocks.boilPortalFrame));
				}
			}

			if(var2[0].equalsIgnoreCase("Depths")) {
				if(playerMP.dimension != Config.depths) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.depths, new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.depths), Config.depths, EssenceBlocks.depthsPortal, EssenceBlocks.depthsPortalFrame));
				}
			}
			
			if(var2[0].equalsIgnoreCase("FrozenLands")) {
				if(playerMP.dimension != Config.frozen) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.frozen, new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.frozen), Config.frozen, EssenceBlocks.frozenPortal, Blocks.snow));
				}
			}
			
			if(var2[0].equalsIgnoreCase("Corba")) {
				if(playerMP.dimension != Config.corba) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.corba, new TeleporterCorba(playerMP.mcServer.worldServerForDimension(Config.corba)));
				}
			}
			
			if(var2[0].equalsIgnoreCase("Wastelands")) {
				if(playerMP.dimension != Config.wastelands) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.wastelands, new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.wastelands), Config.wastelands, EssenceBlocks.wastelandsPortal, EssenceBlocks.wastelandsPortalFrame));
				}
			}
			
			if(var2[0].equalsIgnoreCase("Cloudia")) {
				if(playerMP.dimension != Config.wastelands) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.cloudia, new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.cloudia), Config.cloudia, EssenceBlocks.cloudiaPortal, EssenceBlocks.cloudiaPortalFrame));
				}
			}
		}
		
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2, BlockPos pos) {
		return par2.length == 1 ? getListOfStringsMatchingLastWord(par2, new String[] {"overworld", "nether", "end", "euca", "boilingpoint", "depths", "frozenlands", "corba", "wastelands", "cloudia"}) : null;
	}
}