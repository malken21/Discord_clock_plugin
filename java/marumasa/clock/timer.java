package marumasa.clock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Calendar;

public class timer extends BukkitRunnable {

    private boolean clock = true;

    @Override
    public void run() {
        final Calendar calendar = Calendar.getInstance();
        final int MINUTE = calendar.get(Calendar.MINUTE);

        final int MINUTE_SET = new Clock().getMinute();

        if (MINUTE == MINUTE_SET + 1 && !clock) {
            clock = true;
            return;
        }

        if (MINUTE == MINUTE_SET && clock) {
            clock = false;

            final int YEAR = calendar.get(Calendar.YEAR);
            final int MONDAY = calendar.get(Calendar.MONDAY) + 1;
            final int DAY = calendar.get(Calendar.DATE);
            final int HOUR = calendar.get(Calendar.HOUR_OF_DAY);

            String text = String.format(new Clock().getMessage(), YEAR, MONDAY, DAY, HOUR, MINUTE);
            Bukkit.broadcastMessage(ChatColor.YELLOW + text);
        }
    }
}