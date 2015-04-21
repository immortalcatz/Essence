package net.essence.event.message;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageDarkEnergyBar implements IMessage {

	public MessageDarkEnergyBar() { }
	
	@Override
	public void fromBytes(ByteBuf buf) { }

	@Override
	public void toBytes(ByteBuf buf) { }
	
	public class DarkEnergyHandler implements IMessageHandler<MessageDarkEnergyBar, IMessage> {

		@Override
		public IMessage onMessage(MessageDarkEnergyBar message, MessageContext ctx) {
			return null;
		}
	}
}
