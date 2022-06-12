package marumasa.clock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Calendar;

public class timer extends BukkitRunnable {
    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        int MINUTE = calendar.get(Calendar.MINUTE);
        if (MINUTE == 0) {
            int YEAR = calendar.get(Calendar.YEAR);
            int MONDAY = calendar.get(Calendar.MONDAY) + 1;
            int DAY = calendar.get(Calendar.DATE);
            int HOUR = calendar.get(Calendar.HOUR_OF_DAY);

            String text = String.format("時報 %d/%d/%d/%d:00 になりました", YEAR, MONDAY, DAY, HOUR);
            Bukkit.broadcastMessage(ChatColor.YELLOW + text);
        }
    }
}