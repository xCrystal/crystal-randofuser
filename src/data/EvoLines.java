package data;

public enum EvoLines {

	_BULBASAUR  (Pokemon.BULBASAUR,  Pokemon.IVYSAUR,    Pokemon.VENUSAUR),
	_CHARMANDER (Pokemon.CHARMANDER, Pokemon.CHARMELEON, Pokemon.CHARIZARD),
	_SQUIRTLE   (Pokemon.SQUIRTLE,   Pokemon.WARTORTLE,  Pokemon.BLASTOISE),
	_CATERPIE   (Pokemon.CATERPIE,   Pokemon.METAPOD,    Pokemon.BUTTERFREE),
	_WEEDLE     (Pokemon.WEEDLE,     Pokemon.KAKUNA,     Pokemon.BEEDRILL),
	_PIDGEY     (Pokemon.PIDGEY,     Pokemon.PIDGEOTTO,  Pokemon.PIDGEOT),
	_RATTATA    (Pokemon.RATTATA,    Pokemon.RATICATE,   Pokemon.NONE),
	_SPEAROW    (Pokemon.SPEAROW,    Pokemon.FEAROW,     Pokemon.NONE),
	_EKANS      (Pokemon.EKANS,      Pokemon.ARBOK,      Pokemon.NONE),
	_SANDSHREW  (Pokemon.SANDSHREW,  Pokemon.SANDSLASH,  Pokemon.NONE),
	_NIDORAN_F  (Pokemon.NIDORAN_F,  Pokemon.NIDORINA,   Pokemon.NIDOQUEEN),
	_NIDORAN_M  (Pokemon.NIDORAN_M,  Pokemon.NIDORINO,   Pokemon.NIDOKING),
	_VULPIX     (Pokemon.VULPIX,     Pokemon.NINETALES,  Pokemon.NONE),
	_ODDISH     (Pokemon.ODDISH,     Pokemon.GLOOM,      Pokemon.VILEPLUME),
	_PARAS      (Pokemon.PARAS,      Pokemon.PARASECT,   Pokemon.NONE),
	_VENONAT    (Pokemon.VENONAT,    Pokemon.VENOMOTH,   Pokemon.NONE),
	_DIGLETT    (Pokemon.DIGLETT,    Pokemon.DUGTRIO,    Pokemon.NONE),
	_MEOWTH     (Pokemon.MEOWTH,     Pokemon.PERSIAN,    Pokemon.NONE),
	_PSYDUCK    (Pokemon.PSYDUCK,    Pokemon.GOLDUCK,    Pokemon.NONE),
	_MANKEY     (Pokemon.MANKEY,     Pokemon.PRIMEAPE,   Pokemon.NONE),
	_GROWLITHE  (Pokemon.GROWLITHE,  Pokemon.ARCANINE,   Pokemon.NONE),
	_POLIWAG    (Pokemon.POLIWAG,    Pokemon.POLIWHIRL,  Pokemon.POLIWRATH),
	_ABRA       (Pokemon.ABRA,       Pokemon.KADABRA,    Pokemon.ALAKAZAM),
	_MACHOP     (Pokemon.MACHOP,     Pokemon.MACHOKE,    Pokemon.MACHAMP),
	_BELLSPROUT (Pokemon.BELLSPROUT, Pokemon.WEEPINBELL, Pokemon.VICTREEBEL),
	_TENTACOOL  (Pokemon.TENTACOOL,  Pokemon.TENTACRUEL, Pokemon.NONE),
	_GEODUDE    (Pokemon.GEODUDE,    Pokemon.GRAVELER,   Pokemon.GOLEM),
	_PONYTA     (Pokemon.PONYTA,     Pokemon.RAPIDASH,   Pokemon.NONE),
	_SLOWPOKE   (Pokemon.SLOWPOKE,   Pokemon.SLOWBRO,    Pokemon.NONE),
	_MAGNEMITE  (Pokemon.MAGNEMITE,  Pokemon.MAGNETON,   Pokemon.NONE),
	_FARFETCH_D (Pokemon.FARFETCH_D ,Pokemon.NONE,       Pokemon.NONE),
	_DODUO      (Pokemon.DODUO,      Pokemon.DODRIO,     Pokemon.NONE),
	_SEEL       (Pokemon.SEEL,       Pokemon.DEWGONG,    Pokemon.NONE),
	_GRIMER     (Pokemon.GRIMER,     Pokemon.MUK,        Pokemon.NONE),
	_SHELLDER   (Pokemon.SHELLDER,   Pokemon.CLOYSTER,   Pokemon.NONE),
	_GASTLY     (Pokemon.GASTLY,     Pokemon.HAUNTER,    Pokemon.GENGAR),
	_ONIX       (Pokemon.ONIX,       Pokemon.STEELIX,    Pokemon.NONE),
	_DROWZEE    (Pokemon.DROWZEE,    Pokemon.HYPNO,      Pokemon.NONE),
	_KRABBY     (Pokemon.KRABBY,     Pokemon.KINGLER,    Pokemon.NONE),
	_VOLTORB    (Pokemon.VOLTORB,    Pokemon.ELECTRODE,  Pokemon.NONE),
	_EXEGGCUTE  (Pokemon.EXEGGCUTE,  Pokemon.EXEGGUTOR,  Pokemon.NONE),
	_CUBONE     (Pokemon.CUBONE,     Pokemon.MAROWAK,    Pokemon.NONE),
	_HITMONLEE  (Pokemon.HITMONLEE,  Pokemon.NONE,       Pokemon.NONE),
	_HITMONCHAN (Pokemon.HITMONCHAN, Pokemon.NONE,       Pokemon.NONE),
	_LICKITUNG  (Pokemon.LICKITUNG,  Pokemon.NONE,       Pokemon.NONE),
	_KOFFING    (Pokemon.KOFFING,    Pokemon.WEEZING,    Pokemon.NONE),
	_RHYHORN    (Pokemon.RHYHORN,    Pokemon.RHYDON,     Pokemon.NONE),
	_CHANSEY    (Pokemon.CHANSEY,    Pokemon.BLISSEY,    Pokemon.NONE),
	_TANGELA    (Pokemon.TANGELA,    Pokemon.NONE,       Pokemon.NONE),
	_KANGASKHAN (Pokemon.KANGASKHAN, Pokemon.NONE,       Pokemon.NONE),
	_HORSEA     (Pokemon.HORSEA,     Pokemon.SEADRA,     Pokemon.KINGDRA),
	_GOLDEEN    (Pokemon.GOLDEEN,    Pokemon.SEAKING,    Pokemon.NONE),
	_STARYU     (Pokemon.STARYU,     Pokemon.STARMIE,    Pokemon.NONE),
	_MR__MIME   (Pokemon.MR__MIME,   Pokemon.NONE,       Pokemon.NONE),
	_SCYTHER    (Pokemon.SCYTHER,    Pokemon.SCIZOR,     Pokemon.NONE),
	_PINSIR     (Pokemon.PINSIR,     Pokemon.NONE,       Pokemon.NONE),
	_TAUROS     (Pokemon.TAUROS,     Pokemon.NONE,       Pokemon.NONE),
	_MAGIKARP   (Pokemon.MAGIKARP,   Pokemon.GYARADOS,   Pokemon.NONE),
	_LAPRAS     (Pokemon.LAPRAS,     Pokemon.NONE,       Pokemon.NONE),
	_DITTO      (Pokemon.DITTO,      Pokemon.NONE,       Pokemon.NONE),
	_EEVEE      (Pokemon.EEVEE,      Pokemon.VAPOREON,   Pokemon.NONE),
	_JOLTEON    (Pokemon.JOLTEON,    Pokemon.NONE,       Pokemon.NONE),
	_FLAREON    (Pokemon.FLAREON,    Pokemon.NONE,       Pokemon.NONE),
	_PORYGON    (Pokemon.PORYGON,    Pokemon.PORYGON2,   Pokemon.NONE),
	_OMANYTE    (Pokemon.OMANYTE,    Pokemon.OMASTAR,    Pokemon.NONE),
	_KABUTO     (Pokemon.KABUTO,     Pokemon.KABUTOPS,   Pokemon.NONE),
	_AERODACTYL (Pokemon.AERODACTYL, Pokemon.NONE,       Pokemon.NONE),
	_SNORLAX    (Pokemon.SNORLAX,    Pokemon.NONE,       Pokemon.NONE),
	_ARTICUNO   (Pokemon.ARTICUNO,   Pokemon.NONE,       Pokemon.NONE),
	_ZAPDOS     (Pokemon.ZAPDOS,     Pokemon.NONE,       Pokemon.NONE),
	_MOLTRES    (Pokemon.MOLTRES,    Pokemon.NONE,       Pokemon.NONE),
	_DRATINI    (Pokemon.DRATINI,    Pokemon.DRAGONAIR,  Pokemon.DRAGONITE),
	_MEWTWO     (Pokemon.MEWTWO,     Pokemon.NONE,       Pokemon.NONE),
	_MEW        (Pokemon.MEW,        Pokemon.NONE,       Pokemon.NONE),
	_CHIKORITA  (Pokemon.CHIKORITA,  Pokemon.BAYLEEF,    Pokemon.MEGANIUM),
	_CYNDAQUIL  (Pokemon.CYNDAQUIL,  Pokemon.QUILAVA,    Pokemon.TYPHLOSION),
	_TOTODILE   (Pokemon.TOTODILE,   Pokemon.CROCONAW,   Pokemon.FERALIGATR),
	_SENTRET    (Pokemon.SENTRET,    Pokemon.FURRET,     Pokemon.NONE),
	_HOOTHOOT   (Pokemon.HOOTHOOT,   Pokemon.NOCTOWL,    Pokemon.NONE),
	_LEDYBA     (Pokemon.LEDYBA,     Pokemon.LEDIAN,     Pokemon.NONE),
	_SPINARAK   (Pokemon.SPINARAK,   Pokemon.ARIADOS,    Pokemon.NONE),
	_ZUBAT      (Pokemon.ZUBAT,      Pokemon.GOLBAT,     Pokemon.CROBAT),
	_CHINCHOU   (Pokemon.CHINCHOU,   Pokemon.LANTURN,    Pokemon.NONE),
	_PICHU      (Pokemon.PICHU,      Pokemon.PIKACHU,    Pokemon.RAICHU),
	_CLEFFA     (Pokemon.CLEFFA,     Pokemon.CLEFAIRY,   Pokemon.CLEFABLE),
	_IGGLYBUFF  (Pokemon.IGGLYBUFF,  Pokemon.JIGGLYPUFF, Pokemon.WIGGLYTUFF),
	_TOGEPI     (Pokemon.TOGEPI,     Pokemon.TOGETIC,    Pokemon.NONE),
	_NATU       (Pokemon.NATU,       Pokemon.XATU,       Pokemon.NONE),
	_MAREEP     (Pokemon.MAREEP,     Pokemon.FLAAFFY,    Pokemon.AMPHAROS),
	_BELLOSSOM  (Pokemon.BELLOSSOM,  Pokemon.NONE,       Pokemon.NONE),
	_MARILL     (Pokemon.MARILL,     Pokemon.AZUMARILL,  Pokemon.NONE),
	_SUDOWOODO  (Pokemon.SUDOWOODO,  Pokemon.NONE,       Pokemon.NONE),
	_POLITOED   (Pokemon.POLITOED,   Pokemon.NONE,       Pokemon.NONE),
	_HOPPIP     (Pokemon.HOPPIP,     Pokemon.SKIPLOOM,   Pokemon.JUMPLUFF),
	_AIPOM      (Pokemon.AIPOM,      Pokemon.NONE,       Pokemon.NONE),
	_SUNKERN    (Pokemon.SUNKERN,    Pokemon.SUNFLORA,   Pokemon.NONE),
	_YANMA      (Pokemon.YANMA,      Pokemon.NONE,       Pokemon.NONE),
	_WOOPER     (Pokemon.WOOPER,     Pokemon.QUAGSIRE,   Pokemon.NONE),
	_ESPEON     (Pokemon.ESPEON,     Pokemon.NONE,       Pokemon.NONE),
	_UMBREON    (Pokemon.UMBREON,    Pokemon.NONE,       Pokemon.NONE),
	_MURKROW    (Pokemon.MURKROW,    Pokemon.NONE,       Pokemon.NONE),
	_SLOWKING   (Pokemon.SLOWKING,   Pokemon.NONE,       Pokemon.NONE),
	_MISDREAVUS (Pokemon.MISDREAVUS, Pokemon.NONE,       Pokemon.NONE),
	_UNOWN      (Pokemon.UNOWN,      Pokemon.NONE,       Pokemon.NONE),
	_WOBBUFFET  (Pokemon.WOBBUFFET,  Pokemon.NONE,       Pokemon.NONE),
	_GIRAFARIG  (Pokemon.GIRAFARIG,  Pokemon.NONE,       Pokemon.NONE),
	_PINECO     (Pokemon.PINECO,     Pokemon.FORRETRESS, Pokemon.NONE),
	_DUNSPARCE  (Pokemon.DUNSPARCE,  Pokemon.NONE,       Pokemon.NONE),
	_GLIGAR     (Pokemon.GLIGAR,     Pokemon.NONE,       Pokemon.NONE),
	_SNUBBULL   (Pokemon.SNUBBULL,   Pokemon.GRANBULL,   Pokemon.NONE),
	_QWILFISH   (Pokemon.QWILFISH,   Pokemon.NONE,       Pokemon.NONE),
	_SCIZOR     (Pokemon.NONE,       Pokemon.NONE,       Pokemon.NONE),
	_SHUCKLE    (Pokemon.SHUCKLE,    Pokemon.NONE,       Pokemon.NONE),
	_HERACROSS  (Pokemon.HERACROSS,  Pokemon.NONE,       Pokemon.NONE),
	_SNEASEL    (Pokemon.SNEASEL,    Pokemon.NONE,       Pokemon.NONE),
	_TEDDIURSA  (Pokemon.TEDDIURSA,  Pokemon.URSARING,   Pokemon.NONE),
	_SLUGMA     (Pokemon.SLUGMA,     Pokemon.MAGCARGO,   Pokemon.NONE),
	_SWINUB     (Pokemon.SWINUB,     Pokemon.PILOSWINE,  Pokemon.NONE),
	_CORSOLA    (Pokemon.CORSOLA,    Pokemon.NONE,       Pokemon.NONE),
	_REMORAID   (Pokemon.REMORAID,   Pokemon.OCTILLERY,  Pokemon.NONE),
	_DELIBIRD   (Pokemon.DELIBIRD,   Pokemon.NONE,       Pokemon.NONE),
	_MANTINE    (Pokemon.MANTINE,    Pokemon.NONE,       Pokemon.NONE),
	_SKARMORY   (Pokemon.SKARMORY,   Pokemon.NONE,       Pokemon.NONE),
	_HOUNDOUR   (Pokemon.HOUNDOUR,   Pokemon.HOUNDOOM,   Pokemon.NONE),
	_PHANPY     (Pokemon.PHANPY,     Pokemon.DONPHAN,    Pokemon.NONE),
	_STANTLER   (Pokemon.STANTLER,   Pokemon.NONE,       Pokemon.NONE),
	_SMEARGLE   (Pokemon.SMEARGLE,   Pokemon.NONE,       Pokemon.NONE),
	_TYROGUE    (Pokemon.TYROGUE,    Pokemon.HITMONTOP,  Pokemon.NONE),
	_SMOOCHUM   (Pokemon.SMOOCHUM,   Pokemon.JYNX,       Pokemon.NONE),
	_ELEKID     (Pokemon.ELEKID,     Pokemon.ELECTABUZZ, Pokemon.NONE),
	_MAGBY      (Pokemon.MAGBY,      Pokemon.MAGMAR,     Pokemon.NONE),
	_MILTANK    (Pokemon.MILTANK,    Pokemon.NONE,       Pokemon.NONE),
	_RAIKOU     (Pokemon.RAIKOU,     Pokemon.NONE,       Pokemon.NONE),
	_ENTEI      (Pokemon.ENTEI,      Pokemon.NONE,       Pokemon.NONE),
	_SUICUNE    (Pokemon.SUICUNE,    Pokemon.NONE,       Pokemon.NONE),
	_LARVITAR   (Pokemon.LARVITAR,   Pokemon.PUPITAR,    Pokemon.TYRANITAR),
	_LUGIA      (Pokemon.LUGIA,      Pokemon.NONE,       Pokemon.NONE),
	_HO_OH      (Pokemon.HO_OH,      Pokemon.NONE,       Pokemon.NONE),
	_CELEBI     (Pokemon.CELEBI,     Pokemon.NONE,       Pokemon.NONE);

	private Pokemon pkmn1;
	private Pokemon pkmn2;
	private Pokemon pkmn3;

	EvoLines (Pokemon pkmn1, Pokemon pkmn2, Pokemon pkmn3) {
		this.setPkmn1(pkmn1);
		this.setPkmn2(pkmn2);
		this.setPkmn3(pkmn3);
	}

	public Pokemon getPkmn1() {
		return pkmn1;
	}

	public void setPkmn1(Pokemon pkmn1) {
		this.pkmn1 = pkmn1;
	}

	public Pokemon getPkmn2() {
		return pkmn2;
	}

	public void setPkmn2(Pokemon pkmn2) {
		this.pkmn2 = pkmn2;
	}

	public Pokemon getPkmn3() {
		return pkmn3;
	}

	public void setPkmn3(Pokemon pkmn3) {
		this.pkmn3 = pkmn3;
	}

}
