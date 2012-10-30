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

	public boolean hasPermissionWater(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.bucket.water");
	}

	public boolean hasPermissionLava(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.bucket.lava");
	}

	@EventHandler
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
		Player player = event.getPlayer();
		if (!hasPermissionWater(player, "iBlock.bucket.water")
				&& event.getBucket() == Material.WATER_BUCKET) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(
					ChatColor.GREEN + "[iBlock] " + ChatColor.RED
							+ plugin.getConfig().getString("waterBucketM"));
		} else if (hasPermissionWater(player, "iBlock.bucket.water")
				&& event.getBucket() == Material.WATER_BUCKET) {
			// Ignore this player -- do not block bucket use.
		}

		if (!hasPermissionLava(player, "iBlock.bucket.lava")
				&& event.getBucket() == Material.LAVA_BUCKET) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(
					ChatColor.GREEN + "[iBlock] " + ChatColor.RED
							+ plugin.getConfig().getString("lavaBucketM"));
		} else if (hasPermissionLava(player, "iBlock.bucket.lava")
				&& event.getBucket() == Material.LAVA_BUCKET) {
			// Ignore this player -- do not block bucket use.
		}
	}
}
