package HW;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class HW {

    private static final Logger debugLogger = LogManager.getLogger("DebugLog");
    private static final Logger infoLogger = LogManager.getLogger("InfoLog");
    private static final Logger errorLogger = LogManager.getLogger("ErrorLog");

    public static void main(String[] args) {
        // Initialize Log4j2 configuration
        Configurator.initialize(null, "log4j2.xml");

        Timer debugTimer = new Timer();
        Timer infoTimer = new Timer();
        Timer errorTimer = new Timer();

        TimerTask debugTask = new TimerTask() {
            @Override
            public void run() {
                Format f = new SimpleDateFormat("HH");
                String msg = f.format(new Date());
                debugLogger.debug(msg);
            }
        };

        TimerTask infoTask = new TimerTask() {
            @Override
            public void run() {
                Format f = new SimpleDateFormat("mm");
                String msg = f.format(new Date());
                infoLogger.info(msg);
            }
        };

        TimerTask errorTask = new TimerTask() {
            @Override
            public void run() {
                Format f = new SimpleDateFormat("ss");
                String msg = f.format(new Date());
                errorLogger.error(msg);
            }
        };

        debugTimer.scheduleAtFixedRate(debugTask, 0, 1000);             // Every 1 second
        infoTimer.scheduleAtFixedRate(infoTask, 0, 1000 * 60);        // Every 1 minute
        errorTimer.scheduleAtFixedRate(errorTask, 0, 1000 * 60 * 60);  // Every 1 hour
    }
}
