package org.example;

import io.github.ollama4j.*;
import io.github.ollama4j.models.chat.*;

public class llm {
    public llm(String model_name) throws Exception {
        String[] cmd = { "ollama", "serve" };
        ollama_proc = Runtime.getRuntime().exec(cmd);
        api = new OllamaAPI();
        model = model_name;
    }

    public String ask(String prompt) throws Exception {

        OllamaChatRequestBuilder builder =
        OllamaChatRequestBuilder.getInstance(model);
        
        OllamaChatRequest req_model =
        builder.withMessage(OllamaChatMessageRole.USER, prompt).build();

        api.setRequestTimeoutSeconds(60 * 5);
        OllamaChatResult res = api.chat(req_model);
        String answer = res.getResponseModel().getMessage().getContent();

        return answer;
    }

    public void reset() throws Exception {
        close();
        String[] cmd = { "ollama", "serve" };
        ollama_proc = Runtime.getRuntime().exec(cmd);
    }

    public void close() throws Exception {
        ollama_proc.destroy();
    }

    private Process ollama_proc;
    private String model;
    private OllamaAPI api;
}