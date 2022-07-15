package com.t1dmlgus.ordermvp.persistence.item;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;


public class ItemDto {

    @ToString
    @Getter
    public static class RegisterItemRequest{

        @NotBlank(message = "상품명은 필수 값입니다.")
        private String itemName;

        @NotBlank(message = "상품가격은 필수 값입니다.")
        private String itemPrice;
        private Long memberId;

        private List<RegisterItemOptionGroup> itemOptionGroupList;

        public void addSessionMemberId(Long memberId) {
            this.memberId = memberId;
        }
    }

    @ToString
    @Getter
    public static class RegisterItemOptionGroup {


        private String itemOptionGroupName;
        private List<RegisterItemOption> itemOptionList;
    }

    @ToString
    @Getter
    public static class RegisterItemOption {

        private String itemOptionName;
        private String itemOptionPrice;
    }

}
