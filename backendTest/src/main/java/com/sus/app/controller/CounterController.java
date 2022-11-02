package com.sus.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CounterController {

    public static final String INDEX_TEMPLATE_VIEW_NAME = "session";
    private final Set<String> sessionIds = Collections.synchronizedSet(new HashSet<>());

    @GetMapping("/session")
    public ModelAndView sessionRequestCounts(HttpSession session) {
        this.sessionIds.add(session.getId());
        Map<String, Object> model = new HashMap<>();

        model.put("sessionType", session.getClass().getName());
        model.put("sessionCount", this.sessionIds.size());
        model.put("requestCount", getRequestCount(session));
        System.out.println(model);
        return new ModelAndView(INDEX_TEMPLATE_VIEW_NAME, model);
    }

    private Object getRequestCount(HttpSession session) {
        Integer requestCount = (Integer) session.getAttribute("requestCount");
        requestCount = requestCount != null ? requestCount : 0;
        requestCount++;
        session.setAttribute("requestCount", requestCount);
        return requestCount;
    }

    private String format(String value) {
        return String.format("<h1>%s</h1>", value);
    }


/*
        this.sessionIds.add(session.getClass().getName());
*/
}
