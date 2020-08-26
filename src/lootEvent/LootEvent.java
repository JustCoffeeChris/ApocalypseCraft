package lootEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LootEvent implements Listener {

	private static HashMap<Location, Long> usedLoot = new HashMap<Location, Long>();
	final private ArrayList<Material> lootableObject = new ArrayList<Material>(
			Arrays.asList(Material.BARREL, Material.CAULDRON, Material.COMPOSTER, Material.GOLD_BLOCK));
	final private long cooldownTime = 300;

	@EventHandler
	public void disableDrop(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}
	
	private void givePlayerLootBarrel(Player user) {

		for (int i = 0; i < 2; i++) {

			Random rnd = new Random();

			for (int x = 0; x != 3; x++) {
				switch (rnd.nextInt(3)) {
				case 1:
					user.getInventory().addItem(new ItemStack(Material.COOKIE));
					break;
				case 2:
					user.getInventory().addItem(new ItemStack(Material.BREAD));
					break;
				case 3:
					user.getInventory().addItem(new ItemStack(Material.APPLE));
					break;
				}
			}

			for (int x = 0; x != 2; x++) {
				switch (rnd.nextInt(4)) {
				case 1:
					user.getInventory().addItem(new ItemStack(Material.ARROW));
					break;
				case 2:
					user.getInventory().addItem(new ItemStack(Material.SPIDER_EYE));
					break;
				case 3:
					user.getInventory().addItem(new ItemStack(Material.ROTTEN_FLESH));
					break;
				case 4:
					user.getInventory().addItem(new ItemStack(Material.GOLD_NUGGET));
					break;
				}

			}

		}

	}

	private void givePlayerLootCauldron(Player user) {
		user.getInventory().addItem(new ItemStack(Material.MILK_BUCKET));
	}

	private void givePlayerLootComposter(Player user) {

		Random rnd = new Random();

		for (int x = 0; x != 3; x++) {
			switch (rnd.nextInt(3)) {
			case 1:
				user.getInventory().addItem(new ItemStack(Material.COOKIE));
				break;
			case 2:
				user.getInventory().addItem(new ItemStack(Material.BREAD));
				break;
			case 3:
				user.getInventory().addItem(new ItemStack(Material.APPLE));
				break;
			}
		}

	}

	private void givePlayerLootNugget(Player user) {
		user.getInventory().addItem(new ItemStack(Material.GOLD_NUGGET));
	}

	@EventHandler
	public void clickPlayer(PlayerInteractEvent event) {

		if ((event.getClickedBlock() != null) && (lootableObject.contains(event.getClickedBlock().getType()))) {

			if (usedLoot.containsKey(event.getClickedBlock().getLocation())) {
				long now = System.currentTimeMillis();
				long old = usedLoot.get(event.getClickedBlock().getLocation());
				long ellapsed = ((old - now) / 1000) * -1;

				if ((this.cooldownTime - ellapsed) <= 0) {

					usedLoot.remove(event.getClickedBlock().getLocation());

				}

				if (usedLoot.containsKey(event.getClickedBlock().getLocation())) {
					return;
				}
			}

			if ((event.getClickedBlock().getType() == Material.BARREL)) {
				givePlayerLootBarrel(event.getPlayer());

			} else if (event.getClickedBlock().getType() == Material.CAULDRON) {
				givePlayerLootCauldron(event.getPlayer());

			} else if (event.getClickedBlock().getType() == Material.COMPOSTER) {
				givePlayerLootComposter(event.getPlayer());

			} else if (event.getClickedBlock().getType() == Material.GOLD_BLOCK) {
				givePlayerLootNugget(event.getPlayer());
			}

			usedLoot.put(event.getClickedBlock().getLocation(), System.currentTimeMillis());

		}
	}
}
