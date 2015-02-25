package com.bringspring.client;

import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bringspring.gateway.vo.CarPicture;
import com.bringspring.gateway.vo.TradInfo;
import com.bringspring.interAnalyisi.AnalysisTools;
import com.bringspring.interAnalyisi.TradOper;
import com.intelligence.common.IDGenerate;

public class DataDecoderEx extends CumulativeProtocolDecoder {
	private static final Logger LOG = LoggerFactory
			.getLogger(DataDecoderEx.class);
	private AnalysisTools tools;
	private TradOper tradOper;
	
	public DataDecoderEx()
	{
		this.tools = AnalysisTools.getInstanse();
		this.tradOper = new TradOper();
	}
	@Override
	protected boolean doDecode(IoSession session, IoBuffer in,ProtocolDecoderOutput out) throws Exception {
		long beg = System.currentTimeMillis();
		in.order(ByteOrder.LITTLE_ENDIAN);
		if(in.remaining()<4)
		{ 
			return false;
		}
        
		if (in.remaining() > 1) {
			in.mark();
			
			int tag = in.getInt();
			int len = in.getInt();
			
			if (tag == (int) 0x55aa55aa) {
				if(len>in.remaining()){
	                in.reset();   
	                return false;//接收新数据，以拼凑成完整数据   
				}else{
					if(len==16)
					{
						byte[] temp = new byte[len];
						in.get(temp,0,len);
						out.write("OK");
					}else
					{
						TradInfo info = new TradInfo();
						info.setId(IDGenerate.getInstanse().getID());
						
						byte[] temp = new byte[1];
						in.get(temp);
						
						in.get(temp);
						int videoId = Integer.parseInt(tools.hextoString(temp),16);
//						System.out.println(videoId);
						info.setVideoId(String.valueOf(videoId));
						
						temp = new byte[4];
						in.get(temp);
						long time = Long.parseLong(tools.hextoString(temp), 16);
//						System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time*1000)));
						info.setCatchTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time*1000)));
						
						in.get(temp);
						int nCredit = Integer.parseInt(tools.hextoString(temp),16);
//						System.out.println(nCredit);
						info.setCredibility(nCredit);
						
						temp = new byte[13];
						in.get(temp);
						temp = tools.filterBytes(temp);
						info.setPlateNo(new String(temp,"GBK"));
//						System.out.println(new String(temp,"GBK"));
						
						temp = new byte[13];
						in.get(temp);
						temp = tools.filterBytes(temp);
						info.setPlateNoOther(new String(temp,"GBK"));
						
						temp = new byte[1];
						in.get(temp);
						int type = Integer.parseInt(tools.hextoString(temp),16);
//						System.out.println(type);
						info.setPlateType(String.valueOf(type));
						
						temp = new byte[25];
						in.get(temp);
						
						temp = new byte[1];
						in.get(temp);
						int num = Integer.parseInt(tools.hextoString(temp),16);
//						System.out.println(num);
						info.setPhotoNum(num);
						
//						//插入数据
//						tradOper.saveInfo(info);
						for(int i=0;i<num;i++){
							CarPicture pic = new CarPicture();
							pic.setId(IDGenerate.getInstanse().getID());
							pic.setTradinfoId(info.getId());
							
							temp = new byte[4];
							in.get(temp);
							int size = Integer.parseInt(tools.hextoString(temp),16);
//							System.out.println(size);
							temp = new byte[size];
							in.get(temp);
							pic.setPic(temp);
							
							tradOper.savePicture(pic);
						}
						
						//插入数据
						tradOper.saveInfo(info);
						
						out.write("记录保存成功！"); 
					}
					
					if(in.remaining() > 0){//如果读取内容后还粘了包，就让父类再给一次，进行下一次解析
						return false;
					}
					long end = System.currentTimeMillis();
					Thread current = Thread.currentThread();
					LOG.info(current.getName()+"获得包长度："+len+"===信息处理时间："+(end - beg));
					return true;//这里有两种情况1：没数据了，那么就结束当前调用，有数据就再次调用
				}
			}
        }   
        return false;//处理成功，让父类进行接收下个包   
	}
}
