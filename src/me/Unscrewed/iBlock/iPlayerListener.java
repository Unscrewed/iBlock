package me.Unscrewed.iBlock;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class iPlayerListener implements Listener {
	public iPlayerListener(iBlock iblock) {
		plugin = iblock;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	private iBlock plugin;

	@EventHandler
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPermission("iBlock.bucket.water") && event.getBucket() == Material.WATER_BUCKET) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GREEN + "[iBlock] " + ChatColor.RED + plugin.getConfig().getString("Bucket.Water.message"));
		} else if (player.hasPermission("iBlock.bucket.water") && event.getBucket() == Material.WATER_BUCKET) {
			// Ignore this player -- do not block bucket use.
		}

		if (!player.hasPermission("iBlock.bucket.lava") && event.getBucket() == Material.LAVA_BUCKET) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GREEN + "[iBlock] " + ChatColor.RED + plugin.getConfig().getString("Bucket.Lava.message"));
		} else if (player.hasPermission("iBlock.bucket.lava") && event.getBucket() == Material.LAVA_BUCKET) {
			// Ignore this player -- do not block bucket use.
		}
	}
}
