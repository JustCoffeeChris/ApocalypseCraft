package lootEvent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinEvents implements Listener {

	public void repairItems(Player user) {

		user.getInventory().getBoots().getItemMeta().setUnbreakable(true);
		Inventory inv = user.getInventory();

		ItemStack[] IS = inv.getContents();

		for (int i = 0; i < IS.length; i++) {

			if (!(IS[i] == null || IS[i].getType() == Material.AIR)) {

				ItemMeta meta = IS[i].getItemMeta();
				meta.setUnbreakable(true);
				IS[i].setItemMeta(meta);
			}
		}

	}

	@EventHandler
	public void firstJoin(PlayerJoinEvent event) {

		if (!event.getPlayer().hasPlayedBefore()) {
			event.getPlayer().sendMessage("Welcome! ");

			ItemStack[] firstStuff = { new ItemStack(Material.WOODEN_SWORD), new ItemStack(Material.LEATHER_HELMET),
					new ItemStack(Material.LEATHER_CHESTPLATE), new ItemStack(Material.LEATHER_LEGGINGS),
					new ItemStack(Material.LEATHER_BOOTS) };

			for (int i = 0; i < firstStuff.length; i++) {
				ItemMeta meta = firstStuff[i].getItemMeta();
				meta.setUnbreakable(true);
				firstStuff[i].setItemMeta(meta);
			}

			event.getPlayer().getInventory().addItem(firstStuff[0]);
			event.getPlayer().getInventory().addItem(new ItemStack(Material.BREAD));
			event.getPlayer().getInventory().setHelmet(firstStuff[1]);
			event.getPlayer().getInventory().setChestplate(firstStuff[2]);
			event.getPlayer().getInventory().setLeggings(firstStuff[3]);
			event.getPlayer().getInventory().setBoots(firstStuff[4]);
		}

	}

}
