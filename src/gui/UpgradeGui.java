package gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class UpgradeGui {

	final private String upgradeGuiName = "UpgradeGui";
	Player user = null;

	public UpgradeGui() {
		
	}
	
	public UpgradeGui(Player getUser) {
		this.user = getUser;
	}

	public String getName() {
		return this.upgradeGuiName;
	}
	
	public void openGui() {

		Inventory upgradeGui = Bukkit.createInventory(user, 9, upgradeGuiName);
		ItemStack[] stack = new ItemStack[5];
		/*
		 * 0 = Boots 1 = Leggins 2 = Chestplate 3 = Head 4 = Sword
		 */
		
		user.sendMessage(user.getInventory().getChestplate().getType().toString());
		
		
		
		
		user.sendMessage(
				user.getInventory().getBoots().getType().toString() + "\n" +
				user.getInventory().getLeggings().getType().toString() + "\n" +
				user.getInventory().getChestplate().getType().toString() + "\n" +
				user.getInventory().getHelmet().getType().toString() + "\n" 
				);
		
		switch (user.getInventory().getBoots().getType()) {
		case LEATHER_BOOTS:
			stack[0] = new ItemStack(Material.GOLDEN_BOOTS);
			break;
		case GOLDEN_BOOTS:
			stack[0] = new ItemStack(Material.CHAINMAIL_BOOTS);
			break;
		case CHAINMAIL_BOOTS:
			stack[0] = new ItemStack(Material.IRON_BOOTS);
			break;
		case IRON_BOOTS:
			stack[0] = new ItemStack(Material.DIAMOND_BOOTS);
			break;
		default:
			user.sendMessage("Du hast stinkesocken!");
			stack[0] = new ItemStack(Material.DIRT);
			break;
		}
		
		switch (user.getInventory().getLeggings().getType()) {
		case LEATHER_LEGGINGS:
			stack[1] = new ItemStack(Material.GOLDEN_LEGGINGS);
			break;
		case GOLDEN_LEGGINGS:
			stack[1] = new ItemStack(Material.CHAINMAIL_LEGGINGS);
			break;
		case CHAINMAIL_LEGGINGS:
			stack[1] = new ItemStack(Material.IRON_LEGGINGS);
			break;
		case IRON_LEGGINGS:
			stack[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
			break;
		default:
			stack[1] = new ItemStack(Material.DIRT);
			break;
		}
		
		switch (user.getInventory().getChestplate().getType()) {
		case LEATHER_CHESTPLATE:
			stack[2] = new ItemStack(Material.GOLDEN_CHESTPLATE);
			break;
		case GOLDEN_CHESTPLATE:
			stack[2] = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			break;
		case CHAINMAIL_CHESTPLATE:
			stack[2] = new ItemStack(Material.IRON_CHESTPLATE);
			break;
		case IRON_CHESTPLATE:
			stack[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
			break;
		default:
			stack[2] = new ItemStack(Material.DIRT);
			break;
		}
		
		switch (user.getInventory().getHelmet().getType()) {
		case LEATHER_HELMET:
			user.sendMessage("Lederkopf");
			stack[3] = new ItemStack(Material.GOLDEN_HELMET);
			break;
		case GOLDEN_HELMET:
			stack[3] = new ItemStack(Material.CHAINMAIL_HELMET);
			break;
		case CHAINMAIL_HELMET:
			stack[3] = new ItemStack(Material.IRON_HELMET);
			break;
		case IRON_HELMET:
			stack[3] = new ItemStack(Material.DIAMOND_HELMET);
			break;
		default:
			stack[3] = new ItemStack(Material.DIRT);
			break;
		}
		
		switch (user.getInventory().getItem(0).getType()) {
		case WOODEN_SWORD:
			stack[4] = new ItemStack(Material.STONE_SWORD);
			break;
		case STONE_SWORD:
			stack[4] = new ItemStack(Material.GOLDEN_SWORD);
			break;
		case GOLDEN_SWORD:
			stack[4] = new ItemStack(Material.IRON_SWORD);
			break;
		case IRON_SWORD:
			stack[4] = new ItemStack(Material.DIAMOND_SWORD);
			break;
		default:
			stack[4] = new ItemStack(Material.DIRT);
			break;
		}
		
		

		
		for(int i = 0; i < stack.length; i++) {
			user.sendMessage(stack[i].getType().toString());
		}
		
		upgradeGui.setContents(stack);
		user.openInventory(upgradeGui);

	}

}
