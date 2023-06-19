package Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeConverter {

    public static Timestamp convertToTimestamp(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

    public static LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }
}
