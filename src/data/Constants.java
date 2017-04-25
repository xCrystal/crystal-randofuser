package data;

public class Constants {
	
	public static final int ROM_SIZE = 0x200000;
	
	public static final String FILE_NAME_IN  = "crystal.gbc";
	public static final String FILE_NAME_OUT = "crystal_randofused.gbc";
	
	public static final int NUM_POKEMON = Pokemon.CELEBI.ordinal() - Pokemon.BULBASAUR.ordinal() + 1;
	public static final int NUM_STATS = 6;
	public static final int NUM_TYPES = 17;	
	
	public static final int EVOS_ATTACKS = 0x40000;
	public static final int EGG_MOVES = 0x1d4000;
	public static final int BASE_DATA = 0x51424;
	public static final int NAMES = 0x53384;
	public static final int PALETTES = 0xa8ce + 8;
	public static final int TRAINERS = 0x39a21;
	public static final int TRAINERS_END = 0x3b4f1;

	public static final int EVOS_ATTACKS_LENGTH = 0x31;
	public static final int EGG_MOVES_LENGTH = 19;
	public static final int BASE_DATA_LENGTH = 0x20;
	public static final int NAMES_LENGTH = 10;
	public static final int PALETTES_LENGTH = 8;
	
	public static final int NORMAL_T = 0;
	public static final int FIGHTING_T = 1;
	public static final int FLYING_T = 2;
	public static final int POISON_T = 3;
	public static final int GROUND_T = 4;
	public static final int ROCK_T = 5;
	public static final int BIRD_T = 6;
	public static final int BUG_T = 7;
	public static final int GHOST_T = 8;
	public static final int STEEL_T = 9;
	public static final int FIRE_T = 20;
	public static final int WATER_T = 21;
	public static final int GRASS_T = 22;
	public static final int ELECTRIC_T = 23;
	public static final int PSYCHIC_T = 24;
	public static final int ICE_T = 25;
	public static final int DRAGON_T = 26;
	public static final int DARK_T = 27;
	
	public static final byte MOON_STONE = 0x08;
	public static final byte FIRE_STONE = 0x16;
	public static final byte THUNDERSTONE = 0x17;
	public static final byte WATER_STONE = 0x18;
	public static final byte LEAF_STONE = 0x22;
	public static final byte SUN_STONE = (byte) 0xa2;

	public static final byte EVOLVE_LEVEL = 0x01;
	public static final byte EVOLVE_HAPPINESS = 0x04;
	public static final byte TR_MORNDAY = 0x02;
	public static final byte TR_NITE = 0x03;
	
	public static final int GOLDENROD_GAME_CORNER = 0x56db8 + 2;
	public static final int CELADON_GAME_CORNER = 0x7287f + 2;
	
	public enum BaseDataFields {
		
		STATS (0x51425 - 0x51424),
		TYPE_1 (0x5142b - 0x51424),
		TYPE_2 (0x5142c - 0x51424),
		CATCH_RATE (0x5142d - 0x51424),
		BASE_EXP (0x5142e - 0x51424),
		ITEM_1  (0x5142f - 0x51424),
		ITEM_2  (0x51430 - 0x51424),
		GENDER (0x51431 - 0x51424),
		HATCH_CYCLES (0x51433 - 0x51424),	
		GROWTH_RATE (0x5143a - 0x51424),	
		EGG_GROUPS (0x5143b - 0x51424),
		TMHM (0x5143c - 0x51424);
		
		private int offset;
		
		BaseDataFields (int offset) {
			this.offset = offset;
		}

		public int getOffset() {
			return offset;
		}
	}
	
	public enum EvolutionCategories {
		
		EVOLVE_NONE,
		EVOLVE_LEVEL,
		EVOLVE_ITEM,
		EVOLVE_TRADE,
		EVOLVE_HAPPINESS,
		EVOLVE_STAT;
	}
	
	public enum GrowthRates {
		
		MEDIUM, // 1M
		SLIGHTLY_FAST, // 0.89M (8/9)
		SLIGHTLY_SLOW, // 1.11M (10/9)
		PARABOLIC, // 1.06M (parabolic)
		FAST, // 0.8M
		SLOW;  // 1.25M
	}
	
}
