package lootEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldEvents implements Listener{
	
	
	//I hate rain!!!!!
	@EventHandler
	public void disableTheRain(WeatherChangeEvent event) {
		event.setCancelled(true);
	}

}
