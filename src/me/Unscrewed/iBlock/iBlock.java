package me.Unscrewed.iBlock;

import java.util.ArrayList;
import java.util.Arrays;
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
		loadConfiguration();
		deniedBlocksPlace = getConfig().getIntegerList("bannedBlocksPlace");
		deniedBlocksBreak = getConfig().getIntegerList("bannedBlocksBreak");
		@SuppressWarnings("unused")
		Updater updater = new Updater(this, "iBlock", this.getFile(), Updater.UpdateType.DEFAULT, false);
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("[iBlock] Version " + pdfFile.getVersion() + " disabled successfully!");
	}

	public void loadConfiguration() {
		String bannedBucketWaterM = "waterBucketM";
		String bannedBucketLavaM = "lavaBucketM";
		String bannedBlocksPlace = "bannedBlocksPlace";
		String bannedBlocksBreak = "bannedBlocksBreak";
		String bannedBlocksPlaceM = "bannedBlocksPlaceM";
		String bannedBlocksBreakM = "bannedBlocksBreakM";
		String warnAdmins = "warnAdmins";
		String bannedBucketWaterMV = "You are not allowed to place water here.";
		String bannedBucketLavaMV = "You are not allowed to place lava here.";
		String bannedBlocksPlaceMV = "You are not allowed to place this block.";
		String bannedBlocksBreakMV = "You are not allowed to break this block.";
		String[] bannedBlocksPlaceList = { "7", "9", "11", "19", "30", "52", "78", "79", "97", "120" };
		String[] bannedBlocksBreakList = { "7" };
		String warnAdminsT = "true";
		this.getConfig().addDefault(warnAdmins, warnAdminsT);
		this.getConfig().addDefault(bannedBucketWaterM, bannedBucketWaterMV);
		this.getConfig().addDefault(bannedBucketLavaM, bannedBucketLavaMV);
		this.getConfig().addDefault(bannedBlocksPlaceM, bannedBlocksPlaceMV);
		this.getConfig().addDefault(bannedBlocksBreakM, bannedBlocksBreakMV);
		this.getConfig().addDefault(bannedBlocksPlace, Arrays.asList(bannedBlocksPlaceList));
		this.getConfig().addDefault(bannedBlocksBreak, Arrays.asList(bannedBlocksBreakList));
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

	public static List<Integer> deniedBlocksPlace = new ArrayList<Integer>();
	public static List<Integer> deniedBlocksBreak = new ArrayList<Integer>();

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
