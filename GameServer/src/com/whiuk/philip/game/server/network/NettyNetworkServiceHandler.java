package com.whiuk.philip.game.server.network;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.whiuk.philip.game.server.MessageHandler;
import com.whiuk.philip.game.server.MessageHandlerService;
import com.whiuk.philip.game.shared.Messages.ClientMessage;

/**
 * Handles network events for the netty-based connection.
 * @author Philip Whitehouse
 *
 */
public class NettyNetworkServiceHandler extends SimpleChannelHandler {

	@Autowired
	MessageHandlerService messageHandler;

	@Override
    public final void messageReceived(final ChannelHandlerContext ctx,
			final MessageEvent e) {
		ClientMessage message = (ClientMessage) e.getMessage();
		messageHandler.processInboundMessage(message);
	}
}
