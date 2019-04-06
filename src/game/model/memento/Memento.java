package game.model.memento;

import game.controller.GameState;
import game.model.ItemManager;
import game.model.entity.EntityManager;

public class Memento {
	
	private GameState gameState;
	private EntityManager entityManager;
	private ItemManager itemManager;
	
	public Memento(GameState state , EntityManager entityManager , ItemManager itemManager) {
		this.gameState = state;
		this.entityManager = entityManager;
		this.itemManager = itemManager;
	}
	
	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
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
