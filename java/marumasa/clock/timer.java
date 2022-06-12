package marumasa.clock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Calendar;

public class timer extends BukkitRunnable {

    boolean clock = true;

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        final int MINUTE = calendar.get(Calendar.MINUTE);

        final int MINUTE_SET = 0;

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

            String text = String.format("時報 %d/%d/%d/%d:00 になりました", YEAR, MONDAY, DAY, HOUR);
            Bukkit.broadcastMessage(ChatColor.YELLOW + text);
        }
    }
}