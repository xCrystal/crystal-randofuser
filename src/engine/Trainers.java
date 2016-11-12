package engine;

import java.nio.ByteBuffer;

import data.Settings;

public class Trainers {

	public static void raiseLevels(ByteBuffer buf) {
		
		if (Settings.JohtoLevelBump == 0 && Settings.KantoLevelBump == 0) return;
		
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
					f *= (float) ((100 + Settings.JohtoLevelBump)) / 100;
					buf.put((byte) f);
					buf.position(buf.position() + 1);
				} while (buf.get(buf.position()) != (byte) 0xff);
			
			} else if (b == 0x02) { // level, mon, item
			
				do {
					f = buf.get(buf.position());
					f *= (float) ((100 + Settings.JohtoLevelBump)) / 100;
					buf.put((byte) f);
					buf.position(buf.position() + 2);
				} while (buf.get(buf.position()) != (byte) 0xff);
					
			// KANTO
			} else if (b == 0x80) { // level, mon
			
				do {
					f = buf.get(buf.position());
					f *= (float) ((100 + Settings.KantoLevelBump)) / 100;
					buf.put((byte) f);
					buf.position(buf.position() + 1);
				} while (buf.get(buf.position()) != (byte) 0xff);
			
			} else if (b == 0x82) { // level, mon, item
			
				do {
					f = buf.get(buf.position());
					f *= (float) ((100 + Settings.KantoLevelBump)) / 100;
					buf.put((byte) f);
					buf.position(buf.position() + 2);
				} while (buf.get(buf.position()) != (byte) 0xff);
			}
			
		} while (buf.remaining() > 1);
	}
	
}
