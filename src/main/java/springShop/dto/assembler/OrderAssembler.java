package springShop.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import springShop.controller.OrderController;
import springShop.dto.OrderDTO;
import springShop.entity.Order;

@Component
public class OrderAssembler extends RepresentationModelAssemblerSupport<Order, OrderDTO> {

    public OrderAssembler() {
        super(OrderController.class, OrderDTO.class);
    }

    @Override
    public OrderDTO toModel(Order entity){
        OrderDTO dto = createModelWithId(entity.getId(),entity);
        return dto;
    }

}
