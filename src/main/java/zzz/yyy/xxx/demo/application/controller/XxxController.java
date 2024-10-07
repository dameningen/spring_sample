package zzz.yyy.xxx.demo.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import zzz.yyy.xxx.demo.application.resource.Response;
import zzz.yyy.xxx.demo.domain.service.CommentService;

@RestController
@RequestMapping("api/comment")
@Slf4j
public class XxxController {

    @Value("${message}")
    private String message;

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/getcount")
    public ResponseEntity<Response<List<String>>> getMtNoteCount() {

        Response<List<String>> response = new Response<>();
        List<String> subInfo = commentService.getCount();
        response.setData(subInfo);

        log.info("★response：" + response);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/findall")
    public ResponseEntity<Response<List<String>>> findAllPayment() {

        Response<List<String>> response = new Response<>();

        log.info("★response：" + response);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "nagap", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getSomething() {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbb");
        list.add("ccccc");
        log.info("★response：" + list);

        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "nagap2", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, String>>> getSomething2() {
        List<Map<String, String>> list = new ArrayList<>();
        list.add(Map.of("key1", message, "key4", "val4"));
        list.add(Map.of("key2", "val2"));
        list.add(Map.of("key3", "val3"));

        // TODO Map.ofで作ったMapインスタンスはImmutable
        //        Map<String, String> map = list.get(1);
        //        map.clear();
        log.info("★response：" + list);

        return ResponseEntity.ok(list);
    }

}
