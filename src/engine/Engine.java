package engine;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

import javax.swing.JOptionPane;

import data.Constants;
import data.Constants.BaseDataFields;
import data.Names;
import data.Pokemon;
import data.Settings;

public class Engine {
	
	static boolean verifyRom (FileChannel chin) throws IOException {
		
		byte[] header = {0x50, 0x4D, 0x5F, 0x43, 0x52, 0x59, 0x53, 0x54, 0x41, 0x4C, 0x00, 0x41, 0x42, 
				0x43, 0x44, (byte) 0xC0, 0x30, 0x31, 0x00, 0x10, 0x06, 0x03, 0x01, 0x33, 0x00};
		
		ByteBuffer headerin = ByteBuffer.allocate(header.length);
		chin.read(headerin, 0x134);
		
		return ((ByteBuffer) headerin.rewind()).compareTo(ByteBuffer.wrap(header)) == 0;
	}
	
	static void createRomCopy (FileChannel chin, FileChannel chout) throws IOException {
		
		chin.transferTo(0, chin.size(), chout);
	}
	
	static void readData (FileChannel ch, ByteBuffer bbRead, ByteBuffer bbWrite, long pos) throws IOException {
		
		ch.position(pos);
		bbRead.rewind();
		ch.read(bbRead);
		
		ch.position(pos);
		bbWrite.rewind();
		ch.read(bbWrite);
	}
	
	static void readData (FileChannel ch, ByteBuffer bb, long pos) throws IOException {
		
		ch.position(pos);
		bb.rewind();
		ch.read(bb);
	}
	
	public static void fuseNames (ByteBuffer in, ByteBuffer out, int[] fusionIds) {
		
		byte[] name = new byte[Constants.NAMES_LENGTH];	
		
		for (int i = Pokemon.BULBASAUR.ordinal() ; i <= Pokemon.CELEBI.ordinal() ; i ++) {
			
			Arrays.fill(name, (byte) 0x50);
			
			if (i == Pokemon.UNOWN.ordinal()) i ++;
			
			byte[] prefix = Names.values()[i].getPrefix();
			byte[] suffix = Names.values()[fusionIds[i]].getSuffix();
			
			prefix = Arrays.copyOf(prefix, prefix.length - 1); // get rid of the terminator
			
			if ((prefix.length + suffix.length) > 10)
				suffix = Arrays.copyOf(suffix, 5); // get rid of the terminator if no need for it
			
			System.arraycopy(prefix, 0, name, 0, prefix.length);
			System.arraycopy(suffix, 0, name, prefix.length, suffix.length);
			
			out.position(i * Constants.NAMES_LENGTH);
			out.put(name);
		}
	}
	
	public static void fuseEvosAttacks (ByteBuffer in, ByteBuffer out, int[] fusionIds) {
		
		byte[] evosAttacks1 = new byte[Constants.EVOS_ATTACKS_LENGTH];
		byte[] evosAttacks2 = new byte[Constants.EVOS_ATTACKS_LENGTH];
		
		for (int i = Pokemon.BULBASAUR.ordinal() ; i <= Pokemon.CELEBI.ordinal() ; i ++) {
			
			Arrays.fill(evosAttacks1, (byte) 0x00);
			Arrays.fill(evosAttacks2, (byte) 0x00);
			
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
				
				if (Settings.AverageBaseStats) { 
					out.put((byte) ((evosAttacks1[1] + evosAttacks2[1]) / 2));
				} else {
					out.put((byte) ((4 * evosAttacks1[1] + evosAttacks2[1]) / 5));
				}
			}
			
			// now combine the two level up learnsets
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
			p2 -= 1; // keep the terminator 0x00
			
			out.position((i * Constants.EVOS_ATTACKS_LENGTH) + l);
			out.put(evosAttacks1, l, p1-l);
			out.put(evosAttacks2, l, p2-l);
		}
	}
	
	public static void fuseEggMoves (ByteBuffer in, ByteBuffer out, int[] fusionIds) {
		
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
	
	public static void switchPalettes (ByteBuffer in, ByteBuffer out, int[] fusionIds) {
		
		byte[] pal = new byte[Constants.PALETTES_LENGTH];
		
		for (int i = Pokemon.BULBASAUR.ordinal() ; i <= Pokemon.CELEBI.ordinal() ; i ++) {
			
			if (i == Pokemon.UNOWN.ordinal()) i ++;
			
			in.position(fusionIds[i] * Constants.PALETTES_LENGTH);
			in.get(pal);
			
			out.position(i * Constants.PALETTES_LENGTH);
			out.put(pal);
		}	
	}
	
	public static int baseDataPos (int curMon, BaseDataFields field) {
		
		return curMon * Constants.BASE_DATA_LENGTH + field.getOffset();
	}
	
	public static void fuseBaseData (ByteBuffer in, ByteBuffer out, int[] fusionIds) {
		
		for (int i = Pokemon.BULBASAUR.ordinal() ; i <= Pokemon.CELEBI.ordinal() ; i ++) {
			
			if (i == Pokemon.UNOWN.ordinal()) i ++;
			
			BaseData.fuseStats(in, out, fusionIds, baseDataPos(i, BaseDataFields.STATS), baseDataPos(fusionIds[i], BaseDataFields.STATS));
			BaseData.fuseTypes(in, out, fusionIds, baseDataPos(i, BaseDataFields.TYPE_1), baseDataPos(fusionIds[i], BaseDataFields.TYPE_1));
			BaseData.fuseCatchRates(in, out, fusionIds, baseDataPos(i, BaseDataFields.CATCH_RATE), baseDataPos(fusionIds[i], BaseDataFields.CATCH_RATE));
			BaseData.fuseBaseExp(in, out, fusionIds, baseDataPos(i, BaseDataFields.BASE_EXP), baseDataPos(fusionIds[i], BaseDataFields.BASE_EXP));
			BaseData.fuseHeldItems(in, out, fusionIds, baseDataPos(i, BaseDataFields.ITEM_1), baseDataPos(fusionIds[i], BaseDataFields.ITEM_1));
			BaseData.fuseGenders(in, out, fusionIds, baseDataPos(i, BaseDataFields.GENDER), baseDataPos(fusionIds[i], BaseDataFields.GENDER));
			BaseData.fuseHatchCycles(in, out, fusionIds, baseDataPos(i, BaseDataFields.HATCH_CYCLES), baseDataPos(fusionIds[i], BaseDataFields.HATCH_CYCLES));
			BaseData.fuseGrowthRates(in, out, fusionIds, baseDataPos(i, BaseDataFields.GROWTH_RATE), baseDataPos(fusionIds[i], BaseDataFields.GROWTH_RATE));
			BaseData.fuseEggGroups(in, out, fusionIds, baseDataPos(i, BaseDataFields.EGG_GROUPS), baseDataPos(fusionIds[i], BaseDataFields.EGG_GROUPS));
			BaseData.combineTmHm(in, out, fusionIds, baseDataPos(i, BaseDataFields.TMHM), baseDataPos(fusionIds[i], BaseDataFields.TMHM));
		}		
	}
	
	static void copyData (FileChannel ch, ByteBuffer bbWrite, long pos) throws IOException {
		
		ch.position(pos);
		bbWrite.rewind();
		ch.write(bbWrite);
	}
	
	static void fixGlobalChecksum (FileChannel ch) throws IOException {
		
		ch.position(0);
		ByteBuffer rom = ByteBuffer.allocate(Constants.ROM_SIZE);
		ch.read(rom);
		
		rom.position(0x14e);
		byte[] old_cs = new byte[2];
		rom.get(old_cs, 0, 2);
		
		int checksum = 0;
		for (byte b : rom.array())
			checksum += ((int) b) & 0xff;
		checksum -= (old_cs[0] & 0xff);
		checksum -= (old_cs[1] & 0xff);
		
		ch.position(0x14e);
		byte[] cs = new byte[2];
		cs[0] = (byte) ((checksum >> 8) & 0xff);
		cs[1] = (byte) (checksum & 0xff);
		ch.write(ByteBuffer.wrap(cs));
	}
	
	public static void print (String str) {
		
		JOptionPane.showMessageDialog(null, str);
	}

}
