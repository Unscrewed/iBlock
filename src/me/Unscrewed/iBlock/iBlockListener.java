package me.Unscrewed.iBlock;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class iBlockListener implements Listener {
	public iBlockListener(iBlock iblock) {
		plugin = iblock;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	private iBlock plugin;

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPermission("iBlock.place") && iBlock.deniedBlocksPlace.contains(event.getBlock().getTypeId())) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GREEN + "[iBlock] " + ChatColor.RED + plugin.getConfig().getString("bannedBlocksPlaceM"));
		} else if (iBlock.deniedBlocksPlace.contains(event.getBlock().getTypeId())) {
			// Ignore this player -- do not block banned place-able blocks.
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPermission("iBlock.break")
				&& iBlock.deniedBlocksBreak.contains(event.getBlock().getTypeId())) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GREEN + "[iBlock] " + ChatColor.RED + plugin.getConfig().getString("bannedBlocksBreakM"));
		} else {
			if (iBlock.deniedBlocksBreak.contains(event.getBlock().getTypeId())) {
				// Ignore this player -- do not block banned breakable blocks.
			}
		}
		
	}
}