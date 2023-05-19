package jodatimeapi;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoField;

public class JodaTimeAPI {
	public static void main(String[] args) {
		LocalTime t = LocalTime.now();
		System.out.println("Current time: " + t);
		t = t.minusHours(3);
		System.out.println("Current time minus 3: " + t);
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("Current date: " + dt);
		
		dt = LocalDateTime.of(1753, 6, 27, 22, 55);
		System.out.println("Custom date: " + dt);
		
		//Zoned time:
		//OffsetDateTime only takes the offset of the zone without the zone's information.
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("\nZoned time:\n" + zdt);
		ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(zdt2);
		
		//Standalone time:
		MonthDay md = MonthDay.now();
		System.out.println("\nStand alone time:\n" + md);
		Year y = Year.now();
		System.out.println(y);
		YearMonth ym = YearMonth.now();
		System.out.println(ym);
		
		//Period is a period that can be added or subtracted from a date:
		System.out.println("\nPeriod:");
		Period p = Period.of(20, 5, 10);
		System.out.println(p.addTo(LocalDate.now()));
		
		//Duration is a duration of time that can be added or subtracted from a date and time:
		System.out.println("\nDuration:");
		Duration d = Duration.ofHours(12);
		System.out.println(LocalTime.now());
		System.out.println(d.addTo(LocalTime.now()));
		
		//Instant takes the current time with a fixed time zone of GMT+0.
		System.out.println("\nInstant:");
		Instant i = Instant.now();
		System.out.println(i);
		
		/* Formatter:
		Z = Offset		S = Milisecond	H = Hour(0-23)	M = Month	y = year
		z = Timezone	s = Second		h = Hour(0-11)	m = Minute	d = day
		We can create our own format or use a constant method to use a predefined one. */
		System.out.println("\nFormatter:");
		LocalDateTime ldt = LocalDateTime.now();
		//A predefined format:
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
		//Custom format:
		DateTimeFormatter df2 = DateTimeFormatter.ofPattern("dd|MM|yyyy HH/mm/ss/SSSSSSSSS");
		
		System.out.println("Predefined: " + df.format(ldt));
		System.out.println("Custom: " + df2.format(ldt));
		
		//ChronoField:
		System.out.println("\nChronoField:");
		LocalDateTime lt = LocalDateTime.now();
		System.out.println("Date: " + DateTimeFormatter.ISO_DATE_TIME.format(lt));
		System.out.println("Week of the month: " + lt.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
		System.out.println("Clock Hour: " + lt.get(ChronoField.CLOCK_HOUR_OF_DAY));
		System.out.println("AM(0) or PM(1)? " + lt.get(ChronoField.AMPM_OF_DAY));
		System.out.println("Current minute: " + lt.get(ChronoField.MINUTE_OF_HOUR));
	}
}