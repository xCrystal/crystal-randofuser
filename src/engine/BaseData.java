package engine;

import java.nio.ByteBuffer;

import data.Constants;
import data.Constants.GrowthRates;
import data.Settings;

public class BaseData {
	
	public static int toUnsignedInt (byte b) {
		return ((int) b) & 0xff;
	}
	
	public static void fuseStats (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		byte stat1, stat2;
		int sum1 = 0, sum2 = 0;
		float bstFactor = 1;
		
		if (!Settings.averageBaseStats) {
			
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
		
		byte cr1, cr2;
		
		in.position(i);
		cr1 = in.get();
		in.position(j);
		cr2 = in.get();
		
		byte result;
		
		// do the geometric average of the two catch rates
		// if bst's not averaged, catch rate of mon 1 weighs 80%
		if (Settings.averageBaseStats) {
			result = (byte) (Math.pow(toUnsignedInt(cr1) * toUnsignedInt(cr2), 0.5) + 0.5);
		} else {
			result = (byte) (Math.pow(Math.pow(toUnsignedInt(cr1), 4) * toUnsignedInt(cr2), 0.2) + 0.5);
		}
		
		out.position(i);
		out.put(result);
	}
	
	public static void fuseBaseExp (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		byte be1, be2;
		int f1, f2;
		
		// give more weight to base exp of mon 1 if bst is based solely on that mon
		if (Settings.averageBaseStats) {
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
		byte result = (byte) ((f1 * toUnsignedInt(be1) + f2 * toUnsignedInt(be2) + 9) / 10);
		out.put(result);
	}

	public static void fuseHeldItems (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		byte item1i, item2i, item1j, item2j;
		
		in.position(i);
		item1i = in.get();
		item2i = in.get();
		in.position(j);
		item1j = in.get();
		item2j = in.get();
		
		if (item1i == 0x00) item1i = item1j;
		if (item2i == 0x00) item2i = item2j;
		
		out.position(i);
		out.put(item1i);
		out.put(item2i);
	}
	
	public static void fuseGenders (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		byte g1, g2;
		
		in.position(i);
		g1 = in.get();
		in.position(j);
		g2 = in.get();
		
		out.position(i);
		byte result;
		
		if ((toUnsignedInt(g1) != 0xff) && (toUnsignedInt(g2) != 0xff)) {
			result = (byte) ((toUnsignedInt(g1) + toUnsignedInt(g2) + 1) / 2);
		} else {
			result = g1;
		}
		out.put(result);
	}
	
	public static void fuseHatchCycles (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		byte hc1, hc2;
		int f1, f2;
		
		// give more weight to hatch cycle of mon 1 if bst is based solely on that mon
		if (Settings.averageBaseStats) {
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
	
	public static void homogenizeGrowthRates (ByteBuffer out, int i) {
	// this changes the growth rate of all Pokemon to "PARABOLIC". 
	// If this option is selected, the PARABOLIC formula will also be slightly balanced.
		out.position(i);
		out.put((byte) GrowthRates.PARABOLIC.ordinal());
	}
	
	public static void fuseGrowthRates (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		if (Settings.homogenizeGrowthRates) {
			homogenizeGrowthRates (out, i);
			return;
		}
		
		// if user didn't select to homogenize growth rates, and chose to keep BST unchanged, 
		// don't do anything with growth rate data.
		if (!Settings.averageBaseStats) 
			return;
		
		// else, "average" the growth rates
		byte gr1, gr2;
		
		in.position(i);
		gr1 = in.get();
		in.position(j);
		gr2 = in.get();
		
		// Medium slow (parabolic) is related to starters and early game pokemon, don't bother if either pokemon has it
		if (gr1 != GrowthRates.PARABOLIC.ordinal() && gr2 != GrowthRates.PARABOLIC.ordinal()) {
			
			if (gr1 != gr2) {
				
				if      (gr1 == GrowthRates.FAST.ordinal()   && gr2 == GrowthRates.SLOW.ordinal())   gr1 = (byte) GrowthRates.MEDIUM.ordinal();
				else if (gr1 == GrowthRates.SLOW.ordinal()   && gr2 == GrowthRates.FAST.ordinal())   gr1 = (byte) GrowthRates.MEDIUM.ordinal();
				else if (gr1 == GrowthRates.SLOW.ordinal()   && gr2 == GrowthRates.MEDIUM.ordinal()) gr1 = (byte) GrowthRates.SLIGHTLY_SLOW.ordinal();
				else if (gr1 == GrowthRates.MEDIUM.ordinal() && gr2 == GrowthRates.SLOW.ordinal())   gr1 = (byte) GrowthRates.SLIGHTLY_SLOW.ordinal();
				else if (gr1 == GrowthRates.FAST.ordinal()   && gr2 == GrowthRates.MEDIUM.ordinal()) gr1 = (byte) GrowthRates.SLIGHTLY_FAST.ordinal();
				else if (gr1 == GrowthRates.MEDIUM.ordinal() && gr2 == GrowthRates.FAST.ordinal())   gr1 = (byte) GrowthRates.SLIGHTLY_FAST.ordinal();
			}
		}
		
		out.position(i);
		out.put(gr1);
	}

	public static void fuseEggGroups (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		// egg group work like types, except they are nybbles
		byte egi, egj, eg1i, eg2i, eg1j, eg2j;
		
		in.position(i);
		egi = in.get();
		eg1i = (byte) ((egi & 0xf0) >> 4);
		eg2i = (byte)  (egi & 0x0f);
		
		in.position(j);
		egj = in.get();
		eg1j = (byte) ((egj & 0xf0) >> 4);
		eg2j = (byte)  (egj & 0x0f);
		
		if ((egi != (byte) 0xff) && (egj != (byte) 0xff)) { // don't do anything if either mon can't breed
		
			if (eg1i != eg1j) { 
				eg2i = eg1j; // use eg1 of mon1 and eg2 of mon2 if they differ
			
			} else if (eg1i == eg2i) { // if mon1 has one egg group,
				if (eg1j != eg2j) {    // and if mon2 has two egg groups:
					eg2i = eg2j;       // use eg2 of mon2
				}
			} // else, keep eg2 of mon1 (no changes)
		
		}
		out.position(i);
		out.put((byte) ((eg1i << 4) | eg2i));
	}
	
	public static void combineTmHm (ByteBuffer in, ByteBuffer out, int[] fusionIds, int i, int j) {
		
		// tmhm flags are 8 bytes of data
		long tmhm1, tmhm2;
		
		in.position(i);
		tmhm1 = in.getLong();
		in.position(j);
		tmhm2 = in.getLong();
		
		out.put(ByteBuffer.allocate(8).putLong(tmhm1 | tmhm2).array());
	}


}
