package org.example.client;

import com.dtflys.forest.annotation.*;
import org.example.interceptors.SimpleInterceptor;
import org.example.model.*;
import org.example.utils.CommonConstant;

import java.io.File;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/3 14:08
 */
@BaseRequest(baseURL = CommonConstant.HOST, interceptor = SimpleInterceptor.class)
public interface SimpleClient {

    @Get(CommonConstant.MODELS)
    String getModels();

    @Post(
            url = CommonConstant.COMPLETIONS,
            contentType = "application/json"
    )
    String requestCompletions(@Body CompletionsModel completionsModel);


    @Post(
            url = CommonConstant.CHAT_COMPLETIONS,
            contentType = "application/json"
    )
    String requestChatCompletions(@Body ChatCompletionsModel chatCompletionsModel);

    @Post(
            url = CommonConstant.EDITS,
            contentType = "application/json"
    )
    String requestEdits(@Body EditsModel editsModel);
    @Post(
            url = CommonConstant.IMAGES_GEN,
            contentType = "application/json"
    )
    String requestImagesGen(@Body ImagesGenModel imagesGenModel);

    /**
     * 发送File类型数据
     */
    @Post(
            url = CommonConstant.IMAGES_EDITS,
            contentType = "multipart/form-data"
    )
    String requestImagesEdits(@DataFile("image") String image,@Body("prompt") String prompt);

    @Post(
            url = CommonConstant.IMAGES_VARIATIONS,
            contentType = "multipart/form-data"
    )
    String requestImagesVariations(@DataFile("image") String image,@Body("n") Integer n,@Body("size") String size);

    @Post(
            url = CommonConstant.EMBEDDINGS,
            contentType = "application/json"
    )
    String requestEmbeddings(@Body EditsModel editsModel);


    @Post(
            url = CommonConstant.AUDIO_TRANSCRIPTIONS,
            contentType = "multipart/form-data"
    )
    String requestAudioTranscriptions(@DataFile("file") String image,@Body("model") String model);
    @Post(
            url = CommonConstant.AUDIO_TRANSLATIONS,
            contentType = "multipart/form-data"
    )
    String requestAudioTranslation(@DataFile("file") String image,@Body("model") String model);
}
