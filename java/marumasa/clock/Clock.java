package marumasa.clock;

import org.bukkit.plugin.java.JavaPlugin;

public final class Clock extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);
        new SendMessage(config).runTaskTimer(this, 0L, 600L);
    }
}