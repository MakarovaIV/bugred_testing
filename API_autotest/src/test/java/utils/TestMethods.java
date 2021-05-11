package utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMethods {
    public static boolean testPOSTValidUsr(String postParam, String email, String name) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //Send POST
        HttpClient.sendPOST(httpClient, postParam);

        //Send GET
        User usrFromGet = HttpClient.sendGET(httpClient, email);
        return email.equals(usrFromGet.getEmail())&&name.equals(usrFromGet.getName());
    }

    public static boolean testPUTValidValue(String putParam, String email, String name) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //Send PUT
        HttpClient.sendPUT(httpClient, putParam);

        //Send GET (check PUT)
        User usrFromGet = HttpClient.sendGET(httpClient, email);
        return name.equals(usrFromGet.getName());
    }

    public static boolean testDELValidUser(String email) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //Send DELETE
        ResponseBody usrFromDel = HttpClient.sendDELETE(httpClient, email);

        Pattern pattern = Pattern.compile("успеш.");
        Matcher matcher = pattern.matcher(usrFromDel.getMessage());
        return matcher.find();
    }

    public static boolean testPOSTInvalidUsr(String postParam, String type) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //Send POST
        User usrForInvalidPost = HttpClient.sendPOST(httpClient, postParam);

        return type.equals(usrForInvalidPost.getErType());
    }

    public static boolean testGETInvalidUsr(String email, String type) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //Send POST
        User usrFromInvalidGet = HttpClient.sendGET(httpClient, email);
        return type.equals(usrFromInvalidGet.getErType());
    }

    public static boolean testPUTInvalidValue(String putParam) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //Send DELETE
        ResponseBody usrForInvalidPut = HttpClient.sendPUT(httpClient, putParam);

        Pattern pattern = Pattern.compile("успеш.");
        Matcher matcher = pattern.matcher(usrForInvalidPut.getMessage());
        return matcher.find();
    }
}
