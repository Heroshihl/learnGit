package com.shihl.stress_testing;

import lombok.extern.slf4j.Slf4j;


import javax.ws.rs.client.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 石华磊
 * @description
 * @date 2021/6/29
 */
@Slf4j
public class RestfullClient {

    public static AtomicLong sendRestfullSeccessCount = new AtomicLong(0L);
    public static AtomicLong sendRestfullFailedCount = new AtomicLong(0L);
    public static Client client = ClientBuilder.newClient();

    public RestfullClient() {
    }

    /**发送rest接口
     * @param url 请求路径
     * @param method curd
     * @param jsondata json数据
     * @param queryparams 信息参数
     * @param header 消息头
     * @return
     * @throws Exception
     */
    public static String sendRestfull3(String url, String method, String jsondata,
                                       Map<String, String[]> queryparams, List<String> header) throws Exception {
        Response resp = null;

        String head;
        try {
            WebTarget target = client.target(url);
            Builder builder = null;
            builder = target.request();
            Iterator var8;
            String[] headers;
            if (null != header) {
                var8 = header.iterator();

                while (var8.hasNext()) {
                    head = (String) var8.next();
                    headers = head.split(":");
                    if (headers.length == 2) {
                        builder = builder.header(headers[0], headers[1]);
                    }
                }
            }

            if (method.equals("get")) {
                Entry entry;
                if (null != queryparams && !queryparams.isEmpty()) {
                    for (var8 = queryparams.entrySet().iterator(); var8.hasNext();
                         target = target.queryParam((String) entry.getKey(), (Object[]) entry.getValue())) {
                        entry = (Entry) var8.next();
                    }
                }

                builder = target.request();
                if (null != header) {
                    var8 = header.iterator();

                    while (var8.hasNext()) {
                        head = (String) var8.next();
                        headers = head.split(":");
                        if (headers.length == 2) {
                            builder = builder.header(headers[0], headers[1]);
                        }
                    }
                }

                resp = builder.get();
            } else if (method.equals("put")) {
                resp = builder.accept(new String[]{"*/*"}).put(Entity.entity(jsondata, StaticHeadNames.CONTENTTYPE));
            } else if (method.equals("post")) {
                resp = builder.accept(new String[]{"*/*"}).post(Entity.entity(jsondata, StaticHeadNames.CONTENTTYPE));
            } else if (method.equals("delete")) {
                if (null != jsondata && !"".equals(jsondata)) {
                    target = target.queryParam("IDList", new Object[]{jsondata});
                }

                builder = target.request();
                if (null != header) {
                    var8 = header.iterator();

                    while (var8.hasNext()) {
                        head = (String) var8.next();
                        headers = head.split(":");
                        if (headers.length == 2) {
                            builder = builder.header(headers[0], headers[1]);
                        }
                    }
                }

                resp = (Response) builder.accept(new String[]{"*/*"}).delete(Response.class);
            }

            log.debug("http状态码: {}", resp.getStatus());
            if (resp.getStatus() != 200) {
                throw new RuntimeException(resp.getStatusInfo().toString());
            }

            String entity = (String) resp.readEntity(String.class);
            sendRestfullSeccessCount.incrementAndGet();
            head = entity;
        } catch (Exception var14) {
            sendRestfullFailedCount.incrementAndGet();
            throw var14;
        } finally {
            if (resp != null) {
                resp.close();
            }

        }

        return head;
    }

    static {
        client.property("jersey.config.client.connectTimeout", 15000);
        client.property("jersey.config.client.readTimeout", 120000);
    }
}
