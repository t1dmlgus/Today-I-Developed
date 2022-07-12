package com.t1dmlgus.ordermvp.service.item;

import com.t1dmlgus.ordermvp.domain.item.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemServiceImplTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;


    @DisplayName("아이템 등록 테스트")
    @Test
    void registerItem() {

        // given


        /**
         *
         * 1. item 1 - N itemOtpion 인 경우
         * 모든 옵션이 리스트 형태로, 바인딩되어
         * -> 원하는 결과 : 색상, 사이즈
         * -> 잘못된 결과 : 색상, 색상
         * -> 잘못된 결과 : 사이즈, 사이즈
         * 그 외, 여러 잘못된 결과가 도출될 수 있음
         *
         *
         * 2. item 1 - N itemOptionGroup 1 - N itemOption
         *
         * - json 형태로 데이터를 받으면, item 은 그대로 바인딩
         * - 어차피 물품은 색상과 사이즈 둘다 필요 -> 미리 생성해도 나쁘지 않을 거 같음
         * - 넘어오는 json 데이터를 토대로 new itemOption 생성
         *
         */

        //then
    }

    @DisplayName("아이템 등록 실패 테스트 >> 예외처리")
    @Test
    void registerItemFail() {

        // given


        //then
    }
}