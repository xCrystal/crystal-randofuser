# Pokemon Crystal Randofuser

This is a special randomizer tool compatible with Pokemon Crystal. It fuses each Pokemon with another
existing one at random with matching evolution stage. All the data and characteristics of the
Pokemon such as moves and base stats are combined in different ways, as described below.

## How Pokemon data gets fused

The base Pokemon retains the Pokedex number, sprite, cry, and first half of the name, while the secondary
Pokemon can be identified by its palette and second half of its name. Each Pokemon has been assigned a prefix and a
suffix so that the names are properly merged and the secondary Pokemon can be easily identified.

#### <b>Evolutions</b>
Pokemon will only be merged with another Pokemon of the same evolution category. For example, Charmander might
be fused with a Mareep, but not with an Ekans. The combinations will be consistent across an evolutionary line; say Venonat 
is merged with Slugma, then Venomoth will be merged with Magcargo. Evolution categories can be further filtered before the randomization,
for example to make Legendary Pokemon independent from other 1/1 evolution Pokemon.

Branched evolutions have been removed. Which Pokemon retains its evolutionary line is selectable. For example, if the user
chooses Politoed to be the evolution of Poliwhril, Poliwrath will be independent and will be merged with another independent Pokemon
like Heracross or Mr. Mime. Note that the independent Pokemon will be unobtainable due to not appearing as a wild Pokemon.

Trade evolutions have been replaced with reasonable level-based evolutions. If two Pokemon with level-based evolutions are fused, the
resulting Pokemon will evolve at the average of the two. If either Pokemon evolves through other method (happiness, stone), the evolution
type of the base Pokemon will be tranferred unchanged.

#### <b>Types</b>
The first type of the base Pokemon will always be chosen as the first type of the resulting Pokemon. The secondary type will 
be taken from the first type of the secondary Pokemon, unless the types match. If so, a secondary type of one of the fused 
Pokemon will be used, if possible. For example, Nidorino plus Gloom will yield a Poison/Grass Pokemon while Lanturn fused with
Gyarados will output a Water/Electric Pokemon. Marill fused with Goldeen will simply yield a Water-type Pokemon.

In all cases, Normal/Flying Pokemon are treated as Flying/Normal Pokemon instead. For example, Pidgey plus Machop will turn 
into a Flying/Fighting Pokemon.

#### <b>Moves</b>
Learnsets are combined, including level-up, egg, and TM/HM moves. For example, if Cyndaquil gets fused with Gastly, it will learn Ember at level 12 and Mean Look at level 13, and will be able to learn both Fire Blast and Shadow Ball via TM. Moreover, level-up moves are arranged by level. When the moveset of a wild or trainer Pokemon is filled, it will end up with the last four moves that the two original Pokemon could learn by that level. For example, a level 30 "Gyarasect", will show up with Bite, Dragon Rage, Spore and Leer. Trainers no longer may have custom movesets.

Pokemon such as Raichu, Arcanine or Starmie that could only learn a subset of moves compared to their pre-evolutions have had their movesets updated to match the moves learnable by their pre-evolutions, although with a small level delay similar to the patterns found in other evolved Pokemon.

#### <b>Base Stats</b>
The user can choose wether each Base Stat is averaged or whether only the base stat patterns are averaged, keeping the BST (base stat total) of the base Pokemon unchanged. The second option differs from the first in that the resulting values of the base stats are then multiplied by a "BST factor", which is the quotient of the BST of the base Pokemon and the BST of the secondary Pokemon. This way, trainer and wild Pokemon can keep their original strength.

#### <b>Growth rates</b>
If 'average base stat patterns only' is chosen, the Growth Rate of the base Pokemon is retained. Otherwise, if either Pokemon's Growth Rate is parabolic, the base's Pokemon Growth Rate is also retained. The parabolic Growth Rate is a special one related to Pokemon that appear early in the game (such as the starters) in order to make them grow fast at lower levels and slow-ish at higher levels. Otherwise, that is, when the Growth Rates of both original Pokemon are linear, and the experience requirement to grow levels is averaged, introducing two sub-types of Growth Rates for this purpose.

Additioanlly, there is a selectable option to homogenize the Growth Rates, ignoring all the other rules. This option will make all Pokemon use a custom Growth Rate with characteristics from both the parabolic and fast growth rates. It makes all Pokemon grow relatively fast at all level ranges, which is ideal to soften any necessity of grinding.

#### <b>Other data</b>
- Base Experience: the average of the two original Pokemon. If 'average base stat patterns only' is selected, the base experience value of the base Pokemon weighs 80% of the total.
- Catch Rates: calculated with the geometric mean of the catch rate of the original Pokemon, i.e. the square root of the product of the two values.  If 'average base stat patterns only' is selected, the catch rate value of the base Pokemon weighs 80% of the total.
- Gender: the average of the two original Pokemon. For example, if one Pokemon has a 2/16 chance to be female and the other Pokemon a 8/16 chance, the resulting Pokemon will be female 5/16 of the times.
- Wild Held Items: follow the same logic used to obtain the types
- Egg Groups: follow the same logic used to obtain the types
- Hatch Cycles: the average of the two orginal Pokemon. If 'average base stat patterns only' is selected, the hatch cycles value of the base Pokemon weighs 80% of the total.
