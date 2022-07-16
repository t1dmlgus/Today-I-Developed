package com.t1dmlgus.ordermvp.persistence.item;


import com.t1dmlgus.ordermvp.common.SessionConst;
import com.t1dmlgus.ordermvp.common.response.CommonResponse;
import com.t1dmlgus.ordermvp.service.item.ItemCommand;
import com.t1dmlgus.ordermvp.service.item.ItemInfo;
import com.t1dmlgus.ordermvp.service.item.ItemService;
import com.t1dmlgus.ordermvp.service.member.MemberInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;
    private final ItemDtoMapper itemDtoMapper;


    @PostMapping("/api/v1/items")
    public ResponseEntity<CommonResponse<String>> registerItem(@RequestBody ItemDto.RegisterItemRequest registerItemRequest, HttpServletRequest request) {

        Long sessionMemberId = getSessionMemberId(request);
        registerItemRequest.addSessionMemberId(sessionMemberId);
        ItemCommand.RegisterItemRequest itemCommand = itemDtoMapper.of(registerItemRequest);

        itemService.registerItem(itemCommand);

        CommonResponse<String> response = CommonResponse.of("아이템이 등록되었습니다.");
        return ResponseEntity.ok(response);
    }


    @GetMapping("/api/v1/items/{itemId}")
    public ResponseEntity<?> getItemDetails(@PathVariable Long itemId) {

        ItemInfo itemInfo = itemService.getItemDetails(itemId);

        CommonResponse<ItemInfo> response = CommonResponse.of(itemInfo, "상품을 조회하였습니다.");
        return ResponseEntity.ok(response);
    }


    private Long getSessionMemberId(HttpServletRequest request) {
        MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(SessionConst.LOGIN_MEMBER);
        return memberInfo.getId();
    }
}
