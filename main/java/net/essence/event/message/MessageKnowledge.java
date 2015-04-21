package net.essence.event.message;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageKnowledge implements IMessage {
	
	public int amount;
	public boolean shouldRegen;

	public MessageKnowledge(int amount, boolean shouldRegen) {
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
	
	public class DarkEnergyHandler implements IMessageHandler<MessageKnowledge, IMessage> {

		@Override
		public IMessage onMessage(MessageKnowledge message, MessageContext ctx) {
			return null;
		}
	}
}
