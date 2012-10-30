package me.Unscrewed.MBot;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class MBotListener implements Listener{
	public MBotListener() {}
	static final String MBotTag = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Bot" + ChatColor.DARK_GRAY + "]" + ChatColor.BLUE + "MasterBot: " + ChatColor.WHITE;
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		if(event.getMessage().toLowerCase().contains("can i be op")||event.getMessage().toLowerCase().contains("can i be admin")||event.getMessage().toLowerCase().contains("can i be vip") || event.getMessage().toLowerCase().contains("can i get op")||event.getMessage().toLowerCase().contains("can i get admin")){
			Bukkit.getServer().broadcastMessage(MBotTag + "You can rank up by proving yourself, " + event.getPlayer().getName() + ".");
		}
		if(event.getMessage().toLowerCase().contains("whats the time") || event.getMessage().toLowerCase().contains("how late is it") || event.getMessage().toLowerCase().contains("tell me the time")){
			Bukkit.getServer().broadcastMessage(MBotTag + "That question will remain unanswered until someone tells you, " + event.getPlayer().getName() + ".");
		}
		if(event.getMessage().toLowerCase().contains("mbot, how are you") || event.getMessage().toLowerCase().contains("mbot, how are u") || event.getMessage().toLowerCase().contains("mbot, how are you") || event.getMessage().toLowerCase().contains("mbot, how are u")){
			Bukkit.getServer().broadcastMessage(MBotTag + "I am fine, thanks for asking. Bots don't have feelings, " + event.getPlayer().getName() + "?");
		}
		if(event.getMessage().toLowerCase().contains("help me") || event.getMessage().toLowerCase().contains("help me mbot") || event.getMessage().toLowerCase().contains("halp me") || event.getMessage().toLowerCase().contains("help me, mbot")){
			Bukkit.getServer().broadcastMessage(MBotTag + "Hello there, " + event.getPlayer().getName() + " with what can I help you?");
		}
		if(event.getMessage().toLowerCase().contains("how to lock chests") || event.getMessage().toLowerCase().contains("how do i lock") || event.getMessage().toLowerCase().contains("how to lock") || event.getMessage().toLowerCase().contains("lock chest")){
			Bukkit.getServer().broadcastMessage(MBotTag + "You can lock your chests, doors, dispensers and more using: /cprivate, " + event.getPlayer().getName() + ".");
		}
		if(event.getMessage().toLowerCase().contains("mbot help")){
			Bukkit.getServer().broadcastMessage(MBotTag + "I can help you with several things, ask a random question, " + event.getPlayer().getName() + ".");
			event.getPlayer().getInventory().remove(64);
		}
		if(event.getMessage().toLowerCase().contains("mbot ver") || event.getMessage().toLowerCase().contains("mbot version")){
			Bukkit.getServer().broadcastMessage(MBotTag + "I am running version: 1.0a, " + event.getPlayer().getName() + ".");
		}
		if(event.getMessage().toLowerCase().contains("mbot smart") || event.getMessage().toLowerCase().contains("mbot dumb")){
			Bukkit.getServer().broadcastMessage(MBotTag + "I am 1.00% smart and I can not learn yet, " + event.getPlayer().getName() + ".");
		}
		if(event.getMessage().toLowerCase().contains("mbot, can i") || event.getMessage().toLowerCase().contains("mbot, am i")){
			Bukkit.getServer().broadcastMessage(MBotTag + "Maybe, " + event.getPlayer().getName() + ".");
		}
	}
}
