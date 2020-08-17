package lootEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LootEvent implements Listener {

	private static HashMap<Location, Long> usedLoot = new HashMap<Location, Long>();

	private void givePlayerLoot(Player user) {
		user.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK));
	}

	@EventHandler
	public void clickPlayer(PlayerInteractEvent event) {

		if ((event.getClickedBlock().getType() == Material.BARREL)) {
			if (usedLoot.containsKey(event.getClickedBlock().getLocation())) {
				long now = System.currentTimeMillis();
				long old = usedLoot.get(event.getClickedBlock().getLocation());
				long ellapsed = ((old - now) / 1000) * -1;

				event.getPlayer().sendMessage("EllapsedTime: " + ellapsed);

				if (ellapsed > 10) {

					usedLoot.remove(event.getClickedBlock().getLocation());

				} else {
					event.getPlayer().sendMessage("Dieses Objekt wurde bereits gelootet! ");
				}
			}

			if (!(usedLoot.containsKey(event.getClickedBlock().getLocation()))) {
				if ((event.getClickedBlock().getType() == Material.BARREL)) {
					event.getPlayer().sendMessage("Loot! Yummy!");
					givePlayerLoot(event.getPlayer());
				}
				usedLoot.put(event.getClickedBlock().getLocation(), System.currentTimeMillis());
			}

		}
	}
}
