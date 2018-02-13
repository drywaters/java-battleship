package battleship.states;

public interface BattleShipState {
		
	public abstract void updateGrid();
	public abstract BattleShipState nextState();
	public abstract String toString();

}
