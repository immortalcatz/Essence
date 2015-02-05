package net.essence.blocks.tileentity;

import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentProcessor;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.gson.JsonParseException;

public class TileEntityEssenceSign extends TileEntitySign {
	
    public IChatComponent[] signText = new IChatComponent[] {new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText("")};
    public int lineBeingEdited = -1;
    private boolean isEditable = true;
    private EntityPlayer player;
    private final CommandResultStats field_174883_i = new CommandResultStats();

    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        for (int i = 0; i < 4; ++i)
        {
            String s = IChatComponent.Serializer.componentToJson(this.signText[i]);
            compound.setString("Text" + (i + 1), s);
        }

        this.field_174883_i.func_179670_b(compound);
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        this.isEditable = false;
        super.readFromNBT(compound);
        ICommandSender icommandsender = new ICommandSender()
        {
            private static final String __OBFID = "CL_00002039";
            public String getName()
            {
                return "Sign";
            }
            public IChatComponent getDisplayName()
            {
                return new ChatComponentText(this.getName());
            }
            public void addChatMessage(IChatComponent message) {}
            public boolean canUseCommand(int permLevel, String commandName)
            {
                return true;
            }
            public BlockPos getPosition()
            {
                return TileEntityEssenceSign.this.pos;
            }
            public Vec3 getPositionVector()
            {
                return new Vec3((double)TileEntityEssenceSign.this.pos.getX() + 0.5D, (double)TileEntityEssenceSign.this.pos.getY() + 0.5D, (double)TileEntityEssenceSign.this.pos.getZ() + 0.5D);
            }
            public World getEntityWorld()
            {
                return TileEntityEssenceSign.this.worldObj;
            }
            public Entity getCommandSenderEntity()
            {
                return null;
            }
            public boolean sendCommandFeedback()
            {
                return false;
            }
            public void setCommandStat(CommandResultStats.Type type, int amount) {}
        };

        for (int i = 0; i < 4; ++i)
        {
            String s = compound.getString("Text" + (i + 1));

            try
            {
                IChatComponent ichatcomponent = IChatComponent.Serializer.jsonToComponent(s);

                try
                {
                    this.signText[i] = ChatComponentProcessor.func_179985_a(icommandsender, ichatcomponent, (Entity)null);
                }
                catch (CommandException commandexception)
                {
                    this.signText[i] = ichatcomponent;
                }
            }
            catch (JsonParseException jsonparseexception)
            {
                this.signText[i] = new ChatComponentText(s);
            }
        }

        this.field_174883_i.func_179668_a(compound);
    }

    public Packet getDescriptionPacket()
    {
        IChatComponent[] aichatcomponent = new IChatComponent[4];
        System.arraycopy(this.signText, 0, aichatcomponent, 0, 4);
        return new S33PacketUpdateSign(this.worldObj, this.pos, aichatcomponent);
    }

    public boolean getIsEditable()
    {
        return this.isEditable;
    }

    @SideOnly(Side.CLIENT)
    public void setEditable(boolean isEditableIn)
    {
        this.isEditable = isEditableIn;

        if (!isEditableIn)
        {
            this.player = null;
        }
    }

    public void setPlayer(EntityPlayer playerIn)
    {
        this.player = playerIn;
    }

    public EntityPlayer getPlayer()
    {
        return this.player;
    }

    public boolean func_174882_b(final EntityPlayer playerIn)
    {
        ICommandSender icommandsender = new ICommandSender()
        {
            private static final String __OBFID = "CL_00002038";
            public String getName()
            {
                return playerIn.getName();
            }
            public IChatComponent getDisplayName()
            {
                return playerIn.getDisplayName();
            }
            public void addChatMessage(IChatComponent message) {}
            public boolean canUseCommand(int permLevel, String commandName)
            {
                return true;
            }
            public BlockPos getPosition()
            {
                return TileEntityEssenceSign.this.pos;
            }
            public Vec3 getPositionVector()
            {
                return new Vec3((double)TileEntityEssenceSign.this.pos.getX() + 0.5D, (double)TileEntityEssenceSign.this.pos.getY() + 0.5D, (double)TileEntityEssenceSign.this.pos.getZ() + 0.5D);
            }
            public World getEntityWorld()
            {
                return playerIn.getEntityWorld();
            }
            public Entity getCommandSenderEntity()
            {
                return playerIn;
            }
            public boolean sendCommandFeedback()
            {
                return false;
            }
            public void setCommandStat(CommandResultStats.Type type, int amount)
            {
                TileEntityEssenceSign.this.field_174883_i.func_179672_a(this, type, amount);
            }
        };

        for (int i = 0; i < this.signText.length; ++i)
        {
            ChatStyle chatstyle = this.signText[i] == null ? null : this.signText[i].getChatStyle();

            if (chatstyle != null && chatstyle.getChatClickEvent() != null)
            {
                ClickEvent clickevent = chatstyle.getChatClickEvent();

                if (clickevent.getAction() == ClickEvent.Action.RUN_COMMAND)
                {
                    MinecraftServer.getServer().getCommandManager().executeCommand(icommandsender, clickevent.getValue());
                }
            }
        }

        return true;
    }

    public CommandResultStats func_174880_d()
    {
        return this.field_174883_i;
    }
}