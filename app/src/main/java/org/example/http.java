package org.example;

import java.net.URL;
import java.net.*;
import java.io.*;
import org.json.JSONObject;

class http {
  public class response {
    public String text;
    public String code;
    public String mess;

    public String toString() {
      String res = new String();
      res += code + "/" + mess + ": \"" + text + "\"";
      return res;
    }
  }

  public http(String url) throws Exception {
    conn = (HttpURLConnection)(new URL(url)).openConnection();
  }

  public http method(String m) throws Exception  { 
    conn.setRequestMethod(m);
    return this;
  }

  public http prop(String k, String v) {
    conn.setRequestProperty(k, v);
    return this;
  }

  public response get() throws Exception {
    conn.setRequestMethod("GET");
    return response();
  }

  public response delete() throws Exception {
    conn.setRequestMethod("DELETE");
    return response();
  }

  public response post(String m) throws Exception {
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    OutputStream os = conn.getOutputStream();
    OutputStreamWriter ow = new OutputStreamWriter(os);
    ow.write(m);
    ow.flush();
    ow.close();
    os.close();
    conn.connect();

    return response();
  }

  public response post(JSONObject obj) throws Exception {
    return post(obj.toString());
  }

  private response response() throws Exception {
    response res = new response();

    res.code = "" + conn.getResponseCode();
    res.mess = conn.getResponseMessage();

    try {
      BufferedReader reader = 
      new BufferedReader(new InputStreamReader(conn.getInputStream()));
      res.text = new String();
      String line;
      while ((line = reader.readLine()) != null) {
        res.text += line;
        res.text += "\n";
      }
    } catch (Exception e) {}

    return res;
  }

  private HttpURLConnection conn;
}