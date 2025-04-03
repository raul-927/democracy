package com.democracy.hhrr.application.usecases.department;

import com.democracy.hhrr.domain.models.Department;
import com.democracy.hhrr.domain.ports.in.department.SelectDepartmentIn;
import com.democracy.hhrr.domain.ports.out.DepartmentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


@Component
public class SelectDepartmentUseCase implements SelectDepartmentIn {

    private final DepartmentOut departmentOut;
    private int count = 1;
    public SelectDepartmentUseCase(DepartmentOut departmentOut) {
        this.departmentOut = departmentOut;
    }


    @Override
    public Flux<Department> selectDepartment(Department department) {

        System.out.println("MAP:---");
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> squaredNumbers = numbers.map(n -> n * n);
        squaredNumbers.subscribe(System.out::println);

        System.out.println("FILTER:---");
        Flux<Integer> evenNumbers = numbers.filter(n -> n % 2 == 0);
        evenNumbers.subscribe(System.out::println);


        System.out.println("ZIPPED:---");
        Flux<Integer> numbers1 = Flux.just(1, 2, 3);
        Flux<Integer> numbers2 = Flux.just(10, 20, 30);
        Flux<Tuple2<Integer, Integer>> zipped = Flux.zip(numbers1, numbers2);
        zipped.subscribe(tuple -> System.out.println(tuple.getT1() + ", " + tuple.getT2()));

        System.out.println("MERGED:---");
        Flux<Integer> numbers3 = Flux.just(1, 2, 3);
        Flux<Integer> numbers4 = Flux.just(4, 5, 6);
        Flux<Integer> merged = Flux.merge(numbers3, numbers4);
        merged.subscribe(System.out::println);


        System.out.println("EXPAND:---");
        Flux<Integer> numbers5 = Flux.just(1, 2, 3);
        Flux<Integer> expanded = numbers5.expand(n -> Flux.just(n * 2).takeWhile(x -> x < 10));
        expanded.subscribe(System.out::println);


        System.out.println("BUFFER:---");
        Flux<Integer> numbers6 = Flux.range(1, 10);
        Flux<List<Integer>> buffered = numbers6.buffer(4);
        buffered.subscribe(System.out::println);

        System.out.println("CACHE:---");
        Flux<Integer> numbers7 = Flux.just(1, 2, 3).cache();
        numbers7.subscribe(System.out::println); // First subscriber
        numbers7.subscribe(System.out::println); // Second subscriber (uses cached values)

        System.out.println("CONCAT:---");
        Flux<Integer> numbers8 = Flux.just(1, 2, 3);
        Flux<Integer> numbers9 = Flux.just(4, 5, 6);
        Flux<Integer> concatenated = Flux.concat(numbers8, numbers9);
        concatenated.subscribe(System.out::println);


        System.out.println("COMBINED:---");
        Flux<Integer> numbers10 = Flux.just(1, 2, 3);
        Flux<Integer> numbers11 = Flux.just(10, 20, 30);
        Flux<Integer> combined = Flux.combineLatest(numbers10, numbers11, (n1, n2) -> n1 + n2);
        combined.subscribe(System.out::println);

        System.out.println("MONO:---");
        Mono.just(10)
                .doOnSubscribe(subscription -> System.out.println("Subscribed"))
                .doOnSuccess(value -> System.out.println("Success: " + value))
                .doOnError(error -> System.err.println("Error: " + error.getMessage()))
                .doOnTerminate(() -> System.out.println("Completed"))
                .subscribe();

        System.out.println("FLUX:---");
        Flux<Integer> numbers12 = Flux.range(1, 10)
                .limitRequest(5) // Limit to 5 elements
                .delayElements(Duration.ofMillis(500)) // Delay each element by 500 milliseconds
                .publish()
                .autoConnect(2); // Share the subscription among 2 subscribers
        numbers12.subscribe(System.out::println);
        numbers12.subscribe(System.out::println);



        System.out.println("GROUP_BY:---");
        Flux<Integer> numbers13 = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Flux<GroupedFlux<String, Integer>> groupedByEvenOdd = numbers13.groupBy(n -> n % 2 == 0 ? "Even" : "Odd");
        groupedByEvenOdd.subscribe(group -> {
            group.subscribe(number -> System.out.println(group.key() + ": " + number));
        });

        System.out.println("RETRY:---");
        int maxRetries = 3;
        Mono<Integer> result = Mono.fromCallable(() -> {
                    System.out.println("Retry count "+ count);
                    count++;
                    if (Math.random() < 0.5) {
                        throw new RuntimeException("Random error occurred");
                    }
                    return 42;
                })
                .retry(maxRetries);
        result.subscribe(
                value -> System.out.println("Result: " + value),
                error -> System.err.println("Error: " + error.getMessage())
        );


        System.out.println("RETRY_WHEN:---");
        int maxRetries2 = 3;
        Mono<Integer> result2 = Mono.fromCallable(() -> {
                    if (Math.random() < 0.5) {
                        throw new RuntimeException("Random error occurred");
                    }
                    return 42;
                })
                .retryWhen(Retry.fixedDelay(maxRetries2, Duration.ofSeconds(1)));
        result2.subscribe(
                value -> System.out.println("Result: " + value),
                error -> System.err.println("Error: " + error.getMessage())
        );


        System.out.println("FLATMAP_ITERABLE:---");
        Flux<String> words = Flux.just("Hello", "Reactor", "World");
        Flux<char[]> letters = words.flatMapIterable(word -> Arrays.asList(word.toCharArray()));
        letters.subscribe(System.out::println);



        //--------------------------------------------------------------------------------------------
        Flux<Integer> numbers15 = Flux.range(1, 100);
        numbers15
                .doOnRequest(requested -> System.out.println("Requested: " + requested))
                .subscribe(
                        value -> {
                            System.out.println("Received: " + value);
                            try {
                                Thread.sleep(100); // Simulate processing delay
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        },
                        error -> System.err.println("Error: " + error.getMessage()), () -> System.out.println("Completed")
                );
// Sleep to observe backpressure in action
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return departmentOut.selectDepartment(department);
    }

    @Override
    public Flux<Department> selectAllDepartment() {
        return departmentOut.selectAllDepartment();
    }

    @Override
    public Mono<Long> selectCount() {
        return departmentOut.selectCount();
    }
}
