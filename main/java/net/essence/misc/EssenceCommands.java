package net.essence.misc;

import java.util.List;

import net.essence.EssenceBlocks;
import net.essence.client.DarkEnergyBar;
import net.essence.client.EssenceBar;
import net.essence.dimension.ModTeleporter;
import net.essence.util.Config;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Teleporter;

public class EssenceCommands extends CommandBase {

	@Override
	public String getCommandName() {
		return "essence";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/essence";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		EntityPlayerMP p = null;
		try {
			p = getCommandSenderAsPlayer(var1);
		} catch (PlayerNotFoundException e) {
			e.printStackTrace();
		}
		if(var2[0].equalsIgnoreCase("Heal")){
			if(p.getHealth() < p.getMaxHealth()) 
				p.heal(20);

			if(p.getFoodStats().needFood())
				p.getFoodStats().addStats(20, 1);

			EssenceBar.addBarPoints(400);
			DarkEnergyBar.addBarPoints(400);
		}

		EntityPlayerMP playerMP = (EntityPlayerMP)var1;
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
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.euca,
							new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.euca), Config.euca,
									EssenceBlocks.eucaPortal, EssenceBlocks.eucaPortalFrame));
				}
			}

			if(var2[0].equalsIgnoreCase("BoilingPoint")) {
				if(playerMP.dimension != Config.euca) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.boil,
							new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.boil), Config.boil,
									EssenceBlocks.boilPortal, EssenceBlocks.boilPortalFrame));
				}
			}

			if(var2[0].equalsIgnoreCase("Depths")) {
				if(playerMP.dimension != Config.depths) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, Config.depths, new ModTeleporter(playerMP.mcServer.worldServerForDimension(Config.depths), Config.depths, EssenceBlocks.depthsPortal, EssenceBlocks.depthsPortalFrame));
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
		return par2.length == 1 ? getListOfStringsMatchingLastWord(par2, new String[] {"heal", "overworld", "nether", "end", "euca", "boilingpoint", "depths"}) : null;
	}
}