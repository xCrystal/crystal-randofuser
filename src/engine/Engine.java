package engine;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.JOptionPane;

import data.Constants;

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
		ch.read(bbRead);
		ch.position(pos);
		ch.read(bbWrite);
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
		checksum -= ((old_cs[0] + old_cs[1]) & 0xff);
		
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
