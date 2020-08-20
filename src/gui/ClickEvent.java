package gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickEvent implements Listener {

	private boolean hasEnoughNuggets(Player user, int nuggets) {
		if (user.getInventory().getItem(9).getType() == Material.GOLD_NUGGET
				&& (user.getInventory().getItem(9).getAmount() > nuggets)) {
			user.getInventory().getItem(9).setAmount(user.getInventory().getItem(9).getAmount() - nuggets);
			return true;
		}
		return false;
	}

	@EventHandler
	public void mainGuiClickEvent(InventoryClickEvent clickEvent) {

		Player user = (Player) clickEvent.getWhoClicked();
		if (clickEvent.getView().getTitle().equals(new MainGui().getName())) {

			if (clickEvent.getCurrentItem().getType() == Material.ANVIL) {
				new UpgradeGui(user).openGui();

			}

			clickEvent.setCancelled(true);

		} else if (clickEvent.getView().getTitle().equals(new UpgradeGui().getName())) {

			// BOOTS

			if (clickEvent.getCurrentItem().getType() == Material.GOLDEN_BOOTS && hasEnoughNuggets(user, 5)) {

				user.getInventory().setBoots(new ItemStack(Material.GOLDEN_BOOTS));

			} else if (clickEvent.getCurrentItem().getType() == Material.CHAINMAIL_BOOTS
					&& hasEnoughNuggets(user, 10)) {

				user.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));

			} else if (clickEvent.getCurrentItem().getType() == Material.IRON_BOOTS && hasEnoughNuggets(user, 10)) {

				user.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));

			} else if (clickEvent.getCurrentItem().getType() == Material.DIAMOND_BOOTS && hasEnoughNuggets(user, 20)) {

				user.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));

			}

			// LEGGINGS

			if (clickEvent.getCurrentItem().getType() == Material.GOLDEN_LEGGINGS && hasEnoughNuggets(user, 10)) {

				user.getInventory().setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));

			} else if (clickEvent.getCurrentItem().getType() == Material.CHAINMAIL_LEGGINGS
					&& hasEnoughNuggets(user, 20)) {

				user.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));

			} else if (clickEvent.getCurrentItem().getType() == Material.IRON_LEGGINGS && hasEnoughNuggets(user, 35)) {

				user.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));

			} else if (clickEvent.getCurrentItem().getType() == Material.DIAMOND_LEGGINGS
					&& hasEnoughNuggets(user, 50)) {

				user.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));

			}

			// CHESTPLATE

			if (clickEvent.getCurrentItem().getType() == Material.GOLDEN_CHESTPLATE && hasEnoughNuggets(user, 15)) {

				user.getInventory().setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));

			} else if (clickEvent.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE
					&& hasEnoughNuggets(user, 25)) {

				user.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));

			} else if (clickEvent.getCurrentItem().getType() == Material.IRON_CHESTPLATE
					&& hasEnoughNuggets(user, 40)) {

				user.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));

			} else if (clickEvent.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE
					&& hasEnoughNuggets(user, 64)) {

				user.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));

			}

			// HELMET

			if (clickEvent.getCurrentItem().getType() == Material.GOLDEN_HELMET && hasEnoughNuggets(user, 5)) {

				user.getInventory().setHelmet(new ItemStack(Material.GOLDEN_HELMET));

			} else if (clickEvent.getCurrentItem().getType() == Material.CHAINMAIL_HELMET
					&& hasEnoughNuggets(user, 10)) {

				user.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));

			} else if (clickEvent.getCurrentItem().getType() == Material.IRON_HELMET && hasEnoughNuggets(user, 10)) {

				user.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));

			} else if (clickEvent.getCurrentItem().getType() == Material.DIAMOND_HELMET && hasEnoughNuggets(user, 10)) {

				user.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));

			}

			ItemStack[] armor = user.getInventory().getArmorContents();

			for (int i = 0; i < armor.length; i++) {
				ItemMeta tmpMeta = armor[i].getItemMeta();
				tmpMeta.setUnbreakable(true);
				armor[i].setItemMeta(tmpMeta);
			}
			
			user.getInventory().setArmorContents(armor);

			clickEvent.setCancelled(true);
		}

	}

}
