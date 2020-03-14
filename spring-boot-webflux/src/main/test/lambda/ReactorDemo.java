package lambda;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class ReactorDemo {

    public static void main(String[] args) {
        //reactor = jdk8 stream + jdk9 reactive stream
        //Mono 0-1 个元素
        //Flux 0-n 个元素
        String[] str = {"1", "2", "3"};
        //jdk8 stream

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        Flux.fromArray(str).map(s -> Integer.parseInt(s))
                //jdk9 reactive stream
                .subscribe(subscriber);

    }
}
