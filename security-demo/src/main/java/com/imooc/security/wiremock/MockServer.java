//package com.imooc.security.demo.wiremock;
//
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.core.io.ClassPathResource;
//
//import static com.github.tomakehurst.wiremock.client.WireMock.*;
//
//public class MockServer {
//
//    public static void main(String[] args) throws IOException {
//        configureFor(8085);
//        removeAllMappings();
//
//        mock("/order/1", "01");
//    }
//
//    private static void mock(String url, String fileName) throws IOException {
//        ClassPathResource resource = new ClassPathResource("/mock/response/" + fileName + ".txt");
//        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
//        stubFor(get(urlEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)));
//
//    }
//
//}
