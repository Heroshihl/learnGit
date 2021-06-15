package webservice.jobservice;

import webservice.jobservice.client.JobService;
import webservice.jobservice.client.JobServiceImplService;

/**
 * @author shihl
 * @date 2020/9/11 10:33
 * @description
 */
public class Test {
    public static void main(String[] args) {
        JobServiceImplService jobServiceImplService = new JobServiceImplService();
        JobService service = jobServiceImplService.getJobServiceImplPort();
        String job = service.getJob();
        System.out.println(job);
    }
}
