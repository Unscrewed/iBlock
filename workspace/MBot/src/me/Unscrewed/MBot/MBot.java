package me.Unscrewed.MBot;

import java.util.logging.Logger;
import me.Unscrewed.MBot.MBotListener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

	public class MBot extends JavaPlugin{
		private final MBotListener playerListener = new MBotListener();
		Logger log = Logger.getLogger("Minecraft");
		PluginDescriptionFile pdfFile = this.getDescription();

		public void onEnable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			log.info("[MBot] Version " + pdfFile.getVersion() + " enabled successfully!");
			PluginManager pm = getServer().getPluginManager();
		    pm.registerEvents(playerListener, this);
			}
		
		public void onDisable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			log.info("[MBot] Version " + pdfFile.getVersion() + " disabled successfully!");
		}
	}
