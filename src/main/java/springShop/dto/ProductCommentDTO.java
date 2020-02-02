package springShop.dto;

import org.springframework.hateoas.RepresentationModel;



public class ProductCommentDTO extends RepresentationModel<ProductCommentDTO> {

    private Integer idAccount;
    private String comment;

    public ProductCommentDTO() {
    }

    public ProductCommentDTO(Integer idAccount, String comment) {
        this.idAccount = idAccount;
        this.comment = comment;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
