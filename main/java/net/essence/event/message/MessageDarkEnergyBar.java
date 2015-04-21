package net.essence.event.message;

import io.netty.buffer.ByteBuf;
import net.essence.Essence;
import net.essence.client.BarTickHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageDarkEnergyBar implements IMessage {
	
	public int amount;
	public boolean shouldRegen;

	public MessageDarkEnergyBar(int amount, boolean shouldRegen) {
		this.amount = amount;
		this.shouldRegen = shouldRegen;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		amount = buf.readInt();
		shouldRegen = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(amount);
		buf.writeBoolean(shouldRegen);
	}
	
	public class DarkEnergyHandler implements IMessageHandler<MessageDarkEnergyBar, IMessage> {

		@Override
		public IMessage onMessage(MessageDarkEnergyBar message, MessageContext ctx) {
			BarTickHandler.darkAmount = message.amount;
			BarTickHandler.regenDark = message.shouldRegen;
			Essence.proxy.updateDarkEnergy(message.amount);
			return null;
		}
	}
}
