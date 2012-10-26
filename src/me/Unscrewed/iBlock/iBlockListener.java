package me.Unscrewed.iBlock;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class iBlockListener implements Listener{
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
	public boolean hasPermissionDebug(Player player, String string) {
		return player.isOp() || player.hasPermission("iBlock.debug");
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if(!hasPermissionPlace(player, "iBlock.place") && iBlock.deniedBlocksPlace.contains(event.getBlock().getTypeId())){
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GREEN + "[iBlock] " + ChatColor.RED + plugin.getConfig().getString("bBlocksPlace-message"));
			if(hasPermissionDebug(player, "iBlock.debug") && plugin.getConfig().getBoolean("debugOn")){event.getPlayer().sendMessage(ChatColor.GOLD + "#DEBUG: BlockPlaceEvent: interrupted");}
		}else if(iBlock.deniedBlocksPlace.contains(event.getBlock().getTypeId())){
				//Ignore this player -- do not block banned place-able blocks.
			if(hasPermissionDebug(player, "iBlock.debug") && plugin.getConfig().getBoolean("debugOn")){event.getPlayer().sendMessage(ChatColor.GOLD + "#DEBUG: BlockPlaceEvent: successful");}
		}
	}
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(!hasPermissionBreak(player, "iBlock.break") && iBlock.deniedBlocksBreak.contains(event.getBlock().getTypeId())){
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GREEN + "[iBlock] " + ChatColor.RED + plugin.getConfig().getString("bBlocksBreak-message"));
			if(hasPermissionDebug(player, "iBlock.debug") && plugin.getConfig().getBoolean("debugOn")){event.getPlayer().sendMessage(ChatColor.GOLD + "#DEBUG: BlockBreakEvent: interrupted");}
		}else if(iBlock.deniedBlocksBreak.contains(event.getBlock().getTypeId())){
				//Ignore this player -- do not block banned breakable blocks.
			if(hasPermissionDebug(player, "iBlock.debug") && plugin.getConfig().getBoolean("debugOn")){event.getPlayer().sendMessage(ChatColor.GOLD + "#DEBUG: BlockBreakEvent: successful");}
		}
	}
}