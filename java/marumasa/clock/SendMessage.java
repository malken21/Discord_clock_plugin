package marumasa.clock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Calendar;

public class SendMessage extends BukkitRunnable {

    private boolean clock = true;
    private final Config config;

    public SendMessage(Config data) {
        config = data;
    }

    @Override
    public void run() {
        final Calendar calendar = Calendar.getInstance();
        final int MINUTE = calendar.get(Calendar.MINUTE);

        final int Minute = config.Minute;

        if (MINUTE != Minute && !clock) {
            clock = true;
            return;
        }

        if (MINUTE == Minute && clock) {
            clock = false;

            final int YEAR = calendar.get(Calendar.YEAR);
            final int MONDAY = calendar.get(Calendar.MONDAY) + 1;
            final int DAY = calendar.get(Calendar.DATE);
            final int HOUR = calendar.get(Calendar.HOUR_OF_DAY);

            String text = String.format(config.Message, YEAR, MONDAY, DAY, HOUR, String.format("%02d", MINUTE));
            Bukkit.broadcastMessage(ChatColor.YELLOW + text);
        }
    }
}