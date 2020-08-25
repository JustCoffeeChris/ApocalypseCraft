package lootEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WorldEvents implements Listener {

	@EventHandler
	public void disableBlockBreak(BlockBreakEvent event) {
		if (!(event.getPlayer().isOp())) {
			event.setCancelled(true);
		}
	}

	// I hate rain!!!!!
	@EventHandler
	public void disableTheRain(WeatherChangeEvent event) {
		event.setCancelled(true);
	}

}
