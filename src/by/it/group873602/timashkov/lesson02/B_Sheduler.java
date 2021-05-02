package by.it.group873602.timashkov.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
даны интервальные события events
реализуйте метод calcStartTimes, так, чтобы число принятых к выполнению
непересекающихся событий было максимально.
Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class B_Sheduler {
    //событие у аудитории(два поля: начало и конец)
    static class Event {
        int start;
        int stop;

        Event(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public String toString() {
            return "("+ start +":" + stop + ")";
        }
    }

    public static void main(String[] args) {
        by.it.group873602.timashkov.lesson02.B_Sheduler instance = new by.it.group873602.timashkov.lesson02.B_Sheduler();
        by.it.group873602.timashkov.lesson02.B_Sheduler.Event[] events = {
                new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(0, 3),  new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(0, 1), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(1, 2), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(3, 5),
                new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(1, 3),  new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(1, 3), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(1, 3), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(3, 6),
                new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(2, 7),  new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(2, 3), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(2, 7), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(7, 9),
                new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(3, 5),  new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(2, 4), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(2, 3), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(3, 7),
                new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(4, 5),  new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(6, 7), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(6, 9), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(7, 9),
                new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(8, 9),  new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(4, 6), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(8, 10), new by.it.group873602.timashkov.lesson02.B_Sheduler.Event(7, 10)
        };

        List<by.it.group873602.timashkov.lesson02.B_Sheduler.Event> starts = instance.calcStartTimes(events,0,10);  //рассчитаем оптимальное заполнение аудитории
        System.out.println(starts);                                 //покажем рассчитанный график занятий
    }

    List<by.it.group873602.timashkov.lesson02.B_Sheduler.Event> calcStartTimes(by.it.group873602.timashkov.lesson02.B_Sheduler.Event[] events, int from, int to) {
        //events - события которые нужно распределить в аудитории
        //в период [from, int] (включительно).
        //оптимизация проводится по наибольшему числу непересекающихся событий.
        //начало и конец событий могут совпадать.
        List<by.it.group873602.timashkov.lesson02.B_Sheduler.Event> result;
        result = new ArrayList<>();
        //ваше решение.

        Arrays.sort(events, (e1, e2) -> {
            if(e1.stop == e2.stop)
                return Integer.compare(e1.start, e2.start);
            return Integer.compare(e1.stop, e2.stop);
        });

        int lastStop = from;
        for(int i = 0; i < events.length && events[i].stop <= to; i++) {
            if(events[i].start >= lastStop) {
                result.add(events[i]);
                lastStop = events[i].stop;
            }
        }
        return result;                        //вернем итог
    }
}