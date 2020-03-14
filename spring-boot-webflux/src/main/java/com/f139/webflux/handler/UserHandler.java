package com.f139.webflux.handler;

import com.f139.webflux.entry.User;
import com.f139.webflux.service.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    //@Autowired
    private final UserRepository userRepository;

    //构造方法注入
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> getAllUser(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(this.userRepository.findAll(), User.class);
    }


    public Mono<ServerResponse> createUser(ServerRequest request) {
        Mono<User> user = request.bodyToMono(User.class);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(this.userRepository.saveAll(user), User.class);
    }


    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        String id = request.pathVariable("id");
        return this.userRepository.findById(id)
                .flatMap(user -> this.userRepository.delete(user))
                .then(ServerResponse.ok().build())
                .switchIfEmpty(ServerResponse.notFound().build());

    }

}
