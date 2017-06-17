package engine;

import java.nio.ByteBuffer;

import data.Constants;
import data.Settings;

public class Trainers {

	static void raiseLevels(ByteBuffer buf) {

		if (Settings.johtoLevelBump == 0 && Settings.kantoLevelBump == 0) return;

		buf.rewind();
		byte b = 0;
		float f = 0;

		do {

			do {
				b = buf.get();
			} while (b != 0x50); // skip name

			b = buf.get(); // trainer type

			// JOHTO
			if (b == 0x00) { // level, mon

				do {
					f = buf.get(buf.position());
					f *= (float) ((100 + Settings.johtoLevelBump)) / 100;
					buf.put((byte) f);
					buf.position(buf.position() + 1);
				} while (buf.get(buf.position()) != (byte) 0xff);

			} else if (b == 0x02) { // level, mon, item

				do {
					f = buf.get(buf.position());
					f *= (float) ((100 + Settings.johtoLevelBump)) / 100;
					buf.put((byte) f);
					buf.position(buf.position() + 2);
				} while (buf.get(buf.position()) != (byte) 0xff);

			// KANTO
			} else if (b == (byte) 0x80) { // level, mon

				do {
					f = buf.get(buf.position());
					f *= (float) ((100 + Settings.kantoLevelBump)) / 100;
					buf.put((byte) f);
					buf.position(buf.position() + 1);
				} while (buf.get(buf.position()) != (byte) 0xff);

			} else if (b == (byte) 0x82) { // level, mon, item

				do {
					f = buf.get(buf.position());
					f *= (float) ((100 + Settings.kantoLevelBump)) / 100;
					buf.put((byte) f);
					buf.position(buf.position() + 2);
				} while (buf.get(buf.position()) != (byte) 0xff);
			}

		} while (buf.remaining() > 1);
	}

	public static void randomizeParties(ByteBuffer buf) {

		if (!Settings.randomizeTrainerPokemon) return;

		buf.rewind();

		int[] paramsNames = {1, 0, 1};
		int[] paramsWithoutItem = {1, 1, 1};
		int[] paramsWithItem = {1, 1, 1,  1, 0, 1};

		for (int i = 0; i < Constants.NUM_TRAINERS; i ++) {
			buf = RandomizePokemon.randomize(buf, paramsNames, (byte) 0x50, 1, true);
			if ((buf.get() & 0x7f) == 0x00) {
				buf = RandomizePokemon.randomize(buf, paramsWithoutItem, (byte) 0xff, 1, true);
			} else {
				buf = RandomizePokemon.randomize(buf, paramsWithItem, (byte) 0xff, 2, true);
			}
		}
	}

}
