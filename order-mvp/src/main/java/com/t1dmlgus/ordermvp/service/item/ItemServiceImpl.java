package com.t1dmlgus.ordermvp.service.item;

import com.t1dmlgus.ordermvp.common.exception.BusinessException;
import com.t1dmlgus.ordermvp.common.exception.ErrorType;
import com.t1dmlgus.ordermvp.domain.item.Item;
import com.t1dmlgus.ordermvp.domain.item.ItemRepository;
import com.t1dmlgus.ordermvp.domain.member.Member;
import com.t1dmlgus.ordermvp.domain.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService{


    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    public ItemServiceImpl(ItemRepository itemRepository, MemberRepository memberRepository) {
        this.itemRepository = itemRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    @Override
    public void registerItem(ItemCommand.RegisterItemRequest itemCommand) {

        Member member = memberRepository.findById(itemCommand.getMemberId())
                .orElseThrow(()-> new BusinessException(ErrorType.USER_ENTITY_NOT_FOUND));
        Item item = itemCommand.toEntity(member);

        Item savedItem = itemRepository.save(item);
    }



}
