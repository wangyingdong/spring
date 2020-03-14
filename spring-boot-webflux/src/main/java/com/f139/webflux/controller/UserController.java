package com.f139.webflux.controller;


import com.f139.webflux.entry.User;
import com.f139.webflux.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found")
    public void notFound() {
    }

    @GetMapping("/")
    public Flux<User> findALL() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/stream/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamFindAll() {
        return userRepository.findAll();
    }


    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> findById(@PathVariable String id) {
        return userRepository.findById(id)
                .map(u -> new ResponseEntity<User>(u, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/age/{start}/{end}")
    public Flux<User> findByAge(@PathVariable Integer start, @PathVariable Integer end) {
        return userRepository.findByAgeBetween(start, end);

    }


    @GetMapping(value = "/stream/age/{start}/{end}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamFindByAge(@PathVariable Integer start, @PathVariable Integer end) {
        return userRepository.findByAgeBetween(start, end);

    }


    @PostMapping("")
    public Mono<User> create(@Valid @RequestBody User user) {
        //spring data jpa 新增和修改都是save，有ID是修改，没有ID是新增
        return userRepository.save(user);
    }


    //存在返回200,和修改的数据，不存在404
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> update(@PathVariable String id,  @Valid @RequestBody User user) {

        return this.userRepository.findById(id)
                .flatMap(u -> {
                    u.setAge(user.getAge());
                    u.setName(user.getName());
                    return this.userRepository.save(u);
                })
                .map(u -> new ResponseEntity<User>(u, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity(HttpStatus.NOT_FOUND));

    }

    //存在返回200，不存在404
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {

        //没有返回值 userRepository.deleteById(id);
        return this.userRepository.findById(id)
                //如果操作数据，返回Mono的时候用flatMap,如果不操作数据，只是数据转换，用map
                .flatMap(user -> this.userRepository.delete(user).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity(HttpStatus.NOT_FOUND));

    }


}
