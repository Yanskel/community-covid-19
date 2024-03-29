package com.brice.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.brice.common.JacksonObjectMapper;

/**
 * WebMVC配置
 *
 * @author Brice
 * @date 2023/05/20
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        //设置消息转换器
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //设置自定义转换器为优先
        converters.add(0, messageConverter);
    }
}
