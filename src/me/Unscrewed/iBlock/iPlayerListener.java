package me.Unscrewed.iBlock;
 
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
 
public class iPlayerListener implements Listener{
	public iPlayerListener(iBlock iblock) {
		plugin = iblock;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	private iBlock plugin;
	public boolean hasPermissionWater(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.bucket.water");
	}
	public boolean hasPermissionLava(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.bucket.lava");
	}
	public boolean hasPermissionDebug(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.debug");
	}
	@EventHandler
		public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
			Player player = event.getPlayer();
				if(!hasPermissionWater(player, "iBlock.bucket.water") && event.getBucket()== Material.WATER_BUCKET){
						event.setCancelled(true);
						event.getPlayer().sendMessage(ChatColor.GREEN + "[iBlock] " + ChatColor.RED + plugin.getConfig().getString("water-bucket-message"));
							if(event.isCancelled() && hasPermissionDebug(player, "iBlock.debug") && plugin.getConfig().getBoolean("debugOn")){event.getPlayer().sendMessage(ChatColor.GOLD + "#DEBUG: PlayerBucketEmptyEvent|water: interrupted");}
						}else if(hasPermissionWater(player, "iBlock.bucket.water") && event.getBucket()== Material.WATER_BUCKET){
							//Ignore this player -- do not block bucket use.
							if(event.isCancelled() && hasPermissionDebug(player, "iBlock.debug") && plugin.getConfig().getBoolean("debugOn")){event.getPlayer().sendMessage(ChatColor.GOLD + "#DEBUG: PlayerBucketEmptyEvent|water: successful");}
						}
							
				if(!hasPermissionLava(player, "iBlock.bucket.lava") && event.getBucket()== Material.LAVA_BUCKET){
						event.setCancelled(true);
						event.getPlayer().sendMessage(ChatColor.GREEN + "[iBlock] " + ChatColor.RED + plugin.getConfig().getString("lava-bucket-message"));
							if(event.isCancelled() && hasPermissionDebug(player, "iBlock.debug") && plugin.getConfig().getBoolean("debugOn")){event.getPlayer().sendMessage(ChatColor.GOLD + "#DEBUG: PlayerBucketEmptyEvent|lava: interrupted");}
						}else if(hasPermissionLava(player, "iBlock.bucket.lava") && event.getBucket()== Material.LAVA_BUCKET){
							//Ignore this player -- do not block bucket use.
							if(event.isCancelled() && hasPermissionDebug(player, "iBlock.debug") && plugin.getConfig().getBoolean("debugOn")){event.getPlayer().sendMessage(ChatColor.GOLD + "#DEBUG: PlayerBucketEmptyEvent|lava: successful");}
						}
					}
				}
				
				