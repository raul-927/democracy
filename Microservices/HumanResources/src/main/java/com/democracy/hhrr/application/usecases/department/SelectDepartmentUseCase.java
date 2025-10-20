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
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

@Slf4j
@Component
public class SelectDepartmentUseCase implements SelectDepartmentIn {
    Logger LOGGER = LoggerFactory.getLogger(SelectDepartmentUseCase.class);
    private final DepartmentOut departmentOut;
    private int count = 1;
    public SelectDepartmentUseCase(DepartmentOut departmentOut) {
        this.departmentOut = departmentOut;
    }


    @Override
    public Flux<Department> selectDepartment(Department department) {

        LOGGER.info("MAP:---");
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> squaredNumbers = numbers.map(n -> n * n);
        squaredNumbers.subscribe(System.out::println);

        LOGGER.info("FILTER:---");
        Flux<Integer> evenNumbers = numbers.filter(n -> n % 2 == 0);
        evenNumbers.subscribe(System.out::println);


        LOGGER.info("ZIPPED:---");
        Flux<Integer> numbers1 = Flux.just(1, 2, 3);
        Flux<Integer> numbers2 = Flux.just(10, 20, 30);
        Flux<Tuple2<Integer, Integer>> zipped = Flux.zip(numbers1, numbers2);
        zipped.subscribe(tuple -> LOGGER.info(tuple.getT1() + ", " + tuple.getT2()));

        LOGGER.info("MERGED:---");
        Flux<Integer> numbers3 = Flux.just(1, 2, 3);
        Flux<Integer> numbers4 = Flux.just(4, 5, 6);
        Flux<Integer> merged = Flux.merge(numbers3, numbers4);
        merged.subscribe(System.out::println);


        LOGGER.info("EXPAND:---");
        Flux<Integer> numbers5 = Flux.just(1, 2, 3);
        Flux<Integer> expanded = numbers5.expand(n -> Flux.just(n * 2).takeWhile(x -> x < 10));
        expanded.subscribe(System.out::println);


        LOGGER.info("BUFFER:---");
        Flux<Integer> numbers6 = Flux.range(1, 10);
        Flux<List<Integer>> buffered = numbers6.buffer(4);
        buffered.subscribe(System.out::println);

        LOGGER.info("CACHE:---");
        Flux<Integer> numbers7 = Flux.just(1, 2, 3).cache();
        numbers7.subscribe(System.out::println); // First subscriber
        numbers7.subscribe(System.out::println); // Second subscriber (uses cached values)

        LOGGER.info("CONCAT:---");
        Flux<Integer> numbers8 = Flux.just(1, 2, 3);
        Flux<Integer> numbers9 = Flux.just(4, 5, 6);
        Flux<Integer> concatenated = Flux.concat(numbers8, numbers9);
        concatenated.subscribe(System.out::println);


        LOGGER.info("COMBINED:---");
        Flux<Integer> numbers10 = Flux.just(1, 2, 3);
        Flux<Integer> numbers11 = Flux.just(10, 20, 30);
        Flux<Integer> combined = Flux.combineLatest(numbers10, numbers11, Integer::sum);
        combined.subscribe(System.out::println);

        LOGGER.info("MONO:---");
        Mono.just(10)
                .doOnSubscribe(subscription -> LOGGER.info("Subscribed"))
                .doOnSuccess(value -> LOGGER.info("Success: {}", value))
                .doOnError(error -> LOGGER.error("Error: {}",error.getMessage()))
                .doOnTerminate(() -> LOGGER.info("Completed"))
                .subscribe();

        LOGGER.info("FLUX:---");
        Flux<Integer> numbers12 = Flux.range(1, 10)
                .limitRequest(5) // Limit to 5 elements
                .delayElements(Duration.ofMillis(500)) // Delay each element by 500 milliseconds
                .publish()
                .autoConnect(2); // Share the subscription among 2 subscribers
        numbers12.subscribe(System.out::println);
        numbers12.subscribe(System.out::println);



        LOGGER.info("GROUP_BY:---");
        Flux<Integer> numbers13 = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Flux<GroupedFlux<String, Integer>> groupedByEvenOdd = numbers13.groupBy(n -> n % 2 == 0 ? "Even" : "Odd");
        groupedByEvenOdd.subscribe(group -> {
            group.subscribe(number -> LOGGER.info(group.key() + ": " + number));
        });

        LOGGER.info("RETRY:---");
        int maxRetries = 3;
        Mono<Integer> result = Mono.fromCallable(() -> {
                    LOGGER.info("Retry count "+ count);
                    count++;
                    if (Math.random() < 0.5) {
                        throw new RuntimeException("Random error occurred");
                    }
                    return 42;
                })
                .retry(maxRetries);
        result.subscribe(
                value -> LOGGER.info("Result: {}",value),
                error -> LOGGER.error("Error: {}",error.getMessage())
        );


        LOGGER.info("RETRY_WHEN:---");
        int maxRetries2 = 3;
        Mono<Integer> result2 = Mono.fromCallable(() -> {
                    if (Math.random() < 0.5) {
                        throw new RuntimeException("Random error occurred");
                    }
                    return 42;
                })
                .retryWhen(Retry.fixedDelay(maxRetries2, Duration.ofSeconds(1)));
        result2.subscribe(
                value -> LOGGER.info("Result: {}",value),
                error -> LOGGER.error("Error: {}",error.getMessage())
        );


        LOGGER.info("FLATMAP_ITERABLE:---");
        Flux<String> words = Flux.just("Hello", "Reactor", "World");
        Flux<char[]> letters = words.flatMapIterable(word -> List.of(word.toCharArray()));
        letters.subscribe(System.out::println);



        //--------------------------------------------------------------------------------------------
        LOGGER.info("BACMPRESSURE:---");

        Flux<Integer> numbers15 = Flux.range(1, 100);
        numbers15
                .doOnRequest(requested -> LOGGER.info("Requested: " + requested))
                .subscribe(
                        value -> {
                            LOGGER.info("Received: " + value);
                            try {
                                Thread.sleep(100); // Simulate processing delay
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        },
                        error -> LOGGER.error("Error: {}",error.getMessage()), () -> LOGGER.info("Completed")
                );
// Sleep to observe backpressure in action
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//---------------------------------------------------------------------------------------------------

        LOGGER.info("BACMPRESSURE_WITH_INTERVALS:---");
        Flux<Long> intervalNumbers = Flux.interval(Duration.ofSeconds(1))
                .take(20);
        intervalNumbers
                .doOnRequest(requested -> LOGGER.info("Requested with intervals: " + requested))
                .subscribe(
                        value -> {
                            LOGGER.info("Received with intervals: " + value);
                            try {
                                Thread.sleep(2000); // Simulate slower processing
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        },
                        error -> LOGGER.error("Error: {}" ,error.getMessage())
                );

// Sleep to observe backpressure in action
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //-------------------------------------------------------------------------------------------------
        LOGGER.info("BACMPRESSURE_WITH_SLOW_CONSUMER:---");
        Flux<Integer> numbers14 = Flux.range(1, 100);
        numbers14
                .doOnRequest(requested -> LOGGER.info("Requested with slow consumer: " + requested))
                .subscribe(
                        value -> {
                            LOGGER.info("Received with slow consumer: " + value);
                            try {
                                Thread.sleep(500); // Simulate slower processing
                            } catch (InterruptedException e) {

                                e.printStackTrace();
                            }
                        },
                        error -> LOGGER.error("Error: {}" ,error.getMessage()),
                        () -> LOGGER.info("Completed")
                );

// Sleep to observe backpressure in action

        try {

            Thread.sleep(30000); // Consumer requests slowly over 30 seconds

        } catch (InterruptedException e) {

            e.printStackTrace();

        }


        Flux.interval(Duration.ofSeconds(1))
                .map(index -> "Event " + index)
                .take(10)
                .subscribe(value -> LOGGER.info("VALUE: "+value)); // L

        return departmentOut.selectDepartment(department);
    }

    @Override
    public Flux<Department> selectAllDepartment() {

        LOGGER.info("MAP:---");
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> squaredNumbers = numbers.map(n -> n * n);
        squaredNumbers.subscribe(System.out::println);

        LOGGER.info("FILTER:---");
        Flux<Integer> evenNumbers = numbers.filter(n -> n % 2 == 0);
        evenNumbers.subscribe(System.out::println);


        LOGGER.info("ZIPPED:---");
        Flux<Integer> numbers1 = Flux.just(1, 2, 3);
        Flux<Integer> numbers2 = Flux.just(10, 20, 30);
        Flux<Tuple2<Integer, Integer>> zipped = Flux.zip(numbers1, numbers2);
        zipped.subscribe(tuple -> LOGGER.info(tuple.getT1() + ", " + tuple.getT2()));

        LOGGER.info("MERGED:---");
        Flux<Integer> numbers3 = Flux.just(1, 2, 3);
        Flux<Integer> numbers4 = Flux.just(4, 5, 6);
        Flux<Integer> merged = Flux.merge(numbers3, numbers4);
        merged.subscribe(System.out::println);


        LOGGER.info("EXPAND:---");
        Flux<Integer> numbers5 = Flux.just(1, 2, 3);
        Flux<Integer> expanded = numbers5.expand(n -> Flux.just(n * 2).takeWhile(x -> x < 10));
        expanded.subscribe(System.out::println);


        LOGGER.info("BUFFER:---");
        Flux<Integer> numbers6 = Flux.range(1, 10);
        Flux<List<Integer>> buffered = numbers6.buffer(4);
        buffered.subscribe(System.out::println);

        LOGGER.info("CACHE:---");
        Flux<Integer> numbers7 = Flux.just(1, 2, 3).cache();
        numbers7.subscribe(System.out::println); // First subscriber
        numbers7.subscribe(System.out::println); // Second subscriber (uses cached values)

        LOGGER.info("CONCAT:---");
        Flux<Integer> numbers8 = Flux.just(1, 2, 3);
        Flux<Integer> numbers9 = Flux.just(4, 5, 6);
        Flux<Integer> concatenated = Flux.concat(numbers8, numbers9);
        concatenated.subscribe(System.out::println);


        LOGGER.info("COMBINED:---");
        Flux<Integer> numbers10 = Flux.just(1, 2, 3);
        Flux<Integer> numbers11 = Flux.just(10, 20, 30);
        Flux<Integer> combined = Flux.combineLatest(numbers10, numbers11, Integer::sum);
        combined.subscribe(System.out::println);

        LOGGER.info("MONO:---");
        Mono.just(10)
                .doOnSubscribe(subscription -> LOGGER.info("Subscribed"))
                .doOnSuccess(value -> LOGGER.info("Success: " + value))
                .doOnError(error -> LOGGER.error("Error: {}" ,error.getMessage()))
                .doOnTerminate(() -> LOGGER.info("Completed"))
                .subscribe();

        LOGGER.info("FLUX:---");
        Flux<Integer> numbers12 = Flux.range(1, 10)
                .limitRequest(5) // Limit to 5 elements
                .delayElements(Duration.ofMillis(500)) // Delay each element by 500 milliseconds
                .publish()
                .autoConnect(2); // Share the subscription among 2 subscribers
        numbers12.subscribe(System.out::println);
        numbers12.subscribe(System.out::println);



        LOGGER.info("GROUP_BY:---");
        Flux<Integer> numbers13 = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Flux<GroupedFlux<String, Integer>> groupedByEvenOdd = numbers13.groupBy(n -> n % 2 == 0 ? "Even" : "Odd");
        groupedByEvenOdd.subscribe(group -> {
            group.subscribe(number -> LOGGER.info(group.key() + ": " + number));
        });

        LOGGER.info("RETRY:---");
        int maxRetries = 3;
        Mono<Integer> result = Mono.fromCallable(() -> {
                    LOGGER.info("Retry count "+ count);
                    count++;
                    if (Math.random() < 0.5) {
                        throw new RuntimeException("Random error occurred");
                    }
                    return 42;
                })
                .retry(maxRetries);
        result.subscribe(
                value -> LOGGER.info("Result: " + value),
                error -> LOGGER.error("Error: {}" ,error.getMessage())
        );


        LOGGER.info("RETRY_WHEN:---");
        int maxRetries2 = 3;
        Mono<Integer> result2 = Mono.fromCallable(() -> {
                    if (Math.random() < 0.5) {
                        throw new RuntimeException("Random error occurred");
                    }
                    return 42;
                })
                .retryWhen(Retry.fixedDelay(maxRetries2, Duration.ofSeconds(1)));
        result2.subscribe(
                value -> LOGGER.info("Result: " + value),
                error -> LOGGER.error("Error: {}" ,error.getMessage())
        );


        LOGGER.info("FLATMAP_ITERABLE:---");
        Flux<String> words = Flux.just("Hello", "Reactor", "World");
        Flux<char[]> letters = words.flatMapIterable(word -> Arrays.asList(word.toCharArray()));
        letters.subscribe(System.out::println);



        //--------------------------------------------------------------------------------------------
        LOGGER.info("BACMPRESSURE:---");

        Flux<Integer> numbers15 = Flux.range(1, 100);
        numbers15
                .doOnRequest(requested -> LOGGER.info("Requested: " + requested))
                .subscribe(
                        value -> {
                            LOGGER.info("Received: " + value);
                            try {
                                Thread.sleep(100); // Simulate processing delay
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        },
                        error -> LOGGER.error("Error: {}" ,error.getMessage()), () -> LOGGER.info("Completed")
                );
// Sleep to observe backpressure in action
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//---------------------------------------------------------------------------------------------------

        LOGGER.info("BACMPRESSURE_WITH_INTERVALS:---");
        Flux<Long> intervalNumbers = Flux.interval(Duration.ofSeconds(1))
                .take(20);
        intervalNumbers
                .doOnRequest(requested -> LOGGER.info("Requested with intervals: " + requested))
                .subscribe(
                        value -> {
                            LOGGER.info("Received with intervals: " + value);
                            try {
                                Thread.sleep(2000); // Simulate slower processing
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        },
                        error -> LOGGER.error("Error: {}" ,error.getMessage())
                );

// Sleep to observe backpressure in action
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    //-------------------------------------------------------------------------------------------------
        LOGGER.info("BACMPRESSURE_WITH_SLOW_CONSUMER:---");
        Flux<Integer> numbers14 = Flux.range(1, 20);
        numbers14
                .doOnRequest(requested -> LOGGER.info("Requested with slow consumer: " + requested))
                .subscribe(
                        value -> {
                            LOGGER.info("Received with slow consumer: " + value);
                            try {
                                Thread.sleep(500); // Simulate slower processing
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        },
                        error -> LOGGER.error("Error: {}" ,error.getMessage()),
                        () -> LOGGER.info("Completed")
                );

    // Sleep to observe backpressure in action

        try {

            Thread.sleep(30000); // Consumer requests slowly over 30 seconds

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        Flux.interval(Duration.ofSeconds(1))
                .map(index -> "Event " + index)
                .take(10)
                .subscribe(value -> LOGGER.info("VALUE: "+value)); // L

        return departmentOut.selectAllDepartment();
    }

    @Override
    public Mono<Long> selectCount() {
        return departmentOut.selectCount();
    }
}
