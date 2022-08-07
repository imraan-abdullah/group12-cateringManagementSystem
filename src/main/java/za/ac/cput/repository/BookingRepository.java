//package za.ac.cput.repository;
//
//import za.ac.cput.entity.Booking;
//
//import java.util.HashSet;
//import java.util.Set;
//import za.ac.cput.repository.IBookingRepository;
//
///*BookingRepository.java Repository for the BookingRepository
//Author: Mariam Gallie (219094837)
//Date: 4 April 2022
//*/
//public class BookingRepository implements IBookingRepository{
//    private static BookingRepository repository = null;
//    private Set<Booking> bookingDB =null;
//
//    private BookingRepository(){
//        bookingDB = new HashSet<Booking>();
//    }
//    public static BookingRepository getRepository(){
//        if (repository == null){
//            repository = new BookingRepository();
//        }
//        return repository;
//    }
//    @Override
//    public Booking create(Booking booking){
//        boolean success = bookingDB.add(booking);
//        if(!success)
//            return null;
//        return booking;
//    }
//    public Booking read( String bookingNum){
//        for (Booking b : bookingDB){
//            if(b.getBookingNum().equals(bookingNum))
//                return b;
//        }
//        return null;
//    }
//    @Override
//    public Booking update(Booking booking){
//        Booking oldbooking = read(booking.getBookingNum());
//        if(oldbooking != null){
//            bookingDB.remove(oldbooking);
//            bookingDB.add(booking);
//            return booking;
//        }
//        return null;
//    }
//    @Override
//    public boolean delete( String bookingNum){
//        Booking bookingToDelete = read(bookingNum);
//        if(bookingNum == null)
//            return false;
//        bookingDB.remove(bookingToDelete);
//        return true;
//    }@Override
//    public Set <Booking > getAll(){
//        return bookingDB;
//    }
//}
