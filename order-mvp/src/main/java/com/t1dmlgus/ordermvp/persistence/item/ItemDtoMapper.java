package com.t1dmlgus.ordermvp.persistence.item;


import com.t1dmlgus.ordermvp.service.item.ItemCommand;
import org.mapstruct.*;

@Mapper
        (
                componentModel = "spring",
                injectionStrategy = InjectionStrategy.CONSTRUCTOR,
                unmappedTargetPolicy = ReportingPolicy.ERROR
        )
public interface ItemDtoMapper {

    //register
    @Mappings(@Mapping(source = "request.itemOptionGroupList", target = "itemOptionGroupRequestList"))
    ItemCommand.RegisterItemRequest of(ItemDto.RegisterItemRequest request);


    @Mappings({@Mapping(source = "itemOptionList", target = "itemOptionRequestList")})
    ItemCommand.RegisterItemOptionGroupRequest of(ItemDto.RegisterItemOptionGroup request);

    ItemCommand.RegisterItemOptionRequest of(ItemDto.RegisterItemOption request);
}
