package marumasa.clock;

import org.bukkit.plugin.java.JavaPlugin;

public final class Clock extends JavaPlugin {

    private Config config;
    @Override
    public void onEnable() {
        config = new Config(this);
        new timer().runTaskTimer(this, 0L, 600L);
    }

    public String getMessage() {
        return config.getMessage();
    }
    public int getMinute() {
        return config.getMinute();
    }
}