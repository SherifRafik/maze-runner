package game.model.memento;

import game.controller.GameState;
import game.controller.State;
import game.model.ItemManager;
import game.model.entity.EntityManager;

public class Originator {
	
	private GameState gameState;
	private EntityManager entityManager;
	private ItemManager itemManager;
	

	public Memento saveStateToMemento() {
		return new Memento(gameState , entityManager , itemManager);
	}
	
	public void getStateFromMemento(Memento memento) {
		gameState = memento.getGameState();
		entityManager = memento.getEntityManager();
		itemManager = memento.getItemManager();
	}
	public void setGameState(GameState state) {
		this.gameState = state;
	}
	
	public State getGameState() {
		return gameState;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

}
