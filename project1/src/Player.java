
public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	
	private PlayerType type; 	//Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
	private double maxHP;		//Max HP of this player
	private double currentHP;	//Current HP of this player 
	private double atk;			//Attack power of this player
	
	private int SpecialTurn;    
	private int CurrentTurn = 0;    
	
	private boolean alive = true;   
	private boolean taunt = false; ;	
	private boolean sleep = false;    
	private boolean cursed = false;	
	private Player youcurse;
	
	private Arena.Team team; 
	private Arena.Row row; 
	private int PositionSet;
	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	
	public void setPosition(int position , Arena.Row row , Arena.Team team){
		this.PositionSet = position;
		this.row = row;
		this.team = team;
	}
	
	public Player(PlayerType _type){	
		//INSERT YOUR CODE HERE
		
		type = _type;
		atk = 0;
		maxHP = 0;
		currentHP = 0;
		
		switch(_type){
		case Healer:
			this.type = PlayerType.Healer;
			maxHP = 4790;
			currentHP = 4790;
			atk = 238;
			SpecialTurn = 4;
			break;
			
		case Tank:
			this.type = PlayerType.Tank;
			maxHP = 5340;
			currentHP = 5340;
			atk = 255;
			SpecialTurn = 4;
			break;
			
		case Samurai:
			this.type = PlayerType.Samurai;
			maxHP = 4005;
			currentHP = 4005;
			atk = 368;
			SpecialTurn = 3;
			break;
			
		case BlackMage:
			this.type = PlayerType.BlackMage;
			maxHP = 4175;
			currentHP = 4175;
			atk = 303;
			SpecialTurn = 4;
			break;
			
		case Phoenix:
			this.type = PlayerType.Phoenix;
			maxHP = 4175;
			currentHP = 4175;
			atk = 209;
			SpecialTurn = 8;
			break;
			
		case Cherry:
			this.type = PlayerType.Cherry;
			this.maxHP = 3560;
			this.currentHP = 3560;
			this.atk = 198;
			this.SpecialTurn = 4;
			break;
		}	
	}
	
	/**
	 * Returns the current HP of this player
	 * @return
	 */
	public double getCurrentHP(){
		//INSERT YOUR CODE HERE
		return currentHP;
	}
	
	/**
	 * Returns type of this player
	 * @return
	 */
	public Player.PlayerType getType(){
		//INSERT YOUR CODE HERE
		return type;
	}
	
	/**
	 * Returns max HP of this player. 
	 * @return
	 */
	public double getMaxHP(){
		//INSERT YOUR CODE HERE
		return maxHP;
	}
	
	/**
	 * Returns whether this player is sleeping.
	 * @return
	 */
	public boolean isSleeping(){
		//INSERT YOUR CODE HERE
		if(sleep){
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether this player is being cursed.
	 * @return
	 */
	public boolean isCursed(){
		//INSERT YOUR CODE HERE
		if(cursed){
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * @return
	 */
	public boolean isAlive(){
		//INSERT YOUR CODE HERE
		if(alive){
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether this player is taunting the other team.
	 * @return
	 */
	public boolean isTaunt(){
		//INSERT YOUR CODE HERE
		if(taunt){
			return true;
		}
		return false;
	}
	
	
	public void attack(Player target){	
		//INSERT YOUR CODE HERE
		target.currentHP -= this.atk; 
		if(target.currentHP <= 0){  //check that currentHP less than 0 or not 
			target.CurrentTurn = 0;
			target.currentHP = 0;
			target.alive = false;
			target.cursed = false;
			target.sleep = false;
			target.taunt = false;
			//if it 0 mean that the Player dead. So the currentHP will be 0.
		}
	}
	
	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam){	
		//INSERT YOUR CODE HERE
		Player target = null;
		
		switch(type){
		case Healer: 
			target = FindLowHP(myTeam);
			if(target.cursed == false && target.currentHP < target.maxHP && target != null){
				double upHP;
				upHP = 0.25 * target.maxHP; //increase 25% of maxHP 
				target.currentHP += upHP;
				
				if(target.currentHP > target.maxHP){
					target.currentHP = target.maxHP;
				}
				System.out.println("# "+this.playerInfo()+" Heals "+target.playerInfo());
			}
			break;
			
		case Tank: 
			taunt = true;
			System.out.println("# "+this.playerInfo()+" is taunting ");
			break;
			
		case Samurai:
			target = FindTarget(theirTeam);
			if(target != null){ //check that it is a target or not
				attack(target);
				attack(target);
				System.out.println("# "+this.playerInfo()+" Double-Slashes "+target.playerInfo());
			}
			break;
			
		case BlackMage:
			target = FindTarget(theirTeam);
			if(target != null){
				youcurse = target;
				target.cursed = true;
				System.out.println("# "+this.playerInfo()+" Curses "+target.playerInfo());
			}
			break;
			
		case Phoenix:
			target = DeadTeammate(myTeam);
			if(target != null){
				target.alive = true;
				target.currentHP = 0.30 * target.maxHP;
				target.CurrentTurn = 0;
				System.out.println("# "+this.playerInfo()+" Revives "+target.playerInfo());
			}
			break;
			
		case Cherry:
			for(int i = 0 ; i < 2 ; i++){
				for(int j = 0 ; j < theirTeam[i].length ; j++){
					if(theirTeam[i][j].alive){
						theirTeam[i][j].sleep = true;
						System.out.println("# "+this.playerInfo()+" Feed a fortune cookie to "+theirTeam[i][j].playerInfo());
					}
				}
			}
			break;
			
		default : 
			break;
		}
	}
	
	public static boolean TeamIsAlive(Player[][] Team){
		for(int i = 0 ; i < 2 ; i++){
			for(int j = 0 ; j < Team[i].length ; j++){
				if(Team[i][j].isAlive()){ //check that there are player in the team alive or not
					return true;
				}else{
					;
				}
			}
		}
		return false;
	}
	
	public static Player FindTarget(Player[][] otherteam){ //Find the target that have least HP in other team
		Player target = null;	
		if(TauntEnemy(otherteam) != null){
			target = TauntEnemy(otherteam);
		}else if(FrontRowDead(otherteam) == false){
			for(int i = 0 ; i < otherteam[0].length ; i++){
				if(otherteam[0][i].isAlive()){ //check that the other team is alive or not
					target = otherteam[0][i];
					break;
				}
			}
			for(int i = 0 ; i < otherteam[0].length ; i++){
				if(otherteam[0][i].isAlive() && target.getCurrentHP() > otherteam[0][i].getCurrentHP()){ //check that the other team is alive or not
					target = otherteam[0][i];
				}	
			}
		}else{
			for(int i = 0 ; i < otherteam[1].length ; i++){
				if(otherteam[1][i].isAlive()){
					target = otherteam[1][i];
					break;
				}else{
					;
				}
			}
			for(int i = 0 ; i < otherteam[1].length ; i++){
				if(otherteam[1][i].isAlive() && target.getCurrentHP() > otherteam[1][i].getCurrentHP()){  //check that the other team is alive or not
					target = otherteam[1][i];
				}else{
					;
				}
			}
		}
		return target;
	}

	public static boolean FrontRowDead(Player[][] Team){
		for(int i = 0 ; i < Team[0].length ; i++){
			if(Team[0][i].isAlive() == true){
				return false;
			}else{
				;
			}
		}
		return true;
	}
	
	public static Player TauntEnemy(Player[][] Team){ //taunt the other team
		Player target = null;
		boolean TauntEnemyFound = false;
		for(int i = 0 ; i < 2 ; i++){
			for(int j = 0 ; j < Team[i].length ; j++){
				if(Team[i][j].isTaunt() && Team[i][j].isAlive() == true){
					target = Team[i][j];
					TauntEnemyFound = true;
					break;
				}
			}
			if(TauntEnemyFound == true){
				break;
			}	
		}
		return target;
	}
	
	public static Player FindLowHP(Player[][] team){ //find the player that have the least HP
		Player target = null;
		boolean InjuredFound = false;
		for(int i = 0 ; i < 2 ; i++){
			for(int j = 0 ; j < team[i].length ; j++){
				if(team[i][j].isAlive() == true){
					target = team[i][j];
					InjuredFound = true;
					break;
				}
			}
			if(InjuredFound == true){
				break;
			}
		}
		for(int i = 0 ; i < 2 ; i++){
			for(int j = 0 ; j < team[i].length ; j++){
				if(target.getCurrentHP() / target.getMaxHP() > team[i][j].getCurrentHP() / team[i][j].getMaxHP() && team[i][j].alive){
					target = team[i][j];
				}
			}
		}
		return target;
	}
	
	public static Player DeadTeammate(Player[][] Team){
		Player target = null;
		boolean DeadTeammateFound = false;
		for(int i = 0 ; i < 2 ; i++){
			for(int j = 0 ; j < Team[i].length ; j++){
				if(Team[i][j].isAlive() == false){
					target = Team[i][j];
					DeadTeammateFound = true;
					break;
				}
			}
			if(DeadTeammateFound == true){
				break;
			}
		}
		return target;
	}
	
	/**
	 * This method is called by Arena when it is this player's turn to take an action. 
	 * By default, the player simply just "attack(target)". However, once this player has 
	 * fought for "numSpecialTurns" rounds, this player must perform "useSpecialAbility(myTeam, theirTeam)"
	 * where each player type performs his own special move. 
	 * @param arena
	 */
	public void takeAction(Arena arena){	
		//INSERT YOUR CODE HERE	
		Player target;
		if(this.type == PlayerType.Tank){
			taunt = false;
		}
		if(this.type == PlayerType.BlackMage && youcurse != null){
			youcurse.cursed = false;
			youcurse = null;
		}
		if((sleep == false) && this.alive){
			CurrentTurn++;
			switch(team){
			case A:
				if(CurrentTurn == SpecialTurn){
					useSpecialAbility(arena.getTeam(Arena.Team.A) , arena.getTeam(Arena.Team.B));
					this.CurrentTurn = 0;
				}else{
					target = FindTarget(arena.getTeam(Arena.Team.B));
					if(target != null){
						attack(target);
						System.out.println("# "+this.playerInfo()+" Attacks "+target.playerInfo());
					}
				}
				break;
				
			case B:
				if(CurrentTurn == SpecialTurn){
					useSpecialAbility(arena.getTeam(Arena.Team.B) , arena.getTeam(Arena.Team.A));	
					CurrentTurn = 0;
				}else{
					target = FindTarget(arena.getTeam(Arena.Team.A));
					if(target != null){
						attack(target);
						System.out.println("# "+this.playerInfo()+" Attacks "+target.playerInfo());
					}else{
						;
					}
				}
				break;
			}
		}
		if(sleep == true){
			sleep = false;
		}else{
			;
		}
	}
	
	private String playerInfo(){
		return this.team+"["+this.row+"] ["+this.PositionSet+"] {"+this.type+"}";
	}
	
	/**
	 * This method overrides the default Object's toString() and is already implemented for you. 
	 */
	@Override
	public String toString(){
		return "["+this.type.toString()+" HP:"+this.currentHP+"/"+this.maxHP+" ATK:"+this.atk+"]["
				+((this.isCursed())?"C":"")
				+((this.isTaunt())?"T":"")
				+((this.isSleeping())?"S":"")
				+"]";
	}
	  
}

