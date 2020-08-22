package lootEvent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;

public class LevelUpEvent implements Listener {

	static boolean played = false;
	final private String hellName = "world_nether";
	final private String endName = "world_the_end";

	@EventHandler
	public void playerLevelUp(PlayerLevelChangeEvent levelUpEvent) {

		Player user = levelUpEvent.getPlayer();

		if (levelUpEvent.getNewLevel() == 15) {
			user.getInventory().addItem(new ItemStack(Material.BOW));
		}

		if ((levelUpEvent.getNewLevel() == 50)) {
			World hell = Bukkit.getWorld(hellName);

			Location nether = new Location(hell, hell.getSpawnLocation().getX(), hell.getSpawnLocation().getY(),
					hell.getSpawnLocation().getZ());

			user.teleport(nether);
		}

		if ((levelUpEvent.getNewLevel() == 70)) {
			World end = Bukkit.getWorld(endName);

			Location endLocation = new Location(end, end.getSpawnLocation().getX(), end.getSpawnLocation().getY(),
					end.getSpawnLocation().getZ());
			
			user.teleport(endLocation);
		}

	}
}
