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

/////////////////////////////////////
// ALL WORK HERE IS BY "UNSCREWED" //
// PLEASE, DO NOT DECOMPILE MY WORK//
// WITH THE FOLLOWING REASONS:     //
// TO STEAL, COPYPASTE AND REUPLOAD//
// MY WORK. THANKS IN ADVANCE!     //
/////////////////////////////////////

public class iBlock extends JavaPlugin{
	private iBlockListener blockListener;
	private iPlayerListener playerListener;
	Logger log = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdfFile = this.getDescription();

	public void onEnable() {
		blockListener = new iBlockListener(this);
		playerListener = new iPlayerListener(this);
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("[iBlock] Version " + pdfFile.getVersion() + " enabled successfully!");
		PluginManager pm = getServer().getPluginManager();
	    loadConfiguration();
		deniedBlocksPlace = getConfig().getIntegerList("bannedBlocksPlace");
		deniedBlocksBreak = getConfig().getIntegerList("bannedBlocksBreak");
		Updater updater = new Updater(this, "iBlock", this.getFile(), Updater.UpdateType.DEFAULT, false);
		}
	
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info("[iBlock] Version " + pdfFile.getVersion() + " disabled successfully!");}
	public boolean hasPermissionReload(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.reload");
		}
	public boolean hasPermissionDebug(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.debug");
	}
	public void loadConfiguration(){
	     String bannedBucketWaterM = "water-bucket-message";
	     String bannedBucketLavaM = "lava-bucket-message";
	     String bannedBlocksPlace = "bannedBlocksPlace";
	     String bannedBlocksBreak = "bannedBlocksBreak";
	     String bannedBlocksPlaceM = "bBlocksPlace-message";
	     String bannedBlocksBreakM = "bBlocksBreak-message";
	     String debugOn = "debugOn";
	     	String bannedBucketWaterMV = "You are not allowed to place water here.";
	     	String bannedBucketLavaMV = "You are not allowed to place lava here.";
	        String bannedBlocksPlaceMV = "You are not allowed to place this block.";
			String bannedBlocksBreakMV = "You are not allowed to break this block.";
	     	String[] bannedBlocksPlaceList = {"7","9","11","19","30","52","78","79","97","120"};
			String[] bannedBlocksBreakList = {"7"};
			String[] debugOnT = {"false"};
			 this.getConfig().addDefault(bannedBucketWaterM, bannedBucketWaterMV);
			 this.getConfig().addDefault(bannedBucketLavaM, bannedBucketLavaMV);
		     this.getConfig().addDefault(bannedBlocksPlaceM, bannedBlocksPlaceMV);
		     this.getConfig().addDefault(bannedBlocksBreakM, bannedBlocksBreakMV);
		     this.getConfig().addDefault(bannedBlocksPlace, Arrays.asList(bannedBlocksPlaceList));
		     this.getConfig().addDefault(bannedBlocksBreak, Arrays.asList(bannedBlocksBreakList));
		     this.getConfig().addDefault(debugOn, debugOnT);
		     this.getConfig().options().copyDefaults(true);
		     this.saveConfig();
	}
	
	public static List<Integer> deniedBlocksPlace = new ArrayList<Integer>();
	public static List<Integer> deniedBlocksBreak = new ArrayList<Integer>();
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
        if(sender instanceof Player){
        	Player player = (Player) sender;
        	if(cmd.getName().equalsIgnoreCase("iBlock") && !hasPermissionReload(player, "iBlock.reload")){
        	player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
        	if(hasPermissionDebug(player, "iBlock.debug") && this.getConfig().getBoolean("debugOn")){player.sendMessage(ChatColor.GOLD + "#DEBUG: !hasPermissionReload | onCommand: interrupted");}
			return true;
		}else{
			this.reloadConfig();
			player.sendMessage(ChatColor.GREEN + "[iBlock Information]");
			player.sendMessage(ChatColor.RED + "Configuration file reloaded.");
			player.sendMessage(ChatColor.GREEN + "[Version Information]");
			player.sendMessage(ChatColor.RED + "Version: 3.0-DEV-b1");
			player.sendMessage(ChatColor.RED + "Updates: Needs more testing.");
			player.sendMessage(ChatColor.RED + "Thank you very much for using iBlock!");
			if(hasPermissionDebug(player, "iBlock.debug") && this.getConfig().getBoolean("debugOn")){player.sendMessage(ChatColor.GOLD + "#DEBUG: iBlock.reloadConfig: successful");}
		return true; 
		}
       }
      return false;
	}
}