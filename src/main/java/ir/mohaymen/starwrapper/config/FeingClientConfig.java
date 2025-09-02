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


    // این رو اضافه کن 👇
    @Bean
    public OkHttpClient feignClient() {
        return new OkHttpClient.Builder()
                .followRedirects(false)          // ❌ ریدایرکت عادی را غیرفعال می‌کند
                .followSslRedirects(false)       // ❌ ریدایرکت HTTPS را هم غیرفعال می‌کند
                .build();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // لاگ کامل درخواست و پاسخ
    }
}
