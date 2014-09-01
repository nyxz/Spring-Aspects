package com.test.aspect.logged;

import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LongWait {

    private static final Logger LOG = Logger.getAnonymousLogger();

    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Long run() {
        LOG.info("Running run()");
        long sum = 0;

        for (long i = 0; i < 1000000; i++) {
            sum += i;
        }

        return sum;
    }
    

    @RequestMapping(value = "/dumb", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void dumb() {
        LOG.info("Running dumb()");
    }
}
