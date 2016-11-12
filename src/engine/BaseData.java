package engine;

import java.nio.ByteBuffer;

import data.Constants;
import data.Settings;

public class BaseData {
	
	public static int toUnsignedInt (byte b) {
	    return ((int) b) & 0xff;
	}
	
	public static void fuseStats (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		byte stat1, stat2;
		int sum1 = 0, sum2 = 0;
		float bstFactor = 1;
		
		if (!Settings.AverageBaseStats) {
			
			for (int s = 0 ; s < Constants.NUM_STATS ; s ++) {
				
				in.position(i + s);
				stat1 = in.get();
				in.position(j + s);
				stat2 = in.get();
				
				sum1 += toUnsignedInt(stat1);
				sum2 += toUnsignedInt(stat2);
			}
			bstFactor = ((float) sum1 / (float) sum2);
		}
		
		for (int s = 0 ; s < Constants.NUM_STATS ; s ++) {
		
			in.position(i + s);
			stat1 = in.get();
			in.position(j + s);
			stat2 = in.get();
			
			out.position(i + s);
			byte result = (byte) (Math.min ((((toUnsignedInt(stat1) + (toUnsignedInt(stat2) * bstFactor) + 1) / 2)), 255)); // adjust stat2 preserving bst of mon 1
			out.put(result);
		}
		
	}
	
	public static void fuseTypes (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}
	
	public static void fuseCatchRates (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}
	
	public static void fuseBaseExp (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}

	public static void fuseHeldItems (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}
	
	public static void fuseGenders (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}
	
	public static void fuseHatchCycles (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}
	
	public static void fuseGrowthRates (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}

	public static void fuseEggGroups (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}
	
	public static void combineTmHm (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}


}
