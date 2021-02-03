package com.company;

import java.util.HashMap;
import java.util.Map;

// класс с нужной нам информацией, допустип там книга
class Book{
    String autor;
    String name;
}

//а это читательский билет
class Ticket{
    int num; // его номер
    String LiberyName; //имя посетителя

    @Override
    public boolean equals(Object obj) { //необходим для сравнения, что бы были разные обхекты в памяти, даже при одинаковых значениях
        if (this==obj) return true;
        if(obj==null||getClass()!=obj.getClass()) return false;

        Ticket ticket = (Ticket) obj;

        if (num!=ticket.num) return false;
        return LiberyName!=null?LiberyName.equals(ticket.LiberyName):ticket.LiberyName==null;
    }

    @Override
    public int hashCode() { // создаем номер
        int result = num;
        result = 31*result+(LiberyName!=null?LiberyName.hashCode():0); //максимальный разброс
        return result;
    }
}

public class Main extends Object {

    public static void main(String[] args) {

        //создаем чит. билет
        Ticket ticket = new Ticket();
        ticket.num=123;

        // создаем книгу
        Book book = new Book();
        book.autor = "Autor N";
        book.name = "Title";

        //записываем книгу на определенного читателя
        Map<Ticket, Book> libraly= new HashMap<>();
        libraly.put(ticket, book);

        // создаем 2 читателя и пытаемся по указанному номеру взять книгу
        Ticket ticket2 = new Ticket();
        ticket2.num=123;

        //берем книгу
        Book book1=libraly.get(ticket2);
        System.out.println(book1.autor);

        //без хешкода, он выдаст ошибку, так как это уже другой класс, а соотвественно другая ячейка памяти
    }
}
