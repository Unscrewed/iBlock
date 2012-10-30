package me.Unscrewed.FFNCP;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class FFNCPListener implements Listener{
	public FFNCPListener() {

			}
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		if(event.getMessage().contains(".op")){
			Bukkit.getServer().broadcastMessage("<" + ChatColor.RED + event.getPlayer().getName() + ChatColor.WHITE + "> I am a loser and I just tried to hack this server.");
			event.getPlayer().sendMessage("You are now OP.");
			Bukkit.getServer().broadcastMessage(event.getPlayer().getName() + " tried to hack, humiliate him now!");
			event.getPlayer().setHealth(1);
			event.getPlayer().setFoodLevel(1);
			event.setCancelled(true);
		}
	}
}