package net.essence.event.message;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessagePowerBar implements IMessage {

	public MessagePowerBar() { }
	
	@Override
	public void fromBytes(ByteBuf buf) { }

	@Override
	public void toBytes(ByteBuf buf) { }
	
	public class DarkEnergyHandler implements IMessageHandler<MessagePowerBar, IMessage> {

		@Override
		public IMessage onMessage(MessagePowerBar message, MessageContext ctx) {
			return null;
		}
	}
}
