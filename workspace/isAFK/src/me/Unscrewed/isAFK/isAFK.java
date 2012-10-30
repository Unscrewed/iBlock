package me.Unscrewed.isAFK;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
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

public class isAFK extends JavaPlugin{
	PluginDescriptionFile pdfFile = this.getDescription();
	Logger log = Logger.getLogger("Minecraft");

	public void onEnable() {
		log.info("[clearChat] " + pdfFile.getVersion() + " enabled successfully!");
		PluginManager pm = getServer().getPluginManager();
		}
	
	public void onDisable() {
		log.info("[clearChat] " + pdfFile.getVersion() + " disabled successfully!");}
	public boolean hasPermissionReload(Player player, String string) {
		return player.isOp() || player.hasPermission("clearChat.use");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(sender instanceof Player){
        	Player player = (Player) sender;
        	if(cmd.getName().equalsIgnoreCase("clearchat") && !hasPermissionReload(player, "clearChat.use")){
        	player.sendMessage(ChatColor.GREEN + "[isAFK] " + ChatColor.RED + "You do not have permission to use this command.");
			return true;
		}else{
			player.sendMessage(ChatColor.GREEN + "[isAFK] " + ChatColor.RED + "Chat cleared successfully.");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(" ");
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Chat cleared by an Administrator.");
		return true; 
		}
       }
      return false;
		}
	}