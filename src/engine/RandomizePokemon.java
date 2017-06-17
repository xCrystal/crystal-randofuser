package engine;

import java.nio.ByteBuffer;

import data.Pokemon;

public class RandomizePokemon {

	private static int i = 0, replaceCnt = 0, repeatCnt = 0;

	static byte getRandomMatchingPokemon(byte mon_in, boolean isTrainer) {

		if (mon_in == 0 || mon_in == (byte) Pokemon.UNOWN.ordinal() + 1) return mon_in;

		int strength_in = Pokemon.values()[(mon_in - 1) & 0xff].getStrength();
		if (!isTrainer && strength_in >= 4) strength_in = 4;
		int mon_out = 0, strength_out = 0;

		do {
			mon_out = Rng.randomRange(Pokemon.BULBASAUR.ordinal(), Pokemon.CELEBI.ordinal());
			strength_out = Pokemon.values()[mon_out].getStrength();
			if (!isTrainer && strength_out >= 4) strength_out = 4;
		} while (strength_out != strength_in || mon_out == Pokemon.UNOWN.ordinal());

		return (byte) (mon_out + 1);
	}

	static ByteBuffer doRandomizeSequence(ByteBuffer buf, int[] params, boolean isTrainer) {

		byte read = 0;

		i ++;
		if (params[i + 1] != 0) {
			repeatCnt = params[i + 1];
			do {
				buf.position(buf.position() + params[i - 1]);
				replaceCnt = params[i];
				do {
					read = buf.get();
					buf.position(buf.position() - 1);
					if (replaceCnt != 0) {
						buf.put(getRandomMatchingPokemon(read, isTrainer));
						replaceCnt --;
					}
				} while (replaceCnt != 0);
				repeatCnt --;
			} while (repeatCnt != 0);
		}
		i += 2;

		return buf;
	}

	static ByteBuffer randomize(ByteBuffer buf, int[] params, byte terminator, int numSequences, boolean isTrainer) {

		while (buf.get() != terminator && buf.position() != buf.capacity()) {
			buf.position(buf.position() - 1);
			i = 0;
			for (int j = 0; j < numSequences; j ++) {
				buf = doRandomizeSequence(buf, params, isTrainer);
			}
		}

		return buf;
	}

}
