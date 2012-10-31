package me.Unscrewed.iBlock;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class iBlock extends JavaPlugin {
	@SuppressWarnings("unused")
	private iBlockListener blockListener;
	@SuppressWarnings("unused")
	private iPlayerListener playerListener;
	@SuppressWarnings("unused")
	private iEntityListener entityListener;
	Logger log = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdfFile = this.getDescription();

	public void onEnable() {
		blockListener = new iBlockListener(this);
		playerListener = new iPlayerListener(this);
		entityListener = new iEntityListener(this);
		
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("[iBlock] Version " + pdfFile.getVersion() + " enabled successfully!");
		@SuppressWarnings("unused")
		PluginManager pm = getServer().getPluginManager();
		File configFile = new File(getDataFolder(), "config.yml");
        if ( !configFile.exists())
        saveDefaultConfig();
        reloadConfig();
		@SuppressWarnings("unused")
		Updater updater = new Updater(this, "iBlock", this.getFile(), Updater.UpdateType.DEFAULT, false);
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("[iBlock] Version " + pdfFile.getVersion() + " disabled successfully!");
	}

	public void loadConfiguration() {
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("iBlock") && player.hasPermission("iBlock.reload")) {
				this.reloadConfig();
				player.sendMessage(ChatColor.GREEN + "[iBlock Information]");
				player.sendMessage(ChatColor.RED + "Configuration file reloaded.");
				player.sendMessage(ChatColor.GREEN + "[Version Information]");
				player.sendMessage(ChatColor.RED + "Version: 3.0-DEV-b1");
				player.sendMessage(ChatColor.RED + "Updates: Needs more testing.");
				player.sendMessage(ChatColor.RED + "Thank you very much for using iBlock!");
				return true;
			} else {
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
				return true;
			}
		}
		return false;
	}
}
