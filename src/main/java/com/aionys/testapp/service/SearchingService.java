package com.aionys.testapp.service;

import com.aionys.testapp.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Service
public class SearchingService {

    private final SearchRepository searchRepository;

    @Autowired
    public SearchingService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public String getDto(Long id) throws IOException {

        URL url = new URL("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
        /* create a new URL and open a connection */
        URLConnection con = url.openConnection();
        con.setDoOutput(true);

        /* wrapper the output stream of the connection with PrintWiter so that we can write plain text to the stream */
        PrintWriter wr = new PrintWriter(con.getOutputStream(), true);

        /* set up the parameters into a string and send it via the output stream */
        StringBuilder parameters = new StringBuilder();
        parameters.append("account.firstName=" + URLEncoder.encode("test", "UTF-8"));
        parameters.append("&");
        parameters.append("account.lastName=" + URLEncoder.encode("test", "UTF-8"));
        wr.println(parameters);
        wr.close();

        /* wrapper the input stream of the connection with BufferedReader to read plain text, and print the response to the console */
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while((line = br.readLine()) != null) System.out.println(line);
        br.close();

        return "OK";
//        return searchRepository.getById(id).toString();
    }


}
