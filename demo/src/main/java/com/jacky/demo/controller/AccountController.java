package com.jacky.demo.controller;


import com.jacky.demo.dto.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 一、
 * 存款 帳戶+金額 “存款成功，帳戶餘額顯示”
 * 提款 帳戶+金額 “提款成功，帳戶餘額顯示”
 *
 * Error
 * 1.帳戶不存在
 * 2.餘額不足
 *
 * */

@RestController
public class AccountController {


        private Map<Integer, Integer> accounts = new HashMap<>(); // 存儲帳戶餘額的map

        @PutMapping("/accounts/{userId}/deposit")
        public ResponseEntity<String> deposit(@PathVariable Integer userId,
                                              @RequestBody UserRequest userRequest){

            Integer account = userRequest.getAccount();
            Integer balance = accounts.getOrDefault(userId, 0); // 如果不存在，返回默認值0
            accounts.put(userId, balance + account);
            return ResponseEntity.ok("存款成功，帳戶餘額為：" + accounts.get(userId));
        }

        @PutMapping("/accounts/{userId}/withdraw")
        public ResponseEntity<String> withdraw(@PathVariable Integer userId,
                                               @RequestBody UserRequest userRequest){

            Integer account = userRequest.getAccount();
            Integer balance = accounts.get(userId);

            if (balance == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("帳戶不存在");
            }
            if(balance < account){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("餘額不足");
            }
            accounts.put(userId, balance - account);
            return ResponseEntity.ok("提款成功，帳戶餘額為：" + accounts.get(userId));
        }
    }





