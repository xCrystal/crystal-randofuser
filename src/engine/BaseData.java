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
		
		byte type1i, type2i, type1j, type2j;
		
		in.position(i);
		type1i = in.get();
		type2i = in.get();
		in.position(j);
		type1j = in.get();
		type2j = in.get();
		
		//type 1 has priority, unless type is normal/flying
		if ((type1i == Constants.NORMAL_T) && (type2i == Constants.FLYING_T)) {
			type1i = Constants.FLYING_T;
			type2i = Constants.NORMAL_T;
		}
		if ((type1j == Constants.NORMAL_T) && (type2j == Constants.FLYING_T)) {
			type1j = Constants.FLYING_T;
			type2j = Constants.NORMAL_T;
		}
		
		if (type1i != type1j) { 
			type2i = type1j; // use type1 of mon1 and type1 of mon2 if they differ
			
		} else if (type1i == type2i) { // if mon1 is monotype,
			if (type1j != type2j) {    // and if mon2 has two types:
				type2i = type2j;       // use type2 of mon2
			}
		} // else, keep type2 of mon1 (no changes)
		
		out.position(i);
		out.put(type1i);
		out.put(type2i);
	}
	
	public static void fuseCatchRates (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}
	
	public static void fuseBaseExp (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		byte be1, be2;
		int f1, f2;
		
		// give more weight to base exp of mon 1 if bst is based solely on that mon
		if (Settings.AverageBaseStats) {
			f1 = 5; // be1 - 50% weight
			f2 = 5; // be2 - 50% weight
		} else {
			f1 = 8; // be1 - 80% weight
			f2 = 2; // be2 - 20% weight
		}
		
		in.position(i);
		be1 = in.get();
		in.position(j);
		be2 = in.get();
		
		out.position(i);
		byte result = (byte) ((f1 * toUnsignedInt(be1) + f2 * toUnsignedInt(be2)) / 10);
		out.put(result);
		
	}

	public static void fuseHeldItems (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}
	
	public static void fuseGenders (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		byte g1, g2;
		
		in.position(i);
		g1 = in.get();
		in.position(j);
		g2 = in.get();
		
		out.position(i);
		byte result = (byte) ((toUnsignedInt(g1) + toUnsignedInt(g2) + 1) / 2);
		out.put(result);
	}
	
	public static void fuseHatchCycles (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		byte hc1, hc2;
		int f1, f2;
		
		// give more weight to hatch cycle of mon 1 if bst is based solely on that mon
		if (Settings.AverageBaseStats) {
			f1 = 5; // be1 - 50% weight
			f2 = 5; // be2 - 50% weight
		} else {
			f1 = 8; // be1 - 80% weight
			f2 = 2; // be2 - 20% weight
		}
		
		in.position(i);
		hc1 = in.get();
		in.position(j);
		hc2 = in.get();
		
		out.position(i);
		byte result = (byte) ((f1 * toUnsignedInt(hc1) + f2 * toUnsignedInt(hc2)) / 10);
		out.put(result);
		
	}
	
	public static void fuseGrowthRates (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}

	public static void fuseEggGroups (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}
	
	public static void combineTmHm (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
	}


}
