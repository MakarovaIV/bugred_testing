package utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClient {
    static final String charset = "utf-8";
    public static User sendPOST(CloseableHttpClient srv, String postParam) throws IOException {
        HttpPost post = new HttpPost("http://users.bugred.ru/tasks/rest/doregister");
        post.setEntity(new StringEntity(postParam, HttpClient.charset));

        ResponseHandler<User> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(EntityUtils.toString(entity), User.class);
                } else {
                    return null;
                }
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };

        return srv.execute(post, responseHandler);
    }

    public static ResponseBody sendPUT(CloseableHttpClient srv, String putParam) throws IOException {
        HttpPut put = new HttpPut("http://users.bugred.ru/tasks/rest/useronefield");
        put.setEntity(new StringEntity(putParam, HttpClient.charset));

        ResponseHandler<ResponseBody> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(EntityUtils.toString(entity, HttpClient.charset), ResponseBody.class);
                } else {
                    return null;
                }
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };

        return srv.execute(put, responseHandler);
    }

    public static User sendGET(CloseableHttpClient srv, String email) throws IOException {
        HttpGet request = new HttpGet("http://users.bugred.ru/tasks/rest/getuser?email=" + email);

        ResponseHandler<User> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(EntityUtils.toString(entity, HttpClient.charset), User.class);
                } else {
                    return null;
                }
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };

        return srv.execute(request, responseHandler);
    }

    public static ResponseBody sendDELETE(CloseableHttpClient srv, String email) throws IOException {
        HttpDelete request = new HttpDelete ("http://users.bugred.ru/tasks/rest/deleteuser?email=" + email);

        ResponseHandler<ResponseBody> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String respText = EntityUtils.toString(entity, HttpClient.charset);
                    Pattern pattern = Pattern.compile("\\{\\\".+\\}$");
                    String respMessage = "";

                    Matcher matcher = pattern.matcher(respText);
                    if (matcher.find()) {
                        respMessage = matcher.group(0);
                    } else System.out.println("No data from server");

                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(respMessage, ResponseBody.class);
                } else {
                    return null;
                }
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };

        return srv.execute(request, responseHandler);
    }

    public static void close(CloseableHttpClient srv) throws IOException {
        srv.close();
    }
}
