package me.Unscrewed.iBlock;

import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class iBlockListener implements Listener {
	public iBlockListener(iBlock iblock) {
		plugin = iblock;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	private iBlock plugin;

	public boolean hasPermissionPlace(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.place");
	}

	public boolean hasPermissionBreak(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.break");
	}

	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		Iterator<Block> it = event.blockList().iterator();
		while (it.hasNext()) {
			if (iBlock.deniedBlocksBreak.contains(it.next().getTypeId()))
				it.remove();
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (!hasPermissionPlace(player, "iBlock.place")
				&& iBlock.deniedBlocksPlace.contains(event.getBlock()
						.getTypeId())) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(
					ChatColor.GREEN
							+ "[iBlock] "
							+ ChatColor.RED
							+ plugin.getConfig()
									.getString("bannedBlocksPlaceM"));
		} else if (iBlock.deniedBlocksPlace.contains(event.getBlock()
				.getTypeId())) {
			// Ignore this player -- do not block banned place-able blocks.
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (!hasPermissionBreak(player, "iBlock.break")
				&& iBlock.deniedBlocksBreak.contains(event.getBlock()
						.getTypeId())) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(
					ChatColor.GREEN
							+ "[iBlock] "
							+ ChatColor.RED
							+ plugin.getConfig()
									.getString("bannedBlocksBreakM"));
		} else {
			if (iBlock.deniedBlocksBreak.contains(event.getBlock().getTypeId())) {
				// Ignore this player -- do not block banned breakable blocks.
			}
		}
	}
}