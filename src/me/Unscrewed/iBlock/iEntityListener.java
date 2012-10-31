package me.Unscrewed.iBlock;

import java.util.Iterator;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class iEntityListener implements Listener {
	public iEntityListener(iBlock iblock) {
		plugin = iblock;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	private iBlock plugin;
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		Iterator<Block> it = event.blockList().iterator();
		while (it.hasNext()) {
			if (plugin.getConfig().getIntegerList("bannedBlocksBreak").contains(it.next().getTypeId()))
				it.remove();
			
		}
	}
}
