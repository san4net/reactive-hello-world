package org.santi;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HelloFlowable {

    private static void flowable(){
        Flowable.fromStream(Stream.of(1,2,3))
                .filter(i-> i<3)
                .subscribe(System.out::println);
    }


  private static void flowableHeavyOperation() throws InterruptedException {
      Flowable.fromCallable(()->{
          return "result";
      }).observeOn(Schedulers.io())
              .observeOn(Schedulers.single())
              .subscribe(System.out::println, Throwable::printStackTrace);
      Thread.sleep(2000);
  }
    private <T> List<T> newArrayList(T... item) {
        List<T> list = new ArrayList<>();
        for(T t: item){
            list.add(t);
        }
        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        flowable();
        flowableHeavyOperation();
    }
}
