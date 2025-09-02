package ir.mohaymen.starwrapper.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class FeingClientConfig {

    @Bean
    public RequestInterceptor defaultHeadersInterceptor() {
        return (RequestTemplate requestTemplate) -> {
            requestTemplate.header("Accept", "application/json, text/plain, */*");
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("X-Mrpc-ExecNetTimeout", "6000");
        };
    }


    @Bean
    public OkHttpClient feignClient() {
        return new OkHttpClient.Builder().followRedirects(false)
                                         .followSslRedirects(false)
                                         .build();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
