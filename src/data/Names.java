package data;

import java.nio.charset.StandardCharsets;

public enum Names {

	BULBASAUR  ("BULB<",  "ASAUR<"),
	IVYSAUR    ("IVYS<",  "YSAUR<"),
	VENUSAUR   ("VENUS<", "USAUR<"),
	CHARMANDER ("CHAR<",  "ANDER<"),
	CHARMELEON ("CHAR<",  "ELEON<"),
	CHARIZARD  ("CHAR<",  "IZARD<"),
	SQUIRTLE   ("SQUIR<", "IRTLE<"),
	WARTORTLE  ("WART<",  "ORTLE<"),
	BLASTOISE  ("BLAST<", "TOISE<"),
	CATERPIE   ("CATER<", "ERPIE<"),
	METAPOD    ("METAP<", "TAPOD<"),
	BUTTERFREE ("BUT<",   "FREE<"),
	WEEDLE     ("WEED<",  "EEDLE<"),
	KAKUNA     ("KAKUN<", "AKUNA<"),
	BEEDRILL   ("BEED<",  "DRILL<"),
	PIDGEY     ("PIDG<",  "IDGEY<"),
	PIDGEOTTO  ("PIDG<",  "EOTTO<"),
	PIDGEOT    ("PIDG<",  "GEOT<"),
	RATTATA    ("RAT<",   "TATA<"),
	RATICATE   ("RATIC<", "CATE<"),
	SPEAROW    ("SPEAR<", "EAROW<"),
	FEAROW     ("FEAR<",  "AROW<"),
	EKANS      ("EKAN<",  "EKANS<"),
	ARBOK      ("ARB<",   "ARBOK<"),
	PIKACHU    ("PIK<",   "ACHU<"),
	RAICHU     ("RAICH<", "AICHU<"),
	SANDSHREW  ("SAND<",  "HREW<"),
	SANDSLASH  ("SAND<",  "LASH<"),
	NIDORAN_F  ("NIDOR<", "ORANf<"),
	NIDORINA   ("NIDOR<", "ORINA<"),
	NIDOQUEEN  ("NIDOQ<", "QUEEN<"),
	NIDORAN_M  ("NIDOR<", "ORANm<"),
	NIDORINO   ("NIDOR<", "ORINO<"),
	NIDOKING   ("NIDOK<", "OKING<"),
	CLEFAIRY   ("CLEF<",  "AIRY<"),
	CLEFABLE   ("CLEF<",  "ABLE<"),
	VULPIX     ("VUL<",   "ULPIX<"),
	NINETALES  ("NINET<", "ALES<"),
	JIGGLYPUFF ("JIGG<",  "YPUFF<"),
	WIGGLYTUFF ("WIGG<",  "YTUFF<"),
	ZUBAT      ("ZUB<",   "UBAT<"),
	GOLBAT     ("GOL<",   "OLBAT<"),
	ODDISH     ("ODD<",   "DISH<"),
	GLOOM      ("GLOOM<", "LOOM<"),
	VILEPLUME  ("VILEP<", "LUME<"),
	PARAS      ("PARAS<", "ARAS<"),
	PARASECT   ("PARAS<", "ASECT<"),
	VENONAT    ("VENON<", "ONAT<"),
	VENOMOTH   ("VENOM<", "OMOTH<"),
	DIGLETT    ("DIG<",   "LETT<"),
	DUGTRIO    ("DUG<",   "TRIO<"),
	MEOWTH     ("MEOW<",  "EOWTH<"),
	PERSIAN    ("PERS<",  "SIAN<"),
	PSYDUCK    ("PSYD<",  "YDUCK<"),
	GOLDUCK    ("GOLD<",  "DUCK<"),
	MANKEY     ("MANK<",  "ANKEY<"),
	PRIMEAPE   ("PRIM<",  "EAPE<"),
	GROWLITHE  ("GROWL<", "ITHE<"),
	ARCANINE   ("ARCAN<", "ANINE<"),
	POLIWAG    ("POLIW<", "IWAG<"),
	POLIWHIRL  ("POLIW<", "WHIRL<"),
	POLIWRATH  ("POLIW<", "WRATH<"),
	ABRA       ("ABR<",   "ABRA<"),
	KADABRA    ("KADAB<", "DABRA<"),
	ALAKAZAM   ("ALAK<",  "AZAM<"),
	MACHOP     ("MACH<",  "ACHOP<"),
	MACHOKE    ("MACH<",  "HOKE<"),
	MACHAMP    ("MACH<",  "CHAMP<"),
	BELLSPROUT ("BELLS<", "ROUT<"),
	WEEPINBELL ("WEEP<",  "BELL<"),
	VICTREEBEL ("VICT<",  "EEBEL<"),
	TENTACOOL  ("TENT<",  "ACOOL<"),
	TENTACRUEL ("TENT<",  "CRUEL<"),
	GEODUDE    ("GEOD<",  "ODUDE<"),
	GRAVELER   ("GRAV<",  "ELER<"),
	GOLEM      ("GOLEM<", "OLEM<"),
	PONYTA     ("PONYT<", "ONYTA<"),
	RAPIDASH   ("RAPID<", "IDASH<"),
	SLOWPOKE   ("SLOW<",  "POKE<"),
	SLOWBRO    ("SLOW<",  "OWBRO<"),
	MAGNEMITE  ("MAGN<",  "EMITE<"),
	MAGNETON   ("MAGN<",  "ETON<"),
	FARFETCH_D ("FARFE<", "TCH*D<"),
	DODUO      ("DOD<",   "ODUO<"),
	DODRIO     ("DODR<",  "ODRIO<"),
	SEEL       ("SEEL<",  "EEL<"),
	DEWGONG    ("DEWG<",  "GONG<"),
	GRIMER     ("GRIM<",  "IMER<"),
	MUK        ("MUK<",   "MUK<"),
	SHELLDER   ("SHEL<",  "LDER<"),
	CLOYSTER   ("CLOYS<", "YSTER<"),
	GASTLY     ("GAST<",  "ASTLY<"),
	HAUNTER    ("HAUNT<", "UNTER<"),
	GENGAR     ("GENG<",  "ENGAR<"),
	ONIX       ("ONIX<",  "ONIX<"),
	DROWZEE    ("DROWZ<", "OWZEE<"),
	HYPNO      ("HYPN<",  "YPNO<"),
	KRABBY     ("KRAB<",  "ABBY<"),
	KINGLER    ("KING<",  "GLER<"),
	VOLTORB    ("VOLT<",  "TORB<"),
	ELECTRODE  ("ELECT<", "RODE<"),
	EXEGGCUTE  ("EXEG<",  "CUTE<"),
	EXEGGUTOR  ("EXEG<",  "UTOR<"),
	CUBONE     ("CUBON<", "UBONE<"),
	MAROWAK    ("MAROW<", "OWAK<"),
	HITMONLEE  ("HITMO<", "LEE<"),
	HITMONCHAN ("HITMO<", "CHAN<"),
	LICKITUNG  ("LICKI<", "TUNG<"),
	KOFFING    ("KOF<",   "FING<"),
	WEEZING    ("WEEZ<",  "ZING<"),
	RHYHORN    ("RHYH<",  "YHORN<"),
	RHYDON     ("RHYD<",  "YDON<"),
	CHANSEY    ("CHANS<", "ANSEY<"),
	TANGELA    ("TANGE<", "GELA<"),
	KANGASKHAN ("KANGA<", "SKHAN<"),
	HORSEA     ("HORS<",  "ORSEA<"),
	SEADRA     ("SEADR<", "EADRA<"),
	GOLDEEN    ("GOLD<",  "DEEN<"),
	SEAKING    ("SEAK<",  "AKING<"),
	STARYU     ("STAR<",  "ARYU<"),
	STARMIE    ("STARM<", "ARMIE<"),
	MR__MIME   ("MR. <", "MIME<"),
	SCYTHER    ("SCYTH<", "YTHER<"),
	JYNX       ("JYNX<",  "JYNX<"),
	ELECTABUZZ ("ELE<",   "BUZZ<"),
	MAGMAR     ("MAGMA<", "GMAR<"),
	PINSIR     ("PINSI<", "NSIR<"),
	TAUROS     ("TAURO<", "UROS<"),
	MAGIKARP   ("MAGIK<", "IKARP<"),
	GYARADOS   ("GYAR<",  "ADOS<"),
	LAPRAS     ("LAPRA<", "PRAS<"),
	DITTO      ("DITTO<", "DITTO<"),
	EEVEE      ("EEV<",   "EEVEE<"),
	VAPOREON   ("VAPOR<", "OREON<"),
	JOLTEON    ("JOLTE<", "TEON<"),
	FLAREON    ("FLARE<", "AREON<"),
	PORYGON    ("PORYG<", "YGON<"),
	OMANYTE    ("OMAN<",  "ANYTE<"),
	OMASTAR    ("OMAS<",  "ASTAR<"),
	KABUTO     ("KABUT<", "ABUTO<"),
	KABUTOPS   ("KABUT<", "UTOPS<"),
	AERODACTYL ("AERO<",  "CTYL<"),
	SNORLAX    ("SNO<",   "RLAX<"),
	ARTICUNO   ("ARTI<",  "CUNO<"),
	ZAPDOS     ("ZAPDO<", "PDOS<"),
	MOLTRES    ("MOL<",   "TRES<"),
	DRATINI    ("DRAT<",  "ATINI<"),
	DRAGONAIR  ("DRAG<",  "ONAIR<"),
	DRAGONITE  ("DRAG<",  "ONITE<"),
	MEWTWO     ("MEW<",   "WTWO<"),
	MEW        ("MEW<",   "MEW<"),
	CHIKORITA  ("CHIK<",  "ORITA<"),
	BAYLEEF    ("BAYL<",  "YLEEF<"),
	MEGANIUM   ("MEGAN<", "ANIUM<"),
	CYNDAQUIL  ("CYND<",  "AQUIL<"),
	QUILAVA    ("QUIL<",  "ILAVA<"),
	TYPHLOSION ("TYPH<",  "OSION<"),
	TOTODILE   ("TOTOD<", "ODILE<"),
	CROCONAW   ("CROC<",  "ONAW<"),
	FERALIGATR ("FERAL<", "IGATR<"),
	SENTRET    ("SENT<",  "TRET<"),
	FURRET     ("FUR<",   "URRET<"),
	HOOTHOOT   ("HOOT<",  "HOOT<"),
	NOCTOWL    ("NOCT<",  "TOWL<"),
	LEDYBA     ("LEDYB<", "EDYBA<"),
	LEDIAN     ("LED<",   "EDIAN<"),
	SPINARAK   ("SPIN<",  "ARAK<"),
	ARIADOS    ("ARIAD<", "IADOS<"),
	CROBAT     ("CROB<",  "OBAT<"),
	CHINCHOU   ("CHIN<",  "CHOU<"),
	LANTURN    ("LANT<",  "TURN<"),
	PICHU      ("PICH<",  "ICHU<"),
	CLEFFA     ("CLEF<",  "EFFA<"),
	IGGLYBUFF  ("IGGL<",  "YBUFF<"),
	TOGEPI     ("TOGEP<", "OGEPI<"),
	TOGETIC    ("TOGET<", "ETIC<"),
	NATU       ("NAT<",   "ATU<"),
	XATU       ("XAT<",   "XATU<"),
	MAREEP     ("MAR<",   "AREEP<"),
	FLAAFFY    ("FLAAF<", "AAFFY<"),
	AMPHAROS   ("AMPH<",  "AROS<"),
	BELLOSSOM  ("BELLO<", "SSOM<"),
	MARILL     ("MARIL<", "ARILL<"),
	AZUMARILL  ("AZUM<",  "ARILL<"),
	SUDOWOODO  ("SUDO<",  "WOODO<"),
	POLITOED   ("POLI<",  "TOED<"),
	HOPPIP     ("HOP<",   "OPPIP<"),
	SKIPLOOM   ("SKIP<",  "PLOOM<"),
	JUMPLUFF   ("JUMP<",  "LUFF<"),
	AIPOM      ("AIPO<",  "POM<"),
	SUNKERN    ("SUNK<",  "KERN<"),
	SUNFLORA   ("SUNF<",  "LORA<"),
	YANMA      ("YANMA<", "YANMA<"),
	WOOPER     ("WOOP<",  "OOPER<"),
	QUAGSIRE   ("QUAG<",  "SIRE<"),
	ESPEON     ("ESPE<",  "PEON<"),
	UMBREON    ("UMBRE<", "BREON<"),
	MURKROW    ("MUR<",   "KROW<"),
	SLOWKING   ("SLOW<",  "KING<"),
	MISDREAVUS ("MIS<",   "AVUS<"),
	UNOWN      ("UN<",    "OWN<"),
	WOBBUFFET  ("WOBBU<", "FFET<"),
	GIRAFARIG  ("GIRA<",  "FARIG<"),
	PINECO     ("PINEC<", "INECO<"),
	FORRETRESS ("FORR<",  "TRESS<"),
	DUNSPARCE  ("DUN<",   "PARCE<"),
	GLIGAR     ("GLI<",   "LIGAR<"),
	STEELIX    ("STEEL<", "EELIX<"),
	SNUBBULL   ("SNUB<",  "BULL<"),
	GRANBULL   ("GRAN<",  "NBULL<"),
	QWILFISH   ("QUI<",   "FISH<"),
	SCIZOR     ("SCIZ<",  "IZOR<"),
	SHUCKLE    ("SHU<",   "CKLE<"),
	HERACROSS  ("HERA<",  "CROSS<"),
	SNEASEL    ("SNEA<",  "ASEL<"),
	TEDDIURSA  ("TED<",   "IURSA<"),
	URSARING   ("URSAR<", "ARING<"),
	SLUGMA     ("SLUG<",  "UGMA<"),
	MAGCARGO   ("MAG<",   "ARGO<"),
	SWINUB     ("SWIN<",  "INUB<"),
	PILOSWINE  ("PILOS<", "WINE<"),
	CORSOLA    ("CORSO<", "SOLA<"),
	REMORAID   ("REMOR<", "ORAID<"),
	OCTILLERY  ("OCTIL<", "LERY<"),
	DELIBIRD   ("DELI<",  "BIRD<"),
	MANTINE    ("MANTI<", "TINE<"),
	SKARMORY   ("SKA<",   "MORY<"),
	HOUNDOUR   ("HOUND<", "DOUR<"),
	HOUNDOOM   ("HOUND<", "DOOM<"),
	KINGDRA    ("KING<",  "DRA<"),
	PHANPY     ("PHAN<",  "ANPY<"),
	DONPHAN    ("DONPH<", "PHAN<"),
	PORYGON2   ("PORYG<", "YGON2<"),
	STANTLER   ("STA<",   "TLER<"),
	SMEARGLE   ("SMEA<",  "RGLE<"),
	TYROGUE    ("TYROG<", "OGUE<"),
	HITMONTOP  ("HIT<",   "TOP<"),
	SMOOCHUM   ("SMOOC<", "OCHUM<"),
	ELEKID     ("ELEK<",  "EKID<"),
	MAGBY      ("MAG<",   "AGBY<"),
	MILTANK    ("MIL<",   "TANK<"),
	BLISSEY    ("BLIS<",  "ISSEY<"),
	RAIKOU     ("RAI<",   "KOU<"),
	ENTEI      ("ENTE<",  "TEI<"),
	SUICUNE    ("SUICU<", "CUNE<"),
	LARVITAR   ("LARV<",  "ITAR<"),
	PUPITAR    ("PUPIT<", "PITAR<"),
	TYRANITAR  ("TYRAN<", "NITAR<"),
	LUGIA      ("LUGI<",  "LUGIA<"),
	HO_OH      ("HO-<",   "-OH<"),
	CELEBI     ("CELE<",  "LEBI<"),
	NONE       ("", "");
	
	private String prefix;
	private String suffix;

	Names (String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public byte[] getPrefix() {
		
		byte[] bytes = prefix.getBytes(StandardCharsets.US_ASCII);
		
		int i = 0;
		for (byte b : bytes) {
			
			if (b == '.') b = (byte) 0xe8;
			else if (b == ' ') b = (byte) 0x7f;
			else if (b == '-') b = (byte) 0xe3;
			else if (b == '<') b = (byte) 0x50;
			else b += 0x3f;
			
			bytes[i] = b;
			i ++;
		}
		
		return bytes;
	}
	
	public byte[] getSuffix() {
		
		byte[] bytes = suffix.getBytes(StandardCharsets.US_ASCII);
		
		int i = 0;
		for (byte b : bytes) {

			if (b == 'f') b = (byte) 0xf5;
			else if (b == 'm') b = (byte) 0xef;
			else if (b == '*') b = (byte) 0xe0;
			else if (b == '-') b = (byte) 0xe3;
			else if (b == '2') b = (byte) 0xf8;
			else if (b == '<') b = (byte) 0x50;
			else b += 0x3f;
			
			bytes[i] = b;
			i ++;
		}
		
		return bytes;
	}
	
}
