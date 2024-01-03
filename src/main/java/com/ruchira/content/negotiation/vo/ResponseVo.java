package com.ruchira.content.negotiation.vo;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@XmlRootElement()
@XmlType()
@Data
public class ResponseVo {

    private Long id;
    private String payload;
    private String error;
    private LocalDateTime localDateTime;

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }


}
