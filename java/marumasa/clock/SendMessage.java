package marumasa.clock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Calendar;

public class SendMessage extends BukkitRunnable {

    private boolean clock = true;
    private final Clock Minecraft ;

    public SendMessage(Clock plugin){
        Minecraft = plugin;
    }

    @Override
    public void run() {
        final Calendar calendar = Calendar.getInstance();
        final int MINUTE = calendar.get(Calendar.MINUTE);

        final int Minute = new Config(Minecraft).Minute;

        if (MINUTE == Minute + 1 && !clock) {
            clock = true;
            return;
        }

        if (MINUTE == Minute && clock) {
            clock = false;

            final int YEAR = calendar.get(Calendar.YEAR);
            final int MONDAY = calendar.get(Calendar.MONDAY) + 1;
            final int DAY = calendar.get(Calendar.DATE);
            final int HOUR = calendar.get(Calendar.HOUR_OF_DAY);

            String text = String.format(new Config(Minecraft).Message, YEAR, MONDAY, DAY, HOUR, MINUTE);
            Bukkit.broadcastMessage(ChatColor.YELLOW + text);
        }
    }
}