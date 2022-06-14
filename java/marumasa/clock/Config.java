package marumasa.clock;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public final String Message;
    public final int Minute;

    public Config(Clock plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();
        Message = config.getString("Message", "時報 %d/%d/%d/%d:%d になりました");
        Minute = config.getInt("Minute", 0);
    }
}