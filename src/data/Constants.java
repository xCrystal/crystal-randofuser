package data;

public class Constants {
	
	public static final int ROM_SIZE = 0x200000;
	
	public static final String FILE_NAME_IN  = "crystal.gbc";
	public static final String FILE_NAME_OUT = "crystal_randofused.gbc";
	
	public static final int NUM_POKEMON = Pokemon.CELEBI.ordinal() - Pokemon.BULBASAUR.ordinal();
	
	public static final int EVOS_ATTACKS = 0x44000;
	public static final int EGG_MOVES = 0x1d4000;
	public static final int BASE_DATA = 0x51424;
	public static final int NAMES = 0x53384;

	public static final int EVOS_ATTACKS_LENGTH = 0x31;
	public static final int EGG_MOVES_LENGTH = 19;
	public static final int BASE_DATA_LENGTH = 0x20;
	public static final int NAMES_LENGTH = 10;
	
	public enum BaseDataOffsets {
		
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
		
		BaseDataOffsets (int offset) {
			this.offset = offset;
		}

		public int getOffset() {
			return offset;
		}

	}

}

/*
14:5425 BaseData0_Stats
14:5433 BaseData0_HatchCycles
14:5430 BaseData0_Item2
14:542F BaseData0_Item1
14:543A BaseData0_GrowthRate
14:543C BaseData0_TMHM
14:5431 BaseData0_Gender
14:543B BaseData0_EggGroups
14:542C BaseData0_Type2
14:542B BaseData0_Type1
14:542E BaseData0_BaseExp
14:542D BaseData0_CatchRate
*/