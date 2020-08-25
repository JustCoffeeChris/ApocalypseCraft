package main;

import org.bukkit.plugin.java.JavaPlugin;

import gui.ClickEvent;
import gui.MainGui;
import gui.RemoveItem;
import lootEvent.JoinEvents;
import lootEvent.LevelUpEvent;
//import gui.UpgradeGui;
import lootEvent.LootEvent;
import lootEvent.WorldEvents;
import mobs.DeathEvent;
import mobs.levelZombie;

public class Main extends JavaPlugin {

	// Fired when plugin is first enabled
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		getLogger().info("Plugin geladen!");

		this.getServer().getWorld("world").setGameRuleValue("keepInventory", "true");

		this.getServer().getPluginManager().registerEvents(new levelZombie(), this);
		this.getServer().getPluginManager().registerEvents(new LootEvent(), this);
		this.getServer().getPluginManager().registerEvents(new ClickEvent(), this);
		this.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
		this.getServer().getPluginManager().registerEvents(new LevelUpEvent(), this);
		this.getServer().getPluginManager().registerEvents(new JoinEvents(), this);
		this.getServer().getPluginManager().registerEvents(new WorldEvents(), this);

		this.getCommand("mainGui").setExecutor(new MainGui());
		this.getCommand("removeItem").setExecutor(new RemoveItem());

	}

	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		getLogger().info("Plugin tot!");
	}
}
