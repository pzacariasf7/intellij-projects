package com.paul.employee.config;

import com.paul.employee.proxy.api.EmployeeApi;
import com.paul.employee.proxy.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Value("${employee.profiles.host.uri}")
    private String employeeUri;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient().setBasePath(employeeUri);
    }

    @Bean
    public EmployeeApi employeeApi() {
        return new EmployeeApi(apiClient());
    }

}
