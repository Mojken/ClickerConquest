# ClickerConquest

##Multiplayer vers. style clicker game themed around medieval warfare on a battlefield.

Income:
Killing creeps
Gained from killing the opponent’s creeps on the battlefield.
The money gained from killing a creep is a exponential function of the cost of the creep, influenced by Karma and Idols (and potential creeps or something of the sort).

Funding, a slow income based on multiple factors, such as cost of relevant units, time into game, Idols, DPS, Karma, potential other units

###Expense:
Training units
Sends units out to the Battlefield, killing opponent creeps. Each unit has a HP and are essential for survival. Each unit has different stats. The stats are: HP, Defense, Regen (?), Aggro, Build Karma, critical chance and Attack speed.

###Ascension:
Piece treaty
Both get (100 + f(Karma))% of the points they are alleged to and get to spend them in their kingdom. Triggered by a mutual agreement and costs money to suggest.

Loss / Win
Winner gets (100 + f(Karma))% + 25% of their opponent’s points. Loser gets (75 + f(Karma))% of their alleged points. Triggered by either player reaching 0 HP.

###Spending AP
Idols, entities that give a permanent bonus to a variety of different stats - one per idol. They reside in buildings that must be bought for AP, the price for those growing exponentially. Each building houses a set of idols related to each other in either visuals of effects, and also grow exponentially in price per idol owned in each set, but different sets do not affect each other. The later you get a set, the more expensive the idols in it are going to be.
I.E: The equation would look something like price = f(f(\# of owned houses) * f(\# of owned Idols in same house))

###Currencies:
Default gold, used for units.

AP, gotten from multiple variables when peace is initiated.

Karma, A variable affected by every action, affecting every action. Should have an impact, however small, on every equation relevant enough. Karma does not need to be displayed, but if displayed, it should be arbitrary - such as a percentage of how much of the current karma, shared between you and your opponent, is yours.

###Skill Tree:
Experience, gotten in a “different” way, spent in a skill-tree.

###Health management:
HP, depleted by specific low-HP, high-aggro (siege) units when no other units are present on your side. When depleted loss is triggered. Win is triggered if opponent’s HP is depleted. Unreplenishable.

Unit's HP, much lower than the players' HP. When depleted unit dies. Each unit has a different base HP.

DPS, the total damage currently being dealt per second by your units. Lowers opponent's units' HP.

##Specifics

###Idols:

\#	Name:		Effect:
1	Corinthians			Lowers the cost of units to train.
2	Rán					Increases money yealed from killing creeps.
1	Clementia			Decreases Karma loss
1	Eucleia				Increases Karma gain
2	Lofn				Decreased Karma's bad influences		}
2	Ullr				Increases Karma's good influences		} - Could be separate Idols for each influence, or one for everything
3	Houyi				Increases ranged damage
2	Gersemi				Increases starter gold					- Could potentially ruin everything if this gets too serious, although, you can always click. Needs to stay rather insignificant either way
3	Caishen				Increases Funding
3	Hachiman			Increases each unit's DPS
1	Nemesis				Adds a base DPS - unrelated to units	- Ought to stay low, could ruin early-game. OR, we let these two remain, and just call people who don't get them Noobs, as they would fail miserably.
2	Hlín				Decreases damage taken					- Does not apply to units
3	Jurojin				Increases AP gain
						
1	Greek Mythology: 4
2	Norse Mythology: 5
3	Chinese Folklore and Shinto: 4
	
###Units:
Ranged units enhance clicks, have low aggro.
Siege units can attack the player, massive aggro.
Broodmothers spawn other units over time, middle-high aggro.

Basic cheap melee unit
Basic cheap ranged unit