package dev.t1dmlgus.moviemvp.common.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
public class MDCFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("ghj");
        MDC.put("TRANSACTION_ID", UUID.randomUUID().toString().substring(0, 8));
        chain.doFilter(request, response);
        MDC.remove("TRANSACTION_ID");
    }
}
