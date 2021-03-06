/*
 * Copyright 2014, Ragunath Jawahar (www.codeherenow.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codeherenow.bookstore.books;

import java.util.Arrays;
import java.util.List;

/**
 * A repo that supplies sample book data.
 *
 * @author Ragunath Jawahar <www.codeherenow.com>
 */
public class BooksRepository {

    public static List<Book> getBooks() {
        return Arrays.asList(
                new Book("The Hard Thing about Hard Things", "Ben Horowitz", "9780062273215", 10.99),
                new Book("Only the Paranoid Survive", "Andrew S. Grove", "9780385482585", 11.49),
                new Book("The Lost Symbol", "Dan Brown", "9781407447292", 8.99),
                new Book("Like a Virgin", "Sir Richard Branson", "9780753519929", 5.29),
                new Book("Steve Jobs: The Exclusive Biography", "Walter Isaacson", "9781442369054", 12.99),
                new Book("The E-Myth Revisited", "Michael E. Gerber", "9780887307287", 7.99),
                new Book("The Lean Startup", "Eric Ries", "9780307939869", 10.99),
                new Book("The Da Vinci Code", "Dan Brown", "9780828815130", 7.99),
                new Book("The High Performance Entrepreneur", "Subroto Bagchi", "9780670999187", 6.99),
                new Book("The Richest Man in Babylon", "George Samuel Clason", "9781304520647", 4.49),
                new Book("Ghost in the Wires", "Kevin Mitnick", "9781441793751", 8.49),
                new Book("Eat that Frog", "Brian Tracy", "9781576754221", 4.99),
                new Book("Deception Point", "Dan Brown", "9780743490306", 11.99),
                new Book("Think and Grow Rich", "Napolean Hill", "9781291976472", 6.49),
                new Book("Inferno", "Dan Brown", "9780385537865", 9.49),
                new Book("Screw it, Let's do it", "Sir Richard Branson", "9780753510995", 2.99),
                new Book("The $100 Startup", "Guillebeau C", "9780307951526", 6.99),
                new Book("Angels and Demons", "Dan Brown", "9780743501569", 10.99),
                new Book("The Secret", "Rhonda Byrne", "9788479536442", 6.99),
                new Book("Diary of a Wimpy Kid : Hard Luck", "Jeff Kinney", "9781613125885", 9.99),
                new Book("Digital Fortress", "Dan Brown", "9785559171548", 8.99),
                new Book("Head First Design Patterns",
                        "Kathy Sierra, Eric Freeman, Elisabeth Freeman, Bert", "9780596102142", 20.99),
                new Book("The 7 Habits of Highly Effective People", "Stephen R. Covey",
                        "9780783881157", 14.99)
        );
    }

}
