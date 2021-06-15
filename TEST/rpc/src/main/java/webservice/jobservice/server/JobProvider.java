package webservice.jobservice.server;

import webservice.jobservice.impl.JobServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * @author shihl
 * @date 2020/9/11 10:27
 * @description 发布服务
 *在jdk的bin目录中使用wsimport
 *  wsimport -keep -d E:\ideatest\TEST\rpc\src\main\java -p webservice.jobservice.client http://localhost:9991/ws/jobservice?WSDL
 */
public class JobProvider {
    public static void main(String[] args) {
        JobServiceImpl jobService = new JobServiceImpl();
        String address = "http://localhost:9991/ws/jobservice";
        Endpoint.publish(address, jobService);
        System.out.println("wsdl地址:" + address + "?WSDL");
    }
}
