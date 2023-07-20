package com.ruoyi.admin.test.controller;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.common.utils.MessageUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

/**

* 文件描述


* @author tanqiansheng@huoxian.cn



*/
@SpringBootTest(classes = RuoYiApplication.class)
@RunWith(SpringRunner.class)
class StBookControllerTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void list() {
    }

    @org.junit.jupiter.api.Test
    void export() {
    }

    @org.junit.jupiter.api.Test
    void getInfo() {
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void edit() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void selectBooksByCategoryuuid() {
    }

    @org.junit.jupiter.api.Test
    void getPanelGroupData() {
        String message = MessageUtils.messageWithLocal("user.logout.success",Locale.getDefault(),new Object[]{11,11} );
        String message2 = MessageUtils.messageWithLocal("user.logout.success", Locale.US,new Object[]{11,11});
        System.out.println(message);
        System.out.println(message2);
//        System.out.println(MessageUtils.message("length.not.valid",1,10, Locale.getDefault()));
//        System.out.println(MessageUtils.message("length.not.valid",1,10, Locale.US));
        System.out.println(MessageUtils.messageWithLocal("no.create.permission", Locale.CHINA,"admin"));
        System.out.println(MessageUtils.messageWithLocal("no.create.permission",Locale.US,"admin"));

    }
}