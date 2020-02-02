package springShop.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import springShop.controller.OrderItemController;
import springShop.dto.OrderItemDTO;
import springShop.entity.OrderItem;

@Component
public class OrderItemAssembler extends RepresentationModelAssemblerSupport<OrderItem,OrderItemDTO> {
    public OrderItemAssembler(){super(OrderItemController.class,OrderItemDTO.class);}


    @Override
    public OrderItemDTO toModel(OrderItem entity) {
        OrderItemDTO dto = createModelWithId(entity.getId(),entity);
        return dto;
    }
}
