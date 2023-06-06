package Test;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Test {
    private LocalTime startZeit;
    private LocalTime endZeit;

    public Test(LocalTime startZeit, LocalTime endZeit) {
        this.startZeit = startZeit;
        this.endZeit = endZeit;
    }

    public long berechneDauerInMillisekunden() {
        long dauerInSekunden = startZeit.until(endZeit, ChronoUnit.SECONDS);
        long dauerInMillisekunden = dauerInSekunden * 1000;

        return dauerInMillisekunden;
    }
}