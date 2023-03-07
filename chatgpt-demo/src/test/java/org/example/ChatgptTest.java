package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.client.SimpleClient;
import org.example.model.*;
import org.example.utils.CommonConstant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/4 11:10
 */
@SpringBootTest
@Slf4j
public class ChatgptTest {

    @Resource
    private SimpleClient simpleClient;
    @Test
    public void getModelsTest(){
        String models = simpleClient.getModels();
        log.info(models);

    }

    @Test
    public void requestCompletions(){
        CompletionsModel model = new CompletionsModel();
        model.setModel("text-davinci-003");
        model.setPrompt("Say this is a test");
        model.setMax_tokens(7);
        model.setTemperature(0);
        String models = simpleClient.requestCompletions(model);
        log.info(models);
    }

    @Test
    public void requestChatCompletions(){
        ChatCompletionsModel model = new ChatCompletionsModel();
        model.setModel("gpt-3.5-turbo");
        List<ChatCompletionsModel.Item> list = new ArrayList<>();
        list.add(new ChatCompletionsModel.Item("user","Hello!"));
        model.setMessages(list);
        String result = simpleClient.requestChatCompletions(model);
        log.info(result);
    }

    /**
     * {
     *   "model": "text-davinci-edit-001",
     *   "input": "What day of the wek is it?",
     *   "instruction": "Fix the spelling mistakes",
     * }
     */
    @Test
    public void requestEdits(){
        EditsModel editsModel = new EditsModel();
        editsModel.setModel("text-davinci-edit-001");
        editsModel.setInput("What day of the wek is it?");
        editsModel.setInstruction("Fix the spelling mistakes");
        String result = simpleClient.requestEdits(editsModel);
        log.info(result);
    }
    @Test
    public void requestImagesGen(){
        ImagesGenModel imagesGenModel = new ImagesGenModel();
        imagesGenModel.setPrompt("农民给羊挤奶");
        imagesGenModel.setN(2);
        imagesGenModel.setSize("1024x1024");
        String result = simpleClient.requestImagesGen(imagesGenModel);
        log.info(result);
    }

    @Test
    public void requestImagesEdits(){
        String result = simpleClient.requestImagesEdits("D:\\test\\test1.png","A cute baby sea otter wearing a beret");
        log.info(result);
    }

    @Test
    public void requestImagesVariations(){
        String result = simpleClient.requestImagesVariations("D:\\test\\test1.png",2,"1024x1024");
        log.info(result);
    }
    @Test
    public void requestEmbeddings(){
        EditsModel editsModel = new EditsModel();
        editsModel.setModel("text-embedding-ada-002");
        editsModel.setInput("The food was delicious and the waiter...");
        String result = simpleClient.requestEmbeddings(editsModel);
        log.info(result);
    }

    @Test
    public void requestAudioTranscriptions(){
        String result = simpleClient.requestAudioTranscriptions("D:\\test\\痴心绝对.mp3","whisper-1");
        log.info(result);
    }
    @Test
    public void requestAudioTranslation(){
        String result = simpleClient.requestAudioTranslation("D:\\test\\痴心绝对.mp3","whisper-1");
        log.info(result);
    }
}
