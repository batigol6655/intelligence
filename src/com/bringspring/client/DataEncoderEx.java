package com.bringspring.client;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class DataEncoderEx extends ProtocolEncoderAdapter{

/* (non-Javadoc)
     * @see org.apache.mina.filter.codec.ProtocolEncoder#encode(org.apache.mina.core.session.IoSession, java.lang.Object, org.apache.mina.filter.codec.ProtocolEncoderOutput)
     */
    public void encode(IoSession session, Object message,ProtocolEncoderOutput out) throws Exception {
    	IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);
	    byte[] send= (byte[])message;
		buf.put(send);
		buf.flip();
		out.write(buf);
    }
    
}
