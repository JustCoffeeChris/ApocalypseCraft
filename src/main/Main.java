package main;

import org.bukkit.plugin.java.JavaPlugin;

import mobs.levelZombie;

public class Main extends JavaPlugin{

	// Fired when plugin is first enabled
	@Override
	public void onEnable() {
		getLogger().info("Plugin geladen!");
		
		this.getServer().getPluginManager().registerEvents(new levelZombie(), this);
		//this.getCommand("testZombie").setExecutor(new commands.SpawnZombie(this));
	}

	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		getLogger().info("Plugin tot!");
	}
}
