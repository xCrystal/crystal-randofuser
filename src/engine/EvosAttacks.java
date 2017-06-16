package engine;

import java.nio.ByteBuffer;
import java.util.Arrays;

import data.Constants;
import data.Pokemon;
import data.Settings;

public class EvosAttacks {
	
	static void fuseEvosAttacks (ByteBuffer in, ByteBuffer out, int[] fusionIds) {
		
		byte[] evosAttacks1 = new byte[Constants.EVOS_ATTACKS_LENGTH];
		byte[] evosAttacks2 = new byte[Constants.EVOS_ATTACKS_LENGTH];
		byte[] attacksUnsorted = new byte[Constants.EVOS_ATTACKS_LENGTH - 4];
		
		for (int i = Pokemon.BULBASAUR.ordinal() ; i <= Pokemon.CELEBI.ordinal() ; i ++) {
			
			Arrays.fill(evosAttacks1, (byte) 0x00);
			Arrays.fill(evosAttacks2, (byte) 0x00);
			Arrays.fill(attacksUnsorted, (byte) 0x00);
			
			if (i == Pokemon.UNOWN.ordinal()) i ++;
			
			int p1 = 1, p2 = 1; // offsets of learnset data, depends on whether mon has an evolution entry or not
			int l = 1; // length of evo data of current mons
			
			in.position(i * Constants.EVOS_ATTACKS_LENGTH);
			in.get(evosAttacks1, 0, 4); // read evolution data
			in.position(fusionIds[i] * Constants.EVOS_ATTACKS_LENGTH);
			in.get(evosAttacks2, 0, 4); // read evolution data
			
			if (evosAttacks1[0] != Constants.EvolutionCategories.EVOLVE_NONE.ordinal()) { p1 = 4; p2 = 4; l = 4; }
			
			// if either evolution is not level, keep evolution of mon 1
			if (evosAttacks1[0] == Constants.EvolutionCategories.EVOLVE_LEVEL.ordinal() && 
					evosAttacks2[0] == Constants.EvolutionCategories.EVOLVE_LEVEL.ordinal()) {
				
				// else, average the level requirement rounded down
				// if bst's are not averaged, mon 1 weighs 80%
				out.position((i * Constants.EVOS_ATTACKS_LENGTH) + 1);
				
				if (Settings.averageBaseStats) { 
					out.put((byte) ((evosAttacks1[1] + evosAttacks2[1]) / 2));
				} else {
					out.put((byte) ((4 * evosAttacks1[1] + evosAttacks2[1]) / 5));
				}
			}
			
			// now read the two level up learnsets
			in.position(i * Constants.EVOS_ATTACKS_LENGTH + p1);
			do { 
				in.get(evosAttacks1, p1, 2);
				p1 += 2;
			} while (evosAttacks1[p1-2] != 0);
			p1 -= 2;
			
			in.position(fusionIds[i] * Constants.EVOS_ATTACKS_LENGTH + p2);
			do {
				in.get(evosAttacks2, p2, 2);
				p2 += 2;
			} while (evosAttacks2[p2-2] != 0);
			p2 -= 2;
			
			// finally combine and arrange the moves by their level
			System.arraycopy(evosAttacks1, l, attacksUnsorted, 0, p1-l);
			System.arraycopy(evosAttacks2, l, attacksUnsorted, p1-l, p2-l);
			byte[] attacksSorted = Arrays.copyOf(attacksUnsorted, p1-l + p2-l);
			boolean changed;
			
			do {
				changed = false;
				byte tempx, tempy;
				
				for (int j = 0 ; j < (attacksSorted.length - 2) ; j += 2) {
				
					if (attacksSorted[j] > attacksSorted[j+2]) {
						
						changed = true;
						tempx = attacksSorted[j];
						tempy = attacksSorted[j+1];
						attacksSorted[j] = attacksSorted[j+2];
						attacksSorted[j+1] = attacksSorted[j+3];
						attacksSorted[j+2] = tempx;
						attacksSorted[j+3] = tempy;
					}
				}
				
			} while (changed);
			
			out.position((i * Constants.EVOS_ATTACKS_LENGTH) + l);
			out.put(attacksSorted, 0, attacksSorted.length);
		}
	}
	
	static void fuseEggMoves (ByteBuffer in, ByteBuffer out, int[] fusionIds) {
		
		byte[] eggMoves1 = new byte[Constants.EGG_MOVES_LENGTH];
		byte[] eggMoves2 = new byte[Constants.EGG_MOVES_LENGTH];
		
		for (int i = Pokemon.BULBASAUR.ordinal() ; i <= Pokemon.CELEBI.ordinal() ; i ++) {
			
			Arrays.fill(eggMoves1, (byte) 0x00);
			Arrays.fill(eggMoves2, (byte) 0x00);
			
			if (i == Pokemon.UNOWN.ordinal()) i ++;
			
			in.position(i * Constants.EGG_MOVES_LENGTH);
			in.get(eggMoves1);
			in.position(fusionIds[i] * Constants.EGG_MOVES_LENGTH);
			in.get(eggMoves2);
			
			out.position(i * Constants.EGG_MOVES_LENGTH);
			
			int c = 0;
			byte b;
			do {
				b = eggMoves1[c];
				if ((b != (byte) 0xff) && (b != (byte) 0x00)) {
					out.put(b);
					c ++;
				}
			} while ((b != (byte) 0xff) && (b != (byte) 0x00));
			
			c = 0;
			do {
				b = eggMoves2[c];
				if ((b != (byte) 0xff) && (b != (byte) 0x00)) { 
					out.put(b);
					c ++;
				}
			} while ((b != (byte) 0xff) && (b != (byte) 0x00));
			
			out.put((byte) 0xff);
		}
	}

}
