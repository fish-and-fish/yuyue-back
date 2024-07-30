package com.amrni.sport.shop.config.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amrni.sport.shop.config.web.ComHandlerInterceptor;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import static java.time.format.DateTimeFormatter.ofPattern;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd";

    @Resource
    private ComHandlerInterceptor comHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(comHandlerInterceptor).addPathPatterns("/**");
    }

    /**
     * 配置LocalDateTime类型序列化与反序列化
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.serializers(new LocalDateTimeSerializer(ofPattern(LOCAL_DATE_TIME_PATTERN)));
            builder.deserializers(new LocalDateTimeDeserializer(ofPattern(LOCAL_DATE_TIME_PATTERN)));
        };
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserInfoHandlerMethodArgumentResolver());
    }

    //    @Bean
    //    @Primary
    //    public ObjectMapper serializingObjectMapper() {
    //        ObjectMapper objectMapper = new ObjectMapper();
    //        JavaTimeModule javaTimeModule = new JavaTimeModule();
    //        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    //                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    //                .configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    //        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(ofPattern("yyyy-MM-dd HH:mm:ss")));
    //        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(ofPattern("yyyy-MM-dd HH:mm:ss")));
    //        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(ofPattern("HH:mm:ss")));
    //        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(ofPattern("HH:mm:ss")));
    //        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(ofPattern("yyyy-MM-dd ")));
    //        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(ofPattern("yyyy-MM-dd ")));
    //        objectMapper.registerModule(javaTimeModule);
    //        return objectMapper;
    //    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(localDateConvert());
        registry.addConverter(localDateTimeConvert());
    }

    public Converter<String, LocalDate> localDateConvert() {
        // 不能替换为lambda表达式
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                if (StringUtils.hasText(source)) {
                    return LocalDate.parse(source, ofPattern("yyyy-MM-dd"));
                }
                return null;
            }
        };
    }

    public Converter<String, LocalDateTime> localDateTimeConvert() {
        // 不能替换为lambda表达式
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                if (StringUtils.hasText(source)) {
                    return LocalDateTime.parse(source, ofPattern("yyyy-MM-dd"));
                }
                return null;
            }
        };
    }

    //    @Override
    //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
    //                .addResourceLocations("classpath:/public/").addResourceLocations("classpath:/resources/");
    //    }

}
