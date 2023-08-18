package org.example.fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Напишіть програму, що виводить в консоль рядок, що складається з чисел від 1 до n, але з заміною деяких значень:

якщо число ділиться на 3 - вивести fizz
якщо число ділиться на 5 - вивести buzz
якщо число ділиться на 3 і на 5 одночасно - вивести fizzbuzz
Наприклад, для n = 15, очікується такий результат: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

Програма повинна бути багатопотоковою, і працювати з 4 потоками:

Потік A викликає fizz(), щоб перевірити, чи ділиться число на 3, і якщо так - додати в чергу на виведення для потоку D рядок fizz.
Потік B викликає buzz(), щоб перевірити, чи ділиться число на 5, і якщо так - додати в чергу на виведення для потоку D рядок buzz.
Потік C викликає fizzbuzz(), щоб перевірити, чи ділиться число на 3 та 5 одночасно, і якщо так - додати в чергу на виведення для потоку D рядок fizzbuzz.
Потік D викликає метод number(), щоб вивести наступне число з черги, якщо є таке число для виведення.*/
public class Task2 {
    public static void main(String[] args) {
        System.out.println("Input n:");
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        FizzBuzz fizzBuzz = new FizzBuzz();
        NumberProcessor numberProcessorFizz = new NumberProcessor((numb)->fizzBuzz.fizz(numb),n);
        NumberProcessor numberProcessorBuzz = new NumberProcessor((numb)->fizzBuzz.buzz(numb),n);
        NumberProcessor numberProcessorFizzBuzz = new NumberProcessor((numb)->fizzBuzz.fizzBuzz(numb),n);
        NumberProcessor numberProcessorNotFizzBuzz = new NumberProcessor((numb)->fizzBuzz.notFizzBuzz(numb),n);
        List<NumberProcessor> threadList = new ArrayList<>();

        threadList.add(numberProcessorFizz);
        threadList.add(numberProcessorBuzz);
        threadList.add(numberProcessorFizzBuzz);
        threadList.add(numberProcessorNotFizzBuzz);

        for(NumberProcessor t: threadList) {
            t.start();
        }
        for(int i = 1; i <= n; i++) {
            for(NumberProcessor t: threadList) {
                t.process(i);
            }
            while(true) {
                int processed = 0;
                for(NumberProcessor t:threadList) {
                    if(t.isNProcessed()) {
                        ++processed;
                    }
                }
                if(processed == 4) {
                    break;
                }
            }
        }
        System.out.println(fizzBuzz.getQueue());

    }
}
