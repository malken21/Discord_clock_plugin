package marumasa.clock;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public String Message;
    public int Minute;

    public void load(Clock plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();
        Message = config.getString("Message", "時報 %d/%d/%d/%d:%d になりました");
        Minute = config.getInt("Minute", 0);
    }
}