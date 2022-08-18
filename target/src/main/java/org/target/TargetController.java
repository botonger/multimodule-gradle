package org.target;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class TargetController {
    @GetMapping("hello")
    public String hello() {
        return "hello World!";
    }

    @PostMapping("dxdev3")
    public ResponseEntity<Map<String, List<Member>>> hellodxdev3() {
        Map<String, List<Member>> group = new HashMap<>();
        List<Member> members = new ArrayList<>();

        Arrays.asList(
                new Member("두영","guevarra","ENFP"),
                new Member("정연", "cindy", "ESFP"),
                new Member("채연", "cheyenne", "INTP"),
                new Member("태혁", "tomas", "ENTP"),
                new Member("종휘", "tommy", "ISFJ")
        ).stream().forEach(members::add);

        group.put("members", members);

        return ResponseEntity.ok().body(group);
    }
}
