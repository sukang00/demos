package org.example.utils;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/3/4 10:50
 */
public interface CommonConstant {

    /**
     * 密钥
     */
    String API_KEY = "XXXX";
    /**
     * 组织id
     */
    String ORGANIZATION ="XXX";
    /**
     * api请求url前缀
     */
    String HOST="https://api.openai.com";
    /**
     *
     */
    String MODELS="/v1/models";
    /**
     *给定一个提示，该模型将返回一个或多个预测的完成，并且还可以返回每个位置的替代标记的概率。
     */
    String COMPLETIONS="/v1/completions";
    /**
     * 给定聊天对话，模型将返回聊天完成响应。
     */

    String CHAT_COMPLETIONS="/v1/chat/completions";
    /**
     * 给定提示和指令，模型将返回提示的编辑版本。
     */
    String EDITS ="/v1/edits";
    /**
     * 根据提示创建图像。
     */
    String IMAGES_GEN="/v1/images/generations";
    /**
     * 在给定原始图像和提示的情况下创建编辑或扩展图像。
     */
    String IMAGES_EDITS="/v1/images/edits";
    /**
     * 创建给定图像的变体
     */
    String IMAGES_VARIATIONS="/v1/images/variations";
    /**
     * 创建表示输入文本的嵌入向量。
     */
    String EMBEDDINGS="/v1/embeddings";
    /**
     * 将音频转录为输入语言
     */
    String AUDIO_TRANSCRIPTIONS ="/v1/audio/transcriptions";
    /**
     * 将音频翻译成英文
     */

    String AUDIO_TRANSLATIONS="/v1/audio/translations";


}
