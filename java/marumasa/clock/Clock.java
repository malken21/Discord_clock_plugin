package marumasa.clock;

import org.bukkit.plugin.java.JavaPlugin;

public final class Clock extends JavaPlugin {

    @Override
    public void onEnable() {
        new timer().runTaskTimer(this, 0L, 600L);
    }
}