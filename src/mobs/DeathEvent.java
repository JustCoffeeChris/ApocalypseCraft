package mobs;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener{

	final private ArrayList<EntityType> notLoot = new ArrayList<EntityType>(Arrays.asList(EntityType.ZOMBIE, 
			EntityType.SKELETON));
	
	@EventHandler
	public void entityDeath(EntityDeathEvent deathEvent) {
		if(notLoot.contains(deathEvent.getEntityType())) {
			deathEvent.getDrops().clear();
			deathEvent.setDroppedExp(deathEvent.getDroppedExp()/2);
		}
	}
	
	@EventHandler
	public void playerDeath(PlayerDeathEvent playerDeath) {
		playerDeath.setDroppedExp(0);
		playerDeath.getDrops().clear();
	}
}
