package marumasa.clock;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private final Clock plugin;
    private FileConfiguration config = null;

    private String Message;
    private int Minute;

    public Config(Clock plugin) {
        this.plugin = plugin;
        load();
    }

    public void load() {
        plugin.saveDefaultConfig();
        if (config != null) {
            plugin.reloadConfig();
        }
        config = plugin.getConfig();
        Message = config.getString("Message", "時報 %d/%d/%d/%d:%d になりました");
        Minute = config.getInt("Minute",0);
    }

    public String getMessage() {
        return Message;
    }
    public int getMinute() {
        return Minute;
    }
}