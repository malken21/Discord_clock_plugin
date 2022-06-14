package marumasa.clock;

import org.bukkit.plugin.java.JavaPlugin;

public final class Clock extends JavaPlugin {

    @Override
    public void onEnable() {
        new Config().load(this);
        new SendMessage().runTaskTimer(this, 0L, 600L);
    }
}