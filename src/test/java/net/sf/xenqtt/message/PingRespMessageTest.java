package net.sf.xenqtt.message;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;

import org.junit.Test;

public class PingRespMessageTest {

	ByteBuffer buf = ByteBuffer.wrap(new byte[] { (byte) 0xd0, 0x00 });

	PingRespMessage msg;

	@Test
	public void testCtor_Receive() {

		msg = new PingRespMessage(buf);
		assertMsg();
	}

	@Test
	public void testCtor_Send() {
		msg = new PingRespMessage();
		assertMsg();
	}

	private void assertMsg() {

		assertEquals(buf, msg.buffer);

		assertEquals(MessageType.PINGRESP, msg.getMessageType());
		assertFalse(msg.isDuplicate());
		assertEquals(QoS.AT_MOST_ONCE, msg.getQoS());
		assertFalse(msg.isRetain());
		assertEquals(0, msg.getRemainingLength());
	}
}
