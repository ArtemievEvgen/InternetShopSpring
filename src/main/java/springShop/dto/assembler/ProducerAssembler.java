package springShop.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import springShop.controller.ProducerController;
import springShop.dto.ProducerDTO;
import springShop.entity.Producer;
@Component
public class ProducerAssembler extends RepresentationModelAssemblerSupport<Producer, ProducerDTO> {
    public ProducerAssembler() {
        super(ProducerController.class, ProducerDTO.class);
    }

    @Override
    public ProducerDTO toModel(Producer entity) {
        ProducerDTO dto = createModelWithId(entity.getId(),entity);
        return dto;
    }
}
