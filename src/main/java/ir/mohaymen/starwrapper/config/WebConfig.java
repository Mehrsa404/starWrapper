package ir.mohaymen.starwrapper.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;

@Configuration
public class WebConfig {

    @Bean
    public MappingJackson2HttpMessageConverter mrpcJacksonConverter(ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter conv = new MappingJackson2HttpMessageConverter(objectMapper);
        var types = new ArrayList<>(conv.getSupportedMediaTypes());
        types.add(new MediaType("application", "mrpc+json")); // application/mrpc+json
        conv.setSupportedMediaTypes(types);
        return conv;
    }
}
