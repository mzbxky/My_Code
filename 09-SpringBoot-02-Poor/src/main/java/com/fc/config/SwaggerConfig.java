package com.fc.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration(proxyBeanMethods = false)
@EnableSwagger2WebMvc
@EnableKnife4j
public class SwaggerConfig {
    //装配Swagger的bean对象
    @Bean
    public Docket docket(){
        //创建对象
        return new Docket(DocumentationType.SWAGGER_2)
                //添加api的信息
                .apiInfo(apiInfo())
                //允许查看所有
                .select()
                //指定生成文档的路径
                .apis(RequestHandlerSelectors.basePackage("com.fc"))
                //支持上面那个路径是满足条件的
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("扶贫项目Api")
                .version("1.2")
                .description("测试Api")
                .contact(new Contact("mzb","https://github.com/mzbxky","1376055937@qq.com"))
                //许可证
                .license("mzb许可")
                //服务条款
                .termsOfServiceUrl("给我十块钱")
                //创建
                .build();
    }
}
