package de.cubeisland.AntiGuest.Punishments;

import de.cubeisland.AntiGuest.Punishment;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

/**
 * Sends a awkward message from the user
 *
 * @author Phillip Schichtel
 */
public class MessagePunishment implements Punishment
{
    public String getName()
    {
        return "message";
    }

    public void punish(Player player, ConfigurationSection config)
    {
        if (config.contains("message"))
        {
            player.chat(config.getString("message"));
        }
    }
}
