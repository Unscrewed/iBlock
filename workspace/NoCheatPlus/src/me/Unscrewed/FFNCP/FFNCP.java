package me.Unscrewed.FFNCP;

import java.util.logging.Logger;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

	public class FFNCP extends JavaPlugin{
		private final FFNCP playerListener = new FFNCP();
		Logger log = Logger.getLogger("Minecraft");
		PluginDescriptionFile pdfFile = this.getDescription();

		public void onEnable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			log.info("[FFNCP] Version " + pdfFile.getVersion() + " enabled successfully!");
			PluginManager pm = getServer().getPluginManager();
		    pm.registerEvents(playerListener, this);
			}
		
		public void onDisable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			log.info("[FFNCP] Version " + pdfFile.getVersion() + " disabled successfully!");
		}
	}

