package com.bringspring.interAnalyisi;

public class AnalysisTools {
	private static AnalysisTools instance = null;

	/**
	 * 获取单例对象
	 * 
	 * @return
	 */
	public static AnalysisTools getInstanse() {
		if (instance == null) {
			instance = new AnalysisTools();
		}
		return instance;
	}

	public String hextoString(byte[] tb) {
		String result = "";
		for (int i = 0; i < tb.length; i++) {
			String hex = Integer.toHexString(tb[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			result = hex + result;
		}
		return result.toUpperCase();
	}

	public byte[] subBytes(byte[] src, int begin, int count) {
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++)
			bs[i - begin] = src[i];
		return bs;
	}

	public byte[] filterBytes(byte[] bytes) {
		int num = 0;
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);

			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			if ("00".equals(hex)) {
				num = i;
				break;
			}
		}

		return subBytes(bytes, 0, num);
	}
}
