package gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainGui implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] arg3) {
		
		if(sender instanceof Player) {
			Player user = (Player) sender;
			
			Inventory mainGui = Bukkit.createInventory(user, 9, "Choose Gui");
			
			ItemStack upgrade = new ItemStack(Material.ANVIL);
			upgrade.getItemMeta().setDisplayName("Upgrade Items");
			
			ItemStack[] guiContent = {upgrade};
			mainGui.setContents(guiContent);
			
			user.openInventory(mainGui);
		}
		
		
		return true;
	}

}
