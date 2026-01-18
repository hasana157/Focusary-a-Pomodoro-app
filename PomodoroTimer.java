import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimer {
    private Timer timer;
    private int remainingTime; // in seconds
    private boolean isRunning;

    private Runnable onTickCallback; // Called every second
    private Runnable onFinishCallback; // Called when timer ends

    public PomodoroTimer(int durationInMinutes) {
        this.remainingTime = durationInMinutes * 60;
        this.isRunning = false;
    }

    public void start() {
        if (isRunning) return;

        isRunning = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (remainingTime > 0) {
                    remainingTime--;
                    if (onTickCallback != null) onTickCallback.run();
                } else {
                    stop();
                    if (onFinishCallback != null) onFinishCallback.run();
                }
            }
        }, 0, 1000);
    }

    public void pause() {
        if (timer != null) {
            timer.cancel();
            isRunning = false;
        }
    }

    public void reset(int durationInMinutes) {
        pause();
        this.remainingTime = durationInMinutes * 60;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setOnTick(Runnable callback) {
        this.onTickCallback = callback;
    }

    public void setOnFinish(Runnable callback) {
        this.onFinishCallback = callback;
    }

    private void stop() {
        if (timer != null) {
            timer.cancel();
            isRunning = false;
        }
    }
}
