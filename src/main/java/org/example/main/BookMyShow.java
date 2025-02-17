package org.example.main;
import org.example.services.BookingService;

import java.util.*;

public class BookMyShow {


    public static void main(String[] args) {

        BookingService bookService = BookingService.getInstance(); //Use a Singleton Pattern
        bookService.initialize();
        bookService.startBookingSession();
    }
}
