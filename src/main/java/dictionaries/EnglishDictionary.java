package dictionaries;

import interfaces.IDictionaryAPI;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class EnglishDictionary implements IDictionaryAPI {

    private static String url = "https://api.dictionaryapi.dev/api/v2/entries/en/";
    private static CloseableHttpResponse response;
    private static CloseableHttpClient instance;

    private int SendGetRequest(String url, String resource) {
        HttpGet httpGet = new HttpGet(url + resource);
        instance = HttpClientBuilder.create().build();
        try {
            response = instance.execute(httpGet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.getStatusLine().getStatusCode();
    }

    public Boolean IsWordOnDictionary(String word) {
        boolean bool = false;
        int responseCode = SendGetRequest(url, word);
        try {
            if(responseCode == 200) {
                bool = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return bool;
    }
}
