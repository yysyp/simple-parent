package com.example.news.buzz.service.impl;

import com.example.news.buzz.dao.ThreadDao;
import com.example.news.buzz.dto.NewsThreadDto;
import com.example.news.buzz.model.NewsThread;
import com.example.news.exception.CodeEnum;
import com.example.news.exception.ServerApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
public class ThreadService {

    @Autowired
    ThreadDao threadDao;

    //@Transactional
    /* Mongodb multi-document transaction requires replica-set and version 4.0+ */
    public NewsThreadDto saveNewsThread(NewsThreadDto newsThreadDto) {
        NewsThread newsThread = new NewsThread();
        BeanUtils.copyProperties(newsThreadDto, newsThread);

        String uniqueId = null;
        NewsThread savedNewsThread = null;
        int retryCountDown = 5;
        while(retryCountDown-- > 0) {
            try {
                uniqueId = UUID.randomUUID().toString();
                newsThread.setUniqueId(uniqueId);
                savedNewsThread = threadDao.save(newsThread);
                break;
            } catch (DuplicateKeyException duplicateKeyException) {
                if (retryCountDown > 0) {
                    log.info("Duplicated uniqueId, retryCountDown={}", retryCountDown);
                } else {
                    log.error("Duplicated uniqueId error, duplicatedId={}", uniqueId);
                    throw new ServerApiException(CodeEnum.DUPLICATED_KEY, true, duplicateKeyException);
                }
            }
        }

        NewsThreadDto resultDto = new NewsThreadDto();
        BeanUtils.copyProperties(savedNewsThread, resultDto);
        return resultDto;
    }

    public NewsThreadDto findNewsThreadById(Integer id) {
        NewsThread newsThread = threadDao.findNewsThreadById(id);
        NewsThreadDto newsThreadDto = new NewsThreadDto();
        BeanUtils.copyProperties(newsThread, newsThreadDto);
        return newsThreadDto;
    }

}
